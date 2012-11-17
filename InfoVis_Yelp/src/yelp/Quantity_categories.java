package yelp;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Quantity_categories {
	public static void main(String[] args) 	
	{
		try
		{ 
			String[] arrCat = {"Indian","Restaurants","Japanese","American (New)","Food","Farmers Market","American (Traditional)",
					"Bakeries","Donuts","Coffee & Tea","Sandwiches","Vegetarian","Vegan","Burgers","Sushi Bars","Greek","Pizza",
					"Mexican","Soup","Cajun/Creole","Bars","Pool Halls","Nightlife","Italian","Chinese","Ethiopian","Beer, Wine & Spirits",
					"Seafood","Buffets","Thai","Mediterranean","Specialty Food","Health Markets","Grocery","Steakhouses","Wine Bars",
					"Bed & Breakfast","Breakfast & Brunch","Diners","Desserts","Asian Fusion","Tea Rooms","Meat Shops","Fast Food",
					"Delis","Barbeque","Sports Bars","Tex-Mex"}; 
			
			Map<String,Integer> arrCatMap = new HashMap<String,Integer>(); //calculate the number of each category
			ObjectMapper mapper = new ObjectMapper();
			List<Business_Prof> biz_profs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/VT_jsons/VT_business_profiles.json"), 
					new TypeReference<List<Business_Prof>>(){});
			Integer temp = 0;
			for(String arr:arrCat){
				for(Business_Prof bp: biz_profs){
					if(bp.getSchools().contains("Virginia Tech")){
						if(bp.getCategories().contains(arr)){
							if(arrCatMap.containsKey(arr)){
								arrCatMap.put(arr, arrCatMap.get(arr)+1);
							}else{
								arrCatMap.put(arr, 1);
							}
						}
					}
					
				}
				
			}
			
			
			for(String arr:arrCatMap.keySet()){
				temp = arrCatMap.get(arr);
				if(temp >= 3){
					System.out.println(arr+":"+temp);
				}
			}
			
		} 
		catch (Exception e) 
		{
			System.out.println("IOException");
			e.printStackTrace();
		}

		}
}
