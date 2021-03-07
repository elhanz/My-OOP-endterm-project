package repositories.interfaces;

import entities.Employee;
import entities.Product;
import java.time.LocalDate;
import java.util.ArrayList;

public interface IMRepository {//there are all our methods
    public ArrayList <Product> searchProductByDescription(String description);
    public ArrayList <Product>  showAllProduct();
    public Product getProductById(int product_id);
    public  boolean addProduct (Product product);
    public boolean removeProductById(int product_id);
    public ArrayList<Employee> searchEmployeeByName(String name);
    public ArrayList<Employee>  showAllEmployee();
    public Employee getEmployeeById(int id);
    public  boolean addEmployee (Employee employee);
    public boolean removeEmployeeById(int id);
    public ArrayList<Employee> searchEmployeeByDate(LocalDate date);
    public  boolean updateProductQ (int id, int quantity, String choice);
    public  ArrayList<Product> searchProductByBrand(String brand);
    public  ArrayList<Product> searchProductBySize(String size);
}