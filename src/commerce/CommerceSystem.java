package commerce;

import java.util.List;
import java.util.Scanner;

// 커머스 플랫폼의 상품을 관리하고 사용자 입력을 처리하는 클래스

public class CommerceSystem {

    // 속성
    private List<Category> categoryList;
    private Scanner sc = new Scanner(System.in);


    // 생성자
    public CommerceSystem(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    //기능

    public void start() {
        while (true) {
            // 1단계 카테고리 출력
            showCategory();

            // 2단계 카테고리 입력받기
            System.out.print("입력 👉 ");
            int inputNumber = sc.nextInt();

            // 3단계. 0이면 프로그램 바로 종료
            if (inputNumber == 0) {
                System.out.println("프로그램 종료🛑");
                return; // start()메서드를 종료
            }

            // 3.1 입력 값 유효성 검사
            if (!validateChoice(inputNumber, categoryList.size())) {
                continue;
            }

            // 올바른 카테고리 번호 입력 시 실행
            Category selectCategory = categoryList.get(inputNumber - 1);
            List<Product> productList = selectCategory.getProductList();

            // 3단계(true) 선택한 카테고리 상품 목록 출력
            showProduct(selectCategory);

            // 4단계 상품 번호 입력받기
            System.out.print("입력 👉 ");
            int inputNumber2 = sc.nextInt();

            // 5.1 뒤로 돌아가기
            if (inputNumber2 == 0) {
                System.out.println("메인 화면으로 돌아갑니다");
                continue;
            }
            // 5.2 유효성 검사
            if (!validateChoice(inputNumber2, productList.size())) {
                continue;
            }
            // 5.3 올바른 상품번호 입력 시 실행
            Product selectProduct = productList.get(inputNumber2 - 1);
            System.out.printf("선택한 상품: %s | %,d원 | %s | 재고: %d개\n", selectProduct.getProductName(), selectProduct.getPrice(), selectProduct.getExplanation(), selectProduct.getStockQuantity());
        } // while문 끝
    }


    //카테고리 목록 출력 메서드
    public void showCategory() {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), categoryList.get(i).getCategoryName());
        }
        System.out.printf("0. %-6s | %s\n", "종료", "프로그램 종료");
    }


    // 선택한 카테고리 상품 목록 출력 메서드
    public void showProduct(Category category) {
        List<Product> productList = category.getProductList();

        System.out.println("[ " + category.getCategoryName() + " 카테고리 ]");
        for (int i = 0; i < productList.size(); i++) {
            System.out.printf("%d. %-15s | %,10d원 | %s\n",
                    (i + 1),
                    productList.get(i).getProductName(),
                    productList.get(i).getPrice(),
                    productList.get(i).getExplanation());
        }
        System.out.println("0. 뒤로가기");
    }

    // 카테고리 선택 유효성 검사
    public boolean validateChoice(int value, int maxSize) {
        if (value < 0 || value > maxSize) {
            System.out.println("잘못입력하셨습니다 다시입력해주세요.");
            return false;
        }
        return true;
    }
}
