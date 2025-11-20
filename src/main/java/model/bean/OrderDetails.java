package model.bean;

public class OrderDetails {
    private int id;
    private int orderId;
    private int productId;
    private float price;
    private int numberOfProducts;
    private float totalMoney;
    private String color;

    public OrderDetails() {
    }

    public OrderDetails(int id, int orderId, int productId, float price,
                        int numberOfProducts, float totalMoney, String color) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.price = price;
        this.numberOfProducts = numberOfProducts;
        this.totalMoney = totalMoney;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
