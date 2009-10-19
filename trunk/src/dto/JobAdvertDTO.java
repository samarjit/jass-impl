package dto;



public class JobAdvertDTO implements PropDTO{
	
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
	private String advertizerref;
	

	public String getCmpnyDesc() {
		return cmpnyDesc;
	}
	public void setCmpnyDesc(String cmpnyDesc) {
		this.cmpnyDesc = cmpnyDesc;
	}
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	public String toString(){
		return "\n#id:"+Id+"|jobrefcode:"+jobrefcode+"| jobtitle:"+jobtitle+"|cmpnyDesc:"+cmpnyDesc+"| advertizerref:"+advertizerref;
	}
	public String getJobrefcode() {
		return jobrefcode;
	}
	public void setJobrefcode(String jobrefcode) {
		this.jobrefcode = jobrefcode;
	}
	public String getCmpname() {
		return cmpname;
	}
	public void setCmpname(String cmpname) {
		this.cmpname = cmpname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getJobdesc() {
		return jobdesc;
	}
	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}
	public String getTechskills() {
		return techskills;
	}
	public void setTechskills(String techskills) {
		this.techskills = techskills;
	}
	public String getMgmtskills() {
		return mgmtskills;
	}
	public void setMgmtskills(String mgmtskills) {
		this.mgmtskills = mgmtskills;
	}
	public String getNoyrexp() {
		return noyrexp;
	}
	public void setNoyrexp(String noyrexp) {
		this.noyrexp = noyrexp;
	}
	public String getSalaryrange() {
		return salaryrange;
	}
	public void setSalaryrange(String salaryrange) {
		this.salaryrange = salaryrange;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAdvertizerref() {
		return advertizerref;
	}
	public void setAdvertizerref(String advertizerref) {
		this.advertizerref = advertizerref;
	}
	
}
