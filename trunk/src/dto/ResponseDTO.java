package dto;

/**
 * <p> <b>ResponseDTO</b> holds the information about the job seeker's response 
 * on a particular job advert. </p> 
 * 
 * 
 * @author Justin Jose
 * @version 1.0	28/09/09
 * 
 */


public class ResponseDTO implements PropDTO {
	
	private int id=0;
	private int jsId;
	private String jsName;
	private String jsEmail;
	private String jsAddress;
	private String jsTelNum;
	private String jsResume;
	private int advertRefId;
	
	
	/**
	 * returns  response id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * set  response id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * return job seeker id
	 */
	public int getJsId() {
		return jsId;
	}
	
	/**
	 * set job seeker id
	 * @param jsId
	 */
	public void setJsId(int jsId) {
		 this.jsId = jsId;
	}
	
	/**
	 * returns  job seeker name
	 * @return job seeker name
	 */
	public String getJsName() {
		return jsName;
	}
	
	/**
	 * 
	 * @param jsName
	 */
	public void setJsName(String jsName) {
		this.jsName = jsName;
	}
	
	/**
	 * returns  job seeker email
	 * @return
	 */
	public String getJsEmail() {
		return jsEmail;
	}
	
	/**
	 * set  job seeker email
	 * @param jsEmail
	 */
	public void setJsEmail(String jsEmail) {
		this.jsEmail = jsEmail;
	}
	
	/**
	 * returns  job seeker address
	 * @return
	 */
	public String getJsAddress() {
		return jsAddress;
	}
	
	/**
	 * set  job seeker address
	 * @param jsAddress
	 */
	public void setJsAddress(String jsAddress) {
		this.jsAddress = jsAddress;
	}
	
	/**
	 * returns  job seeker telephone number
	 * @return
	 */
	public String getJsTelNum() {
		return jsTelNum;
	}
	
	/**
	 * set job seeker telephone number
	 * @param jsTelNum
	 */
	public void setJsTelNum(String jsTelNum) {
		this.jsTelNum = jsTelNum;
	}
	
	/**
	 * returns  job seeker resume
	 * @return
	 */
	public String getJsResume() {
		return jsResume;
	}
	
	/**
	 * set job seeker resume
	 * @param jsResume
	 */	
	public void setJsResume(String jsResume) {
		this.jsResume = jsResume;
	}
	
	/**
	 *  returns job advert reference id
	 * @param advertRefId
	 */
	public int getAdvertRefId() {
		return advertRefId;
	}

	/**
	 * set job advert reference id
	 * @param advertRefId
	 */
	public void setAdvertRefId(int advertRefId) {
		this.advertRefId = advertRefId;
	}
	
}
