package chess.pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import chess.ChessColor;

public class Bishop extends Piece {
	
	private String blackBishopURL = "https://upload.wikimedia.org/wikipedia/commons/9/98/Chess_bdt45.svg";
	private String whiteBishopURL = "https://upload.wikimedia.org/wikipedia/commons/b/b1/Chess_blt45.svg";
	public Bishop(ChessColor color, Integer x, Integer y) {
		this.pieceName = "B";
		this.x = x;
		this.y = y;
		this.color = color;
		Image image;
		if(color.isWhite()) {
			BufferedImage bi;
			try {
				URL url = new URL(whiteBishopURL);
				bi = ImageIO.read(url);
				image = bi;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			BufferedImage bi;
			try {
				URL url = new URL(blackBishopURL);
				bi = ImageIO.read(url);
				image = bi;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
