package chess.pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

import chess.ChessColor;
import chess.Space;

public class Piece {
	private ChessColor color;
	private String pieceName;
	private BufferedImage image;
	private Integer x;
	private Integer y;
	
	public List<Space> getPossibleMoves(Space[][] spaces) {
		return null;
	}

	public ChessColor getColor() {
		return color;
	}

	public void setColor(ChessColor color) {
		this.color = color;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public String getPieceName() {
		return pieceName;
	}

	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}
}
