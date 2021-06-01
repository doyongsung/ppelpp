package ch11;

import java.util.*;

public class SetFootBallPlayer {

   
	public static void main(String[] args) {
		Set<FootballPlayer> hashSet = new HashSet<>();
		
		hashSet.add(new FootballPlayer("홍명보",9,"서울",20));
		hashSet.add(new FootballPlayer("기성룡",5,"부천",25));
		hashSet.add(new FootballPlayer("박지성",10,"서울",30));
		hashSet.add(new FootballPlayer("기성룡",5,"부천",25));
		
		
		
		Iterator<FootballPlayer> itr =hashSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		}

	

}
