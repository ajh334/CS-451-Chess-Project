package chess;

import java.util.ArrayList;
import java.util.List;

import chess.BoardState.BoardCheck;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Rook;

public class MoveValidation {
	
	List<Integer[]> checkMoveList;
	
	public List<Integer[]> getPossibleMoves(Piece[][] spaces, Piece piece, Boolean isCheck, Boolean isCheckMove) {
		List<Integer[]> movesList = new ArrayList<Integer[]>();
		switch(piece.getPieceName()) {
		case "P": 
			movesList = getPossibleMovesPawn(spaces, piece, movesList, isCheck);
			break;
		case "B": 
			movesList = getPossibleMovesBishop(spaces, piece, movesList, isCheck);
			break;
		case "H": 
			movesList = getPossibleMovesKnight(spaces, piece, movesList, isCheck);
			break;
		case "K": 
			movesList = getPossibleMovesKing(spaces, piece, movesList, isCheck);
			break;
		case "Q": 
			movesList = getPossibleMovesQueen(spaces, piece, movesList, isCheck);
			break;
		case "R":
			movesList = getPossibleMovesRook(spaces, piece, movesList, isCheck);
			break;
		}
		if(piece != null && !isCheckMove) {
			for(int i = 0; i < movesList.size(); i++) {
				Piece[][] temp = spaces;
				Piece oldPiece = piece;
				piece.setX(movesList.get(i)[0]);
				piece.setY(movesList.get(i)[1]);
				if (!isCheckMove(temp, piece.getColor(), piece, oldPiece)) {
					movesList.remove(i);
					i = i--;
				}
			}
		}
		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesPawn(Piece[][] spaces, Piece piece, List<Integer[]> movesList, Boolean isCheck) {
		Pawn pawn = (Pawn) piece;
		if(piece.getColor().isWhite()) {
			movesList = getWhitePawnPossibleMoves(spaces, movesList, pawn, isCheck);
		} else if (!piece.getColor().isWhite()) {
			movesList = getBlackPawnPossibleMoves(spaces, movesList, pawn, isCheck);
		}
		return movesList;
	}
	
	public List<Integer[]> getWhitePawnPossibleMoves(Piece[][] spaces, List<Integer[]> movesList, Pawn pawn, Boolean isCheck) {
		Integer y1 = pawn.getY()-1;
		Integer y3 = pawn.getY();
		Integer x1 = pawn.getX()-1;
		Integer x2 = pawn.getX()+1;
		Integer x3 = pawn.getX();

		String pawnString = "P";
		Integer[] temp = new Integer[2];
		

		if (y1 >= 0) {
			Piece forward1 = spaces[x3][y1];
			if (forward1 == null) {
				temp[0] = x3;
				temp[1] = y1;
				movesList.add(temp);
				if (!pawn.hasMoved()) {
					Integer y2 = pawn.getY() - 2;
					Piece forward2 = spaces[x3][y2];
					if (forward2 == null) {
						temp = new Integer[2];
						temp[0] = x3;
						temp[1] = y2;
						movesList.add(temp);
					}
				}
			}
		}
		
		if (x1 >= 0 && y1 >= 0) { 
			Piece diagonal2 = spaces[x1][y1];
			Piece lateral2 = spaces[x1][y3];
			if (diagonal2 != null && !diagonal2.getColor().isWhite()) {
				temp = new Integer[2];
				temp[0] = x1;
				temp[1] = y1;
				movesList.add(temp);
			}
			

			if(lateral2 != null
					&& !lateral2.getColor().isWhite()
					&& lateral2.getPieceName().equals(pawnString)) {
				Pawn tempPawn = (Pawn) lateral2;
				if(tempPawn.getEnPassantPossible()) {
					temp = new Integer[2];
					temp[0] = x1;
					temp[1] = y1;
					movesList.add(temp);
				}
			} 
		}
		
		if (x2 <= 7 && y1 >= 0) {
			Piece diagonal1 = spaces[x2][y1];
			Piece lateral1 = spaces[x2][y3];
			if(diagonal1 != null && !diagonal1.getColor().isWhite()) {
				temp = new Integer[2];
				temp[0] = x2;
				temp[1] = y1;
				movesList.add(temp);
			}
			if(lateral1 != null
					&& lateral1.getColor().isWhite()
					&& lateral1.getPieceName().equals(pawnString)) {
				Pawn tempPawn = (Pawn) lateral1;
				if(tempPawn.getEnPassantPossible()) {
					temp = new Integer[2];
					temp[0] = x2;
					temp[1] = y1;
					movesList.add(temp);
				}
			}
		}
		
		return movesList;
	}
	
	public List<Integer[]> getBlackPawnPossibleMoves(Piece[][] spaces, List<Integer[]> movesList, Pawn pawn, Boolean isCheck) {
		Integer y1 = pawn.getY()+1;
		Integer y2 = pawn.getY()+2;
		Integer y3 = pawn.getY();
		Integer x1 = pawn.getX()-1;
		Integer x2 = pawn.getX()+1;
		Integer x3 = pawn.getX();
		String pawnString = pawn.getPieceName();
		Integer[] temp = new Integer[2];
		
		if (y1 <= 7) {
			Piece forward1 = spaces[x3][y1];
			if (forward1 == null) {
				temp[0] = x3;
				temp[1] = y1;
				movesList.add(temp);
				if (!pawn.hasMoved()) {
					Piece forward2 = spaces[x3][y2];
					if (forward2 == null) {
						temp = new Integer[2];
						temp[0] = x3;
						temp[1] = y2;
						movesList.add(temp);
					}
				}
			}
		}

		if(x1 >= 0 && y1 <= 7) {
			Piece diagonal2 = spaces[x1][y1];
			Piece lateral2 = spaces[x1][y3];
			if (diagonal2 != null && diagonal2.getColor().isWhite()) {
				temp = new Integer[2];
				temp[0] = x1;
				temp[1] = y1;
				movesList.add(temp);
			}
			
			if(lateral2 != null
					&& lateral2.getColor().isWhite()
					&& lateral2.getPieceName().equals(pawnString)) {
				Pawn tempPawn = (Pawn) lateral2;
				if(tempPawn.getEnPassantPossible()) {
					temp = new Integer[2];
					temp[0] = x1;
					temp[1] = y1;
					movesList.add(temp);
				}
			}
		}
		if(7 >= x2 && y1 <= 7) {
			Piece diagonal1 = spaces[x2][y1];
			Piece lateral1 = spaces[x2][y3];
			
			if(diagonal1 != null && diagonal1.getColor().isWhite()) {
				temp = new Integer[2];
				temp[0] = x2;
				temp[1] = y1;
				movesList.add(temp);
			}

			if(lateral1 != null
					&& lateral1.getColor().isWhite()
					&& lateral1.getPieceName().equals(pawnString)) {
				Pawn tempPawn = (Pawn) lateral1;
				if(tempPawn.getEnPassantPossible()) {
					temp = new Integer[2];
					temp[0] = x2;
					temp[1] = y1;
					movesList.add(temp);
				}
			}

		}

		
		return movesList;
	}
	
	
	public List<Integer[]> getPossibleMovesBishop(Piece[][] spaces, Piece piece, List<Integer[]> movesList, Boolean isCheck) {
		int pieceX = piece.getX();
		int pieceY = piece.getY();
		Integer[] coords = new Integer[2];
		for (int i = 1; i < 8; i++) {
			int tempX = pieceX;
			int tempY = pieceY;
			tempX += i;
			tempY += i;
			if (tempX < 8 && tempX >= 0 && tempY < 8 && tempY >= 0) {
				Piece temp = spaces[tempX][tempY];
				if (temp != null) {
					if (temp.getColor().isWhite().equals(piece.getColor().isWhite)
							&& !temp.equals(piece)) {
						break;
					} else if (!temp.equals(piece)) {
						coords = new Integer[2];
						coords[0] = tempX;
						coords[1] = tempY;
						movesList.add(coords);
						break;
					}
				}
				coords = new Integer[2];
				coords[0] = tempX;
				coords[1] = tempY;
				movesList.add(coords);
			}
		}
		
		for (int i = 1; i < 8; i++) {
			int tempX = pieceX;
			int tempY = pieceY;
			tempX += i;
			tempY -= i;
			if (tempX < 8 && tempX >= 0 && tempY < 8 && tempY >= 0) {
				Piece temp = spaces[tempX][tempY];
				if (temp != null) {
					if (temp.getColor().isWhite().equals(piece.getColor().isWhite)
							&& !temp.equals(piece)) {
						break;
					} else if (!temp.equals(piece)) {
						coords = new Integer[2];
						coords[0] = tempX;
						coords[1] = tempY;
						movesList.add(coords);
						break;
					}
				}
				coords = new Integer[2];
				coords[0] = tempX;
				coords[1] = tempY;
				movesList.add(coords);
			}
		}
		
		for (int i = 1; i < 8; i++) {
			int tempX = pieceX;
			int tempY = pieceY;
			tempX -= i;
			tempY += i;
			if (tempX < 8 && tempX >= 0 && tempY < 8 && tempY >= 0) {
				Piece temp = spaces[tempX][tempY];
				if (temp != null) {
					if (temp.getColor().isWhite().equals(piece.getColor().isWhite)
							&& !temp.equals(piece)) {
						break;
					} else if (!temp.equals(piece)) {
						coords = new Integer[2];
						coords[0] = tempX;
						coords[1] = tempY;
						movesList.add(coords);
						break;
					}
				}
				coords = new Integer[2];
				coords[0] = tempX;
				coords[1] = tempY;
				movesList.add(coords);
			}
		}
		
		for (int i = 1; i < 8; i++) {
			int tempX = pieceX;
			int tempY = pieceY;
			tempX -= i;
			tempY -= i;
			if (tempX < 8 && tempX >= 0 && tempY < 8 && tempY >= 0) {
				Piece temp = spaces[tempX][tempY];
				if (temp != null) {
					if (temp.getColor().isWhite().equals(piece.getColor().isWhite)
							&& !temp.equals(piece)) {
						break;
					} else if (!temp.equals(piece)) {
						coords = new Integer[2];
						coords[0] = tempX;
						coords[1] = tempY;
						movesList.add(coords);
						break;
					}
				}
				coords = new Integer[2];
				coords[0] = tempX;
				coords[1] = tempY;
				movesList.add(coords);
			}
		}
		
		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesKnight(Piece[][] spaces, Piece piece, List<Integer[]> movesList, Boolean isCheck) {
	    final int[][] offsets = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},
	            {-2,1},{-2,-1},{-1,-2}};
		int pieceX = piece.getX();
		int pieceY = piece.getY();
		Integer[] coords = new Integer[2];
		for (int i = 0; i < offsets.length; i++) {
			int spaceX = pieceX + offsets[i][0];
			int spaceY = pieceY + offsets[i][1];
			if (spaceX >= 0 && spaceX < 8 && spaceY >= 0 && spaceY < 8) {
				if (spaces[spaceX][spaceY] != null) {
					Piece temp = spaces[spaceX][spaceY];
					if (!temp.getColor().isWhite().equals(piece.getColor().isWhite)) {
						coords = new Integer[2];
						coords[0] = spaceX;
						coords[1] = spaceY;
						movesList.add(coords);
					}
				} else {
					coords = new Integer[2];
					coords[0] = spaceX;
					coords[1] = spaceY;
					movesList.add(coords);
				}
			}
		}
		
		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesKing(Piece[][] spaces, Piece piece, List<Integer[]> movesList, Boolean isCheck) {
		King king = (King) piece;
	    final int[][] offsets = {{1,1},{-1,-1},{1, 0},{-1,0},{-1,1},
	            {1,-1},{0,-1},{0,1}};
		int pieceX = king.getX();
		int pieceY = king.getY();
		Integer[] coords = new Integer[2];
		for (int i = 0; i < 8; i++) {
			int spaceX = pieceX + offsets[i][0];
			int spaceY = pieceY + offsets[i][1];
			if (spaceX >= 0 && spaceX < 8 && spaceY >= 0 && spaceY < 8) {
				if (spaces[spaceX][spaceY] != null) {
					Piece temp = spaces[spaceX][spaceY];
					if (!temp.getColor().isWhite().equals(king.getColor().isWhite)) {
						coords = new Integer[2];
						coords[0] = spaceX;
						coords[1] = spaceY;
						movesList.add(coords);
					}
				} else {
					coords = new Integer[2];
					coords[0] = spaceX;
					coords[1] = spaceY;
					movesList.add(coords);
				}
			}
		}
		
		Rook leftRook = null;
		Rook rightRook = null;
		

		if(king.getX().equals(4)) {
			if(spaces[king.getX()+3][king.getY()] != null 
					&& spaces[king.getX()+3][king.getY()].getPieceName().equals("R")) {
				rightRook = (Rook) spaces[king.getX()+3][king.getY()];
			}
			
			if(spaces[king.getX()-4][king.getY()] != null 
					&& spaces[king.getX()-4][king.getY()].getPieceName().equals("R")) {
				leftRook = (Rook) spaces[king.getX()-4][king.getY()];
			}
		}

		
		if (leftRook != null) {
			if (!king.hasMoved() && !leftRook.hasMoved() 
					&& spaces[king.getX()-3][king.getY()] == null 
					&& spaces[king.getX()-2][king.getY()] == null
					&& spaces[king.getX()-1][king.getY()] == null) {
				coords = new Integer[2];
				coords[0] = king.getX() - 2;
				coords[1] = king.getY();
				movesList.add(coords);
			}
		}
		
		if (rightRook != null) {
			if (!king.hasMoved() && !rightRook.hasMoved()
					&& spaces[king.getX()+2][king.getY()] == null
					&& spaces[king.getX()+1][king.getY()] == null) {
				coords = new Integer[2];
				coords[0] = king.getX() + 2;
				coords[1] = king.getY();
				movesList.add(coords);
			}
		}
		
		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesQueen(Piece[][] spaces, Piece piece, List<Integer[]> movesList, Boolean isCheck) {
		movesList = getPossibleMovesRook(spaces, piece, movesList, isCheck);
		movesList = getPossibleMovesBishop(spaces, piece, movesList, isCheck);
		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesRook(Piece[][] spaces, Piece piece, List<Integer[]> movesList, Boolean isCheck) {
		int pieceX = piece.getX();
		int pieceY = piece.getY();
		Integer[] coords = new Integer[2];
		for(int i = pieceX+1; i < 8; i++) {
			Piece temp = spaces[i][pieceY];
			if(temp != null) {
				if(temp.getColor().isWhite().equals(piece.getColor().isWhite) && !temp.equals(piece)) {
					break;
				} else if (!temp.equals(piece)) {
					coords = new Integer[2];
					coords[0] = i;
					coords[1] = pieceY;
					movesList.add(coords);
					break;
				}
			}
			coords = new Integer[2];
			coords[0] = i;
			coords[1] = pieceY;
			movesList.add(coords);
		}
		
		for(int i = pieceX-1; i >= 0; i--) {
			Piece temp = spaces[i][pieceY];
			if(temp != null) {
				if(temp.getColor().isWhite().equals(piece.getColor().isWhite) && !temp.equals(piece)) {
					break;
				} else if (!temp.equals(piece)) {
					coords = new Integer[2];
					coords[0] = i;
					coords[1] = pieceY;
					movesList.add(coords);
					break;
				}
			}
			coords = new Integer[2];
			coords[0] = i;
			coords[1] = pieceY;
			movesList.add(coords);
		}
			
		for(int i = pieceY+1; i < 8; i++) {
			Piece temp = spaces[pieceX][i];
			if(temp != null) {
				if(temp.getColor().isWhite().equals(piece.getColor().isWhite) && !temp.equals(piece)) {
					break;
				} else if (!temp.equals(piece)) {
					coords = new Integer[2];
					coords[0] = pieceX;
					coords[1] = i;
					movesList.add(coords);
					break;
				}
			}
			coords = new Integer[2];
			coords[0] = pieceX;
			coords[1] = i;
			movesList.add(coords);
		}
		
		for(int i = pieceY-1; i >= 0; i--) {
			Piece temp = spaces[pieceX][i];
			if(temp != null) {
				if(temp.getColor().isWhite().equals(piece.getColor().isWhite) && !temp.equals(piece)) {
					break;
				} else if (!temp.equals(piece)){
					coords = new Integer[2];
					coords[0] = pieceX;
					coords[1] = i;
					movesList.add(coords);
					break;
				}
			}
			coords = new Integer[2];
			coords[0] = pieceX;
			coords[1] = i;
			movesList.add(coords);
		}
		
		
		return movesList;
	}
	
	public BoardCheck isSinglePieceCheck(Piece[][] spaces, Piece piece) {
		BoardCheck bc = BoardCheck.NO_CHECK;
		List<Integer[]> moveList = getPossibleMoves(spaces, piece, false, false);
		Piece king = findKing(spaces, new ChessColor(!piece.getColor().isWhite()));
		Integer[] kingPos = new Integer[2];
		kingPos[0] = king.getX();
		kingPos[1] = king.getY();
		if(moveList.contains(kingPos)) {
			bc = isCheckmate(spaces, piece);
		}
		
		return bc;
	}
	
	public BoardCheck isCheck(Piece[][] spaces, ChessColor color) {
		List<Integer[]> moveList = new ArrayList<Integer[]>();
		List<Integer[]> allEnemyMoves = new ArrayList<Integer[]>();
		List<List<Piece>> pieceList = getPieceArray(spaces, color, true);
		List<Piece> friendlyPieceList = pieceList.get(1);
		List<Piece> opposingPieceList = pieceList.get(0);
		Piece king = findKing(spaces, color);
		Piece temp = null;
		BoardCheck bc = BoardCheck.NO_CHECK;
		Integer[] kingPos = new Integer[2];
		kingPos[0] = king.getX();
		kingPos[1] = king.getY();
		
		for(int i = 0; i < pieceList.size(); i++) {
			temp = opposingPieceList.get(i);
			moveList = getPossibleMoves(spaces, temp, false, false);
			allEnemyMoves.addAll(moveList);
			if(moveList.contains(kingPos)) {

			}
		}

		return bc;
	}

	public BoardCheck isCheckmate(Piece[][] spaces, Piece piece) {
		ChessColor color = new ChessColor(!piece.getColor().isWhite());
		List<Integer[]> tempMoveList = new ArrayList<Integer[]>();
		List<Integer[]> moveList = new ArrayList<Integer[]>();
		List<Integer[]> allEnemyMoves = new ArrayList<Integer[]>();
		List<List<Piece>> pieceList = getPieceArray(spaces, color, true);
		List<Piece> friendlyPieceList = pieceList.get(1);
		List<Piece> opposingPieceList = pieceList.get(0);
		Piece king = findKing(spaces, color);
		Integer[] kingPos = new Integer[2];
		kingPos[0] = king.getX();
		kingPos[1] = king.getY();
		Piece tempPiece = null;
		for(int i = 0; i < friendlyPieceList.size(); i++) {
			tempPiece = friendlyPieceList.get(i);
			tempMoveList = getPossibleMoves(spaces, tempPiece, true, false);
			for(int j = 0; j < tempMoveList.size(); j++) {
				Piece[][] tempSpaces = spaces;
				Piece oldPiece = tempPiece;
				tempPiece.setX(tempMoveList.get(i)[0]);
				tempPiece.setY(tempMoveList.get(i)[1]);
				if (isCheckMove(tempSpaces, tempPiece.getColor(), tempPiece, oldPiece)) {
					return BoardCheck.CHECK;
				}
			}
		}
		
		return BoardCheck.CHECKMATE;
	}
	
	public Boolean isCheckMove(Piece[][] spaces, ChessColor color, Piece piece, Piece oldPiece) {
		List<Integer[]> moveList = new ArrayList<Integer[]>();
		Piece[][] pieces = spaces.clone();
		pieces[oldPiece.getX()][oldPiece.getY()] = null;
		pieces[piece.getX()][piece.getY()] = piece;
		List<List<Piece>> pieceList = getPieceArray(spaces, color, false);
		List<Piece> opposingPieceList = pieceList.get(0);
		Piece king = findKing(spaces, color);
		Integer[] kingPos = new Integer[2];
		kingPos[0] = king.getX();
		kingPos[1] = king.getY();
		Piece tempPiece = null;
		Boolean canMove = true;
		for(int i = 0; i < opposingPieceList.size(); i++) {
			tempPiece = opposingPieceList.get(i);
			moveList = getPossibleMoves(spaces, tempPiece, false, true);
			if(moveList.contains(kingPos)) {
				canMove = false;
				break;
			}
		}
		
		
		return canMove;
	}

	
	public List<List<Piece>> getPieceArray(Piece[][] spaces, ChessColor color, Boolean both) {
		List<List<Piece>> pieceList = new ArrayList<List<Piece>>(2);
		List<Piece> friendlyPieceList = new ArrayList<Piece>();
		List<Piece> opposingPieceList = new ArrayList<Piece>();
		for (int i = 0; i < spaces.length; i++) {
			for (int j = 0; j < spaces.length; j++) {
				if (spaces[i][j] != null) {
					Piece temp = spaces[i][j];
					if (!temp.getColor().isWhite.equals(color.isWhite)) {
						opposingPieceList.add(temp);
					} else if (both && temp.getColor().isWhite.equals(color.isWhite)){
						friendlyPieceList.add(temp);
					}
				}
			}
		}
		pieceList.add(opposingPieceList);
		pieceList.add(friendlyPieceList);
		return pieceList;
	}
	
	public Piece findKing(Piece[][] spaces, ChessColor color) {
		Piece king = null;
		if(color.isWhite) {
			for (int i = 7; i >= 0; i--) {
				for (int j = 7; j >= 0; j--) {
					if(spaces[i][j] != null) {
						king = spaces[i][j];
						if(king.getPieceName().equals("K") 
								&& king.getColor().isWhite.equals(color.isWhite)) {
							return king;
						}
					}
				}
			}
		} else {
			for (int i = 0; i < spaces.length; i++) {
				for (int j = 0; j < spaces.length; j++) {
					if(spaces[i][j] != null) {
						king = spaces[i][j];
						if(king.getPieceName().equals("K") 
								&& king.getColor().isWhite.equals(color.isWhite)) {
							return king;
						}
					}
				}
			}
		}
		return king;
	}

}
