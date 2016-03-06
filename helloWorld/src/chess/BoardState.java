package chess;

public class BoardState {
	private Space[][] currentBoardState = new Space[8][8];
	private BoardCheck boardCheck;
	public enum BoardCheck {
		NO_CHECK, CHECK, CHECKMATE, STALEMATE
	}
	public Space[][] getCurrentBoardState() {
		return currentBoardState;
	}
	public void setCurrentBoardState(Space[][] currentBoardState) {
		this.currentBoardState = currentBoardState;
	}
	public BoardCheck getBoardCheck() {
		return boardCheck;
	}
	public void setBoardCheck(BoardCheck boardCheck) {
		this.boardCheck = boardCheck;
	}
}
