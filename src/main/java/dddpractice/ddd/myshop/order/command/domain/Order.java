package dddpractice.ddd.myshop.order.command.domain;

import dddpractice.ddd.myshop.common.event.Events;
import dddpractice.ddd.myshop.common.jpa.MoneyConverter;
import dddpractice.ddd.myshop.common.model.Money;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchase_order")
@Access(AccessType.FIELD)
public class Order {

    @EmbeddedId
    private OrderNo number;

    @Version
    private long version;

    @Embedded
    private Orderer orderer;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "order_line", joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;

    @Convert(converter = MoneyConverter.class)
    @Column(name = "total_amounts")
    private Money totalAmounts;

    @Embedded
    private ShippingInfo shippingInfo;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    protected Order() {

    }

    public Order(OrderNo number, Orderer orderer, List<OrderLine> orderLines,
                 ShippingInfo shippingInfo, OrderState state) {
        setNumber(number);
        setOrderer(orderer);
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
        this.state = state;
        this.orderDate = LocalDateTime.now();
        Events.raise(new OrderPlacedEvent(number.getNumber(), orderer, orderLines, orderDate));
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmount() {
        this.totalAmounts = new Money(orderLines.stream()
                .mapToInt(x -> x.getAmounts().getValue()).sum());
    }

    public void cancel() {
        verifyNotYetShipped();
    }

    private void verifyNotYetShipped() {
        if (!isNotYetShipped()) {
            throw new AlreadyShippedException();
        }
    }

    private boolean isNotYetShipped() {
        return state == OrderState.PAYMENT_WAITING || state == OrderState.PREPARING;
    }

    public boolean matchVersion(long version) {
        return this.version == version;
    }

    public void startShipping() {
        verifyShippableState();
        this.state = OrderState.SHIPPED;
        Events.raise(new ShippingStratedEvent(number.getNumber()));
    }

    private void verifyShippableState() {
        verifyNotYetShipped();
        verifyNotCanceled();
    }

    private void verifyNotCanceled() {
        if (state == OrderState.CANCELED) {
            throw new OrderAlreadyCancelException();
        }
    }

    public OrderNo getNumber() {
        return number;
    }

    private void setNumber(OrderNo number) {
        if (number == null) {
            throw new IllegalArgumentException("no number");
        }
        this.number = number;
    }

    public long getVersion() {
        return version;
    }

    public Orderer getOrderer() {
        return orderer;
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null) {
            throw new IllegalArgumentException("no orderer");
        }
        this.orderer = orderer;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmount();
    }

    public Money getTotalAmounts() {
        return totalAmounts;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no shipping info");
        }
        this.shippingInfo = shippingInfo;
    }

    public OrderState getState() {
        return state;
    }
}