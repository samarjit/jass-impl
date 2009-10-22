package dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dto.JobAdvertDTO;
import dto.ResponseDTO;
import junit.framework.TestCase;


/**
 * <p> <b> ResponseDAOTest </b> Test class for ResponseDAO {@link dao.ResponseDAO} class</p>
 * 
 * @author Justin Jose
 * @version 1.0 28/09/09
 *
 */
public class ResponseDAOTest extends TestCase {


	/**
	 * 
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	/**
	 *
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	/**
	 * initialization. Executed before each test.
	 * @throws java.lang.Exception
	 */
	@Before
	protected void setUp() throws Exception{		
		ResponseDAO.PROPFILE = "properties/responsedaotest.properties";
		File f = new File(ResponseDAO.PROPFILE);
		f.delete();
		f.createNewFile();
	}

	/**
	 * Executed after each test.
	 * @throws java.lang.Exception
	 */	
	@After
	public void tearDown()throws Exception{
		ResponseDAO.PROPFILE = "properties/responsedaotest.properties";
		File f = new File(ResponseDAO.PROPFILE);
		f.delete();
	}
	
	
	/**
	 * Test method for {@link dao.ResponseDAO#insert(java.lang.Object)}.
	 */	
	@Test
	public void testInsert() {

		ResponseDTO rdt = new ResponseDTO();
		rdt = new ResponseDTO();
		rdt.setId(1);
		rdt.setJsId(1);
		rdt.setJsName("JS1");
		rdt.setJsEmail("js1@gmail.com");
		rdt.setJsAddress("Address");
		rdt.setJsTelNum("9962308233");
		rdt.setJsResume("resume");
		rdt.setAdvertRefId(1);
		
		ResponseDAO<ResponseDTO> rDAO = new ResponseDAO<ResponseDTO>();
		try {
			rDAO.insert(rdt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseDTO selRdt = null;
		
		try {
			selRdt = rDAO.select(rdt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertSame("Inserted and selected object should be same", rdt, selRdt);	    
	}

	/**
	 *  Test method for {@link dao.ResponseDAO#select(java.lang.Object)}.
	 */
	@Test
	public void testSelect() {
		
		ResponseDTO rdt = new ResponseDTO();
		rdt = new ResponseDTO();
		rdt.setId(1);
		rdt.setJsId(1);
		rdt.setJsName("JS1");
		rdt.setJsEmail("js1@gmail.com");
		rdt.setJsAddress("Address");
		rdt.setJsTelNum("9962308233");
		rdt.setJsResume("resume");
		rdt.setAdvertRefId(1);
		
		
		ResponseDAO<ResponseDTO> rDAO = new ResponseDAO<ResponseDTO>();

		ResponseDTO selRdt = new ResponseDTO();
	
		try {
			rDAO.insert(rdt);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			selRdt = rDAO.select(rdt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertSame("selected object id should be same", rdt.getId(), selRdt.getId());
	}

	/**
	 * Test method for {@link dao.ResponseDAO#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		
		ResponseDTO rdt = new ResponseDTO();
		rdt = new ResponseDTO();
		rdt.setId(1);
		rdt.setJsId(1);
		rdt.setJsName("JS1");
		rdt.setJsEmail("js1@gmail.com");
		rdt.setJsAddress("Address");
		rdt.setJsTelNum("9962308233");
		rdt.setJsResume("resume");
		rdt.setAdvertRefId(1);
		
		ResponseDAO<ResponseDTO> rDAO = new ResponseDAO<ResponseDTO>();
		
		try {
			rDAO.insert(rdt);			
			rdt.setId(2);
			rDAO.insert(rdt);
			rdt.setId(3);
			rDAO.insert(rdt);
			List<ResponseDTO> rdtList = (List<ResponseDTO>) rDAO.selectAll();			 
			assertEquals("The values should be same 1",1,((ResponseDTO) rdtList.get(2)).getId());
			assertEquals("The values should be same 2",2,((ResponseDTO) rdtList.get(1)).getId());
			assertEquals("The values should be same 3",3,((ResponseDTO) rdtList.get(0)).getId());			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Test method for {@link dao.ResponseDAO#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		
		ResponseDTO rdt = new ResponseDTO();
		rdt = new ResponseDTO();
		rdt.setId(1);
		rdt.setJsId(1);
		rdt.setJsName("JS1");
		rdt.setJsEmail("js1@gmail.com");
		rdt.setJsAddress("Address");
		rdt.setJsTelNum("9962308233");
		rdt.setJsResume("resume");
		rdt.setAdvertRefId(1);
		
		ResponseDAO<ResponseDTO> rDAO = new ResponseDAO<ResponseDTO>();
		try {
			
			rDAO.insert(rdt);
			rdt.setJsName("JSChange");
			rDAO.update(rdt);
			ResponseDTO dt = rDAO.select(rdt);
			assertEquals("The values should be same","JSChange",dt.getJsName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Test method for {@link dao.ResponseDAO#getNextId(java.lang.Object)}.
	 */
	@Test
	public void testGetNextId() {
		ResponseDAO<ResponseDTO> rDAO = new ResponseDAO<ResponseDTO>();
		ResponseDTO rdt =  new ResponseDTO();		
		try {
			int val  = rDAO.getNextId(rdt);
			
			assertEquals("Next id nust be 0", val,0);
			
			rdt.setId(val);
			rdt.setJsId(1);
			rdt.setJsName("JS1");
			rdt.setJsEmail("js1@gmail.com");
			rdt.setJsAddress("Address");
			rdt.setJsTelNum("9962308233");
			rdt.setJsResume("resume");
			rdt.setAdvertRefId(1);
			rDAO.insert(rdt);
			
			val  = rDAO.getNextId(rdt);
			
			assertEquals("Next id nust be 1 after inserting one record", 1,val);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link dao.ResponseDAO#delete(java.lang.Object)}.
	 */
	@Test
	public void testDelete() {
		
		ResponseDTO rdt = new ResponseDTO();
		rdt = new ResponseDTO();
		rdt.setId(1);
		rdt.setJsId(1);
		rdt.setJsName("JS1");
		rdt.setJsEmail("js1@gmail.com");
		rdt.setJsAddress("Address");
		rdt.setJsTelNum("9962308233");
		rdt.setJsResume("resume");
		rdt.setAdvertRefId(1);
			
		ResponseDAO<ResponseDTO> rDAO = new ResponseDAO<ResponseDTO>();
		
		try {
			rDAO.insert(rdt);			
			rdt.setId(2);			
			rDAO.insert(rdt);
			
			assertEquals("Before deleting next ID", 3, rDAO.getNextId(rdt) );
			rDAO.delete(rdt);			
			assertEquals("After deleting next ID", 2, rDAO.getNextId(rdt) );
						
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
