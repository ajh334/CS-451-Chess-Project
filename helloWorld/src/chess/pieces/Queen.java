package chess.pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import chess.ChessColor;

public class Queen extends Piece {
	private String blackQueenURL = "https://upload.wikimedia.org/wikipedia/commons/4/47/Chess_qdt45.svg";
	private String whiteQueenURL = "https://upload.wikimedia.org/wikipedia/commons/1/15/Chess_qlt45.svg";
	private String pieceName = "Q";
	Queen(ChessColor color) {
		Image image;
		if(color.isWhite()) {
			BufferedImage bi;
			try {
				URL url = new URL(whiteQueenURL);
				bi = ImageIO.read(url);
				image = bi;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			BufferedImage bi;
			try {
				URL url = new URL(blackQueenURL);
				bi = ImageIO.read(url);
				image = bi;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
