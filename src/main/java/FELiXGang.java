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

public class FELiXGang 
{
	private int classSize; //size of the entire "class" of students
	private int teamSize; //size of the teams, designated by user
	private int numTeams; //number of teams, calculated with the above two ints in the initializer
	private String[][] teamsMatrix; //the matrix of all names of the team members in respective teams
	private String[][] prefsMatrix; //the matrix of all prefs of the team members, parallel to teamsMatrix

    //initializer for a FELiXGang
    public FELiXGang(int cSize, int tSize)
    {
    	classSize = cSize;
    	teamSize = tSize;

    	if(classSize % teamSize == 0)
    		numTeams = classSize / teamSize;
    	else
    		numTeams = classSize / teamSize + 1;
    	teamsMatrix = new String[teamSize][numTeams];
    	prefsMatrix = new String[teamSize][numTeams];
    	fillTeams("sampleTeam.txt");
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
    	File file = new File(fileName);
    
    	try 
    	{
        	Scanner sc = new Scanner(file);
        	int r = 0, c = 0;

	    	while (sc.hasNextLine()) 
	     	{
	     		String nextLine = sc.nextLine();
	     		String nameAndPrefs[] = nextLine.split(",",2);

	     		fillTeamsMatrixIndex(nameAndPrefs[0], r, c);
	     		if(nextLine.indexOf(',') >= 0)
	     			fillPrefsMatrixIndex(nameAndPrefs[1], r, c);
	     		else
	     			fillPrefsMatrixIndex("0,0,0,0,0,0", r, c);
	     		if(c < numTeams-1)
	     			c++;
	     		else
	     		{
	     			r++;
	     			c = 0;
	     		}
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
	//gets the name at teamsMatrix at index [r][c]
    public String getTeamsMatrixIndex(int r, int c)
    {
    	return teamsMatrix[r][c];
    }
	//adds prefs to prefsMatrix at index [r][c]
    public void fillPrefsMatrixIndex(String prefs, int r, int c)
    {
    	prefsMatrix[r][c] = prefs;
    }
	//gets the prefs at prefsMatrix at index [r][c]
    public String getPrefsMatrixIndex(int r, int c)
    {
    	return prefsMatrix[r][c];
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
					System.out.println(teamsMatrix[r][c]);
			}
			System.out.println("");
		}
	}
	
	public static void main( String[] args )
    {
        System.out.println( "Hello, this is a sample file!" );
        FELiXGang t = new FELiXGang(4,2);
        t.printTeams();
    }
}
