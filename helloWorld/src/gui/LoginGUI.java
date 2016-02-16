package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

import chess.ChessBoard;
import chess.ChessColor;
import chess.Space;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import test.HelloWorld;


public class LoginGUI extends JPanel 
{
	static JFrame frameMenu = new JFrame("Chess Champ");
	
	static Color ochre = new Color(204,119,34);
	private JLabel welcome;
	private JTextField username;
	private JButton login;

 private JLabel addLabel(JPanel banner, String s)
{
   JLabel temp = new JLabel(s);
   temp.setForeground(Color.BLACK);
   temp.setBackground(ochre);
   temp.setFont(new Font("Lucida Bright", Font.BOLD, 25));
   temp.setHorizontalAlignment(SwingConstants.CENTER);
   banner.add(temp);
   return temp;
}

 private JLabel addPic(JPanel picture, Icon i)
{
   JLabel temp = new JLabel(i);
   temp.setFont(new Font("Lucida Bright", Font.BOLD, 25));
   temp.setBackground(ochre);
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

 private JTextField addText(JPanel panel, int x, Color c, Color s)
 {
    JTextField temp = new JTextField(x);
    temp.setFont(new Font("Courier", Font.PLAIN, 16));
    temp.setForeground(c);
    temp.setBackground(s);
    panel.add(temp);
    return temp;
 }
 

 public LoginGUI()
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
   option.setBackground(ochre);
   add(option, BorderLayout.SOUTH);
   username = addText(option, 20, Color.BLACK, Color.WHITE);
   login = addButton(option, "Login", "Click here to login", new LoginListener());
}
   
 private class LoginListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
   {
    	String user = username.getText();
    	System.out.println("Username pulled from textfield: " + user);
    	HelloWorld.f.dispose();
    	
    	frameMenu.setSize(805,525);
    	frameMenu.setLocationByPlatform(true);
    	frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frameMenu.setContentPane(new MenuGUI(user));
		frameMenu.pack();
		frameMenu.setVisible(true);           
   }
}
}
