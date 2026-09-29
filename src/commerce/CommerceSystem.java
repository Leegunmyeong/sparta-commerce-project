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
            // 1단계 반복문 시작 시 콘솔창에 카테고리 목록 보여주기
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            for (int i = 0; i < categoryList.size(); i++) {
                System.out.printf("%d. %s\n",
                        (i + 1),
                        categoryList.get(i).getCategoryName()
                );
            }
            System.out.printf("0. %-6s | %s\n", "종료", "프로그램 종료");
            System.out.print("입력 👉 ");

            // 2단계 원하는 카테고리 선택 및 프로그램 종료 번호 입력 받기
            int inputNumber = sc.nextInt();

            // 2.1 사용자 입력한 번호가 0이면 프로그램을 종료 */
            if (inputNumber == 0) {
                System.out.println("프로그램 종료🛑");
                return; // start()메서드를 완전히 끝내서 프로그램 종료
            }
            // 2.2 사용자가 올바른 번호 입력한 경우
            else if (inputNumber > 0 && inputNumber <= categoryList.size()) {

                // 사용자가 선택한 카테고리 객체 및 그 안에 Product 리스트를 담는 지역변수를 생성해서 저장
                Category selectCategory = categoryList.get(inputNumber - 1);
                List<Product> productList = selectCategory.getProductList();

                // 3.선택한 카테고리 상품 목록 출력
                System.out.println("[ " + selectCategory.getCategoryName() + " ]");
                for (int i = 0; i < productList.size(); i++) {
                    System.out.printf("%d. %-15s | %,10d원 | %s\n",
                            (i + 1),
                            productList.get(i).getProductName(),
                            productList.get(i).getPrice(),
                            productList.get(i).getExplanation()
                    );
                }
                System.out.println("0. 뒤로가기");

                System.out.print("입력 👉 ");
                // 4.사용자가 원하는 상품 번호 or 뒤로가기 번호 선택 입력
                int choice = sc.nextInt();

                // 5.사용자가 입력한 번호에 맞게 결과 출력
                if (choice == 0) {
                    // return을 쓰지 않으면 start 메서드의 시작지검 while문으로 자동으로 이동
                    System.out.println("메인 화면으로 돌아갑니다");
                } else if (choice > 0 && choice <= productList.size()) {
                    System.out.printf("선택한 상품: %s | %,d원 | %s | 재고: %d개\n",
                            productList.get(choice - 1).getProductName(),
                            productList.get(choice - 1).getPrice(),
                            productList.get(choice - 1).getExplanation(),
                            productList.get(choice - 1).getStockQuantity());
                } else {
                    System.out.println("잘못된 상품 번호입니다.🛑");
                }
            } else {
                System.out.println("잘못된 번호를 입력하셨습니다. 다시 입력해주세요");
            }
        } // while문 끝 부분

    }// start 메서드 끝 부분

}
