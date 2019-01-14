package com.testli.services;

import java.util.ArrayList;
import java.util.List;
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

}
