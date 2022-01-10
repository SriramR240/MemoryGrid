package MemoryGrid;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class Grid extends JFrame

{
	
	protected static int dimension=960;
	protected static int mode=0;
	protected static int cd=240;
	protected int pairs;
	protected List<Card> cards;
	
	protected int display(List<BufferedImage> cardVals) throws FileNotFoundException
	{
    	File file = new File(GameSystem.theme);
    	Scanner scan=new Scanner(file);
    	String path;
    	BufferedImage image = null;
    	int dummies=0;
    	
    	
    	if(Grid.cd==240)
    	{
    		this.pairs=8;
    		if (Grid.mode==1)
    		{
    			
    			dummies=1;
    		}
    	}
    	else if (Grid.cd==160)
    	{
    		this.pairs=18;
    		if (Grid.mode==1)
    		{
    			
    			dummies=2;
    		}
    	}
    	else
    	{
    		this.pairs=32;
    		if (Grid.mode==1)
    		{
    			
    			dummies=4;
    		}
    	}
    	
    	
    	this.cards=new ArrayList<Card>();
        int i=0;
        int j=0;
         
        while(scan.hasNext() && i<(this.pairs-dummies) ) 
        {
    		path=scan.next();
    		try 
    		{
    			image = ImageIO.read(new File(path));
    			cardVals.add(image);
    			
    			if (j<dummies)
    			{
    				path=scan.next();
    				image = ImageIO.read(new File(path));
        			cardVals.add(image);
    				j+=1;
    			
    			}
    			else
    			{
    				cardVals.add(image);
    				i+=1;
    			}
    		
    		}
    		catch (Exception e) 
    		{
    			System.out.println("Image cannot be loaded");
    			
    		}
    		
        }
        j=0;
        
        scan.close();
        return(this.pairs-dummies);
		
	}

}
