/******************************************************************************
*  Author : cal17b Carter Leslie, wsl15a Wade Linder, and fab16b Felix Mbikogbia
*  Class  : Spring 2020 CS374.01 Dr. Reeves
*  Date   : 
*  Task   : This is the test file for Project 1 of CS374. 
*
*  Tests Team FELiXGang's edition of the Happy Teams Project.
*
******************************************************************************/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.Description;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FELiXGangTest
{

	@Rule
    public TestRule watcher =
    	new TestWatcher() {
    	    protected void starting(Description description) {
    		System.out.println("Starting test: " + description.getMethodName());
    	    }
    	};
/*
    FELiXGang sampleVar;

    @Before
    public void initialize()
    {
    	sampleVar = new FELiXGang(4,2);
    }
*/
    @Test
    public void testInizializer()
    {
    	FELiXGang test1 = new FELiXGang("sampleTeam.txt",15,3);
		assertTrue(test1.getTeamSize() == 3); //team size should be 3

    	assertTrue(test1.getClassSize() == 15); //class size should be 15

    	assertTrue(test1.getNumTeams() == 5); //num teams should be 5

        
    	FELiXGang test2 = new FELiXGang("sampleTeam.txt",14,3);
		assertTrue(test2.getTeamSize() == 3); //team size should be 3

		assertTrue(test2.getClassSize() == 14); //class size should be 14

		assertTrue(test2.getNumTeams() == 5); //num teams should be 5

    	FELiXGang test3 = new FELiXGang("sampleTeam.txt",13,3);
		assertTrue(test3.getTeamSize() == 3); //team size should be 3

    	assertTrue(test3.getClassSize() == 13); //class size should be 14

		assertTrue(test3.getNumTeams() == 5); //num teams should be 5
    }

    @Test 
    public void testFillMatrix()
    {
		FELiXGang test1 = new FELiXGang("sampleTeam.txt",4,2);
		String test = "help";
		test1.fillTeamsMatrixIndex(test,0,0);
    	String ans = test1.getTeamsMatrixIndex(0,0);
    	assertEquals("help",ans);

    	ans = "Natasha";
		assertEquals(ans,test1.getTeamsMatrixIndex(1,0));
    } 
	
	@Test
	public void testHappiness()
	{
		FELiXGang test1 = new FELiXGang("sampleTeam.txt",4,2);

        int val = test1.getIndividualHappinessMatrixIndex(0,0); //should be 5
        int ans1 = 13;
        assertEquals(ans1,val);

        int val2 = test1.getTeamHappinessIndex(0); // should be (5 + 6) / 2, which is 5 lol
        int ans2 = 14; //(13 + 16) / 2 = 14
        assertEquals(ans2,val2);
	}   
	@Test
	public void testSwap()
	{
		FELiXGang test1 = new FELiXGang("sampleTeam.txt",4,2);
		
		String ans = "Natasha";
		String ans2 = "Bubba";
		assertEquals(ans,test1.getTeamsMatrixIndex(1,0));	//Making sure it's in the right place first...
		assertEquals(ans2,test1.getTeamsMatrixIndex(0,0));
		
		test1.swapPeople(0,0,1,0);
		assertEquals(ans,test1.getTeamsMatrixIndex(0,0)); //And now testing that it's swapped.
		assertEquals(ans2,test1.getTeamsMatrixIndex(1,0));
	}
	
	@Test
	public void testSwapHappiness()
	{
		FELiXGang test1 = new FELiXGang("sampleTeam.txt",4,2);
		
		
		test1.swapPeople(0,0,0,1);	//Swap Bubba and Roland.
		int val = test1.getIndividualHappinessMatrixIndex(0,0); //Should be 10, Roland doesn't care about Natasha
        	int ans1 = 4;
        	assertEquals(ans1,val);
		
		int ans2 = 7;
		int val2 = test1.getTeamHappinessIndex(0);//Should also be 10, neither of them care about each other.
		assertEquals(ans2,val2);
	}
}
