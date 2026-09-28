package commerce;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Product> electronicsList = new ArrayList<>();
        List<Category> categories = new ArrayList<>();

        Product product1 = new Product("Galaxy S24", 1200000, "최신 스마트폰", 50);
        Product product2 = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 30);
        Product product3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 100);
        Product product4 = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 20);


        electronicsList.add(product1);
        electronicsList.add(product2);
        electronicsList.add(product3);
        electronicsList.add(product4);

        Category electronics = new Category("전자제품", electronicsList);
        Category clothes = new Category("의류", new ArrayList<>());
        Category food = new Category("음식", new ArrayList<>());
        categories.add(electronics);
        categories.add(clothes);
        categories.add(food);


        CommerceSystem system = new CommerceSystem(categories);

        system.start();







    }
}
