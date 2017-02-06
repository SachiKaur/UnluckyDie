import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;
import java.util.Timer;
import java.util.TimerTask;
public class Roll extends JFrame implements ActionListener {
  
  private Picture background;
  private JButton roll;
  private Die die1,die2;
  private ImageIcon d1,d2,equal,plus;
  private JLabel lbld1,lbld2,lblequal,lbltotal,lblplus;
  private int x = 0;
  private int total = 0;
  private Timer timer;
  
  public Roll() { 
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
      lbltotal.setBounds(178,190,100,100);
    }
    catch (Exception h)
    {      
    }
    
    roll = new JButton ("Roll The Dice");
    roll.setBounds (175,370,150,50);
    
    lbld1 = new JLabel (); //Initializing JLabels and setting into a specific spots
    lbld1.setBounds(160,50,50,50);
    
    lbld2 = new JLabel (); //Initializing JLabels and setting into a specific spots
    lbld2.setBounds(300,50,50,50);
    
    lblequal = new JLabel ();
    lblequal.setBounds(230,130,50,50);
    
    lblplus = new JLabel ();
    lblplus.setBounds (235,55,40,40);
    
    die1 = new Die (6);
    die2 = new Die (6);
   
    add (lblplus);
    add (lbltotal);
    add (lblequal);
    add (lbld1);
    add (lbld2);
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
      
      showImage (die1.getValue(),die2.getValue());
      lbltotal.setText("" + (die1.getValue()+die2.getValue()));
      
      timer = new Timer (  ) ;
      timer.schedule ( new ToDoTask (  ) , 3 *1000 ); 
      
      roll.setEnabled(false);
    }
  }
  
  public void showImage (int dice1, int dice2)
  {
    try
    {
      d1 = new ImageIcon(dice1 + ".png");   
      lbld1.setIcon (d1);
      
      d2 = new ImageIcon(dice2 + ".png");   
      lbld2.setIcon (d2);
      
      equal = new ImageIcon("equal.png");  
      lblequal.setIcon (equal);
      
      plus = new ImageIcon("plus.gif");  
      lblplus.setIcon (plus);
      
    }
    catch (Exception f)
    {
    }    
    
  }
  class ToDoTask extends TimerTask  {
    public void run (  )   {
      Card cardGui = new Card ((die1.getValue()+die2.getValue()));
      setVisible(false);
    }
  }
  
  public static void main(String[] args) { 
    Roll myGui = new Roll ();
  }
  
  /* ADD YOUR CODE HERE */
  
  
}