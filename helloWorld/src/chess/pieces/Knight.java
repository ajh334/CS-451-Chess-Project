package chess.pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import chess.ChessColor;

public class Knight extends Piece {
	private String blackKnightURL = "https://upload.wikimedia.org/wikipedia/commons/e/ef/Chess_ndt45.svg";
	private String whiteKnightURL = "https://upload.wikimedia.org/wikipedia/commons/7/70/Chess_nlt45.svg";
	private String pieceName = "H";
	Knight(ChessColor color) {
		Image image;
		if(color.isWhite()) {
			BufferedImage bi;
			try {
				URL url = new URL(whiteKnightURL);
				bi = ImageIO.read(url);
				image = bi;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			BufferedImage bi;
			try {
				URL url = new URL(blackKnightURL);
				bi = ImageIO.read(url);
				image = bi;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
