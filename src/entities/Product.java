package entities;


public class Product {
    private int product_id;
    private String product_type;
    private String description;
    private String brand;
    private String size;
    private int quantity;
    private int price;//check

    public Product(int product_id, String product_type, String description, String brand, String size, int quantity, int price) {//to show products
        this.product_id = product_id;
        this.product_type = product_type;
        this.description = description;
        this.brand = brand;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(String product_type, String description, String brand, String size, int quantity, int price) {//to add products
        this.product_type = product_type;
        this.description = description;
        this.brand = brand;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public Product() {
    }


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "\nProduct{" +
                "product_id=" + product_id +
                ", product_type='" + product_type + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
