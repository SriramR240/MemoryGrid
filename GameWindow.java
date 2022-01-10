package MemoryGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.*;



@SuppressWarnings("serial")
public class GameWindow extends JFrame {
	
	private Card selectedCard;
    private Card c1;
    private Card c2;
    private Timer t;
    public Grid g1;
    private int count;
    
    

	public void begin(User u,Thread newt) throws FileNotFoundException
	{

    	
    	List<BufferedImage> cardVals = new ArrayList<BufferedImage>();
    	g1=new Grid();
        count=g1.display(cardVals);
        Collections.shuffle(cardVals);
        
        
        for (BufferedImage val : cardVals)
        {
            Card c = new Card();
            c.setfront(val);
             
            c.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent ae)
                {
                    selectedCard = c;
                    mouseclicked();
                }
            });
            
            g1.cards.add(c);
        }
        
        
        Time t1=new Time();
        
        t = new Timer(750, new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if (c1.getfront() == c2.getfront()) //match condition
                {
                    c1.setEnabled(false); //disables the button
                    c2.setEnabled(false);
                    count-=1;
                    
                    
                    if (count<=0)
                    {
                    	hardexit(t1,u,newt);
                    }	
                }

                else{
                    c1.setIcon(null); //'hides' text
                    c2.setIcon(null);
                }
                c1 = null; //reset c1 and c2
                c2 = null;
            }
        });

        t.setRepeats(false);
        
        //set up the board itself
        Container pane = getContentPane();
        
        int temp=(Grid.dimension/Grid.cd);
        
     
        pane.setLayout(new GridLayout(temp,temp));
        
        for (Card c : g1.cards){
            pane.add(c);
        }
        
        // some time passes
        setTitle("Memory Match");
	}
	
    public void mouseclicked()
    {
        if (c1 == null && c2 == null)
        {
            c1 = selectedCard;
            //c1.setText(String.valueOf(c1.getId()));
            c1.setIcon(new ImageIcon(c1.getfront()));
        }

        if (c1 != null && c1 != selectedCard && c2 == null)
        {
            c2 = selectedCard;
            //c2.setText(String.valueOf(c2.getId()));
            c2.setIcon(new ImageIcon(c2.getfront()));
            t.start();

        }
    }

    
    
    public void hardexit(Time t1,User u,Thread t)
    {
    	t1.timepassed=(System.nanoTime()-t1.timepassed)/1000000000;
        JOptionPane.showMessageDialog(this, "You win!.Your time is "+t1.timepassed+"seconds");
        try
        {
         GameSystem.reflect_data(t1,u);
        }
        catch (IOException e)
        {
        	//null
        }
    }


}

	
		
