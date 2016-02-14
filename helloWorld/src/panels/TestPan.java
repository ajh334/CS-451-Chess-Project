package panels;
  //Name: Kofi Lewis
 //Purpose: This module designs a screen where the user can take a test    
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.util.ArrayList;
	
    public class TestPan extends JPanel
   {
   
       private JLabel addLabel(JPanel panel, String s, Color c)
      {
         JLabel temp = new JLabel(s);
         temp.setForeground(new Color(0,0,255));
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
         temp.setForeground(c);
         temp.setBackground(s);
         panel.add(temp);
         return temp;
      }
   	
       private JTextArea addArea(JPanel panel, Color c, Color s)
      {
         JTextArea temp = new JTextArea(10,10);
         temp.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
         temp.setForeground(c);
         temp.setBackground(s);
         temp.setLineWrap(true);
         JScrollPane temp2 = new JScrollPane(temp);
         panel.add(temp2);
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
      private JTextField text1;
      private JComboBox box;
      private String name,type;
      private int index01, x, i;
      private char c, t;
      public static JButton button, button1, button2, button3, button4, button6;
   
       public TestPan()
      {	      
         setLayout(new BorderLayout());
         	      
         JPanel fieldName = new JPanel();
         fieldName.setLayout(new GridLayout(2,3));
         fieldName.setBackground(new Color(255,0,0));
         add(fieldName, BorderLayout.NORTH);
         
         addLabel(fieldName, " ", new Color(255,0,0)); 
      
         addLabel(fieldName, " ", new Color(255,0,0));
         addLabel(fieldName, " ", new Color(255,0,0));
         addLabel(fieldName, " ", new Color(255,0,0));
         addLabel(fieldName, " ", new Color(255,0,0));
         addLabel(fieldName, " ", new Color(255,0,0));
      
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
      
         text1 = addText(info, 3, new Color(0, 0, 255), new Color(255,255,255));
         text1.setFont(new Font("Lucida Bright", Font.BOLD, 70));
      		
         addLabel(info, " ", new Color(0,0,255));  
      
         JPanel option = new JPanel();
         option.setLayout(new FlowLayout());
         option.setBackground(new Color(255,0,0));
         add(option, BorderLayout.SOUTH);
         button4 = addButton(option, "Hint", new Listener4());
         button6 = addButton(option, "Answer", new Listener6());
         button = addButton(option, "Next Card", new Listener());
         button1 = addButton(option, "Previous Card", new Listener1());     
         button2 = addButton(option, "Back", new Listener2());             	       
      }
         
       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {         
            CardList general = new CardList();
               	      
            Card[] temp = new Card[CardUtilities.flash.size()];
            Card[] tempA = new Card[CardUtilities.addition.size()];
            Card[] tempS = new Card[CardUtilities.subtraction.size()];
            Card[] tempM = new Card[CardUtilities.multiplication.size()];
            Card[] tempD = new Card[CardUtilities.division.size()];
            CardUtilities.flash.toArray(temp);
            CardUtilities.addition.toArray(tempA);
            CardUtilities.subtraction.toArray(tempS);
            CardUtilities.division.toArray(tempD);
            CardUtilities.multiplication.toArray(tempM);
            
            for(int i = 0; i < CardUtilities.flash.size(); i++)
            {
               System.out.println("List is" + temp[i].getCategory());
            }
            System.out.println("Size is: " + CardUtilities.flash.size());
         
         //**MASTERY FACTOR**\\ 5: Merging two or more sorted data structures
            if(SelectTestPan.radio1.isSelected())
            {
               for(int i = 0; i < CardUtilities.addition.size(); i++)
               {
                  general.add(tempA[i]);
               }
            }
            
            if(SelectTestPan.radio2.isSelected())
            {
               for(int i = 0; i < CardUtilities.subtraction.size(); i++)
               {
                  general.add(tempS[i]);
                  
               }
            }
            
            if(SelectTestPan.radio4.isSelected())
            {
               for(int i = 0; i < CardUtilities.division.size(); i++)
               {
                  general.add(tempD[i]);
               }
            }
            
            if(SelectTestPan.radio3.isSelected())
            {
               for(int i = 0; i < CardUtilities.multiplication.size(); i++)
               {
                  
                  general.add(tempM[i]);
                  
               }
            } 
         
            Card[] extra = new Card[general.size()];
            general.toArray(extra);
            System.out.println("extra length" + extra.length);
            System.out.println("extra[0]" + extra[0].getCategory());
            
            index01 = index01 +1;   
            if (index01 == general.size())
            {
               index01 = 0;
            }
            label1.setText(" " + extra[index01].getNumber1());        
            label2.setText(extra[index01].getOperation());
            label3.setText(" " + extra[index01].getNumber2());
            text1.setText("");
            text1.setForeground(Color.BLUE);
         }  
      }
      
       private class Listener1 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {  
            CardList general = new CardList();
               	      
            Card[] temp = new Card[CardUtilities.flash.size()];
            Card[] tempA = new Card[CardUtilities.addition.size()];
            Card[] tempS = new Card[CardUtilities.subtraction.size()];
            Card[] tempM = new Card[CardUtilities.multiplication.size()];
            Card[] tempD = new Card[CardUtilities.division.size()];
            CardUtilities.flash.toArray(temp);
            CardUtilities.addition.toArray(tempA);
            CardUtilities.subtraction.toArray(tempS);
            CardUtilities.division.toArray(tempD);
            CardUtilities.multiplication.toArray(tempM);
            
         	//#ERROR HANDLING##\\
         	//pulls the categories that have been selected and creates a test with only those categories.
            for(int i = 0; i < CardUtilities.flash.size(); i++)
            {
               System.out.println("List is" + temp[i].getCategory());
            }
            System.out.println("Size is: " + CardUtilities.flash.size());
         
         //**MASTERY FACTOR**\\ 11: The use of any five standard level mastery factors
         //Standard Level mastery factor 7: Nested loops
            if(SelectTestPan.radio1.isSelected())
            {
               for(int i = 0; i < CardUtilities.addition.size(); i++)
               {
                  general.add(tempA[i]);
               }
            }
            
            if(SelectTestPan.radio2.isSelected())
            {
               for(int i = 0; i < CardUtilities.subtraction.size(); i++)
               {
                  general.add(tempS[i]);
                  
               }
            }
            
            if(SelectTestPan.radio4.isSelected())
            {
               for(int i = 0; i < CardUtilities.division.size(); i++)
               {
                  general.add(tempD[i]);
               }
            }
            
            if(SelectTestPan.radio3.isSelected())
            {
               for(int i = 0; i < CardUtilities.multiplication.size(); i++)
               {
                  
                  general.add(tempM[i]);
                  
               }
            } 
         
            Card[] extra = new Card[general.size()];
            general.toArray(extra);
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
            text1.setText("");
            text1.setForeground(Color.BLUE);
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
            SelectTestPan.frameDoTest.dispose(); 
         }
      }
   
       private class Listener4 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            CardList general = new CardList();
               	      
            Card[] temp = new Card[CardUtilities.flash.size()];
            Card[] tempA = new Card[CardUtilities.addition.size()];
            Card[] tempS = new Card[CardUtilities.subtraction.size()];
            Card[] tempM = new Card[CardUtilities.multiplication.size()];
            Card[] tempD = new Card[CardUtilities.division.size()];
            CardUtilities.flash.toArray(temp);
            CardUtilities.addition.toArray(tempA);
            CardUtilities.subtraction.toArray(tempS);
            CardUtilities.division.toArray(tempD);
            CardUtilities.multiplication.toArray(tempM);
            
            for(int i = 0; i < CardUtilities.flash.size(); i++)
            {
               System.out.println("List is" + temp[i].getCategory());
            }
            System.out.println("Size is: " + CardUtilities.flash.size());
         
            if(SelectTestPan.radio1.isSelected())
            {
               for(int i = 0; i < CardUtilities.addition.size(); i++)
               {
                  general.add(tempA[i]);
               }
            }
            
            if(SelectTestPan.radio2.isSelected())
            {
               for(int i = 0; i < CardUtilities.subtraction.size(); i++)
               {
                  general.add(tempS[i]);
                  
               }
            }
            
            if(SelectTestPan.radio4.isSelected())
            {
               for(int i = 0; i < CardUtilities.division.size(); i++)
               {
                  general.add(tempD[i]);
               }
            }
            
            if(SelectTestPan.radio3.isSelected())
            {
               for(int i = 0; i < CardUtilities.multiplication.size(); i++)
               {
                  
                  general.add(tempM[i]);
                  
               }
            } 
         
            Card[] extra = new Card[general.size()];
            general.toArray(extra);
            System.out.println("extra length" + extra.length);
            System.out.println("extra[0]" + extra[0].getCategory());
         
            JOptionPane.showMessageDialog(null, extra[index01].getHint(), "Monica's Flashcard Program",  JOptionPane.WARNING_MESSAGE);
         
         }  
      }
   
       private class Listener6 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            CardList general = new CardList();
               	      
            Card[] temp = new Card[CardUtilities.flash.size()];
            Card[] tempA = new Card[CardUtilities.addition.size()];
            Card[] tempS = new Card[CardUtilities.subtraction.size()];
            Card[] tempM = new Card[CardUtilities.multiplication.size()];
            Card[] tempD = new Card[CardUtilities.division.size()];
            CardUtilities.flash.toArray(temp);
            CardUtilities.addition.toArray(tempA);
            CardUtilities.subtraction.toArray(tempS);
            CardUtilities.division.toArray(tempD);
            CardUtilities.multiplication.toArray(tempM);
            
            for(int i = 0; i < CardUtilities.flash.size(); i++)
            {
               System.out.println("List is" + temp[i].getCategory());
            }
            System.out.println("Size is: " + CardUtilities.flash.size());
         
            if(SelectTestPan.radio1.isSelected())
            {
               for(int i = 0; i < CardUtilities.addition.size(); i++)
               {
                  general.add(tempA[i]);
               }
            }
            
            if(SelectTestPan.radio2.isSelected())
            {
               for(int i = 0; i < CardUtilities.subtraction.size(); i++)
               {
                  general.add(tempS[i]);
                  
               }
            }
            
            if(SelectTestPan.radio4.isSelected())
            {
               for(int i = 0; i < CardUtilities.division.size(); i++)
               {
                  general.add(tempD[i]);
               }
            }
            
            if(SelectTestPan.radio3.isSelected())
            {
               for(int i = 0; i < CardUtilities.multiplication.size(); i++)
               {
                  
                  general.add(tempM[i]);
                  
               }
            } 
            Card[] extra = new Card[general.size()];
            general.toArray(extra);
            System.out.println("extra length" + extra.length);
            System.out.println("extra[0]" + extra[0].getAnswer());  
            
            System.out.println("The answer is: " + extra[index01].getAnswer());
            System.out.println("This was entered: " + text1.getText());
         	
            if(Integer.parseInt(text1.getText()) == extra[index01].getAnswer())
            {
               text1.setForeground(Color.GREEN);
            }
            else
            {
               text1.setForeground(Color.RED);
            }
         }
      }  
   }  
      
