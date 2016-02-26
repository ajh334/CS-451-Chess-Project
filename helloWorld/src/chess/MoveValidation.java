package chess;

import java.util.ArrayList;
import java.util.List;

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
			movesList = getWhitePossibleMoves(spaces, movesList, pawn);
		} else if (!piece.getColor().isWhite()) {
			movesList = getBlackPossibleMoves(spaces, movesList, pawn);
		}
		return movesList;
	}
	
	public List<Integer[]> getWhitePossibleMoves(Space[][] spaces, List<Integer[]> movesList, Pawn pawn) {
		Integer y1 = pawn.getY()+1;
		Integer y2 = pawn.getY()+2;
		Integer y3 = pawn.getY();
		Integer x1 = pawn.getX()-1;
		Integer x2 = pawn.getX()+1;
		Integer x3 = pawn.getX();
		Space forward1 = spaces [y1] [x3];
		Space forward2 = spaces [y2] [x3];
		Space diagonal1 = spaces[y1][x2];
		Space diagonal2 = spaces[y1][x1];
		Space lateral1 = spaces[y3][x2];
		Space lateral2 = spaces[y3][x1];
		String pawnString = "P";
		Integer[] temp = new Integer[2];
		
		if(forward1.getPiece().equals(null)) {
			temp[0] = y1;
			temp[1] = x3;
			movesList.add(temp);
			if(!pawn.getHasMoved() && forward2.getPiece().equals(null)) {
				temp[0] = y2;
				temp[1] = x3;
				movesList.add(temp);
			}
		}
		
		if(!diagonal1.getPiece().equals(null) && !diagonal1.getPiece().getColor().isWhite()) {
			temp[0] = y1;
			temp[1] = x2;
			movesList.add(temp);
		}
		if (!diagonal2.getPiece().equals(null) && !diagonal2.getPiece().getColor().isWhite()) {
			temp[0] = y1;
			temp[1] = x1;
			movesList.add(temp);
		}
		
		if(!lateral1.getPiece().equals(null)
				&& !lateral1.getPiece().getColor().isWhite()
				&& lateral1.getPiece().getPieceName().equals(pawnString)) {
			Pawn tempPawn = (Pawn) lateral1.getPiece();
			if(tempPawn.getEnPassantPossible()) {
				temp[0] = y1;
				temp[1] = x2;
				movesList.add(temp);
			}
		}
		if(!lateral2.getPiece().equals(null)
				&& !lateral2.getPiece().getColor().isWhite()
				&& lateral2.getPiece().getPieceName().equals(pawnString)) {
			Pawn tempPawn = (Pawn) lateral2.getPiece();
			if(tempPawn.getEnPassantPossible()) {
				temp[0] = y1;
				temp[1] = x1;
				movesList.add(temp);
			}
		} 
		return movesList;
	}
	
	public List<Integer[]> getBlackPossibleMoves(Space[][] spaces, List<Integer[]> movesList, Pawn pawn) {
		Integer y1 = pawn.getY()-1;
		Integer y2 = pawn.getY()-2;
		Integer y3 = pawn.getY();
		Integer x1 = pawn.getX()-1;
		Integer x2 = pawn.getX()+1;
		Integer x3 = pawn.getX();
		Space forward1 = spaces [y1] [x3];
		Space forward2 = spaces [y2] [x3];
		Space diagonal1 = spaces[y1][x2];
		Space diagonal2 = spaces[y1][x1];
		Space lateral1 = spaces[y3][x2];
		Space lateral2 = spaces[y3][x1];
		String pawnString = "P";
		Integer[] temp = new Integer[2];
		
		if(forward1.getPiece().equals(null)) {
			temp[0] = y1;
			temp[1] = x3;
			movesList.add(temp);
			if(!pawn.getHasMoved() && forward2.getPiece().equals(null)) {
				temp[0] = y2;
				temp[1] = x3;
				movesList.add(temp);
			}
		}
		
		if(!diagonal1.getPiece().equals(null) && !diagonal1.getPiece().getColor().isWhite()) {
			temp[0] = y1;
			temp[1] = x2;
			movesList.add(temp);
		}
		if (!diagonal2.getPiece().equals(null) && !diagonal2.getPiece().getColor().isWhite()) {
			temp[0] = y1;
			temp[1] = x1;
			movesList.add(temp);
		}
		
		if(!lateral1.getPiece().equals(null)
				&& !lateral1.getPiece().getColor().isWhite()
				&& lateral1.getPiece().getPieceName().equals(pawnString)) {
			Pawn tempPawn = (Pawn) lateral1.getPiece();
			if(tempPawn.getEnPassantPossible()) {
				temp[0] = y1;
				temp[1] = x1;
				movesList.add(temp);
			}
		}
		if(!lateral2.getPiece().equals(null)
				&& !lateral2.getPiece().getColor().isWhite()
				&& lateral2.getPiece().getPieceName().equals(pawnString)) {
			Pawn tempPawn = (Pawn) lateral2.getPiece();
			if(tempPawn.getEnPassantPossible()) {
				temp[0] = y1;
				temp[1] = x1;
				movesList.add(temp);
			}
		} 
		return movesList;
	}

	
	public List<Integer[]> getPossibleMovesBishop(Space[][] spaces, Piece piece, List<Integer[]> movesList) {

		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesKnight(Space[][] spaces, Piece piece, List<Integer[]> movesList) {

		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesKing(Space[][] spaces, Piece piece, List<Integer[]> movesList) {

		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesQueen(Space[][] spaces, Piece piece, List<Integer[]> movesList) {
		
		return movesList;
	}
	
	public List<Integer[]> getPossibleMovesRook(Space[][] spaces, Piece piece, List<Integer[]> movesList) {

		return movesList;
	}
	
}
