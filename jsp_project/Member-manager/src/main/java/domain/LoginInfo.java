package domain;

public class LoginInfo {

	private int idx;
	private String memberId;
	private String memberName;


public LoginInfo(int idx, String memberId, String memberName) {
	this.idx = idx;
	this.memberId = memberId;
	this.memberName = memberName;
}


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


public String getMemberName() {
	return memberName;
}


public void setMemberName(String memberName) {
	this.memberName = memberName;
}


@Override
public String toString() {
	return "LoginInfo [idx=" + idx + ", memberId=" + memberId + ", memberName=" + memberName + "]";
}



}
