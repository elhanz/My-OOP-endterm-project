
import controllers.MController;

import java.time.LocalDate;
import java.util.Scanner;

public class MyApplication {
    private final MController MController;
    private final Scanner scanner;

    public MyApplication(MController MController) {
        this.MController = MController;
        scanner = new Scanner(System.in);
    }

    public void start() {
      while (true){
          System.out.println("Choose what do you want to work with: \n1. Products \n2. Employees");
          System.out.print("Answer: ");
          int choice = scanner.nextInt();
          scanner.nextLine();
          if (choice==1) {//work with products

              System.out.println("Choose one option (0-8):\n1. Search product by description\n2. Get product by id\n3. Add product\n4. Remove product\n5. Show all products\n6. Update product quantity\n7. Get product by brand\n8. Get product by size\n. Exit\n");
              int choice2 = scanner.nextInt();
              scanner.nextLine();
              if (choice2==1) {
                  searchProductByDescription( );
              }
              else if (choice2==2) {
                  getProductByIdMenu();
              }
              else if (choice2==3) {//add new product
                  addProductMenu();
              }
              else if (choice2==4) {
                  removeProductByIdMenu();
              }
              else if (choice2 == 5) {
                  showAllProduct();
              }
              else if (choice2 == 6) {//add/remove some quantities from database
                  updateProductQ();
              }
              else if (choice2 == 7) {
                  searchProductByBrand();
              }
              else if (choice2 == 8) {
                  searchProductBySize();
              }
              else {
                  break;
              }
          }
          else if (choice==2) {//work with employee

              System.out.println("Choose one option (0-6):\n1. Search employee by name\n2. Get employee by id\n3. Add employee\n4. Remove employee\n5. Show all employee \n0) Exit\n");
              int choice3 = scanner.nextInt();
              if (choice3==1) {
                  searchEmployeeByName( );
              }
              else if (choice3==2) {
                  getEmployeeByIdMenu();
              }
              else if (choice3==3) {
                  addEmployeeMenu();
              }
              else if (choice3==4) {
                  removeEmployeeByIdMenu();
              }
              else if (choice3==5) {
                  showAllEmployee();
              }
              else if (choice3==6) {
                  searchEmployeeByDate();
              }

              else {
                  break;
              }

          }
          else {
              break;
          }
          System.out.println("\n*******************************************************************************************************************************\n");
      }


    }

    public void searchProductByDescription(){
        System.out.println("Write the description of product in (color/brand/type): ");
        String description = scanner.next();//checking text
        String result = MController.searchProductByDescription(description);// send it to our controller and get result
        System.out.println(result);//show result on the screen
    }
    public void searchProductByBrand(){
        System.out.println("Write the brand of product : ");
        String brand = scanner.next();
        String result = MController.searchProductByBrand(brand);
        System.out.println(result);
    }
    public void searchProductBySize(){
        System.out.println("Write the size of product : ");
        String size = scanner.next();
        String result = MController.searchProductBySize(size);
        System.out.println(result);
    }
    public void getProductByIdMenu() {
        System.out.println("Write product id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String result = MController.getProductById(id);
        System.out.println(result);
    }

    public void addProductMenu() {
        System.out.println("Write the type of product: ");
        String product_type = scanner.nextLine();
        System.out.println("Write the description of product: ");
        String description = scanner.nextLine();
        System.out.println("Write the brand of product: ");
        String brand = scanner.nextLine();
        System.out.println("Write product's size: ");
        String size = scanner.nextLine();
        System.out.println("Write quantity: ");
        int  quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Write price: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        String result = MController.addProduct(product_type, description, brand,  size,  quantity, price);
        System.out.println(result);
    }


    public void removeProductByIdMenu() {
        System.out.println("Write product's id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String result = MController.removeProductById(id);

        System.out.println(result);
    }
    public void showAllProduct() {
        String result = MController.showAllProduct();

        System.out.println(result);
    }

    public void searchEmployeeByName() {
        System.out.println("Write employee's name: ");
        String name = scanner.next();
        String result = MController.searchEmployeeByName(name);
        System.out.println(result);
    }

    public void getEmployeeByIdMenu() {
        System.out.println("Write employee's id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String result = MController.getEmployeeById(id);
        System.out.println(result);
    }

    public void addEmployeeMenu() {
        System.out.println("Write employee's name: ");
        String name = scanner.next();
        System.out.println("Write employee's surname: ");
        String surname = scanner.next();
        System.out.println("Write employee's job: ");
        String job = scanner.next();
        System.out.println("Write employee's hiring date in yyyy-mm-dd format: ");
        String dateofhiring = scanner.next();
        LocalDate dateOfHiring= LocalDate.parse(dateofhiring);
        System.out.println("Write employee's salary: ");
        int salary = scanner.nextInt();
        scanner.nextLine();

        String result = MController.addEmployee(name,surname,job, dateOfHiring,salary);
        System.out.println(result);
    }


    public void removeEmployeeByIdMenu() {
        System.out.println("Write employee id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String result = MController.removeEmployeeById(id);

        System.out.println(result);
    }
    public void showAllEmployee() {
        String result = MController.showAllEmployee();

        System.out.println(result);
    }
    public void searchEmployeeByDate() {//search employee by date of hiring
        System.out.println("Write employee's hiring date: \n");
        String date = scanner.next();
        String result = MController.searchEmployeeByDate(LocalDate.parse(date)); //LocalDate.parse convert string to Local date
        System.out.println(result);
    }
    public void updateProductQ(){//add/remove quantities of some product
        System.out.println("Write product's id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Add quantity or remove? (add/remove): ");
        String choice = scanner.nextLine();
        System.out.println("How much?: ");
        int quantityD = scanner.nextInt();
        scanner.nextLine();

        String result = MController.updateProductQ(id, quantityD, choice);
        System.out.println(result);
        }
    }

