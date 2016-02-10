package chess.pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import chess.ChessColor;

public class Rook extends Piece {
	private String blackRookURL = "https://upload.wikimedia.org/wikipedia/commons/f/ff/Chess_rdt45.svg";
	private String whiteRookURL = "https://upload.wikimedia.org/wikipedia/commons/7/72/Chess_rlt45.svg";
	Rook(ChessColor color) {
		Image image;
		if(color.isWhite()) {
			BufferedImage bi;
			try {
				URL url = new URL(whiteRookURL);
				bi = ImageIO.read(url);
				image = bi;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			BufferedImage bi;
			try {
				URL url = new URL(blackRookURL);
				bi = ImageIO.read(url);
				image = bi;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
