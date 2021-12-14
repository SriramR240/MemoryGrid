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
		pass1=scan.next();
		System.out.println("retype new password");
		pass2=scan.next();
		
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
		int difficulty;
		System.out.println("Enter 1 for easy");
		System.out.println("Enter 2 for moderate");
		System.out.println("Enter 3 for hard");
		difficulty=scan.nextInt();
		
		if (difficulty>0 && difficulty<4)
		{
			int mode;
			System.out.println("Enter 1 for cranky mode");
			System.out.println("otherwise its in normal mode");
			mode=scan.nextInt();
			
			if (mode==1)
			{
				Grid.mode=1;
			}
			else
			{
				Grid.mode=0;
			}
			Grid.dimension=difficulty;
			
		}
		else
		{
			System.out.println("invalid input");
		}
		
		
		
	}

	public void main(User u) throws IOException
	{
		
		int choice;
		
		while (true)
		{
		choice=0;
		while (choice>4 || choice<1) 
		{
			System.out.println("Press 1 to change difficulty and mode");
			System.out.println("Press 2 to change theme");
			System.out.println("Press 3 to chnage password");
			System.out.println("Press 4 to return to main menu");
			choice =scan.nextInt();
		}
		
		if (choice==1)
		{
			changediff();
		}
		
		else if (choice==2)
		{
			//
		}
		else if (choice==3) 
		{
			changepassword(u);
		}
		else
		{
			System.out.println("Retuning to main menu...");
			break;
		}
		
		}
		
		return;

	}

}
