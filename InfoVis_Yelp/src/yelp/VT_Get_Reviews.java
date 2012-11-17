package yelp;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class VT_Get_Reviews {

		public static void main(String[] args) 	
		{
			try
			{
				ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
				List<Business_Prof> biz_profs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/jsons/VT_business_profiles.json"), 
						new TypeReference<List<Business_Prof>>(){});
				List<User_Review> usr_revs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/jsons/ur4.json"), 
						new TypeReference<List<User_Review>>(){});
				PrintWriter out = new PrintWriter(new FileWriter("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/jsons/VT_user_reviews4.json"));
				
				
				int cnt = 0;
				for(User_Review ur : usr_revs)
				{
					for(Business_Prof bp : biz_profs)
					{
						if(bp.getBusiness_id().equals(ur.getBusiness_id()))
						{
							out.append(mapper.writeValueAsString(ur) + ",\n");
							cnt++;
						}
					}
				}
				System.out.println("should be 143...or less i guess...: " + cnt);
				
				out.close();
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
