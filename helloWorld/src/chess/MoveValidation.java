package chess;

import java.util.ArrayList;
import java.util.List;

import chess.pieces.Bishop;
import chess.pieces.Pawn;
import chess.pieces.Piece;

public class MoveValidation {
	
	public List<Integer[]> getPossibleMoves(Space[][] spaces, Piece piece) {
		List<Integer[]> movesList = new ArrayList<Integer[]>();
		switch(piece.getPieceName()) {
		case "P": 
			movesList = getPossibleMovesPawn(spaces, piece, movesList);
			break;
		case "B": 
			movesList = getPossibleMovesBishop(spaces, piece, movesList);
			break;
		case "H": 
			movesList = getPossibleMovesKnight(spaces, piece, movesList);
			break;
		case "K": 
			movesList = getPossibleMovesKing(spaces, piece, movesList);
			break;
		case "Q": 
			movesList = getPossibleMovesQueen(spaces, piece, movesList);
			break;
		case "R":
			movesList = getPossibleMovesRook(spaces, piece, movesList);
			break;
		}
		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesPawn(Space[][] spaces, Piece piece, List<Integer[]> movesList) {
		Pawn pawn = (Pawn) piece;
		if(piece.getColor().isWhite()) {
			movesList = getWhitePawnPossibleMoves(spaces, movesList, pawn);
		} else if (!piece.getColor().isWhite()) {
			movesList = getBlackPawnPossibleMoves(spaces, movesList, pawn);
		}
		return movesList;
	}
	
	public List<Integer[]> getWhitePawnPossibleMoves(Space[][] spaces, List<Integer[]> movesList, Pawn pawn) {
		Integer y1 = pawn.getY()-1;
		Integer y3 = pawn.getY();
		Integer x1 = pawn.getX()-1;
		Integer x2 = pawn.getX()+1;
		Integer x3 = pawn.getX();

		String pawnString = "P";
		Integer[] temp = new Integer[2];
		

		if (y1 >= 0) {
			Space forward1 = spaces[x3][y1];
			if (!forward1.isPiece()) {
				temp[0] = x3;
				temp[1] = y1;
				movesList.add(temp);
				if (!pawn.getHasMoved()) {
					Integer y2 = pawn.getY() - 2;
					Space forward2 = spaces[x3][y2];
					if (!forward2.isPiece()) {
						temp = new Integer[2];
						temp[0] = x3;
						temp[1] = y2;
						movesList.add(temp);
					}
				}
			}
		}
		
		if (x1 >= 0 && y1 >= 0) { 
			Space diagonal2 = spaces[x1][y1];
			Space lateral2 = spaces[x1][y3];
			if (diagonal2.isPiece() && !diagonal2.getPiece().getColor().isWhite()) {
				temp = new Integer[2];
				temp[0] = x1;
				temp[1] = y1;
				movesList.add(temp);
			}
			

			if(lateral2.isPiece()
					&& !lateral2.getPiece().getColor().isWhite()
					&& lateral2.getPiece().getPieceName().equals(pawnString)) {
				Pawn tempPawn = (Pawn) lateral2.getPiece();
				if(tempPawn.getEnPassantPossible()) {
					temp = new Integer[2];
					temp[0] = x1;
					temp[1] = y1;
					movesList.add(temp);
				}
			} 
		}
		
		if (x2 <= 7 && y1 >= 0) {
			Space diagonal1 = spaces[x2][y1];
			Space lateral1 = spaces[x2][y3];
			if(diagonal1.isPiece() && !diagonal1.getPiece().getColor().isWhite()) {
				temp = new Integer[2];
				temp[0] = x2;
				temp[1] = y1;
				movesList.add(temp);
			}
			if(lateral1.isPiece()
					&& !lateral1.getPiece().getColor().isWhite()
					&& lateral1.getPiece().getPieceName().equals(pawnString)) {
				Pawn tempPawn = (Pawn) lateral1.getPiece();
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
	
	public List<Integer[]> getBlackPawnPossibleMoves(Space[][] spaces, List<Integer[]> movesList, Pawn pawn) {
		Integer y1 = pawn.getY()+1;
		Integer y2 = pawn.getY()+2;
		Integer y3 = pawn.getY();
		Integer x1 = pawn.getX()-1;
		Integer x2 = pawn.getX()+1;
		Integer x3 = pawn.getX();
		String pawnString = pawn.getPieceName();
		Integer[] temp = new Integer[2];
		
		if (y1 <= 7) {
			Space forward1 = spaces[x3][y1];
			if (!forward1.isPiece()) {
				temp[0] = x3;
				temp[1] = y1;
				movesList.add(temp);
				if (!pawn.getHasMoved()) {
					Space forward2 = spaces[x3][y2];
					if (!forward2.isPiece()) {
						temp = new Integer[2];
						temp[0] = x3;
						temp[1] = y2;
						movesList.add(temp);
					}
				}
			}
		}

		if(x1 >= 0 && y1 <= 7) {
			Space diagonal2 = spaces[x1][y1];
			Space lateral2 = spaces[x1][y3];
			if (diagonal2.isPiece() && diagonal2.getPiece().getColor().isWhite()) {
				temp = new Integer[2];
				temp[0] = x1;
				temp[1] = y1;
				movesList.add(temp);
			}
			
			if(lateral2.isPiece()
					&& lateral2.getPiece().getColor().isWhite()
					&& lateral2.getPiece().getPieceName().equals(pawnString)) {
				Pawn tempPawn = (Pawn) lateral2.getPiece();
				if(tempPawn.getEnPassantPossible()) {
					temp = new Integer[2];
					temp[0] = x1;
					temp[1] = y1;
					movesList.add(temp);
				}
			}
		}
		if(7 >= x2 && y1 <= 7) {
			Space diagonal1 = spaces[x2][y1];
			Space lateral1 = spaces[x2][y3];
			
			if(diagonal1.isPiece() && diagonal1.getPiece().getColor().isWhite()) {
				temp = new Integer[2];
				temp[0] = x2;
				temp[1] = y1;
				movesList.add(temp);
			}

			if(lateral1.isPiece()
					&& lateral1.getPiece().getColor().isWhite()
					&& lateral1.getPiece().getPieceName().equals(pawnString)) {
				Pawn tempPawn = (Pawn) lateral1.getPiece();
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
	
	
	public List<Integer[]> getPossibleMovesBishop(Space[][] spaces, Piece piece, List<Integer[]> movesList) {
		int pieceX = piece.getX();
		int pieceY = piece.getY();
		Integer[] coords = new Integer[2];
		for (int i = pieceX; i < 8; i++) {
			for (int j = pieceY; j < 8; j++) {
				Space temp = spaces[i][j];
				if (temp.isPiece()) {
					if (temp.getPiece().getColor().isWhite().equals(piece.getColor().isWhite) && !temp.getPiece().equals(piece)) {
						break;
					} else if (!temp.getPiece().equals(piece)) {
						coords = new Integer[2];
						coords[0] = i;
						coords[1] = pieceY;
						movesList.add(coords);
						break;
					}
				}
				coords = new Integer[2];
				coords[0] = i;
				coords[1] = j;
				movesList.add(coords);
			}
		}
		
		for (int i = pieceX; i < 8; i++) {
			for (int j = pieceY; j >= 0; j--) {
				Space temp = spaces[i][j];
				if (temp.isPiece()) {
					if (temp.getPiece().getColor().isWhite().equals(piece.getColor().isWhite) && !temp.getPiece().equals(piece)) {
						break;
					} else if (!temp.getPiece().equals(piece)) {
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
		}
		
		for (int i = pieceX; i >= 0; i--) {
			for (int j = pieceY; j < 8; j++) {
				Space temp = spaces[i][j];
				if (temp.isPiece()) {
					if (temp.getPiece().getColor().isWhite().equals(piece.getColor().isWhite) && !temp.getPiece().equals(piece)) {
						break;
					} else if (!temp.getPiece().equals(piece)) {
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
		}
		
		for (int i = pieceX; i >= 0; i--) {
			for (int j = pieceY; j >= 0; j--) {
				Space temp = spaces[i][j];
				if (temp.isPiece()) {
					if (temp.getPiece().getColor().isWhite().equals(piece.getColor().isWhite) && !temp.getPiece().equals(piece)) {
						break;
					} else if (!temp.getPiece().equals(piece)) {
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
		}
		
		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesKnight(Space[][] spaces, Piece piece, List<Integer[]> movesList) {
	    final int[][] offsets = {{1,-2},{2,-1},{2,1},{1,2},{-1,2},
	            {-2,1},{-2,-1},{-1,-2}};
		int pieceX = piece.getX();
		int pieceY = piece.getY();
		Integer[] coords = new Integer[2];
		for (int i = 0; i < 8; i++) {
			int spaceX = pieceX + offsets[i][0];
			int spaceY = pieceY + offsets[i][1];
			if (spaceX >= 0 && spaceX < 8 && spaceY >= 0 && spaceY < 8) {
				if (spaces[spaceX][spaceY].isPiece()) {
					Piece temp = spaces[spaceX][spaceY].getPiece();
					if (!temp.getColor().equals(piece.getColor())) {
						coords = new Integer[2];
						coords[0] = i;
						coords[1] = pieceY;
						movesList.add(coords);
					}
				} else {
					coords = new Integer[2];
					coords[0] = i;
					coords[1] = pieceY;
					movesList.add(coords);
				}
			}
		}
		
		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesKing(Space[][] spaces, Piece piece, List<Integer[]> movesList) {
	    final int[][] offsets = {{1,1},{-1,-1},{1, 0},{-1,0},{-1,1},
	            {1,-1},{0,-1},{0,1}};
		int pieceX = piece.getX();
		int pieceY = piece.getY();
		Integer[] coords = new Integer[2];
		for (int i = 0; i < 8; i++) {
			int spaceX = pieceX + offsets[i][0];
			int spaceY = pieceY + offsets[i][1];
			if (spaceX >= 0 && spaceX < 8 && spaceY >= 0 && spaceY < 8) {
				if (spaces[spaceX][spaceY].isPiece()) {
					Piece temp = spaces[spaceX][spaceY].getPiece();
					if (!temp.getColor().equals(piece.getColor())) {
						coords = new Integer[2];
						coords[0] = i;
						coords[1] = pieceY;
						movesList.add(coords);
					}
				} else {
					coords = new Integer[2];
					coords[0] = i;
					coords[1] = pieceY;
					movesList.add(coords);
				}
			}
		}
		
		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesQueen(Space[][] spaces, Piece piece, List<Integer[]> movesList) {
		movesList = getPossibleMovesRook(spaces, piece, movesList);
		movesList = getPossibleMovesBishop(spaces, piece, movesList);
		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesRook(Space[][] spaces, Piece piece, List<Integer[]> movesList) {
		int pieceX = piece.getX();
		int pieceY = piece.getY();
		Integer[] coords = new Integer[2];
		for(int i = pieceX; i < 8; i++) {
			Space temp = spaces[i][pieceY];
			if(temp.isPiece()) {
				if(temp.getPiece().getColor().isWhite().equals(piece.getColor().isWhite) && !temp.getPiece().equals(piece)) {
					break;
				} else if (!temp.getPiece().equals(piece)) {
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
		
		for(int i = pieceX; i >= 0; i--) {
			Space temp = spaces[i][pieceY];
			if(temp.isPiece()) {
				if(temp.getPiece().getColor().isWhite().equals(piece.getColor().isWhite) && !temp.getPiece().equals(piece)) {
					break;
				} else if (!temp.getPiece().equals(piece)) {
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
			
		for(int i = pieceY; i < 8; i++) {
			Space temp = spaces[pieceX][i];
			if(temp.isPiece()) {
				if(temp.getPiece().getColor().isWhite().equals(piece.getColor().isWhite) && !temp.getPiece().equals(piece)) {
					break;
				} else if (!temp.getPiece().equals(piece)) {
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
		
		for(int i = pieceY; i >= 0; i--) {
			Space temp = spaces[pieceX][i];
			if(temp.isPiece()) {
				if(temp.getPiece().getColor().isWhite().equals(piece.getColor().isWhite) && !temp.getPiece().equals(piece)) {
					break;
				} else if (!temp.getPiece().equals(piece)){
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

}
