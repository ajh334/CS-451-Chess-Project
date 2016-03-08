package unit_tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;

import chess.ChessColor;
import chess.MoveValidation;
import chess.Space;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Rook;
import gui.BoardGUI;

public class BoardGUITest {

	@Test
	public void testInitializeBoardGui() {
		
		BoardGUI gui = new BoardGUI(true);

		Space[][] spaces = gui.getSpaces();
		
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
	
	@Test
	public void testHighlightBoard() 
	{
		BoardGUI gui = new BoardGUI(true);

		Space[][] spaces = gui.getSpaces();
		
		for (int x = 0; x < spaces.length; x++) {
            for (int y = 0; y < spaces[x].length; y++) {
                spaces[x][y].deletePiece();
            }
        }
		
		MoveValidation mv = new MoveValidation();

		ChessColor color = new ChessColor(true);
		Rook piece = new Rook(color,  3,  4);
		spaces[3][4].setPiece(piece);
		
		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color,  3,  6);
		spaces[3][6].setPiece(piece2);
		
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color,  3,  0);
		spaces[3][0].setPiece(piece3);
		
		color = new ChessColor(false);
		Pawn piece4 = new Pawn(color,  1,  4);
		spaces[1][4].setPiece(piece4);
		
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  7,  4);
		spaces[7][4].setPiece(piece5);
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(addPieces(spaces), spaces[3][4].getPiece(), false, false);
		
		
		gui.addHighlightListener(spaces[3][4]);
 
		
	
		
		for (int x = 0; x < spaces.length; x++) 
        {
            for (int y = 0; y < spaces[x].length; y++) 
            {
            	if(moveExists(moveList, x,y))
            	{
            		assertEquals(Color.CYAN, spaces[x][y].getBackground());
            	}
            	else
            	{
            		if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) 
            		{
                        assertEquals(Color.WHITE, spaces[x][y].getBackground());
                    } else 
                    {
                    	assertEquals(Color.DARK_GRAY, spaces[x][y].getBackground());
                    }
            	}
            }
        }
	}


	@Test
	public void testDehighlightBoard() 
	{
		BoardGUI gui = new BoardGUI(true);

		Space[][] spaces = gui.getSpaces();
		
		for (int x = 0; x < spaces.length; x++) {
            for (int y = 0; y < spaces[x].length; y++) {
                spaces[x][y].deletePiece();
            }
        }
		
		MoveValidation mv = new MoveValidation();

		ChessColor color = new ChessColor(true);
		Rook piece = new Rook(color,  3,  4);
		spaces[3][4].setPiece(piece);
		
		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color,  3,  6);
		spaces[3][6].setPiece(piece2);
		
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color,  3,  0);
		spaces[3][0].setPiece(piece3);
		
		color = new ChessColor(false);
		Pawn piece4 = new Pawn(color,  1,  4);
		spaces[1][4].setPiece(piece4);
		
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  7,  4);
		spaces[7][4].setPiece(piece5);
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(addPieces(spaces), spaces[3][4].getPiece(), false, false);
		
		gui.addHighlightListener(spaces[3][4]);
		
		gui.deHighlightButtons();
		
		// Check square and piece color
        for (int x = 0; x < spaces.length; x++) 
        {
            for (int y = 0; y < spaces[x].length; y++) 
            {
                
                if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) {
                    assertEquals(Color.WHITE, spaces[x][y].getBackground());
                } else {
                	assertEquals(Color.DARK_GRAY, spaces[x][y].getBackground());
                }
            }
        }
	}
	
	//--------------------------------------------------------------
	//--- Tests that if a piece is selects a second time it will ---
	//--- instead be unselected                                  ---
    //--------------------------------------------------------------
	@Test
	public void testDeselectPiece() 
	{
		BoardGUI gui = new BoardGUI(true);

		Space[][] spaces = gui.getSpaces();
		
		for (int x = 0; x < spaces.length; x++) {
            for (int y = 0; y < spaces[x].length; y++) {
                spaces[x][y].deletePiece();
            }
        }
		
		MoveValidation mv = new MoveValidation();

		ChessColor color = new ChessColor(true);
		Rook piece = new Rook(color,  3,  4);
		spaces[3][4].setPiece(piece);
		
		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color,  3,  6);
		spaces[3][6].setPiece(piece2);
		
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color,  3,  0);
		spaces[3][0].setPiece(piece3);
		
		color = new ChessColor(false);
		Pawn piece4 = new Pawn(color,  1,  4);
		spaces[1][4].setPiece(piece4);
		
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  7,  4);
		spaces[7][4].setPiece(piece5);
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(addPieces(spaces), spaces[3][4].getPiece(), false, false);
		
		gui.addHighlightListener(spaces[3][4]);
		
		// select piece a second time.
		gui.addHighlightListener(spaces[3][4]);
		
		// Check square and piece color
        for (int x = 0; x < spaces.length; x++) 
        {
            for (int y = 0; y < spaces[x].length; y++) 
            {
                
                if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) {
                    assertEquals(Color.WHITE, spaces[x][y].getBackground());
                } else {
                	assertEquals(Color.DARK_GRAY, spaces[x][y].getBackground());
                }
            }
        }
	}
	
	
	    //-----------------------------------------------------------------
		//--- Tests that if a piece is selected when other is already   ---
		//--- the board will unhighlight currently hightlighted squares ---
	    //--- and highlight moves for newly selected pieces             ---
	    //-----------------------------------------------------------------
		@Test
		public void testChangeSelection() 
		{
			BoardGUI gui = new BoardGUI(true);

			Space[][] spaces = gui.getSpaces();
			
			for (int x = 0; x < spaces.length; x++) {
	            for (int y = 0; y < spaces[x].length; y++) {
	                spaces[x][y].deletePiece();
	            }
	        }
			
			MoveValidation mv = new MoveValidation();

			ChessColor color = new ChessColor(true);
			Rook piece = new Rook(color,  3,  4);
			spaces[3][4].setPiece(piece);
			
			color = new ChessColor(false);
			Pawn piece2 = new Pawn(color,  3,  6);
			spaces[3][6].setPiece(piece2);
			
			color = new ChessColor(false);
			Pawn piece3 = new Pawn(color,  3,  0);
			spaces[3][0].setPiece(piece3);
			
			color = new ChessColor(false);
			Pawn piece4 = new Pawn(color,  1,  4);
			spaces[1][4].setPiece(piece4);
			
			color = new ChessColor(false);
			Pawn piece5 = new Pawn(color,  7,  4);
			spaces[7][4].setPiece(piece5);
			
			color = new ChessColor(true);
			Rook piece6 = new Rook(color, 7,  0);
			spaces[7][0].setPiece(piece6);
			
			
			gui.addHighlightListener(spaces[3][4]);
			
			
			// get moves
			ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(addPieces(spaces), spaces[7][0].getPiece(), false, false);
			
			// select piece a second time.
			gui.addHighlightListener(spaces[7][0]);
			
			// Check square and piece color
	        for (int x = 0; x < spaces.length; x++) 
	        {
	            for (int y = 0; y < spaces[x].length; y++) 
	            {
	                
	            	if(moveExists(moveList, x,y))
	            	{
	            		assertEquals(Color.CYAN, spaces[x][y].getBackground());
	            	}
	            	else
	            	{
	            		if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) 
	            		{
	                        assertEquals(Color.WHITE, spaces[x][y].getBackground());
	                    } else 
	                    {
	                    	assertEquals(Color.DARK_GRAY, spaces[x][y].getBackground());
	                    }
	            	}
	            }
	        }
		}
	
	@Test
	public void testMovePiece() 
	{
		BoardGUI gui = new BoardGUI(true);

		Space[][] spaces = gui.getSpaces();
		
		for (int x = 0; x < spaces.length; x++) {
            for (int y = 0; y < spaces[x].length; y++) {
                spaces[x][y].deletePiece();
            }
        }
		
		MoveValidation mv = new MoveValidation();

		ChessColor color = new ChessColor(true);
		Rook piece = new Rook(color,  3,  4);
		spaces[3][4].setPiece(piece);
		
		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color,  3,  6);
		spaces[3][6].setPiece(piece2);
		
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color,  3,  0);
		spaces[3][0].setPiece(piece3);
		
		color = new ChessColor(false);
		Pawn piece4 = new Pawn(color,  1,  4);
		spaces[1][4].setPiece(piece4);
		
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  7,  4);
		spaces[7][4].setPiece(piece5);
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(addPieces(spaces), spaces[3][4].getPiece(), false, false);
		
		gui.addHighlightListener(spaces[3][4]);
		
		gui.movePiece(spaces[3][4].getPiece(), 3, 0);
		
		
		assertEquals(null, spaces[3][4].getPiece());

    	assertEquals("R", spaces[3][0].getPiece().getPieceName());
		
		// Check square and piece color
        for (int x = 0; x < spaces.length; x++) 
        {
            for (int y = 0; y < spaces[x].length; y++) 
            {
                if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) {
                    assertEquals(Color.WHITE, spaces[x][y].getBackground());
                } else {
                	assertEquals(Color.DARK_GRAY, spaces[x][y].getBackground());
                }
            }
        }
		
	}
		
	public boolean moveExists(ArrayList<Integer[]> moveList, Integer x, Integer y){
		for(int i = 0; i < moveList.size(); i++){
			if(moveList.get(i)[0] == x &&  moveList.get(i)[1] == y){
				return true;
			}
		}
			
		return false;
	}
	
	public Piece[][] addPieces(Space[][] spaces) {
		Piece[][] pieces = new Piece[8][8];
		for (int i = 0; i < spaces.length; i++) {
			for (int j = 0; j < spaces.length; j++) {
				if (spaces[i][j] != null) {
					pieces[i][j] = spaces[i][j].getPiece();
				}
			}
		}
		return pieces;
	}
}
