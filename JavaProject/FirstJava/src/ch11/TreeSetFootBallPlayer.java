package ch11;

import java.util.*;


public class TreeSetFootBallPlayer {

	public static void main(String[] args) {
		TreeSet<FootballPlayer> treeSet = new TreeSet<>();
		
		treeSet.add(new FootballPlayer("기성롱",5,"부천",25));
		treeSet.add(new FootballPlayer("홍명보",9,"서울",20));
		treeSet.add(new FootballPlayer("차두리",20,"부천",40));
		treeSet.add(new FootballPlayer("기성룡",5,"부천",25));
		treeSet.add(new FootballPlayer("박지성",10,"서울",30));
		treeSet.add(new FootballPlayer("홍명보",8,"서울",27));
		

		Iterator<FootballPlayer> itr =treeSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}	
	}

	

}
