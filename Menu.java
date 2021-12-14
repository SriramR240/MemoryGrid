package MemoryGrid;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public String description="This class represents the main menu for the system";
	
	private Settings s= new Settings();
	
	public int main(User u) throws IOException
	{
		
		Scanner scan= new Scanner(System.in);
		int choice=0;
		
		while (true)
		{
		choice=0;
		while (choice>4 || choice<1) 
		{
			System.out.println("Press 1 to start the game");
			System.out.println("Press 2 to change settings");
			System.out.println("Press 3 to get leaderboard");
			System.out.println("Press 4 to end game");
			choice =scan.nextInt();
		}
		
		if (choice==1)
		{
			System.out.println("Starting the Game...");
			scan.close();
			break;
		}
		
		else if (choice==2)
		{
			s.main(u);
		}
		else if (choice==3)
		{
			//leaderboard goes here
		}
		else
		{
			System.out.println("Quitting the game...");
			scan.close();
			break;
			
		}
		
		
		}
		
		return choice;
		

	};

}
