package repositories;

import data.interfaces.DBInterface;
import entities.Product;
import entities.Employee;
import repositories.interfaces.IMRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MRepository implements IMRepository {
    private final DBInterface database;

    public MRepository(DBInterface database) {
        this.database = database;
    }


    @Override
    public ArrayList<Product> searchProductByDescription(String description) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products where description like'%"+description+"%'");
            ResultSet rs = preparedStatement.executeQuery();

            ArrayList<Product> products = new ArrayList<>();//fill our arraylist by values from database
            while (rs.next()) {
                Product product = new Product(rs.getInt("product_id"), rs.getString("product_type"),
                        rs.getString("description"), rs.getString("brand"), rs.getString("size"),
                        rs.getInt("quantity"), rs.getInt("price"));
                products.add(product);//add new product to arraylist
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public ArrayList<Product> searchProductByBrand(String brand) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products where brand ='"+brand+"'");
            ResultSet rs = preparedStatement.executeQuery();

            ArrayList<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product(rs.getInt("product_id"), rs.getString("product_type"),
                        rs.getString("description"), rs.getString("brand"), rs.getString("size"),
                        rs.getInt("quantity"), rs.getInt("price"));
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public ArrayList<Product> searchProductBySize(String size) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products where size ='"+size+"'");
            ResultSet rs = preparedStatement.executeQuery();

            ArrayList<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product(rs.getInt("product_id"), rs.getString("product_type"),
                        rs.getString("description"), rs.getString("brand"), rs.getString("size"),
                        rs.getInt("quantity"), rs.getInt("price"));
                products.add(product);
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Product> showAllProduct() {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products ");
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product(
                    resultSet.getInt("product_id"),
               resultSet.getString("product_type"),
                        resultSet.getString("description"),
                       resultSet.getString("brand"),
                resultSet.getString("size"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("price"));

                products.add(product);
            }
            return products;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public Product getProductById(int product_id) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from products where product_id=?");
            preparedStatement.setInt(1, product_id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                Product product = new Product(rs.getInt("product_id"), rs.getString("product_type"),
                        rs.getString("description"), rs.getString("brand"), rs.getString("size"),
                        rs.getInt("quantity"), rs.getInt("price"));
                return product;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addProduct ( Product product) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into products (product_type,description, brand,size,  quantity, price) values (?,?,?,?,?,?)");
            preparedStatement.setString(1, product.getProduct_type());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setString(3, product.getBrand());
            preparedStatement.setString(4, product.getSize());
            preparedStatement.setInt(5, product.getQuantity());
            preparedStatement.setInt(6, product.getPrice());

            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeProductById(int product_id) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from products where product_id=?");
            preparedStatement.setInt(1, product_id);
            boolean executed = preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

        @Override
        public ArrayList<Employee> searchEmployeeByName(String name) {
            Connection connection = null;
            try {
                connection = database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where name= '" + name + "'");//finding employee by name
                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<Employee> employees = new ArrayList<>();
                while (resultSet.next()) {
                    Employee employee = new Employee(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getString("job"),
                            resultSet.getDate("dateofhiring").toLocalDate(),
                            resultSet.getInt("salary"));
                    employees.add(employee);
                }
                return employees;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public ArrayList<Employee> showAllEmployee() {
            Connection connection = null;
            try {
                connection = database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from employee ");
                ResultSet resultSet = preparedStatement.executeQuery();

                ArrayList<Employee> employees = new ArrayList<>();
                while (resultSet.next()) {
                    Employee employee = new Employee(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getString("job"),
                            resultSet.getDate("dateofhiring").toLocalDate(),
                            resultSet.getInt("salary"));
                    employees.add(employee);
                }
                return employees;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }



        @Override
        public Employee getEmployeeById(int id) {
            Connection connection = null;
            try {
                connection = database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");//checking employee with this id
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                Employee employee = new Employee();
                if (resultSet.next()) {
                    employee.setId(resultSet.getInt("id"));
                    employee.setName(resultSet.getString("name"));
                    employee.setSurname(resultSet.getString("surname"));
                    employee.setJob(resultSet.getString("job"));
                    employee.setDateOfHiring(resultSet.getDate("dateOfHiring").toLocalDate());
                    employee.setSalary(resultSet.getInt("salary"));
                }
                return employee;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public boolean addEmployee(Employee employee) {
            Connection connection = null;
            try {
                connection = database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into employee(name, surname,job,dateofhiring,salary) values (?,?,?,?,?)");//inserting into database new employee
                preparedStatement.setString(1, employee.getName());//prepared statements to insert values in such order
                preparedStatement.setString(2, employee.getSurname());
                preparedStatement.setString(3, employee.getJob());
                preparedStatement.setDate(4, Date.valueOf(employee.getDateOfHiring()));
                preparedStatement.setInt(5, employee.getSalary());
                preparedStatement.execute();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public boolean removeEmployeeById(int id) {
            Connection connection = null;
            try {
                connection = database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id=?");//removing employee from database
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        public ArrayList<Employee> searchEmployeeByDate(LocalDate date) {
            Connection connection = null;
            try {
                connection = database.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where dateofhiring=?");//finding employee with this hiring date

                preparedStatement.setDate(1, Date.valueOf(date));
                ResultSet resultSet = preparedStatement.executeQuery();
                ArrayList<Employee> employees = new ArrayList<>();
                while (resultSet.next()) {
                    Employee employee = new Employee(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getString("job"),
                            resultSet.getDate("dateofhiring").toLocalDate(),
                            resultSet.getInt("salary"));
                    employees.add(employee);
                }
                return employees;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

    public boolean updateProductQ(int id, int quantity, String choice) {
        Connection connection = null;
        try {
            connection = database.getConnection();
            char symbol ='/';
            if(choice.equals("add")){//to add quantity
                symbol = '+';
            }else if(choice.equals("remove")){//to remove quantity
                symbol = '-';
            }
            PreparedStatement preparedStatement = connection.prepareStatement("update products set quantity = quantity " + symbol + " ? where product_id = ?");

            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, id);
            boolean executed = preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    }



