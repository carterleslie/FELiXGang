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

    FELiXGang sampleVar;

    /*@Before
    public void initialize()
    {
    	
    }*/

    @Test
    public void testInizializer()
    {
    	try
    	{
    		FELiXGang test1 = new FELiXGang(15,3);
    		assertTrue(test1.getTeamSize() == 3); //team size should be 3

    		assertTrue(test1.getClassSize() == 15); //class size should be 15
    	}
        catch (Exception e)
        {
            System.out.println("ExceptionInInitializerError1");
        }

        try
    	{
    		FELiXGang test2 = new FELiXGang(14,3);
    		assertTrue(test2.getTeamSize() == 3); //team size should be 3

    		assertTrue(test2.getClassSize() == 14); //class size should be 14
    	}
        catch (Exception e)
        {
            System.out.println("ExceptionInInitializerError2");
        }

        try
    	{
    		FELiXGang test3 = new FELiXGang(13,3);
    		assertTrue(test3.getTeamSize() == 3); //team size should be 3

    		assertTrue(test3.getClassSize() == 13); //class size should be 14
    	}
        catch (Exception e)
        {
            System.out.println("ExceptionInInitializerError3");
        }
    }

    @Test 
    public void testEmpty()
    {
    	try
    	{
		String test = "help";
		sampleVar.fillTeamsMatrixIndex(test,0,0);
    		String ans = sampleVar.getTeamsMatrixIndex(0,0);
    		assertEquals("help",ans);
    	}
        catch (Exception e)
        {
            System.out.println("Matrix is empty.");
        }
    } 
	/*
	//@Test
	testHappiness()
	{
		try
		{
			double ans = sampleVar.**methodName(proper utilization)**;
			assertEquals(5,ans);
		}
		catch (Exception e)
		{
			System.out.println("Not happy enough.");
		}
	}
    */
}
