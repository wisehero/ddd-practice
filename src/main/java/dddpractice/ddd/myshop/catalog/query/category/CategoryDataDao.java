package dddpractice.ddd.myshop.catalog.query.category;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import dddpractice.ddd.myshop.catalog.command.domain.category.CategoryId;

public interface CategoryDataDao extends Repository<CategoryData, CategoryId> {
	Optional<CategoryData> findById(CategoryId id);

	List<CategoryData> findAll();
}
