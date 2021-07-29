package guest.exception;

public class InvalidPasswordException extends Exception{

	public InvalidPasswordException() {
		super("비밀번호가 틀렸습니다.");
	}

	
}
