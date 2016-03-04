package panels;
  //Name: Kofi Lewis
 //Purpose: This module designs a screen where the user can select which categories of cards they want to test on   
	import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
    public class SelectTestPan extends JPanel
   {
      static JFrame frameDoTest = new JFrame("Test!");
   
       private JLabel addLabel(String s, Color c)
      {
         JLabel temp = new JLabel(s);
         temp.setForeground(new Color(255,0,0));
         temp.setBackground(c);
         temp.setHorizontalAlignment(SwingConstants.CENTER);
         add(temp);
         return temp;
      }
      
       private JRadioButton addRadio(String s, Color c)
      {
         JRadioButton temp = new JRadioButton(s);
         temp.setForeground(new Color(255,0,0));
         temp.setBackground(c);
         add(temp);
         return temp;
      }
   
       public JButton addButton(JPanel panel, String s, ActionListener li)
      {
         JButton temp = new JButton();
         temp.setText(s);
         temp.addActionListener(li); 
         panel.add(temp);
         return temp;
      }
   	
      private JLabel labelBlank1, labelBlank2, label1,label2,label3,label4,label5, label6;
      private JTextField text1;
      private String name,type;
      private int index01, x, i;
      private char c, t;
      public static JRadioButton radio1, radio2, radio3, radio4;
      public static JButton button, button1;
       
       public SelectTestPan()
      {
      
         setLayout(new GridLayout(6,1));
         setBackground(new Color(0,0,255));
         //##ERROR HANDLING##\\
			//Creates the radioButtons for the categories that can be selected for a test
         label1 = addLabel("Select Categories For Testing", new Color(0,0,255));
         label1.setFont((new Font("Lucida Bright", Font.PLAIN, 20)));
         
         radio1 = addRadio("Addition", new Color(0,0,255));
         radio1.setFont((new Font("Lucida Bright", Font.PLAIN, 20)));      
         
         radio2 = addRadio("Subtraction", new Color(0,0,255));
         radio2.setFont((new Font("Lucida Bright", Font.PLAIN, 20)));
         
         radio3 = addRadio("Multiplication", new Color(0,0,255));
         radio3.setFont((new Font("Lucida Bright", Font.PLAIN, 20)));
         
         radio4 = addRadio("Division", new Color(0,0,255));
         radio4.setFont((new Font("Lucida Bright", Font.PLAIN, 20)));
               
         JPanel option = new JPanel();
         option.setBackground(new Color(0,0,255));
         add(option);
         button = addButton(option, "Start!", new Listener());
         button1 = addButton(option, "Back", new Listener1());
      }
         
       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {         
            frameDoTest.setSize(805,525);
            frameDoTest.setLocation(200, 100);
            frameDoTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameDoTest.setContentPane(new TestPan());
            frameDoTest.setVisible(true);
            CardPanel.frameTest.dispose();
         }  
      }
      
       private class Listener1 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {         
            DriverCard.frame.setSize(600, 500);
            DriverCard.frame.setLocation(200, 100);
            DriverCard.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            DriverCard.frame.setContentPane(new CardPanel());
            DriverCard.frame.setVisible(true);
            CardPanel.frameTest.dispose();
         
         }  
      }
            
   }