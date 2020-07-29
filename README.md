# Java Bricklink API

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.dajlab/bricklinkapi/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.dajlab/bricklinkapi)

Java API for Bricklink API.

See http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki for more information about the official Bricklink API

## Implemented methods
| Methods category | Implemented   |
| :------------ | :-------------: |
| Order       |  No   |
| User Inventory       |  No   |
| Catalog Item       |  **Yes**   |
| Feedback       |  No   |
| Color       |  **Yes**   |
| Category       |  **Yes**   |
| Push Notification       |  No   |
| Coupon       |  No   |
| Setting       |  No   |
| Member       |  No   |
| Item Mapping       |  **Yes**   |


## Examples


```java
IBricklinkService service = new BricklinkServiceImpl("consumerKey", "consumerSecret", "tokenValue", "tokenSecret");
Item item = service.getCatalogItem().getItem(Type.PART, "3001");

PriceGuideParametersRequest param = new PriceGuideParametersRequest();
param.setColorId(9);
param.setNewOrUsed(NewOrUsed.NEW);
param.setGuideType(GuideType.STOCK);
PriceGuide price = service.getCatalogItem().getPrice(Type.PART, "3003", param);


```

Check ICatalogItemService, ICategoryService, IColorService, IItemMappingService to see the full list of methods.

## Unit tests

To run the tests, you need to create a parameters.properties in test resources with the following properties :

    consumerKey=
    consumerSecret=
    tokenValue=
    tokenSecret=
    
