package commerce;

import java.util.List;

// Product 클래스를 관리하는 클래스
public class Category {

    // 속성
    private String categoryName;
    private List<Product> productList;


    // 생성자
    public Category(String categoryName, List<Product> productList) {
        this.categoryName = categoryName;
        this.productList = productList;
    }


    // getter
    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProductList() {
        return productList;
    }


}
