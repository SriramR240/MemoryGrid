
package MemoryGrid;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.*;

public class DB_Accessor 
{
	
	protected static String[]  getusername() throws IOException
	{
		
		String names[]= new String[GameSystem.no_of_users];
		int i=0;
		
		File file = new File("E:/Username.txt");
		Scanner sc = new Scanner(file);

		while(sc.hasNext()) {
			names[i]=sc.next();
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
				
		File file = new File("E:/Password.txt");
		Scanner sc = new Scanner(file);

		while(sc.hasNext()) {
			pass[i]=sc.next();
			
			i+=1;
		}
		
		sc.close();
		System.out.println("Access complete");
		return pass;
	}
	
	protected static void setpassword(int lineNumber,String data) throws IOException
	{
		Path path = Paths.get("E:/Password.txt");
	    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
	    lines.set(lineNumber - 1, data);
	    Files.write(path, lines, StandardCharsets.UTF_8);
	}

	

}
