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


/**
 * <p><b>JobAdvertDAO</b> is data access object for accessing the jobadvert properties file and 
 * maintaining JobAdvert related records.</p>
 * @author Samarjit Samanta
 * @param <JobAdvertDTO>
 */
public class JobAdvertDAO<T> implements PropDAO<T>{
	
	public static String PROPFILE = "properties/jobadvert.properties";
	/**
	 * Inserts JobAdvert to properties
	 * @see dao.PropDAO#insert(java.lang.Object)
	 * @exception If insert failed then exception is thrown
	 */
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
			prop.setProperty("cmpnyDesc"+i, jdt.getCmpnyDesc());
			prop.setProperty("jobrefcode"+i,jdt.getJobrefcode());
			prop.setProperty("cmpname"+i, jdt.getCmpname());
			prop.setProperty("department"+i, jdt.getDepartment());
			prop.setProperty("jobtitle"+i, jdt.getJobtitle());
			prop.setProperty("jobdesc"+i, jdt.getJobdesc());
			prop.setProperty("techskills"+i, jdt.getTechskills());
			prop.setProperty("mgmtskills"+i, jdt.getMgmtskills());
			prop.setProperty("noyrexp"+i, jdt.getNoyrexp());
			prop.setProperty("salaryrange"+i, jdt.getSalaryrange());
			prop.setProperty("startdate"+i, jdt.getStartdate());
			prop.setProperty("location"+i, jdt.getLocation());
			prop.setProperty("advertizerref"+i, jdt.getAdvertizerref());
			
			 
			fout = new FileOutputStream(JobAdvertDAO.PROPFILE);
			prop.store(fout, "Updated on: " + new Date());
			fout.close();
		}else{
			throw new Exception("Insert failed:Record already exists");
		}
	    
	}
	/**
	 * Select a JobAdvert object from properties
	 * @see dao.PropDAO#select(java.lang.Object)
	 * @exception If no record exists then select throws an exception
	 */
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
			    jdt.setCmpnyDesc(prop.getProperty("cmpnyDesc"+i));
			    jdt.setJobrefcode(prop.getProperty("jobrefcode"+i));
			    jdt.setCmpname(prop.getProperty("cmpname"+i));
			    jdt.setDepartment(prop.getProperty("department"+i));
			    jdt.setJobtitle(prop.getProperty("jobtitle"+i));
			    jdt.setJobdesc(prop.getProperty("jobdesc"+i));
			    jdt.setTechskills(prop.getProperty("techskills"+i));
			    jdt.setMgmtskills(prop.getProperty("mgmtskills"+i));
			    jdt.setNoyrexp(prop.getProperty("noyrexp"+i));
			    jdt.setSalaryrange(prop.getProperty("salaryrange"+i));
			    jdt.setStartdate(prop.getProperty("startdate"+i));
			    jdt.setLocation(prop.getProperty("location"+i));
			    jdt.setAdvertizerref(prop.getProperty("advertizerref"+i));
			}
			 
			return  dt;
	}
		 
	/**
	 * Select all JobAdvert objects from properties
	 * @see dao.PropDAO#selectAll(java.lang.Object)
	 */
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
						jdt.setCmpnyDesc(prop.getProperty("cmpnydesc"+str));
						jdt.setCmpnyDesc(prop.getProperty("cmpnyDesc"+str));
					    jdt.setJobrefcode(prop.getProperty("jobrefcode"+str));
					    jdt.setCmpname(prop.getProperty("cmpname"+str));
					    jdt.setDepartment(prop.getProperty("department"+str));
					    jdt.setJobtitle(prop.getProperty("jobtitle"+str));
					    jdt.setJobdesc(prop.getProperty("jobdesc"+str));
					    jdt.setTechskills(prop.getProperty("techskills"+str));
					    jdt.setMgmtskills(prop.getProperty("mgmtskills"+str));
					    jdt.setNoyrexp(prop.getProperty("noyrexp"+str));
					    jdt.setSalaryrange(prop.getProperty("salaryrange"+str));
					    jdt.setStartdate(prop.getProperty("startdate"+str));
					    jdt.setLocation(prop.getProperty("location"+str));
					    jdt.setAdvertizerref(prop.getProperty("advertizerref"+str));
						arJobadvertDTO.add(jdt);
				}
			}
			
			 
			 
		return (Collection<T>) arJobadvertDTO;
	}

	/**
	 * Updates a JobAdvert object from properties
	 * @see dao.PropDAO#update(java.lang.Object)
	 * @exception If update fails it throws an exception
	 */
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
			prop.setProperty("cmpnyDesc"+i, jdt.getCmpnyDesc());
			prop.setProperty("jobrefcode"+i,jdt.getJobrefcode());
			prop.setProperty("cmpname"+i, jdt.getCmpname());
			prop.setProperty("department"+i, jdt.getDepartment());
			prop.setProperty("jobtitle"+i, jdt.getJobtitle());
			prop.setProperty("jobdesc"+i, jdt.getJobdesc());
			prop.setProperty("techskills"+i, jdt.getTechskills());
			prop.setProperty("mgmtskills"+i, jdt.getMgmtskills());
			prop.setProperty("noyrexp"+i, jdt.getNoyrexp());
			prop.setProperty("salaryrange"+i, jdt.getSalaryrange());
			prop.setProperty("startdate"+i, jdt.getStartdate());
			prop.setProperty("location"+i, jdt.getLocation());
			prop.setProperty("advertizerref"+i, jdt.getAdvertizerref());
			 
			fout = new FileOutputStream(JobAdvertDAO.PROPFILE);
			prop.store(fout, "Updated on: " + new Date());
			fout.close();
		}
		
	}
	
	
	/** 
	 * Gets the next suitable Id that can be used for insertion of a new record. Its non conventional 
	 * of a database system so it is not derived from interface.
	 * @see dao.PropDAO#getNextId(java.lang.Object)
	 */
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

	/** 
	 * Deletes a job advert object given a dummy job advert object which matched the original job 
	 * advert id.
	 * @see dao.PropDAO#delete(java.lang.Object)
	 */
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
			prop.remove("cmpnyDesc"+i) ;
			prop.remove("jobrefcode"+i) ;
			prop.remove("cmpname"+i) ;
			prop.remove("department"+i) ;
			prop.remove("jobtitle"+i) ;
			prop.remove("jobdesc"+i) ;
			prop.remove("techskills"+i) ;
			prop.remove("mgmtskills"+i) ;
			prop.remove("noyrexp"+i) ;
			prop.remove("salaryrange"+i) ;
			prop.remove("startdate"+i) ;
			prop.remove("location"+i) ;
			prop.remove("advertizerref"+i) ;
			fout = new FileOutputStream(JobAdvertDAO.PROPFILE);
			prop.store(fout, "deleted rec no:"+i +" on " + new Date());
			fout.close();
		}
		
	}
	 
	


}
