package dddpractice.ddd.myshop.order.command.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import dddpractice.ddd.myshop.member.command.domain.MemberId;

@Embeddable
public class Orderer {

	@AttributeOverrides(
		@AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
	)
	private MemberId memberId;

	@Column(name = "orderer_name")
	private String name;

	protected Orderer() {

	}

	public Orderer(MemberId memberId, String name) {
		this.memberId = memberId;
		this.name = name;
	}

	public MemberId getMemberId() {
		return memberId;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Orderer))
			return false;

		Orderer orderer = (Orderer)o;

		if (getMemberId() != null ? !getMemberId().equals(orderer.getMemberId()) : orderer.getMemberId() != null)
			return false;
		return getName() != null ? getName().equals(orderer.getName()) : orderer.getName() == null;
	}

	@Override
	public int hashCode() {
		int result = getMemberId() != null ? getMemberId().hashCode() : 0;
		result = 31 * result + (getName() != null ? getName().hashCode() : 0);
		return result;
	}
}
