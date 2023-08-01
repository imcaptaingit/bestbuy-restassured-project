package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

    //21. Extract the limit
    @Test
    public void test021() {
        int limit = response.extract().path("limit");
        System.out.println("The Value of limit is " + limit);
    }

    //22. Extract the total
    @Test
    public void test022() {
        int total = response.extract().path("total");
        System.out.println("The Total Product is " + total);
    }

    //23. Extract the name of 5th product

    @Test
    public void test023() {
        String name = response.extract().path("data[4].name");
        System.out.println("The Total Product is " + name);
    }

    //24. Extract the names of all the products
    @Test
    public void test024() {
        List<String> name = response.extract().path("data.name");
        System.out.println("Name of All Product is " + name);
    }

    //25. Extract the productId of all the products
    @Test
    public void test025() {
        List<Integer> productId = response.extract().path("data.id");
        System.out.println("Id of All Product is " + productId);
    }

    //26. Print the size of the data list

    @Test
    public void test026() {
        List<Integer> productId = response.extract().path("data");
        int num = productId.size();
        System.out.println("Size of the Product is " + num);

    }

    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)

    @Test
    public void test027() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)' }");
        System.out.println("The values for product name 'Energizer - MAX Batteries AA (4-Pack)' are: " + values);
    }

    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test028() {
        List<Double> model = response.extract().path("data.findAll{it.name=='Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("The model of product name 'Energizer - N Cell E90 Batteries (2-Pack)' is : " + model);
    }
    //29. Get all the categories of 8th products

    @Test
    public void test029() {
        List<HashMap<String, ?>> products = response.extract().path("data[7].categories");
        System.out.println("All the Categories for product 8" + products);
    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void test030() {
        List<HashMap<String, ?>> categories = response.extract().path("data.findAll{it.id == 150115}.categories");
        System.out.println("The categories of product id 150115: " + categories);
    }

    //31. Get all the descriptions of all the products

    @Test
    public void test031() {
        List<String> descriptions = response.extract().path("data.description");
        System.out.println("Description of All Product is " + descriptions);
    }

    //32. Get id of all the all categories of all the products

    @Test
    public void test032() {
        List<HashMap<String, ?>> allIdOfCategories = response.extract().path("data.categories.id");
        System.out.println("Id of All Product is " + allIdOfCategories);
    }
    //33. Find the product names Where type = HardGood

    @Test
    public void test033() {
        List<String> productName = response.extract().path("data.findAll{it.type='HardGood'}.name");
        System.out.println("Name of All Product where type  is HardGood " + productName);
    }

    //34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)

    @Test
    public void test034() {
        List<HashMap<String, ?>> productId = response.extract().path("data.findAll{it.name=='Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");


        int num = productId.size();
        System.out.println("Size of the Product is " + num);

    }

    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test035() {
        List<String> createdAt = response.extract().path("data.findAll{it.price<5.49}.createdAt");
        System.out.println("Get Created At all product < 5.49 " + createdAt);
    }


    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”

    @Test
    public void test036() {
        List<HashMap<String, ?>> productName = response.extract().path("data.findAll{it.name=='Energizer - MAX Batteries AA (4-Pack)'}.categories.name");
        System.out.println("name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack) is" + productName);
    }
    //37. Find the manufacturer of all the products

    @Test
    public void test037() {
        List<String> product = response.extract().path("data.manufacturer");
        System.out.println("manufacturer of all the products" + product);
    }

    //38. Find the image of products whose manufacturer is = Energizer
    @Test
    public void test038() {

        List<String> image = response.extract().path("data.findAll{it.manufacturer=='Energizer'}.image");
        System.out.println("Energizer of all the image is" + image);
    }

    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test039() {
        List<String> createdAt = response.extract().path("data.findAll{it.price>5.99}.categories.createdAt");
        System.out.println("Get Created At all product > 5.99" + createdAt);

    }

    //40. Find the uri of all the products
    @Test
    public void test040() {
        List<String> url = response.extract().path("data.url");
        System.out.println("Get the ALL url for Products" + url);

    }

}
