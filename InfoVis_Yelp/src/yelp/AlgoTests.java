package yelp;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AlgoTests 
{
	public static void main (String[] args)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			List<Business_Prof> biz_profs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/VT_jsons/VT_business_profiles_food_only.json"), 
				new TypeReference<List<Business_Prof>>(){});
			List<User_Prof> user_profs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/VT_jsons/VT_user_profiles.json"), 
					new TypeReference<List<User_Prof>>(){});
			List<User_Review> usr_revs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/VT_jsons/VT_user_reviews.json"), 
					new TypeReference<List<User_Review>>(){});
			List<ScoreObj> scobj = mapper.readValue(new File("all_ratings.json"), 
					new TypeReference<List<ScoreObj>>(){});
			Algorithms.Algo1(biz_profs, user_profs, usr_revs);
			//Algorithms.Algo2(scobj);
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
