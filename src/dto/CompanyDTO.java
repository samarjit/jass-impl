package dto;

public class CompanyDTO {
	
	private int id;
	private String CompanyID;
	private String CompanyName;
	
	
	public String getCompanyID() {
		return CompanyID;
	}

	public void setCompanyID(String companyID) {
		CompanyID = companyID;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
