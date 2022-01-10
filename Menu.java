package MemoryGrid;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public String description="This class represents the main menu for the system";
	
	private Settings s= new Settings();
	
	
	private void startgame()
	{
		System.out.println("Starting the Game...");
		String diff;
		String mode;
		if (Grid.cd==240)
		{
			diff="Easy";
		}
		else if (Grid.cd==160)
		{
			diff="Medium";
		}
		else
		{
			diff="Hard";
		}
		System.out.println("Difficulty level:"+diff);
		
		if (Grid.mode==1)
		{
			mode="Cranky";
		}
		else
		{
			mode="Normal";
		}
		System.out.println("Mode"+mode);
	}
	
	private void endgame()
	{
		System.out.println("Quitting the game...");
		System.exit(0);
	}
	
	public int main(User u) throws IOException
	{
		
		Scanner scan= new Scanner(System.in);
		String choice;
		
	
		while (true)
		{
			choice=" ";
		
			System.out.println("Press 1 to start the game");
			System.out.println("Press 2 to change settings");
			System.out.println("Press 3 to get leaderboard");
			System.out.println("Press 4 to end game");
			choice =scan.nextLine();
			
		
			if (choice.equals("1"))
			{
				startgame();
				break;
			}
		
			else if (choice.equals("2"))
			{
				s.main(u);
			}
			else if (choice.equals("3"))
			{
				GameSystem.getdata();
			}
			else if (choice.equals("4"))
			{
				
				endgame();
				break;
			
			}
			else
			{
				System.out.println("Invalid choice.Try again");
			}
		
		
		}
		System.out.println("returning");
		return Integer.parseInt(choice);
		

	};

}
