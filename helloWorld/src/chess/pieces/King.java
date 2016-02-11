package chess.pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import chess.ChessColor;

public class King extends Piece {
	private String blackKingURL = "https://upload.wikimedia.org/wikipedia/commons/f/f0/Chess_kdt45.svg";
	private String whiteKingURL = "https://upload.wikimedia.org/wikipedia/commons/4/42/Chess_klt45.svg";
	int[][] offsets = {
	        {1, 0},
	        {0, 1},
	        {-1, 0},
	        {0, -1},
	        {1, 1},
	        {-1, 1},
	        {-1, -1},
	        {1, -1}
	};
	King(ChessColor color) {
		Image image;
		if(color.isWhite()) {
			BufferedImage bi;
			try {
				URL url = new URL(whiteKingURL);
				bi = ImageIO.read(url);
				image = bi;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			
		}
	}
}
