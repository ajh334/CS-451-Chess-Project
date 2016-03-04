package panels;
 //Name: Kofi Lewis
 //Purpose: This module designs a screen where the user can add a Card    
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
    public class AddCardPan extends JPanel
   {
      private JTextField text1, text2, text4, text5;
      private JTextArea textArea1;
      private JComboBox combo;
      private JLabel label;
       
       private JLabel addLabel(JPanel panel, String s)
      {
         JLabel temp = new JLabel(s);
         temp.setForeground(new Color(255,0,0));
         temp.setBackground(new Color(0,0,255));
         temp.setFont(new Font("Lucida Bright", Font.BOLD, 16));
         temp.setHorizontalAlignment(SwingConstants.LEFT);
         panel.add(temp);
         return temp;
      }
   
       private JButton addButton(JPanel panel, String s, ActionListener li)
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
         temp.setFont(new Font("Courier", Font.PLAIN, 16));
         temp.setForeground(c);
         temp.setBackground(s);
         panel.add(temp);
         return temp;
      }
      
       private JTextArea addArea(JPanel panel, Color c, Color s)
      {
         JTextArea temp = new JTextArea(10,10);
         temp.setFont(new Font("Courier", Font.PLAIN, 16));
         temp.setForeground(c);
         temp.setBackground(s);
         temp.setLineWrap(true);
         JScrollPane temp2 = new JScrollPane(temp);
         panel.add(temp2);
         return temp;
      }
   	
       private JComboBox addCombo(JPanel panel, Color c, Color s)
      {
         JComboBox temp = new JComboBox();
         temp.setFont(new Font("Lucida Bright", Font.PLAIN, 12));
         temp.setForeground(c);
         temp.setBackground(s);
         
         panel.add(temp);
         return temp;
      }
          
   //**MASTERY FACTOR**\\ 16: Use of additional libraries    
       public AddCardPan()
      {	      
         setLayout(new BorderLayout());
         	      
         JPanel fieldName = new JPanel();
         fieldName.setLayout(new GridLayout(5, 2));
         fieldName.setBackground(new Color(0,0,255));
         add(fieldName, BorderLayout.NORTH);
      	          
         addLabel(fieldName, "Category");
         combo = addCombo(fieldName, new Color(0,0,255), new Color(255,0,0));
         combo.addItem("Addition");
         combo.addItem("Subtraction");
         combo.addItem("Division");
         combo.addItem("Multiplication");
         combo.addItemListener(new ItemListener1());
      
      	
         addLabel(fieldName, "First Number");
         text2 = addText(fieldName, 10, new Color(255,0,0), new Color(0,0,255));
      	
         addLabel(fieldName, "Operation");
         label = addLabel(fieldName, "+");//new Color(0,0,255), new Color(255,0,0));
      	            
         addLabel(fieldName, "Second Number");
         text4 = addText(fieldName, 10, new Color(255,0,0),new Color(0,0,255));
      	
         addLabel(fieldName, "Answer");	
         text5 = addText(fieldName, 10, new Color(0,0,255), new Color(255,0,0));
      
         JPanel info = new JPanel();
         info.setLayout(new GridLayout(1,2));
         info.setBackground(new Color(0,0,255));
         add(info, BorderLayout.CENTER);
         
         addLabel(info, "Hint");
         textArea1 = addArea(info, new Color(255,0,0), new Color(255,255,255));
      	
         JPanel option = new JPanel();
         option.setLayout(new FlowLayout());
         option.setBackground(new Color(0,0,255));
         add(option, BorderLayout.SOUTH);
         addButton(option, "Add Card", new Listener());
         addButton(option, "Back", new Listener1());
      }
      

       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            Card newCard = new Card((String)(combo.getSelectedItem()), Integer.parseInt(text2.getText().trim()),label.getText().trim(),Integer.parseInt(text4.getText().trim()), textArea1.getText(),Integer.parseInt(text5.getText().trim()));
         
            CardUtilities.flash.add(newCard);
            if(combo.getSelectedItem().equals("Addition"))
            {
               CardUtilities.addition.add(newCard);
            }
            else if(combo.getSelectedItem().equals("Subtraction"))
            {
               CardUtilities.subtraction.add(newCard);
            }
            else if(combo.getSelectedItem().equals("Division"))
            {
               CardUtilities.division.add(newCard);
            }
            else if(combo.getSelectedItem().equals("Multiplication"))
            {
               CardUtilities.multiplication.add(newCard);
            }
         	
            combo.setSelectedItem("Addition");
            text2.setText("");
            label.setText("+");
            text4.setText("");
            text5.setText("");
         
            textArea1.setText("");				                      
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
            CardPanel.frameAdd.dispose();
         }
      }
      
       private class ItemListener1 implements ItemListener
      {
          public void itemStateChanged(ItemEvent ie)
         {  
			//##ERROR HANDLING##\\
			//User errors are handled by changing the operation symbol assigned to the card based on the category chosen. 
			//This keeps the user from inputting the wrong operation.  
			//This control is handled through JComboBoxes that, when clicked, change the operation label to the correct operation    
    
            if(combo.getSelectedItem() == "Addition")
            { 
               label.setText("+");
            }
            else if(combo.getSelectedItem() == "Subtraction")
            {
               label.setText("-");
            }
            
            else if(combo.getSelectedItem() == "Division")
            {
               label.setText("/");
            }
            else if(combo.getSelectedItem() == "Multiplication")
            {
               label.setText("*");
            }
         
         }   
      }
   
   }
