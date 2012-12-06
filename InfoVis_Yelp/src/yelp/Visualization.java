package yelp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Visualization extends JPanel
{
	ArrayList<ScoreObj> dataset;
	ArrayList<String> rest_categories;
	Color [] rating_colors = new Color[9];
	JPanel yelpVis = new JPanel();

	public Visualization()
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
			dataset = mapper.readValue(new File("all_ratings.json"), 
					new TypeReference<List<ScoreObj>>(){});
			rest_categories = new ArrayList<String>();
			String [] r_cats = new String[23];
			String [] rating_types = new String[9];
			//System.out.println("size: " + dataset.size()); //106 restaurants total.
			for(ScoreObj a : dataset)
			{
				if(!rest_categories.contains(a.getCategory())) //23 categories total.
				{
					rest_categories.add(a.getCategory());
					System.out.println(a.getCategory());
				}
			}
			rating_types[0] = "Overall Rating";
			rating_colors[0] = Color.BLUE;
			rating_types[1] = "Cool Reviews";
			rating_colors[1] = Color.RED;
			rating_types[2] = "Useful Reviews";
			rating_colors[2] = Color.GREEN;
			rating_types[3] = "Funny Reviews";	
			rating_colors[3] = Color.YELLOW;
			rating_types[4] = "Cool Reviewers";		
			rating_colors[4] = Color.MAGENTA;
	    	rating_types[5] = "Useful Reviewers";
	    	rating_colors[5] = Color.ORANGE;
	    	rating_types[6] = "Funny Reviewers";
	    	rating_colors[6] = Color.CYAN;
	    	rating_types[7] = "Recent Ratings";
	    	rating_colors[7] = Color.PINK;
	    	rating_types[8] = "Reviewer's quantity of ratings";
	    	rating_colors[8] = Color.LIGHT_GRAY;
			rest_categories.toArray(r_cats);
    		JComboBox cats = new JComboBox(r_cats);
    		JComboBox rats = new JComboBox(rating_types);
    		JLabel cat_title = new JLabel("Select a category:");
    		JLabel rating_title = new JLabel("Sort based on:");
			//cats.addActionListener(this);

    		//Lay out everything.
			yelpVis.add(rating_title);
			yelpVis.add(rats);
			yelpVis.add(cat_title);
			yelpVis.add(cats);
			add(yelpVis);
    		
			cats.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ap) 
				{
					JComboBox cb = (JComboBox)ap.getSource();
				    String newSelection = (String)cb.getSelectedItem(); //gets category name.
				    updateView(newSelection);
				}
			});
			rats.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event) 
				{
					JComboBox cb = (JComboBox)event.getSource();
				    String newSelection = (String)cb.getSelectedItem();
				    System.out.println("Sort by: " + newSelection);
				    
				    //SORT BASED ON RATING TYPE SELECTED.
				    
				}
			});
		
			
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


	
	public void updateView(String category)
	{
		int cnt = 0;
		
		System.out.println(category.toUpperCase() + "\n------------------");
		for(ScoreObj scobj : dataset)
		{
			if(scobj.getCategory().equals(category))
			{
				cnt++;
				System.out.println(cnt+ ".) " + scobj.getName() + " S1:"
						+ scobj.getS1() + " S2:"
						+ scobj.getS2() + " S3:"
						+ scobj.getS3() + " S4:"
						+ scobj.getS4() + " S5:"
						+ scobj.getS5() + " S6:"
						+ scobj.getS6() + " S7:"
						+ scobj.getS7() + " S8:"
						+ scobj.getS8() + " S9:"
						+ scobj.getS9());
				//SHOW DATA FOR RESTAURANTS IN THIS CATEGORY			
			}
		}
		repaint();
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
	}

    private static void createAndShowGUI() 
	{
	        //Create and set up the window.
	        JFrame frame = new JFrame("Visualization");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        //Create and set up the content pane.
	        JComponent newContentPane = new Visualization();
	        newContentPane.setOpaque(true); //content panes must be opaque
	        frame.setContentPane(newContentPane);

	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	}

	    public static void main(String[] args) 
	    {
	       createAndShowGUI();    
	    }
	
}
