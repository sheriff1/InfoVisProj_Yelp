package yelp;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class DiceService{
	MyPanel myPanel;
	JPanel panel1;
	JComboBox numOfDice;
	JPanel panel;
	JScrollPane scroller;
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
	"Recent Rating",
	"High Volume Reviewers"};
	/*private static final Color [] rating_colors = {Color.BLUE,Color.RED,Color.GREEN,Color.YELLOW,
	Color.MAGENTA,
	Color.ORANGE,
	Color.CYAN,
	Color.PINK,
	Color.LIGHT_GRAY};*/
	private static JComboBox cats = new JComboBox(categories);
    private static JComboBox rats = new JComboBox(rating_types);
    ArrayList<ScoreObj> dataset;
    
	public DiceService()
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper(); 
			dataset = mapper.readValue(new File("all_ratings.json"), 
					new TypeReference<List<ScoreObj>>(){});
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
		}
	}
	public static void main(String[] args){
		new DiceService().go();
	}

	public void go(){
		JFrame frame = new JFrame("VT Yelp++");
		panel = new JPanel();
		JButton button = new JButton("Submit");
		button.addActionListener(new RollEmListener());
		JLabel cat_title = new JLabel("Select a category:");
		JLabel rating_title = new JLabel("Sort based on:");
		Border blackline = BorderFactory.createLineBorder(Color.red);
		
		System.out.println("STRANG" + panel.toString());
		panel.setMaximumSize(new Dimension(1400,50));
		System.out.println("STRANG" + panel.toString());

		//initialize bar graph panel
		myPanel = new MyPanel();
		scroller = new JScrollPane(myPanel);  
		myPanel.setBorder(blackline);
		
		//initialize buttons and dropdown menu
		//panel.setBorder(blackline2);
		panel.add(rating_title);
		panel.add(rats);
		panel.add(cat_title);
		panel.add(cats);
		panel.add(button);
		
		//creates visualization panels
		panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(panel);
		panel1.add(scroller);
		
		//draws visualization panels on JSwing window
		frame.getContentPane().add(BorderLayout.CENTER, panel1);  
		frame.setSize(800,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class RollEmListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			panel1.remove(scroller);
			panel1.add(scroller);
			panel1.validate();
			panel1.repaint();
		}
		
	}


	class MyPanel extends JPanel{
		
		
		protected void paintComponent(Graphics g)
		{
			    int rat_index = rats.getSelectedIndex();
				String cat_type = cats.getSelectedItem().toString();
				int x = 10; //initial X-axis
				int y = 50; //inital Y-axis
				int height = 15; // the initial height of bar
				ArrayList<ScoreObj> catted = new ArrayList<ScoreObj>();
				ArrayList<ScoreObj> sorted = new ArrayList<ScoreObj>(); 
				Color freshblue = new Color(88,161,255);
				Color darkblue = new Color(20,0,190);
				//SORTING
				for (ScoreObj sc : dataset)
				{
					if(sc.getCategory().equals(cat_type))
					{
						catted.add(sc);
					}
				}
				
				while(!catted.isEmpty())
				{

				ScoreObj temp = new ScoreObj();
				for (ScoreObj sc : catted)
				{
					
					if(sc.getScores(rat_index) > temp.getScores(rat_index))
					{
						temp = sc;
					}
					
				}
				//System.out.println("IT IS: " + temp.getName());
				sorted.add(temp);
				catted.remove(temp);
				}
				
				
				//DRAWING
				g.drawString("Restaurant:", x, y);				
				x=x+250;
				for(int c=0; c<9; c++)
				{
					g.drawString(rating_types[c],x,y);
					x = x + 110;
				}
				y=y+10;
				for (ScoreObj sc : sorted) 
				{
					x=10;
						g.setColor(Color.BLACK);
						g.drawString(sc.getName(),x,y+12);
						x=x+250;
						for(int a=0; a<9; a++)
						{
							int width = sc.scoresArray()[a];
							if(a==rat_index)
							{
								g.setColor(freshblue);
								g.fillRect(x, y, width, height);
								g.setColor(Color.BLACK);
								g.drawRect(x, y, 100, height);
							}
							else
							{
								g.setColor(darkblue);
								g.fillRect(x, y, width, height);
								g.setColor(Color.BLACK);
								g.drawRect(x, y, 100, height);
							}
							
							x=x+110;
						}
						y=y+25;
				}
				
		}

	}

	
}