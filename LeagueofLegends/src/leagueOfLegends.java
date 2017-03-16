import java.util.List;
import java.util.Scanner;

import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.QueueType;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.summoner.Summoner;
import com.robrua.orianna.type.core.league.League;
import com.robrua.orianna.type.core.staticdata.Champion;



public class leagueOfLegends 
{
	static Scanner summonerName = new Scanner(System.in);
	
    public static void main(String[] args) {
    	RiotAPI.setRegion(Region.NA); // Testing API in NA reigon ONLY
        RiotAPI.setAPIKey("e06f9d1d-10f9-4cc4-b0ce-63a1ccc9d647"); // My API key
        
        System.out.println("Welcome to a League of Legends Summoner Database!");//Welcome message!
        System.out.println("");
        
    	System.out.println("Please enter a Summoner name: "); // User to enter summoner name
    	String a = summonerName.nextLine(); 
    	Summoner summoner = RiotAPI.getSummonerByName(a);
    	
    	
    	/*OUTPUT-- Thanks to user input, we are granted access to more Summoner information!*/
    	System.out.println("");
    	System.out.println(summoner.getName() + ", ID# " + summoner.getID() + ", is a level " + summoner.getLevel() + " summoner on the NA server.");
       
        long b = summoner.getLevel(); //BIG FACTOR TO THE CODE
        
        
        /*Level 30 player vs non-level 30 player*/
        if (b == 30) {
        	System.out.println("Player is level 30, and therefore can play Ranked games.");
        	System.out.println("");
        	
        }
        else {
        	System.out.println("Player is not level 30, therefore this summoner cannot play Ranked");
        	System.out.println("Once this summoner is level 30, they will likely be ranked Bronze after completing placement matches (unless this is a Smurf account).");
        	System.out.println("");
        }
        
        
        List<Champion> champions = RiotAPI.getChampions(); //APPLICABLE TO ALL PLAYERS, REGARDLESS OF LEVEL
        System.out.println("This summoner has played againt multiple champions, one champion being: " + champions.get((int)(champions.size() * Math.random())) + ".");
        System.out.println("");
        
        /*Level 30 player vs non-level 30 player*/
        League challenger = RiotAPI.getChallenger(QueueType.RANKED_SOLO_5x5);
        Summoner bestNA = challenger.getEntries().get(0).getSummoner();
        
        if (b == 30) {
        	System.out.println("This player might be good, but they definitely aren't as good as " + bestNA + ".");
        }
        else {
        	System.out.println("Unless this is a Smurf account, this player will definitely not be as good as " + bestNA + ".");
        }
    }
}	

    