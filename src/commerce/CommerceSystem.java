package commerce;

import java.util.List;
import java.util.Scanner;

// 커머스 플랫폼의 상품을 관리하고 사용자 입력을 처리하는 클래스

public class CommerceSystem {

    // 속성
    private List<Category> categoryList;
    private Scanner sc = new Scanner(System.in);
    private Category selectCategory;
    private Product selectProduct;


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
            int inputNumber = enterNumber();

            // 3단계 입력 받은 카테고리 번호 값 결과 처리
            String getCategoryValue = processCategorySelection(inputNumber);

            // 프로그램 종료
            if (getCategoryValue.equals("exit")) {
                break;
            }
            // 잘못 입력 할 경우
            if (getCategoryValue.equals("wrong")) {
                continue;
            }

            // 제대로 입력 했을 때 4단계로 넘어감

            // 4단계 상품 목록 출력
            showProduct();

            // 5단계 상품 번호 입력받기
            int inputNumber2 = enterNumber();
            // 6단계 입력 받은 상품 번호 값 결과 처리
            String getProductValue = processProductSelection(inputNumber2);

            // 뒤로가기
            if (getProductValue.equals("back")) {
                break;
            }
            //잘못 입력 할 경우
            if (getProductValue.equals("wrong")) {
                continue;
            }

            // 올라른 번호 입력한 경우
            if (getProductValue.equals("product")) {
                System.out.printf("선택한 상품: %s | %,d원 | %s | 재고: %d개\n",
                        selectProduct.getProductName(),
                        selectProduct.getPrice(),
                        selectProduct.getExplanation(),
                        selectProduct.getStockQuantity()
                );
            }

        } // while문 끝
    }




    // 카테고리 목록 출력 메서드
    private void showCategory() {
        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.printf("%d. %s\n", (
                            i + 1),
                    categoryList.get(i).getCategoryName());
        }
        System.out.printf("0. %-6s | %s\n", "종료", "프로그램 종료");
    }


    // 상품 목록 출력 메서드
    private void showProduct() {
        List<Product> productList = selectCategory.getProductList();

        System.out.println("[ " + selectCategory.getCategoryName() + " 카테고리 ]");
        for (int i = 0; i < productList.size(); i++) {
            System.out.printf("%d. %-15s | %,10d원 | %s\n",
                    (i + 1),
                    productList.get(i).getProductName(),
                    productList.get(i).getPrice(),
                    productList.get(i).getExplanation());
        }
        System.out.println("0. 뒤로가기");
    }

    // 선택한 카테고리 반환 메서드
    private String processCategorySelection(int value) {
        // 0이면 프로그램 종료
        if (value == 0) {
            System.out.println("프로그램 종료🛑");
            return "exit";
        } else if (value > 0 && value <= categoryList.size()) { // 카테고리 객체 반환
            this.selectCategory = categoryList.get(value - 1);
            return "category";
        } else {
            System.out.println("잘못된 값을 입력하셨습니다 다시 입력해주세요.❌"); // 잘못 입력 처리
            return "wrong";
        }
    }

    // 선택한 상품 출력 메서드
    private String processProductSelection(int value) {

        List<Product> productList = this.selectCategory.getProductList();

        if (value == 0) {
            System.out.println("메인 화면으로 돌아갑니다");
            return "back";
        } else if (value > 0 && value <= productList.size()) {
            this.selectProduct = productList.get(value - 1); // Product 객체 반환
            return "product";
        } else {
            System.out.println("잘못된 상품번호를 입력하셨습니다 다시 입력해주세요.❌"); // 잘못 입력 처리
        }
        return "wrong";
    }

    // 입력 받기
    private int enterNumber() {
        System.out.print("입력 👉 ");
        return sc.nextInt();
    }
}
