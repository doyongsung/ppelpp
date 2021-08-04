package member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import member.dao.Dao;
import member.domain.Member;

public class ChangePasswordService2 {
	
	@Autowired
	@Qualifier("member")
	private Dao dao;
	
	public void changePassword(String email, String oldPw, String newPw) throws Exception {
		
		System.out.println("change : " + email);
		
		Member member = dao.selectByEmail(email);
		
		if(member == null) {
			throw new Exception("존재하지않는 회원!");
		}
		
		member.changePassword(oldPw, newPw);
			
		dao.update(member);
		
	}
	

}
