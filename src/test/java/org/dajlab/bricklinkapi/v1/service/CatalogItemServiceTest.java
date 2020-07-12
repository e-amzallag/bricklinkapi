package org.dajlab.bricklinkapi.v1.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.dajlab.bricklinkapi.v1.enumeration.Type;
import org.dajlab.bricklinkapi.v1.service.impl.CatalogItemServiceImpl;
import org.dajlab.bricklinkapi.v1.vo.Item;
import org.dajlab.bricklinkapi.v1.vo.KnownColorsList;
import org.dajlab.bricklinkapi.v1.vo.PriceGuide;
import org.dajlab.bricklinkapi.v1.vo.PriceGuideParametersRequest;
import org.dajlab.bricklinkapi.v1.vo.SubsetEntriesList;
import org.dajlab.bricklinkapi.v1.vo.SubsetParametersRequest;
import org.dajlab.bricklinkapi.v1.vo.SupersetEntriesList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CatalogItemServiceTest {

	private static ICatalogItemService service;

	@BeforeAll
	public static void before() {
		ResourceBundle rb = ResourceBundle.getBundle("parameters");
		service = new CatalogItemServiceImpl(rb.getString("consumerKey"), rb.getString("consumerSecret"),
				rb.getString("tokenValue"), rb.getString("tokenSecret"));

	}

	@Test
	public void testGetItem() {

		try {
			Item item = service.getItem(Type.PART, "3001");
			assertNotNull(item);
			assertEquals("Brick 2 x 4", item.getName());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetItemImage() {
		try {

//		Item item = service.getItemImage(Type.PART, "3001", 1);
//		System.out.println("URL of image for 3001 : " + item.getImageUrl());
//		System.out.println("URL of thumbnail for 3001 : " + item.getThumbnailUrl());

			Item item2 = service.getItemImage(Type.SET, "10264-1", 0);
			System.out.println("URL of image for 10264-1 : " + item2.getImageUrl());
			System.out.println("URL of thumbnail for 10264-1 : " + item2.getThumbnailUrl());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetSupersets() {
		try {

			SupersetEntriesList entries = service.getSupersets(Type.PART, "3001");
			System.out.println("Number of supersets for 3001 = " + entries.size());

			entries = service.getSupersets(Type.PART, "3001", 1);
			System.out.println("Number of supersets for 3001 with color 1 = " + entries.size());

			entries = service.getSupersets(Type.SET, "7324-2");
			System.out.println("Number of supersets for 7324-2 = " + entries.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetSubsets() {
		try {

			SubsetEntriesList entries = service.getSubsets(Type.SET, "7324-1");
			System.out.println("Number of subsets for 7324-1 = " + entries.size());

			SubsetParametersRequest params = new SubsetParametersRequest();
			params.setBreakSubsets(Boolean.TRUE);
			entries = service.getSubsets(Type.SET, "7324-1");
			System.out.println("Number of subsets for 7324-1 with break subsets= " + entries.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGetPriceGuide() {
		try {
			PriceGuide price = null;
			price = service.getPrice(Type.PART, "3001");
			System.out.println("Avg price for 3001 : " + price.getAvgPrice());

			PriceGuideParametersRequest param = new PriceGuideParametersRequest();
			param.setColorId(11);
			price = service.getPrice(Type.PART, "3001", param);
			System.out.println("Avg price for 3001 in color 11 : " + price.getAvgPrice());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	@Test
	public void testGetPriceGuide2() {
		try {

			PriceGuide price = null;

			Map<String, Integer> parts = new HashMap<>();
			parts.put("3003", 9);
			parts.put("3003", 1);
			parts.put("10884", 110);
			parts.put("973pr4919c01", 59);
			parts.put("41879a", 105);
			parts.put("11833", 34);
			for (String part : parts.keySet()) {
				PriceGuideParametersRequest param = new PriceGuideParametersRequest();
				param.setColorId(parts.get(part));
				price = service.getPrice(Type.PART, part, param);
				if (price != null) {
					System.out.println(
							"Avg price for " + part + " in color " + parts.get(part) + " : " + price.getAvgPrice());
				} else {
					System.out.println("Part " + part + " not found");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	@Test
	public void testGetKnownColor() {
		try {

			KnownColorsList colors = service.getKnownColors(Type.PART, "3001");
			System.out.println("Number of colors for 3001 : " + colors.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}

	}

	@Test
	public void testGetSet() {
		try {

			Item item = service.getItem(Type.SET, "10263-1");
			System.out.println("Name of 21316-1 : " + item.getName());
			System.out.println("Year of release of 21316-1 : " + item.getYearReleased());
			System.out.println("Image url 21316-1 : " + item.getImageUrl());
			System.out.println("Thumbnail url 21316-1 : " + item.getThumbnailUrl());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
