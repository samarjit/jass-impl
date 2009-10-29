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
 * <p> <b>ResponseDAO</b> This class handles the update, delete, insert, select 
 * operations on Response records</p> 
 * @param  T This should be {@link dto.ResponseDTO} object.
 * 
 * @author Justin Jose
 * @version 1.0	28/09/09
 * 
 */

public class ResponseDAO<T> implements PropDAO<ResponseDTO> {
	
	
	/**
	 *  This contains the path of properties file response.properties, where data is stored
	 */
	public static String PROPFILE = "properties/response.properties";
	
	/**
	 * insert one Response record into the Response properties file
	 * @see dao.PropDAO#insert(java.lang.Object)
	 * @exception If insert failed then exception is thrown
	 */

	public   void insert(ResponseDTO dt) throws Exception {
		 ResponseDTO rdt= (ResponseDTO) dt;
		 Properties prop= new Properties();
		 File fprop = new File(ResponseDAO.PROPFILE);
		 FileOutputStream fout = null;
		 if(!fprop.exists()){
			System.out.println("Creating new file");
			 fprop.createNewFile();
		 }
		FileInputStream fin =  new FileInputStream(ResponseDAO.PROPFILE);
		prop.load(fin);
		fin.close();
		String str = "";
		int i=rdt.getId();

		str = prop.getProperty("id"+rdt.getId());
		if(str == null || "".equals(str))
		{
			
			prop.setProperty("id"+i, String.valueOf(rdt.getId()));
			prop.setProperty("jsId"+i, String.valueOf(rdt.getJsId()));
			prop.setProperty("jsName"+i, rdt.getJsName());
			prop.setProperty("jsEmail"+i, rdt.getJsEmail());
			prop.setProperty("jsAddress"+i, rdt.getJsAddress());
			prop.setProperty("jsTelNum"+i, rdt.getJsTelNum());
			prop.setProperty("jsResume"+i, rdt.getJsResume());
			prop.setProperty("advertId"+i, String.valueOf(rdt.getAdvertRefId()));
			
			fout = new FileOutputStream(ResponseDAO.PROPFILE);
			prop.store(fout, "Updated on: " + new Date());
			fout.close();
		}else{
			throw new Exception("Insert failed:Record already exists");
		}
	    
	}

