package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dto.*;


/**
 * <p><b>UserAuthDAO</b> is data access object for accessing the User Authentication details properties file and 
 * authenticating the details.</p>
 * @author Anbazhagan satish kumar
 * @param  T This should be <@link dto.UserAuthDTO> object.
 */
public class UserAuthDAO<T> implements PropDAO<T> {
	
	/**
	 *   This contains the path of properties file userauth.properties, where data is stored
	 */
	public static String PROPFILE = "properties/userauth.properties";
	/** 
	 * Deletes a User Auth record in the properties file
	 * @see dao.PropDAO#delete(java.lang.Object)
	 */

	public void delete(T dt) throws Exception { 
	 
		 UserAuthDTO uadt= (UserAuthDTO) dt;
		 Properties prop= new Properties();
		 File fprop = new File(UserAuthDAO.PROPFILE);
		 FileOutputStream fout = null;
	
		if(!fprop.exists()){
		System.out.println("Creating new file");
		 fprop.createNewFile();
	 }
	FileInputStream fin =  new FileInputStream(UserAuthDAO.PROPFILE);
	prop.load(fin);
	fin.close();
	String str = "";
	int i=uadt.getId();

	str = prop.getProperty("id"+uadt.getId());
	if(str == null || "".equals(str))
	{
		throw new Exception("Delete failed:Record does not exists");
	}else{
	
		prop.remove("id"+i);
		prop.remove("userId"+i);
		prop.remove("pwd"+i);
	
		
		fout = new FileOutputStream(UserAuthDAO.PROPFILE);
		prop.store(fout, "deleted rec no:"+i +" on " + new Date());
		fout.close();
	
}
	
	}

	/** 
	 * Gets the next Id that can be used for insertion of a new record.
	 * @see dao.PropDAO#getNextId(java.lang.Object)
	 */
	public int getNextId(T dt) throws Exception {
		 UserAuthDTO uadt= (UserAuthDTO) dt;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(UserAuthDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			int i=uadt.getId();
			
			do{
			str="";
			str = prop.getProperty("id"+i);
			i++;
			}while(str != null && i <=10000);
			 i--;
			 
			return i;
	}
	/**
	 * Inserts User Authentication record to properties file
	 * @see dao.PropDAO#insert(java.lang.Object)
	 * @exception If insert failed then exception is thrown
	 */
	public void insert(T dt) throws Exception {
		
		 UserAuthDTO uadt= (UserAuthDTO) dt;
		 Properties prop= new Properties();
		 File fprop = new File(UserAuthDAO.PROPFILE);
		 FileOutputStream fout = null;
		 if(!fprop.exists()){
			System.out.println("Creating new file");
			 fprop.createNewFile();
		 }
		FileInputStream fin =  new FileInputStream(UserAuthDAO.PROPFILE);
		prop.load(fin);
		fin.close();
		
		String str = "";
		int i=uadt.getId();

		str = prop.getProperty("id"+uadt.getId());
		if(str == null || "".equals(str))
		{
			
			prop.setProperty("id"+i, String.valueOf(uadt.getId()));
			prop.setProperty("userId"+i, String.valueOf(uadt.getUserID()));
			prop.setProperty("pwd"+i, String.valueOf(uadt.getPwd()));
			
			fout = new FileOutputStream(UserAuthDAO.PROPFILE);
			prop.store(fout, "Updated on: " + new Date());
			fout.close();
		}else{
			throw new Exception("Insert failed:Record already exists");
		}
	    
	}

	/**
	 * Select a User Auth object from properties file
	 * @see dao.PropDAO#select(java.lang.Object)
	 * @exception If no record exists then select throws an exception
	 */
	public T select(T dt) throws Exception {
		 UserAuthDTO uadt= (UserAuthDTO) dt;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(UserAuthDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			int i=uadt.getId();
			
			str = prop.getProperty("id"+uadt.getId());
			if(str == null || "".equals(str))
			{
			throw new Exception("Select failed:Record does not exists");
			}else{
			    
				uadt.setId(Integer.parseInt(prop.getProperty("id"+i)));
				uadt.setUserID(prop.getProperty("userId"+i));
				uadt.setPwd(prop.getProperty("pwd"+i));
			}			 
			return  dt;
	}

	/**
	 * Select all UserAuth records from properties file
	 * @see dao.PropDAO#selectAll()
	 */
	public Collection<T> selectAll() throws Exception {
		 UserAuthDTO uadt= new UserAuthDTO();
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(UserAuthDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			Set<?> kprop = prop.keySet();			
			Iterator<String> itr = (Iterator<String>)kprop.iterator();
			ArrayList<UserAuthDTO> arUserAuthDTO =  new ArrayList<UserAuthDTO>();
			while(itr.hasNext()){
				str =   itr.next();
				if(str !=null && "id".equals(str.substring(0,str.length()-1))){
						str = str.substring(str.length()-1,str.length() );
						uadt.setId(Integer.parseInt(prop.getProperty("id"+str)));
						uadt.setUserID(prop.getProperty("userId"+str));
						uadt.setPwd(prop.getProperty("pwd"+str));
						arUserAuthDTO.add(uadt);
				}
			}			
		return (Collection<T>) arUserAuthDTO;
	}

	/**
	 * Updates a User Auth record from properties files
	 * @see dao.PropDAO#update(java.lang.Object)
	 * @exception If update fails it throws an exception
	 */
	public void update(T dt) throws Exception {
		
		 UserAuthDTO uadt= (UserAuthDTO) dt;
		 Properties prop= new Properties();
		 File fprop = new File(UserAuthDAO.PROPFILE);
		 FileOutputStream fout = null;
		 if(!fprop.exists()){
			System.out.println("Creating new file");
			 fprop.createNewFile();
		 }
		FileInputStream fin =  new FileInputStream(UserAuthDAO.PROPFILE);
		prop.load(fin);
		fin.close();
		String str = "";
		int i=uadt.getId();

		str = prop.getProperty("id"+uadt.getId());
		if(str == null || "".equals(str))
		{
			throw new Exception("Update failed:Record does not exists");
		}else{

			prop.setProperty("id"+i, String.valueOf(uadt.getId()));
			prop.setProperty("userId"+i, uadt.getUserID());
			prop.setProperty("pwd"+i, uadt.getPwd());
			
			 
			fout = new FileOutputStream(UserAuthDAO.PROPFILE);
			prop.store(fout, "Updated on: " + new Date());
			fout.close();
		}
		
		
	}
	

}
