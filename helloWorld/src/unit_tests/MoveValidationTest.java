package unit_tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.junit.Test;

import chess.ChessColor;
import chess.MoveValidation;
import chess.Space;
import chess.pieces.*;
import gui.BoardGUI;

public class MoveValidationTest {

	//------------------------------
	//-----                    -----
	//-----    TEST METHODS    -----
	//-----                    -----
	//------------------------------
	
	public Space[][] setupTestBoard()
	{
		Space[][] board = new Space[8][8];
		
		for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                Space b = new Space();
                board[x][y] = b;
            }
        }
		 return board;
	}
	
	
	public boolean moveExists(ArrayList<Integer[]> moveList, Integer x, Integer y){
		for(int i = 0; i < moveList.size(); i++){
			if(moveList.get(i)[0] == x &&  moveList.get(i)[1] == y){
				return true;
			}
		}
		
		return false;
	}
	
	//------------------------------
	//-----                    -----
	//-----     ROOK TESTS     -----
    //-----                    -----
    //------------------------------
	@Test
	public void testRookEmptyBoard() 
	{	
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		ChessColor color = new ChessColor(true);
		Rook piece = new Rook(color,  3,  4);
		board[3][4].setPiece(piece);
		
		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece(), false);
		
        //check if number of moves is equal to expected value of 14
		assertEquals(14, moveList.size());
		
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 0,4));
		assertTrue(moveExists(moveList, 1,4));
		assertTrue(moveExists(moveList, 2,4));
		assertTrue(moveExists(moveList, 4,4));
		assertTrue(moveExists(moveList, 5,4));
		assertTrue(moveExists(moveList, 6,4));
		assertTrue(moveExists(moveList, 7,4));
		assertTrue(moveExists(moveList, 3,0));
		assertTrue(moveExists(moveList, 3,1));
		assertTrue(moveExists(moveList, 3,2));
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 3,5));
		assertTrue(moveExists(moveList, 3,6));
		assertTrue(moveExists(moveList, 3,7));
		
	}
	
	
	@Test
	public void testRookBoardEdge() {
		
		MoveValidation mv = new MoveValidation();
		
		// Set up board for test
		Space[][] board = setupTestBoard();
		
		ChessColor color = new ChessColor(true);
		Rook piece = new Rook(color,  0,  0);
		board[0][0].setPiece(piece);
		
		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[0][0].getPiece(), false);
		
        //check if number of moves is equal to expected value of 14
		
		assertEquals(14, moveList.size());
		
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 1,0));
		assertTrue(moveExists(moveList, 2,0));
		assertTrue(moveExists(moveList, 3,0));
		assertTrue(moveExists(moveList, 4,0));
		assertTrue(moveExists(moveList, 5,0));
		assertTrue(moveExists(moveList, 6,0));
		assertTrue(moveExists(moveList, 7,0));
		assertTrue(moveExists(moveList, 0,1));
		assertTrue(moveExists(moveList, 0,2));
		assertTrue(moveExists(moveList, 0,3));
		assertTrue(moveExists(moveList, 0,4));
		assertTrue(moveExists(moveList, 0,5));
		assertTrue(moveExists(moveList, 0,6));
		assertTrue(moveExists(moveList, 0,7));
		
	}
	
	
	@Test
	public void testRookCaptures() 
	{	
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		ChessColor color = new ChessColor(true);
		Rook piece = new Rook(color,  3,  4);
		board[3][4].setPiece(piece);
		
		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color,  3,  6);
		board[3][6].setPiece(piece2);
		
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color,  3,  0);
		board[3][0].setPiece(piece3);
		
		color = new ChessColor(false);
		Pawn piece4 = new Pawn(color,  1,  4);
		board[1][4].setPiece(piece4);
		
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  7,  4);
		board[7][4].setPiece(piece5);
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece(), false);
		
        //check if number of moves is equal to expected value of 12
		
		assertEquals(12, moveList.size());
		
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 1,4));
		assertTrue(moveExists(moveList, 2,4));
		assertTrue(moveExists(moveList, 4,4));
		assertTrue(moveExists(moveList, 5,4));
		assertTrue(moveExists(moveList, 6,4));
		

		assertTrue(moveExists(moveList, 6,4));
		assertTrue(moveExists(moveList, 7,4));
		assertTrue(moveExists(moveList, 3,0));
		assertTrue(moveExists(moveList, 3,1));
		assertTrue(moveExists(moveList, 3,2));
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 3,5));
		assertTrue(moveExists(moveList, 3,6));
	}
	
	@Test
	public void testRookOwnPieceConflicts() 
	{
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		ChessColor color = new ChessColor(true);
		Rook piece = new Rook(color,  3,  4);
		board[3][4].setPiece(piece);
		
		color = new ChessColor(true);
		Pawn piece2 = new Pawn(color,  3,  6);
		board[3][6].setPiece(piece2);
		
		color = new ChessColor(true);
		Pawn piece3 = new Pawn(color,  3,  0);
		board[3][0].setPiece(piece3);
		
		color = new ChessColor(true);
		Pawn piece4 = new Pawn(color,  1,  4);
		board[1][4].setPiece(piece4);
		
		color = new ChessColor(true);
		Pawn piece5 = new Pawn(color,  7,  4);
		board[7][4].setPiece(piece5);
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece(), false);
		
        //check if number of moves is equal to expected value of 8
		
		assertEquals(8, moveList.size());
		
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,4));
		assertTrue(moveExists(moveList, 4,4));
		assertTrue(moveExists(moveList, 5,4));
		assertTrue(moveExists(moveList, 6,4));
		assertTrue(moveExists(moveList, 3,1));
		assertTrue(moveExists(moveList, 3,2));
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 3,5));
	}
	
	@Test
	public void testRookCheck() 
	{
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();

		
		ChessColor color = new ChessColor(true);
		Rook piece = new Rook(color,  3,  4);
		board[3][4].setPiece(piece);
		
		color = new ChessColor(false);
		Pawn blackPawn1 = new Pawn(color,  3,  6);
		board[3][6].setPiece( blackPawn1);
		
		color = new ChessColor(false);
		Pawn  blackPawn2 = new Pawn(color,  4,  6);
		board[4][6].setPiece( blackPawn1);
		
		color = new ChessColor(true);
		Pawn whitePawn = new Pawn(color,  1,  4);
		board[1][4].setPiece(whitePawn);
		
		color = new ChessColor(true);
		King whiteKing = new King(color,  1,  1);
		board[1][1].setPiece(whiteKing);
		
		color = new ChessColor(false);
		Rook blackRook = new Rook(color,  7,  1);
		board[7][1].setPiece(blackRook);
		
		color = new ChessColor(false);
		Pawn blackPawn3 = new Pawn(color,  7,  4);
		board[7][4].setPiece( blackPawn3);
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece(), false);
		
        //check if number of moves is equal to expected value of 1
		
		assertEquals(1, moveList.size());
		
		//check if number all expected moves exist in returned move list
		
		assertTrue(moveExists(moveList, 3,1));
	
	}
	
	
	//------------------------------
	//-----                    -----
    //-----    BISHOP TESTS    -----
	//-----                    -----
	//------------------------------	
	@Test
	public void testBishopEmptyBoard() 
	{			
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();

		ChessColor color = new ChessColor(true);
		Bishop piece = new Bishop(color,  4,  4);
		board[4][4].setPiece(piece);
			
		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
			
	    //check if number of moves is equal to expected value of 13
			
		assertEquals(13, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 0,0));
		assertTrue(moveExists(moveList, 1,1));
		assertTrue(moveExists(moveList, 2,2));
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 5,5));
		assertTrue(moveExists(moveList, 6,6));
		assertTrue(moveExists(moveList, 7,7));
			
		assertTrue(moveExists(moveList, 1,7));
		assertTrue(moveExists(moveList, 2,6));
		assertTrue(moveExists(moveList, 3,5));
		assertTrue(moveExists(moveList, 5,3));
		assertTrue(moveExists(moveList, 6,2));
		assertTrue(moveExists(moveList, 7,1));
	}
			
	@Test
	public void testBishopBoardEdge() 
	{		
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		ChessColor color = new ChessColor(true);
		Bishop piece = new Bishop(color,  0,  0);
		board[0][0].setPiece(piece);
			
		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[0][0].getPiece(), false);
			
		//check if number of moves is equal to expected value of 7
			
		assertEquals(7, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 1,1));
		assertTrue(moveExists(moveList, 2,2));
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 4,4));
		assertTrue(moveExists(moveList, 5,5));
		assertTrue(moveExists(moveList, 6,6));
		assertTrue(moveExists(moveList, 7,7));
			
	}
			
	@Test
	public void testBishopCaptures() 
	{	
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		ChessColor color = new ChessColor(true);
		Bishop piece = new Bishop(color,  4, 4);
		board[4][4].setPiece(piece);
			
		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color,  2, 2);
		board[2][2].setPiece(piece2);
			
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color,  6, 6);
		board[6][6].setPiece(piece3);
			
		color = new ChessColor(false);
		Pawn piece4 = new Pawn(color,  1,7);
		board[1][7].setPiece(piece4);
			
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  6,2);
		board[6][2].setPiece(piece5);
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
					
		//check if number of moves is equal to expected value of 9
						
		assertEquals(9, moveList.size());
						
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,2));
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 5,5));
		assertTrue(moveExists(moveList, 6,6));					
		assertTrue(moveExists(moveList, 1,7));
		assertTrue(moveExists(moveList, 2,6));
		assertTrue(moveExists(moveList, 3,5));
		assertTrue(moveExists(moveList, 5,3));
		assertTrue(moveExists(moveList, 6,2));

	}
	
	@Test
	public void testBishopOwnPieceConflicts() {
			
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		ChessColor color = new ChessColor(true);
		Bishop piece = new Bishop(color,  4, 4);
		board[4][4].setPiece(piece);
			
		color = new ChessColor(true);
		Pawn piece2 = new Pawn(color,  2, 2);
		board[2][2].setPiece(piece2);
			
		color = new ChessColor(true);
		Pawn piece3 = new Pawn(color,  6, 6);
		board[6][6].setPiece(piece3);
			
		color = new ChessColor(true);
		Pawn piece4 = new Pawn(color,  1,7);
		board[1][7].setPiece(piece4);
			
		color = new ChessColor(true);
		Pawn piece5 = new Pawn(color,  6,2);
		board[6][2].setPiece(piece5);
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
					
		//check if number of moves is equal to expected value of 9
						
		assertEquals(5, moveList.size());
						
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 5,5));					
		assertTrue(moveExists(moveList, 2,6));
		assertTrue(moveExists(moveList, 3,5));
		assertTrue(moveExists(moveList, 5,3));
	}
		
	@Test
	public void testBishopCheck() 
	{	
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		ChessColor color = new ChessColor(true);
		Bishop piece = new Bishop(color,  4, 4);
		board[4][4].setPiece(piece);
			
		color = new ChessColor(false);
		Rook piece2 = new Rook(color,  2, 2);
		board[2][2].setPiece(piece2);
			
		color = new ChessColor(true);
		King whiteKing = new King(color, 2, 4);
		board[2][4].setPiece(whiteKing);
			
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color,  6, 6);
		board[6][6].setPiece(piece3);
			
		color = new ChessColor(true);
		Pawn piece4 = new Pawn(color,  1,7);
		board[1][7].setPiece(piece4);
			
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  6,2);
		board[6][2].setPiece(piece5);
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
						
		//check if number of moves is equal to expected value of 1
						
		assertEquals(1, moveList.size());
						
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,2));

	}

	
	//------------------------------
	//-----                    -----
	//-----    QUEEN TESTS     -----
	//-----                    -----
	//------------------------------	
	@Test
	public void testQueenEmptyBoard() 
	{		
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();

		ChessColor color = new ChessColor(true);
		Queen piece = new Queen(color,  4,  4);
		board[4][4].setPiece(piece);
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
			
	    //check if number of moves is equal to expected value of 27
			
		assertEquals(27, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 0,0));
		assertTrue(moveExists(moveList, 1,1));
		assertTrue(moveExists(moveList, 2,2));
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 5,5));
		assertTrue(moveExists(moveList, 6,6));
		assertTrue(moveExists(moveList, 7,7));	
		assertTrue(moveExists(moveList, 1,7));
		assertTrue(moveExists(moveList, 2,6));
		assertTrue(moveExists(moveList, 3,5));
		assertTrue(moveExists(moveList, 5,3));
		assertTrue(moveExists(moveList, 6,2));
		assertTrue(moveExists(moveList, 7,1));
		assertTrue(moveExists(moveList, 0,4));
		assertTrue(moveExists(moveList, 1,4));
		assertTrue(moveExists(moveList, 2,4));
		assertTrue(moveExists(moveList, 3,4));
		assertTrue(moveExists(moveList, 5,4));
		assertTrue(moveExists(moveList, 6,4));
		assertTrue(moveExists(moveList, 7,4));
		assertTrue(moveExists(moveList, 4,0));
		assertTrue(moveExists(moveList, 4,1));
		assertTrue(moveExists(moveList, 4,2));
		assertTrue(moveExists(moveList, 4,3));
		assertTrue(moveExists(moveList, 4,5));
		assertTrue(moveExists(moveList, 4,6));
		assertTrue(moveExists(moveList, 4,7));
	}
		
		
	@Test
	public void testQueenBoardEdge() 
	{	
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		ChessColor color = new ChessColor(true);
		Queen piece = new Queen(color,  0,  0);
		board[0][0].setPiece(piece);
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[0][0].getPiece(), false);
			
		//check if number of moves is equal to expected value of 21
			
		assertEquals(21, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 1,1));
		assertTrue(moveExists(moveList, 2,2));
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 4,4));
		assertTrue(moveExists(moveList, 5,5));
		assertTrue(moveExists(moveList, 6,6));
		assertTrue(moveExists(moveList, 7,7));
		assertTrue(moveExists(moveList, 1,0));
		assertTrue(moveExists(moveList, 2,0));
		assertTrue(moveExists(moveList, 3,0));
		assertTrue(moveExists(moveList, 4,0));
		assertTrue(moveExists(moveList, 5,0));
		assertTrue(moveExists(moveList, 6,0));
		assertTrue(moveExists(moveList, 7,0));
		assertTrue(moveExists(moveList, 0,1));
		assertTrue(moveExists(moveList, 0,2));
		assertTrue(moveExists(moveList, 0,3));
		assertTrue(moveExists(moveList, 0,4));
		assertTrue(moveExists(moveList, 0,5));
		assertTrue(moveExists(moveList, 0,6));
		assertTrue(moveExists(moveList, 0,7));
			
	}
		
		
	@Test
	public void testQueenCaptures() 
	{
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		ChessColor color = new ChessColor(true);
		Queen piece = new Queen(color,  4, 4);
		board[4][4].setPiece(piece);
			
		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color,  2, 2);
		board[2][2].setPiece(piece2);
			
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color,  6, 6);
		board[6][6].setPiece(piece3);
			
		color = new ChessColor(false);
		Pawn piece4 = new Pawn(color,  1,7);
		board[1][7].setPiece(piece4);
			
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  6,2);
		board[6][2].setPiece(piece5);
		
		color = new ChessColor(false);
		Pawn piece6 = new Pawn(color,  4,  6);
		board[4][6].setPiece(piece6);
		
		color = new ChessColor(false);
		Pawn piece7 = new Pawn(color,  4,  0);
		board[4][0].setPiece(piece7);
		
		color = new ChessColor(false);
		Pawn piece8 = new Pawn(color,  1,  4);
		board[1][4].setPiece(piece8);
		
		color = new ChessColor(false);
		Pawn piece9 = new Pawn(color,  7,  4);
		board[7][4].setPiece(piece9);
		
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
					
		//check if number of moves is equal to expected value of 21
						
		assertEquals(21, moveList.size());
						
		//check if number all expected moves exist in returned move list

		assertTrue(moveExists(moveList, 2,2));
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 5,5));
		assertTrue(moveExists(moveList, 6,6));
		assertTrue(moveExists(moveList, 1,7));
		assertTrue(moveExists(moveList, 2,6));
		assertTrue(moveExists(moveList, 3,5));
		assertTrue(moveExists(moveList, 5,3));
		assertTrue(moveExists(moveList, 6,2));
		assertTrue(moveExists(moveList, 1,4));
		assertTrue(moveExists(moveList, 2,4));
		assertTrue(moveExists(moveList, 3,4));
		assertTrue(moveExists(moveList, 5,4));
		assertTrue(moveExists(moveList, 6,4));
		assertTrue(moveExists(moveList, 7,4));
		assertTrue(moveExists(moveList, 4,0));
		assertTrue(moveExists(moveList, 4,1));
		assertTrue(moveExists(moveList, 4,2));
		assertTrue(moveExists(moveList, 4,3));	
		assertTrue(moveExists(moveList, 4,5));
		assertTrue(moveExists(moveList, 4,6));


	}
	
	@Test
	public void testQueenOwnPieceConflicts() 
	{	
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		ChessColor color = new ChessColor(true);
		Queen piece = new Queen(color,  4, 4);
		board[4][4].setPiece(piece);
			
		color = new ChessColor(true);
		Pawn piece2 = new Pawn(color,  2, 2);
		board[2][2].setPiece(piece2);
			
		color = new ChessColor(true);
		Pawn piece3 = new Pawn(color,  6, 6);
		board[6][6].setPiece(piece3);
			
		color = new ChessColor(true);
		Pawn piece4 = new Pawn(color,  1,7);
		board[1][7].setPiece(piece4);
			
		color = new ChessColor(true);
		Pawn piece5 = new Pawn(color,  6,2);
		board[6][2].setPiece(piece5);
		
		color = new ChessColor(true);
		Pawn piece6 = new Pawn(color,  4,6);
		board[4][6].setPiece(piece6);
		
		color = new ChessColor(true);
		Pawn piece7 = new Pawn(color,  4,0);
		board[4][0].setPiece(piece7);
		
		color = new ChessColor(true);
		Pawn piece8 = new Pawn(color, 1,4);
		board[1][4].setPiece(piece8);
		
		color = new ChessColor(true);
		Pawn piece9 = new Pawn(color, 7, 4);
		board[7][4].setPiece(piece9);
		
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
					
		//check if number of moves is equal to expected value of 13
					
		assertEquals(13, moveList.size());
						
		//check if number all expected moves exist in returned move list

	
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 5,5));
		assertTrue(moveExists(moveList, 2,6));
		assertTrue(moveExists(moveList, 3,5));
		assertTrue(moveExists(moveList, 5,3));
		assertTrue(moveExists(moveList, 2,4));
		assertTrue(moveExists(moveList, 3,4));
		assertTrue(moveExists(moveList, 5,4));
		assertTrue(moveExists(moveList, 6,4));
		assertTrue(moveExists(moveList, 4,1));
		assertTrue(moveExists(moveList, 4,2));
		assertTrue(moveExists(moveList, 4,3));	
		assertTrue(moveExists(moveList, 4,5));

	}
		
	@Test
	public void testQueenCheck() 
	{		
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
			
		ChessColor color = new ChessColor(true);
		Queen piece = new Queen(color, 4, 4);
		board[4][4].setPiece(piece);
			
		color = new ChessColor(false);
		Rook piece2 = new Rook(color, 2, 2);
		board[2][2].setPiece(piece2);
			
		color = new ChessColor(true);
		King whiteKing = new King(color, 2, 4);
		board[2][4].setPiece(whiteKing);
			
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color, 6, 6);
		board[6][6].setPiece(piece3);
			
		color = new ChessColor(true);
		Pawn piece4 = new Pawn(color, 1,7);
		board[1][7].setPiece(piece4);
			
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color, 6,2);
		board[6][2].setPiece(piece5);
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
						
		//check if number of moves is equal to expected value of 13
						
		assertEquals(8, moveList.size());
						
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,2));

	}
	
	
	//------------------------------
	//-----                    -----
	//-----    KNIGHT TESTS    -----
    //-----                    -----
	//------------------------------
	
	@Test
	public void testKnightEmptyBoard() 
	{		
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
			
		ChessColor color = new ChessColor(true);
		Knight piece = new Knight(color, 4,  4);
		board[4][4].setPiece(piece);

		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
	
	    //check if number of moves is equal to expected value of 8
	    assertEquals(8, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 3,2));
		assertTrue(moveExists(moveList, 5,2));
		assertTrue(moveExists(moveList, 6,3));
		assertTrue(moveExists(moveList, 6,5));
		assertTrue(moveExists(moveList, 3,6));
		assertTrue(moveExists(moveList, 5,6));
		assertTrue(moveExists(moveList, 2,3));
		assertTrue(moveExists(moveList, 2,5));
	}
		
		
	@Test
	public void testknightBoardEdge() 
	{		
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		ChessColor color = new ChessColor(true);
		Knight piece = new Knight(color, 0,  0);
		board[0][0].setPiece(piece);
			
		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[0][0].getPiece(), false);
			
	    //check if number of moves is equal to expected value of 2
	    assertEquals(2, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 1,2));
		assertTrue(moveExists(moveList, 2,1));
		
	}
		
	@Test
	public void testKnightCaptures() 
	{	
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
			
		ChessColor color = new ChessColor(true);
		Knight piece = new Knight(color, 4,  4);
		board[4][4].setPiece(piece);
			
		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color,  3,  4);
	    board[3][4].setPiece(piece2);
			
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color,  2,  5);
		board[2][5].setPiece(piece3);
			
		color = new ChessColor(false);
		Pawn piece4 = new Pawn(color,  6,  3);
		board[6][3].setPiece(piece4);
			
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  4,  5);
		board[4][5].setPiece(piece5);
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
			
	    //check if number of moves is equal to expected value of 8
			
		assertEquals(8, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 3,2));
		assertTrue(moveExists(moveList, 5,2));
		assertTrue(moveExists(moveList, 6,3));
		assertTrue(moveExists(moveList, 6,5));
		assertTrue(moveExists(moveList, 3,6));
		assertTrue(moveExists(moveList, 5,6));
		assertTrue(moveExists(moveList, 2,3));
		assertTrue(moveExists(moveList, 2,5));
	
	}
		
	@Test
	public void testKnightOwnPieceConflicts() 
	{
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
			
		ChessColor color = new ChessColor(true);
		Knight piece = new Knight(color, 4,  4);
		board[4][4].setPiece(piece);
			
		color = new ChessColor(true);
		Pawn piece2 = new Pawn(color,  3,  4);
	    board[3][4].setPiece(piece2);
			
		color = new ChessColor(true);
		Pawn piece3 = new Pawn(color,  2,  5);
		board[2][5].setPiece(piece3);
			
		color = new ChessColor(true);
		Pawn piece4 = new Pawn(color,  6,  3);
		board[6][3].setPiece(piece4);
			
		color = new ChessColor(true);
		Pawn piece5 = new Pawn(color,  4,  5);
		board[4][5].setPiece(piece5);
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
			
	    //check if number of moves is equal to expected value of 6
		for(int i = 0; i < moveList.size(); i++){
			System.out.println(moveList.get(i)[0] + " " + moveList.get(i)[1]);
			
		}
		assertEquals(6, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 3,2));
		assertTrue(moveExists(moveList, 5,2));
		assertTrue(moveExists(moveList, 6,5));
		assertTrue(moveExists(moveList, 3,6));
		assertTrue(moveExists(moveList, 5,6));
		assertTrue(moveExists(moveList, 2,3));
	}
		
	@Test
	public void testKnightCheck() 
	{
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
	
		ChessColor color = new ChessColor(true);
		Knight piece = new Knight(color, 4,  4);
		board[4][4].setPiece(piece);
			
		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color,  3,  4);
	    board[3][4].setPiece(piece2);
			
		color = new ChessColor(false);
		Rook piece3 = new Rook(color,  2,  5);
		board[2][5].setPiece(piece3);
			
		color = new ChessColor(false);
		Pawn piece4 = new Pawn(color,  6,  3);
		board[6][3].setPiece(piece4);
			
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  4,  5);
		board[4][5].setPiece(piece5);
		
		color = new ChessColor(true);
		Pawn whiteKing = new Pawn(color,  3,  0);
		board[3][0].setPiece(whiteKing);
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece(), false);
			
	    //check if number of moves is equal to expected value of 8
			
		assertEquals(1, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,5));
	}
	

	//------------------------------
	//-----                    -----
	//-----     KING TESTS     -----
    //-----                    -----
	//------------------------------
	@Test
	public void testKingEmptyBoard() 
	{
		
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		// Add pieces to board for test
		ChessColor color = new ChessColor(true);
		King piece = new King(color, 4,  4);
		board[4][4].setPiece(piece);

		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
			
	    //check if number of moves is equal to expected value of 8
	    assertEquals(8, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 4,3));
		assertTrue(moveExists(moveList, 4,5));
		assertTrue(moveExists(moveList, 3,4));
		assertTrue(moveExists(moveList, 5,4));
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 3,5));
		assertTrue(moveExists(moveList, 5,3));
		assertTrue(moveExists(moveList, 5,5));
	}
		
		
	@Test
	public void testKingBoardEdge() 
	{		
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
				
		// Add pieces to board for test
		ChessColor color = new ChessColor(true);
		King piece = new King(color, 0,  0);
		board[0][0].setPiece(piece);

		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[0][0].getPiece(), false);
					
		//check if number of moves is equal to expected value of 3
		assertEquals(3, moveList.size());
					
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 1,0));
		assertTrue(moveExists(moveList, 0,1));
		assertTrue(moveExists(moveList, 1,1));
	}
		
	@Test
	public void testKingCaptures() 
	{	
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
			
		// Add pieces to board for test
		ChessColor color = new ChessColor(true);
		King piece = new King(color, 4,  4);
		board[4][4].setPiece(piece);

		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color,  3,  4);
	    board[3][4].setPiece(piece2);
			
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color,  5,  4);
		board[5][4].setPiece(piece3);
			
		color = new ChessColor(false);
		Pawn piece4 = new Pawn(color,  3,  5);
		board[3][5].setPiece(piece4);
			
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  5,  5);
		board[5][5].setPiece(piece5);
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
					
	    //check if number of moves is equal to expected value of 7
	    assertEquals(7, moveList.size());
					
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 4,3));
		assertTrue(moveExists(moveList, 3,4));
		assertTrue(moveExists(moveList, 5,4));
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 3,5));
		assertTrue(moveExists(moveList, 5,3));
		assertTrue(moveExists(moveList, 5,5));	
	}
		
	@Test
	public void testKingOwnPieceConflicts() {
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
					
		// Add pieces to board for test
		ChessColor color = new ChessColor(true);
		King piece = new King(color, 4,  4);
		board[4][4].setPiece(piece);

		color = new ChessColor(true);
		Pawn piece2 = new Pawn(color,  3,  4);
	    board[3][4].setPiece(piece2);
					
		color = new ChessColor(true);
		Pawn piece3 = new Pawn(color,  4, 5);
		board[4][5].setPiece(piece3);
					
		color = new ChessColor(true);
		Pawn piece4 = new Pawn(color,  3,  5);
		board[3][5].setPiece(piece4);
					
		color = new ChessColor(true);
		Pawn piece5 = new Pawn(color,  5,  5);
		board[5][5].setPiece(piece5);
				
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
							
		//check if number of moves is equal to expected value of 7
		assertEquals(4, moveList.size());
							
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 4,3));
		assertTrue(moveExists(moveList, 5,4));
		assertTrue(moveExists(moveList, 3,3));
		assertTrue(moveExists(moveList, 5,3));
	}
		
	@Test
	public void testKingCheck() 
	{
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
							
		// Add pieces to board for test
		ChessColor color = new ChessColor(true);
		King piece = new King(color, 4,  4);
		board[4][4].setPiece(piece);

		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color, 3, 3);
		board[3][3].setPiece(piece2);
				
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
									
		//check if number of moves is equal to expected value of 1
		assertEquals(1, moveList.size());
									
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 3, 3));

	}
	
	@Test
	public void testKingCastling() 
	{
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
							
		// Add pieces to board for test
		ChessColor color = new ChessColor(true);
		King whiteKing = new King(color, 4,  7);
		board[4][7].setPiece(whiteKing);

		color = new ChessColor(true);
		Rook whiteRook = new Rook(color, 0, 7);
		board[0][7].setPiece(whiteRook);
		
		color = new ChessColor(true);
		Rook whiteRook2 = new Rook(color, 7, 7);
		board[7][7].setPiece(whiteRook2);
		
		color = new ChessColor(false);
		King blackKing = new King(color, 4,  0);
		board[4][0].setPiece(blackKing);

		color = new ChessColor(false);
		Rook blackRook = new Rook(color, 0, 0);
		board[0][0].setPiece(blackRook);
		
		color = new ChessColor(false);
		Rook blackRook2 = new Rook(color, 7, 0);
		board[7][0].setPiece(blackRook2);
		
		//---------------------------------------
		//--- Check that castling is returned ---
		//--- with valid moves for white king ---
		//---------------------------------------
		
		// get moves for white king
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][7].getPiece(), false);
									
		//check if number of moves is equal to expected value of 7
		assertEquals(7, moveList.size());
									
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 3, 6));
		assertTrue(moveExists(moveList, 3, 7));
		assertTrue(moveExists(moveList, 4, 6));
		assertTrue(moveExists(moveList, 5, 6));
		assertTrue(moveExists(moveList, 5, 7));
		
		assertTrue(moveExists(moveList, 2, 7));
		assertTrue(moveExists(moveList, 6, 7));
		
		//---------------------------------------
		//--- Check that castling is returned ---
		//--- with valid moves for black king ---
		//---------------------------------------
				
		// get moves for black king
		moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][7].getPiece(), false);
											
		//check if number of moves is equal to expected value of 7
		assertEquals(7, moveList.size());
											
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 3, 0));
		assertTrue(moveExists(moveList, 3, 1));
		assertTrue(moveExists(moveList, 4, 1));
		assertTrue(moveExists(moveList, 5, 0));
		assertTrue(moveExists(moveList, 5, 1));
		
		assertTrue(moveExists(moveList, 2, 0));
		assertTrue(moveExists(moveList, 6, 0));
	}
	
	
	//------------------------------
	//-----                    -----
	//-----     Pawn TESTS     -----
    //-----                    -----
	//------------------------------
	@Test
	public void testWhitePawnEmptyBoard() 
	{
		
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		// Add pieces to board for test
		ChessColor color = new ChessColor(true);
		Pawn piece = new Pawn(color, 4,  4);
		piece.setHasMoved(true);
		board[4][4].setPiece(piece);

		color = new ChessColor(true);
		Pawn piece2 = new Pawn(color, 2,  6);
		board[2][6].setPiece(piece2);
		
		//---------------------------------------
		//--- Test Pawn not at initial square ---
		//---------------------------------------
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
			
	    //check if number of moves is equal to expected value of 1
	    assertEquals(1, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 4,3));
		
		//---------------------------------------
		//----  Test Pawn at initial square  ----
		//---------------------------------------
				
		// get moves
		moveList = (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[2][6].getPiece(), false);
					
		//check if number of moves is equal to expected value of 2
		assertEquals(2, moveList.size());
					
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,5));
		assertTrue(moveExists(moveList, 2,4));
	}
		
		
	@Test
	public void testWhitePawnBoardEdge() 
	{
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		// Add pieces to board for test
		ChessColor color = new ChessColor(true);
		Pawn piece = new Pawn(color, 0,  0);
		board[0][0].setPiece(piece);

		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[0][0].getPiece(), false);
			
	    //check if number of moves is equal to expected value of 1
	    assertEquals(0, moveList.size());	
	}
		
	@Test
	public void testWhitePawnCaptures() 
	{
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
			
		// Add pieces to board for test
		ChessColor color = new ChessColor(true);
		Pawn piece = new Pawn(color, 4,  4);
		piece.setHasMoved(true);
		board[4][4].setPiece(piece);
		
		color = new ChessColor(true);
		Pawn piece2 = new Pawn(color, 2,  6);
		board[2][6].setPiece(piece2);
			
		color = new ChessColor(true);
		Pawn piece3 = new Pawn(color, 6,  6);
		board[6][6].setPiece(piece3);

		color = new ChessColor(false);
		Pawn blackPiece = new Pawn(color,  6,  5);
		board[6][5].setPiece(blackPiece);
				
		color = new ChessColor(false);
		Pawn blackPiece2 = new Pawn(color,  2,  4);
		board[2][4].setPiece(blackPiece2);
				
		color = new ChessColor(false);
		Pawn blackPiece3 = new Pawn(color,  3,  5);
		board[3][5].setPiece(blackPiece3);
				
		color = new ChessColor(false);
		Pawn blackPiece4 = new Pawn(color,  4,  2);
		board[4][2].setPiece(blackPiece4);	
			
		color = new ChessColor(false);
		Pawn blackPiece5 = new Pawn(color,  4,  2);
		board[3][3].setPiece(blackPiece5);	
			
		//---------------------------------------
		//--- Test Pawn not at initial square ---
		//---------------------------------------
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
				
		//check if number of moves is equal to expected value of 2
		assertEquals(2, moveList.size());
				
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 4,3));
		assertTrue(moveExists(moveList, 3,3));
			
		//---------------------------------------
		//----  Test Pawn at initial square  ----
		//---------------------------------------
					
		// get moves
		moveList = (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[2][6].getPiece(), false);
						
		//check if number of moves is equal to expected value of 2
		assertEquals(2, moveList.size());
						
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,5));
		assertTrue(moveExists(moveList, 3,5));
		
		// get moves
		moveList = (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[6][6].getPiece(), false);
								
		//check if number of moves is equal to expected value of 2
		assertEquals(0, moveList.size());
	}
		
	@Test
	public void testWhitePawnPieceConflicts() 
	{
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
					
		// Add pieces to board for test
		ChessColor color = new ChessColor(true);
		Pawn piece = new Pawn(color, 4,  4);
		piece.setHasMoved(true);
		board[4][4].setPiece(piece);
				
		color = new ChessColor(true);
		Pawn piece2 = new Pawn(color, 2,  6);
		board[2][6].setPiece(piece2);
					
		color = new ChessColor(true);
		Pawn piece3 = new Pawn(color, 6,  6);
		board[6][6].setPiece(piece3);

		color = new ChessColor(true);
		Pawn piece4 = new Pawn(color,  6,  5);
		board[6][5].setPiece(piece4);
						
		color = new ChessColor(true);
		Pawn piece5 = new Pawn(color,  2,  4);
		board[2][4].setPiece(piece5);
						
		color = new ChessColor(true);
		Pawn piece6 = new Pawn(color,  3,  5);
		board[3][5].setPiece(piece6);
						
		color = new ChessColor(true);
		Pawn piece7 = new Pawn(color,  4,  2);
		board[4][2].setPiece(piece7);	
					
		color = new ChessColor(true);
		Pawn piece8 = new Pawn(color,  4,  2);
		board[3][3].setPiece(piece8);	
					
		//---------------------------------------
		//--- Test Pawn not at initial square ---
		//---------------------------------------
					
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
						
		//check if number of moves is equal to expected value of 1
		assertEquals(1, moveList.size());
						
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 4,3));
					
		//---------------------------------------
		//----  Test Pawn at initial square  ----
		//---------------------------------------
							
		// get moves
		moveList = (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[2][6].getPiece(), false);
								
		//check if number of moves is equal to expected value of 1
		assertEquals(1, moveList.size());
								
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,5));

		// get moves
		moveList = (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[6][6].getPiece(), false);
										
		//check if number of moves is equal to expected value of 2
		assertEquals(0, moveList.size());
	}	
	
	@Test
	public void testWhitePawnCheck() 
	{
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
					
		// Add pieces to board for test
		ChessColor color = new ChessColor(true);
		Pawn piece = new Pawn(color, 4,  4);
		piece.setHasMoved(true);
		board[4][4].setPiece(piece);
				
		color = new ChessColor(true);
		King king = new King(color, 5,  4);
		board[5][4].setPiece(king);
					
		color = new ChessColor(false);
		Rook rook = new Rook(color, 5,  3);
		board[5][3].setPiece(rook);

		color = new ChessColor(false);
		Rook rook2 = new Rook(color, 3,  3);
		board[3][3].setPiece(rook2);

		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
						
		//check if number of moves is equal to expected value of 1
		assertEquals(1, moveList.size());
						
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 5,3));
	
	}
	
	@Test
	public void testBlackPawnEmptyBoard() 
	{
		
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		// Add pieces to board for test
		ChessColor color = new ChessColor(false);
		Pawn piece = new Pawn(color, 4,  4);
		piece.setHasMoved(true);
		board[4][4].setPiece(piece);

		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color, 2,  1);
		board[2][1].setPiece(piece2);
		
		//---------------------------------------
		//--- Test Pawn not at initial square ---
		//---------------------------------------
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
			
	    //check if number of moves is equal to expected value of 1
	    assertEquals(1, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 4,5));
		
		//---------------------------------------
		//----  Test Pawn at initial square  ----
		//---------------------------------------
				
		// get moves
		moveList = (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[2][1].getPiece(), false);
					
		//check if number of moves is equal to expected value of 2
		assertEquals(2, moveList.size());
					
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,2));
		assertTrue(moveExists(moveList, 2,3));
	}
		
		
	@Test
	public void testBlackPawnBoardEdge() 
	{
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
		
		// Add pieces to board for test
		ChessColor color = new ChessColor(false);
		Pawn piece = new Pawn(color, 0,  7);
		board[0][7].setPiece(piece);

		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[0][7].getPiece(), false);
			
	    //check if number of moves is equal to expected value of 1
	    assertEquals(0, moveList.size());	
	}
		
	@Test
	public void testBlackPawnCaptures() 
	{
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
			
		// Add pieces to board for test
		ChessColor color = new ChessColor(false);
		Pawn piece = new Pawn(color, 4,  4);
		piece.setHasMoved(true);
		board[4][4].setPiece(piece);
		
		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color, 2,  1);
		board[2][1].setPiece(piece2);
			
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color, 6,  1);
		board[6][1].setPiece(piece3);

		color = new ChessColor(true);
		Pawn whitePiece = new Pawn(color,  6,  2);
		board[6][2].setPiece(whitePiece);
				
		color = new ChessColor(true);
		Pawn whitePiece2 = new Pawn(color,  2,  3);
		board[2][3].setPiece(whitePiece2);
				
		color = new ChessColor(true);
		Pawn whitePiece3 = new Pawn(color,  3,  2);
		board[3][2].setPiece(whitePiece3);
				
		color = new ChessColor(true);
		Pawn whitePiece4 = new Pawn(color,  4,  6);
		board[4][6].setPiece(whitePiece4);	
			
		color = new ChessColor(true);
		Pawn whitePiece5 = new Pawn(color,  5,  5);
		board[5][5].setPiece(whitePiece5);	
			
		//---------------------------------------
		//--- Test Pawn not at initial square ---
		//---------------------------------------
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
				
		//check if number of moves is equal to expected value of 2
		assertEquals(2, moveList.size());
				
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 4,5));
		assertTrue(moveExists(moveList, 5,5));
			
		//---------------------------------------
		//----  Test Pawn at initial square  ----
		//---------------------------------------
					
		// get moves
		moveList = (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[2][1].getPiece(), false);
						
		//check if number of moves is equal to expected value of 2
		assertEquals(2, moveList.size());
						
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,2));
		assertTrue(moveExists(moveList, 3,2));
		
		// get moves
		moveList = (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[6][1].getPiece(), false);
								
		//check if number of moves is equal to expected value of 2
		assertEquals(0, moveList.size());
	}
		
	@Test
	public void testBlackPawnPieceConflicts() 
	{
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
					
		// Add pieces to board for test
		ChessColor color = new ChessColor(false);
		Pawn piece = new Pawn(color, 4,  4);
		piece.setHasMoved(true);
		board[4][4].setPiece(piece);
				
		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color, 2,  1);
		board[2][1].setPiece(piece2);
					
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color, 6,  1);
		board[6][1].setPiece(piece3);

		color = new ChessColor(false);
		Pawn piece4 = new Pawn(color,  6,  2);
		board[6][2].setPiece(piece4);
						
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  2,  3);
		board[2][3].setPiece(piece5);
						
		color = new ChessColor(false);
		Pawn piece6 = new Pawn(color,  3,  2);
		board[3][2].setPiece(piece6);
						
		color = new ChessColor(false);
		Pawn piece7 = new Pawn(color,  4,  6);
		board[4][6].setPiece(piece7);	
					
		color = new ChessColor(false);
		Pawn piece8 = new Pawn(color,  5,  5);
		board[5][5].setPiece(piece8);	
					
		//---------------------------------------
		//--- Test Pawn not at initial square ---
		//---------------------------------------
					
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
						
		//check if number of moves is equal to expected value of 1
		assertEquals(1, moveList.size());
						
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 4,5));
					
		//---------------------------------------
		//----  Test Pawn at initial square  ----
		//---------------------------------------
							
		// get moves
		moveList = (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[2][1].getPiece(), false);
								
		//check if number of moves is equal to expected value of 1
		assertEquals(1, moveList.size());
								
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,2));

		// get moves
		moveList = (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[6][1].getPiece(), false);
										
		//check if number of moves is equal to expected value of 2
		assertEquals(0, moveList.size());
	}	
	@Test
	public void testBlackPawnCheck() 
	{
		// Instantiate move validation utility and set up board
		MoveValidation mv = new MoveValidation();
		Space[][] board = setupTestBoard();
					
		// Add pieces to board for test
		ChessColor color = new ChessColor(false);
		Pawn piece = new Pawn(color, 4,  4);
		piece.setHasMoved(true);
		board[4][4].setPiece(piece);
				
		color = new ChessColor(false);
		King king = new King(color, 5,  4);
		board[5][4].setPiece(king);
					
		color = new ChessColor(true);
		Rook rook = new Rook(color, 5,  5);
		board[5][3].setPiece(rook);

		color = new ChessColor(true);
		Rook rook2 = new Rook(color, 3,  5);
		board[3][3].setPiece(rook2);

		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece(), false);
						
		//check if number of moves is equal to expected value of 1
		assertEquals(1, moveList.size());
						
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 5,5));
	
	}
	
}
