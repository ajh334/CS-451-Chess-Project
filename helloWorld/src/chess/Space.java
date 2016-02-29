package chess;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import chess.pieces.Piece;

public class Space extends JButton{
	protected Piece piece;
	protected Integer xCoord;
	protected Integer yCoord;
	
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.setIcon(new ImageIcon(piece.getImage()));
		this.piece = piece;
	}
	public Integer getxCoord() {
		return xCoord;
	}
	public void setxCoord(Integer xCoord) {
		this.xCoord = xCoord;
	}
	public Integer getyCoord() {
		return yCoord;
	}
	public void setyCoord(Integer yCoord) {
		this.yCoord = yCoord;
	}
	
	public Boolean isPiece() {
		if(piece == null) {
			return false;
		}
		return true;
	}

	
}
