/**
 * 
 */
package dao;

import static org.junit.Assert.fail;
import junit.framework.TestCase;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import dto.JobAdvertDTO;

/**
 * <p><b>JobAdvertDAOTest</b> is used to test  dao.JobAdvertDAO class</p>
 * @author Samarjit Samanta
 *
 */
public class JobAdvertDAOTest extends TestCase {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		System.out.println("Created File"+JobAdvertDAO.PROPFILE);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		System.out.println("Deleting temporary file"+JobAdvertDAO.PROPFILE);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		JobAdvertDAO<JobAdvertDTO> jdao = new JobAdvertDAO<JobAdvertDTO>();
		JobAdvertDAO.PROPFILE = "properties/jobadvertdaotest.properties";
		File f = new File(JobAdvertDAO.PROPFILE);
		f.delete();
		f.createNewFile();
		System.out.println("before");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		JobAdvertDAO.PROPFILE = "properties/jobadvertdaotest.properties";
		File f = new File(JobAdvertDAO.PROPFILE);
		f.delete();
		System.out.println("after");
	}

	/**
	 * Test method for  dao.JobAdvertDAO#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		
		JobAdvertDAO<JobAdvertDTO> dao = new JobAdvertDAO<JobAdvertDTO>();
		JobAdvertDTO dto =  new JobAdvertDTO();
		dto.setId(1);
		dto.setAdvertizerref("some");
		dto.setCmpname("some cmpny name");
		dto.setDepartment("some department");
		dto.setJobdesc("some desc");
		dto.setJobrefcode("some ref code");
		dto.setJobtitle("some job title");
		dto.setLocation("Location new delhi");
		dto.setMgmtskills("mgmt skills");
		dto.setNoyrexp("no yr exp");
		dto.setSalaryrange("30000");
		dto.setStartdate("12/12/2009");
		dto.setTechskills("Tech skills java");
		dto.setCmpname("MY Company");
		try {
			dao.insert(dto);
			JobAdvertDTO dt = dao.select(dto);
			assertEquals("The values should be same","MY Company",dto.getCmpname());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
	}

	

	/**
	 * Test method for  dao.JobAdvertDAO#selectAll()}.
	 */
	@Test
	public void testSelectAll() {
		JobAdvertDAO<JobAdvertDTO> dao = new JobAdvertDAO<JobAdvertDTO>();
		JobAdvertDTO dto =  new JobAdvertDTO();
		dto.setId(1);
		dto.setAdvertizerref("some");
		dto.setCmpname("some cmpny name");
		dto.setDepartment("some department");
		dto.setJobdesc("some desc");
		dto.setJobrefcode("some ref code");
		dto.setJobtitle("some job title");
		dto.setLocation("Location new delhi");
		dto.setMgmtskills("mgmt skills");
		dto.setNoyrexp("no yr exp");
		dto.setSalaryrange("30000");
		dto.setStartdate("12/12/2009");
		dto.setTechskills("Tech skills java");
		dto.setCmpname("MY Company");
		try {
			dao.insert(dto);
			dto.setId(2);
			dto.setCmpname("AnotherCompany");
			dao.insert(dto);
			List<JobAdvertDTO> dt = (List<JobAdvertDTO>) dao.selectAll();
			 
			assertEquals("The values should be same 1","MY Company",((JobAdvertDTO) dt.get(1)).getCmpname());
			assertEquals("The values should be same 2","AnotherCompany",((JobAdvertDTO) dt.get(0)).getCmpname());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Test method for  dao.JobAdvertDAO#update(java.lang.Object)}.
	 */
	@Test
	public void testUpdate() {
		JobAdvertDAO<JobAdvertDTO> dao = new JobAdvertDAO<JobAdvertDTO>();
		JobAdvertDTO dto =  new JobAdvertDTO();
		dto.setId(1);
		dto.setAdvertizerref("some");
		dto.setCmpname("some cmpny name");
		dto.setDepartment("some department");
		dto.setJobdesc("some desc");
		dto.setJobrefcode("some ref code");
		dto.setJobtitle("some job title");
		dto.setLocation("Location new delhi");
		dto.setMgmtskills("mgmt skills");
		dto.setNoyrexp("no yr exp");
		dto.setSalaryrange("30000");
		dto.setStartdate("12/12/2009");
		dto.setTechskills("Tech skills java");
		dto.setCmpname("MY Company");
		try {
			dao.insert(dto);
			dto.setCmpname("somediffcompany");
			dao.update(dto);
			JobAdvertDTO dt = dao.select(dto);
			assertEquals("The values should be same","somediffcompany",dto.getCmpname());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Test method for  dao.JobAdvertDAO#getNextId(java.lang.Object)}.
	 */
	@Test
	public void testGetNextId() {
		JobAdvertDAO<JobAdvertDTO> dao = new JobAdvertDAO<JobAdvertDTO>();
		JobAdvertDTO dto =  new JobAdvertDTO();
		dto.setId(0);
		try {
			int val  = dao.getNextId(dto);
			
			assertEquals("This must be 0", val,0);
			dto.setId(1);
			dto.setAdvertizerref("some");
			dto.setCmpname("some cmpny name");
			dto.setDepartment("some department");
			dto.setJobdesc("some desc");
			dao.insert(dto);
			val  = dao.getNextId(dto);
			
			assertEquals("This must be 2", 2,val);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for  dao.JobAdvertDAO#delete(java.lang.Object).
	 */
	@Test
	public void testDelete() {
		JobAdvertDAO<JobAdvertDTO> dao = new JobAdvertDAO<JobAdvertDTO>();
		JobAdvertDTO dto =  new JobAdvertDTO();
		dto.setId(0);
		dto.setAdvertizerref("some");
		dto.setCmpname("some cmpny name");
		dto.setDepartment("some department");
		dto.setJobdesc("some desc");
		
		try {
			dao.insert(dto);
			dto.setId(1);
			dto.setAdvertizerref("some new");
			dto.setCmpname(" new cmpny name");
			dto.setDepartment("new department");
			dto.setJobdesc("new desc");
			dao.insert(dto);
			JobAdvertDTO newdto = dao.select(dto);
			assertEquals("Before deleting","some new",newdto.getAdvertizerref());
			dao.delete(newdto);
			dto.setId(0);
			int nexti = dao.getNextId(dto);
			assertEquals("After deleting",1,nexti);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
