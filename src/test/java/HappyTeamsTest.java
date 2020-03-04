/******************************************************************************
*  Author : cal17b Carter Leslie, wsl15a Wade Linder, and fab16b Felix Mbikogbia
*  Class  : Spring 2020 CS374.01 Dr. Reeves
*  Date   : 
*  Task   : This is the test file for Project 1 of CS374. 
*
*  Tests Team FELiXGang's edition of the Happy Teams Project.
*
******************************************************************************/

import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;
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
public class HappyTeamsTest
{
    private static String sampleTeam;
    private static String initializerTest1;
    private static String initializerTest2;
    private static String initializerTest3;
    private static String negativeHappyTest;
    private static String bestTest;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception 
    {
        File file = new File("sampleTeam.txt");
        Scanner sc = new Scanner(file);
        sampleTeam = "";
        while(sc.hasNext())
        {
            sampleTeam = sampleTeam + sc.next() + " ";
        }
        sc.close();
        file = new File("initializerTest1.txt");
        sc = new Scanner(file);
        initializerTest1 = "";
        while(sc.hasNext())
        {
            initializerTest1 = initializerTest1 + sc.next() + " ";
        }
        sc.close();
        file = new File("initializerTest2.txt");
        sc = new Scanner(file);
        initializerTest2 = "";
        while(sc.hasNext())
        {
            initializerTest2 = initializerTest2 + sc.next() + " ";
        }
        sc.close();
        file = new File("initializerTest3.txt");
        sc = new Scanner(file);
        initializerTest3 = "";
        while(sc.hasNext())
        {
            initializerTest3 = initializerTest3 + sc.next() + " ";
        }
        sc.close();
        file = new File("negativeHappyTest.txt");
        sc = new Scanner(file);
        negativeHappyTest = "";
        while(sc.hasNext())
        {
            negativeHappyTest = negativeHappyTest + sc.next() + " ";
        }
        sc.close();
        file = new File("bestTest.txt");
        sc = new Scanner(file);
        bestTest = "";
        while(sc.hasNext())
        {
            bestTest = bestTest + sc.next() + " ";
        }
        sc.close();
    }

	@Rule
    public TestRule watcher =
    	new TestWatcher() {
    	    protected void starting(Description description) {
    		System.out.println("Starting test: " + description.getMethodName());
    	    }
    	};

    @Test
    public void testInizializer()
    {
    	HappyTeams test1 = new HappyTeams(initializerTest1, 3, -1, 0, 0, 0);
		assertEquals(3, test1.getTeamSize()); //team size should be 3
    	assertEquals(15, test1.getClassSize()); //class size should be 15
    	assertEquals(5, test1.getNumTeams()); //num teams should be 5

    	HappyTeams test2 = new HappyTeams(initializerTest2, 3, -1, 0, 0, 0);
		assertEquals(3, test2.getTeamSize()); //team size should be 3
		assertEquals(14, test2.getClassSize()); //class size should be 14
		assertEquals(5, test2.getNumTeams()); //num teams should be 5

    	HappyTeams test3 = new HappyTeams(initializerTest3, 3, -1, 0, 0, 0);
		assertEquals(3, test3.getTeamSize()); //team size should be 3
    	assertEquals(13, test3.getClassSize()); //class size should be 13
		assertEquals(5, test3.getNumTeams()); //num teams should be 5
    }

    @Test 
    public void testFillMatrix()
    {
		HappyTeams test = new HappyTeams(sampleTeam, 2, -1, 0, 0, 0);
		String ans1 = "Bubba";
        String test1 = test.getTeamsMatrixIndex(0,0);
    	assertEquals(ans1,test1);

    	String ans2 = "Natasha";
        String test2 = test.getTeamsMatrixIndex(1,0);
		assertEquals(ans2,test2);
    } 
	
	@Test
	public void testHappiness()
	{
		HappyTeams test1 = new HappyTeams(sampleTeam, 2, -1, 0, 0, 0);

        int val = test1.getIndividualHappinessMatrixIndex(0,0); //should be 5
        int ans1 = 5;
        assertEquals(ans1,val);

        int val2 = test1.getTeamHappinessIndex(0); // should be 5 + 7, which is 12
        int ans2 = 12; //5 + 7 = 12
        assertEquals(ans2,val2);
	}   
	@Test
	public void testSwap()
	{
		HappyTeams test1 = new HappyTeams(sampleTeam, 2, -1, 0, 0, 0);
		
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
		HappyTeams test1 = new HappyTeams(sampleTeam, 2, -1, 0, 0, 0);
		
		test1.swapPeople(0,0,0,1);	//Swap Bubba and Roland.
		int val = test1.getIndividualHappinessMatrixIndex(0,0); //Should be 1
        int ans1 = 1;
        assertEquals(ans1,val);
		
		int ans2 = 1;
		int val2 = test1.getTeamHappinessIndex(0); //Should be 1
		assertEquals(ans2,val2);
	}

