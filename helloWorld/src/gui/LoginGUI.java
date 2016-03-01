package gui;

import java.awt.BorderLayout;

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
import java.sql.*;


public class LoginGUI implements GUI
{
	static JFrame frameMenu = new JFrame("Chess Champ");
	
	private LoginPanel panel;
	private Connection con = null;

 public LoginGUI()
{
  panel = new LoginPanel();
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
	case "login": return panel.getLoginButton();
	}
	System.out.println("error: no button found with that tag");
	return null;
}

@Override
public JTextField getText(String s) 
{
	switch(s.toLowerCase().trim())
	{
	case "username": return panel.getUsernameTextField();
	}
	System.out.println("error: no button found with that tag");
	return null;
	
}

@Override
public JLabel getLabel(String s) 
{
	switch(s.toLowerCase().trim())
	{
	case "username": return panel.getWelcomeLabel();
	}
	System.out.println("error: no button found with that tag");
	return null;
}

public Boolean checkLogin()
{
	return false;
}

}
