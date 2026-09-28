package commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    // 커머스 플랫폼의 상품을 관리하고 사용자 입력을 처리하는 클래스
    private List<Category> categoryList ;
    Scanner sc = new Scanner(System.in);


    // 생성자
    CommerceSystem(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    //기능
    public void start() {
        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품💻📱 ]");
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
                break;
            }
        }

    }

}
