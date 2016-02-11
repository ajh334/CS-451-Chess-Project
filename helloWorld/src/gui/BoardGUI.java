package gui;

import java.awt.BorderLayout;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

import chess.ChessBoard;
import chess.ChessColor;
import chess.Space;
import chess.pieces.Pawn;
import chess.pieces.Piece;

public class BoardGUI {
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private Space[][] spaces = new Space[8][8];
    private JPanel chessBoard;
    private final int WHITE_START_ROW = 0;
    private final int BLACK_START_ROW = 7;
    
    public BoardGUI() {
    	initializeBoardGui();
    }
	

    public final void initializeBoardGui() {

        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        Action concedeAction = new AbstractAction("Concede") {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        Action drawAction = new AbstractAction("Draw") {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        Action endTurnAction = new AbstractAction("End Turn") {

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        tools.add(concedeAction);
        tools.add(drawAction);
        tools.add(endTurnAction);
        tools.addSeparator();

        gui.add(new JLabel("?"), BorderLayout.LINE_START);

        chessBoard = new JPanel(new GridLayout(0, 8)) {
            @Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension(
                            (int) d.getWidth(), (int) d.getHeight());
                } else if (c != null && c.getWidth() > d.getWidth() && c.getHeight() > d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (w>h ? h : w);
                return new Dimension(s,s);
            }
        };
        chessBoard.setBorder(new CompoundBorder(
                new EmptyBorder(8,8,8,8),
                new LineBorder(Color.BLACK)
                ));
        Color ochre = new Color(204,119,34);
        chessBoard.setBackground(ochre);
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(ochre);
        boardConstrain.add(chessBoard);
        gui.add(boardConstrain);

        // create the chess board squares
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                Space b = new Space();
                b.setxCoord(i);
                b.setyCoord(j);
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.DARK_GRAY);
                }
                spaces[j][i] = b;
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                        chessBoard.add(spaces[j][i]);
            }
        }
        populateBoard(spaces);
    }
    
    public void populateBoard(Space[][] spaces) {
    	populateWhitePieces(spaces);
    	populateBlackPieces(spaces);
    }
    
    public void populateWhitePieces(Space[][] spaces) {
		boolean white = true;
    	for (int i = 0; i < 2; i++) {
    		for (int j=0; j < 8; j++) {
    			if(i == 0) {
    				Space temp = spaces[j][i];
    				ChessColor color = new ChessColor(white);
    				Piece piece = new Pawn(color);
    				temp.setPiece(piece);
    			} else if (i == 1) {
    				Space temp = spaces[j][i];
    				ChessColor color = new ChessColor(white);
    				Piece piece = new Pawn(color);
    				temp.setPiece(piece);
    			}
    		}
    	}
    }
    
    public void populateBlackPieces(Space[][] spaces) {
		boolean black = false;
    	for (int i = 6; i < 8; i++) {
    		for (int j=0; j < 8; j++) {
    			if(i == 6) {
    				Space temp = spaces[j][i];
    				ChessColor color = new ChessColor(black);
    				Piece piece = new Pawn(color);
    				temp.setPiece(piece);
    			} else if (i == 7) {
    				Space temp = spaces[j][i];
    				ChessColor color = new ChessColor(black);
    				Piece piece = new Pawn(color);
    				temp.setPiece(piece);
    			}
    		}
    	}
    }
    
    public final JComponent getGUI() {
    	return gui;
    }
    public final JButton[][] getSpaces() {
    	return spaces;
    }
}
