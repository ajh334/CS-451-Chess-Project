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

	public boolean moveExists(ArrayList<Integer[]> moveList, Integer x, Integer y){
		for(int i = 0; i < moveList.size(); i++){
			if(moveList.get(i)[0] == x &&  moveList.get(i)[1] == y){
				return true;
			}
		}
		
		return false;
	}
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
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[0][0].getPiece());
		
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
	public void testRookCaptures() {
		
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
		Pawn piece3 = new Pawn(color,  3,  0);
		board[3][0].setPiece(piece3);
		
		color = new ChessColor(false);
		Pawn piece4 = new Pawn(color,  1,  4);
		board[1][4].setPiece(piece4);
		
		color = new ChessColor(false);
		Pawn piece5 = new Pawn(color,  7,  4);
		board[7][4].setPiece(piece5);
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece());
		
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
	public void testRookOwnPieceConflicts() {
		
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
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece());
		
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
		board[1][1].setPiece(whiteKing);
		
		color = new ChessColor(false);
		Rook blackRook = new Rook(color,  7,  1);
		board[7][1].setPiece(blackRook);
		
		color = new ChessColor(false);
		Pawn blackPawn3 = new Pawn(color,  7,  4);
		board[7][4].setPiece( blackPawn3);
		
		
		
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece());
		
        //check if number of moves is equal to expected value of 1
		
		assertEquals(1, moveList.size());
		
		//check if number all expected moves exist in returned move list
		
		assertTrue(moveExists(moveList, 3,1));
	
	}
	
	//--------------------
    //--- Bishop TESTS ---
	//--------------------
		
	@Test
	public void testBishopEmptyBoard() {
			
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
		Bishop piece = new Bishop(color,  4,  4);
		board[4][4].setPiece(piece);
			
		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece());
			
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
	public void testBishopBoardEdge() {
			
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
		Bishop piece = new Bishop(color,  0,  0);
		board[0][0].setPiece(piece);
			
		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[0][0].getPiece());
			
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
	public void testBishopCaptures() {
			
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
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece());
					
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
			
		// Set up board for test
		Space[][] board = new Space[8][8];
			
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				Space b = new Space();
				board[x][y] = b;
			}
		}
		
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
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece());
					
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
	public void testBishopCheck() {
			
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
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece());
						
		//check if number of moves is equal to expected value of 13
						
		assertEquals(8, moveList.size());
						
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,2));

	}

	//-------------------
    //--- QUEEN TESTS ---
	//-------------------
		
	@Test
	public void testQueenEmptyBoard() {
			
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
		Queen piece = new Queen(color,  4,  4);
		board[4][4].setPiece(piece);
			
		// get moves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece());
			
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
	public void testQueenBoardEdge() {
			
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
		Queen piece = new Queen(color,  0,  0);
		board[0][0].setPiece(piece);
			
		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[0][0].getPiece());
			
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
	public void testQueenCaptures() {
			
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
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece());
					
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
	public void testQueenOwnPieceConflicts() {
			
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
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece());
					
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
	public void testQueenCheck() {
			
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
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece());
						
		//check if number of moves is equal to expected value of 13
						
		assertEquals(8, moveList.size());
						
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,2));

	}
	
	//------------------
    //--- ROOK TESTS ---
	//------------------
		
	@Test
	public void testKnightEmptyBoard() {
			
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
		Knight piece = new Knight(color, 4,  4);
		board[4][4].setPiece(piece);

		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece());
		for(int i = 0; i < moveList.size(); i++){
			System.out.println(moveList.get(i)[0] + " " + moveList.get(i)[1]);
			
		}		
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
	public void testknightBoardEdge() {
			
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
		Knight piece = new Knight(color, 0,  0);
		board[0][0].setPiece(piece);
			
		// get mooves
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[0][0].getPiece());
			
	    //check if number of moves is equal to expected value of 2
	    assertEquals(2, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 1,2));
		assertTrue(moveExists(moveList, 2,1));
		
	}
		
	@Test
	public void testKnightCaptures() {	
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
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece());
			
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
	public void testKnightOwnPieceConflicts() {
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
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[4][4].getPiece());
			
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
		
		// Set up board for test
		Space[][] board = new Space[8][8];
			
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
	        	Space b = new Space();
	        	board[x][y] = b;
	   		}
		}

			
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
		ArrayList<Integer[]> moveList =  (ArrayList<Integer[]>) mv.getPossibleMoves(board, board[3][4].getPiece());
			
	    //check if number of moves is equal to expected value of 8
			
		assertEquals(1, moveList.size());
			
		//check if number all expected moves exist in returned move list
		assertTrue(moveExists(moveList, 2,5));
	}
}
