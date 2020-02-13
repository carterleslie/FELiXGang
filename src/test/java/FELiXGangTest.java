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

public class FELiXGangTest
{
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
    		FELiXGang test = new FELiXGang(15,3)
    		assertTrue(FELiXGang.getTeamSize() == 3); //team size should be 3

    		assertTrue(FELiXGang.getClassSize() == 15); //class size should be 15
    	}
        catch (Exception e)
        {
            System.out.println("Test failed");
        }
    }

    //@Test 
    /*testEmpty()
    {
    	try
    	{
    		string ans = sampleVar.**methodName(proper utilization)**;
    		assertEquals("",ans);
    	}
        catch (Exception e)
        {
            System.out.println("Matrix is not empty.");
        }
    } 
	
	//@Test
	testTeamSize()
	{
		try
		{
			int ans = sampleVar.**methodName(proper utilization)**;
			assertEquals(3,ans);
		}
		catch (Exception e)
		{
			System.out.println("Teams are not three deep.");
		}
	}
	
	//@Test
	testTeamNumber()
	{
		try
		{
			int ans = sampleVar.**methodName(proper utilization)**;
			assertEquals(5,ans);
		}
		catch (Exception e)
		{
			System.out.println("Not right amount of teams.");
		}
	}
	
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