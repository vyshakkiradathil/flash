package oops;

import java.util.ArrayList;
import java.util.List;

public class CollectionFunction {
	public static void main(String [] args) {
		List<String> team1=new ArrayList<String>();
		team1.add("Sachin");
		team1.add("Virat");
		team1.add("Aswin");
		System.out.println("Team1 is : "+team1);
		System.out.println("Size of Team1 is : " + team1.size());
		List<String> team2=new ArrayList<String>();
		team2.add("Viru");
		team2.add("Aswin");
		team2.add("Jadeja");
		team2.add(1,"Yuvraj");
		System.out.println("Team2 is : "+team2);
		System.out.println("Size of Team2 is : " + team2.size());
		team1.addAll(team2);
		System.out.println("Team1 after adding Team2 : "+team1);
		team1.remove(1);
		System.out.println("Team1 after removie [1] : "+team1);
		System.out.println("Team1 contains Sachin :"+team1.contains("Sachin"));
		System.out.println("Team1 is empty : " + team1.isEmpty());
        team1.removeAll(team2);
        System.out.println(team1); 
        team1.clear();
        System.out.println("Team1 is empty : " + team1.isEmpty());
	}

}
