package MemoryGrid;

import java.util.Scanner;
import java.io.*;

public class Mainer {
	
	public static void main(String args[]) throws IOException
	{
		//Just a message
		System.out.println("Hello,Welcome to the GAME.Enjoy yourself");
		
		//Initializing the Game System and a User
		GameSystem GS= new GameSystem();
		User u=new User();
		
		//Getting game info
		File Sysfile = new File("E:/Systeminfo.txt");
		Scanner sc = new Scanner(Sysfile);
		GameSystem.no_of_users=sc.nextInt();
		sc.close();
		
		//Login process start
		GS.L.main(u);
		if (GS.L.usertype==1)
		{
			GameSystem.no_of_users+=1;
			GS.reflect_data(u);
		}
		//Login process end
		
		int i=GS.m.main(u);
		
		if(i==4) //Quit condition
		{
			return;
		}
		
		
		
	}

}
