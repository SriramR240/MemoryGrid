package MemoryGrid;

import java.util.Scanner;
import java.io.*;

public class Settings {
	
	Scanner scan= new Scanner(System.in);
	public String description="This module is used to chnage the settings of the game";
	
	public void changepassword(User u) throws IOException
	{
		Authentication auth= new Authentication();
		String pass1;
		String pass2;
		
		System.out.println("Enter new pasword");
		pass1=scan.nextLine();
		System.out.println("retype new password");
		pass2=scan.nextLine();
		
		if (pass1.equals(pass2))
		{
			auth.validate_password(pass1);
			if (auth.result!=-1)
			{
				System.out.println("password already taken");
				return;
			}
			else
			{
				auth.validate_password(u.password);
				DB_Accessor.setpassword(auth.result+1, pass1);
				return;
			}
		}
		else
		{
			System.out.println("passwords does not match");
		}
		System.out.println("here");
		return;
		
	}
	
	public void changediff()
	{
		String difficulty;
		System.out.println("Enter 1 for easy");
		System.out.println("Enter 2 for moderate");
		System.out.println("Enter 3 for hard");
		difficulty=scan.nextLine();
		boolean proceed=true;
		
		switch(difficulty)
		{
			
			case "1":
				Grid.cd=240;
				if (GameSystem.theme_no==0)
				{
					GameSystem.theme="./src/MemoryGrid/Image_links/house_easy.txt";
				}
				else
				{
					GameSystem.theme="./src/MemoryGrid/Image_links/emoji_easy.txt";
				}
				break;
			case "2":
				Grid.cd=160;
				if (GameSystem.theme_no==0)
				{
					GameSystem.theme="./src/MemoryGrid/Image_links/house_medium.txt";
				}
				else
				{
					GameSystem.theme="./src/MemoryGrid/Image_links/emoji_medium.txt";
				}
				break;
			case "3":
				Grid.cd=120;
				if (GameSystem.theme_no==0)
				{
					GameSystem.theme="./src/MemoryGrid/Image_links/house_hard.txt";
				}
				else
				{
					GameSystem.theme="./src/MemoryGrid/Image_links/emoji_hard.txt";
				}
				break;
			default:
				System.out.println("Invalid input");
				proceed=false;
				break;
			
		}
		
		if (proceed)
		{
			changemode();
		}
		
		
	}
	
	public void changemode()
	{
		
			String mode;
			System.out.println("Enter c for cranky mode");
			System.out.println("otherwise its in normal mode");
			mode=scan.nextLine();
			
			if (mode.equals("c"))
			{
				Grid.mode=1;
			}
			else
			{
				Grid.mode=0;
			}
			
			
		
		
	}
	
	public void changetheme()
	{
		String choice;
		System.out.println("Select any one of the folowing themes");
		System.out.println("Enter e for emoji theme");
		System.out.println("otherwise its home(default) theme");
		choice=scan.nextLine();
		if (choice.equals("e"))
		{
			GameSystem.theme_no=1;
			if (Grid.cd==240)
			{
				GameSystem.theme="./src/MemoryGrid/Image_links/emoji_easy.txt";
			}
			else if (Grid.cd==160)
			{
				GameSystem.theme="./src/MemoryGrid/Image_links/emoji_medium.txt";
			}
			else
			{
				GameSystem.theme="./src/MemoryGrid/Image_links/emoji_hard.txt";
			}
			
		}
		else
		{
			GameSystem.theme_no=0;
			if (Grid.cd==240)
			{
				GameSystem.theme="./src/MemoryGrid/Image_links/house_easy.txt";
			}
			else if (Grid.cd==160)
			{
				GameSystem.theme="./src/MemoryGrid/Image_links/house_medium.txt";
			}
			else
			{
				GameSystem.theme="./src/MemoryGrid/Image_links/house_hard.txt";
			}
			
		}
		
		
	}
	

	public void main(User u) throws IOException
	{
		
		String choice;
		
		while (true)
		{
			choice=" ";
	
			System.out.println("Press 1 to change difficulty and mode");
			System.out.println("Press 2 to change theme");
			System.out.println("Press 3 to change password");
			System.out.println("Press 4 to return to main menu");
			choice =scan.nextLine();
		
		
		if (choice.equals("1"))
		{
			changediff();
		}
		
		else if (choice.equals("2"))
		{
			changetheme();
		}
		else if (choice.equals("3")) 
		{
			changepassword(u);
		}
		else if (choice.equals("4"))
		{
			System.out.println("Retuning to main menu...");
			break;
		}
		else
		{
			System.out.println("Invalid input.try again");
		}
		
		}
		
		
		
		return;

	}

}
