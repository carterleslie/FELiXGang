/******************************************************************************
*  Author : cal17b Carter Leslie, wsl15a Wade Linder, and fab16b Felix Mbikogbia
*  Class  : Spring 2020 CS374.01 Dr. Reeves
*  Date   : 
*  Task   : 
*
*  This is a file for creating other files to use quickly in the future.
*
******************************************************************************/

import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;  
import java.io.IOException; 
 

public class FELiXGang 
{
	private int classSize; //size of the entire "class" of students
	private int teamSize; //size of the teams, designated by user
	private int numTeams; //number of teams, calculated with the above two ints in the initializer
	private String[][] teamsMatrix; //the matrix of all names of the team members in respective teams
	private int[][][] prefsMatrix; //the matrix of all prefs of the team members, parallel to teamsMatrix
	private int[][] individualHappinessMatrix;
	private int[] teamHappiness;
	private int[][] idMatrix;
	private int[] happinessIndex;

    //initializer for a FELiXGang
    public FELiXGang(String fileToInput, int cSize, int tSize)
    {
    	classSize = cSize;
    	teamSize = tSize;

    	if(classSize % teamSize == 0)
    		numTeams = classSize / teamSize;
    	else
    		numTeams = classSize / teamSize + 1;
    	teamsMatrix = new String[teamSize][numTeams];
    	prefsMatrix = new int[teamSize][numTeams][6];
    	individualHappinessMatrix = new int[teamSize][numTeams];
    	teamHappiness = new int[numTeams];
    	idMatrix = new int[teamSize][numTeams];

    	happinessIndex = new int[] {6,3,1,-1,-3,-6};
    	fillTeams(fileToInput);
    	calcHappiness();
    	prefsPerTeam();
    }
    //gets the teamSize
    public int getTeamSize()
    {
    	return teamSize;
    }
    //gets the classSize
    public int getClassSize()
    {
    	return classSize;
    }
    //gets the numTeams
    public int getNumTeams()
    {
    	return numTeams;
    }
    //fills up the teamsMatrix and prefsMatrix with whatever file you pass it
    //fills them in a way that only leaves the end index of a column open as null when there aren't
    //enough people in the class.
    //fills all of [0][0-numTeams], then [1][0-numTeams] such that only the far right of the bottom row is open at the end
    private void fillTeams(String fileName)
    {
    	for (int c = 0; c < numTeams; c++)
		{
			for(int r = 0; r < teamSize; r++)
			{
				idMatrix[r][c] = 0;
			}
		}

    	File file = new File(fileName);
    
    	try 
    	{
        	Scanner sc = new Scanner(file);
        	int r = 0, c = 0;
        	int id = 1;
	    	while (sc.hasNextLine()) 
	     	{
	     		String nextLine = sc.nextLine();
	     		String nameAndPrefs[] = nextLine.split(",",2);

	     		fillTeamsMatrixIndex(nameAndPrefs[0], r, c);
	     		if(nextLine.indexOf(',') >= 0)
	     			fillPrefsMatrixIndex(nameAndPrefs[1], r, c);
	     		else
	     			fillPrefsMatrixIndex("0,0,0,0,0,0", r, c);
	     		idMatrix[r][c] = id;
	     		if(c < numTeams-1)
	     			c++;
	     		else
	     		{
	     			r++;
	     			c = 0;
	     		}
	     		id++;
	     	}
	     	sc.close();
    	} 
    	catch (FileNotFoundException e) 
    	{
        	e.printStackTrace();
    	}
    }

	//adds name to teamsMatrix[r][c]
    public void fillTeamsMatrixIndex(String name, int r, int c)
    {
    	teamsMatrix[r][c] = name;
    }
    //adds prefs to prefsMatrix at index [r][c]
    public void fillPrefsMatrixIndex(String prefs, int r, int c)
    {
    	String[] values = prefs.split(",");
    	for(int i = 0; i < values.length; i++)
    		prefsMatrix[r][c][i] = Integer.parseInt(values[i]);
    	if(values.length < 6)
    		for(int i = values.length; i < 6; i++)
    			prefsMatrix[r][c][i] = 0;
    }
    // ---------------------- getFromMatrix() -----------------------
	//gets the name at teamsMatrix at index [r][c]
    public String getTeamsMatrixIndex(int r, int c)
    {
    	return teamsMatrix[r][c];
    }
	
	//gets the prefs at prefsMatrix at index [r][c][index]
    public int getPrefsMatrixIndex(int r, int c, int index)
    {
    	return prefsMatrix[r][c][index];
    }
    //
    public int getIndividualHappinessMatrixIndex(int r, int c)
    {
    	return individualHappinessMatrix[r][c];
    }
    //
    public int getTeamHappinessIndex(int index)
    {
    	return teamHappiness[index];
    }
    //
    public int getIDMatrixIndex(int r, int c)
    {
    	return idMatrix[r][c];
    }
	//calculates the happiness for eahc individual and puts them in the 
	//individual happiness array
	public void calcHappiness()
	{
		int happiness = 10;
		for (int c = 0; c < numTeams; c++)
		{
			for(int r = 0; r < teamSize; r++)
			{
				happiness = 10;
				if(idMatrix[r][c] != 0)
				{
					for(int r2 = 0; r2 < teamSize; r2++)
					{
						if(r != r2)
						{
							for(int i = 0; i < 6; i++)
							{
								if(idMatrix[r2][c] == prefsMatrix[r][c][i])
									happiness += happinessIndex[i];
							}
						}
					}
				}
				individualHappinessMatrix[r][c] = happiness;
			}
		}
	}
	//Gauges the happiness of each team.
	public void prefsPerTeam()
	{
		int happiness = 0;
		int localTeamSize = 0;
		for(int c = 0; c < numTeams; c++)
		{
			happiness = 0;
			localTeamSize = teamSize;
			//System.out.println("Team " + (c+1) + "Average Happiness: ");
			for( int r = 0; r < teamSize; r++)
			{
				if(teamsMatrix[r][c] != "null")
				{
					happiness += individualHappinessMatrix[r][c];
				}
				else
				{
					localTeamSize--;
				}
			}
			teamHappiness[c] = (happiness/localTeamSize);
			//System.out.print(teamHappiness[c]);
		}
	}
	//Prints out created teams.
	public void printTeams() 
	{
		for (int c = 0; c < numTeams; c++) 
		{
			System.out.print("Team " + (c+1) + ": "); 
			for (int r = 0; r < teamSize; r++) 
			{
				if(r < teamSize-1)
					System.out.print(teamsMatrix[r][c] + ", ");	
				else
					System.out.print(teamsMatrix[r][c]);
			}
			System.out.println(" " + getTeamHappinessIndex(c));
			System.out.println("");
		}
	}
	public static void main( String[] args )
    {
        System.out.println( "Hello, this is the FELiXGang Happy teams file, please enter inputs to being!" );
        Scanner in = new Scanner(System.in);
        System.out.print("File to read from: ");
        String inputFile = in.nextLine();
        System.out.print("Team size: ");
        int userTeamSize = in.nextInt();
        System.out.print("Verbose: ");
        int verbose = in.nextInt();
        System.out.print("Number of swaps to attempt: ");
        int numAttempts = in.nextInt();
        System.out.print("Number of times to perform the number of swaps: ");
        int numPerformSwaps = in.nextInt();
        System.out.print("Percent of suboptimal swaps: ");
        int suboptimalPercent = in.nextInt();
        System.out.print("");
        FELiXGang t = new FELiXGang(inputFile, 4,userTeamSize);
        t.printTeams();
    }
}
