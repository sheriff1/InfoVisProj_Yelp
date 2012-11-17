package yelp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class Algorithms 
{
	//Algo1 - weights user review
	public static void Algo1(List<Business_Prof> biz_profs,List<User_Prof> usr_profs,
			List<User_Review> usr_revs)
	{
		double totalV_CRR=0;
		double totalV_URR=0;
		double totalV_FRR=0;
		double totalV_CUR=0;
		double totalV_UUR=0;
		double totalV_FUR=0;
		try 
		{
			BufferedWriter out = new BufferedWriter(new FileWriter("/Users/sheriff/Documents/VT/FA12/CS5764-InfoVis/project/vtvisyelp/list_of_scores.txt"));
			int cnt = 0;
		
		double CRR = 0, URR = 0, FRR = 0, CUR = 0, UUR = 0, FUR = 0;
		for(int i=0; i<biz_profs.size(); i++)
		{
			cnt++;
		for(int a=0; a<usr_revs.size(); a++)
		{
			String user_BID = usr_revs.get(a).getBusiness_id();
			String user_UID = usr_revs.get(a).getUser_id();
			if(biz_profs.get(i).getBusiness_id().equals(user_BID))
			{
				int numVotes_CRR = usr_revs.get(a).getVotes().getCool().intValue(); 
				totalV_CRR += numVotes_CRR;
				int numVotes_URR = usr_revs.get(a).getVotes().getUseful().intValue(); 
				totalV_URR += numVotes_URR;
				int numVotes_FRR = usr_revs.get(a).getVotes().getFunny().intValue(); 
				totalV_FRR += numVotes_FRR;
				CRR += (numVotes_CRR * usr_revs.get(a).getStars().doubleValue());
				URR += (numVotes_URR * usr_revs.get(a).getStars().doubleValue());
				FRR += (numVotes_FRR * usr_revs.get(a).getStars().doubleValue());
				
				
				for (int b=0; b<usr_profs.size();b++)
				{
					if(user_UID.equals(usr_profs.get(b).getUser_id()))
					{
						int numVotes_CUR = usr_profs.get(b).getVotes().getCool().intValue(); 
						totalV_CUR += numVotes_CUR;
						int numVotes_UUR = usr_profs.get(b).getVotes().getUseful().intValue(); 
						totalV_UUR += numVotes_UUR;
						int numVotes_FUR = usr_profs.get(b).getVotes().getFunny().intValue(); 
						totalV_FUR += numVotes_FUR;
						CUR += (numVotes_CUR * usr_revs.get(a).getStars().doubleValue());
						UUR += (numVotes_UUR * usr_revs.get(a).getStars().doubleValue());
						FUR += (numVotes_FUR * usr_revs.get(a).getStars().doubleValue());
					}
				}
			}
		}
		totalV_CRR = (totalV_CRR == 0) ? 1 : totalV_CRR;
		totalV_URR = (totalV_URR == 0) ? 1 : totalV_URR;
		totalV_FRR = (totalV_FRR == 0) ? 1 : totalV_FRR;
		totalV_CUR = (totalV_CUR == 0) ? 1 : totalV_CUR;
		totalV_UUR = (totalV_UUR == 0) ? 1 : totalV_UUR;
		totalV_FUR = (totalV_FUR == 0) ? 1 : totalV_FUR;
		out.write(biz_profs.get(i).getName().toUpperCase() + "\n");
		/*System.out.println("Cool Review Rating:\t" + CRR + "/" + totalV_CRR + " = " + (CRR/totalV_CRR));
		System.out.println("Useful Review Rating:\t" + URR + "/" + totalV_URR + " = " +  (URR/totalV_URR));
		System.out.println("Funny Review Rating:\t" + FRR + "/" + totalV_FRR + " = " + (FRR/totalV_FRR));
		System.out.println("Cool User Rating:\t" + CUR + "/" + totalV_CUR + " = " + (CUR/totalV_CUR));
		System.out.println("Useful User Rating:\t" + UUR + "/" + totalV_UUR + " = " +  (UUR/totalV_UUR));
		System.out.println("Funny User Rating:\t" + FUR + "/" + totalV_FUR + " = " +  (FUR/totalV_FUR));*/
		DecimalFormat f = new DecimalFormat("##.00");  
		out.write("Overall Rating:\t" + (int)(biz_profs.get(i).getStars().doubleValue()*20) +  " (" +(biz_profs.get(i).getStars().doubleValue())+ ")\n");
		out.write("Cool Review Rating:\t\t" + f.format((20*(CRR/totalV_CRR))) + " (" +(CRR/totalV_CRR)+ ")\n");
		out.write("Useful Review Rating:\t" + f.format((20*(URR/totalV_URR))) + " (" +(URR/totalV_URR)+ ")\n");
		out.write("Funny Review Rating:\t" + f.format((20*(FRR/totalV_FRR))) + " (" +(FRR/totalV_FRR)+ ")\n");
		out.write("Cool User Rating:\t\t" + f.format((20*(CUR/totalV_CUR))) + " (" +(CUR/totalV_CUR)+ ")\n");
		out.write("Useful User Rating:\t\t" +  f.format((20*(UUR/totalV_UUR))) + " (" +(UUR/totalV_UUR)+ ")\n");
		out.write("Funny User Rating:\t\t"  +  f.format((20*(FUR/totalV_FUR))) + " (" +(FUR/totalV_FUR)+ ")\n");
		out.write("--------------------------------------------------\n");
		}	
	System.out.println("Count: " + cnt);
	out.close();
		}
	catch (IOException e) 
	{
		e.printStackTrace();
	}
}
}
