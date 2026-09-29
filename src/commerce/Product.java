package commerce;

public class Product {

    //속성
    //상품명
    private String productName;
    //가격
    private int price;
    //설명
    private String explanation;
    //재고수량
    private int stockQuantity;


    // 생성자
    public Product(String productName, int price, String explanation, int stockQuantity) {
        this.productName = productName;
        this.price = price;
        this.explanation = explanation;
        this.stockQuantity = stockQuantity;
    }


    //getter

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getExplanation() {
        return explanation;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
