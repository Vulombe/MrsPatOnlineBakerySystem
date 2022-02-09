-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: mrspatbakerydb
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `addressId` int NOT NULL AUTO_INCREMENT,
  `houseNumber` int NOT NULL DEFAULT '0',
  `street` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `state` varchar(100) NOT NULL,
  `code` varchar(50) NOT NULL DEFAULT '0',
  `custEmail` varchar(100) NOT NULL,
  `isValid` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`addressId`),
  KEY `FK1 user and address` (`custEmail`),
  CONSTRAINT `FK1 user and address` FOREIGN KEY (`custEmail`) REFERENCES `user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,8888,'Tsakani Street','pretoria','Jozi','0101','marys@gmail.com','N'),(5,322,'15th Road','pta','jhb','1685','ksylverster@gmail.com','Y'),(6,4554,'Omri','Brooklyn','Pretoria','0121','dave.makhubele@gmail.com','Y');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartlineitems`
--

DROP TABLE IF EXISTS `cartlineitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartlineitems` (
  `cartLineItemsId` int NOT NULL AUTO_INCREMENT,
  `productId` int NOT NULL DEFAULT '0',
  `qty` int NOT NULL DEFAULT '0',
  `orderId` int NOT NULL,
  `isActive` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`cartLineItemsId`),
  KEY `FK1 product and cartlineItem` (`productId`),
  KEY `FK2order  and cart` (`orderId`),
  CONSTRAINT `FK1 product and cartlineItem` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`),
  CONSTRAINT `FK2order  and cart` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartlineitems`
--

