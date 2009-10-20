package dto;

/**
 * This interface defines a generic DTO interface with one mandatory field specified
 * Id. This field is basically the primary key using which all records can be uniquely 
 * identified.
 * @author Samarjit
 * @version 1.0
 */
public interface PropDTO {

	int getId();
	
	void setId(int id);
	public String toString();

}
