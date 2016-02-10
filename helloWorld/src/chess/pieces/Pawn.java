package chess.pieces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import chess.ChessColor;

public class Pawn extends Piece{
	private String blackPawnURL = "https://upload.wikimedia.org/wikipedia/commons/c/c7/Chess_pdt45.svg";
	private String whitePawnURL = "https://upload.wikimedia.org/wikipedia/commons/4/45/Chess_plt45.svg";
	Pawn(ChessColor color) {
		Image image;
		if(color.isWhite()) {
			BufferedImage bi;
			try {
				URL url = new URL(whitePawnURL);
				bi = ImageIO.read(url);
				image = bi;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			BufferedImage bi;
			try {
				URL url = new URL(blackPawnURL);
				bi = ImageIO.read(url);
				image = bi;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
