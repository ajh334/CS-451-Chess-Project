package gui;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;


public interface GUI
{
	public JPanel getPanel();
	public JButton getButton(String s);	
	public JTextField getText(String s);
	public JLabel getLabel(String s);
	//public JLabel getPic(String s);
}
