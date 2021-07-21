package member;

import java.sql.Timestamp;

// 빈즈 클래스 생성
public class Member {

	// 변수는 모두 private 처리
	private int idx;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String regdate;
	
	
	public Member(int idx, String memberId, String memberPw, String memberName, String regdate) {
		this.idx = idx;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.regdate = regdate;
		
	}
	public Member( String memberId, String memberPw, String memberName) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
	}
	public Member() {}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Member [idx=" + idx + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", regdate=" + regdate + "]";
	}


	
	
	
	
	
}