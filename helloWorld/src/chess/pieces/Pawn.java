package chess.pieces;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import chess.ChessColor;
import chess.Space;

public class Pawn extends Piece{
	private String blackPawnURL = "http://i.imgur.com/l5slgWd.png";
	private String whitePawnURL = "http://i.imgur.com/UFLmr7M.jpg";
	private Boolean hasMoved = false;
	private BufferedImage image;
	private Integer x;
	private Integer y;

	public Pawn(ChessColor color) {
		if(color.isWhite()) {
			BufferedImage bi;
			try {
				URL url = new URL(whitePawnURL);
				bi = ImageIO.read(url);
				image = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB_PRE);
				Graphics g = image.getGraphics();
				g.drawImage(bi.getScaledInstance(64, 64, Image.SCALE_SMOOTH), 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			BufferedImage bi;
			try {
				URL url = new URL(blackPawnURL);
				bi = ImageIO.read(url);
				image = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB_PRE);
				Graphics g = image.getGraphics();
				g.drawImage(bi.getScaledInstance(64, 64, Image.SCALE_SMOOTH), 0, 0, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public List<Space> getPossibleMoves(Space[][] spaces) {
		List<Space> movesList = new ArrayList<Space>();
		if(!hasMoved) {
			
		}
		
		return movesList;
	}

	public Boolean getHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(Boolean hasMoved) {
		this.hasMoved = hasMoved;
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

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
