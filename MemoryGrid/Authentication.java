package MemoryGrid;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Authentication {
	
	public String description="The autentication module is used to authenticate the username and password in the database";
	protected int result=0;
	
	protected void validate_username(String username) throws IOException
	{
		String names[]=DB_Accessor.getusername();
		for(int i=0;i<GameSystem.no_of_users;i++)
			
		{
			
			if (username.equals(names[i]))
			{
				this.result+=1;
				System.out.println("Authentication over");
				return;
			}
		}
		this.result+=0;
		System.out.println("Authentication over");
		return;
	
		
	}
	
	protected void validate_password(String password) throws IOException
	{
		String pass[]=DB_Accessor.getpassword();
		for(int i=0;i<GameSystem.no_of_users;i++)
			
		{
			
			if (password.equals(pass[i]))
			{
				this.result+=1;
				System.out.println("Authentication over");
				return;
			}
		}
		
		this.result+=0;
		System.out.println("Authentication over");
		return;
		
	}
	

			

}
