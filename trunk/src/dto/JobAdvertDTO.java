package dto;



/**
 * <p><b>JobAdvertDTO</b> contains the entity JobAdvert.</p>
 * @author Samarjit Samanta
 * @version 1.0
 *
 */
public class JobAdvertDTO implements PropDTO{
	
	/**
	 * The Job Advert Status is "new" for the record
	 */
	public static String STATUS_NEW = "new";
	/**
	 * The Job Advert Status is "obsolete" for the record
	 */
	public static String STATUS_OBSOLETE = "obsolete";
	/**
	 * The Job Advert Status is "withdrawn" for the record
	 */
	public static String STATUS_WITHDRAWN = "withdrawn";
	/**
	 * The Job Advert Status is "filled" for the record
	 */
	public static String STATUS_FILLED = "filled";
	
	
	private int Id=0;
	private String cmpnyDesc="";
	private String jobrefcode="";
	private String cmpname="";
	private String department="";
	private String jobtitle="";
	private String jobdesc="";
	private String techskills="";
	private String mgmtskills="";
	private String noyrexp="";
	private String salaryrange="";
	private String startdate="";
	private String location="";
	private String status=STATUS_NEW;
	private String advertizerref="";
	

	/**
	 * gets company description
	 * @return company description
	 */
	public String getCmpnyDesc() {
		return cmpnyDesc;
	}
	/**
	 * sets company description
	 * @param cmpnyDesc
	 */
	public void setCmpnyDesc(String cmpnyDesc) {
		this.cmpnyDesc = cmpnyDesc;
	}
	/**
	 * gets the Id of the record
	 * @see dto.PropDTO#getId()
	 */
	public int getId() {
		return Id;
	}

	/** 
	 * sets the Id of the record
	 */
	public void setId(int id) {
		this.Id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "\n#id:"+Id+"|jobrefcode:"+jobrefcode+"| jobtitle:"+jobtitle+"|cmpnyDesc:"+cmpnyDesc+"| advertizerref:"+advertizerref;
	}
	/**
	 * gets job reference code
	 * @return job reference code
	 */
	public String getJobrefcode() {
		return jobrefcode;
	}
	/**
	 * sets job reference code
	 * @param jobrefcode
	 */
	public void setJobrefcode(String jobrefcode) {
		this.jobrefcode = jobrefcode;
	}
	/**
	 * gets company name
	 * @return company name
	 */
	public String getCmpname() {
		return cmpname;
	}
	/**
	 * sets compare
	 * @param cmpname
	 */
	public void setCmpname(String cmpname) {
		this.cmpname = cmpname;
	}
	/**
	 * gets department
	 * @return department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * sets department
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * gets job title
	 * @return job title
	 */
	public String getJobtitle() {
		return jobtitle;
	}
	/**
	 * set job title
	 * @param jobtitle
	 */
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	/**
	 * get Jod description
	 * @return job description
	 */
	public String getJobdesc() {
		return jobdesc;
	}
	/**
	 * sets job description
	 * @param jobdesc
	 */
	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}
	/**
	 * get tech skills
	 * @return tech skills
	 */
	public String getTechskills() {
		return techskills;
	}
	/**
	 * set tech skills
	 * @param techskills
	 */
	public void setTechskills(String techskills) {
		this.techskills = techskills;
	}
	/**
	 * get management skills
	 * @return management skills
	 */
	public String getMgmtskills() {
		return mgmtskills;
	}
	/**
	 * sets management skills
	 * @param mgmtskills
	 */
	public void setMgmtskills(String mgmtskills) {
		this.mgmtskills = mgmtskills;
	}
	/**
	 * @return no of years experience
	 */
	public String getNoyrexp() {
		return noyrexp;
	}
	/**
	 * sets number of years experience
	 * @param noyrexp
	 */
	public void setNoyrexp(String noyrexp) {
		this.noyrexp = noyrexp;
	}
	/**
	 * get salary range
	 * @return salary range
	 */
	public String getSalaryrange() {
		return salaryrange;
	}
	/**
	 * sets advertiser
	 * @param salaryrange
	 */
	public void setSalaryrange(String salaryrange) {
		this.salaryrange = salaryrange;
	}
	public String getStartdate() {
		return startdate;
	}
	/**
	 * sets Start Date
	 * @param startdate
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	/**
	 * gets location
	 * @return location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * sets location
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * gets advertiser
	 * @return advertiser
	 */
	public String getAdvertizerref() {
		return advertizerref;
	}
	
	/**
	 * gets status
	 * @return status
	 */
	public String getStatus() {
		return status;
	}
	
	
	/**
	 * sets status
	 */
	public void setStatus (String status) {
		this.status = status;
	}
	
	
	
	
	/**
	 * sets advertiser
	 * @param advertizerref
	 */
	public void setAdvertizerref(String advertizerref) {
		this.advertizerref = advertizerref;
	}
	
}
