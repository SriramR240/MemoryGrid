
package MemoryGrid;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class DB_Accessor 
{
	
	protected static String[]  getusername() throws IOException
	{
		
		String names[]= new String[GameSystem.no_of_users];
		int i=0;
		
		File file = new File("E:/Database.txt");
		Scanner sc = new Scanner(file);

		while(sc.hasNext()) {
			names[i]=sc.next();
			sc.next();
			i+=1;
		}
		
		sc.close();
		System.out.println("Access complete");
		return names;
	}
	
	protected static String[] getpassword() throws IOException
	{
		String pass[]= new String[GameSystem.no_of_users];
		int i=0;
				
		File file = new File("E:/Database.txt");
		Scanner sc = new Scanner(file);

		while(sc.hasNext()) {
			sc.next();
			pass[i]=sc.next();
			
			i+=1;
		}
		
		sc.close();
		System.out.println("Access complete");
		return pass;
	}

	

}
