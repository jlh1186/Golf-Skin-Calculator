import java.util.ArrayList;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import java.util.InputMismatchException;
import java.util.Scanner;

public class golfroundclient2 {
		
		public static int holes;
		public static int group;
		//Array of Scores [# of Holes]
		public static int[] score;


		//Display
		private static void display()
		{
			System.out.println("******Hello, Welcome to Golf Round Skin Calculator V1.0******");
			System.out.println("*************************************************************");
			System.out.println("*************************************************************");
			System.out.println("***********************Produced by Joe***********************");
		}
		//Instructions
		private static void instructions()
		{
			System.out.println("");
			System.out.println("*********Instructions***********");
			System.out.println("********************************");
			System.out.println("");
			System.out.println("To Quit Type Q, In Selection Area At Anytime");
			System.out.println("****************************");
			System.out.println("Press A to Start Caclulator");
			System.out.println("Press B to View Players");
			System.out.println("Press C to View Score");
			System.out.println("Press D to Edit Score");
			System.out.println("Press GO to Compare Score");
			System.out.println("Press Q to Exit");
			System.out.print("Select Option: ");
		}
		//Method 4 : Using HashMap
		private static void findDuplicatesUsingHashMap(int[] inputArray)
		{
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int element : inputArray) 
		{   
		if(map.get(element) == null)
		{
		map.put(element, 1);
		}
		else
		{
		map.put(element, map.get(element)+1);
		}
		}
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) 
		{               
		if(entry.getValue() > 1)
		{
		System.out.println("Duplicate Score: "+entry.getKey()+" - Found "+entry.getValue()+" Times.");
		}
		}
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//How Many Holes Played
		int num1,num2,newscore;
		boolean quit = true;
		//Name of Each Player
		String name;
		//Create Scanner To Read Information
		Scanner input = new Scanner(System.in);
		//Create Array List for Players Name, Score and how many par 3's they had closest to the pin (Depending on how many holes they played)
		ArrayList<golfround> playersArr = new ArrayList<golfround>();
		//Into Display
		display();

		//Collect Info
		while(quit!=false)
		{
			//Instructions
			instructions();
			String choice = input.next();
			if(choice.equals("Q"))
			{
				System.out.println("Good Bye");
				quit = false;				
			}
			else
			{
				switch(choice)
				{
				//Enter Score
				case("A"):
				{
					System.out.println("Enter How Many Players: ");
					try
					{
					group = input.nextInt();
					if(group>0)
					{
						System.out.print("How Many Holes Played? 18 or 9: ");
						holes = input.nextInt();
						switch(holes)
						{
						case(9):
						{
							holes = 9;
							break;
						}
						case(18):
						{
							holes = 18;
							break;
						}
						default:
						{
							System.out.print("Enter 18 or 9: ");
							holes = input.nextInt();
						}

						}	
						score = new int [holes];
						for(int x = 0; x<group;x++)
						{
						System.out.print("Player "+x+1+ " Enter Player's Name: ");
						name = input.next();
						System.out.print("Enter "+name+"'s ");
						for(int y = 0; y<holes;y++)
						{
							System.out.print("Score for Hole "+(y+1)+" :");
							num1 = input.nextInt();
							score[y]=num1;

						}
						playersArr.add(new golfround(name,score,0));
						}
						//1st Loop: for(int x=0; x<#of_players(group);x++)
						//2d Loop: for(int y=0; y<#of_holes(holes);x++)
						//playersArr.add(new golfround(name,score,0));
					}
					else
					{
						input.close();
						System.out.println("Good Bye");
					}

					
					
				}
					catch(InputMismatchException ex)
					{
						System.out.println("You entered a Letter instead of Number. Try again.");
						
						
					}
					break;
					}
				//View Players
				case("B"):
				{
					//Print Names
					if(group<=0)
					{
						System.out.println("You Must Add Players First.");
						break;
					}
					else
					{
						System.out.println("*******");
						System.out.println("Players");
						System.out.println("-------");
						for(int x=0;x<group;x++)
						{
						System.out.println(playersArr.get(x).getname());
						}
						break;
					}
				}
				//View Scores
				case("C"):
				{
					//Print Scores and Names
					if(group<=0)
					{
						System.out.println("You Must Add Players First.");
						break;
					}
					else
					{
						System.out.println("Score For Each Hole");
						System.out.print("\t\t\t  Hole#:");
						for(int y = 1; y<holes+1;y++)
						{
							System.out.print(" "+y+ "    ");
						}
						System.out.println("");
						System.out.print("\t\t\t    Par:");
						for(int z = 0; z<holes;z++)
						{
							System.out.print(" "+golfround.getpar()[z]+ "    ");
						}
						System.out.println("");
						System.out.print("\t\t\tYardage:");
						for(int z = 0; z<holes;z++)
						{
							System.out.print(golfround.getyardage()[z]+ "  ");
						}
						System.out.println("");
						for(int x=0;x<group;x++)
						{
							System.out.println("Player: "+playersArr.get(x).getname()+"\t******* \t "+playersArr.get(x).getscore());

						}
					}
					break;
				}
				//Edit Scores
				case("D"):
				{
					//Print Names
					if(group<=0)
					{
						System.out.println("You Must Add Players First.");
						break;
					}
					else
					{
						//Display Players Name
						for(int x=0;x<group;x++)
						{
						System.out.println("Player#: "+x+"\t"+playersArr.get(x).getname());
						}
						System.out.print("Enter Players Number: ");
						try
						{
						num1 = input.nextInt();
						if(num1<group)
						{
							System.out.println("Edit "+playersArr.get(num1).getname()+" Score");
							System.out.print("Enter Hole To Edit: ");
							num2 = input.nextInt();
							System.out.print(playersArr.get(num1).getname()+"'s "+ "Score for Hole#: "+num2);
							newscore = input.nextInt();
							playersArr.get(num1).setscore(num2-1,newscore);

						}
						}
						catch(InputMismatchException ex)
						{
							System.out.println("You entered a Letter instead of Number. Try again.");
							
							
						}
						}
					break;
					}

				
				//Compare Data
				case("GO"):
				{
					//Print Names
					if(group<=0)
					{
						System.out.println("You Must Add Players First.");
						break;
					}
					else
					{
						//Produce Everybody Score
						System.out.println(golfround.header1());
						for(int x=0;x<group;x++)
						{
						System.out.println("Player# "+x+" "+playersArr.get(x).getname()+":"+"\t******* \t "+playersArr.get(x).getscore()+"   "+playersArr.get(x).totalscore());
						}
						//Prints Scores From Lowest - Highest
						//Sort Array List By Score

					   }

						//Finds Who Had The Lowest Front 9
						System.out.println(playersArr.get(0).front9());
						for(int c = 1; c<group+1;c++)
						{
							golfround.totaloffront9(36,c);
						}
						System.out.println("********************");
						System.out.println("Front 9 Lowest to Highest");
						for(int c = 0; c<group;c++)
						{
							for(int b = 0+c; b<group;b++)
							{
								if(golfround.getfront9()[c]==playersArr.get(b).front9())
								{
									System.out.println("Score "+golfround.getfront9()[c]);
									System.out.println(playersArr.get(b).getname());
									
								}
							}
						}
						//Finds Who Had The Lowest Back 9
						for(int c = 0; c<group;c++)
						{
							golfround.totalofback9(playersArr.get(c).back9(),c);
						}
						System.out.println("********************");
						System.out.println("Back 9 Lowest to Highest");
						for(int c = 0; c<group;c++)
						{
							for(int b = 0+c; b<group;b++)
							{
								if(golfround.getback9()[c]==playersArr.get(b).back9())
								{
									System.out.println("Score "+golfround.getback9()[c]);
									System.out.println(playersArr.get(b).getname());
									
								}
							}
						}
						//Finds Skins on Each Hole
						
						//Finds Greenie On Par3's
					}
					break;
				}
				}
			}
			input.close();
			}
		
		
		
					

					
		//1st Loop: for(int x=0; x<#of_players(group);x++)
		//2d Loop: for(int y=0; y<#of_holes(holes);x++)
		//playersArr.add(new golfround(name,score,0));
		//playersArr.add(new golfround("Ron",score,0));
		//Loop x will loop through players and y will loop through the round
		//System.out.println(playersArr.get(0).getscore());
		//System.out.println("Good Bye.");
		//System.out.close();
		//Find Dublicates
		//findDuplicatesUsingHashMap();

	}
