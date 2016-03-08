package gui;

import java.awt.BorderLayout;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

import chess.ChessColor;
import chess.Space;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import clientserver.ChessClient;
import test.ChessChamp;
import java.sql.*;


public class MenuGUI implements GUI
{
	static JFrame frameMenu = new JFrame("Chess Champ");
	
	private MenuPanel panel;

 public MenuGUI(String user)
{
  panel = new MenuPanel(user);
}
 public MenuGUI(String user, ChessClient cc)
 {
	 panel = new MenuPanel(user);
	 panel.setClient(cc);
 }

@Override
public JPanel getPanel() 
{
	return panel;
}

@Override
public JButton getButton(String s) 
{
	switch(s.toLowerCase().trim())
	{
	case "find game": return panel.getFindGameButton();
	case "exit":
	}
	System.out.println("error: no button found with that tag");
	return null;
}

@Override
public JTextField getText(String s) 
{
	System.out.println("error: no textfields on this panel");
	return null;
	
}

@Override
public JLabel getLabel(String s) 
{
	switch(s.toLowerCase().trim())
	{
	case "username": return panel.getUserName();
	case "username label": return panel.getUserNameLabel();
	}
	System.out.println("error: no label found with that tag");
	return null;
}

public Boolean checkLogin()
{
	return false;
}

}