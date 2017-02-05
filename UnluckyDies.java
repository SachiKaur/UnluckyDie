import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;
public class UnluckyDies extends JFrame implements ActionListener {
  
  private Picture  background;
  private JButton enter;
  private ImageIcon image;
  private JLabel lblPic;
  
  public UnluckyDies() { 
    super ("Unlucky Dies");
    
    try
    {
      background = new Picture (0,0,500,500); 
      background.setBounds (0,0,500,500);
      background.resetColor (0,0,255);
    }
    catch (Exception e)
    {
    }
    String sachi [][] = new String [5][6];
    image = new ImageIcon ("background.gif");
    lblPic = new JLabel (); //Initializing JLabels and setting into a specific spots
    lblPic.setBounds(0,0,500,470);
    lblPic.setIcon(image);
    
    enter = new JButton ("Enter");
    enter.setBounds (175,250,150,50);
    
    add (enter);
    add (lblPic);
    add (background);
    
    enter.addActionListener (this);
    setResizable (false);
    setSize(500,500);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    background.repaint();
    ImageIcon hi [][] = new ImageIcon [4][6];
  }
  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource() == enter) //Help button shows a picture where the person sees what each thing is for
    {
      Spinner newGui = new Spinner();
      setVisible (false);
    }
  }
  public static void main(String[] args) { 
    UnluckyDies myGui = new UnluckyDies();
  }
  
  /* ADD YOUR CODE HERE */
  
}
