import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
   An action listener that prints a message.
*/
public class measureClick implements ActionListener
{
	private String metric;




   public measureClick(String theName)
   {
      metric  = theName;

   }

   public void actionPerformed(ActionEvent event)
   {   
     System.out.println(metric);
     

   }}

