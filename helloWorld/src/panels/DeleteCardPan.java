package panels;
  //Name: Kofi Lewis
 //Purpose: This module designs a screen where the user can delete a card  
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
    public class DeleteCardPan extends JPanel
   {
       private JLabel addLabel(JPanel panel, String s)
      {
         JLabel temp = new JLabel(s);
         temp.setForeground(new Color(255,0,0));
         temp.setFont(new Font("Lucida Bright", Font.BOLD, 12));
         temp.setHorizontalAlignment(SwingConstants.LEFT);
         panel.add(temp);
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
      	
       private JTextArea addArea(JPanel panel, Color c, Color s)
      {
         JTextArea temp = new JTextArea(10,5);
         temp.setFont(new Font("Courier", Font.PLAIN, 12));
         temp.setForeground(c);
         temp.setBackground(s);
         temp.setLineWrap(true);
         JScrollPane temp2 = new JScrollPane(temp);
         panel.add(temp2);
         return temp;
      }
   
      private JLabel label1,label2,label3,label4,label5;
      private JTextArea textArea1;
      private String name,type;
      private int price;
      private int index01;
      public static JButton button, button1, button2, button3;
   
       public DeleteCardPan()
      {	      
         setLayout(new BorderLayout());
           
         JPanel flashCard = new JPanel();
         flashCard.setLayout(new GridLayout(1, 5));
         flashCard.setBackground(new Color(255,255,255));
         add(flashCard, BorderLayout.NORTH);
        
         
      
         label1 = addLabel(flashCard, " ");
         label1.setFont(new Font("Lucida Bright", Font.BOLD, 30));
      	
         label2 = addLabel(flashCard, " ");
         label2.setFont(new Font("Lucida Bright", Font.BOLD, 30));
      
         label3 = addLabel(flashCard, " ");
         label3.setFont(new Font("Lucida Bright", Font.BOLD, 30));
      
         label4 = addLabel(flashCard, "=");
         label4.setFont(new Font("Lucida Bright", Font.BOLD, 30));
      
         label5 = addLabel(flashCard, " ");
         label5.setFont(new Font("Lucida Bright", Font.BOLD, 30));
      
      
         JPanel info = new JPanel();
         info.setLayout(new GridLayout(1,2));
         info.setBackground(new Color(0,0,255));
         add(info, BorderLayout.CENTER);
         
         addLabel(info, "Hint");
         textArea1 = addArea(info, new Color(255,0,0), new Color(0,0,255));
      	
         JPanel option = new JPanel();
         option.setLayout(new FlowLayout());
         option.setBackground(new Color(0,0,255));
         add(option, BorderLayout.SOUTH);
         button = addButton(option, "Next Card", new Listener());
         button1 = addButton(option, "Previous Card", new Listener1());
         button2 = addButton(option, "Delete Card", new Listener2());
         button3 = addButton(option, "Back", new Listener3());         	  
      }
         
       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            Card[] temp = new Card[CardUtilities.flash.size()];
            CardUtilities.flash.toArray(temp);
            index01 = index01 + 1;
            if (index01 == CardUtilities.flash.size())
            {
               index01 = 0;
            }
            label1.setText(" " + temp[index01].getNumber1());        
            label2.setText(temp[index01].getOperation());
            label3.setText(" " + temp[index01].getNumber2());
            label5.setText(" " + temp[index01].getAnswer());
            
            textArea1.setText(temp[index01].getHint());
         }  
      }
      
       private class Listener1 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {  
            Card[] temp = new Card[CardUtilities.flash.size()];
            CardUtilities.flash.toArray(temp);
            index01 = index01 - 1;
         	        
            if (index01 == CardUtilities.flash.size())
            {
               index01 = 0;
            }
            if(index01 == -1)
               index01 = CardUtilities.flash.size() - 1;
         		
            label1.setText(" " + temp[index01].getNumber1());        
            label2.setText(temp[index01].getOperation());
            label3.setText(" " + temp[index01].getNumber2());
            label5.setText(" " + temp[index01].getAnswer());
         
            textArea1.setText(temp[index01].getHint());
         }        
      }
        //$$USABILITY$$\\
   //Companies can be deleted  
       private class Listener2 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {  
         //##ERROR HANDLING##\\
         //User errors are handled by allowing JOptionPanes to pop up and ask users if they are sure they wish  to delete               
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Card?", "Mrs. Lewis' Flashcard Program",  JOptionPane.YES_NO_OPTION);
         
            if(reply == 0)
            {
               Card[] temp = new Card[CardUtilities.flash.size()];
               CardUtilities.flash.toArray(temp);
            	
               int x = index01;

            // //**MASTERY FACTOR**\\ 9: User Defined Methods with Parameters                    
               if(temp[index01].getCategory().equals("Addition"))
               {
                  for(int i = 0; i < CardUtilities.addition.size()+1; i++)
                  {
                     if(CardUtilities.addition.get(i) == CardUtilities.flash.get(x))
                     {
                        CardUtilities.addition.remove(i);
                     }
                  }
               }
               else if(temp[index01].getCategory().equals("Subtraction"))
               {
                  for(int i = 0; i < CardUtilities.subtraction.size()+1; i++)
                  {
                     if(CardUtilities.subtraction.get(i) == CardUtilities.flash.get(x))
                     {
                        CardUtilities.subtraction.remove(i);
                     }
                  }
               }
               else if(temp[index01].getCategory().equals("Division"))
               {
                  for(int i = 0; i < CardUtilities.division.size()+1; i++)
                  {
                     if(CardUtilities.division.get(i) == CardUtilities.flash.get(x))
                     {
                        CardUtilities.division.remove(i);
                     }
                  }
               }
               else if(temp[index01].getCategory().equals("Multiplication"))
               {
                  for(int i = 0; i < CardUtilities.multiplication.size()+1; i++)
                  {
                     if(CardUtilities.multiplication.get(i) == CardUtilities.flash.get(x))
                     {
                        CardUtilities.multiplication.remove(i);
                     }
                  }
               }
               CardUtilities.flash.remove(x);
               
               
            
               label1.setText(" " + temp[index01-1].getNumber1());        
               label2.setText(temp[index01-1].getOperation());
               label3.setText(" " + temp[index01-1].getNumber2());
               label5.setText(" " + temp[index01-1].getAnswer()); 
            
               textArea1.setText(temp[index01-1].getHint());
            } 
            if(reply ==1)
            {
            
            }
         }
      }
      
       private class Listener3 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            DriverCard.frame.setSize(600, 500);
            DriverCard.frame.setLocation(200, 100);
            DriverCard.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            DriverCard.frame.setContentPane(new CardPanel());
            DriverCard.frame.setVisible(true);
            CardPanel.frameDelete.dispose();
         }
      }
   }