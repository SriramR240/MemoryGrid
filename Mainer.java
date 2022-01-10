package MemoryGrid;

import java.util.Scanner;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.io.*;
import java.awt.*;    
import java.awt.event.WindowEvent;    
import java.awt.event.WindowListener;  
import java.awt.event.WindowAdapter;

public class Mainer {
	
	public static void main(String args[]) throws IOException
	{
		//Just a message
		System.out.println("Hello,Welcome to the GAME.Enjoy yourself");
		
		//Initializing the Game System and a User
		GameSystem GS= new GameSystem();
		User u=new User();
		
		//Getting game info
		File Sysfile = new File("./src/MemoryGrid/Database/Systeminfo.txt");
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
		int i=0;
		
		while (true)
		{
		i=GS.m.main(u);
		
		if(i==4) //Quit condition
		{
			break;
		}
		
		
		 Thread t= new Thread();
		 GameWindow b = new GameWindow();
		 b.begin(u,t);
		 
	     b.setPreferredSize(new Dimension(Grid.dimension,Grid.dimension)); 
	     b.setLocation(400,40);
	     //b.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	     b.addWindowListener(new WindowAdapter() 
	     {
	    	    public void windowClosing(WindowEvent e) 
	    	    {
	    	        b.dispose();
	    	        synchronized(t) 
	    	        {
	    	            t.notify();
	    	        }
	    	    }
	    	});
	     b.pack();
	     b.setVisible(true);


	     System.out.println("over");
	     
	     
	    		 
	     synchronized(t) {
	    	    try {
	    	        
	    	        t.wait();
	    	    } catch (InterruptedException e) {
	    	        //.
	    	    }
	    	}		
		
	     System.out.println("double over");
		}
		
	}

}