    @Test
    public void testNegativeHappy()
    {
        HappyTeams testNegative = new HappyTeams(negativeHappyTest, 4,-1,0,0,0);

        int test1 = testNegative.getIndividualHappinessMatrixIndex(3,0); //should be -15
        int ans1 = -15;
        assertEquals(ans1,test1);

        int test2 = testNegative.getTeamHappinessIndex(0); //should be -46
        int ans2 = -46;
        assertEquals(ans2,test2);
    }
	@Test
	public void testTotalHappiness()
	{
		HappyTeams testTotalHap = new HappyTeams(sampleTeam, 2,-1,0,0,0);
		int val = 0;
		int teamSize = testTotalHap.getNumTeams();
		for(int i = 0; i < teamSize; i++)
			val += testTotalHap.getTeamHappinessIndex(i);	//Gets every team's total happiness, should be 12 for team 1 and 7 for team 2
		int ans = 19;
		assertEquals(ans,val);
	}
	@Test
	public void testTotalHappinessSwap()
	{
		HappyTeams testTotalHap = new HappyTeams(sampleTeam, 2,-1,0,0,0);
		int val = 0;
		int teamSize = testTotalHap.getNumTeams();
		testTotalHap.swapPeople(0,0,0,1);
		for(int i = 0; i < teamSize; i++)
			val += testTotalHap.getTeamHappinessIndex(i);	//Gets every team's total happiness, should be 1 for team 1 and 1 for team 2
		int ans = 2;
		assertEquals(ans,val);
	}
	
    @Test
    public void testBest()
    {
        HappyTeams best = new HappyTeams(bestTest,3,0,1000,20,0);
        //making sure the total happiness is highter than 0, meaning more people are happy than are not happy
        for(int i = 0; i < 20; i++)
            assertTrue( best.getSetsIndex(i).getTotalHappiness() > 0); 
    }

	@Test(expected= IndexOutOfBoundsException.class)
	public void testWrongSwap()
	{
		HappyTeams testWrongSwap = new HappyTeams(sampleTeam, 2,-1,0,0,0);
		testWrongSwap.swapPeople(0,0,2,2); //breaks because a 2x2 matrix only has r=1 and c=1 as it's max
	}
	
    @Test(expected= IndexOutOfBoundsException.class)
    public void testBothWrongSwap() //Swaps the names of people, but one is outside of the scope
    {
        HappyTeams test1 = new HappyTeams(sampleTeam, 2, -1, 0, 0, 0);
        test1.swapPeople(2,1,1,2);
    }

	@Test(expected= IndexOutOfBoundsException.class)
	public void testHappyWrong()
	{
		HappyTeams testHappy = new HappyTeams(negativeHappyTest, 4,-1,0,0,0);

        int test1 = testHappy.getIndividualHappinessMatrixIndex(8,8); //breaks because it's far outside the matrix
	}
	
	@Test(expected= IndexOutOfBoundsException.class)
	public void testFillMatrixWrong()
	{
		HappyTeams test = new HappyTeams(sampleTeam, 2, -1, 0, 0, 0);
        test.getTeamsMatrixIndex(3,3);	//Breaks here, out of scope of the matrix.
	}
	@Test
    public void testPrefMatrixIndex()
    {
        HappyTeams testNegative = new HappyTeams(negativeHappyTest, 4,-1,0,0,0);

        int test1 = testNegative.getPrefsMatrixIndex(0,0,0); //should be 2
        int ans1 = 2;
        assertEquals(ans1,test1);
	}
	@Test
    public void testGetIDMatrixIndex()
    {
        HappyTeams testGetIDIndex = new HappyTeams(sampleTeam, 2, -1, 0, 0, 0);

        int test1 = testGetIDIndex.getIDMatrixIndex(0,1); //should be 2
        int ans1 = 2;
        assertEquals(ans1,test1);
	}

	@Test(expected= IndexOutOfBoundsException.class)
	public void testGetIDMatrixIndexWrong()
	{
		HappyTeams testGetIDIndex = new HappyTeams(sampleTeam, 2, -1, 0, 0, 0);

        int test1 = testGetIDIndex.getIDMatrixIndex(0,8); //This should fail because there is no ID at the give index.
	}
}