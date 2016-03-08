package gui;

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

public class MenuPanel extends JPanel {
	static JFrame frameMenu = new JFrame("ChessChamp");

	static Color ochre = new Color(204, 119, 34);
	private JLabel userNameLabel;
	private JLabel username;
	private JButton findGame;
	private JButton exit;
	private String user;
	private ChessClient client;

	private JLabel addLabel(JPanel banner, String s) {
		JLabel temp = new JLabel(s);
		temp.setForeground(Color.BLACK);
		temp.setBackground(ochre);
		temp.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		temp.setHorizontalAlignment(SwingConstants.CENTER);
		banner.add(temp);
		return temp;
	}

	private JLabel addPic(JPanel picture, Icon i) {
		JLabel temp = new JLabel(i);
		temp.setFont(new Font("Lucida Bright", Font.BOLD, 25));
		temp.setBackground(ochre);
		picture.add(temp);
		return temp;
	}

	private JButton addButton(JPanel option, String s, String t, ActionListener li) {
		JButton temp = new JButton();
		temp.setText(s);
		temp.addActionListener(li);
		temp.setToolTipText(t);
		option.add(temp);
		return temp;
	}

	private JTextField addText(JPanel panel, int x, Color c, Color s) {
		JTextField temp = new JTextField(x);
		temp.setFont(new Font("Courier", Font.PLAIN, 16));
		temp.setForeground(c);
		temp.setBackground(s);
		panel.add(temp);
		return temp;
	}

	public MenuPanel(String u) {
		System.out.println("Username pased to MenuGUI: " + u);
		user = u;
		System.out.println("Username assigned in MenuGUI: " + u);

		// ImageIcon i = new ImageIcon("chess.jpg");
		setLayout(new BorderLayout());

		JPanel banner = new JPanel();
		banner.setLayout(new GridLayout(2, 1));
		banner.setBackground(ochre);
		add(banner, BorderLayout.NORTH);
		userNameLabel = addLabel(banner, "Username: ");
		username = addLabel(banner, user);

		JPanel option = new JPanel();
		option.setBackground(ochre);
		add(option, BorderLayout.SOUTH);
		findGame = addButton(option, "Find Game", "Click here to find a game", new FindGameListener());
		exit = addButton(option, "Exit", "Click here to exit program", new ExitListener());
	}

	public JLabel getUserNameLabel() {
		return userNameLabel;
	}

	public JLabel getUserName() {
		return username;
	}

	public JButton getFindGameButton() {
		return findGame;
	}

	public JButton getExitButton() {
		return exit;
	}
	
	 public ChessClient getClient()
	 {
		 return client;
	 }
	 public void setClient(ChessClient cc)
	 {
		 client = cc;
	 }

	private class FindGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ChessChamp.f.dispose();

			ChessChamp.f.dispose();
			frameMenu.setSize(805, 525);
			frameMenu.setLocationByPlatform(true);
			frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameMenu.setContentPane(new BoardGUI(true).getGUI());
			frameMenu.pack();
			frameMenu.setVisible(true);
		}
	}

	// private class Listener1 implements ActionListener
	// {
	// public void actionPerformed(ActionEvent e)
	// {
	// DriverCard.frame.dispose();
	// frameAdd.setSize(425,325);
	// frameAdd.setLocation(100, 200);
	// frameAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// frameAdd.setContentPane(new AddCardPan());
	// frameAdd.setVisible(true);
	// }
	// }
	//
	// private class Listener2 implements ActionListener
	// {
	// public void actionPerformed(ActionEvent e)
	// {
	// DriverCard.frame.dispose();
	// frameDelete.setSize(425,325);
	// frameDelete.setLocation(100, 200);
	// frameDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// frameDelete.setContentPane(new DeleteCardPan());
	// frameDelete.setVisible(true);
	// }
	// }
	// private class Listener4 implements ActionListener
	// {
	// public void actionPerformed(ActionEvent e)
	// {
	//// ##ERROR HANDLING##\\
	//// User errors are handled by allowing JOptionPanes to pop up and ask
	// users if they are sure they wish to save
	// int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to
	// save?", "Mrs. Lewis' Flashcard Program", JOptionPane.YES_NO_OPTION);
	//
	// //**MASTERY FACTOR**\\ 12-15:The use of any five standard level mastery
	// factors
	// //Standard Level Mastery Factor 4: Simple Selection(if-else)
	// if(reply == 0)
	// {
	// CardUtilities.writeFile("CardData.txt", CardUtilities.flash);
	// }
	// else
	// {
	//
	// }
	// }
	// }

	private class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	// private class Listener6 implements ActionListener
	// {
	// public void actionPerformed(ActionEvent e)
	// {
	// DriverCard.frame.dispose();
	//
	// frameTest.setSize(525,525);
	// frameTest.setLocation(100, 200);
	// frameTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// frameTest.setContentPane(new SelectTestPan());
	// frameTest.setVisible(true);
	//
	// }
	// }
}
