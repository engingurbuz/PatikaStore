package PatikaStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private List<Brand> brands;
    private List<Product> products;

    public Store() {
        brands = new ArrayList<>();
        products = new ArrayList<>();
        initializeBrands();
    }

    private void initializeBrands() {
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void listBrands() {
        System.out.println("Brands:");
        for (Brand brand : brands) {
            System.out.println("- " + brand.getName());
        }
    }

    public void listProducts() {
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(product.getProductDetails());
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("PatikaStore Product Management Panel");
            System.out.println("1 - Notebook Transactions");
            System.out.println("2 - Mobile Phone Transactions");
            System.out.println("3 - List Brands");
            System.out.println("0 - Exit");
            System.out.print("Select: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    handleNotebookTransactions(scanner);
                    break;
                case 2:
                    handleMobilePhoneTransactions(scanner);
                    break;
                case 3:
                    listBrands();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void handleNotebookTransactions(Scanner scanner) {
        System.out.println("Notebook Transactions");
        System.out.println("1 - Add Notebook");
        System.out.println("2 - List Notebooks");
        System.out.print("Select: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addNotebook(scanner);
                break;
            case 2:
                listNotebooks();
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private void addNotebook(Scanner scanner) {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Discount: ");
        double discount = scanner.nextDouble();
        System.out.print("Enter Stock: ");
        int stock = scanner.nextInt();
        System.out.print("Enter Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter Brand ID: ");
        int brandId = scanner.nextInt();
        System.out.print("Enter RAM (GB): ");
        int ram = scanner.nextInt();
        System.out.print("Enter Storage (GB): ");
        int storage = scanner.nextInt();
        System.out.print("Enter Screen Size (inch): ");
        double screenSize = scanner.nextDouble();

        Brand brand = findBrandById(brandId);
        if (brand != null) {
            Notebook notebook = new Notebook(id, price, discount, stock, name, brand, ram, storage, screenSize);
            addProduct(notebook);
            System.out.println("Notebook added successfully.");
        } else {
            System.out.println("Brand not found.");
        }
    }

    private void listNotebooks() {
        System.out.println("Notebook List:");
        for (Product product : products) {
            if (product instanceof Notebook) {
                System.out.println(product.getProductDetails());
            }
        }
    }

    private void handleMobilePhoneTransactions(Scanner scanner) {
        System.out.println("Mobile Phone Transactions");
        System.out.println("1 - Add Mobile Phone");
        System.out.println("2 - List Mobile Phones");
        System.out.print("Select: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addMobilePhone(scanner);
                break;
            case 2:
                listMobilePhones();
                break;
            default:
                System.out.println("Invalid choice, please try again.");
        }
    }

    private void addMobilePhone(Scanner scanner) {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Discount: ");
        double discount = scanner.nextDouble();
        System.out.print("Enter Stock: ");
        int stock = scanner.nextInt();
        System.out.print("Enter Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter Brand ID: ");
        int brandId = scanner.nextInt();
        System.out.print("Enter Memory (GB): ");
        int memory = scanner.nextInt();
        System.out.print("Enter Screen Size (inch): ");
        double screenSize = scanner.nextDouble();
        System.out.print("Enter Battery (mAh): ");
        int battery = scanner.nextInt();
        System.out.print("Enter RAM (GB): ");
        int ram = scanner.nextInt();
        System.out.print("Enter Color: ");
        scanner.nextLine(); // Consume newline
        String color = scanner.nextLine();

        Brand brand = findBrandById(brandId);
        if (brand != null) {
            MobilePhone mobilePhone = new MobilePhone(id, price, discount, stock, name, brand, memory, screenSize, battery, ram, color);
            addProduct(mobilePhone);
            System.out.println("Mobile phone added successfully.");
        } else {
            System.out.println("Brand not found.");
        }
    }

    private void listMobilePhones() {
        System.out.println("Mobile Phone List:");
        for (Product product : products) {
            if (product instanceof MobilePhone) {
                System.out.println(product.getProductDetails());
            }
        }
    }

    private Brand findBrandById(int id) {
        for (Brand brand : brands) {
            if (brand.getId() == id) {
                return brand;
            }
        }
        return null;
    }
}
