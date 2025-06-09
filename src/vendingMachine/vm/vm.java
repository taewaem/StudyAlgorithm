//package vendingMachine.vm;
//
//import vendingMachine.admin.Admin;
//import vendingMachine.coin.Coin;
//import vendingMachine.drink.Drink;
//import vendingMachine.service.AdminService;
//import vendingMachine.service.CoinService;
//import vendingMachine.service.DrinkService;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//
//public class vm {
//
//    public static Drink[] drink = new Drink[]{
//            new Drink("water", 5, 450),
//            new Drink("canCoffee", 5, 500),
//            new Drink("energy", 5, 550),
//            new Drink("coffee", 5, 700),
//            new Drink("cock", 5, 1000)
//    };
//
//
//
//    private static Admin admin = new Admin("admin1234");
//    private static AdminService adminService;
//    private static DrinkService drinkService;
//    private static CoinService coinService;
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        HashMap<String, String> drinkHashMap = new HashMap<>();
//        HashMap<String, String> coinHashMap = new HashMap<>();
//        Long sequence = 0L;
//
//        System.out.println("실행 할 프로그램을 확인하세요");
//        System.out.println("1, 관리자 메뉴");
//        System.out.println("2. 음료 구매");
//        int n = Integer.parseInt(br.readLine());
//
//        switch (n) {
//            case 1:
//                System.out.println("관리자 비밀번호를 입력하세요:");
//                String password = br.readLine();
//                if (password.equals(admin.getPassword())) {
//                    System.out.println("관리자 로그인 성공");
//                    do {
//                        drinkService.findAll(Drink.drink);
//                        System.out.println("실행할 명령을 선택하세요");
//                        System.out.println("1. 음료 재고 보충");
//                        System.out.println("2. 동전 추가");
//                        System.out.println("3. 수금");
//                        System.out.println("4. 종료");
//                        int adminN = Integer.parseInt(br.readLine());
//                        switch (adminN) {
//                            case 1:
//                                System.out.println("음료 이름을 입력하세요");
//                                String dName = br.readLine();
//                                System.out.println("추가 할 음료 개수을 입력하세요");
//                                int dNum = Integer.parseInt(br.readLine());
//                                drinkService.drinkAdd(dName, dNum);
////                                drinkService.findDrinks();
//                                break;
//                            case 2:
////                                int coin = Integer.parseInt(br.readLine());
////                                coinService.coinAdd(coin);
//                                break;
//                            case 3:
////                                coinService.coinDevice(coin);
//                                break;
//                            case 4:
//                                break;
//                        }
//                    } while (true);
//
//                }
//                else
//                    System.out.println("관리자 로그인 실패");
//                break;
//            case 2:
//                System.out.println("음료 구매 페이지");
//                break;
//
//        }
//
//    }
//}
