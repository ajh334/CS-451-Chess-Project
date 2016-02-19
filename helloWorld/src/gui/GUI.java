package gui;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;


public interface GUI
{
	public JPanel getPanel();
	public void getButton(JButton b);	
	public void getText(JTextField t);
	public void getLabel(JLabel l);
	public void getPic(JLabel p);
}
