package unit_tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;

import chess.Space;
import gui.BoardGUI;

public class BoardGUITest {

	@Test
	public void testInitializeBoardGui() {
		
		BoardGUI gui = new BoardGUI();

		Space[][] spaces = gui.getSpaces();
		
		assertEquals(8, spaces.length);
		
		// Check square and piece color
        for (int x = 0; x < spaces.length; x++) 
        {
        	assertEquals(8, spaces[x].length);
            for (int y = 0; y < spaces[x].length; y++) 
            {
                
                if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) {
                    assertEquals(Color.WHITE, spaces[x][y].getBackground());
                } else {
                	assertEquals(Color.DARK_GRAY, spaces[x][y].getBackground());
                }
                
                if(y <= 1){
                	assertTrue(!spaces[x][y].getPiece().getColor().isWhite());
                }
                if(y >= 6){
                	assertTrue(spaces[x][y].getPiece().getColor().isWhite());
                }
            }
        }
        
        // Check pawn positions; 
        for(int x = 0; x < spaces.length; x++)
        {
        	assertEquals("P", spaces[x][1].getPiece().getPieceName());
        	assertEquals("P", spaces[x][6].getPiece().getPieceName());
        }
        
        // Check rook positions 
        assertEquals("R", spaces[0][0].getPiece().getPieceName());
    	assertEquals("R", spaces[0][7].getPiece().getPieceName());
    	assertEquals("R", spaces[7][0].getPiece().getPieceName());
    	assertEquals("R", spaces[7][7].getPiece().getPieceName());
    	
    	// Check knight positions 
        assertEquals("H", spaces[1][0].getPiece().getPieceName());
    	assertEquals("H", spaces[1][7].getPiece().getPieceName());
    	assertEquals("H", spaces[6][0].getPiece().getPieceName());
    	assertEquals("H", spaces[6][7].getPiece().getPieceName());
    	
    	// Check bishop positions 
        assertEquals("B", spaces[2][0].getPiece().getPieceName());
    	assertEquals("B", spaces[2][7].getPiece().getPieceName());
    	assertEquals("B", spaces[5][0].getPiece().getPieceName());
    	assertEquals("B", spaces[5][7].getPiece().getPieceName());
    	
    	// Check queen positions
    	assertEquals("Q", spaces[3][0].getPiece().getPieceName());
    	assertEquals("Q", spaces[3][7].getPiece().getPieceName());
    	
    	// Check king positions
    	assertEquals("K", spaces[4][0].getPiece().getPieceName());
    	assertEquals("K", spaces[4][7].getPiece().getPieceName());
	}
}
