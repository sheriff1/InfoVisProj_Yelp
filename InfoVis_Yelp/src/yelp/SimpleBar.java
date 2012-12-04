package yelp;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class SimpleBar extends JPanel

{
	int width = 60;  // the initial width of bar
	int height = 20; // the initial height of bar
	
	private Map<Color, Integer> bars = new LinkedHashMap<Color, Integer>();
	
	/**
	 * Add new bar to chart
	 * @param color color to display bar
	 * @param value size of bar
	 */
	public void addBar(Color color,int value)
	{
		bars.put(color,value);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		
		// paint bars
		int x = 10; //initial X-axis
		int y = 120; //inital Y-axis
		int i = 0;
		
		for (Color color : bars.keySet())
		{
			
			g.setColor(color);
			g.fillRect(x, y, width, height);
			g.setColor(Color.BLACK);
			g.drawRect(x, y, width, height);
			
			i++;
			if(i%9 == 0) {
				x= 10;
				y=(y+50);
			}else{
				x += (width + 10);
			}
			
		}
	}
	
	


	public static void main(String[] args)
	{
		
		
		JFrame frame = new JFrame("Bar Chart");
		
		SimpleBar chart = new SimpleBar();
		chart.addBar(Color.red, 20);
		chart.addBar(Color.green, 20);
		chart.addBar(Color.blue, 20);
		chart.addBar(Color.yellow, 20);	
		chart.addBar(Color.magenta, 20);
		chart.addBar(Color.cyan, 20);
		chart.addBar(Color.gray, 20);
		chart.addBar(Color.pink, 20);
		chart.addBar(Color.ORANGE, 20);	
		chart.addBar(Color.lightGray, 20);
		chart.addBar(Color.black, 20);
		chart.addBar(Color.darkGray, 20);
		
		frame.getContentPane().add(chart);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
