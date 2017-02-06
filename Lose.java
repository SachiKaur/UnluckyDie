import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.io.*;
import javax.imageio.*;
import java.net.URL;
import javax.sound.sampled.*;
public class Lose extends JFrame {
  
  private Picture  background;
  private JLabel lblPic;
  private ImageIcon image;
  private int total,win,lose;
  
  public Lose(int round) { 
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
    
    image = new ImageIcon ("Lose.gif");
    lblPic = new JLabel (); //Initializing JLabels and setting into a specific spots
    lblPic.setBounds(0,0,500,480);
    lblPic.setIcon(image);
    
    try 
    {
      // Open an audio input stream.
      URL url = this.getClass().getClassLoader().getResource("Lose.wav");
      AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
      // Get a sound clip resource.
      Clip clip = AudioSystem.getClip();
      // Open audio clip and load samples from the audio input stream.
      clip.open(audioIn);
      clip.start();
    }
    catch (Exception g)
    {        
    }
    
    add (lblPic);
    add (background);
    
    setResizable (false);
    setSize(500,500);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    background.repaint();
    
    if (round == 1)
    {
      read ("Round1");
      write ("Round1");
    }
    else
    {
      read ("Round2");
      write ("Round2"); 
    }
    
    try
    {
      Thread.sleep(3000);
    }
    catch (Exception f)
    {      
    }
    
    UnluckyDie myGui = new UnluckyDie();
    setVisible(false);
    dispose();
    
  }
  public void read (String round)
  {
    try
    {
      BufferedReader fr = new BufferedReader(new FileReader(round + ".txt")); //Opens the file
      
      total = Integer.parseInt(fr.readLine()); 
      win = Integer.parseInt(fr.readLine());
      lose = Integer.parseInt(fr.readLine());
      
      fr.close (); //Closes the file 
    }
    catch (Exception t)
    {
    }
  }
  public void write (String round)
  {
    try
    {
      PrintWriter fw = new PrintWriter (new FileWriter(round + ".txt")); 
      
      fw.println(total + 1); 
      fw.println(win); 
      fw.println(lose + 1); 
      
      fw.close(); //Closing the file 
    }
    catch (Exception t)
    {
    }
  }
  public static void main(String[] args) { 
    Lose myGui = new Lose(1);
  }
  
  /* ADD YOUR CODE HERE */
  
}
