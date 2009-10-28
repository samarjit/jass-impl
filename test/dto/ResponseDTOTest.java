package dto;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import dto.CompanyDTO;
import dto.JobAdvertDTO;
import dto.ResponseDTO;

import junit.framework.TestCase;

/**
 * <p> <b> ResponseDTOTest </b> Test class for ResponseDTO {@link dto.ResponseDTO} class</p>
 * 
 * @author Anbazhagan Satish Kumar
 * @version 1.0 22/10/09
 *
 */

public class ResponseDTOTest extends TestCase{
	
	private int id=0;
	private int jsId;
	private String jsName;
	private String jsEmail;
	private String jsAddress;
	private String jsTelNum;
	private String jsResume;
	private int advertRefId;
	
	/**
	 * initialization. Executed before each test.
	 * @throws java.lang.Exception
	 */
	@Before
	protected void setUp() throws Exception{		
		
		id=1;
		jsId=11;
		jsName="david";
		jsEmail="david@gmail.com";
		jsAddress="boon lay";
		jsTelNum="81231344";
		jsResume="ergtrtg";
		advertRefId=1;
		
	}
	
	/**
	* Test method for {@link dto.ResponseDTO#setId(int)}.<br/>
	* Test method for {@link dto.ResponseDTO#getId()}.
	*/	
	
	public void testGetId()
	{
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setId(id);
		int id1= responseDTO.getId();
		assertEquals("These two ID's must be the same",id,id1);
	}
	
	/**
	* Test method for {@link dto.ResponseDTO#setJsId(int)}.<br/>
	* Test method for {@link dto.ResponseDTO#getJsId()}.
	*/
	
	public void testGetJsId()
	{
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setJsId(jsId);
		int jsId1= responseDTO.getJsId();
		assertEquals("These two Job seeker's ID's must be the same",jsId,jsId1);
	}

	/**
	* Test method for {@link dto.ResponseDTO#setJsName(String)}.<br/>
	* Test method for {@link dto.ResponseDTO#getJsName()}.
	*/
	
	public void testGetJsName()
	{
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setJsName(jsName);
		String jsName1= responseDTO.getJsName();
		assertSame("These two Job seeker's Name must be the same",jsName,jsName1);
	}

	/**
	* Test method for {@link dto.ResponseDTO#setJsEmail(String)}.<br/>
	* Test method for {@link dto.ResponseDTO#getJsEmail()}.
	*/
	
	public void testGetJsEmail()
	{
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setJsEmail(jsEmail);
		String jsEmail1= responseDTO.getJsEmail();
		assertEquals("These two Job seeker's Email must be the same",jsEmail,jsEmail1);
	}

	/**
	* Test method for {@link dto.ResponseDTO#setJsAddress(String)}.<br/>
	* Test method for {@link dto.ResponseDTO#getJsAddress()}.
	*/
	
	public void testGetJsAddress()
	{
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setJsAddress(jsAddress);
		String jsAddress1= responseDTO.getJsAddress();
		assertEquals("These two Job seeker's Address must be the same",jsAddress,jsAddress1);
	}

	/**
	* Test method for {@link dto.ResponseDTO#setJsTelNum(String)}.<br/>
	* Test method for {@link dto.ResponseDTO#getJsTelNum()}.
	*/
	
	public void testGetJsTelNum()
	{
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setJsTelNum(jsTelNum);
		String jsTelNum1= responseDTO.getJsTelNum();
		assertTrue((jsTelNum.equals(jsTelNum1)));
	}

	/**
	* Test method for {@link dto.ResponseDTO#setJsResume(String)}.<br/>
	* Test method for {@link dto.ResponseDTO#getJsResume()}.
	*/
	
	public void testGetJsResume()
	{
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setJsResume(jsResume);
		String jsResume1= responseDTO.getJsResume();
		assertSame("These two Job seeker's Name must be the same", jsResume, jsResume1);	
	}

	/**
	* Test method for {@link dto.ResponseDTO#setAdvertRefId(int)}.<br/>
	* Test method for {@link dto.ResponseDTO#getAdvertRefId()}.
	*/
	
	public void testGetAdvertRefId()
	{
		ResponseDTO responseDTO=new ResponseDTO();
		responseDTO.setAdvertRefId(advertRefId);
		int advertRefId1= responseDTO.getAdvertRefId();
		assertTrue(advertRefId==(advertRefId1));
	}
	
	
	
}
