package com.testli.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testli.aop.Loggable;
import com.testli.data.model.Category;
import com.testli.services.CategoryService;

@RestController
@Loggable
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/categories", method = POST, headers = { "Accept=application/json" })
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	@RequestMapping(value = "/categories/{id}", method = PUT, headers = { "Accept=application/json" })
	public Category updateCategory(@PathVariable("id") String id, @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}

	@RequestMapping(value = "/categories/{id}/parent/{parentId}", method = PUT, headers = { "Accept=application/json" })
	public Category updateParent(@PathVariable("id") String id, @PathVariable("childId") String parentId) {
		return categoryService.updateParent(id, parentId);
	}

	@RequestMapping(value = "/categories/{id}/childs/{childId}", method = POST, headers = { "Accept=application/json" })
	public Category addChildCategory(@PathVariable("id") String id, @PathVariable("childId") String childId) {
		return categoryService.addChildCategory(id, childId);
	}

	@RequestMapping(value = "/categories/{id}", method = GET, headers = { "Accept=application/json" })
	public List<Category> getCategory(@PathVariable("id") String id) {
		return categoryService.getCategory(id);
	}

	@RequestMapping(value = "/categories/{id}", method = DELETE, headers = { "Accept=application/json" })
	public void deleteCategory(@PathVariable("id") String id) {
		categoryService.deleteCategory(id);
	}

	@RequestMapping(value = "/categories/{id}/childs/{childId}", method = DELETE, headers = {
			"Accept=application/json" })
	public Category deleteChildCategory(@PathVariable("id") String id, @PathVariable("childId") String childId) {
		return categoryService.deleteChildCategory(id, childId);
	}

	@RequestMapping(value = "/categories/{id}/parent", method = DELETE, headers = { "Accept=application/json" })
	public Category deleteParent(@PathVariable("id") String id) {
		return categoryService.deleteParent(id);
	}

	@RequestMapping(value = "/categories", method = GET, headers = { "Accept=application/json" })
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

}
