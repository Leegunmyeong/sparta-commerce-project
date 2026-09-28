package commerce;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    // 커머스 플랫폼의 상품을 관리하고 사용자 입력을 처리하는 클래스
    List<Product> productList;
    Scanner sc = new Scanner(System.in);


    // 생성자
    CommerceSystem(List<Product> products) {
        this.productList = products;
    }

    //기능
    public void start() {
        while (true) {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품💻📱 ]");
            for (int i = 0; i < productList.size(); i++) {
                System.out.printf("%d. %-15s | %,10d원 | %s\n",
                        (i + 1),
                        productList.get(i).getProductName(),
                        productList.get(i).getPrice(),
                        productList.get(i).getExplanation()
                );
            }
            System.out.printf("0. %-14s | %s\n", "종료", "프로그램 종료");
            System.out.print("입력 👉 ");
            int inputNumber = sc.nextInt();
            if (inputNumber == 0) {
                System.out.println("프로그램 종료🛑");
                break;
            }
        }

    }

}
