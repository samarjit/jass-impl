package dto;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;
/**
 * <p> <b> UserAuthDTOTest </b> Test class for UserAuthDTO {@link dto.UserAuthDTOTest} class</p>
 * 
 * @author  
 * @version 1.0 28/09/09
 *
 */

import dto.UserAuthDTO;
public class UserAuthDTOTest extends TestCase{
	
    private int Id=0;
	private String userid;
	private String password;
	
	/**
	 * initialization. Executed before each test.
	 * @throws java.lang.Exception
	 */	
	@Before
	public void setUp() throws Exception
	{
		 Id='1';
		 userid="k123";
		 password="12345";
	     		
	}
	
	/**
	 * Executed after each test.
	 * @throws java.lang.Exception
	 */	
	@After
	public void tearDown() throws Exception
	{
		
		
	}
	
/**
* Test method for {@link dto.UserAuthDTO#setId(String)}.<br/>
* Test method for {@link dto.UserAuthDTO#getId()}.
*/
@Test
public void testGetId()
{
   UserAuthDTO userauthdto= new UserAuthDTO();
   userauthdto.setId(Id);
   int testid= userauthdto.getId();
   assertEquals("These two IDs must be the same",Id,testid);
}

/**
* Test method for {@link dto.UserAuthDTO#setUserID(String)}.<br/>
* Test method for {@link dto.UserAuthDTO#getUserID()}.
*/
@Test
public void testGetUserId(){
	   UserAuthDTO userauthdto= new UserAuthDTO();
	   userauthdto.setUserID(userid);
	   String testuserid= userauthdto.getUserID();
	   assertEquals("Userid and testuserid must be the same.",userid,testuserid);
}


/**
* Test method for {@link dto.UserAuthDTO#serPwd(String)}.<br/>
* Test method for {@link dto.UserAuthDTO#getPwd()}.
*/
@Test
public void testGetPassword(){
	   UserAuthDTO userauthdto= new UserAuthDTO();
	   userauthdto.setPwd(password);
	   String testpassword= userauthdto.getPwd();
	   assertEquals("Password and testpassword must be the same.",password,testpassword);
}
}