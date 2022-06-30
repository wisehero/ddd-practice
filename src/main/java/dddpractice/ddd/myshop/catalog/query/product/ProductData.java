package dddpractice.ddd.myshop.catalog.query.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import dddpractice.ddd.myshop.catalog.command.domain.category.CategoryId;
import dddpractice.ddd.myshop.catalog.command.domain.product.Image;
import dddpractice.ddd.myshop.catalog.command.domain.product.ProductId;
import dddpractice.ddd.myshop.common.jpa.MoneyConverter;
import dddpractice.ddd.myshop.common.model.Money;

@Entity
@Table(name = "product")
public class ProductData {

	@EmbeddedId
	private ProductId id;

	@ElementCollection
	@CollectionTable(name = "product_category",
		joinColumns = @JoinColumn(name = "product_id"))
	private Set<CategoryId> categoryIds;

	private String name;

	@Convert(converter = MoneyConverter.class)
	private Money price;

	private String detail;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
		orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	@OrderColumn(name = "list_idx")
	private List<Image> images = new ArrayList<>();

	protected ProductData() {

	}

	public ProductData(ProductId id, String name, Money price, String detail, List<Image> images) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.detail = detail;
		this.images.addAll(images);
	}

	public ProductId getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Money getPrice() {
		return price;
	}

	public String getDetail() {
		return detail;
	}

	public List<Image> getImages() {
		return Collections.unmodifiableList(images);
	}

	public String getFirstIamgeThumbnailPath() {
		if (images == null || images.isEmpty())
			return null;
		return images.get(0).getThumbnailUrl();
	}
}
