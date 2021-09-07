/*
 * Joseph Hutchens
 * Golf Skin Calculator
 * Beta
 */

import java.util.Arrays;


public class golfround {
	private static int size = golfroundclient2.holes;
	private int[] holes;
	//Yardage for Lyon Oaks: Black-6,837, Blue-6,427, White-6,133, Gold-5,389, Green-4,525
	private static int yardage = 0;
	private static int [] yardagePerhole = {371,322,333,398,501,116,356,129,530,379,410,391,110,321,328,531,130,477};
	private static int [] course_par = {4,4,4,4,5,3,4,3,5,4,4,4,3,4,4,5,3,5};
	private int [] score;
	private static int [] arrayscores;
	private static int [] front9pre;
	private static int [] back9pre;
	private int [] pars;
	private int [] birdies;
	private int [] eagles;
	private String name = "";
	private int front9total=0,back9total=0,par3s,par3amount,par4amount,par5amount;
	
	
	//Default Constructor
	public golfround() {
		// TODO Auto-generated constructor stub
		//Variables
		holes = new int [size];
		pars = new int [size];
		birdies = new int [size];
		eagles = new int [size];
		score = new int [size];
		//For How Many Players
		arrayscores = new int [size];
		front9pre = new int [size];
		back9pre = new int [size];
		front9total= 0;
		back9total = 0;
		name = "Blank";
		
		par3s = 0;
	}
	//Overload Constructor
	public golfround(String newname, int [] newscore, int newpar3s) {
		//Variables
		name = newname;
		holes = new int [newscore.length];
		pars = new int [newscore.length];
		birdies = new int [newscore.length];
		eagles = new int [newscore.length];
		score = new int [newscore.length];

		//Check if Any Player Won a Closest Pin
		if(newpar3s>0)
		{
			par3s = newpar3s;
		}
		//Input Values for Each Object
		for(int i = 1; i < (holes.length + 1); i++)
		{
			holes[i-1] = i;
		}

		for(int i = 0; i < (score.length); i++)
		{
			score[i] = newscore[i];
		}

	}
	
	//The Accessors
	public int [] getholes()
	{
		return holes;
	}
	public static int [] getpar()
	{
		return course_par;
	}
	public static int [] getfront9()
	{
		return front9pre;
	}
	public static int [] getback9()
	{
		return back9pre;
	}
	public int [] par()
	{
		return pars;
	}
	public int [] birdies()
	{
		return birdies;
	}
	public int [] eagle()
	{
		return eagles;
	}
	public int [] getascore()
	{
		return score;
	}
	public static int [] getyardage()
	{
		return yardagePerhole;
	}
	public String getpars()
	{
		String format = "";
		for(int i = 0; i < size; i++)
		{
			if(i>=9)
			{
				format+=pars[i] + "  ";
			}
			else
			{
				format+=pars[i] + " ";
			}
			
		}
		return format;
	}
	public String getbirdies()
	{
		String format = "";
		for(int i = 0; i < size; i++)
		{
			if(i>=9)
			{
				format+=birdies[i] + "  ";
			}
			else
			{
				format+=birdies[i] + " ";
			}
			
		}
		return format;
	}
	public String geteagles()
	{
		String format = "";
		for(int i = 0; i < size; i++)
		{
			if(i>=9)
			{
				format+=eagles[i] + "  ";
			}
			else
			{
				format+=eagles[i] + " ";
			}
			
		}
		return format;
	}
	public int playerpar3amount()
	{
		return par3s;
	}
	public String getscore()
	{
		String format = "";
		for(int i = 0; i < size; i++)
		{
				format+=score[i] + "    ";

			
		}
		return format;
	}
	public String getname()
	{
		return name;
	}
	
