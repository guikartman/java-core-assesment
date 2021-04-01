package com;

import com.entites.*;
import com.services.CollectionService;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProgramMain {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CollectionService service = CollectionService.getInstance();

        System.out.println("Starting the application....");
        Integer option;

        do {
            menu();
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Save a new Product");
                    System.out.println("Name: ");
                    String name = sc.nextLine();
                    System.out.println("Description:");
                    String description = sc.nextLine();
                    System.out.println("Price:");
                    BigDecimal price = BigDecimal.valueOf(sc.nextDouble());
                    System.out.println("Quantity:");
                    Integer quantity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Image name:");
                    String imageName = sc.nextLine();
                    System.out.println("Image path:");
                    String imagePath = sc.nextLine();
                    System.out.println("Sub-collection name:");
                    String subCollName = sc.nextLine();
                    SubCollection subc = service.findSubCollection(subCollName);
                    System.out.println("1: To save new Pants");
                    System.out.println("2: To save new Sneakers");
                    System.out.println("3: To save new TShirt");
                    int res = sc.nextInt();
                    sc.nextLine();
                    switch (res) {
                        case 1:
                            Pants pants = new Pants(null,name,price,description,quantity,new Image(imageName, null, null, imagePath));
                            pants.setSubCollection(subc);
                            System.out.println("Color:");
                            pants.setColor(sc.nextLine());
                            System.out.println("Gender:");
                            pants.setGender(sc.next().charAt(0));
                            sc.nextLine();
                            System.out.println("Size:");
                            pants.setSize(Size.valueOf(sc.next()));
                            sc.nextLine();
                            System.out.println("Activity:");
                            pants.setActivity(sc.nextLine());
                            System.out.println("Material:");
                            pants.setMaterial(sc.nextLine());
                            pants = (Pants) service.insert(pants.getSubCollection(),pants);
                            System.out.println("Product saved: "+ pants);
                            break;

                        case 2:
                            Sneakers sneakers = new Sneakers(null,name,price,description,quantity,new Image(imageName, null, null, imagePath));
                            sneakers.setSubCollection(subc);
                            System.out.println("Color:");
                            sneakers.setColor(sc.nextLine());
                            System.out.println("Gender:");
                            sneakers.setGender(sc.next().charAt(0));
                            sc.nextLine();
                            System.out.println("Size:");
                            sneakers.setSize(sc.nextInt());
                            sc.nextLine();
                            System.out.println("Activity:");
                            sneakers.setActivity(sc.nextLine());
                            sneakers = (Sneakers) service.insert(sneakers.getSubCollection(),sneakers);
                            System.out.println("Product saved: "+ sneakers);
                            break;

                        case 3:
                            TShirt tShirt = new TShirt(null,name,price,description,quantity,new Image(imageName, null, null, imagePath));
                            tShirt.setSubCollection(subc);
                            System.out.println("Color:");
                            tShirt.setColor(sc.nextLine());
                            System.out.println("Gender:");
                            tShirt.setGender(sc.next().charAt(0));
                            sc.nextLine();
                            System.out.println("Size:");
                            tShirt.setSize(Size.valueOf(sc.next()));
                            sc.nextLine();
                            System.out.println("Is it a long Tshirt? Y/N");
                            Character y = sc.next().charAt(0);
                            if (y.equals('Y') || y.equals('y')) {
                                tShirt.setIsLong(true);
                            }else {
                                tShirt.setIsLong(false);
                            }
                            tShirt = (TShirt) service.insert(tShirt.getSubCollection(),tShirt);
                            System.out.println("Product saved: "+ tShirt);
                            break;

                        default:
                            break;
                    }

                case 2:
                    System.out.println("1: Create a new Collection ");
                    System.out.println("2: Create a new SubCollection");
                    System.out.println("3: List Collections");
                    System.out.println("4: Search for Product in a sub-collection");
                    System.out.println("5: List for products in a collection");
                    System.out.println("6: List for products in a sub-collection");
                    int aws = sc.nextInt();
                    sc.nextLine();
                    switch (aws) {
                        case 1:
                            System.out.println("Inform the collection name: ");
                            String cname = sc.nextLine();
                            Collection savedCollection = service.insertCollection(new Collection(null,cname));
                            System.out.println("Collection saved: "+savedCollection);
                            break;

                        case 2:
                            System.out.println("Inform the collection name: ");
                            String collectionName = sc.nextLine();
                            try {
                                Collection collectionFinded = service.findCollection(collectionName);
                                System.out.println("Inform the sub collection name: ");
                                String subCollectionName = sc.nextLine();
                                SubCollection savedSubCollection = service.insertSubCollection(collectionFinded,new SubCollection(null,subCollectionName));
                                System.out.println("SubCollection saved: "+savedSubCollection);
                                break;
                            } catch (NoSuchElementException e) {
                                System.out.println("Could not find this collection!");
                                break;
                            }


                        case 3:
                            service.listCollections().forEach(c -> System.out.println(c));
                            break;

                        case 4:
                            System.out.println("Inform the sub-collection name: ");
                            String subCName = sc.nextLine();
                            System.out.println("Inform the product name: ");
                            String pName = sc.nextLine();
                            try {
                                Product product = service.findProductInSubCollection(subCName, pName);
                                System.out.println("Finded product: "+ product);
                                break;
                            }catch (NoSuchElementException e) {
                                System.out.println("Could not find the product!");
                                break;
                            }

                        case 5:
                            System.out.println("Inform the collection name: ");
                            String cName = sc.nextLine();
                            System.out.println("Products finded at this collection: ");
                            service.listAllProductsInACollection(cName).forEach(p -> System.out.println(p));
                            break;

                        case 6:
                            System.out.println("Inform the sub-collection name: ");
                            String subCName2 = sc.nextLine();
                            System.out.println("Products finded at this sub-collection: ");
                            service.listAllProductsInASubCollection(subCName2).forEach(sc -> System.out.println(sc));
                            break;

                        default:
                            break;
                    }

                default:
                    break;
            }
        }while (option != 4);

    }

    public static void menu() {
        System.out.println("============== Menu ==============");
        System.out.println("1: Product Management");
        System.out.println("2: Collection Management");
        System.out.println("4: Exit");
        System.out.println("============== Menu ==============");
    }
}
