package Collections;

import java.util.Objects;

public class Point {

	//2차원 점을 나타내는 클래스 x좌표와 y좌표가 있다.
	
	private int x;
	private int y;
	
	public Point() {}
	
	public Point(int x, int y) {
		this.x =x;
		this.y =y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	@Override
	public int hashCode() {
	  return Objects.hash(x,y);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point other = (Point)obj;
			return this.x == other.getX() && this.y == other.getY();
		}
		return false;
	}
	
	
}
