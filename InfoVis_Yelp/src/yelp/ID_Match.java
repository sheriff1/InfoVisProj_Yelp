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

//EDIT THIS AFTER VT JSONS HAVE BEEN EXTRACTED

public class ID_Match {

		public static void main(String[] args) 	
		{
			try
			{
				ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
				List<Business_Prof> biz_profs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/VT_jsons/VT_business_profiles.json"), 
						new TypeReference<List<Business_Prof>>(){});
				List<User_Prof> usr_profs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/VT_jsons/VT_user_profiles.json"), 
						new TypeReference<List<User_Prof>>(){});
				List<User_Review> usr_revs = mapper.readValue(new File("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/VT_jsons/VT_user_reviews.json"), 
						new TypeReference<List<User_Review>>(){});

				ArrayList<String> bizprofID = new ArrayList<String>(); 
				ArrayList<String> usrrevID = new ArrayList<String>();  
				ArrayList<String> usrrevUID = new ArrayList<String>(); 
				ArrayList<String> usrprofID = new ArrayList<String>();
				for(Business_Prof bp: biz_profs)
				{	
					bizprofID.add(bp.getBusiness_id());
				}
				for(User_Review ur: usr_revs)
				{	
					usrrevID.add(ur.getBusiness_id());
					usrrevUID.add(ur.getUser_id());
				}
				for(User_Prof up: usr_profs)
				{
					usrprofID.add(up.getUser_id());
				}
				//verifies business IDs match in business profiles and user reviews
				for(String usrstr : usrrevID)
				{
					if(!bizprofID.contains(usrstr))
					{
						System.out.println("UH-OH: " + usrstr);
					}
				}
				//verifies user IDs match in user profiles and user reviews
				for(String usrustr : usrrevUID)
				{
					if(!usrprofID.contains(usrustr))
					{
						System.out.println("UH-OH2: " + usrustr);
					}
				}
				System.out.println("Number of VT objects:");
				System.out.println("Business profiles: " +bizprofID.size());
				System.out.println("User profiles: " +usrprofID.size());
				System.out.println("User reviews: " +usrrevID.size());
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
