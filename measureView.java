import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;
/**
   This program demonstrates how an action listener can be used to trigger 
   a variable from a surrounding block.
*/
public class measureView
{

   private static final int FRAME_WIDTH = 240;
   private static final int FRAME_HEIGHT = 160;

   public static void main(String[] args)
   {
	   Scanner in = new Scanner(System.in);
	   
	      Measurable[] accounts = new Measurable[3];
	      accounts[0] = new BankAccount(176220);
	      accounts[1] = new BankAccount(513120);
	      accounts[2] = new BankAccount(30510);

		   
	      Measurable[] countries = new Measurable[3];
	      countries[0] = new Country("Uruguay", 176220);
	      countries[1] = new Country("Thailand", 513120);
	      countries[2] = new Country("Belgium", 30510);	   
	      
	      
	      Measurable[] quizes = new Measurable[5];
	      quizes[0] = new QUIZ("Joe", 95);
	      quizes[1] = new QUIZ("Sally",80);
	      quizes[2] = new QUIZ("Jane",90);
	      quizes[3] = new QUIZ("Billy",50);
	      quizes[4] = new QUIZ("Sue",75);
	      
	   int whichMetric = 0;  
	   while (whichMetric != 9) 
	   {   
	   System.out.print("Enter metric to use, 1 for maximum, 2 for minimum, 3 for average or 9 to end: ");
	   whichMetric = in.nextInt();
	   if (whichMetric != 9) {
	   String metricToUse="average";
	   if (whichMetric == 1) {metricToUse = "Maximum";}
	   if (whichMetric == 2) {metricToUse = "Minimum";}
	   if (whichMetric == 3) {metricToUse = "Average";}

//Create frame and panel where buttons will be shown      
	  JPanel panel = new JPanel();
	  JFrame frame = new JFrame();
      frame.add(panel);

//Create button and listener for BankAccount      
      JButton button = new JButton("Get " + metricToUse + " Balance");
      panel.add(button);
      //frame.add(panel);
      ActionListener listener = new ButtonListener(accounts,metricToUse);
      button.addActionListener(listener);

//Create button and listener for Country      
      JButton button2 = new JButton("Get " + metricToUse + " Area");
      panel.add(button2);
      ActionListener listener2 = new ButtonListener(countries,metricToUse);
      button2.addActionListener(listener2);
      
//Create button and listener for Quiz      
      JButton button3 = new JButton("Get " + metricToUse + " Score");
      panel.add(button3);
      ActionListener listener3 = new ButtonListener(quizes,metricToUse);
      button3.addActionListener(listener3);

//Now display frame with buttons      
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
	   }
	   }
	   in.close();
   }
}
