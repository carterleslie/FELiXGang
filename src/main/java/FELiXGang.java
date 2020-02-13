/******************************************************************************
*  Author : cal17b Carter Leslie, wsl15a Wade Linder, and fab16b Felix Mbikogbia
*  Class  : Spring 2020 CS374.01 Dr. Reeves
*  Date   : 
*  Task   : 
*
*  This is a file for creating other files to use quickly in the future.
*
******************************************************************************/

public class FELiXGang 
{
	private int classSize;
	private int teamSize;
	private String[][] classArray;

    //initializer for a FELiXGang
    public FELiXGang(int cSize, int tSize)
    {
    	classSize = cSize;
    	teamSize = tSize;
    	if(classSize % teamSize == 0)
    		classArray = new String[teamSize][classSize / teamSize];
    	else
    		classArray = new String[teamSize][classSize / teamSize +1];
    }

    public int getTeamSize()
    {
    	return teamSize;
    }

    public int getClassSize()
    {
    	return classSize;
    }

}
