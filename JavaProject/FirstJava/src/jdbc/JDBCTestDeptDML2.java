		package jdbc;


		import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;
import java.util.Scanner;

public class JDBCTestDeptDML2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 연결 객체 : 연결 정보를 가진다.
		Connection conn = null;
		// sql을 실행 할  메소드 제공
		Statement stmt = null;
		// executeQuery() 반환타입 -> select의 결과(표)를 담는 객체 
		ResultSet rs = null;
		//Statement -> PreparedStatement  : 성능개선
		PreparedStatement pstmt = null;
		
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공!");
			
			// 2. 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("데이터베이스 연결 성공!!!");
			
			// 트렌젝션 설정
			conn.setAutoCommit(false);
			
			
			System.out.println("부서 정보의 삭제를 시작합니다.");
			System.out.println("부서 번호를 입력해주세요.");
			String deptno = sc.nextLine();
			
			
			
			// 3. sql 처리
			// 사용자에게 정보를 받아 부서 데이터를 입력하는 프로그램을 만들어보자
			String sql = "delete from dept01 where deptno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(deptno));
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println(result+"개 행이 삭제되었습니다.");
			} else {
				System.out.println("조건에 맞는 데이터가 존재하지 않습니다.");
			}
			
			
			
			
			
			
			
			
			// 트렌젝션 완료(성공)
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
			
			// 4. close
			
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
