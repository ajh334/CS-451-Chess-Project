package gui;

import java.awt.BorderLayout;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import chess.ChessColor;
import chess.Space;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import clientserver.ChessClient;
import test.ChessChamp;


public class LoginPanel extends JPanel  
{
	static JFrame frameMenu = new JFrame("Chess Champ");
	
	static Color ochre = new Color(204,119,34);
	private JLabel welcome;
	private JLabel error;
	private JTextField username;
	private JButton login;
	private ChessClient client;
	

 public JLabel addLabel(JPanel banner, String s)
{
   JLabel temp = new JLabel(s);
   temp.setForeground(Color.BLACK);
   temp.setBackground(ochre);
   temp.setFont(new Font("Lucida Bright", Font.BOLD, 25));
   temp.setHorizontalAlignment(SwingConstants.CENTER);
   banner.add(temp);
   return temp;
}

 public JLabel addPic(JPanel picture, Icon i)
{
   JLabel temp = new JLabel(i);
   temp.setFont(new Font("Lucida Bright", Font.BOLD, 25));
   temp.setBackground(ochre);
   picture.add(temp);
   return temp;
}

 public JButton addButton(JPanel option, String s, String t, ActionListener li)
{
   JButton temp = new JButton();
   temp.setText(s);
   temp.addActionListener(li);
   temp.setToolTipText(t); 
   option.add(temp);
   return temp;
}

 public JTextField addText(JPanel panel, int x, Color c, Color s)
 {
    JTextField temp = new JTextField(x);
    temp.setFont(new Font("Courier", Font.PLAIN, 16));
    temp.setForeground(c);
    temp.setBackground(s);
    panel.add(temp);
    return temp;
 }
 

 public LoginPanel()
{
   ImageIcon i = new ImageIcon("chess.jpg");      
   setLayout(new BorderLayout());
   	      
   JPanel banner = new JPanel();
   banner.setLayout(new FlowLayout());
   banner.setBackground(ochre);
   add(banner, BorderLayout.NORTH);
   welcome = addLabel(banner, "Chess Champ");
   
   JPanel picture = new JPanel();
   picture.setLayout(new GridLayout(1,1));
   add(picture, BorderLayout.CENTER);
   picture.setBackground(ochre);
   addPic(picture, i);
	
   JPanel option = new JPanel();
   option.setLayout(new GridLayout(2,2));
   option.setBackground(ochre);
   add(option, BorderLayout.SOUTH);
   username = addText(option, 20, Color.BLACK, Color.WHITE);
   username.getDocument().addDocumentListener(new DocumentListener() {
	   public void changedUpdate(DocumentEvent e) {
		    changed();
		  }
		  public void removeUpdate(DocumentEvent e) {
		    changed();
		  }
		  public void insertUpdate(DocumentEvent e) {
		    changed();
		  }

		  public void changed() {
		     if (username.getText().equals("")){
		       login.setEnabled(false);
		     }
		     else {
		       login.setEnabled(true);
		    }

		  }
		});
   
   login = addButton(option, "Login", "Click here to login", new LoginListener());
   login.setActionCommand("UnAuth");
   login.setEnabled(false);
   error = addLabel(option, " ");
   error.setForeground(Color.RED);
   error.setFont(new Font("Lucida Bright",Font.PLAIN, 12));
}
 
 public JButton getLoginButton()
 {
	 return login;
 }
 
 public JTextField getUsernameTextField()
 {
	 return username;
 }
 
 public JLabel getWelcomeLabel()
 {
	 return welcome;
 }
 
 public ChessClient getClient()
 {
	 return client;
 }
 public void setClient(ChessClient cc)
 {
	 client = cc;
 }
 
 public Boolean checkUserName(Statement st, ResultSet rs, String usr, int ctr) throws SQLException
 {
	 if(!rs.next())
	 {
		 st.executeUpdate("insert into login(PlayerID, username)" + " values(" + ctr + ", \"" + usr + "\")");
		 login.setActionCommand("Auth");
		 System.out.println("login status: " + login.getActionCommand());
		 return true;
	 }
	 String test = rs.getString("username");
	 System.out.println("Found username: " + test);
	 if(test.equals(usr))
	 {
		 System.out.println(usr + " already exists");
		 rs.beforeFirst();
		 return false;
	 }
	 else
	 {
		 ctr++;
		 System.out.println("increment counter: " + ctr);
		 return checkUserName(st, rs, usr, ctr);
	 }
 }
 
 public static boolean isWhiteSpace(String str) {
     if (str == null) {
         return false;
     }
     int sz = str.length();
     for (int i = 0; i < sz; i++) {
         if ((Character.isWhitespace(str.charAt(i)) == false)) {
             return false;
         }
     }
     return true;
 }

   
 private class LoginListener implements ActionListener
{
	   String password = "D4vinci1337";
	   String user = "root";
    public void actionPerformed(ActionEvent e)
   {
    	login.setActionCommand("UnAuth");
    	String user = username.getText();
    	if(isWhiteSpace(user) || user == null)
    	{
    		error.setText("Username must contain some characters");
    		return;
    	}
    	System.out.println("Username pulled from textfield: " + user);
    	Connection con = null;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Class not found");
			e1.printStackTrace();
		}
    	
    	try 
    	{
			con = DriverManager.getConnection("jdbc:mysql://localhost/test", this.user, this.password);			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("select username from login");
			if (!rs.isBeforeFirst() ) 
			{    
				 System.out.println("No data"); 
			} 
			int i = 0;
			
			if(!checkUserName(st, rs, user, i))
			{
				error.setText("Username taken");
				return;
			}
			else
			{
			error.setForeground(Color.GREEN);
			error.setText("Authorized. Logging in...");
			MenuGUI menu = new MenuGUI(user, client);
	    	frameMenu.setSize(805,525);
	    	frameMenu.setLocationByPlatform(true);
	    	frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frameMenu.setContentPane(menu.getPanel());
			frameMenu.pack();
			frameMenu.setVisible(true);
			}
			con.close();
		} 
    	catch (SQLException e1) 
    	{
			System.out.println("Database error");
			e1.printStackTrace();
		}

   }
}
}
