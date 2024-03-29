package suite;

import dao.JobAdvertDAOTest;
import dao.ResponseDAOTest;
import dao.UserAuthDAOTest;
import dto.JobAdvertDTOTest;
import dto.ResponseDTOTest;
import dto.UserAuthDTOTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *  <p> <b> AllTests </b> Test suite class for all JASS test cases </p>
 *  
 * @author Justin Jose
 * @version 1.0	18/10/09
 */

public class AllTests extends TestCase {

	/**
	 * 
	 * @return JASS test suite
	 */
	public static Test suite(){
		TestSuite suite = new TestSuite("Test for JASS package");		
		suite.addTestSuite(ResponseDAOTest.class);
		suite.addTestSuite(ResponseDTOTest.class);
		suite.addTestSuite(JobAdvertDTOTest.class);
		suite.addTestSuite(JobAdvertDAOTest.class);
		suite.addTestSuite(UserAuthDTOTest.class);
		suite.addTestSuite(UserAuthDAOTest.class);
		return suite;
	}
}
