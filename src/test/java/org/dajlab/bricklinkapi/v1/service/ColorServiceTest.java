package org.dajlab.bricklinkapi.v1.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ResourceBundle;

import org.dajlab.bricklinkapi.v1.service.impl.ColorServiceImpl;
import org.dajlab.bricklinkapi.v1.vo.Color;
import org.dajlab.bricklinkapi.v1.vo.ColorsList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ColorServiceTest {

	private static IColorService service;

	@BeforeAll
	public static void before() {
		ResourceBundle rb = ResourceBundle.getBundle("parameters");
		service = new ColorServiceImpl(rb.getString("consumerKey"), rb.getString("consumerSecret"),
				rb.getString("tokenValue"), rb.getString("tokenSecret"));

	}

	@Test
	public void testGetCategoryList() {

		try {
			ColorsList list = service.getColorList();
			System.out.println("Number of colors = " + list.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetCategory() {

		try {
			Color color = service.getColor(5);
			System.out.println("Name of the color 5 = " + color.getColorName());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
