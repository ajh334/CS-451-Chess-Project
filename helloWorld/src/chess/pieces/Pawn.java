package chess.pieces;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import chess.ChessColor;
import chess.Space;

public class Pawn extends Piece{
	private String blackPawnFile = "blackpawn.png";
	private String whitePawnFile = "whitepawn.png";
	private Boolean hasMoved = false;
	private Boolean enPassantPossible = false;

	public Pawn(ChessColor color, Integer x, Integer y) {
		this.pieceName = "P";
		this.x = x;
		this.y = y;
		this.color = color;
		if(color.isWhite()) {
			BufferedImage bi;
			try {
				File img = new File(whitePawnFile);
				bi = ImageIO.read(img);
				image = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB_PRE);
				Graphics g = image.getGraphics();
				g.drawImage(bi.getScaledInstance(64, 64, Image.SCALE_SMOOTH), 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			BufferedImage bi;
			try {
				File img = new File(blackPawnFile);
				bi = ImageIO.read(img);
				image = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB_PRE);
				Graphics g = image.getGraphics();
				g.drawImage(bi.getScaledInstance(64, 64, Image.SCALE_SMOOTH), 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Boolean getHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(Boolean hasMoved) {
		this.hasMoved = hasMoved;
	}

/*	public Integer getX() {
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
	}*/

/*	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}*/

	public Boolean getEnPassantPossible() {
		return enPassantPossible;
	}

	public void setEnPassantPossible(Boolean enPassantPossible) {
		this.enPassantPossible = enPassantPossible;
	}
}
