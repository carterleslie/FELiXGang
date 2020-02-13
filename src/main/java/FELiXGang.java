/******************************************************************************
 *  Author : cal17b Carter Leslie, wsl15a Wade Linder
 *  Class  : Spring 2020 CS374.01 Dr. Reeves
 *  Date   : 
 *  Task   : 
 *
 *  This is a file for creating other files to use quickly in the future.
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
	
	//Prints out created teams.
	public void printTeams() {
		int numTeams = classSize/teamSize;
		System.out.println((for int c = 0; i < numTeams; c++) {
			System.out.println("Team "i+1 ": "); 
			(for int r = 0; i< teamSize; r++) {
				if(r < teamSize-1)
					System.out.println(classArray[r][c] ", ");	
				else
					System.out.println(classArray[r][c]);
			}
			System.out.println("\n");
		} );
	}
	
	public void happinessAvg() {
		
	}
}
