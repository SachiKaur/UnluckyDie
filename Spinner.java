import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;
public class Spinner extends JFrame implements ActionListener {
  
  private Picture  background;
  private JButton stop;
  private JLabel lblPic;
  private ImageIcon image, images [];
  private int s;
  private int num;
  private Die die;
  private Timer timer;
  
  public Spinner() { 
    super ("UnluckyDie");
    
    try
    {
      background = new Picture (0,0,500,500); 
      background.setBounds (0,0,500,500);
      background.resetColor (0,0,255);
    }
    catch (Exception e)
    {
    }
    
    s = 1;
    lblPic = new JLabel (); //Initializing JLabels and setting into a specific spots
    lblPic.setBounds(50,0,394,392);
    
    image = new ImageIcon ("spinner.gif");
    lblPic.setIcon(image);
    
    images = new ImageIcon [8];
    for (int i = 0; i <= 7; i++)
    {
      String z = "0" + i;
      images [i] = new ImageIcon (z + ".png"); 
    }
    
    stop = new JButton ("Stop");
    stop.setBounds (172,400,150,50);
    
    add (lblPic);
    add (stop);
    add (background);
    
    stop.addActionListener (this);
    setResizable (false);
    setSize(500,500);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    background.repaint();
  }
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == stop) //Help button shows a picture where the person sees what each thing is for
    {
      die = new Die (8);
      die.rollDie();
      
      lblPic.setIcon(images[die.getValue()-1]);
      
      stop.setEnabled(false);
      
      timer = new Timer (  ) ;
      timer.schedule ( new ToDoTask (  ) , 3 *1000 );        
    }
  }
  
  class ToDoTask extends TimerTask  {
    public void run (  )   {
      Rolling newGui = new Rolling((die.getValue() - 1));
      setVisible (false); 
    }    
  }
  
  public static void main(String[] args) { 
    Spinner myGui = new Spinner();
  }
  
  /* ADD YOUR CODE HERE */
  
}
