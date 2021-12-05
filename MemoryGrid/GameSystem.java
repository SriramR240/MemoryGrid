package MemoryGrid;


import java.io.*;

public class GameSystem 
{
	public static String description="The system module is the secondary actor which is "
			+ "respnsoble for running the game";
	protected static int no_of_users;
	
	protected Login L = new Login();
	
	protected Authentication Auth = new Authentication();
	
	protected void reflect_data(User u) throws IOException
	{
		Writer wr = new FileWriter("E:/Systeminfo.txt");
		wr.write(GameSystem.no_of_users + "");
		wr.close();
		
		FileWriter fw = new FileWriter("E:/Database.txt", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw);
	    out.println(u.username+" "+u.password);
	    
	    out.close();
	}
	
}


