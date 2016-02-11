package chess;

public class ChessColor {
	Boolean isWhite;
	
	public ChessColor (Boolean isWhite){
		this.isWhite = isWhite;
	}
	
	public void setColor(Boolean isWhite){ 
		this.isWhite = isWhite;
	}
	
	public Boolean isWhite() {
		return isWhite;
	}
	
}
