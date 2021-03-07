
package controllers;

import entities.Employee;
import entities.Product;
import repositories.interfaces.IMRepository;

import java.time.LocalDate;
import java.util.ArrayList;//we use arraylist if query must show us more than one product/employee


public class MController {
    private final IMRepository mRepository;

    public MController(IMRepository mRepository) {
        this.mRepository = mRepository;
    }


    public String searchProductByDescription(String description) {
        ArrayList<Product> products = mRepository.searchProductByDescription(description);
        return (products == null ? "Product was not found." : products.toString());
    }
    public String searchProductByBrand(String brand) {
        ArrayList<Product> products = mRepository.searchProductByBrand(brand);
        return (products == null ? "Product was not found." : products.toString());
    }

    public String searchProductBySize(String size) {
        ArrayList<Product> products = mRepository.searchProductBySize(size);
        return (products == null ? "Product was not found." : products.toString());
    }

    public String getProductById(int product_id) {
        Product product = mRepository.getProductById(product_id);
        return (product == null ? "Product was not found." : product.toString());

    }
        public String showAllProduct () {
            String result = mRepository.showAllProduct().toString();
            return result;
        }

        public String addProduct (String product_type, String description, String brand, String size, int quantity, int price){

            boolean added = mRepository.addProduct(new Product( product_type, description, brand,  size,  quantity, price));

            return(added ? "Product was added." : "Something went wrong...");
        }

        public String removeProductById ( int  product_id){
            boolean removed = mRepository.removeProductById( product_id);// to know if it was/wasn't removed

            return(removed ? "Product was removed." : "Something went wrong...");
        }
    public String searchEmployeeByName(String name) {
        String result = mRepository.searchEmployeeByName(name).toString();
        return result;
    }

    public String getEmployeeById(int id) {
        String result = mRepository.getEmployeeById(id).toString();
        return result;
    }
    public String searchEmployeeByDate(LocalDate date) {//to show employee by date of hiring
        String result = mRepository.searchEmployeeByDate(date).toString();
        return result;
    }
    public String showAllEmployee( ) {
        String result = mRepository.showAllEmployee().toString();
        return result;
    }

    public String addEmployee(String name, String surname, String job, LocalDate dateOfHiring, int salary) {

        boolean added = mRepository.addEmployee(new Employee(name,surname,job, dateOfHiring, salary));// to know if it was/wasn't added

        return(added ? "Employee was added." : "Something went wrong...");
    }

    public String removeEmployeeById(int id) {
        boolean removed = mRepository.removeEmployeeById(id);// to know if it was/wasn't removed

        return(removed ? "Employee was removed." : "Something went wrong...");
    }
    public String updateProductQ(int id, int quantity, String choice){
        boolean updated = mRepository.updateProductQ(id, quantity, choice);

        return(updated ? "Product info was updated" : "Something went wrong...");
    }

}