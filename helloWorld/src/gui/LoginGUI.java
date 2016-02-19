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


public class LoginGUI implements GUI
{
	static JFrame frameMenu = new JFrame("Chess Champ");
	
	private JPanel panel;

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
public void getButton(String s) 
{
	panel.getButton();
	
}

@Override
public void getText(JTextField t) {
	// TODO Auto-generated method stub
	
}

@Override
public void getLabel(JLabel l) {
	// TODO Auto-generated method stub
	
}

@Override
public void getPic(JLabel p) {
	// TODO Auto-generated method stub
	
}
 
}
