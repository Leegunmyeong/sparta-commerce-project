package commerce;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {


        // 1. 전자제품 상품(Product) 객체들을 저장할 리스트 생성
        List<Product> electronicsList = new ArrayList<>();
        // 2. 여러 카테고리 객체들을 관리할 최상위 카테고리 리스트 생성
        List<Category> categories = new ArrayList<>();

        Product product1 = new Product("Galaxy S24", 1200000, "최신 스마트폰", 50);
        Product product2 = new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 30);
        Product product3 = new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 100);
        Product product4 = new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 20);


        electronicsList.add(product1);
        electronicsList.add(product2);
        electronicsList.add(product3);
        electronicsList.add(product4);

        // 3. 카테고리명과 해당 상품 리스트를 묶어서 카테고리 객체 생성
        Category electronics = new Category("전자제품", electronicsList);
        Category clothes = new Category("의류", new ArrayList<>());
        Category food = new Category("음식", new ArrayList<>());

        // 4. 생성한 카테고리 객체들을 전체 카테고리 리스트(categories)에 추가
        categories.add(electronics);
        categories.add(clothes);
        categories.add(food);

        // 5. 완성된 카테고리 목록을 CommerceSystem 클래스에 전달하여 시스템 생성자 호출 및 프로그램 시작
        CommerceSystem system = new CommerceSystem(categories);
        system.start();







    }
}
