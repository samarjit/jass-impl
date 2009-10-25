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


public class UserAuthDAO<T> implements PropDAO<T> {
	
	public static String PROPFILE = "properties/userauth.properties";


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
