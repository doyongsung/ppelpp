package dept.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dept.domain.Dept;
import jdbc.util.ConnectionProvider;

public class deptDaoTest {
	static Connection conn;
	static DeptDao dao;
	Dept dept;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		conn = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(expected =SQLIntegrityConstraintViolationException.class)
	public void testGetInsertDept() throws SQLException{
		int result =dao.insertDept(conn, new Dept(11,"insert","부천"));
		assertSame("insert 확인", result,1);
	}

	@Test
	public void testGetSelectByDept() {
		dept = dao.selectByDeptno(conn, 10);
		assertNotNull("deptno 확인",dept);
	}
	@Test
	public void testGetdeleteDept() {
	int result = dao.deleteDept(conn, 60);
	assertSame("deleteDept 확인", result,1);
	}
	@Test
	public void testGetupdateDept() {
		int result = dao.updateDept(conn, new Dept(30,"update","부천"));
		assertNotSame("update 확인", result,3);
	}
	@Test
	public void testGetDeptList() {
		List<Dept> list = dao.getDeptList(conn);
		assertNotNull("list 확인",list);
	}
	

}
