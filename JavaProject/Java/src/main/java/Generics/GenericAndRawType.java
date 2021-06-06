package Generics;

public class GenericAndRawType {

	public static void main(String[] args) {
		SimpleBox box = new SimpleBox();
		box.set(5);
		Integer N1 = (Integer)box.get();
		
		box.set("choi");
		String s1 = (String) box.get();
		
		Box<Integer> integerBox = new Box<Integer>();
		integerBox.set(5);
		int n2 = integerBox.get();
		
		Box rawBox = new Box();
		rawBox.set(5);
		Integer n3 = (Integer) rawBox.get();
	}

	
}
 class SimpleBox {
private Object object;

public void set(Object object) {
	this.object = object;
}

public Object get() {
	return object;
}
}

