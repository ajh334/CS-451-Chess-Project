package test;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import clientserver.ChessClient;
import gui.*;

public class ChessChamp {
	public static JFrame f = new JFrame("ChessChamp");

	public static void main(String[] args) 
	{
        Runnable r = new Runnable() 
        {
            @Override
            public void run() 
            {
            	
                //BoardGUI gui = new BoardGUI();
            	 String serverAddress = (args.length == 0) ? "localhost" : args[1];
                 try {
					ChessClient client = new ChessClient(serverAddress);
					GUI gui = new LoginGUI(client);
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
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}             
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
	}
}
