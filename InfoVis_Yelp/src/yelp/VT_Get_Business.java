package yelp;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class VT_Get_Business {

		public static void main(String[] args) 	
		{
			try
			{
				int cnt = 0;
				ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
				List<Business_Prof> biz_profs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/jsons/business_profiles.json"), 
						new TypeReference<List<Business_Prof>>(){});
				PrintWriter out = new PrintWriter(new FileWriter("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/jsons/VT_business_profiles_food_only.json"));
				
				String[] arrCat = {"Indian","Restaurants","Japanese","American (New)","Food","Farmers Market","American (Traditional)",
						"Bakeries","Donuts","Coffee & Tea","Sandwiches","Vegetarian","Vegan","Burgers","Sushi Bars","Greek","Pizza",
						"Mexican","Soup","Cajun/Creole","Bars","Pool Halls","Nightlife","Italian","Chinese","Ethiopian","Beer, Wine & Spirits",
						"Seafood","Buffets","Thai","Mediterranean","Specialty Food","Health Markets","Grocery","Steakhouses","Wine Bars",
						"Bed & Breakfast","Breakfast & Brunch","Diners","Desserts","Asian Fusion","Tea Rooms","Meat Shops","Fast Food",
						"Delis","Barbeque","Sports Bars","Tex-Mex"}; 
				ArrayList<String> foodonly = new ArrayList<String>(Arrays.asList(arrCat));
				
				for(Business_Prof bp : biz_profs)
				{
					if(bp.getSchools().contains("Virginia Tech"))
					{
						for(String str : foodonly)
						{
							if(bp.getCategories().contains(str))
							{
								out.println(mapper.writeValueAsString(bp) + ",");		
								cnt++;
								break;
							}
						}
					}
				}
				out.close();
				System.out.println("Countttt: " + cnt);
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
