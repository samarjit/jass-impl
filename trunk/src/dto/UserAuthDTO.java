

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
	 * <p> Constructor which creates the User authentication records <p>
	 * @param userid user name of the user
	 * @param pwd	password of the user
	 */
	public UserAuthDTO(String userid, String pwd) {
		this.userID = userid;
		this.pwd = pwd;
	}
	
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
	 * returns the password of the user 
	 * @return pwd password
	 */
	public String getPwd() {
		return pwd;
	}
	
}