	//The Mutators
	//Stat for Par 3's
	public int totalpar3s()
	{
		for(int x=0;x<(course_par.length);x++)
		{
			if(course_par[x]==3)
			{
			par3amount+=1;	
			}
		}
		return par3amount;
	}
	//Stat for Par 4's
	public int totalpar4s()
	{
		for(int x=0;x<(course_par.length);x++)
		{
			if(course_par[x]==4)
			{
			par4amount+=1;	
			}
		}
		return par4amount;
	}
	//Stat for Par 5's
	public int totalpar5s()
	{
		for(int x=0;x<(course_par.length);x++)
		{
			if(course_par[x]==5)
			{
			par5amount+=1;	
			}
		}
		return par5amount;
	}
	//Counts How Many Par's Each Player Has
	public int totalpars()
	{
		int total = 0;
		for(int i = 0; i < (holes.length); i++)
		{
			if(score[i]-course_par[i]==0) {
				total+=1;
				//Array Stores Where
				pars[i] = -2;
			}
		}
		return total;
	}
	//Counts How Many Birdie's Each Player Has;Needs an Array to Store Where in Reference
	//To Each Hole For Comparing
	public int totalbirdies()
	{
		int total = 0;
		for(int i = 0; i < (holes.length); i++)
		{
			if(score[i]-course_par[i]==-1) {
				total+=1;
				//Array Stores Where
				birdies[i] = -2;
			}
		}
		return total;
	}
	//Counts How Many Eagle's Each Player Has
	public int totaleagles()
	{
		int total = 0;
		for(int i = 0; i < (holes.length); i++)
		{
			if(score[i]-course_par[i]==-2 && course_par[i]==5) {
				total+=1;
				//Array Stores Where
				eagles[i] = -2;
			}
		}
		return total;
	}
	//Counts The Total Score For Each Player
	public int totalscore()
	{
		int total = 0;
		for(int i = 0; i < (size); i++)
		{
				total+=score[i];
		}

		return total;
	}
	//Counts The Yardage for the Golf Course
	private static int totalyardage()
	{
		for(int i = 0; i< size;i++)
		{
			yardage+= yardagePerhole[i];
		}
	 return yardage;
	}
	public int front9()
	{
		int front9total = 0;

		if(score.length>=8)
		{
			for(int x =0; x< score.length;x++)
			{
				if(x<=8)
				{
				front9total +=score[x];
				}
				
				
			}
		}
		else
		{
			System.out.println("Error with score size. Must be atleast 9 holes to compute front 9 score.");
		}
		return front9total;
	}
	public int back9()
	{

		int back9total = 0;
		if(score.length>8)
		{
			for(int x =0; x< score.length;x++)
			{
				if(x<=8)
				{

				}
				else
				{
					back9total +=score[x];
				}
				
			}
		}
		return back9total;
	}
	//Comparing Score

	public static void totalofscores(int num1,int index)
	{
		int newnum1 = num1;
		int newindex = index;
		
		arrayscores[newindex]= newnum1;

		
		//Sort The Array
		Arrays.sort(arrayscores);
	}
	//Comparing Score
		//Front 9
		public static void totaloffront9(int value,int index)
		{
			
			front9pre[index]= value;
			//Sort The Array
			Arrays.sort(front9pre);

		}
		//Back 9
		public static void totalofback9(int num1,int index)
		{
			
			back9pre[index]=num1;
			
			//Sort The Array
			Arrays.sort(back9pre);

		}
		//Set Score
		public void setscore(int index,int value)
		{
			score[index]= value;
		}
	//Header Display
	public static String header1()
	{		
		/*Top Banner*/
		String format = "Lyon Oaks Golf Course\nFather's Day Outing\nDate: June 20th, 2021\n";
		/*Yardage and Par*/
		format+= "Yardage: " + totalyardage();
		/*Hole Number*/
		format+= "\n\t\t\t   Hole: ";
		for(int i = 1; i <= size;i++)
		{
			if(i>=9)
			{
			format+=i + "   ";
			}
			else
			{
				format+=i + "    ";
			}
		}
		format+= "\n";
		/*Par for Each Hole*/
		format+= "\t\t\t    Par: ";
		for(int i = 0; i < size; i++)
		{

				format+=course_par[i] + "    ";
			
			
		}
		format+="\n\t\t\t Yards: ";
		for(int v = 0; v < size; v++)
		{
			if(v>=9)
			{
				format+=yardagePerhole[v] + "  ";
			}
			else
			{
				format+=yardagePerhole[v] + "  ";
			}
			
		}
		
			//format+= "\n";
				return format;
	
	}

	}

