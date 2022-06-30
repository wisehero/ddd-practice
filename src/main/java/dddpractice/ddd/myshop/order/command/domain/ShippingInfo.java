package dddpractice.ddd.myshop.order.command.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;

import dddpractice.ddd.myshop.common.model.Address;

@Embeddable
public class ShippingInfo {
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name = "zipCode", column = @Column(name = "shipping_zip_code")),
		@AttributeOverride(name = "address1", column = @Column(name = "shipping_addr1")),
		@AttributeOverride(name = "address2", column = @Column(name = "shipping_addr2"))
	})
	@Embedded
	private Address address;
	@Column(name = "shipping_message")
	private String message;
	@Embedded
	private Receiver receiver;

	public ShippingInfo() {

	}

	public ShippingInfo(Address address, String message, Receiver receiver) {
		this.address = address;
		this.message = message;
		this.receiver = receiver;
	}

	public Address getAddress() {
		return address;
	}

	public String getMessage() {
		return message;
	}

	public Receiver getReceiver() {
		return receiver;
	}
}
