package yelp;

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

public class Visualization extends JPanel implements ActionListener
{
	ArrayList<ScoreObj> dataset;
	ArrayList<String> rest_categories;
	public Visualization()
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
			dataset = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/InfoVisProj_Yelp/all_ratings.json"), 
					new TypeReference<List<ScoreObj>>(){});
			rest_categories = new ArrayList<String>();
			String [] r_cats = new String[23];
			//System.out.println("size: " + dataset.size()); //106 restaurants total.
			for(ScoreObj a : dataset)
			{
				if(!rest_categories.contains(a.getCategory())) //23 categories total.
				{
					rest_categories.add(a.getCategory());
					//System.out.println(a.getCategory());
				}
			}
			rest_categories.toArray(r_cats);
    		JComboBox cats = new JComboBox(r_cats);
    		JLabel cat_title = new JLabel("Select a category:");
			cats.addActionListener(this);

			 //Lay out everything.
			JPanel yelpVis = new JPanel();
			yelpVis.add(cat_title);
			yelpVis.add(cats);
			add(yelpVis);
			
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

	public void actionPerformed(ActionEvent ap) 
	{
		JComboBox cb = (JComboBox)ap.getSource();
	    String newSelection = (String)cb.getSelectedItem(); //gets category name.
	    updateView(newSelection);
	}
	
	public void updateView(String category)
	{
		System.out.println(category.toUpperCase() + "\n------------------");
		for(ScoreObj g : dataset)
		{
			if(g.getCategory().equals(category))
			{
				//SHOW DATA FOR RESTAURANTS IN THIS CATEGORY
			}
		}
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
