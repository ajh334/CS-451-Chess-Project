package panels;
//Name: Kofi Lewis
//Purpose: This module designs a screen where the user view and sort cards    
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.util.ArrayList;
   
    public class ViewCardPan extends JPanel
   {
   
       private JLabel addLabel(JPanel panel, String s, Color c)
      {
         JLabel temp = new JLabel(s);
         temp.setForeground(new Color(255,0,0));
         temp.setBackground(c);
         temp.setHorizontalAlignment(SwingConstants.CENTER);
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
   	
       private JTextField addText(JPanel panel, int x, Color c, Color s)
      {
         JTextField temp = new JTextField(x);
         temp.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
         temp.setForeground(c);
         temp.setBackground(s);
         panel.add(temp);
         return temp;
      }
   	    
       private JComboBox addBox(JPanel panel, Color c, Color s)
      {
         JComboBox temp = new JComboBox();
         temp.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
         temp.setForeground(c);
         temp.setBackground(s);
         
         panel.add(temp);
         return temp;
      }
      
      private JLabel labelBlank1, labelBlank2, label1,label2,label3,label4,label5, label6;
      private JTextArea textArea1;
      private JComboBox box;
      private String name,type;
      private int index01, x, i, number1, number2, answer;
      private char c, t;
      private String category, operation, hint;
      public static JButton button, button1, button2, button3, button4, button5;
   
       public ViewCardPan()
      {	
         setLayout(new BorderLayout());
         	      
         JPanel fieldName = new JPanel();
         fieldName.setLayout(new GridLayout(2,3));
         fieldName.setBackground(new Color(0,0,255));
         add(fieldName, BorderLayout.NORTH);
         
         label6 = addLabel(fieldName, "Category", new Color(0,0,255));
         label6.setFont(new Font("Lucida Bright", Font.BOLD, 20));
      
      	//$$USABILITY$$\\
      //The search bar enhances the users searching process 
         box = addBox(fieldName,new Color(255,0,0), new Color(0,0,255));
         box.addItem("All");
         box.addItem("Addition");
         box.addItem("Subtraction");
         box.addItem("Division");
         box.addItem("Multiplication");
      	
         addLabel(fieldName, " ", new Color(0,0,255));
         addLabel(fieldName, " ", new Color(0,0,255));
         addLabel(fieldName, " ", new Color(0,0,255));
      
         JPanel info = new JPanel();
         info.setLayout(new GridLayout(1,7));
         add(info, BorderLayout.CENTER);
      	
         addLabel(info, " ", new Color(0,0,255));
      
         label1 = addLabel(info, " ", new Color(255,255,255));
         label1.setFont(new Font("Lucida Bright", Font.BOLD, 70));
      	
         label2 = addLabel(info, " ", new Color(255,255,255));
         label2.setFont(new Font("Lucida Bright", Font.BOLD, 70));
      
         label3 = addLabel(info, " ", new Color(255,255,255));
         label3.setFont(new Font("Lucida Bright", Font.BOLD, 70));
      
         label4 = addLabel(info, "=", new Color(255,255,255));
         label4.setFont(new Font("Lucida Bright", Font.BOLD, 70));
      	
         label5 = addLabel(info, " ", new Color(255,255,255));
         label5.setFont(new Font("Lucida Bright", Font.BOLD, 70));
      	
         addLabel(info, " ", new Color(0,0,255));  
      
         JPanel option = new JPanel();
         option.setLayout(new FlowLayout());
         option.setBackground(new Color(0,0,255));
         add(option, BorderLayout.SOUTH);
         button4 = addButton(option, "Hint", new Listener4());
         button = addButton(option, "Next Card", new Listener());
         button1 = addButton(option, "Previous Card", new Listener1());
         button5 = addButton(option, "Sort Cards", new Listener5());     
         button2 = addButton(option, "Back", new Listener2());         	       
      }
         
       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            CardList general = new CardList();
             
            Card[] tempFlash = new Card[CardUtilities.flash.size()];
            CardUtilities.flash.toArray(tempFlash);
            
            Card[] tempAdd = new Card[CardUtilities.addition.size()];
            CardUtilities.addition.toArray(tempAdd);
            
            Card[] tempSub = new Card[CardUtilities.subtraction.size()];
            CardUtilities.subtraction.toArray(tempSub);
            
            Card[] tempMult = new Card[CardUtilities.multiplication.size()];
            CardUtilities.multiplication.toArray(tempMult);
            
            Card[] tempDiv = new Card[CardUtilities.division.size()];
            CardUtilities.division.toArray(tempDiv);
              
            if(box.getSelectedItem().equals("All"))
            {
               general.clear();
               
               for(int i = 0; i < CardUtilities.flash.size(); i++)
               {
                  general.add(tempFlash[i]);
               }   
            }
            
            else if(box.getSelectedItem().equals("Addition"))
            {
               general.clear();
                              
               System.out.println("after clear, size is: " + general.size());
               
               for(int i = 0; i < CardUtilities.addition.size(); i++)
               {
                  general.add(tempAdd[i]);
                  System.out.println("object #: " + i);
               }
                 
            }
            
            else if(box.getSelectedItem().equals("Subtraction"))
            {
               general.clear();
               
               System.out.println("after clear, size is: " + general.size());
            
               for(int i = 0; i < CardUtilities.subtraction.size(); i++)
               {
                  general.add(tempSub[i]);
                  System.out.println("object #: " + i);  
               }
               
            }
            
            else if(box.getSelectedItem().equals("Division"))
            {
               general.clear();
               
               System.out.println("after clear, size is: " + general.size());
            
               for(int i = 0; i < CardUtilities.division.size(); i++)
               {
                  general.add(tempDiv[i]);
                  System.out.println("object #: " + i);  
               }
            }
            
            else if(box.getSelectedItem().equals("Multiplication"))
            {
               general.clear();
               
               System.out.println("after clear, size is: " + general.size());
            
               for(int i = 0; i < CardUtilities.multiplication.size(); i++)
               { 
                  general.add(tempMult[i]);
                  System.out.println("object #: " + i);  
               }
            }
            
            Card[] extra = new Card[general.size()];
            general.toArray(extra);
            
            for(int i = 0; i < general.size(); i++)
            {
               System.out.println("List is" + extra[i].getCategory());
            }
         
            System.out.println("extra length" + extra.length);
            System.out.println("extra[0]" + extra[0].getCategory());
            
            index01 = index01 +1;
            //**MASTERY FACTOR**\\ 12-15:The use of any five standard level mastery factors
         	//Standard Level Mastery Factor 5: Complex Selection(nested if, if with multiple conditions or switch      
            if (index01 >= general.size())
            {
               index01 = 0;
            }
            label1.setText(" " + extra[index01].getNumber1());        
            label2.setText(extra[index01].getOperation());
            label3.setText(" " + extra[index01].getNumber2());
            label5.setText(" " + extra[index01].getAnswer());
         }  
      }
      
       private class Listener1 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            CardList general = new CardList();
             
            Card[] temp = new Card[CardUtilities.flash.size()];
            CardUtilities.flash.toArray(temp);
            
            for(int i = 0; i < CardUtilities.flash.size(); i++)
            {
               System.out.println("List is" + temp[i].getCategory());
            }
            System.out.println("Size is: " + CardUtilities.flash.size());
         
            if(box.getSelectedItem().equals("All"))
            {
               general.clear();
               
               for(int i = 0; i < CardUtilities.flash.size(); i++)
               {
                  general.add(temp[i]);
               }   
            }
            
            else if(box.getSelectedItem().equals("Addition"))
            {
               general.clear();
               
               for(int i = 0; i < CardUtilities.flash.size(); i++)
               {
                  if(temp[i].getCatNumb() == 1)
                  {
                     general.add(temp[i]);
                  }
               }   
            }
            
            else if(box.getSelectedItem().equals("Subtraction"))
            {
               general.clear();
               for(int i = 0; i < CardUtilities.flash.size(); i++)
               {
                  if(temp[i].getCatNumb() == 2)
                  {
                     general.add(temp[i]);
                  }
               }
               
            }
            
            else if(box.getSelectedItem().equals("Division"))
            {
               general.clear();
               for(int i = 0; i < CardUtilities.flash.size(); i++)
               {
                  if(temp[i].getCatNumb() == 3)
                  {
                     general.add(temp[i]);
                  }
               }
            }
            
            else if(box.getSelectedItem().equals("Multiplication"))
            {
               general.clear();
               for(int i = 0; i < CardUtilities.flash.size(); i++)
               {
                  if(temp[i].getCatNumb() == 4)
                  {
                     general.add(temp[i]);
                  }
               }
            }
               
            Card[] extra = new Card[general.size()];
            general.toArray(extra);
            
            for(int i = 0; i < general.size(); i++)
            {
               System.out.println("List is" + extra[i].getCategory());
            }
         
            System.out.println("extra length" + extra.length);
            System.out.println("extra[0]" + extra[0].getCategory());
         
            index01 = index01 - 1;
                  	        
            if (index01 == general.size())
            {
               index01 = 0;
            }
            if(index01 == -1)
            {
               index01 = general.size() - 1;
            }
            label1.setText(" " + extra[index01].getNumber1());        
            label2.setText(extra[index01].getOperation());
            label3.setText(" " + extra[index01].getNumber2());
            label5.setText(" " + extra[index01].getAnswer());           
         }  
      }   
      
       private class Listener2 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            DriverCard.frame.setSize(600, 500);
            DriverCard.frame.setLocation(200, 100);
            DriverCard.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            DriverCard.frame.setContentPane(new CardPanel());
            DriverCard.frame.setVisible(true);
            CardPanel.frameView.dispose(); 
         }
      }
   	
   
       private class Listener4 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            Card[] temp = new Card[CardUtilities.flash.size()];
            CardUtilities.flash.toArray(temp);
         	
            Card[] tempA = new Card[CardUtilities.addition.size()];
            CardUtilities.addition.toArray(tempA);
         	
            Card[] tempS = new Card[CardUtilities.subtraction.size()];
            CardUtilities.subtraction.toArray(tempS);
         	
            Card[] tempD = new Card[CardUtilities.division.size()];
            CardUtilities.division.toArray(tempD);
         
            Card[] tempM = new Card[CardUtilities.multiplication.size()];
            CardUtilities.multiplication.toArray(tempM);
         //##ERROR HANDLING##\\
         //Only allows the user to view cards by category based on a permanent set of choices, so that they don't input an incorrect category of card
            if(box.getSelectedItem().equals("All"))
            {
               JOptionPane.showMessageDialog(null, temp[index01].getHint(), "Monica's Flashcard Program",  JOptionPane.WARNING_MESSAGE);
            }
            else if(box.getSelectedItem().equals("Addition"))
            {
               JOptionPane.showMessageDialog(null, tempA[index01].getHint(), "Monica's Flashcard Program",  JOptionPane.WARNING_MESSAGE);
            }
            
            else if(box.getSelectedItem().equals("Subtraction"))
            {
               JOptionPane.showMessageDialog(null, tempS[index01].getHint(), "Monica's Flashcard Program",  JOptionPane.WARNING_MESSAGE);
            }
            
            else if(box.getSelectedItem().equals("Division"))
            {
               JOptionPane.showMessageDialog(null, tempD[index01].getHint(), "Monica's Flashcard Program",  JOptionPane.WARNING_MESSAGE);
            }
            
            else if(box.getSelectedItem().equals("Multiplication"))
            {
               JOptionPane.showMessageDialog(null, tempM[index01].getHint(), "Monica's Flashcard Program",  JOptionPane.WARNING_MESSAGE);
            }
         }  
      }
      
       private class Listener5 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
         //***MASTERY FACTOR**\\ 11: The use of any five standard level mastery factors
         //Standard Level mastery factor 11: Sorting
            CardUtilities.sortList();
         }  
      }
   }