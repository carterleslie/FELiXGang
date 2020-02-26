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
public class FELiXGangTest
{
    private static String sampleTeam;
    private static String initializerTest1;
    private static String initializerTest2;
    private static String initializerTest3;
    private static String negativeHappyTest;

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
    }

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
    	FELiXGang test1 = new FELiXGang(initializerTest1, 3, 0, 0, 0, 0);
		assertEquals(3, test1.getTeamSize()); //team size should be 3

    	assertEquals(15, test1.getClassSize()); //class size should be 15

    	assertEquals(5, test1.getNumTeams()); //num teams should be 5

        
    	FELiXGang test2 = new FELiXGang(initializerTest2, 3, 0, 0, 0, 0);
		assertEquals(3, test2.getTeamSize()); //team size should be 3

		assertEquals(14, test2.getClassSize()); //class size should be 14

		assertEquals(5, test2.getNumTeams()); //num teams should be 5

    	FELiXGang test3 = new FELiXGang(initializerTest3, 3, 0, 0, 0, 0);
		assertEquals(3, test3.getTeamSize()); //team size should be 3

    	assertEquals(13, test3.getClassSize()); //class size should be 13

		assertEquals(5, test3.getNumTeams()); //num teams should be 5
    }

    @Test 
    public void testFillMatrix()
    {
		FELiXGang test = new FELiXGang(sampleTeam, 2, 0, 0, 0, 0);
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
		FELiXGang test1 = new FELiXGang(sampleTeam, 2, 0, 0, 0, 0);

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
		FELiXGang test1 = new FELiXGang(sampleTeam, 2, 0, 0, 0, 0);
		
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
		FELiXGang test1 = new FELiXGang(sampleTeam, 2, 0, 0, 0, 0);
		
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
        FELiXGang testNegative = new FELiXGang(negativeHappyTest, 4,0,0,0,0);

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
		FELiXGang testTotalHap = new FELiXGang(sampleTeam, 2, 0, 0, 0);
		int val = 0;
		int teamSize = testTotalHap.getNumTeams;
		for(int i = 0; i < teamSize; i++)
			val += testTotalHap.getTeamHappinessIndex(i);	//Gets every team's total happiness, should be 12 for team 1 and 6 for team 2
		int ans = 18;
		assertEquals(ans,val);
	}
}
