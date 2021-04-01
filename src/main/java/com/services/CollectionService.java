package com.services;

import com.entites.Collection;
import com.entites.Pants;
import com.entites.Product;
import com.entites.Sneakers;
import com.entites.SubCollection;
import com.entites.TShirt;
import com.exception.ProductNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class is responsable to manage collections and sub-collections
 */
public class CollectionService {

    private static CollectionService Instance;

    private Set<Collection> collections = new HashSet<>();
    private Long id = Long.valueOf(1);
    private Long productId = Long.valueOf(1);

    public Product insert(SubCollection subCollection,Sneakers product) {
        subCollection = findSubCollection(subCollection.getName());
        if (subCollection != null && (product.isValid() && product.isValidTwo())) {
            product.setId(productId);
            subCollection.getProducts().add(product);
            return product;
        }
        return null;
    }

    public Product insert(SubCollection subCollection,TShirt product) {
        subCollection = findSubCollection(subCollection.getName());
        if (subCollection != null && (product.isValid() && product.isValidTwo())) {
            product.setId(productId);
            productId++;
            subCollection.getProducts().add(product);
            return product;
        }
        return null;
    }

    public Product insert(SubCollection subCollection,Pants product) {
    	subCollection = findSubCollection(subCollection.getName());
        if (subCollection != null && (product.isValid() && product.isValidTwo())) {
            product.setId(productId);
            subCollection.getProducts().add(product);
            return product;
        }
        return null;
    }

    public Collection insertCollection(Collection collection) {
        if (collection != null && collection.isValid()) {
            Optional<Collection> optional = collections
                    .stream()
                    .filter(c -> c.getName().toLowerCase().equals(collection.getName().toLowerCase()))
                    .findFirst();
            if (optional.isPresent()) {
                return optional.get();
            }

            collection.setId(id);
            collections.add(collection);
            id++;
            return collection;
        }
        return null;
    }

    public SubCollection insertSubCollection(Collection collection, SubCollection subCollection) {
        if (collection != null && (subCollection != null && subCollection.isValid())) {
            Optional<SubCollection> optional = collection.getSubCollections()
                    .stream()
                    .filter(c -> c.getName().toLowerCase().equals(collection.getName().toLowerCase()))
                    .findFirst();
            if (optional.isPresent()) {
                return optional.get();
            }

            int id = collection.getSubCollectionId() + 1;
            collection.setSubCollectionId(id);
            subCollection.setId(Long.valueOf(id));
            collection.getSubCollections().add(subCollection);
            return subCollection;
        }
        return null;
    }

    public Set<Collection> listCollections() {
        return collections;
    }

    public Product findProductInSubCollection(String subCollectionName, String productName) {
        if (!collections.isEmpty()) {
            SubCollection subCollection = findSubCollection(subCollectionName);

            Product product = subCollection
                    .getProducts()
                    .stream()
                    .filter(p -> p.getName().toLowerCase().contains(productName.toLowerCase()))
                    .findFirst().get();

            return product;
        }
        return null;
    }

    public Set<Product> listAllProductsInACollection(String collectionName) {
        Collection collection = findCollection(collectionName);
        Set<Product> list = new HashSet<>();
        for (SubCollection sc : collection.getSubCollections()) {
            for (Product p : sc.getProducts()) {
                list.add(p);
            }
        }

        return list;
    }

    public Set<Product> listAllProductsInASubCollection(String subCollectionName) {
        SubCollection subCollection = findSubCollection(subCollectionName);

        return subCollection.getProducts();
    }

    public Collection findCollection(String name) {
        return collections.stream()
                .filter(c -> c.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst().get();
    }

    public SubCollection findSubCollection(String subCollectionName) {
        return collections.stream().map(c -> {
            SubCollection sbc = null;
            for (SubCollection sc : c.getSubCollections()) {
                if (sc.getName().toLowerCase().equals(subCollectionName.toLowerCase())) {
                    sbc = sc;
                }
            }
            return sbc;
        }).findFirst().get();
    }

    public static synchronized CollectionService getInstance() {
        if (Instance == null) {
            Instance = new CollectionService();
        }
        return Instance;
    }
}
