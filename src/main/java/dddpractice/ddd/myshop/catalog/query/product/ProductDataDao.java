package dddpractice.ddd.myshop.catalog.query.product;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import dddpractice.ddd.myshop.catalog.command.domain.category.CategoryId;
import dddpractice.ddd.myshop.catalog.command.domain.product.ProductId;

public interface ProductDataDao extends Repository<ProductData, ProductId> {
	Optional<ProductData> findById(ProductId id);

	Page<ProductData> findByCategoryIdsContains(CategoryId id, Pageable pageable);
}
