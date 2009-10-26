package dto;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

import dto.UserAuthDTO;
public class UserAuthDTOTest extends TestCase{
	
    private int Id=0;
	private String userid;
	private String password;
	
	
	@Before
	public void setUp() throws Exception
	{
		 Id='1';
		 userid="k123";
		 password="12345";
	     		
	}
	@After
	public void tearDown() throws Exception
	{
		
		
	}
	
@Test
public void testGetId()
{
   UserAuthDTO userauthdto= new UserAuthDTO();
   userauthdto.setId(Id);
   int testid= userauthdto.getId();
   assertEquals("These two IDs must be the same",Id,testid);
}
	
@Test
public void testGetUserId(){
	   UserAuthDTO userauthdto= new UserAuthDTO();
	   userauthdto.setUserID(userid);
	   String testuserid= userauthdto.getUserID();
	   assertEquals("Userid and testuserid must be the same.",userid,testuserid);
}

@Test
public void testGetPassword(){
	   UserAuthDTO userauthdto= new UserAuthDTO();
	   userauthdto.setPwd(password);
	   String testpassword= userauthdto.getPwd();
	   assertEquals("Password and testpassword must be the same.",password,testpassword);
}
}