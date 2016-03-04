package chess.pieces;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import chess.ChessColor;

public class Bishop extends Piece {
	
	private String blackBishopFile = "blackbishop.png";
	private String whiteBishopFile = "whitebishop.png";
	public Bishop(ChessColor color, Integer x, Integer y) {
		this.pieceName = "B";
		this.x = x;
		this.y = y;
		this.color = color;
		if(color.isWhite()) {
			BufferedImage bi;
			try {
				File img = new File(whiteBishopFile);
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
				File img = new File(blackBishopFile);
				bi = ImageIO.read(img);
				image = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB_PRE);
				Graphics g = image.getGraphics();
				g.drawImage(bi.getScaledInstance(64, 64, Image.SCALE_SMOOTH), 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
