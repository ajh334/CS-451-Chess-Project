package panels;
 //Name: Kofi Lewis
 //Purpose: This module designs a welcome screen with buttons so the user can choose what they want to do 
  
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
    public class CardPanel extends JPanel
   {
      static JFrame frameView = new JFrame("View Cards");
      static JFrame frameAdd= new JFrame("Add Card");
      static JFrame frameDelete = new JFrame("Delete Card");
      static JFrame frameTest = new JFrame("Test");
   	   
       private JLabel addLabel(JPanel banner, String s)
      {
         JLabel temp = new JLabel(s);
         temp.setForeground(new Color(255,0,0));
         temp.setBackground(new Color(0,0,255));
         temp.setFont(new Font("Lucida Bright", Font.BOLD, 25));
         temp.setHorizontalAlignment(SwingConstants.CENTER);
         banner.add(temp);
         return temp;
      }
      
       private JLabel addPic(JPanel picture, Icon i)
      {
         JLabel temp = new JLabel(i);
         temp.setFont(new Font("Lucida Bright", Font.BOLD, 25));
         temp.setBackground(new Color(0,0,255));
         picture.add(temp);
         return temp;
      }
   
       private JButton addButton(JPanel option, String s, String t, ActionListener li)
      {
         JButton temp = new JButton();
         temp.setText(s);
         temp.addActionListener(li);
         temp.setToolTipText(t); 
         option.add(temp);
         return temp;
      }
   
       public CardPanel()
      {
         ImageIcon i = new ImageIcon("mathfun.jpg");      
         setLayout(new BorderLayout());
         	      
         JPanel banner = new JPanel();
         banner.setLayout(new FlowLayout());
         banner.setBackground(new Color(0,0,255));
         add(banner, BorderLayout.NORTH);
         addLabel(banner, "Mrs. Lewis' Flashcard Program");
         
         JPanel picture = new JPanel();
         picture.setLayout(new GridLayout(1,1));
         add(picture, BorderLayout.CENTER);
         picture.setBackground(new Color(0,0,255));
         addPic(picture, i);
      	
         JPanel option = new JPanel();
         option.setBackground(new Color(0,0,255));
         add(option, BorderLayout.SOUTH);
         addButton(option, "Test!", "Click here to take a test", new Listener6());
         addButton(option, "View Cards", "Click here to view flashcards", new Listener());
         addButton(option, "Add A Card", "Click here to add flashcards", new Listener1());
         addButton(option, "Delete A Card", "Click here to delete flashcards", new Listener2());
         addButton(option, "Save", "Click here to save flashcards", new Listener4());
         addButton(option, "Exit", "Click here to exit the program", new Listener5());
      }
         
       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            DriverCard.frame.dispose();
         
            frameView.setSize(805,525);
            frameView.setLocation(100, 200);
            frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameView.setContentPane(new ViewCardPan());
            frameView.setVisible(true);           
         }
      }
   	
       private class Listener1 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            DriverCard.frame.dispose();        
            frameAdd.setSize(425,325);
            frameAdd.setLocation(100, 200);
            frameAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameAdd.setContentPane(new AddCardPan());
            frameAdd.setVisible(true);
         }
      }
   
       private class Listener2 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            DriverCard.frame.dispose();        
            frameDelete.setSize(425,325);
            frameDelete.setLocation(100, 200);
            frameDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameDelete.setContentPane(new DeleteCardPan());
            frameDelete.setVisible(true);
         }
      }
       private class Listener4 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
         //##ERROR HANDLING##\\
         //User errors are handled by allowing JOptionPanes to pop up and ask users if they are sure they wish to save
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?", "Mrs. Lewis' Flashcard Program",  JOptionPane.YES_NO_OPTION);
           
            //**MASTERY FACTOR**\\ 12-15:The use of any five standard level mastery factors
         	//Standard Level Mastery Factor 4: Simple Selection(if-else) 
            if(reply == 0)
            {
               CardUtilities.writeFile("CardData.txt", CardUtilities.flash);
            }
            else
            {
            
            }
         }
      }
   
       private class Listener5 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
      }
       private class Listener6 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            DriverCard.frame.dispose();
         
            frameTest.setSize(525,525);
            frameTest.setLocation(100, 200);
            frameTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameTest.setContentPane(new SelectTestPan());
            frameTest.setVisible(true);           
         
         }
      }
   
   }
