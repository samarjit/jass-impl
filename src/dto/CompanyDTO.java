package dto;

/**
 * <p> <b>CompanyDTO</b> holds the information about Company. </p> 
 * 
 * 
 * @author Anbazhagan Satish Kumar
 * @version 1.0	28/09/09
 * 
 */


public class CompanyDTO {
	
	private int id;
	private String CompanyID;
	private String CompanyName;
	
	

	/**
	 * returns Company ID
	 * @return CompanyID
	 */
	public String getCompanyID() {
		return CompanyID;
	}

	/**
	 * set Company id
	 * @param companyID
	 */
	public void setCompanyID(String companyID) {
		CompanyID = companyID;
	}

	/**
	 * returns Company Name
	 * @return CompanyName
	 */
	public String getCompanyName() {
		return CompanyName;
	}

	/**
	 * set Company Name
	 * @param companyName Company Name
	 */
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	

	/**
	 * returns ID
	 * @return ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * set  id
	 * @param  id
	 */
	public void setId(int id) {
		this.id = id;
	}
	

}
