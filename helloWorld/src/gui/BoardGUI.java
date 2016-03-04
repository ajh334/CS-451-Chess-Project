package gui;

import java.awt.BorderLayout;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import chess.ChessBoard;
import chess.ChessColor;
import chess.MoveValidation;
import chess.Space;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;

public class BoardGUI {
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private Space[][] spaces = new Space[8][8];
    private Integer[][] currentBoardState = new Integer[8][8];
    private JPanel chessBoard;
    private final int WHITE_START_ROW = 0;
    private final int BLACK_START_ROW = 7;
    private ArrayList<Integer[]> highlightedSpaces;
    private Boolean whiteTurn = true;
    
    public BoardGUI() {
    	initializeBoardGui();
    }
	

    public final void initializeBoardGui() {

        // set up the main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        highlightedSpaces = new ArrayList<Integer[]>();
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
        for (int x = 0; x < spaces.length; x++) {
            for (int y = 0; y < spaces[x].length; y++) {
                Space b = new Space();
                b.setText(x + " " + y);
                b.setxCoord(x);
                b.setyCoord(y);
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);
                if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.DARK_GRAY);
                }
                b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(b.getPiece() != null) {
							addHighlightListener(b);
						}
					}
				});
                spaces[x][y] = b;
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
    	populateBlackPieces(spaces);
    	populateWhitePieces(spaces);
    }
    
    public void populateWhitePieces(Space[][] spaces) {
		boolean white = true;
    	for (int i = 6; i < 8; i++) {
    		for (int j=0; j < 8; j++) {
    			if(i == 7) {
    				Space temp = spaces[j][i];
    				ChessColor color = new ChessColor(white);
    				Pawn piece = new Pawn(color, j, i);
    				temp.setPiece(piece);
    			} else if (i == 6) {
    				Space temp = spaces[j][i];
    				ChessColor color = new ChessColor(white);
    				Pawn piece = new Pawn(color, j, i);
    				temp.setPiece(piece);
    			}
    		}
    	}
    }
    
    public void populateBlackPieces(Space[][] spaces) {
		boolean black = false;
    	for (int i = 0; i < 2; i++) {
    		for (int j=0; j < 8; j++) {
    			if(i == 1) {
        			Space temp = spaces[j][i];
        			ChessColor color = new ChessColor(black);
        			Piece piece = new Rook(color, j, i);
        			temp.setPiece(piece);
    			} else if (i == 0) {
    				Space temp = spaces[j][i];
    				ChessColor color = new ChessColor(black);
    				Piece piece = new Pawn(color, j, i);
    				temp.setPiece(piece);
    			}
    		}
    	}
    }
    
    public void highlightButtons(ArrayList<Integer[]> moveList, Piece piece) {
    	for(int i = 0; i < moveList.size(); i++) {
    		Integer[] spaceCoord = moveList.get(i);
    		Integer x = spaceCoord[0];
    		Integer y = spaceCoord[1];
    		Space space = spaces[x][y];
    		space.setBackground(Color.CYAN);
    		space.addActionListener(new ActionListener() {
    			@Override
				public void actionPerformed(ActionEvent arg0) {
    				movePiece(piece, x, y);
    			}
    		});
    	}
    	highlightedSpaces = moveList;
    }
    
    
    public void deHighlightButtons() { 
    	for(int i = 0; i < highlightedSpaces.size(); i++) {
    		Integer[] spaceCoord = highlightedSpaces.get(i);
    		Integer x = spaceCoord[0];
    		Integer y = spaceCoord[1];
    		Space space = spaces[x][y];
            if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) {
            	space.setBackground(Color.WHITE);
            } else {
            	space.setBackground(Color.DARK_GRAY);
            }
            space.removeAllActionListeners();
            space.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(space.getPiece() != null) {
						addHighlightListener(space);
					}
				}
            });
    	}
    }
    
    public void addHighlightListener(Space b) {
    	ArrayList<Integer[]> moveList = new ArrayList<Integer[]>();
    	MoveValidation mv = new MoveValidation();
    	moveList = (ArrayList<Integer[]>) mv.getPossibleMoves(spaces, b.getPiece());
    	deHighlightButtons();
    	highlightButtons(moveList, b.getPiece());
    }
    
    public void movePiece(Piece piece, Integer x, Integer y) {
    	Integer pieceX = piece.getX();
    	Integer pieceY = piece.getY();
    	deHighlightButtons();
    	spaces[pieceX][pieceY].deletePiece();
    	piece.setX(x);
    	piece.setY(y);
    	spaces[x][y].setPiece(piece);
    	spaces[x][y].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				movePiece(piece, x, y);
			}
		});
    	this.whiteTurn = !this.whiteTurn;
    }
    
    
    
    public final JComponent getGUI() {
    	return gui;
    }
    
    public final Space[][] getSpaces() {
    	return spaces;
    }
}
