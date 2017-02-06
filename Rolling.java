import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;
public class Rolling extends JFrame implements ActionListener {
  
  private Picture background;
  private JButton roll;
  private Die die,die1,die2,die3;
  private ImageIcon d1,d2,d3,equal,plus1,plus2;
  private JLabel lbld1,lbld2,lbld3,lblequal,lbltotal,lblplus1,lblplus2;
  private int x = 0;
  private int total = 0;
  private int number;
  private Timer timer;
  
  public Rolling(int num) { 
    super ("UnluckyDie");
    
    number = num;
    
    try
    {
      background = new Picture (0,0,500,500); 
      background.setBounds (0,0,500,500);
      background.resetColor (0,0,255);
    }
    catch (Exception e)
    {
    }
    
    try
      {
        Font reisenberg = Font.createFont (Font.TRUETYPE_FONT,this.getClass().getClassLoader().getResourceAsStream("Reisenberg.otf")); //Allowing the jar file to contain this font
        Font reisenberg70Pt =reisenberg.deriveFont(70f);
        
        lbltotal = new JLabel ();
        lbltotal.setFont(reisenberg70Pt);
        lbltotal.setForeground(Color.RED);
        
        FontMetrics fm = lbltotal.getFontMetrics(lbltotal.getFont());
        int width = fm.stringWidth(lbltotal.getText());
        
        lbltotal.setHorizontalAlignment(SwingConstants.RIGHT);
         lbltotal.setBounds(175,190,100,100);
      }
      catch (Exception h)
      {      
      }
      
    roll = new JButton ("Roll The Dice");
    roll.setBounds (175,370,150,50);
    
    lbld1 = new JLabel (); //Initializing JLabels and setting into a specific spots
    lbld1.setBounds(125,50,50,50);
    
    lbld2 = new JLabel (); //Initializing JLabels and setting into a specific spots
    lbld2.setBounds(225,50,50,50);
    
    lbld3 = new JLabel (); //Initializing JLabels and setting into a specific spots
    lbld3.setBounds(325,50,50,50);
    
    lblequal = new JLabel ();
    lblequal.setBounds(225,120,50,50);
    
    lblplus1 = new JLabel ();
    lblplus1.setBounds (180,50,40,40);
    
    lblplus2 = new JLabel ();
    lblplus2.setBounds (280,50,40,40);
    
    die = new Die (3);
    die1 = new Die (6);
    die2 = new Die (6);
    die3 = new Die (6);
    
    add (lblplus1);
    add (lblplus2);
    add (lbltotal);
    add (lblequal);
    add (lbld1);
    add (lbld2);
    add (lbld3);
    add (roll);
    add (background);
    
    roll.doClick();
    
    roll.addActionListener (this);
    setResizable (false);
    setSize(500,500);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    background.repaint();
  }
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == roll) //Help button shows a picture where the person sees what each thing is for
    { 
      die1.rollDie ();
      die2.rollDie ();
      die3.rollDie ();
      
      showImage (die1.getValue(),die2.getValue(),die3.getValue());
      lbltotal.setText("" + (die1.getValue()+die2.getValue()+die3.getValue()));
      
      timer = new Timer (  ) ;
      timer.schedule ( new ToDoTask (  ) , 3 *1000 ); 
      
      roll.setEnabled(false);
    }
  }
  
  public void showImage (int dice1, int dice2, int dice3)
  {
    try
    {
      d1 = new ImageIcon(dice1 + ".png");   
      lbld1.setIcon (d1);
      
      d2 = new ImageIcon(dice2 + ".png");   
      lbld2.setIcon (d2);
      
      d3 = new ImageIcon(dice3 + ".png");
      lbld3.setIcon (d3);
      
      equal = new ImageIcon("equal.png");  
      lblequal.setIcon (equal);
      
      plus1 = new ImageIcon("plus.gif");  
      lblplus1.setIcon (plus1);
      
      plus2 = new ImageIcon("plus.gif");  
      lblplus2.setIcon (plus2);
      
    }
    catch (Exception f)
    {
    }    
    
  }
  class ToDoTask extends TimerTask  {
    public void run (  )   {
      if (number == 0) 
      {
        if (die1.getValue() + die2.getValue() + die3.getValue() == 3)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 4)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 5)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 6)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else
        {
          Lose newGui = new Lose(1);
          setVisible (false);  
          dispose();
        }
      }
      else if (number == 1)
      {
        if (die1.getValue() + die2.getValue() + die3.getValue() == 4)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 9)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 16)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else
        {
          Lose newGui = new Lose(1);
          setVisible (false);  
          dispose();
        }
      }
      else if (number == 2)
      {
        if (die1.getValue() + die2.getValue() + die3.getValue() == 11)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 12)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 13)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 14)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else
        {
          Lose newGui = new Lose(1);
          setVisible (false);  
          dispose();
        }
      }
      else if (number == 3)
      {
        if (die1.getValue() + die2.getValue() + die3.getValue() == 4)
        {
          Win newGui = new Win(1);
          setVisible (false); 
          dispose(); 
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 6)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 8)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 10)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 12)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 14)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 16)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 18)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else
        {
          Lose newGui = new Lose(1);
          setVisible (false); 
          dispose(); 
        }
      }
      else if (number == 4)
      {
        if (die1.getValue() + die2.getValue() + die3.getValue() == 7)
        {
          Win newGui = new Win(1);
          setVisible (false); 
          dispose(); 
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 8)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 9)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 10)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else
        {
          Lose newGui = new Lose(1);
          setVisible (false);  
          dispose();
        }
      }
      else if (number == 5)
      {
        if (die1.getValue() + die2.getValue() + die3.getValue() == 3)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 6)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 9)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 12)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 15)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 18)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else
        {
          Lose newGui = new Lose(1);
          setVisible (false);  
          dispose();
        }
      }
      else if (number == 5)
      {
        if (die1.getValue() + die2.getValue() + die3.getValue() == 15)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 16)
        {
          Win newGui = new Win(1);
          setVisible (false); 
          dispose(); 
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 17)
        {
          Win newGui = new Win(1);
          setVisible (false); 
          dispose(); 
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 18)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else
        {
          Lose newGui = new Lose(1);
          setVisible (false); 
          dispose(); 
        }
      }
      else if (number == 7)
      {
        if (die1.getValue() + die2.getValue() + die3.getValue() == 3)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 5)
        {
          Win newGui = new Win(1);
          setVisible (false);
          dispose();  
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 7)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 9)
        {
          Win newGui = new Win(1);
          setVisible (false);
          dispose();  
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 11)
        {
          Win newGui = new Win(1);
          setVisible (false);
          dispose();  
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 13)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 15)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else if (die1.getValue() + die2.getValue() + die3.getValue() == 17)
        {
          Win newGui = new Win(1);
          setVisible (false);  
          dispose();
        }
        else
        {
          Lose newGui = new Lose(1);
          setVisible (false); 
          dispose(); 
        }
      }
    }
  }
  
  public static void main(String[] args) { 
    Rolling myGui = new Rolling (0);
  }
  
  /* ADD YOUR CODE HERE */
  
  
}