package MemoryGrid;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Login 
{
	Scanner scan= new Scanner(System.in);
	public String description="THe login module is used for logging into the system ";
	protected int usertype;
	
	
	public void Newuser(String username,String password) throws IOException
	{
		Authentication auth= new Authentication();
		auth.validate_username(username);
		while (auth.result==1)
		{
			System.out.println("Username already exists.TRy again");
			System.out.print("Enter your username:");
			username=scan.next();
			System.out.print("Enter the passwrod:");
			password=scan.next();
			
			auth.result=0;
			auth.validate_username(username);
		}
		
		
	}
	
	public void ExistingUser(String username,String password) throws IOException
	{
		Authentication auth= new Authentication();
		auth.validate_username(username);
		auth.validate_password(password);
		while (auth.result!=2)
		{
			System.out.println("Invalid Credentials");
			System.out.print("Enter your username:");
			username=scan.next();
			System.out.print("Enter the passwrod:");
			password=scan.next();
			
			auth.result=0;
			auth.validate_username(username);
			auth.validate_password(password);
		}
	}
	
	public void main(User u) throws IOException
	{
		
		
		//getting choice from the user
		int choice=0;
		
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
			Newuser(username,password);
			
			u.username=username;
			u.password=password;
			u.highscore=0;
			
			System.out.println("Loginover");
		}
		
		if (choice==2)
		{
			this.usertype=2;
			String username,password;
			System.out.print("Enter your username:");
			username=scan.next();
			System.out.print("Enter the passwrod:");
			password=scan.next();
			ExistingUser(username,password);
			
			
			System.out.println("Loginover");
			
		}
		
	}
}
