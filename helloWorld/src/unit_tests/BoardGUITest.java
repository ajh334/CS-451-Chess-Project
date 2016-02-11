package unit_tests;

import static org.junit.Assert.*;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;

import gui.BoardGUI;

public class BoardGUITest {

	@Test
	public void testInitializeBoardGui() {
		
		BoardGUI gui = new BoardGUI();

		JButton[][] spaces = gui.getSpaces();
		
		assertEquals(8, spaces.length);
		
        for (int i = 0; i < 8; i++)
        {
        	assertEquals(8, spaces[i].length);
        	
        }
        
	}

}
