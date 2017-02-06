import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;
public class Card extends JFrame implements ActionListener {
  
  private Picture background;
  private JButton draw;
  private ImageIcon card;
  private JLabel lblcard;
  private int x = 0;
  private int total = 0;
  private Timer timer;
  private Die die,die1;
  private int value;
  
  public Card(int dieValue) { 
    super ("UnluckyDie");
    
    value = dieValue;
    
    try
    {
      background = new Picture (0,0,500,500); 
      background.setBounds (0,0,500,500);
      background.resetColor (0,0,255);
    }
    catch (Exception e)
    {
    }
    
    draw = new JButton ("Draw a Card");
    draw.setBounds (175,370,150,50);
    
    die = new Die (11);
    die1 = new Die (4);
    
    lblcard = new JLabel (); //Initializing JLabels and setting into a specific spots
    lblcard.setBounds(130,20,230,330);
    
    card = new ImageIcon("Back.png");   
    lblcard.setIcon (card); 
    
    add (lblcard);
    add (draw);
    add (background);
    
    draw.addActionListener (this);
    setResizable (false);
    setSize(500,500);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    background.repaint();
  }
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == draw) //Help button shows a picture where the person sees what each thing is for
    { 
      die.rollDie ();
      die1.rollDie();
      
      String suits;
      
      if (die1.getValue() == 1)
      {
        suits = "S";
      }
      else if (die1.getValue() == 2)
      {
        suits = "H"; 
      }
      else if (die1.getValue() == 3)
      {
        suits = "C"; 
      }
      else
      {
        suits = "D"; 
      }
      
      String cards = (die.getValue() + 1) + suits;
      
      showImage (cards);
      
      timer = new Timer (  ) ;
      timer.schedule ( new ToDoTask (  ) , 3 *1000 ); 
      
      draw.setEnabled(false);
    }
  }
  
  public void showImage (String cards)
  {
    try
    {
      card = new ImageIcon(cards + ".png");   
      lblcard.setIcon (card);
    }
    catch (Exception f)
    {
    }    
    
  }
  class ToDoTask extends TimerTask  {
    public void run (  )   {
      if ((die.getValue() + 1) == value)
      {
       Win gui = new Win (2); 
       setVisible(false);
      }
      else
      {
       Lose gui = new Lose(2); 
       setVisible(false);
      }
    }
  }
  
  public static void main(String[] args) { 
    Card myGui = new Card (2);
  }
  
  /* ADD YOUR CODE HERE */
  
  
}