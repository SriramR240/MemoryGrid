package MemoryGrid;


import java.io.*;

public class GameSystem 
{
	public static String description="The system module is the secondary actor which is "
			+ "respnsoble for running the game";
	protected static int no_of_users;
	
	protected Login L = new Login();
	
	protected Authentication Auth = new Authentication();
	
	protected Menu m= new Menu();

	
	//Used to reflect Game System data (No_of_users and user data)
	protected void reflect_data(User u) throws IOException
	{
		Writer wr = new FileWriter("E:/Systeminfo.txt");
		wr.write(GameSystem.no_of_users + "");
		wr.close();
		
		FileWriter fw = new FileWriter("E:/Username.txt", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter out = new PrintWriter(bw);
	    out.println(u.username);
	    out.close();
	    
	    FileWriter fw2 = new FileWriter("E:/Password.txt", true);
	    BufferedWriter bw2 = new BufferedWriter(fw2);
	    PrintWriter out2 = new PrintWriter(bw2);
	    out2.println(u.password);
	    out2.close();
	    
	    
	}
	
	
}


