package chess;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ChessBoard extends Board{
	
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    
	
	public ChessBoard() {
		board = new ArrayList<ArrayList<Space>>();
	}
	
}
