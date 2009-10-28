package dao;


import java.io.File;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dto.UserAuthDTO;

/**
 * <p> <b> UserAuthDAOTest </b> Test class for ResponseDAO {@link dao.UserAuthDAO} class</p>
 * 
 * @author Sarita 
 * @version 1.0 28/09/09
 *
 */
public class UserAuthDAOTest extends TestCase{
	
	private int id;
	private String uid;
	private String pwd;
	
	/**
	 * initialization. Executed before each test.
	 * @throws java.lang.Exception
	 */	
	@Before
	public void setUp() throws Exception {
		
	    UserAuthDAO.PROPFILE = "properties/userauth.properties";
		File f = new File(UserAuthDAO.PROPFILE);
		f.delete();
		f.createNewFile();
				
		UserAuthDAO<UserAuthDTO> dao=new UserAuthDAO<UserAuthDTO>();
		UserAuthDTO dto=new UserAuthDTO();
		id=dao.getNextId(dto)+ 1;
		//id='1';
		uid="M123";
		pwd="abcd";
			
	}

	/**
	 * Executed after each test.
	 * @throws java.lang.Exception
	 */	
	@After
	public void tearDown() throws Exception {
		UserAuthDAO.PROPFILE = "properties/userauthdaotest.properties";
		File f = new File(UserAuthDAO.PROPFILE);
		f.delete();			 
	}
	
	/**
	 * Test method for {@link dao.UserAuthDAO#insert(java.lang.Object)}.
	 */		
	@Test
	public void testInsert()
	{
		UserAuthDAO<UserAuthDTO> uadao=new UserAuthDAO<UserAuthDTO>();
		UserAuthDTO uadto= new UserAuthDTO();
				
		uadto.setId(id);
		uadto.setUserID(uid);
		uadto.setPwd(pwd);
		try {
			uadao.insert(uadto);
			
			assertEquals("The IDs should be the same.",id,uadto.getId());
			assertEquals("The UserIDs should be the same.",uid,uadto.getUserID());
			assertEquals("The Passwords should be the same.",pwd,uadto.getPwd());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Test method for {@link dao.UserAuthDAO#delete(java.lang.Object)}.
	 */	
	@Test
	public void testDelete()
	{
		UserAuthDAO<UserAuthDTO> uadao=new UserAuthDAO<UserAuthDTO>();
		UserAuthDTO uadto=new UserAuthDTO();
					
		try {
			//Add a new record to userauth.properties file
			
			uadto.setId(id);
			uadto.setUserID(uid);
			uadto.setPwd(pwd);
			
			uadao.insert(uadto);
						
			//Add next new record to userauth.properties file
			int testid=uadao.getNextId(uadto);
			//int testid='2';
			String testuid="K234";
			String testpwd="abc12";
			
			uadto.setId(testid);
			uadto.setUserID(testuid);
			uadto.setPwd(testpwd);
			
			uadao.insert(uadto);
			
			//Delete the added record
			UserAuthDTO deluadto=new UserAuthDTO();
			deluadto=uadao.select(uadto);
			uadao.delete(deluadto);
			
			UserAuthDTO newuadto=new UserAuthDTO();
			newuadto=uadao.select(uadto);
			
			assertEquals("After deleting,ID should be the same as first record's id :",id,newuadto.getId());
			assertEquals("After deleting,UserId should be the same as first record's userid :",uid,newuadto.getUserID());
			assertEquals("After deleting,Password should be the same as first record's password :",pwd,newuadto.getPwd());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Test method for {@link dao.UserAuthDAO#update(java.lang.Object)}.
	 */	
	@Test
	public void testUpdate()
	{
		UserAuthDAO<UserAuthDTO> uadao=new UserAuthDAO<UserAuthDTO>();
		UserAuthDTO uadto=new UserAuthDTO();
		try {
			int testid=uadao.getNextId(uadto)+1;
			//int testid='2';
			String testuid="K234";
			String testpwd="abc12";
			
			uadto.setId(testid);
			uadto.setUserID(testuid);
			uadto.setPwd(testpwd);
			
			uadao.insert(uadto);
			uadto.setUserID("U234");
			uadao.update(uadto);
			
			assertEquals("User Id should be the same as the updated data.","U234",uadto.getUserID());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Test method for {@link dao.UserAuthDAO#getNextId(java.lang.Object)}.
	 */	
	@Test
	public void testGetNextId()
	{
		UserAuthDAO<UserAuthDTO> uadao=new UserAuthDAO<UserAuthDTO>();
		UserAuthDTO uadto=new UserAuthDTO();
		
		try {
			uadto.setId(id);
			uadto.setUserID(uid);
			uadto.setPwd(pwd);
			
			uadao.insert(uadto);
						
			//Add next new record to userauth.properties file
			int testid=uadao.getNextId(uadto);
			//int testid='2';
			String testuid="K234";
			String testpwd="abc12";
			
			uadto.setId(testid);
			uadto.setUserID(testuid);
			uadto.setPwd(testpwd);
			
			uadao.insert(uadto);
					
			
		   List<UserAuthDTO> dt = (List<UserAuthDTO>) uadao.selectAll();
		  
		   int firstid=((UserAuthDTO) dt.get(1)).getId();
		   int secondid  = ((UserAuthDTO) dt.get(2)).getId();
		   
		   int nextid= uadao.getNextId(uadto);
			
			assertEquals("The first ID should be 1.", 1,firstid);
			assertEquals("The second ID should be 2.", 2,secondid);
			assertEquals("Next ID should be 3.",3,nextid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Test method for {@link dao.UserAuthDAO#selectAll()}.
	 */	
	@Test
	public void testSelectAll()
	{
		UserAuthDAO<UserAuthDTO> uadao=new UserAuthDAO<UserAuthDTO>();
		UserAuthDTO uadto=new UserAuthDTO();
		
		try {
			uadto.setId(id);
			uadto.setUserID(uid);
			uadto.setPwd(pwd);
			
			uadao.insert(uadto);			
			
			
			int testid=uadao.getNextId(uadto);
			//int testid='2';
			String testuid="S2345";
			String testpwd="abc123";
						
			uadto.setId(testid);
			uadto.setUserID(testuid);
			uadto.setPwd(testpwd);
			
			uadao.insert(uadto);
			List<UserAuthDTO> dt = (List<UserAuthDTO>) uadao.selectAll();
			 
			assertEquals("The values should be the same.","abc123",((UserAuthDTO) dt.get(2)).getPwd());
			assertEquals("The values should be the same.","abcd",((UserAuthDTO) dt.get(1)).getPwd());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
