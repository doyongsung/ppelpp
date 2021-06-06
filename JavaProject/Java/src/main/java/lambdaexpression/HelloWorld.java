package lambdaexpression;

public class HelloWorld {
	
	public void go() {
		//영어 인사를 하기 위해서 Greeting을 구현한 영엉니사 로컬 클래스를 만든다.
		class EnglishGreeting implements Greeting{
			@Override
			public void greet() {
				System.out.println("Hello");
			}
		}
		Greeting englishGreeting = new EnglishGreeting();
		sayHello(englishGreeting); //Hello
		
		//프랑스어 인사는 Anonymous class(이름없는 클래스를)사용한다.
		Greeting frenchGreeting = new Greeting() {
			
			@Override
			public void greet() {
				// TODO Auto-generated method stub
				System.out.println("Bonjour");
			}
		};
		sayHello(frenchGreeting); //Bonjour;
		
		//스페인어 인사는 anonymous class를 메서드 인자에 직접 삽입
		sayHello(new Greeting() {
			
			@Override
			public void greet() {
				// TODO Auto-generated method stub
				System.out.println("Hola");
			}
		});//Hola
		
		//한국어 인사는 Lambda expreesion을 사용한다.
		//functional interface를 구현한 오브젝트는 lambda expression으로 바꿀 수 있다.
		sayHello(() -> {
			System.out.println("안녕하세요");
		});
	}
	//Functional interface Greeting의 greet() 메서드를 수행하는 메서드
	public void sayHello(Greeting greeting) {
		greeting.greet();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
