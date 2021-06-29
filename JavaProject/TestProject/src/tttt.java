
//public class tttt {
//	import java.sql.ResultSet;
//	import java.sql.Statement;
//	import java.util.Scanner;
//
//	public class BuyOption {
//		private Scanner name;
//		private Scanner price;
//
//		void VendingMachine() {
//			BuyManager bmanager = new BuyManager(ProductListDao.getInstance());
//			ProductManager pManager = new ProductManager(ProductListDao.getInstance());
//
//			Scanner sc = new Scanner(System.in);
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//
//				while (true) {
//					System.out.println();
//					System.out.println("---------- 아주시원한 자판기 -----------");
//					bmanager.buyitemList();
//					System.out.println("-----------------------------------");
//					System.out.println("원하시는 음료 번호를 입력해주세요.");
//					int num = Integer.parseInt(sc.nextLine());
//					System.out.println("-----------------------------------");
//
//					// 콜라선택
//					
//					switch(num) {
//					case 1:
//						System.out.println("콜라를 선택하셨습니다.");
//						System.out.println("구매수량을 입력해주세요: ");
//						int qty = Integer.parseInt(sc.nextLine());
//						int total = qty * 700;
//						System.out.println("콜라 - " + qty+" 개 "+ total + "원 입니다.");
//						System.out.println("-----------------------------------");
//						System.out.println("1.추가구매 \t 2.종료 ");
//						int choice = Integer.parseInt(sc.nextLine());
//	                    if (choice == 1){					
//						} else {
//							System.out.println("감사합니다. 시원한 목축임 하세요 *^^*");
//							break;
//						}
//						break;
//					case 2:
//						System.out.println("사이다를 선택하셨습니다.");
//						break;
//					case 3:
//						System.out.println("마운틴듀를 선택하셨습니다.");
//						break;
//					case 4:
//						System.out.println("환타를 선택 하셨습니다.");
//						break;
//					case 5:
//						break;
//					}
//						
//					// 트랜젝션 처리하기 
//					// DB로 구매이력 insert -> 재고에 update
//
//					}
//				
//
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//	}
//}
