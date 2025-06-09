//package vendingMachine.service;
//
//import vendingMachine.drink.Drink;
//
//
//public class DrinkService {
//
//    public static void drinkAdd(String name, int n) {
//        for (Drink d : drinkRepository.drink) {
//            if (d.getDrinkName().equals(name)) {
//                d.setDrinkNum(d.getDrinkNum()+n);
////                System.out.println(d.getDrinkName()+" "+d.getDrinkNum());
//                break;
//            }
//        }
//    }
//
//    public static Object findOne(String name) {
//        for (Drink d : Drink.drink) {
//            if (d.getDrinkName().equals(name)) {
//                return d.getDrinkName() + d.getDrinkNum() + d.getDrinkPrice();
//            }
//        }
//        return "존재하지 않습니다.";
//    }
//
//
//    public void findAll() {
//        for (int i=0; i<drink; i++) {
//            System.out.println("name: "+ drink[i].getDrinkName());
//            System.out.println("num: "+ drink[i].getDrinkNum());
//            System.out.println("price: "+ drink[i].getDrinkPrice());
//        }
//    }
//
//
//}
