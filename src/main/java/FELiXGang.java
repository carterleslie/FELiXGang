/******************************************************************************
*  Author : cal17b Carter Leslie, wsl15a Wade Linder, and fab16b Felix Mbikogbia
*  Class  : Spring 2020 CS374.01 Dr. Reeves
*  Date   : 
*  Task   : 
*
*  This is a file for creating other files to use quickly in the future.
*
******************************************************************************/

import java.util.*;
import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class FELiXGang 
{
	private int classSize; //size of the entire "class" of students
	private int teamSize; //size of the teams, designated by user
	private int numTeams; //number of teams, calculated with the above two ints in the initializer
	private int verbose; //level of debug to output
	private int numSwaps; //number of swaps to attempt
	private int numSets; //number of best sets to create/attempt
	private int badSwapChance; //the chances of keeping a bad swap
	private int totalHappiness; //total happiness of the set
	private String savePeople; //
	//the next five matricies are parallel but individualHappinessMatrix and teamHappiness are calculated upon swaps 
	//while the other three must be manually changed when swapping to preserve parallelness
	private String[][] teamsMatrix; //holds the names of all the people, each r value represents a different team
	private int[][][] prefsMatrix; //holds the preferences of person teamsMatrix[r][c] in it's own [r][c] position
	private int[][] idMatrix; //holds the id of person teamsMatrix[r][c] in it's own [r][c] position
	private int[][] individualHappinessMatrix; //holds the happiness of person teamsMatrix[r][c] in it's own [r][c] position
	private int[] teamHappiness; //holds total team happiness of team teamsMatrix[r][0-teamSize] in it's own [r] position
	private int[] happinessIndex; //holds the array of happiness values
	private int[] unhappinessIndex; //holds the array of unhappyness values


    //initializer for a FELiXGang
    public FELiXGang(String allPeople, int tSize, int v, int n, int l, int r)
    {
    	savePeople = allPeople;
    	classSize = allPeople.split(" ").length;
    	teamSize = tSize;
    	verbose = v;
    	numSwaps = n;
    	numSets = l;
    	badSwapChance = r;

    	if(classSize % teamSize == 0)
    		numTeams = classSize / teamSize;
    	else
    		numTeams = classSize / teamSize + 1;
    	teamsMatrix = new String[teamSize][numTeams];
    	prefsMatrix = new int[teamSize][numTeams][6];
    	idMatrix = new int[teamSize][numTeams];
    	individualHappinessMatrix = new int[teamSize][numTeams];
    	teamHappiness = new int[numTeams];

    	happinessIndex = new int[] {7,5,3,1,1,1};
    	unhappinessIndex = new int[] {-1,-1,-1,-3,-5,-7};
    	
    	fillTeams(allPeople);
    	calcAllHappiness();
    	if(verbose >= 0)
    	{
    		System.out.println("----------Initial Team Setup----------");
    		printTeams();
    		System.out.println(" ");
    		makeBestTeams(this);
    	}
    }
    public FELiXGang(FELiXGang copy)
    {
    	savePeople = copy.savePeople;
    	classSize = copy.savePeople.split(" ").length;
    	teamSize = copy.teamSize;
    	verbose = copy.verbose;
    	numSwaps = copy.numSwaps;
    	numSets = copy.numSets;
    	badSwapChance = copy.badSwapChance;

    	if(classSize % teamSize == 0)
    		numTeams = classSize / teamSize;
    	else
    		numTeams = classSize / teamSize + 1;
    	teamsMatrix = new String[teamSize][numTeams];
    	prefsMatrix = new int[teamSize][numTeams][6];
    	idMatrix = new int[teamSize][numTeams];
    	individualHappinessMatrix = new int[teamSize][numTeams];
    	teamHappiness = new int[numTeams];

    	for(int r = 0; r < teamSize; r++)
    		for(int c = 0; c < numTeams; c++)
    			teamsMatrix[r][c] = copy.teamsMatrix[r][c];
    	for(int r = 0; r < teamSize; r++)
    		for(int c = 0; c < numTeams; c++)
    			prefsMatrix[r][c] = copy.prefsMatrix[r][c];
    	for(int r = 0; r < teamSize; r++)
    		for(int c = 0; c < numTeams; c++)
    			idMatrix[r][c] = copy.idMatrix[r][c];

    	happinessIndex = new int[] {7,5,3,1,1,1};
    	unhappinessIndex = new int[] {-1,-1,-1,-3,-5,-7};
    	
    	calcAllHappiness();
    }
    // ---------------------- getters -----------------------
    //gets teamSize
    public int getTeamSize()
    {
    	return teamSize;
    }
    //gets classSize
    public int getClassSize()
    {
    	return classSize;
    }
    //gets numTeams
    public int getNumTeams()
    {
    	return numTeams;
    }
    //gets verbose level
    public int getVerbose()
    {
    	return verbose;
    }
    //gets numSwaps
    public int getNumSwaps()
    {
    	return numSwaps;
    }
    //gets numSets
    public int getNumSets()
    {
    	return numSets;
    }
    //gets badSwapChance
    public int getBadSwapChance()
    {
    	return badSwapChance;
    }
    //gets totalHappiness
    public int getTotalHappiness()
    {
    	return totalHappiness;
    }
    // ---------------------- getFromMatrix/Array() -----------------------
	//gets the name at teamsMatrix at index [r][c]
    public String getTeamsMatrixIndex(int r, int c)
    {
    	return teamsMatrix[r][c];
    }
	//gets the preference of the person in prefsMatrix at index [r][c][index]
    public int getPrefsMatrixIndex(int r, int c, int index)
    {
    	return prefsMatrix[r][c][index];
    }
	//gets the id of the person in idMatrix at index [r][c]
    public int getIDMatrixIndex(int r, int c)
    {
    	return idMatrix[r][c];
    }
	//gets the individual happiness of the person in individualHappinessMatrix at index [r][c]
    public int getIndividualHappinessMatrixIndex(int r, int c)
    {
    	return individualHappinessMatrix[r][c];
    }
    //gets the team happiness of the team in teamHappiness at index [index]
    public int getTeamHappinessIndex(int index)
    {
    	return teamHappiness[index];
    }
    /*private void //log(int vLevel)
    {
    	StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    	String caller = stackTrace[2].getMethodName();
    	if(vLevel <= verbose && vLevel == 4) //verbose of 4 output
    		System.out.println("Made it into a deeper level of method: "+caller);
    	if(vLevel <= verbose && vLevel == 3) //verbose of 3 output
    		System.out.println("Reached deepest level of a nested part of method: "+caller);
    	if(vLevel <= verbose && vLevel == 2) //verbose of 2 output
    		System.out.println("Completed method: "+caller);
    	if(vLevel <= verbose && vLevel == 1) //verbose of 1 output
    		System.out.println("Called method: "+caller);
    }*/
    //fills up the teamsMatrix and prefsMatrix with whatever file you pass it
    //fills them in a way that only leaves the end index of a column open as null when there aren't
    //enough people in the class.
    //fills all of [0][0-numTeams], then [1][0-numTeams] such that only the far right of the bottom row is open at the end
    private void fillTeams(String peopleString)
    {
    	//log(1);
    	for (int c = 0; c < numTeams; c++)
		{
			//log(4);
			for(int r = 0; r < teamSize; r++)
			{
				//log(3);
				idMatrix[r][c] = 0;
			}
		}

    	String people[] = peopleString.split(" ");
      
        int r = 0, c = 0;
        int id = 1;
	    for(int i = 0; i < classSize; i++)
	    {
	    	//log(3);
	     	String nameAndPrefs[] = people[i].split(",",2);

	     	fillTeamsMatrixIndex(nameAndPrefs[0], r, c);
	     	if(people[i].indexOf(',') >= 0)
	     		fillPrefsMatrixIndex(nameAndPrefs[1], r, c);
	     	else
	     		fillPrefsMatrixIndex("0,0,0,0,0,0", r, c);
	     	idMatrix[r][c] = i+1;
	     	if(c < numTeams-1)
	     		c++;
	     	else
	     	{
	     		r++;
	     		c = 0;
	     	}
	     	id++;
	    }
	    //log(2);	
    }
	//adds name to teamsMatrix[r][c]
    private void fillTeamsMatrixIndex(String name, int r, int c)
    {
    	//log(1);
    	teamsMatrix[r][c] = name;
    	//log(2);
    }
    //adds prefs to prefsMatrix at index [r][c]
    private void fillPrefsMatrixIndex(String prefs, int r, int c)
    {
    	//log(1);
    	String[] values = prefs.split(",");
    	for(int i = 0; i < values.length; i++)
    	{
    		//log(3);
    		prefsMatrix[r][c][i] = Integer.parseInt(values[i]);
    	}
    	if(values.length < 6)
    	{
    		//log(4);
    		for(int i = values.length; i < 6; i++)
    		{
    			//log(3);
    			prefsMatrix[r][c][i] = 0;
    		}
    	}
    	//log(2);
    }
	//calculates the happiness for each individual and puts them in the 
	//individual happiness array
	private void calcIndividualHappiness()
	{
		//log(1);
		int happiness = 0;
		for (int c = 0; c < numTeams; c++)
		{
			//log(4);;
			for(int r = 0; r < teamSize; r++)
			{
				//log(4);
				happiness = 0;
				if(idMatrix[r][c] != 0)
				{
					//log(4);
					for(int r2 = 0; r2 < teamSize; r2++)
					{
						//log(4);
						if(r != r2)
						{
							//log(4);
							for(int i = 0; i < 6; i++)
							{
								//log(3);
								if(idMatrix[r2][c] == prefsMatrix[r][c][i])
								{
									//log(3);
									happiness += happinessIndex[i];
								}
								if(idMatrix[r2][c] == -1*prefsMatrix[r][c][i])
								{
									//log(3);
									happiness += unhappinessIndex[i];
								}
							}
						}
					}
				}
				individualHappinessMatrix[r][c] = happiness;
			}
		}
		//log(2);
	}
	//Gauges the happiness of each team.
	private void calcTeamHappiness()
	{
		//log(1);
		int happiness = 0;
		int localTeamSize = 0;
		for(int c = 0; c < numTeams; c++)
		{
			//log(4);
			happiness = 0;
			for( int r = 0; r < teamSize; r++)
			{
				//log(4);
				if(teamsMatrix[r][c] != "null")
				{
					//log(3);
					happiness += individualHappinessMatrix[r][c];
				}
			}
			teamHappiness[c] = happiness;
		}
		//log(2);
	}
	//calculates the total happiness of the set
	private void calcTotalHappiness()
	{
		//log(1);
		totalHappiness = 0;
		for(int c = 0; c < numTeams; c++)
		{
			//log(3);
			totalHappiness += teamHappiness[c];
		}
		//log(2);
	}
	//calls all calcXHappiness() functions in order to get the new happiness of the set
	private void calcAllHappiness()
	{
		//log(1);
		calcIndividualHappiness();
		calcTeamHappiness();
		calcTotalHappiness();
		//log(2);
	}
	//swaps the person in teamsMatrix[r1][c1] with the person in teamsMatrix[r2][c2]
	//also has to swap prefsMatrix and idMatrix at those same positions so they stay parallel
	public void swapPeople(int r1, int c1, int r2, int c2)
	{
		//log(1);
		String tempName = teamsMatrix[r1][c1];
		teamsMatrix[r1][c1] = teamsMatrix[r2][c2];
		teamsMatrix[r2][c2] = tempName;
		int[] tempArr = prefsMatrix[r1][c1];
		prefsMatrix[r1][c1] = prefsMatrix[r2][c2];
		prefsMatrix[r2][c2] = tempArr;
		int tempID = idMatrix[r1][c1];
		idMatrix[r1][c1] = idMatrix[r2][c2];
		idMatrix[r2][c2] = tempID;
		calcAllHappiness();
		//log(2);
	}
	public void makeBestTeams(FELiXGang orig)
	{
		//log(1);
		FELiXGang sets[];
		sets = new FELiXGang[numSets];
		FELiXGang currSet;
		for(int s = 0; s < numSets; s++)
		{
			//log(4);
			currSet = new FELiXGang(orig);
			for(int n = 0; n < numSwaps; n++)
			{
				//log(4);
				Random rand = new Random();
				FELiXGang attempt = new FELiXGang(currSet);
				int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
				while(c1 == c2)
				{
					//log(3);
					r1 = rand.nextInt(teamSize);
					r2 = rand.nextInt(teamSize);
					c1 = rand.nextInt(numTeams);
					c2 = rand.nextInt(numTeams);
				}
				attempt.swapPeople(r1,c1,r2,c2);
				if(attempt.getTotalHappiness() < currSet.getTotalHappiness())
				{
					//log(3);
					int r = rand.nextInt(100);
					if(r < badSwapChance)
						currSet = new FELiXGang(attempt);
				}
				else
				{
					//log(3);
					currSet = new FELiXGang(attempt);
				}
			}
			sets[s] = new FELiXGang(currSet);
		}
		for(int s = 0; s < numSets; s++)
		{
			//log(3);
			System.out.println("----------Team Setup "+ (s+1) +"----------");
			sets[s].printTeams();
			System.out.println(" ");
		}
		//log(2);
	}
	//Prints out teams and their happiness
	public void printTeams() 
	{
		//log(1);
		for (int c = 0; c < numTeams; c++) 
		{
			System.out.print("Team " + (c+1) + ": "); 
			for (int r = 0; r < teamSize; r++) 
			{
				if(r < teamSize-1)
				{
					System.out.print(teamsMatrix[r][c] + ", ");	
				}
				else
				{
					System.out.print(teamsMatrix[r][c]);
				}
			}
			System.out.println(". Happiness: " + teamHappiness[c]);
		}
		System.out.println("Total Happiness of this set: " + totalHappiness);
		//log(2);
	}
	public static void main( String[] args )
    {
    	int t = 2;
        int v = 0;
        int n = 10000;
        int l = 20;
        int r = 2;
    	if (args.length > 0) 
        { 
            for (int i = 0; i < args.length; i++) 
            {
            	if(args[i].equals("-t"))
            	{
            		i++;
            		t = Integer.parseInt(args[i]);
            	}
            	if(args[i].equals("-v"))
            	{
            		i++;
            		v = Integer.parseInt(args[i]);
            	}
            	if(args[i].equals("-n"))
            	{
            		i++;
            		n = Integer.parseInt(args[i]);
            	}
            	if(args[i].equals("-l"))
            	{
            		i++;
            		l = Integer.parseInt(args[i]);
            	}
            	if(args[i].equals("-r"))
            	{
            		i++;
            		r = Integer.parseInt(args[i]);
            	}
            }
        } 
  		Scanner scanner = new Scanner(System.in);
    	String str = "";
		while(scanner.hasNext())
		{
			str = str + scanner.next() + " ";
		}
		FELiXGang test = new FELiXGang(str,t,v,n,l,r);
    }
}
