package yelp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Visualization 
{
	public static void main(String[] args) 	
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
			ArrayList<ScoreObj> dataset = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/InfoVisProj_Yelp/all_ratings.json"), 
					new TypeReference<List<ScoreObj>>(){});
			ArrayList<String> rest_categories = new ArrayList<String>();
			//System.out.println("size: " + dataset.size()); //106 restaurants total.
			for(ScoreObj a : dataset)
			{
				if(!rest_categories.contains(a.getCategory())) //23 categories total.
				{
					rest_categories.add(a.getCategory());
					System.out.println(a.getCategory());
				}
			}
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
	
}
