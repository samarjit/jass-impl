package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dto.CompanyDTO;
import dto.ResponseDTO;
import dto.UserAuthDTO;

/**
 * <p><b>CompanyDAO</b> is data access object for accessing the company details from properties file</p>
 * @author Anbazhagan satish kumar
 * @param  <T> This should be <@link dto.CompanyDTO> object.
 */
public class CompanyDAO<T> implements PropDAO<T> {

	public static String PROPFILE = "properties/company.properties";
	
	/** 
	 * Deletes a Company record in the properties file
	 * @see dao.PropDAO#delete(java.lang.Object)
	 */
	
	public void delete(T dt) throws Exception {
		 CompanyDTO cdt= (CompanyDTO) dt;
		 Properties prop= new Properties();
		 File fprop = new File(CompanyDAO.PROPFILE);
		 FileOutputStream fout = null;
	
		if(!fprop.exists()){
		System.out.println("Creating new file");
		 fprop.createNewFile();
	 }
	FileInputStream fin =  new FileInputStream(CompanyDAO.PROPFILE);
	prop.load(fin);
	fin.close();
	String str = "";
	int i=cdt.getId();

	str = prop.getProperty("id"+cdt.getId());
	if(str == null || "".equals(str))
	{
		throw new Exception("Delete failed:Record does not exists");
	}else{
		prop.remove("id"+i);
		prop.remove("CompanyId"+i);
		prop.remove("CompanyName"+i);
					
	    fout = new FileOutputStream(CompanyDAO.PROPFILE);
		prop.store(fout, "deleted rec no:"+i +" on " + new Date());
	    fout.close();
	
}
	}

	/** 
	 * Gets the next Id that can be used for insertion of a new record.
	 * @see dao.PropDAO#getNextId(java.lang.Object)
	 */
	public int getNextId(T dt) throws Exception {
		 CompanyDTO cdt = (CompanyDTO)dt;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(CompanyDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			int i=cdt.getId();
			
			do{
			str="";
			str = prop.getProperty("id"+i);
			i++;
			}while(str != null && i <=10000);
			 i--;
			 
			return i;
	}

	/**
	 * Inserts Company record to properties file
	 * @see dao.PropDAO#insert(java.lang.Object)
	 * @exception If insert failed then exception is thrown
	 */
	public void insert(T dt) throws Exception {
		
		CompanyDTO cdt= (CompanyDTO) dt;
		 Properties prop= new Properties();
		 File fprop = new File(CompanyDAO.PROPFILE);
		 FileOutputStream fout = null;
		 if(!fprop.exists()){
			System.out.println("Creating new file");
			 fprop.createNewFile();
		 }
		FileInputStream fin =  new FileInputStream(CompanyDAO.PROPFILE);
		prop.load(fin);
		fin.close();
		
		String str = "";
		int i=cdt.getId();

		str = prop.getProperty("id"+cdt.getId());
		if(str == null || "".equals(str))
		{
			prop.setProperty("id"+i, String.valueOf(cdt.getId()));
			prop.setProperty("CompanyId"+i, cdt.getCompanyID());
			prop.setProperty("CompanyName"+i,cdt.getCompanyName());
			
			
			fout = new FileOutputStream(CompanyDAO.PROPFILE);
			prop.store(fout, "Updated on: " + new Date());
			fout.close();
		}else{
			throw new Exception("Insert failed:Record already exists");
		}
		
	}

	/**
	 * Select a Company object from properties file
	 * @see dao.PropDAO#select(java.lang.Object)
	 * @exception If no record exists then select throws an exception
	 */
	
	public T select(T dt) throws Exception {

		CompanyDTO cdt= (CompanyDTO) dt;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(CompanyDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			int i=cdt.getId();

			str = prop.getProperty("CompanyName"+cdt.getId());
			if(str == null || "".equals(str))
			{
			throw new Exception("Select failed:Record does not exists");
			}else{
			    
				cdt.setId(Integer.parseInt(prop.getProperty("id"+i)));			
				cdt.setCompanyID(prop.getProperty("CompanyId"+i));
				cdt.setCompanyName(prop.getProperty("CompanyName"+i));
			}			 
			return  dt;
	}
	/**
	 * Selects company records from properties file based on the company name. 
	 * It sets the company ID selected from properties to Company DTO object.
	*/
	public T selectIDbyName(T dt) throws Exception{
		
		CompanyDTO cdt= (CompanyDTO) dt;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(CompanyDAO.PROPFILE);
		 prop.load(fin);
		 fin.close();
		
		 int i = 0;
		 int flag = 0;
		Enumeration e =  prop.keys();
		while(e.hasMoreElements()){
			String stra = (String) e.nextElement();
			if(stra.startsWith("id")){
				i = Integer.parseInt(stra.substring(2, (stra.length())));
				
				if(cdt.getCompanyName().equals(prop.getProperty("CompanyName"+i))){
					
					cdt.setCompanyID(prop.getProperty("CompanyId"+i));
					cdt.setId(i);
					flag = 1;
				}
			}
		}

		if(flag==1){
			
			return dt;
		
		}
		
		else {
			return null;
		}
		
	}

	/**
	 * Select all Company records from properties file
	 * @see dao.PropDAO#selectAll()
	 */
	
	public Collection<T> selectAll() throws Exception {
		CompanyDTO cdt = null;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(CompanyDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			Set<?> kprop = prop.keySet();			
			Iterator<String> itr = (Iterator<String>)kprop.iterator();
			ArrayList<CompanyDTO> arCompanyDTO =  new ArrayList<CompanyDTO>();
			while(itr.hasNext()){
				str =   itr.next();
				if(str !=null && "id".equals(str.substring(0,str.length()-1))){
						str = str.substring(str.length()-1,str.length());
						cdt= new CompanyDTO();
						cdt.setId(Integer.parseInt(prop.getProperty("id"+str)));
						cdt.setCompanyID(prop.getProperty("CompanyId"+str));
						cdt.setCompanyName(prop.getProperty("CompanyName"+str));
						arCompanyDTO.add(cdt);
				
				}
			}			
			
		return (Collection<T>) arCompanyDTO;
	}
	


	/**
	 * Updates a company record from properties files
	 * @see dao.PropDAO#update(java.lang.Object)
	 * @exception If update fails it throws an exception
	 */

	public void update(T dt) throws Exception {
		
		CompanyDTO cdt= (CompanyDTO) dt;
		 Properties prop= new Properties();
		 File fprop = new File(CompanyDAO.PROPFILE);
		 FileOutputStream fout = null;
		 if(!fprop.exists()){
			System.out.println("Creating new file");
			 fprop.createNewFile();
		 }
		FileInputStream fin =  new FileInputStream(CompanyDAO.PROPFILE);
		prop.load(fin);
		fin.close();
		String str = "";
		int i=cdt.getId();

		str = prop.getProperty("id"+cdt.getId());
		if(str == null || "".equals(str))
		{
			throw new Exception("Update failed:Record does not exists");
		}else{
			
			prop.setProperty("id"+i, String.valueOf(cdt.getId()));
			prop.setProperty("CompanyId"+i, cdt.getCompanyID());
			prop.setProperty("CompanyNamr"+i, cdt.getCompanyName());
				 
			fout = new FileOutputStream(CompanyDAO.PROPFILE);
			prop.store(fout, "Updated on: " + new Date());
			fout.close();
		}
	}

}
