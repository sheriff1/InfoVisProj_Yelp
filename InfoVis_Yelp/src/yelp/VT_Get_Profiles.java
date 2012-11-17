package yelp;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class VT_Get_Profiles {

		public static void main(String[] args) 	
		{
			try
			{
				ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
				List<User_Prof> usr_profs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/jsons/user_profiles.json"), 
						new TypeReference<List<User_Prof>>(){});
				List<User_Review> usr_revs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/jsons/VT_user_reviews_ALL.json"), 
						new TypeReference<List<User_Review>>(){});
				PrintWriter out = new PrintWriter(new FileWriter("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/jsons/VT_user_profiles.json"));
				
				ArrayList<User_Prof> to_write = new ArrayList<User_Prof>();
				
				int cnt = 0;
				for(User_Prof up : usr_profs)
				{
					for(User_Review ur : usr_revs)
					{
						if(up.getUser_id().equals(ur.getUser_id()))
						{
							if(! to_write.contains(up) )
							{
								to_write.add(up);
								cnt++;
							}
						}
					}
				}
				System.out.println("should be 143...or less i guess...: " + cnt);
				
				for(User_Prof up : to_write)
				{
					out.append(mapper.writeValueAsString(up) + ",\n");
				}
				
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
