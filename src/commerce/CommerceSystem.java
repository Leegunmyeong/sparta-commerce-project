package commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    // 커머스 플랫폼의 상품을 관리하고 사용자 입력을 처리하는 클래스
    private List<Category> categoryList;
    Scanner sc = new Scanner(System.in);


    // 생성자
    public CommerceSystem(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    //기능
    public void start() {
        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (int i = 0; i < categoryList.size(); i++) {
                System.out.printf("%d. %s\n",
                        (i + 1),
                        categoryList.get(i).getCategoryName()
                );
            }
            System.out.printf("0. %-6s | %s\n", "종료", "프로그램 종료");
            System.out.print("입력 👉 ");

            int inputNumber = sc.nextInt();
            if (inputNumber == 0) {
                System.out.println("프로그램 종료🛑");
                return;
            } else if (inputNumber > 0 && inputNumber <= categoryList.size()) {
                showCategoryProducts(categoryList.get(inputNumber - 1));
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }

    }

    // 카테고리 상품 목록
    public void showCategoryProducts(Category category) {
        List<Product> products = category.getProductList();


        System.out.println("[ " + category.getCategoryName() + " ]");
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. %-15s | %,10d원 | %s\n",
                    (i + 1),
                    products.get(i).getProductName(),
                    products.get(i).getPrice(),
                    products.get(i).getExplanation()
            );
        }
        System.out.println("0. 뒤로가기");

        System.out.print("입력 👉 ");
        int choice = sc.nextInt();

        if (choice == 0) {
            return;
        } else if (choice > 0 && choice <= products.size()) {
            System.out.printf("선택한 상품: %s | %,d원 | %s | 재고: %d개\n",
                    products.get(choice - 1).getProductName(), products.get(choice - 1).getPrice(), products.get(choice - 1).getExplanation(), products.get(choice - 1).getStockQuantity());
        } else {
            System.out.println("잘못된 상품 번호입니다.🛑");
        }
    }

}
