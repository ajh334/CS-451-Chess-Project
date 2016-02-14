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
	private ChessColor color;
	private Boolean hasMoved = false;
	private Boolean enPassantPossible = false;
	private BufferedImage image;
	private Integer x;
	private Integer y;

	public Pawn(ChessColor color) {
		this.color = color;
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
		if(this.color.isWhite()) {
			movesList = getWhitePossibleMoves(spaces, movesList);
		} else if (!this.color.isWhite()) {
			movesList = getBlackPossibleMoves(spaces, movesList);
		}

		return movesList;
	}
	
	public List<Space> getWhitePossibleMoves(Space[][] spaces, List<Space> movesList) {
		Space forward1 = spaces [this.getY()+1] [this.getX()];
		Space forward2 = spaces [this.getY()+2] [this.getX()];
		Space diagonal1 = spaces[this.getY()+1][this.getX()+1];
		Space diagonal2 = spaces[this.getY()+1][this.getX()-1];
		Space lateral1 = spaces[this.getY()][this.getX()+1];
		Space lateral2 = spaces[this.getY()][this.getX()-1];
		if(!hasMoved) {
			if(forward1.getPiece().equals(null)) {
				movesList.add(forward1);
				if(forward2.getPiece().equals(null)) {
					movesList.add(forward2);
				}
			}
				
		} else {
			movesList.add(spaces[this.getY()+1][this.getX()]);
		}
		if(!diagonal1.getPiece().equals(null) && !diagonal1.getPiece().getColor().isWhite()) {
			movesList.add(diagonal1);
		}
		if (!diagonal2.getPiece().equals(null) && !diagonal2.getPiece().getColor().isWhite()) {
			movesList.add(diagonal2);
		}
		
		if(!lateral1.getPiece().equals(null)
				&& !lateral1.getPiece().getColor().isWhite()
				&& lateral1.getPiece().getClass().equals(this)) {
			Pawn temp = (Pawn) lateral1.getPiece();
			if(temp.getEnPassantPossible()) {
				movesList.add(lateral1);
			}
		}
		if(!lateral2.getPiece().equals(null)
				&& !lateral2.getPiece().getColor().isWhite()
				&& lateral2.getPiece().getClass().equals(this)) {
			Pawn temp = (Pawn) lateral2.getPiece();
			if(temp.getEnPassantPossible()) {
				movesList.add(lateral1);
			}
		} 
		return movesList;
	}
	
	public List<Space> getBlackPossibleMoves(Space[][] spaces, List<Space> movesList) {
		Space forward1 = spaces [this.getY()-1] [this.getX()];
		Space forward2 = spaces [this.getY()-2] [this.getX()];
		Space diagonal1 = spaces[this.getY()-1][this.getX()+1];
		Space diagonal2 = spaces[this.getY()-1][this.getX()-1];
		Space lateral1 = spaces[this.getY()][this.getX()+1];
		Space lateral2 = spaces[this.getY()][this.getX()-1];
		if(!hasMoved) {
			if(forward1.getPiece().equals(null)) {
				movesList.add(forward1);
				if(forward2.getPiece().equals(null)) {
					movesList.add(forward2);
				}
			}
				
		} else {
			movesList.add(spaces[this.getY()+1][this.getX()]);
		}
		if(!diagonal1.getPiece().equals(null) && diagonal1.getPiece().getColor().isWhite()) {
			movesList.add(diagonal1);
		}
		if (!diagonal2.getPiece().equals(null) && diagonal2.getPiece().getColor().isWhite()) {
			movesList.add(diagonal2);
		}
		if(!lateral1.getPiece().equals(null)
				&& lateral1.getPiece().getColor().isWhite()
				&& lateral1.getPiece().getClass().equals(this)) {
			Pawn temp = (Pawn) lateral1.getPiece();
			if(temp.getEnPassantPossible()) {
				movesList.add(lateral1);
			}
		}
		if(!lateral2.getPiece().equals(null)
				&& lateral2.getPiece().getColor().isWhite()
				&& lateral2.getPiece().getClass().equals(this)) {
			Pawn temp = (Pawn) lateral2.getPiece();
			if(temp.getEnPassantPossible()) {
				movesList.add(lateral1);
			}
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

	public Boolean getEnPassantPossible() {
		return enPassantPossible;
	}

	public void setEnPassantPossible(Boolean enPassantPossible) {
		this.enPassantPossible = enPassantPossible;
	}
}
