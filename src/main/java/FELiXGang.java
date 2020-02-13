/******************************************************************************
*  Authors: cal17b Carter Leslie, wsl15a Wade Linder,
*  Class  : Spring 2020 CS374.01 Dr. Reeves
*  Date   : 2/21/2020
*  Task   : Project 1 - Happy Teams
*
*  Team FELiXGang's main class for the Happy Teams Project.
*
******************************************************************************/

public class FELiXGang 
{
	private:
		int classSize;
		int teamSize;
		String[][] classArray;

    //initializer for a FELiXGang
    public FELiXGang(int cSize, int tSize)
    {
    	classSize = cSize;
    	teamSize = tSize;
    	if(classSize % teamSize == 0)
    		classArray = new classArray[teamSize][classSize/teamSize];
    	else
    		classArray = new classArray[teamSize][classSize/teamSize +1];
    }

}
