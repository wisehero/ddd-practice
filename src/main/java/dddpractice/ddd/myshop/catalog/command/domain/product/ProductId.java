package dddpractice.ddd.myshop.catalog.command.domain.product;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class ProductId implements Serializable {

    @Column(name = "product_id")
    private String id;

    protected ProductId() {
    }

    public ProductId(String id) {
        this.id = id;
    }

    public static ProductId of(String id) {
        return new ProductId(id);
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductId)) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(getId(), productId.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}