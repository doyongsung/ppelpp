package member.main;

import javax.imageio.spi.RegisterableService;

import member.dao.GuestDao;
import member.dao.MemberDao;
import member.service.ChangePasswordService;
import member.service.MemberRegService;

public class Assembler {

	// 컨테이너 : 인스턴스를 관리 -> 생성, 보관, 실행, 필요한 객체를 반환, 소멸
	// 조립기 클래스의 역할
	// 각가의 인스턴스를 생성
	// 의존 주입을 해준다.
	// 필요한 객체를 반환 해주는 기능

	private MemberDao dao;
	private MemberRegService regService;
	private ChangePasswordService passwordService;
	
	private GuestDao gDao;

	public Assembler() {
		// 인스턴스를 생성 -> 의존 주입
		dao = new MemberDao();
		gDao = new GuestDao();
		
		regService = new MemberRegService(dao);
		passwordService = new ChangePasswordService(dao);
	}

	public MemberDao getDao() {
		return dao;
	}

	public MemberRegService getRegService() {
		return regService;
	}

	public ChangePasswordService getPasswordService() {
		return passwordService;
	}

}
