

package dto;


/**
 * <p> <b>UserAuthDTO</b> holds the information about user. </p> 
 * 
 * 
 * @author Justin Jose
 * @version 1.0	28/09/09
 * 
 */


public class UserAuthDTO {

	private int id;
	private String userID;
	private String pwd;

	
	/**
	 * set id
	 * @param id
	 */
	public void setId(int id){
		this.id = id;
	}
	
	/**
	 * returns id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * returns the user name 
	 * @return userID user name of the user
	 */
	public String getUserID() {
		return userID;
	}
	
	/**
	 * set user id
	 * @param id
	 * @return nothing
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/**
	 * returns the password of the user 
	 * @return pwd password
	 */
	public String getPwd() {
		return pwd;
	}
	
	
}
