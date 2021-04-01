package test.services;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import com.entites.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.services.CollectionService;

@TestMethodOrder(OrderAnnotation.class)
public class ServiceTest {

    private CollectionService collectionService = CollectionService.getInstance();
    
    @Test
    @Order(1)
    public void insertNewCollection() {
        Collection expected = new Collection();
        expected.setName("Style");
        expected = collectionService.insertCollection(expected);
        Collection collection = collectionService.findCollection(expected.getName());
        assertEquals(expected,collection);
    }

    @Test
    @Order(2)
    public void insertNewSubCollection() {
        Collection expectedCollection = new Collection();
        expectedCollection.setName("Style");
        expectedCollection = collectionService.insertCollection(expectedCollection);
        Collection collection = collectionService.findCollection(expectedCollection.getName());
        assertEquals(expectedCollection,collection);
        SubCollection expectedSubCollection = new SubCollection();
        expectedSubCollection.setName("Clothes");
        expectedSubCollection = collectionService.insertSubCollection(expectedCollection, expectedSubCollection);
        SubCollection subCollection = collectionService.findSubCollection(expectedSubCollection.getName());
        assertEquals(expectedSubCollection,subCollection);
    }
    
    @Test
    @Order(3)
    public void insertNewTshirt() {
    	SubCollection subCollection = collectionService.findSubCollection("Clothes");
    	TShirt expected = new TShirt();
    	expected.setColor("Black");
    	expected.setDescription("Only a TShirt");
    	expected.setGender('M');
    	expected.setIsLong(true);
    	expected.setName("Adidas TShirt");
    	expected.setPrice(BigDecimal.valueOf(40));
    	expected.setSize(Size.X);
    	expected.setQuantity(10);
    	expected.setSubCollection(subCollection);
    	expected = (TShirt) collectionService.insert(subCollection, expected);
    	TShirt actual = (TShirt) collectionService.findProductInSubCollection(subCollection.getName(), expected.getName());
    	assertEquals(expected, actual);
    }

    @Test
    @Order(4)
    public void insertNewSneakers() {
        SubCollection subCollection = collectionService.findSubCollection("Clothes");
        Sneakers expected = new Sneakers();
        expected.setColor("Blue");
        expected.setDescription("Only a Sneaker");
        expected.setGender('M');
        expected.setName("Nike Sneaker");
        expected.setPrice(BigDecimal.valueOf(150));
        expected.setSize(41);
        expected.setQuantity(10);
        expected.setSubCollection(subCollection);
        expected.setActivity("Soccer");
        expected = (Sneakers) collectionService.insert(subCollection, expected);
        Sneakers actual = (Sneakers) collectionService.findProductInSubCollection(subCollection.getName(), expected.getName());
        assertEquals(expected, actual);
    }

    @Test
    @Order(5)
    public void insertNewPants() {
        SubCollection subCollection = collectionService.findSubCollection("Clothes");
        Pants expected = new Pants();
        expected.setColor("Red");
        expected.setDescription("Only a Pants");
        expected.setGender('F');
        expected.setName("Puma Jeans Pants");
        expected.setPrice(BigDecimal.valueOf(80));
        expected.setSize(Size.XS);
        expected.setQuantity(5);
        expected.setSubCollection(subCollection);
        expected.setActivity("Party");
        expected.setMaterial("Jeans");

        // Adding an image
        Image image = new Image();
        image.setExtension("jpg");
        image.setName("puma-pants");
        image.setSize(Long.valueOf(100));
        image.setPath("images/puma-pants.jpg");
        expected.setImage(image);

        expected = (Pants) collectionService.insert(subCollection, expected);
        Pants actual = (Pants) collectionService.findProductInSubCollection(subCollection.getName(), expected.getName());
        assertEquals(expected, actual);
    }

    @Test
    @Order(6)
    public void searchProduct() {
        Pants pants = (Pants) collectionService.findProductInSubCollection("Clothes","Puma Jeans Pants");
        System.out.println(pants);
        assertNotNull(pants);
    }
}
