package MemoryGrid;

import javax.swing.JButton;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class Card extends JButton
{

	protected  BufferedImage front;
	protected  BufferedImage back;

    public void setfront(BufferedImage id)
    {
        this.front = id;
        this.back=null;
    }

    public BufferedImage getfront()
    {
        return this.front;
    }
    

	
}
