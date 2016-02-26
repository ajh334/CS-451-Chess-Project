package chess;

public class BoardState {
	private Integer[][] currentBoardState = new Integer[8][8];
	private BoardCheck boardCheck;
	public enum BoardCheck {
		NO_CHECK, CHECK, CHECKMATE, STALEMATE
	}
	public Integer[][] getCurrentBoardState() {
		return currentBoardState;
	}
	public void setCurrentBoardState(Integer[][] currentBoardState) {
		this.currentBoardState = currentBoardState;
	}
	public BoardCheck getBoardCheck() {
		return boardCheck;
	}
	public void setBoardCheck(BoardCheck boardCheck) {
		this.boardCheck = boardCheck;
	}
}