LOCK TABLES `cartlineitems` WRITE;
/*!40000 ALTER TABLE `cartlineitems` DISABLE KEYS */;
INSERT INTO `cartlineitems` VALUES (1,7,1,1,'Y'),(2,6,1,1,'Y'),(3,31,2,1,'Y'),(4,6,5,2,'Y'),(5,2,4,2,'Y'),(6,32,12,3,'Y'),(7,40,1,4,'Y'),(8,39,1,4,'Y'),(9,40,1,5,'Y'),(10,39,1,5,'Y'),(11,17,1,6,'Y'),(12,9,1,6,'Y'),(13,1,1,6,'Y'),(14,11,1,6,'Y'),(15,6,1,7,'Y'),(16,10,1,7,'Y'),(17,11,1,7,'Y'),(18,7,1,7,'Y'),(19,6,1,8,'Y'),(20,10,1,8,'Y'),(21,11,1,8,'Y'),(22,7,1,8,'Y'),(23,12,1,9,'Y'),(24,4,1,9,'Y'),(25,5,1,9,'Y'),(26,4,1,10,'Y'),(27,3,1,10,'Y'),(28,12,1,10,'Y'),(29,6,1,11,'Y'),(30,12,1,11,'Y'),(31,40,1,12,'Y'),(32,39,1,12,'Y'),(33,40,1,13,'Y'),(34,39,1,13,'Y'),(35,12,1,14,'Y'),(36,5,1,14,'Y'),(37,4,1,14,'Y'),(38,36,2,15,'Y'),(39,24,1,15,'Y'),(40,14,1,15,'Y'),(41,22,1,15,'Y'),(42,32,1,15,'Y'),(43,35,3,15,'Y'),(44,33,1,15,'Y'),(45,19,1,16,'Y'),(46,18,1,16,'Y'),(47,31,1,17,'Y'),(48,29,1,17,'Y'),(49,30,1,17,'Y'),(50,40,1,18,'Y'),(51,39,1,18,'Y'),(52,40,1,19,'Y'),(53,39,1,19,'Y'),(54,40,1,20,'Y'),(55,39,1,20,'Y'),(56,12,1,21,'Y'),(57,5,1,21,'Y'),(58,40,2,21,'Y'),(59,12,1,22,'Y'),(60,5,1,22,'Y'),(61,40,2,22,'Y'),(62,31,1,23,'Y'),(63,30,1,23,'Y'),(64,31,1,24,'Y'),(65,30,1,24,'Y'),(66,31,1,25,'Y'),(67,30,1,25,'Y');
/*!40000 ALTER TABLE `cartlineitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient` (
  `ingredientId` int NOT NULL AUTO_INCREMENT,
  `ingredientName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nutrient` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `isActive` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`ingredientId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (1,'Milk','energy','Y'),(2,'sugar','false teeth','Y'),(3,'Rama','good for you','Y'),(4,'flour','whole grain','Y'),(5,'mango custard','calaries','Y');
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientitem`
--

DROP TABLE IF EXISTS `ingredientitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredientitem` (
  `ingredientItemId` int NOT NULL AUTO_INCREMENT,
  `ingredientId` int NOT NULL DEFAULT '0',
  `qty` int NOT NULL DEFAULT '0',
  `ingredientName` varchar(50) NOT NULL DEFAULT '0',
  `isActive` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`ingredientItemId`),
  KEY `FK1 ingredient and ingredientLineItem` (`ingredientId`),
  CONSTRAINT `FK1 ingredient and ingredientLineItem` FOREIGN KEY (`ingredientId`) REFERENCES `ingredient` (`ingredientId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientitem`
--

LOCK TABLES `ingredientitem` WRITE;
/*!40000 ALTER TABLE `ingredientitem` DISABLE KEYS */;
INSERT INTO `ingredientitem` VALUES (1,1,5,'milk','Y'),(2,2,3,'sugar','Y');
/*!40000 ALTER TABLE `ingredientitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredientstock`
--

DROP TABLE IF EXISTS `ingredientstock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredientstock` (
  `ingredientStockId` int NOT NULL,
  `qty` int NOT NULL,
  `ingredientItemId` int NOT NULL,
  PRIMARY KEY (`ingredientStockId`),
  KEY `FK1 ingredientItem and IngredientStock` (`ingredientItemId`) USING BTREE,
  CONSTRAINT `FK1 ingredientItem and IngredientStock` FOREIGN KEY (`ingredientItemId`) REFERENCES `ingredientitem` (`ingredientId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredientstock`
--

LOCK TABLES `ingredientstock` WRITE;
/*!40000 ALTER TABLE `ingredientstock` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingredientstock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orderId` int NOT NULL AUTO_INCREMENT,
  `userEmail` varchar(50) NOT NULL,
  `addressId` int NOT NULL DEFAULT '0',
  `totalPrice` double NOT NULL DEFAULT '0',
  `orderDate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `isActive` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`orderId`),
  KEY `FK1USER AND ORDER` (`userEmail`),
  KEY `FK2 ADDRESS AND USER AND ORDER` (`addressId`),
  CONSTRAINT `FK1USER AND ORDER` FOREIGN KEY (`userEmail`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK2 ADDRESS AND USER AND ORDER` FOREIGN KEY (`addressId`) REFERENCES `address` (`addressId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'marys@gmail.com',1,12,'2022-02-04','Y'),(2,'marys@gmail.com',1,199.5,'2022-02-04','Y'),(3,'marys@gmail.com',1,160.4,'2022-02-07','Y'),(4,'ksylverster@gmail.com',5,64.95,'2022-02-09','Y'),(5,'ksylverster@gmail.com',5,64.95,'2022-02-09','Y'),(6,'dave.makhubele@gmail.com',6,144.3,'2022-02-09','Y'),(7,'dave.makhubele@gmail.com',6,130.5,'2022-02-09','Y'),(8,'dave.makhubele@gmail.com',6,130.5,'2022-02-09','Y'),(9,'ksylverster@gmail.com',5,130.5,'2022-02-09','Y'),(10,'ksylverster@gmail.com',5,147.75,'2022-02-09','Y'),(11,'ksylverster@gmail.com',5,90.25,'2022-02-09','Y'),(12,'ksylverster@gmail.com',5,64.95,'2022-02-09','Y'),(13,'ksylverster@gmail.com',5,64.95,'2022-02-09','Y'),(14,'ksylverster@gmail.com',5,130.5,'2022-02-09','Y'),(15,'dave.makhubele@gmail.com',6,162.7,'2022-02-09','Y'),(16,'ksylverster@gmail.com',5,75.3,'2022-02-09','Y'),(17,'ksylverster@gmail.com',5,74.15,'2022-02-09','Y'),(18,'ksylverster@gmail.com',5,64.95,'2022-02-09','Y'),(19,'ksylverster@gmail.com',5,64.95,'2022-02-09','Y'),(20,'ksylverster@gmail.com',5,64.95,'2022-02-09','Y'),(21,'ksylverster@gmail.com',5,113.25,'2022-02-09','Y'),(22,'ksylverster@gmail.com',5,113.25,'2022-02-09','Y'),(23,'ksylverster@gmail.com',5,66.1,'2022-02-09','Y'),(24,'ksylverster@gmail.com',5,66.1,'2022-02-09','Y'),(25,'ksylverster@gmail.com',5,66.1,'2022-02-09','Y');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `productId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `picture` varchar(900) NOT NULL DEFAULT '',
  `price` double NOT NULL DEFAULT '0',
  `Category` varchar(50) NOT NULL,
  `warning` varchar(900) NOT NULL DEFAULT '0',
  `description` varchar(900) NOT NULL,
  `recipeId` int NOT NULL DEFAULT '0',
  `isActive` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`productId`),
  KEY `FK_Product_And_recipe` (`recipeId`),
  CONSTRAINT `FK1 productAndRecipe` FOREIGN KEY (`recipeId`) REFERENCES `recipe` (`recipeId`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='STORING PRODUCTS';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Carrot Cake','https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/carrot-cake-1574437118.jpg?crop=1xw:1xh;center,top&resize=980:*',15,'cakes','no warning','Leavened with baking soda and baking powder, this shortened cake uses oil as its main fat rather than butter. The addition of grated carrots makes the cake extra moist. Carrot cake is also flavored with warm spices and frosted with a rich cream cheese frosting. Pecans or walnuts are optional!',83,'N'),(2,'Devil’s Food Cake','https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/devils-food-cake-1577124539.jpg?crop=1.00xw:0.911xh;0,0.0658xh&resize=980:*',20,'cakes','contains chocolate','This cake is made \"devilish\" by the addition of chocolate in the form of cocoa powder. Extra baking soda causes the crumb to have more air bubbles, giving it a light and airy texture. This rich cake is frosted with either chocolate frosting or buttercream.',83,'Y'),(3,'Chocolate C. Cookies','https://www.tasteofhome.com/wp-content/uploads/2018/05/exps191702_THCSS153652B02_17_19b-1.jpg?resize=700,700',35,'cookies','contains nuts','Every editorial product is independently selected, though we may be compensated or receive an affiliate commission if you buy something through our links. Ratings and prices are accurate and items are in stock as of time of publication.',83,'Y'),(4,'Shortbread Cookies','https://www.tasteofhome.com/wp-content/uploads/2018/01/Scottish-Shortbread_EXPS_DIYD20_1889_B09_17_3b-2.jpg?resize=696,696',25,'cookies','contains flour','Scottish settlers first came to this area over 150 years ago. My mother herself was Scottish, and—as with most of my favorite recipes—she passed this shortbread recipe on to me. I make a triple batch of it each year at Christmas, to enjoy and as gifts',83,'Y'),(5,'Monster Cookies','https://www.tasteofhome.com/wp-content/uploads/2018/01/Monster-Cookies_EXPS_TOHON19_9150_E06_18_8b-7.jpg?resize=700,700',20,'cookies','contains sweets','his recipe combines several favorite flavors—peanut butter, butterscotch and chocolate—in one big cookie. Before baking, I like to press a few extra M&M’s on top for added color.',83,'Y'),(6,'Pound Cake','https://assets.epicurious.com/photos/57c6f789082060f11022b586/6:4/w_1600,c_limit/no-recipe-required-pound-cake-lemon-poppy-seed-30082016.jpg',10,'cakes','contains  egss','Pound cake is a relative of butter cake. It\'s so called because it can be measured as a matter of proportion: a pound of butter, a pound of sugar, a pound of eggs, and a pound of flour. In some pound cake recipes, you\'ll see the eggs separated and the egg whites whipped and folded into the batter, to leaven it; in other recipes you\'ll find leaveners like baking soda and baking powder, bringing it well into the butter-cake fold. These cakes are usually very lightly flavored and served plain or topped with a simple glaze or water icing. A pound cake is usually baked in a loaf or Bundt pan. Many coffee cakes, sour cream cakes, and fruit crumb cakes are variations of pound cake.',83,'Y'),(7,'Sponge Cake','https://assets.epicurious.com/photos/56f301595380ea2215f3b49c/6:4/w_1600,c_limit/1015-FS-CAKE01.jpg',15,'cakes','contains  eggs',' recipe that contains no baking soda or baking powder but lots of whipped eggs or egg whites? That\'s a sponge cake and there are several different types of sponge cake. which will be called different things wherever you are.',83,'Y'),(8,'Genoise Cake','https://assets.epicurious.com/photos/5af339265e455d485852fba6/6:4/w_1600,c_limit/EP_06012016_strawberry_shortcake_hero-slices.jpg',25,'cakes','contains  eggs and sugar',', a sponge cake is called genoise; in genoise, whole eggs are beaten with sugar until they\'re thick and ribbony, and then flour (and sometimes butter) is added and the batter is baked; the result is wonderful baked in a round cake pan and simply frosted, but genoise is also pliable enough to be baked in a jelly-roll pan and rolled up into a roulade.',83,'Y'),(9,'Biscuit Cake','https://assets.epicurious.com/photos/5af31a94fddd026b70f8c8e7/6:4/w_1600,c_limit/french-biscuit-cake-050918.jpg',30,'cakes','contains  eggs and sugar','Biscuit (always pronounced the French way as bees-kwee) cakes are another type of sponge cake containing both egg whites and yolks, but, unlike genoise, the whites and yolks are whipped separately and then folded back together. This creates a light batter that\'s drier than a genoise but holds its shape better after mixing. For this reason, it\'s often used for piped shapes such as ladyfingers',83,'Y'),(10,'Chiffon Cake','https://assets.epicurious.com/photos/5af4550baf6ece1dfcaf1a83/6:4/w_1600,c_limit/persian-love-cake-051018.jpg',15,'cakes','contains  nuts','This fairly recent American creation was invented by a salesman who sold the recipe to General Mills, which spread the recipe through marketing materials in the 1940s and 1950s. A classic chiffon cake is kind of a cross between an oil cake and a sponge cake. It includes baking powder and vegetable oil, but the eggs are separated and the whites are beaten to soft peaks before being folded into the batter. This creates a cake with a tender crumb and rich flavor like an oil cake, but with a lighter texture that\'s more like a sponge cake. Chiffon cakes can be baked in tube pans like angel food cakes or layered with fillings and frostings.',83,'Y'),(11,'Red Velvet Cake','https://assets.epicurious.com/photos/56bcc39c2388d8216df80735/6:4/w_1600,c_limit/shutterstock_365627156.jpg',30,'cakes','contains  oil','Red velvet cake is essentially a butter cake, though it is frequently made with oil instead of butter. In addition, cocoa is added to the cake batter to create the distinct red velvet flavor â originally it was a reaction between buttermilk and the raw cocoa widely available at the time of red velvet\'s inception that caused a ruddy-hued crumb',83,'Y'),(12,'Peanut Butter Cookies','https://www.tasteofhome.com/wp-content/uploads/2018/01/Peanut-Butter-Blossom-Cookies_EXPS_THN17_166861_D06_21_5b-2.jpg?resize=700,700',25,'cookies','contains  nuts','Hereâs proof that peanut butter and chocolate just belong together. These peanut butter drop cookies are an easy family favorite and never fail to make my children smile',83,'Y'),(13,'Crinkle Cookies','https://www.tasteofhome.com/wp-content/uploads/2018/01/Crinkle-Top-Chocolate-Cookies_EXPS_THN17_16297_D06_21_10b-4.jpg?resize=696,696',30,'cookies','contains  crinkles','When I baked this moist, fudgy chocolate crinkle cookie recipe for the first time, my three preschool children went wild over them! But I like them because theyâre lower in fat and easy to mix and bake. ',83,'Y'),(14,'Oatmeal R. Cookies','https://www.tasteofhome.com/wp-content/uploads/2018/01/exps4768_CC144384C05_22_5b-4.jpg?resize=696,696',20,'cookies','contains  raisins','packed chocolate chips, raisins, nuts and cinnamon into this drop cookie recipe. These soft oatmeal cookies are easy to make',83,'Y'),(15,'Cookie Bars','https://www.tasteofhome.com/wp-content/uploads/2018/01/Chocolate-Chip-Cookie-Bars_EXPS_FT21_4960_F_0107_1-7.jpg?resize=700,700',15,'cookies','contains  milk','chocolate chip cookie bars are often requested at church dinners. Theyâre tasty and easy to serve',83,'Y'),(16,'Apple Pie','https://img.grouponcdn.com/seocms/2i7116adj14eoCiYBx8SQLUzXZrq/671x671_Apple_Pie_BUYING_GUIDE_DIFFERENT_TYPES_OF_PIE_012319_ak_jpg-671x671',10,'pies','contains Apples, sugar, and cinnamon','often served with vanilla ice cream on the side; as the Great American Pie, itâs sometimes grouped with baseball and hot dogs as a purely American symbol (though the English and the Dutch have been making pies with apples for centuries).',83,'Y'),(17,'Key Lime Pie','https://img.grouponcdn.com/seocms/MAEqSGQhwmuZ7RsUXWdKF49prF9/671x671_Key_Lime_Pie_BUYING_GUIDE_DIFFERENT_TYPES_OF_PIE_012319_ak_jpg-671x671',7,'pies','contains Lime juice ','Lime juice (specifically one from a Key lime), meringue topping, and graham-cracker crust; naturally, the pie is heavily associate with the Florida Keys',83,'Y'),(18,'Cherry Pie','https://img.grouponcdn.com/seocms/3K8rjwNK22DKVDZ3u4w7jHiGQpxJ/671x671_Cherry_Pie_BUYING_GUIDE_DIFFERENT_TYPES_OF_PIE_012319_ak_jpg-671x671',10,'pies','contains Cherries','namely Montmorency cherries, which are tarter and more sour than your usual Bing cherry; a favorite during the 4th of July; namesake of the 1990 chart-topping hit from glam-rockers Warrant',83,'Y'),(19,'Sugar Cream Pie','https://img.grouponcdn.com/seocms/4UjJMhDwFBf9NzG3ubfXoxs8PKne/671x671_Sugar_Cream_Pie_BUYING_GUIDE_DIFFERENT_TYPES_OF_PIE_012319_ak_jpg-671x671',12,'pies','contains rown sugar, butter, and cream','a simple treat, but one of the most addictive types of pies; popular in French and Quebecois cuisines, as well as the Midwest USA, where it is also called âHoosier Pieâ due to its association with Indiana.',83,'Y'),(20,'Strawberry Pie','https://img.grouponcdn.com/seocms/pdRmvrk1DKLgKZK1p8kDrDNVZ4R/671x671_Strawberry_Pie_BUYING_GUIDE_DIFFERENT_TYPES_OF_PIE_012319_ak_V2_jpg-671x671',7,'pies','contains Strawberries','Lots and lots and lots of strawberries (ideally fresh strawberries), often mixed with a strawberry gelatin. We recommend some whipped cream on top to cut some of the sweetness.',83,'Y'),(21,'French Silk Pie','https://img.grouponcdn.com/seocms/W7UMCtWuaC48JXawXhMTeY4rxgJ/671x671_French_Silk_Pie_BUYING_GUIDE_DIFFERENT_TYPES_OF_PIE_012319_ak_jpg-671x671',13,'pies','contains chocolate','chocolate mousse, whipped cream, and bittersweet chocolate shavings; favorite pie of children at family reunions everywhere; despite its name, French Silk is a purely American invention, the winner of a 1951 Pillsbury competition.',83,'Y'),(22,'French Loaves','https://www.tasteofhome.com/wp-content/uploads/2018/01/French-Loaves_EXPS_WRSM17_47135_B03_28_1b-2.jpg?resize=696,696',14,'fresh_bread','contains flour','feshfrench loaves',83,'Y'),(23,'Pumpkin Bread','https://www.tasteofhome.com/wp-content/uploads/2018/01/exps1196_TH163622D04_19_2b-3.jpg?resize=700,700',15,'fresh_bread','contains pumpkin','fresh pimpkin bread',83,'Y'),(24,'Basic Home.M Bread','https://www.tasteofhome.com/wp-content/uploads/2018/01/Basic-Homemade-Bread_EXPS_TOHcom20_32480_C01_26_2b-30.jpg?resize=700,700',10,'fresh_bread','This easy white bread recipe bakes up deliciously golden brown. Thereâs nothing like the homemade aroma wafting through my kitchen as it bakes','fresh homemade bread',83,'Y'),(25,'Banana Bread','https://www.tasteofhome.com/wp-content/uploads/2018/01/Best-Ever-Banana-Bread_EXPS_TOHDJ20_3309_E07_31_7b-44.jpg?resize=700,700',17,'fresh_bread','contains banana','fresh banana bread',83,'Y'),(26,'Buttery Cornbread','https://www.tasteofhome.com/wp-content/uploads/2018/01/Buttery-Corn-Bread_EXPS_GHBZ18_14600_E08_09_2b-2-176.jpg?resize=700,700',20,'fresh_bread','contains butter','fresh cornbread',83,'Y'),(27,'Pear Bread','https://www.tasteofhome.com/wp-content/uploads/2018/01/Fresh-Pear-Bread_EXPS_UGFBMZ17_10945_C04_28_3b-7.jpg?resize=696,696',16,'fresh_bread','contains pears','fresh pear bread',83,'Y'),(28,'Cherry C. Cupcake','https://crazylittleprojects.com/wp-content/uploads/2014/02/Cherry-Coke-Cupcakes-2.jpg',5,'cupcakes','contains cherry','fresh cherry coke cupcake',83,'Y'),(29,'V.Pumpkin cupcake','https://crazylittleprojects.com/wp-content/uploads/2015/09/vanillapumpkinspicecupcakes-686x1024.jpg',7,'cupcakes','contains vanilla and pumpkin','fresh vanilla pimpkin cupcake',83,'Y'),(30,'Nutella Swirl','https://crazylittleprojects.com/wp-content/uploads/2015/05/NutellaSwirlCupcakes.jpg',6,'cupcakes','contains Nutella','fresh Nutella swirl cupcake',83,'Y'),(31,'Salted C. Cupcakes','https://crazylittleprojects.com/wp-content/uploads/2014/02/Saltedcaramelcupcakesrecipe.png',8,'cupcakes','contains caramel','fresh salted caramel cupcakes',83,'Y'),(32,'Samoas Cupcakes:','https://crazylittleprojects.com/wp-content/uploads/2014/02/samoas-cupcakes-3title.jpg',8,'cupcakes','contains nuts','fresh Samoas  cupcakes',83,'Y'),(33,'Alexandertorte','https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Aleksanterinleivos.jpg/120px-Aleksanterinleivos.jpg',10,'pastries','contains nuts','Pastry strips filled with berries',83,'Y'),(34,'Apple strudel','https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Strudel.jpg/120px-Strudel.jpg',8,'pastries','contains apple','Sliced apples and other fruit are wrapped and cooked in layers of filo pastry. The earliest known recipe is in Vienna, but several countries in central and eastern Europe claim this dish',83,'Y'),(35,'Banitsa','https://upload.wikimedia.org/wikipedia/commons/thumb/7/7a/Banitsa_borzo.jpg/120px-Banitsa_borzo.jpg',8,'pastries','contains eggs','Prepared by layering a mixture of whisked eggs and pieces of cheese between filo pastry, which is then baked in an oven',83,'Y'),(36,'Banket','https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Almond-patties.jpg/120px-Almond-patties.jpg',6,'pastries','contains dough','opular during the Christmas season, prepared by rolling pastry dough around an almond paste filling and then baking it. The log is then cut into short lengths for serving, hot or cold.',83,'Y'),(37,'Bakeshop Brownie','https://blog.ediblearrangements.com/wp-content/uploads/2020/10/Bakeshop-Brownie-min-300x300.jpg',10,'brownies','contains chocolate','A twist on a classic favorite, this rich, fudgy brownie holds a hidden surprise. Its center is filled with gourmet semisweet chocolate chips. Plus, itâs topped with a white chocolate glaze.\n\n',83,'Y'),(38,'Walnut Brownies','https://blog.ediblearrangements.com/wp-content/uploads/2020/10/Fudge-Walnut-Brownies-min-200x300.jpg',7,'brownies','contains nuts','Made just like a regular brownie and jam-packed with walnuts, a brownie with nuts is one of the most classic types of brownies.',83,'Y'),(39,'Iced Brownies','https://blog.ediblearrangements.com/wp-content/uploads/2020/10/Fudge-Iced-Brownies-min-200x300.jpg',8,'brownies','contains chocolate','Whatâs better than a fudgy brownie, you say? One thatâs covered in rich, creamy, chocolate icing. This type of brownie elevates the sweetness level to new heights.',83,'Y'),(40,' Blondies','https://blog.ediblearrangements.com/wp-content/uploads/2020/10/Blondies-min-205x300.jpg',5,'brownies','contains nuts','Blondies arenât about adding in additional ingredients to a classic brownie; instead, they actually omit one.',83,'Y'),(41,' Peanut.B Brownies','https://blog.ediblearrangements.com/wp-content/uploads/2020/10/Peanut-Butter-Brownies-min-200x300.jpg',5,'brownies','contains nuts','Like a peanut butter cup in brownie form, peanut butter brownies make the most out of the chocolate and peanut butter combo. Some recipes require you to swirl the peanut butter into the batter, while others add it in after the brownies have baked.',83,'Y'),(43,'Nutella Brownies','https://blog.ediblearrangements.com/wp-content/uploads/2020/10/Nutella-Brownies-min-200x300.jpg',5,'brownies','contains nutella','This type of brownie ups the ante with hazelnut spread mixed right into the batter and swirled on top. These brownies have an incredibly concentrated and sweet chocolate hazelnut flavor that makes them completely unique.',83,'Y'),(44,'Espresso Brownies','https://blog.ediblearrangements.com/wp-content/uploads/2020/10/Espresso-Brownies-min-200x300.jpg',5,'brownies','contains  espresso','A dose of espresso deepens the chocolate flavor in your brownies. Plus, it gives you a bit of a pick-me-up when you need it most. Espresso brownies combine chocolate and coffee to effortlessly create a brownie with a rich, deep chocolate flavor thatâs simply divine.',83,'Y'),(48,'carrot cake','https://www.wilton.com/dw/image/v2/AAWA_PRD/on/demandware.static/-/Sites-wilton-project-master/default/dw0b1332bb/images/project/WLRECIP-8718/pretty-carrot-cake.jpg?sw=800&sh=800',20,'cakes','contains nuts','yummy',83,'N'),(49,'carrot cake','https://www.wilton.com/dw/image/v2/AAWA_PRD/on/demandware.static/-/Sites-wilton-project-master/default/dw0b1332bb/images/project/WLRECIP-8718/pretty-carrot-cake.jpg?sw=800&sh=800',20,'cupcakes','contains nuts','yummy',83,'Y');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productlineitems`
--

DROP TABLE IF EXISTS `productlineitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productlineitems` (
  `lineItemId` int NOT NULL AUTO_INCREMENT,
  `productId` int NOT NULL,
  `qty` int NOT NULL DEFAULT '1',
  `isActive` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`lineItemId`),
  KEY `FK1 product and productline` (`productId`),
  CONSTRAINT `FK1 product and productline` FOREIGN KEY (`productId`) REFERENCES `product` (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productlineitems`
--

LOCK TABLES `productlineitems` WRITE;
/*!40000 ALTER TABLE `productlineitems` DISABLE KEYS */;
INSERT INTO `productlineitems` VALUES (1,1,1,'Y'),(2,2,1,'Y'),(3,3,1,'Y'),(4,4,1,'Y'),(5,5,1,'Y'),(6,6,1,'Y'),(7,7,1,'Y'),(8,8,1,'Y'),(9,9,1,'Y'),(10,10,1,'Y'),(11,11,1,'Y'),(12,12,1,'Y'),(13,13,1,'Y'),(14,14,1,'Y'),(15,15,1,'Y'),(16,16,1,'Y'),(17,17,1,'Y'),(18,18,1,'Y'),(19,19,1,'Y'),(20,20,1,'Y'),(21,21,1,'Y'),(22,22,1,'Y'),(23,23,1,'Y'),(24,24,1,'Y'),(25,25,1,'Y'),(26,26,1,'Y'),(27,27,1,'Y'),(28,28,1,'Y'),(29,29,1,'Y'),(30,30,1,'Y'),(31,31,1,'Y'),(32,32,1,'Y'),(33,33,1,'Y'),(34,34,1,'Y'),(35,35,1,'Y'),(36,36,1,'Y'),(37,37,1,'Y'),(38,38,1,'Y'),(39,39,1,'Y'),(40,40,1,'Y'),(41,41,1,'Y'),(43,43,1,'Y'),(44,44,1,'Y');
/*!40000 ALTER TABLE `productlineitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productstock`
--

DROP TABLE IF EXISTS `productstock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productstock` (
  `stockId` int NOT NULL AUTO_INCREMENT,
  `qty` int DEFAULT '0',
  `productId` int DEFAULT '0',
  PRIMARY KEY (`stockId`),
  KEY `FK1stock and product lineitem` (`productId`),
  CONSTRAINT `FK1stock and product lineitem` FOREIGN KEY (`productId`) REFERENCES `productlineitem` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productstock`
--

LOCK TABLES `productstock` WRITE;
/*!40000 ALTER TABLE `productstock` DISABLE KEYS */;
/*!40000 ALTER TABLE `productstock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `recipeId` int NOT NULL,
  `recipeName` varchar(50) NOT NULL DEFAULT '',
  `ingredients` varchar(900) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `Steps` varchar(900) NOT NULL DEFAULT '',
  `isActive` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`recipeId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='storing product recipe';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (83,'sweet','1,2','Blah Blah Blah','Y');
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipelineitem`
--

DROP TABLE IF EXISTS `recipelineitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipelineitem` (
  `recipeLineItemId` int NOT NULL AUTO_INCREMENT,
  `ingridientName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `qty` int NOT NULL,
  PRIMARY KEY (`recipeLineItemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipelineitem`
--

LOCK TABLES `recipelineitem` WRITE;
/*!40000 ALTER TABLE `recipelineitem` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipelineitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `stockId` int NOT NULL AUTO_INCREMENT,
  `productId` int NOT NULL DEFAULT '0',
  `productName` varchar(50) NOT NULL DEFAULT '0',
  `Category` varchar(50) NOT NULL DEFAULT '0',
  `qty` int NOT NULL DEFAULT '0',
  `isActive` enum('Y','N') NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`stockId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `firstName` varchar(100) NOT NULL DEFAULT '',
  `lastName` varchar(100) NOT NULL DEFAULT '',
  `email` varchar(100) NOT NULL DEFAULT '',
  `contactNumber` varchar(100) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL DEFAULT '',
  `isClient` enum('Y','N') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Y',
  `isActive` enum('Y','N') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Storing all the users';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Mr','Sylverster','TheMan','ksylverster@gmail.com','0712345678','kanyane','N','Y'),(5,'Ms','Mary','Hairy','maryh@gmail.com','07123456780','eieio','Y','Y'),(6,'Ms','Mary','Scary','marys@gmail.com','07123459876','lamb','Y','Y'),(7,'title','Mary','Scary','maryscary@gmail.com','0111111111111','lamb','Y','Y'),(8,'mr','Manqoba','Manqoba','kkkkkk@gmail.com','07123456789','123456','Y','Y'),(9,'Ms','caroline','Mngomezulu','carolinemngomezulu@gmail.com','0742801301','carocaro','Y','Y'),(11,'Mr','Dave','Makhubele','dave.makhubele@gmail.com','0761449829','dave.dave','Y','Y'),(12,'Mr','Onthatile','modise','goodlubisi@gmail.com','0123456789','mize','Y','Y'),(13,'Mr','Omri','Cassiem','masterwrong@gmail.com','0727818219','1likechee$e','Y','Y'),(14,'Mr','Beef','Stew','stew@gmail.com','0123456789','12','Y','Y'),(15,'Mrs','susan','de wet','susandevet1@gmail.com','0823344424','123456','Y','Y');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-09 15:46:29
