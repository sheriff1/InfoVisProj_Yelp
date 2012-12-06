package yelp;

public class ScoreObj 
{
  	private int S1;
   	private int  s2;
   	private int  s3;
   	private int  s4;
   	private int  s5;
   	private int  s6;
   	private int s7;
   	private int  s8;
   	private int  s9;
   	private String name;
   	private String category;

   	public ScoreObj()
   	{
   		S1=-1;
   		s2=-1;
   		s3=-1;
   		s4=-1;
   		s5=-1;
   		s6=-1;
   		s7=-1;
   		s8=-1;
   		s9=-1;
   	}
   	
 	public int getS1(){
		return this.S1;
	}
	public void setS1(int s1){
		this.S1 = s1;
	}
 	public int getS2(){
		return this.s2;
	}
	public void setS2(int s2){
		this.s2 = s2;
	}
 	public int getS3(){
		return this.s3;
	}
	public void setS3(int s3){
		this.s3 = s3;
	}
 	public int getS4(){
		return this.s4;
	}
	public void setS4(int s4){
		this.s4 = s4;
	}
 	public int getS5(){
		return this.s5;
	}
	public void setS5(int s5){
		this.s5 = s5;
	}
 	public int getS6(){
		return this.s6;
	}
	public void setS6(int s6){
		this.s6 = s6;
	}
 	public int getS7(){
		return this.s7;
	}
	public void setS7(int s7){
		this.s7 = s7;
	}
 	public int getS8(){
		return this.s8;
	}
	public void setS8(int s8){
		this.s8 = s8;
	}
 	public int getS9(){
		return this.s9;
	}
	public void setS9(int s9){
		this.s9 = s9;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public int[] scoresArray()
	{
		int[] ret = {S1,s2,s3,s4,s5,s6,s7,s8,s9};
		return ret;
	}
	public int getScores(int x)
	{
		if(x==0) 
			return S1;
		else if(x==1) 
			return s2;
		else if(x==2) 
			return s3;
		else if(x==3) 
			return s4;
		else if(x==4) 
			return s5;
		else if(x==5) 
			return s6;
		else if(x==6) 
			return s7;
		else if (x==7)
			return s8;
		else
			return s9;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
