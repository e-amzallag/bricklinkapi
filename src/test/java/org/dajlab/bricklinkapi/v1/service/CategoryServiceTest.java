package org.dajlab.bricklinkapi.v1.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ResourceBundle;

import org.dajlab.bricklinkapi.v1.service.impl.CategoryServiceImpl;
import org.dajlab.bricklinkapi.v1.vo.CategoriesList;
import org.dajlab.bricklinkapi.v1.vo.Category;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CategoryServiceTest {

	private static ICategoryService service;

	@BeforeAll
	public static void before() {
		ResourceBundle rb = ResourceBundle.getBundle("parameters");
		service = new CategoryServiceImpl(rb.getString("consumerKey"), rb.getString("consumerSecret"),
				rb.getString("tokenValue"), rb.getString("tokenSecret"));

	}

	@Test
	public void testGetCategoryList() {

		try {
			CategoriesList list = service.getCategoryList();
			assertNotNull(list);
			System.out.println("Number of categories = " + list.size());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetCategory() {

		try {
			Category cat = service.getCategory(5);
			System.out.println("Name of the category 5 = " + cat.getCategoryName());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
