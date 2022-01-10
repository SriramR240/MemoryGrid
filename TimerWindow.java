package MemoryGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class TimerWindow extends JFrame implements ActionListener
{  //creation of an window using JFrame
	private int start = 1;
	private JButton jbtn; //creation of button inside the JFrame window
	private Timer swingtimer; //swing timer instance
	TimerWindow(int tm)
{
start += tm;
setTitle("Timer Window");
setLayout(new FlowLayout());
setTimer();
setSize(700,350);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
private void setTimer()
{
jbtn = new JButton("Staring Timer...");
add(jbtn);
swingtimer = new Timer(2222,this);
swingtimer.start();
}
public void actionPerformed(ActionEvent evnt)
{
start--;
if(start>=1)
{
jbtn.setText("Time : "+start); //changing the label of button as the timer decrases
}else{
jbtn.setText("Timeout... Now,Close the Window");
swingtimer.stop();
}
}
}

class Timerinswing
{
static public void main(String[] args) 
{
TimerWindow tw = new TimerWindow(5);
}
}