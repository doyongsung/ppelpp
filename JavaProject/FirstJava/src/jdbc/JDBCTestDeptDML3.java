		package jdbc;


		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;
import java.util.Scanner;

public class JDBCTestDeptDML3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
				//연결 객체: 연결 정보를  가진다.
				Connection conn = null;
				// sql을 실행 할 메소드 제공
				Statement stmt = null;
				//executeQuery() 반환타입 -> select의 결과(표)를 담는 객체
				ResultSet rs = null;
				//Statement -> PreparedStatement : 성능개선
				PreparedStatement pstmt = null;
				
				
				// 1. 드라이버 로드
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					System.out.println("드라이버 로드 성공!!!");
					
				// 2. 연결
					String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
					String user = "hr";
					String pw = "tiger";
					
					conn = DriverManager.getConnection(jdbcUrl, user, pw);
					System.out.println("데이터베이스 연결 성공!!!");
					
					// 트랜잭션 설정
					conn.setAutoCommit(false);
				
					// 사용자에게 정보를 받아 데이터를 수정
					// 10 dev seoul ==> " "
					System.out.println("부서 데이터의 수정을 시작합니다.");
					System.out.println("10 dev seoul 형식으로 데이터를 입력해 주세요.");
					String input = sc.nextLine();
					
					// String[]
					String[] inputs = input.split(" ");
					
//					for(String str : inputs) {
//						System.out.println(str);
//					}
					
					String sql = "update dept01 set dname=? , loc=? where deptno = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, inputs[1]);
					pstmt.setString(2, inputs[2]);
					pstmt.setInt(3, Integer.parseInt(inputs[0]));
					
					
					int result = pstmt.executeUpdate();
					
					if(result > 0) {
						System.out.println("수정되었습니다.");
					} else {
						System.out.println("찾으시는 부서가 존재하지 않습니다.");
					}
					//pstmt = 
				//트렌젝션 완료(성공)
				conn.commit();
					
				} catch (ClassNotFoundException e) {
					System.out.println("드라이버 클래스를 찾지못함!!!");
					e.printStackTrace();
				} catch (SQLException e) {
					//System.out.println("데이터베이스 연결 실패!!!");
					
					try {
						conn.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					e.printStackTrace();
				} finally {
					
					//4. close
					
					
					if(rs != null) {
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					if(stmt != null) {
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				
				
			}

		}
