package ch11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListFootBallPlayer {

	public static void main(String[] args) {
		List<FootballPlayer> list = new ArrayList<>();
		
		list.add(new FootballPlayer("홍명보",9,"서울",20));
		list.add(new FootballPlayer("차두리",20,"부천",40));
		list.add(new FootballPlayer("박지성",10,"서울",30));
		list.add(new FootballPlayer("기성룡",5,"부천",25));
	
		
		
		Iterator<FootballPlayer> itr =list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		}

	
}
