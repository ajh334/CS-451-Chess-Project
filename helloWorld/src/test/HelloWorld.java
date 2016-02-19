package test;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.*;

public class HelloWorld {
	public static JFrame f = new JFrame("ChessChamp");

	public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() 
            {
            	GUI gui = new LoginGUI();
                //BoardGUI gui = new BoardGUI();

                f = new JFrame("Chess Champ");
                //f.add(gui.getGUI());
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);
                f.setContentPane(gui.getPanel());

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
	}

}
