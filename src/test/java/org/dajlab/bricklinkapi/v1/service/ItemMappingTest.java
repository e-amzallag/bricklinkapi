package org.dajlab.bricklinkapi.v1.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ResourceBundle;

import org.dajlab.bricklinkapi.v1.service.impl.ItemMappingServiceImpl;
import org.dajlab.bricklinkapi.v1.vo.ItemMappingList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ItemMappingTest {

	private static IItemMappingService service;

	@BeforeAll
	public static void before() {
		ResourceBundle rb = ResourceBundle.getBundle("parameters");
		service = new ItemMappingServiceImpl(rb.getString("consumerKey"), rb.getString("consumerSecret"),
				rb.getString("tokenValue"), rb.getString("tokenSecret"));

	}

	@Test
	public void testGetElementId() {
		try {
			ItemMappingList itemsMapping = service.getElementId("3001");
			if (itemsMapping != null) {
				System.out.println("Number of elements for 3001 : " + itemsMapping.size());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());

		}
	}

	@Test
	public void testGetItemNumber() {
		try {
			ItemMappingList itemsMapping = service.getItemNumber("6284676");
			if (itemsMapping != null && itemsMapping.size() > 0) {
				System.out.println("Item = " + itemsMapping.get(0).getElementId() + " - Design = "
						+ itemsMapping.get(0).getItem().getNo() + " - Color = " + itemsMapping.get(0).getColorId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());

		}
	}
}
