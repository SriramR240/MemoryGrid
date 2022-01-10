
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
		
		File file = new File("./src/MemoryGrid/Database/Username.txt");
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
				
		File file = new File("./src/MemoryGrid/Database/Password.txt");
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
		Path path = Paths.get("./src/MemoryGrid/Database/Password.txt");
	    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
	    lines.set(lineNumber - 1, data);
	    Files.write(path, lines, StandardCharsets.UTF_8);
	}
	
	protected static void adduser(String name,String password) throws IOException
	{
		FileWriter fw = new FileWriter("./src/MemoryGrid/Database/Username.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out = new PrintWriter(bw);
		out.println(name);
		out.close();
    
		FileWriter fw2 = new FileWriter("./src/MemoryGrid/Database/Password.txt", true);
		BufferedWriter bw2 = new BufferedWriter(fw2);
		PrintWriter out2 = new PrintWriter(bw2);
		out2.println(password);
		out2.close();
	}
	
	protected static void getleaderborad(String path) throws IOException
	{
		FileInputStream fis=new FileInputStream(path);       
		Scanner sc=new Scanner(fis);
		String raw_data="";
		
		while (sc.hasNext())
		{
			raw_data+=sc.nextLine()+" ";
		}
		System.out.println(raw_data);
		sc.close();
	}

	

}
