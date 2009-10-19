package dao;

import org.junit.Test;

import dto.ResponseDTO;
import junit.framework.TestCase;


/**
 * <p> <b> ResponseDAOTest </b> Test class for ResponseDAO </p>
 * 
 * @author Justin Jose
 * @version 1.0
 *
 */
public class ResponseDAOTest extends TestCase {


	private ResponseDTO rdt;
	/**
	 * Constructor
	 */
	public ResponseDAOTest() {

	}

	/**
	 * initialization. Executed before each test.
	 */
	protected void setUp(){
		rdt = new ResponseDTO();
		rdt.setId(2);
		rdt.setJsId(1);
		rdt.setJsName("JJ");
		rdt.setJsEmail("jj@gmail.com");
		rdt.setJsAddress("BG");
		rdt.setJsTelNum("9962308233");
		rdt.setJsResume("skjdhfsljd");
		rdt.setAdvertRefId(1);
	}

	@Test
	public void testInsert() {

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

	@Test
	public void testSelect() {
		ResponseDAO<ResponseDTO> rDAO = new ResponseDAO<ResponseDTO>();

		ResponseDTO selRdt = new ResponseDTO();
		selRdt.setId(1);
		try {
			selRdt = rDAO.select(selRdt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertSame("selected object id should be same", 1, selRdt.getId());
	}

}
