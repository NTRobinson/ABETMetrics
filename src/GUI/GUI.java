package GUI;


import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUI extends JFrame
{
	private JPanel assignments_p;
	private JButton button;
	private int[] screen_dimensions;
	
	public GUI(int width, int height, String title)
	{
		super(title);
	    center(width, height);
	    addWindowListener(new ExitGUI());
	}
	
private void center(int width, int height)
{
	setSize(width, height);
	//center the window
	Dimension screen_size = getToolkit().getScreenSize();
	screen_dimensions = new int[2];
	screen_dimensions[0] = screen_size.width;
	screen_dimensions[1] = screen_size.height;
	
	setLocation(screen_dimensions[0]/2 - width/2, screen_dimensions[1]/2 - height/2);
}

private class ExitGUI extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}

}
