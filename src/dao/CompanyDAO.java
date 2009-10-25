package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dto.CompanyDTO;
import dto.ResponseDTO;
import dto.UserAuthDTO;

public class CompanyDAO<T> implements PropDAO<T> {

	public static String PROPFILE = "properties/company.properties";
	
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
			prop.setProperty("CompanyNamr"+i,cdt.getCompanyName());
			
			
			fout = new FileOutputStream(CompanyDAO.PROPFILE);
			prop.store(fout, "Updated on: " + new Date());
			fout.close();
		}else{
			throw new Exception("Insert failed:Record already exists");
		}
		
	}

	
	public T select(T dt) throws Exception {

		CompanyDTO cdt= (CompanyDTO) dt;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(CompanyDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			int i=cdt.getId();

			str = prop.getProperty("id"+cdt.getId());
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

	
	public Collection<T> selectAll() throws Exception {
		 CompanyDTO cdt= new CompanyDTO();
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
						cdt.setId(Integer.parseInt(prop.getProperty("id"+str)));
						cdt.setCompanyID(prop.getProperty("CompanyId"+str));
						cdt.setCompanyName(prop.getProperty("CompanyName"+str));
						arCompanyDTO.add(cdt);
				}
			}			
		return (Collection<T>) arCompanyDTO;
	}


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