	/**
	 * return one Response record 
	 * @see dao.PropDAO#select(java.lang.Object)
	 * @exception If select failed then exception is thrown
	 */
	public   ResponseDTO select(ResponseDTO dt) throws Exception {
		 ResponseDTO rdt= (ResponseDTO) dt;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(ResponseDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			int i=rdt.getId();
			
			str = prop.getProperty("id"+rdt.getId());
			if(str == null || "".equals(str))
			{
			throw new Exception("Select failed:Record does not exists");
			}else{
			    rdt.setId(Integer.parseInt(prop.getProperty("id"+i)));
			   
			    rdt.setJsId(Integer.parseInt(prop.getProperty("jsId"+i)));
			    rdt.setJsName(prop.getProperty("jsName"+i));
			    rdt.setJsEmail(prop.getProperty("jsEmail"+i));
			    rdt.setJsAddress(prop.getProperty("jsAddress"+i));
			    rdt.setJsTelNum(prop.getProperty("jsTelNum"+i));
			    rdt.setJsResume(prop.getProperty("jsResume"+i));
			    rdt.setAdvertRefId(Integer.parseInt(prop.getProperty("advertId"+i)));
			
			}			 
			return  dt;
	}
		 

	/**
	 * return all the Response records 
	 * @see dao.PropDAO#selectAll()
	 * @exception If selectALL failed then exception is thrown
	 */
	public Collection<ResponseDTO> selectAll() throws Exception {
		 ResponseDTO rdt= null;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(ResponseDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			Set<?> kprop = prop.keySet();			
			Iterator itr = (Iterator)kprop.iterator();
			ArrayList<ResponseDTO> arResponseDTO =  new ArrayList<ResponseDTO>();
			while(itr.hasNext()){
				str =   (String) itr.next();
				if(str !=null && "id".equals(str.substring(0,str.length()-1))){
						str = str.substring(str.length()-1,str.length() );
						rdt= new ResponseDTO();
						rdt.setId(Integer.parseInt(prop.getProperty("id"+str)));
						   
					    rdt.setJsId(Integer.parseInt(prop.getProperty("jsId"+str)));
					    rdt.setJsName(prop.getProperty("jsName"+str));
					    rdt.setJsEmail(prop.getProperty("jsEmail"+str));
					    rdt.setJsAddress(prop.getProperty("jsAddress"+str));
					    rdt.setJsTelNum(prop.getProperty("jsTelNum"+str));
					    rdt.setJsResume(prop.getProperty("jsResume"+str));
					    rdt.setAdvertRefId(Integer.parseInt(prop.getProperty("advertId"+str)));
						arResponseDTO.add(rdt);
				}
			}			
		return (Collection<ResponseDTO>) arResponseDTO;
	}

	/**
	 * update one Response record 
	 * @see dao.PropDAO#update(java.lang.Object)
	 * @exception If update failed then exception is thrown
	 */
	public   void update(ResponseDTO dt) throws Exception {
		 ResponseDTO rdt= (ResponseDTO) dt;
		 Properties prop= new Properties();
		 File fprop = new File(ResponseDAO.PROPFILE);
		 FileOutputStream fout = null;
		 if(!fprop.exists()){
			System.out.println("Creating new file");
			 fprop.createNewFile();
		 }
		FileInputStream fin =  new FileInputStream(ResponseDAO.PROPFILE);
		prop.load(fin);
		fin.close();
		String str = "";
		int i=rdt.getId();

		str = prop.getProperty("id"+rdt.getId());
		if(str == null || "".equals(str))
		{
			throw new Exception("Update failed:Record does not exists");
		}else{

			prop.setProperty("id"+i, String.valueOf(rdt.getId()));
			prop.setProperty("jsId"+i, String.valueOf(rdt.getJsId()));
			prop.setProperty("jsName"+i, rdt.getJsName());
			prop.setProperty("jsEmail"+i, rdt.getJsEmail());
			prop.setProperty("jsAddress"+i, rdt.getJsAddress());
			prop.setProperty("jsTelNum"+i, rdt.getJsTelNum());
			prop.setProperty("jsResume"+i, rdt.getJsResume());
			prop.setProperty("advertId"+i, String.valueOf(rdt.getAdvertRefId()));
			 
			fout = new FileOutputStream(ResponseDAO.PROPFILE);
			prop.store(fout, "Updated on: " + new Date());
			fout.close();
		}
		
	}
	
	/**
	 * return next Response id 
	 * @see dao.PropDAO#getNextId(java.lang.Object)
	 * @exception If getNextId failed then exception is thrown
	 */
	public   int getNextId(ResponseDTO dt) throws IOException{
		 ResponseDTO rdt= (ResponseDTO) dt;
		 Properties prop= new Properties();
		 FileInputStream fin =  new FileInputStream(ResponseDAO.PROPFILE);
			prop.load(fin);
			fin.close();
			String str = "";
			int i=rdt.getId();
			
			do{
			str="";
			str = prop.getProperty("id"+i);
			i++;
			}while(str != null && i <=10000);
			 i--;
			 
			return i;
	}

	/**
	 * delete one Response record 
	 * @see dao.PropDAO#delete(java.lang.Object)
	 * @exception If delete failed then exception is thrown
	 */
	public void delete(ResponseDTO dt) throws Exception {
		 ResponseDTO rdt= (ResponseDTO) dt;
		 Properties prop= new Properties();
		 File fprop = new File(ResponseDAO.PROPFILE);
		 FileOutputStream fout = null;
		 if(!fprop.exists()){
			System.out.println("Creating new file");
			 fprop.createNewFile();
		 }
		FileInputStream fin =  new FileInputStream(ResponseDAO.PROPFILE);
		prop.load(fin);
		fin.close();
		String str = "";
		int i=rdt.getId();

		str = prop.getProperty("id"+rdt.getId());
		if(str == null || "".equals(str))
		{
			throw new Exception("Delete failed:Record does not exists");
		}else{
		
			prop.remove("id"+i);
			prop.remove("jsId"+i);
			prop.remove("jsName"+i);
			prop.remove("jsEmail"+i);
			prop.remove("jsAddress"+i);
			prop.remove("jsTelNum"+i);
			prop.remove("jsResume"+i);
			prop.remove("advertId"+i);
			
			fout = new FileOutputStream(ResponseDAO.PROPFILE);
			prop.store(fout, "deleted rec no:"+i +" on " + new Date());
			fout.close();
		}
		
	}
	
}
