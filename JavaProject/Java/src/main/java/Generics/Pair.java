package Generics;


//key , value 한 쌍을 가지고 있는 클래스
public class Pair<K,V> {
	private K key;
	private V value;
	
	//캡슐화하면 게터세터랑 투스트링은 무조건 만들어줘야함
	public Pair() {		
	}
	
    public Pair(K key,V value) {
    	this.key = key;
    	this.value = value;
    }

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Pair [key=" + key + ", value=" + value + "]";
	}
    
}
