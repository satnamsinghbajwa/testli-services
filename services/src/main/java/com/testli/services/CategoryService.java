package com.testli.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testli.aop.Loggable;
import com.testli.data.model.Category;
import com.testli.data.repo.CategoryRepository;

@Service
@Loggable
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category addCategory(Category category) {
		return categoryRepository.insert(category);
	}

	public Category addChildCategory(String id, String childId) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			List<String> childsIds = category.getChildrenIds();
			if (childId == null) {
				childsIds = new ArrayList<>();
			}
			childsIds.add(childId);
			return categoryRepository.save(category);
		}
		return null;
	}

	public Category deleteChildCategory(String id, String childId) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			List<String> childsIds = category.getChildrenIds();
			if (childId != null) {
				childsIds.remove(childId);
			}
			return categoryRepository.save(category);
		}
		return null;
	}

	public Category updateParent(String id, String parentId) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			category.setParentId(parentId);
			return categoryRepository.save(category);
		}
		return null;
	}

	public Category updateCategory(String id, Category category) {
		category.setId(id);
		return categoryRepository.save(category);
	}

	public List<Category> getCategory(String ids) {
		List<Category> categories = new ArrayList<>();
		if (ids != null) {
			List<String> items = Stream.of(ids.split("\\s*,\\s*")).map(element -> new String(element))
					.collect(Collectors.toList());
			Iterable<Category> findAllById = categoryRepository.findAllById(items);
			for (Category category : findAllById) {
				categories.add(category);
			}
		}
		return categories;
	}

	public void deleteCategory(String id) {
		categoryRepository.deleteById(id);
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	public Category deleteParent(String id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			category.setParentId(null);
			return categoryRepository.save(category);
		}
		return null;
	}

}
