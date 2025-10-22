package flightbooking;

import java.util.*;

public class FlightBookingSystem {
    private static List<Flight> flights = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeFlights();

        while (true) {
            System.out.println("[항공권 예매 시스템]");
            System.out.println("1. 항공편 목록 보기");
            System.out.println("2. 항공권 예매");
            System.out.println("3. 예매 내역 보기");
            System.out.println("4. 종료");
            System.out.print("선택: ");
            
            int choice = getIntInput();

            switch (choice) {
                case 1 -> showFlights();
                case 2 -> bookFlight();
                case 3 -> showBookings();
                case 4 -> {
                    System.out.println("이용해 주셔서 감사합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void initializeFlights() {
        flights.add(new Flight("KE101", "서울", "도쿄", 250000));
        flights.add(new Flight("OZ202", "인천", "뉴욕", 900000));
        flights.add(new Flight("LJ303", "부산", "방콕", 400000));
    }

    private static void showFlights() {
        System.out.println("\n[항공편 목록]");
        for (int i = 0; i < flights.size(); i++) {
            System.out.println((i + 1) + ". " + flights.get(i));
        }
    }

    private static void bookFlight() {
        showFlights();
        System.out.print("예매할 항공편 번호: ");
        int index = getIntInput() - 1;

        if (index < 0 || index >= flights.size()) {
            System.out.println("잘못된 선택입니다.");
            return;
        }

        System.out.print("탑승객 이름: ");
        String name = sc.nextLine();
        bookings.add(new Booking(name, flights.get(index)));
        System.out.println(" 예매 완료: " + name + "님");
    }

    private static void showBookings() {
        if (bookings.isEmpty()) {
            System.out.println("예매 내역이 없습니다.");
            return;
        }
        System.out.println("\n[예매 내역]");
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                int num = Integer.parseInt(sc.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.print("숫자를 입력해주세요: ");
            }
        }
    }
}
