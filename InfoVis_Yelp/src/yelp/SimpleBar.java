package yelp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SimpleBar extends JPanel
{
	private static final String [] categories = {"Indian","Japanese","American","Grocery","Bakery","Sandwiches","Vegetarian","Burgers",
		"Seafood",
		"Greek",
		"Pizza",
		"Mexican",
		"Coffee",
		"Cajun",
		"Bars",
		"Chinese",
		"Ethiopian",
		"Italian",
		"Thai",
		"Health Food",
		"Sushi",
		"Meat Shops",
		"Desserts"};
	private static final String [] rating_types = {"Overall Rating", "Cool Reviews",
	"Useful Reviews",
	"Funny Reviews",
	"Cool Reviewers",
	"Useful Reviewers",
	"Funny Reviewers",
	"Recent Ratings",
	"Reviewer's quantity of ratings"};

	private static JComboBox cats = new JComboBox(categories);
    private static JComboBox rats = new JComboBox(rating_types);
    ArrayList<ScoreObj> dataset;
    JPanel panel;
	JPanel panel1;

	@Override
	protected void paintComponent(Graphics g)
	{
		Color [] rating_colors = new Color[9];

		rating_colors[0] = Color.BLUE;
		rating_colors[1] = Color.RED;
		rating_colors[2] = Color.GREEN;
		rating_colors[3] = Color.YELLOW;
		rating_colors[4] = Color.MAGENTA;
		rating_colors[5] = Color.ORANGE;
		rating_colors[6] = Color.CYAN;
		rating_colors[7] = Color.PINK;
		rating_colors[8] = Color.LIGHT_GRAY;
		// paint bars
		int x = 10; //initial X-axis
		int y = 50; //inital Y-axis
		int width = 100;  // the initial width of bar
		int height = 20; // the initial height of bar
		
		for (int dy=0; dy<9; dy++)
		{
			g.drawString("Strang",x,y+dy);
			
			for (int dx=0; dx<9; dx++)
			{
				for(int a=0; a<9; a++)
				{
					g.setColor(rating_colors[a]);
					g.fillRect(x, y, width, height);
					g.setColor(Color.BLACK);
					g.drawRect(x, y, width, height);
				}
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		new SimpleBar().start();
	}
	
	public void start()
	{
		panel = new JPanel();
		JFrame frame = new JFrame("Bar Chart");
		JLabel cat_title = new JLabel("Select a category:");
		JLabel rating_title = new JLabel("Sort based on:");
		JButton submit = new JButton("Roll 'em!");
		submit.addActionListener(new SubmitButton());
	
		
		panel.add(rating_title);
		panel.add(rats);
		panel.add(cat_title);
		panel.add(cats);
		panel.add(submit);
		
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	class SubmitButton implements ActionListener
    {
		public void actionPerformed(ActionEvent ae) 
	    {

        }
    }		
		
}


/*ArrayList<ScoreObj> dataset;
try
{
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		dataset = mapper.readValue(new File("all_ratings.json"), 
					new TypeReference<List<ScoreObj>>(){});
			    
    // in the button's action listener, use the references to both 
    // combo boxes to get the selected items
    String rat_type = rats.getSelectedItem().toString();
    String cat_type = cats.getSelectedItem().toString();
    repaint();
	}
catch (JsonGenerationException e) 
	{
		System.out.println("JsonGenerationException");
		e.printStackTrace();
	} 
catch (JsonParseException e) 
{
	System.out.println("JsonParseException");
		e.printStackTrace();
	} 
	catch (JsonMappingException e) 
	{
		System.out.println("JsonMappingException");
		e.printStackTrace();
	} 
	catch (IOException e) 
	{
		System.out.println("IOException");
		e.printStackTrace();
	}*/
