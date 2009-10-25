package dto;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;


import dto.JobAdvertDTO;

/**
 * <p><b>JobAdvertDTOTest</b> will be used to test {@link JobAdvertDTO}class</p>
 * @author Saw Nandi
 * @version 1.0
 */
public class JobAdvertDTOTest extends TestCase{
	
    private int Id=0;
	private String cmpnyDesc;
	private String jobrefcode;
	private String cmpname;
	private String department;
	private String jobtitle;
	private String jobdesc;
	private String techskills;
	private String mgmtskills;
	private String noyrexp;
	private String salaryrange;
	private String startdate;
	private String location;
	private String status;
	private String advertizerref;
	
	@Before
	public void setUp() throws Exception
	{
		 Id='1';
		 cmpnyDesc="My New Company";
		 jobrefcode="fgd45";
	     cmpname="IBM";
		 department="IT";
		 jobtitle="Programmer";
		 jobdesc="sfafdl";
		 techskills="sdfsfsf";
		 mgmtskills="ksdjlkj";
		 noyrexp="3 years";
		 salaryrange="$3000";
		 startdate="12/10/2009";
		 location="Singapore";
		 status="new";
		 advertizerref="Advref-3";
		
	}
	@After
	public void tearDown() throws Exception
	{
		
		
	}
	
@Test
public void testGetId()
{
   JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
   jobadvertDTO.setId(Id);
   int testid= jobadvertDTO.getId();
   assertEquals("These two IDs must be the same",Id,testid);
   
}
	
@Test
public void testGetCompanyDesc(){
	JobAdvertDTO jobadvertDTO = new JobAdvertDTO();
	jobadvertDTO.setCmpnyDesc(cmpnyDesc);
	String newCompDesc = jobadvertDTO.getCmpnyDesc();
	assertEquals("These two company description must be the same",cmpnyDesc,newCompDesc);
}

@Test
public void testGetJobrefcode()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setJobrefcode(jobrefcode);
	String newjrefcode= jobadvertDTO.getJobrefcode();
	assertEquals("These two job reference codes must be the same",jobrefcode,newjrefcode);
}

@Test
public void testGetCmpName()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setCmpname(cmpname);
	String newcmpname= jobadvertDTO.getCmpname();
	assertEquals("These two company names must be the same",cmpname,newcmpname);
}

@Test
public void testGetDept()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setDepartment(department);
	String newdept= jobadvertDTO.getDepartment();
	assertEquals("These two department names must be the same",department,newdept);
}

@Test
public void testGetJTitle()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setJobtitle(jobtitle);
	String newjobtitle= jobadvertDTO.getJobtitle();
	assertEquals("These two job reference codes must be the same",jobtitle,newjobtitle);
}


@Test
public void testGetJDesc()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setJobdesc(jobdesc);
	String newjobdesc= jobadvertDTO.getJobdesc();
	assertEquals("These two job descriptions must be the same",jobdesc,newjobdesc);
}

@Test
public void testGetTechskills()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setTechskills(techskills);
	String newtechskills= jobadvertDTO.getTechskills();
	assertEquals("These two technical skills must be the same",techskills,newtechskills);
}

@Test
public void testGetMgmtskills()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setMgmtskills(mgmtskills);
	String newmgmtskills= jobadvertDTO.getMgmtskills();
	assertEquals("These two job reference codes must be the same",mgmtskills,newmgmtskills);
}

@Test
public void testGetNoyrexp()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setNoyrexp(noyrexp);
	String newnoyrexp= jobadvertDTO.getNoyrexp();
	assertEquals("These two no of year must be the same",noyrexp,newnoyrexp);
}

@Test
public void testGetSalaryRange()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setSalaryrange(salaryrange);
	String newsalaryrange= jobadvertDTO.getSalaryrange();
	assertEquals("These two salary range must be the same",salaryrange,newsalaryrange);
}


@Test
public void testGetStartDate()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setStartdate(startdate);
	String newstartdate= jobadvertDTO.getStartdate();
	assertEquals("These two date must be the same",startdate,newstartdate);
}

@Test
public void testGetLocation()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setLocation(location);
	String newlocation= jobadvertDTO.getLocation();
	assertEquals("These two location must be the same",location,newlocation);
}

@Test
public void testGetAdvertiserref()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setAdvertizerref(advertizerref);
	String newadvertizerref= jobadvertDTO.getAdvertizerref();
	assertEquals("These two job reference codes must be the same",advertizerref,newadvertizerref);
}


@Test
public void testGetStatus()
{
	JobAdvertDTO jobadvertDTO=new JobAdvertDTO();
	jobadvertDTO.setStatus(status);
	String newstatus= jobadvertDTO.getStatus();
	assertEquals("These two status must be the same",status,newstatus);
}
}
