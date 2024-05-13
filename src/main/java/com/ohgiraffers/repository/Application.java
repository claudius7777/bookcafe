package com.ohgiraffers.repository;

import com.ohgiraffers.controller.MainController;
import com.ohgiraffers.dto.BookDTO;

import java.util.Scanner;

public class Application
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        MainController mainController = new MainController();
        boolean rental = true; // 대여 여부를 나타내는 변수
        String result = ""; // 결과를 저장할 변수
        int index; // 대여 목록의 인덱스를 나타내는 변수
        while (rental)
        {
            System.out.println("1. 대여 등록");
            System.out.println("2. 대여 삭제");
            System.out.println("3. 대여 수정");
            System.out.println("4. 대여 상세조회");
            System.out.println("5. 대여 전체조회");
            System.out.print("어떤 메뉴를 동작하시겠나요?");
            int input = sc.nextInt(); // 사용자 입력을 받음
            sc.nextLine(); // 개행문자 제거

            switch(input) {
                case 1: // 대여 등록
                    System.out.print("몇개의 도서를 대여하시겠나요?");
                    int cnt = sc.nextInt();
                    sc.nextLine();
                    BookDTO[] rentals = new BookDTO[cnt];
                    for (int i = 0; i < rentals.length; i++) {
                        System.out.print("대여할 도서 제목을 등록해 주세요 :");
                        String bookName = sc.nextLine();
                        System.out.println("대여 할 도서 수량을 입력해 주세요 :");
                        int quantity = sc.nextInt();
                        System.out.println("대여 가격을 입력해 주세요 :");
                        int price = sc.nextInt();
                        rentals[i] = new BookDTO(bookName, quantity, price);//새로운 BookDTO 객체 생성
                        sc.nextLine(); // 개행문자 제거
                    }
                    result = mainController.rental(rentals); // 대여 등록 메서드 호출

                case 2: // 대여 삭제
                    System.out.print("삭제할 도서의 번호를 입력해 주세요 : ");
                    index = Integer.parseInt(sc.nextLine());
                    result = index + " 번 ";
                    result += mainController.rentalDelete(index);
                    break;

                case 3: // 대여 수정
                    System.out.println(mainController.rentalRead());
                    System.out.print("수정 할 도서 번호를 입력해 주세요 : ");
                    index = sc.nextInt(); //수정할 대여 목록의 인덱스
                    sc.nextLine(); //개행문자 제거
                    System.out.print("도서 이름을 수정해 주세요 :");
                    String bookname = sc.nextLine(); // 수정할 도서 이름 입력
                    System.out.print("도서 대여가격을 수정해 주세요 : ");
                    int price = Integer.parseInt(sc.nextLine()); // 수정할 도서 가격입력
                    System.out.println("도서 수량을 지정해 주세요 : ");
                    int quantity = Integer.parseInt(sc.nextLine()); //수절할 도서 수량 입력
                    BookDTO modifyRental = new BookDTO(bookname, price, quantity); // 수정할 대여 정보 생성
                    result = mainController.rentalModify(index, modifyRental); // 대여 수정 메서드 호출
                    break;

                case 4: // 대여 상세조회
                    System.out.println(rentalController.rentalRead());
                    System.out.println("상세 조회할 도서 번호를 입력해 주세요");
                    int num = sc.nextInt(); // 조회할 대여 목록의 인덱스 입력
                    sc.nextLine();
                    result = mainController.rentalDetail(num);
                    break;

                case 5: // 대여 전체조회
                    result = mainController.reatalRead(); // 대여 전체 조회 메서드 호출
                    break;

                default:
                    System.out.println("입력이 잘못되었습니다.");
                    break;
            }
            System.out.println(result);// 결과 출력

            System.out.println("대열를 종료하시겠나요?");
            rental = sc.nextBoolean(); // 대여 종료 여부 출력

            }
        }
        /* 대여 관련 기능을 수행하는 메일 애플리케이션 클래스 입니다.
        사용자로부터의 입력을 받고, 해당하는 기능을 실행합니다.
        각 기능별로는 'MainController'의 메서드를 호출하여 실행합니다.
        반복문을 통해 사용자가 종료할 때까지 계속해서 기능을 제공합니다.
         */



    }
}
