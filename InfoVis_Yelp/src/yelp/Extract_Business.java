package yelp;
import java.io.File;
	import java.io.IOException;
	import java.util.List;

	import com.fasterxml.jackson.core.JsonGenerationException;
	import com.fasterxml.jackson.core.JsonParseException;
	import com.fasterxml.jackson.core.type.TypeReference;
	import com.fasterxml.jackson.databind.JsonMappingException;
	import com.fasterxml.jackson.databind.ObjectMapper;


public class Extract_Business {

		public static void main(String[] args) 	
		{
			try
			{
				int cnt = 0;
				ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
				/*Collection<UserProf> user_profs =  
					      mapper.readValue(new File("/Users/sheriff/Documents/eclipse-Java EE/workspace/InfoVis_Yelp/jsons/user_profiles.json"),  
					        new TypeReference<Collection<UserProf>>() {});*/
				List<Business_Prof> biz_profs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/jsons/business_profiles.json"), 
						new TypeReference<List<Business_Prof>>(){});
				for(Business_Prof bp: biz_profs)
				{
					if (bp.getSchools().contains("Virginia Tech"))
					{
						System.out.println(bp.getName());
						cnt++;
					}
				}
				System.out.println("there are " + cnt + " restaurants near VT");
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
