package MemoryGrid;


import java.io.*;
import java.util.*;

public class GameSystem 
{
	public static String description="The system module is the secondary actor which is "
			+ "respnsoble for running the game";
	protected static int no_of_users;
	
	protected Login L = new Login();
	
	protected Authentication Auth = new Authentication();
	
	protected Menu m= new Menu();
	
	protected static String theme="./src/MemoryGrid/Image_links/house_easy.txt";
	protected static int theme_no=0;

	
	//Used to reflect Game System data (No_of_users and user data)
	protected void reflect_data(User u) throws IOException
	{
		
		
			Writer wr = new FileWriter("./src/MemoryGrid/Database/Systeminfo.txt");
			wr.write(GameSystem.no_of_users + "");
			wr.close();
			
			DB_Accessor.adduser(u.username,u.password);
		
	    
	}
	
	protected static void getdata() throws IOException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 for easy level\nEnter 2 for medium level\nEnter 3 for hard level");
		String path="";
		String choice1=sc.nextLine();
		if (choice1.equals("1") || choice1.equals("2") || choice1.equals("3"))
		{
			System.out.println("Enter c or cranky mode.anything else for normal mode");
			String choice2=sc.nextLine();
			if (choice2.equals("c"))
			{
				switch(choice1)
				{
					case "1":
						path="./src/MemoryGrid/Database/easy_cranky_scores.txt";
						break;
					case "2":
						path="./src/MemoryGrid/Database/medium_cranky_scores.txt";
						break;
					case "3":
						path="./src/MemoryGrid/Database/hard_cranky_scores.txt";
						break;
						
				}
			}
			else
			{
				switch(choice1)
				{
					case "1":
						path="./src/MemoryGrid/Database/easy_normal_scores.txt";
						break;
					case "2":
						path="./src/MemoryGrid/Database/medium_normal_scores.txt";
						break;
					case "3":
						path="./src/MemoryGrid/Database/hard_normal_scores.txt";
						break;
						
				}
			}
			DB_Accessor.getleaderborad(path);
			
		}
		else
		{
			System.out.println("Invalid input");
		}
		
		
	}
	

	//used to modify the leaderboard
	protected static void reflect_data(Time t1,User u) throws IOException
	{
		String path="";
		
		if (Grid.cd==240)
		{
			if (Grid.mode!=1)
			{
				path="./src/MemoryGrid/Database/easy_normal_scores.txt";
			}
			else
			{
				path="./src/MemoryGrid/Database/easy_cranky_scores.txt";
			}
		}
		else if (Grid.cd==160)
		{
			if (Grid.mode!=1)
			{
				path="./src/MemoryGrid/Database/medium_normal_scores.txt";
			}
			else
			{
				path="./src/MemoryGrid/Database/medium_cranky_scores.txt";
			}
			
		}
		else if (Grid.cd==120)
		{
			if (Grid.mode!=1)
			{
				path="./src/MemoryGrid/Database/hard_normal_scores.txt";
			}
			else
			{
				path="./src/MemoryGrid/Database/hard_cranky_scores.txt";
			}
		}
		else
		{
			return;
		}
		
		FileInputStream fis=new FileInputStream(path);       
		Scanner fsc=new Scanner(fis);
		String data[];
		String raw_data="";
		int changed=-1;
		boolean matched=false;
		
		while (fsc.hasNext())
		{
			raw_data+=fsc.nextLine()+" ";
		}
		
		fsc.close();
		
		data=raw_data.split(" ");
		
		int score3=Integer.parseInt(data[1]);
		int score2=Integer.parseInt(data[3]);
		int score1=Integer.parseInt(data[5]);
		
		if (data[0].equals(u.username))
		{
			if (score3>t1.timepassed)
			{
				score3=(int)t1.timepassed;
				data[1]=Long.toString(t1.timepassed);
				changed=3;
			}
			matched=true;
			
			
		}
		
		else if (data[2].equals(u.username))
		{
			if (score2>t1.timepassed)
			{
				score2=(int)t1.timepassed;
				data[3]=Long.toString(t1.timepassed);
				changed=2;
				
			}
			matched=true;
			
		}
		else if (data[4].equals(u.username))
		{
			if (score1>t1.timepassed)
			{
				score1=(int)t1.timepassed;
				data[5]=Long.toString(t1.timepassed);
				changed=1;
			}
			matched=true;
			
			
		}
		else
		{
			
		}
		
		
		if (matched==true)
		{
			if (changed==1 || changed==-1)
			{
				//do nothing
			}
			else if (changed==2)
			{
				if (score2<score1)
				{
					data[2]=data[4];
					data[3]=data[5];
					data[4]=u.username;
					data[5]=Long.toString(t1.timepassed);
				}
			}
			else
			{
				if (score3<score2)
				{
					
					data[0]=data[2];
					data[1]=data[3];
					data[2]=u.username;
					data[3]=Long.toString(t1.timepassed);
					
					if (score3<score1)
					{
						data[2]=data[4];
						data[3]=data[5];
						data[4]=u.username;
						data[5]=Long.toString(t1.timepassed);
					}
				}
			}
		}
		else
		{
			
			if(t1.timepassed<score3)
			{
				if (t1.timepassed<score2)
				{
					data[0]=data[2];
					data[1]=data[3];
				
					if (t1.timepassed<score1)
					{
						data[2]=data[4];
						data[3]=data[5];
						data[4]=u.username;
						data[5]=Long.toString(t1.timepassed);
					
					}
					else
					{
					
						data[2]=u.username;
						data[3]=Long.toString(t1.timepassed);
					
					}
				}
				else
				{
					data[0]=u.username;
					data[1]=Long.toString(t1.timepassed);
				}
			
			}
		}
		
		
		PrintWriter writer = new PrintWriter(path);
		writer.print(data[0]+" "+data[1]+"\n");
		writer.print(data[2]+" "+data[3]+"\n");
		writer.print(data[4]+" "+data[5]+"\n");
		writer.close();
		
	
		
			
	}
	
	
}


