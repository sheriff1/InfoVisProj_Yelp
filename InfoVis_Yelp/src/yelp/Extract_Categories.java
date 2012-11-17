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


public class Extract_Categories {

		public static void main(String[] args) 	
		{
			try
			{
				int cnt = 0;
				ArrayList<String> cats = new ArrayList<String>();
				ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
				/*Collection<UserProf> user_profs =  
					      mapper.readValue(new File("/Users/sheriff/Documents/eclipse-Java EE/workspace/InfoVis_Yelp/jsons/user_profiles.json"),  
					        new TypeReference<Collection<UserProf>>() {});*/
				List<Business_Prof> biz_profs = mapper.readValue(new File("C:\\Users\\Smile\\Documents\\GitHub\\vtvisyelp\\InfoVis_Yelp\\VT_jsons\\VT_business_profiles.json"), 
						new TypeReference<List<Business_Prof>>(){});

				for(Business_Prof bp: biz_profs)
				{
					for(int a = 0; a < bp.getCategories().size(); a++)
					{
						if(!cats.contains((String) bp.getCategories().get(a)) && bp.getSchools().contains("Virginia Tech"))
						{
							cats.add((String) bp.getCategories().get(a));
							cnt++;
						}
					}			
				}
				for(String cater : cats)
				{
					System.out.println(cater);
				}
				System.out.println("there are " + cnt + " categories near VT (w/o repeats)");
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
