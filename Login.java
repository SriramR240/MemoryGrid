package MemoryGrid;


import java.io.*;
import java.util.*;


public class Login 
{
	Scanner scan= new Scanner(System.in);
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
		
		
		//getting choice from the user
		int choice;
		
		while (true)
		{
		choice=0;
		while (choice!=1 && choice!=2)
		{
			System.out.println("Press 1 if you are a new player");
			System.out.println("Press 2 if you are an existing player");
			choice =scan.nextInt();
							
		}
				
		if (choice==1)
		{
			this.usertype=1;
			String username,password;
			System.out.print("Enter your username:");
			username=scan.next();
			System.out.print("Enter the passwrod:");
			password=scan.next();
			
			if(Newuser(username,password)==1)
			{
				System.out.println("here");
				u.username=username;
				u.password=password;
				u.highscore=0;
				System.out.println("Loginover");
				break;
			
			}
			

		}
		
		else
		{
			this.usertype=2;
			String username,password;
			System.out.print("Enter your username:");
			username=scan.next();
			System.out.print("Enter the passwrod:");
			password=scan.next();
			if (ExistingUser(username,password)==1)
			{
				u.username=username;
				u.password=password;
				u.highscore=0;
				System.out.println("Loginover");
				break;
			}
			
		}
		
		}
		return;
	}
	
}
