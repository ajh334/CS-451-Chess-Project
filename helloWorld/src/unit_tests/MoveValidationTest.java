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

	
	//------------------
	//--- ROOK TESTS ---
	//------------------
	
	@Test
	public void testRookEmptyBoard() {
		
		MoveValidation mv = new MoveValidation();
		
		// Set up board for test
		Space[][] board = new Space[8][8];
		
		for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                Space b = new Space();
                board[x][y] = b;
            }
        }

		
		ChessColor color = new ChessColor(true);
		Rook piece = new Rook(color,  3,  4);
		board[3][4].setPiece(piece);
		
		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece());
		
        //check if number of moves is equal to expected value of 14
		
		assertEquals(14, moveList.size());
		
		//check if number all expected moves exist in returned move list
		assertTrue(moveList.contains(new Integer[]{0,4}));
		assertTrue(moveList.contains(new Integer[]{1,4}));
		assertTrue(moveList.contains(new Integer[]{2,4}));
		assertTrue(moveList.contains(new Integer[]{4,4}));
		assertTrue(moveList.contains(new Integer[]{5,4}));
		assertTrue(moveList.contains(new Integer[]{6,4}));
		assertTrue(moveList.contains(new Integer[]{7,4}));
		assertTrue(moveList.contains(new Integer[]{3,0}));
		assertTrue(moveList.contains(new Integer[]{3,1}));
		assertTrue(moveList.contains(new Integer[]{3,2}));
		assertTrue(moveList.contains(new Integer[]{3,3}));
		assertTrue(moveList.contains(new Integer[]{3,5}));
		assertTrue(moveList.contains(new Integer[]{3,6}));
		assertTrue(moveList.contains(new Integer[]{3,7}));
		
	}
	
	
	@Test
	public void testRookBoardEdge() {
		
		MoveValidation mv = new MoveValidation();
		
		// Set up board for test
		Space[][] board = new Space[8][8];
		
		for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                Space b = new Space();
                board[x][y] = b;
            }
        }

		
		ChessColor color = new ChessColor(true);
		Rook piece = new Rook(color,  0,  0);
		board[0][0].setPiece(piece);
		
		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece());
		
        //check if number of moves is equal to expected value of 14
		
		assertEquals(14, moveList.size());
		
		//check if number all expected moves exist in returned move list
		assertTrue(moveList.contains(new Integer[]{1,0}));
		assertTrue(moveList.contains(new Integer[]{2,0}));
		assertTrue(moveList.contains(new Integer[]{3,0}));
		assertTrue(moveList.contains(new Integer[]{4,0}));
		assertTrue(moveList.contains(new Integer[]{5,0}));
		assertTrue(moveList.contains(new Integer[]{6,0}));
		assertTrue(moveList.contains(new Integer[]{7,0}));
		assertTrue(moveList.contains(new Integer[]{0,1}));
		assertTrue(moveList.contains(new Integer[]{0,2}));
		assertTrue(moveList.contains(new Integer[]{0,3}));
		assertTrue(moveList.contains(new Integer[]{0,4}));
		assertTrue(moveList.contains(new Integer[]{0,5}));
		assertTrue(moveList.contains(new Integer[]{0,6}));
		assertTrue(moveList.contains(new Integer[]{0,7}));
		
	}
	
	
	@Test
	public void testRookPopulatedBoard() {
		
		MoveValidation mv = new MoveValidation();
		
		// Set up board for test
		Space[][] board = new Space[8][8];
		
		for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                Space b = new Space();
                board[x][y] = b;
            }
        }

		
		ChessColor color = new ChessColor(true);
		Rook piece = new Rook(color,  3,  4);
		board[3][4].setPiece(piece);
		
		color = new ChessColor(false);
		Pawn piece2 = new Pawn(color,  3,  6);
		board[3][6].setPiece(piece2);
		
		color = new ChessColor(false);
		Pawn piece3 = new Pawn(color,  4,  6);
		board[4][6].setPiece(piece3);
		
		color = new ChessColor(true);
		Pawn piece4 = new Pawn(color,  1,  4);
		board[1][4].setPiece(piece4);
		
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  7,  4);
		board[7][4].setPiece(piece5);
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece());
		
        //check if number of moves is equal to expected value of 11
		
		assertEquals(11, moveList.size());
		
		//check if number all expected moves exist in returned move list
		assertTrue(moveList.contains(new Integer[]{2,4}));
		assertTrue(moveList.contains(new Integer[]{4,4}));
		assertTrue(moveList.contains(new Integer[]{5,4}));
		assertTrue(moveList.contains(new Integer[]{6,4}));
		assertTrue(moveList.contains(new Integer[]{7,4}));
		assertTrue(moveList.contains(new Integer[]{3,0}));
		assertTrue(moveList.contains(new Integer[]{3,1}));
		assertTrue(moveList.contains(new Integer[]{3,2}));
		assertTrue(moveList.contains(new Integer[]{3,3}));
		assertTrue(moveList.contains(new Integer[]{3,5}));
		assertTrue(moveList.contains(new Integer[]{3,6}));
	}
	
	
	@Test
	public void testRookCheck() {
		
		MoveValidation mv = new MoveValidation();
		
		// Set up board for test
		Space[][] board = new Space[8][8];
		
		for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                Space b = new Space();
                board[x][y] = b;
            }
        }

		
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
		board[1][4].setPiece(whiteKing);
		
		color = new ChessColor(false);
		Rook blackRook = new Rook(color,  7,  1);
		board[1][4].setPiece(blackRook);
		
		color = new ChessColor(false);
		Pawn blackPawn3 = new Pawn(color,  7,  4);
		board[7][4].setPiece( blackPawn3);
		
		
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece());
		
        //check if number of moves is equal to expected value of 1
		
		assertEquals(1, moveList.size());
		
		//check if number all expected moves exist in returned move list
		
		assertTrue(moveList.contains(new Integer[]{3,1}));
	
	}

}
