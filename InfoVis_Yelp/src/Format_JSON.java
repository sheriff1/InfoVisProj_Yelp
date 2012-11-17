import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Format_JSON {

	public static void main (String[] args)
	{
		try 
		{
			
		    String crap = "";
			BufferedReader dammit = new BufferedReader(new FileReader("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/jsons/VT_business_profiles.json"));
			PrintWriter out = new PrintWriter(new FileWriter("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/InfoVis_Yelp/jsons/VT_business_profiles_comma.json")); 
			out.print("[");
			while(dammit.ready())
			{
				crap = dammit.readLine() + ",";
				out.println(crap);
			}
			out.print("]");
			out.flush();
			out.close();
			dammit.close();
		
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}
