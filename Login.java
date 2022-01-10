package MemoryGrid;


import java.io.*;
import java.util.Scanner;


public class Login 
{
	
	public String description="THe login module is used for logging into the system ";
	protected int usertype;
	
	
	public int Newuser(String username,String password) throws IOException
	{
		Authentication auth= new Authentication();
		auth.validate_username(username);
		if(auth.result!=-1)
		{
			System.out.println("Username already exists");
			return 0;
		}
		
		auth.validate_password(password);
		if(auth.result!=-1)
		{
			System.out.println("password already taken");
			return 0;
		}
		
		
		return 1;
		
	}
	
	public int ExistingUser(String username,String password) throws IOException
	{
		Authentication auth= new Authentication();
		auth.validate_username(username);
	
		if(auth.result==-1)
		{
			System.out.println("Username does not exist");
			return 0;
		}
		int temp=auth.result;
		auth.validate_password(password);
		if(auth.result==-1 || auth.result!=temp)
		{
			System.out.println("password does not match");
			return 0;
		}
		return 1;
	}
	
	public void main(User u) throws IOException
	{
		
		Scanner scan= new Scanner(System.in);
		//getting choice from the user
		String choice;
		
		while (true)
		{
		choice="";
		while (!choice.equals("1") && !choice.equals("2"))
		{
			System.out.println("Press 1 if you are a new player");
			System.out.println("Press 2 if you are an existing player");
			choice =scan.nextLine();
							
		}
				
		if (choice.equals("1"))
		{
			this.usertype=1;
			String username,password;
			System.out.print("Enter your username:");
			username=scan.nextLine();
			System.out.print("Enter the passwrod:");
			password=scan.nextLine();
			
			if(Newuser(username,password)==1)
			{
				System.out.println("here");
				u.username=username;
				u.password=password;
				
				System.out.println("Loginover");
				break;
			
			}
			

		}
		
		else
		{
			this.usertype=2;
			String username,password;
			System.out.print("Enter your username:");
			username=scan.nextLine();
			System.out.print("Enter the passwrod:");
			password=scan.nextLine();
			if (ExistingUser(username,password)==1)
			{
				u.username=username;
				u.password=password;
				
				System.out.println("Loginover");
				break;
			}
			
		}

		
		}
		
		
		return;
	}
	
}
