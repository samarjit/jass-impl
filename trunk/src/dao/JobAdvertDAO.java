package dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import dto.*;


public class JobAdvertDAO<T> implements PropDAO<T>{
	
	public static String PROPFILE = "properties/jobadvert.properties";
	public   void insert(T dt) throws Exception {
		 JobAdvertDTO jdt= (JobAdvertDTO) dt;
		 Properties prop= new Properties();
		 File fprop = new File(JobAdvertDAO.PROPFILE);
		 FileOutputStream fout = null;
		 if(!fprop.exists()){
			System.out.println("Creating new file");
			 fprop.createNewFile();
		 }
		FileInputStream fin =  new FileInputStream(JobAdvertDAO.PROPFILE);
		prop.load(fin);
		fin.close();
		String str = "";
		int i=jdt.getId();

		str = prop.getProperty("id"+jdt.getId());
		if(str == null || "".equals(str))
		{
			
			prop.setProperty("id"+i, String.valueOf(jdt.getId()));
			prop.setProperty("addesc"+i, jdt.getAdDesc());
			prop.setProperty("cmpnydesc"+i, jdt.getCmpnyDesc());
			 
			fout = new FileOutputStream(JobAdvertDAO.PROPFILE);
			prop.store(fout, "Updated on: " + new Date());
			fout.close();
		}else{
			throw new Exception("Insert failed:Record already exists");
		}
	    
	}

	public   T select(T  dt) throws Exception {
		 JobAdvertDTO jdt=  (JobAdvertDTO)  dt;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(JobAdvertDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			int i=jdt.getId();
			
			str = prop.getProperty("id"+jdt.getId());
			if(str == null || "".equals(str))
			{
			throw new Exception("Select failed:Record does not exists");
			}else{
			    jdt.setId(Integer.parseInt(prop.getProperty("id"+i)));
				jdt.setAdDesc(prop.getProperty("addesc"+i));
				jdt.setCmpnyDesc(prop.getProperty("cmpnydesc"+i));
			}
			 
			return  dt;
	}
		 

	public Collection<T> selectAll() throws Exception {
		 JobAdvertDTO jdt= null;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(JobAdvertDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			Set<?> kprop = prop.keySet();			
			Iterator<String> itr = (Iterator<String>)kprop.iterator();
			ArrayList<JobAdvertDTO> arJobadvertDTO =  new ArrayList<JobAdvertDTO>();
			while(itr.hasNext()){
				str =   itr.next();
				if(str !=null && "id".equals(str.substring(0,str.length()-1))){
						str = str.substring(str.length()-1,str.length() );
						jdt= new JobAdvertDTO();
						jdt.setId(Integer.parseInt(prop.getProperty("id"+str)));
						jdt.setAdDesc(prop.getProperty("addesc"+str));
						jdt.setCmpnyDesc(prop.getProperty("cmpnydesc"+str));
						arJobadvertDTO.add(jdt);
				}
			}
			
			 
			 
		return (Collection<T>) arJobadvertDTO;
	}

	public   void update(T dt) throws Exception {
		 JobAdvertDTO jdt= (JobAdvertDTO) dt;
		 Properties prop= new Properties();
		 File fprop = new File(JobAdvertDAO.PROPFILE);
		 FileOutputStream fout = null;
		 if(!fprop.exists()){
			System.out.println("Creating new file");
			 fprop.createNewFile();
		 }
		FileInputStream fin =  new FileInputStream(JobAdvertDAO.PROPFILE);
		prop.load(fin);
		fin.close();
		String str = "";
		int i=jdt.getId();

		str = prop.getProperty("id"+jdt.getId());
		if(str == null || "".equals(str))
		{
			throw new Exception("Update failed:Record does not exists");
		}else{

			prop.setProperty("id"+i, String.valueOf(jdt.getId()));
			prop.setProperty("addesc"+i, jdt.getAdDesc());
			prop.setProperty("cmpnydesc"+i, jdt.getCmpnyDesc());
			 
			fout = new FileOutputStream(JobAdvertDAO.PROPFILE);
			prop.store(fout, "Updated on: " + new Date());
			fout.close();
		}
		
	}
	
	public   int getNextId(T dt) throws IOException{
		 JobAdvertDTO jdt= (JobAdvertDTO) dt;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(JobAdvertDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			int i=jdt.getId();
			
			do{
			str="";
			str = prop.getProperty("id"+i);
			i++;
			}while(str != null && i <=10000);
			 i--;
			 
			return i;
	}

	public void delete(T dt) throws Exception {
		 JobAdvertDTO jdt= (JobAdvertDTO) dt;
		 Properties prop= new Properties();
		 File fprop = new File(JobAdvertDAO.PROPFILE);
		 FileOutputStream fout = null;
		 if(!fprop.exists()){
			System.out.println("Creating new file");
			 fprop.createNewFile();
		 }
		FileInputStream fin =  new FileInputStream(JobAdvertDAO.PROPFILE);
		prop.load(fin);
		fin.close();
		String str = "";
		int i=jdt.getId();

		str = prop.getProperty("id"+jdt.getId());
		if(str == null || "".equals(str))
		{
			throw new Exception("Delete failed:Record does not exists");
		}else{

//			prop.setProperty("id"+i, String.valueOf(jdt.getId()));
//			prop.setProperty("addesc"+i, jdt.getAdDesc());
//			prop.setProperty("cmpnydesc"+i, jdt.getCmpnyDesc());
			prop.remove("id"+i) ;
			prop.remove("addesc"+i) ;
			prop.remove("cmpnydesc"+i) ;
			fout = new FileOutputStream(JobAdvertDAO.PROPFILE);
			prop.store(fout, "deleted rec no:"+i +" on " + new Date());
			fout.close();
		}
		
	}
	 
	


}
