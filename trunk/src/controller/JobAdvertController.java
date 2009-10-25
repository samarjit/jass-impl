package controller;

import java.util.ArrayList;

import dao.ResponseDAO;
import dto.JobAdvertDTO;
import dto.ResponseDTO;
import dao.JobAdvertDAO;

import gui.AddJobAdvertScreen;
import gui.JobAdvertDetailScreen;
import gui.JobAdvertListScreen;
import gui.JobAdvertResponseDetailScreen;
import gui.JobAdvertResponseListScreen;
import gui.JobAdvertiserMainScreen;
import gui.MessageDialog;


/**
 * <p> <b>JobAdvertController</b> This class controlls all the job 
 * advert related actions such as show list of adverts, view advert details,
 * delete, modify,withdraw job adverts. </p> 
 * 
 * 
 * @author Justin Jose
 * @version 1.0	28/09/09
 * 
 */
public class JobAdvertController {

	private JobAdvertiserMainScreen jobadvertMainScreen;
	private JobAdvertDetailScreen advertDetailScreen;
	private JobAdvertResponseDetailScreen jobAdvertResponseDetailScreen;
	private JobAdvertResponseListScreen jobAdvertResponseListScreen;
	private JobAdvertListScreen jobAdvertListScreen;
	private MainController mainController;
	private ArrayList<ResponseDTO> responseList;
	private ArrayList<JobAdvertDTO> jobAdvertList;

	/**
	 * constructor
	 */
	public JobAdvertController(JobAdvertiserMainScreen jobadvertMainScreen, MainController mainController) {
		this.jobadvertMainScreen = jobadvertMainScreen;
		this.mainController = mainController;
		responseList = new ArrayList<ResponseDTO>();
		jobAdvertList = new ArrayList<JobAdvertDTO>();		
		updateResponseList();
		updateJobAdvertList();		
	}


	/**
	 * Disply Add Job Advert Screen
	 */
	public void invokeAddJobAdvertScreen(){
		AddJobAdvertScreen addjobScreen = new AddJobAdvertScreen(this);
		jobadvertMainScreen.setMainPanel(addjobScreen, "Add Job Advert");
	}

	/**
	 * Disply Add Job Advert Detail Screen
	 */
	public void invokeJobAdvertDetailScreen(int selId){

		//Get the selected Response and pass to detail screen for display.
		JobAdvertDTO jobadvert = new JobAdvertDTO();
		jobadvert.setId(selId);
		JobAdvertDAO<JobAdvertDTO> jdao = new JobAdvertDAO<JobAdvertDTO>();
		try {
			jdao.select(jobadvert);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		advertDetailScreen = new JobAdvertDetailScreen(this, jobadvert);
		jobadvertMainScreen.setMainPanel(advertDetailScreen, "Job Advert Detail");
	}

	/**
	 * Disply Add Job Advert List Screen
	 */
	public void invokeJobAdvertListScreen(){
		jobAdvertListScreen = new JobAdvertListScreen(this,jobAdvertList);
		jobadvertMainScreen.setMainPanel(jobAdvertListScreen, "Job Advert List");		
	}

	/**
	 * update the jobadvert list from property file. This list contains only new and filled job adverts
	 */
	private void updateJobAdvertList() {
		ArrayList<JobAdvertDTO> templist = null;
		jobAdvertList.clear();
		JobAdvertDAO<JobAdvertDTO> alljobadvert= new JobAdvertDAO<JobAdvertDTO>();
		try {
			templist = (ArrayList<JobAdvertDTO>)alljobadvert.selectAll();					
		} catch (Exception e) {
			e.printStackTrace();
		}	
		for(JobAdvertDTO jdto: templist){
			if(jdto.getStatus().equals(JobAdvertDTO.STATUS_NEW) || jdto.getStatus().equals(JobAdvertDTO.STATUS_FILLED)){
				jobAdvertList.add(jdto);
			}				
		}
	}


	/**
	 * Disply Add Job Advert Response List Screen
	 */
	public void invokeResponseListScreen(){
		jobAdvertResponseListScreen = new JobAdvertResponseListScreen(this,responseList);
		jobadvertMainScreen.setMainPanel(jobAdvertResponseListScreen, "Job Advert Response List");
	}

	/**
	 * update the Response list from property file
	 */
	private void updateResponseList() {
		ResponseDAO<ResponseDTO> allresponse= new ResponseDAO<ResponseDTO>();
		try {
			responseList=(ArrayList<ResponseDTO>)allresponse.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	/**
	 * Disply Add Job Advert Response Detail Screen
	 */
	public void invokeDetailResponseScreen(int selId){
		
		//Get the selected Response and pass to detail screen for display.
		ResponseDTO response = new ResponseDTO();
		response.setId(selId);
		ResponseDAO<ResponseDTO> rdao = new ResponseDAO<ResponseDTO>();
		try {
			rdao.select(response);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		jobAdvertResponseDetailScreen = new JobAdvertResponseDetailScreen(this, response);
		jobadvertMainScreen.setMainPanel(jobAdvertResponseDetailScreen, "Job Advert Response Detail");
	}

	
	/**
	 * remove title from jobadvert main screen
	 */
	public void removeTitle(){
		jobadvertMainScreen.removeTitle();
	}
	
	
	
	/**
	 * give back reference of Job Advertised main screen
	 * @return JobAdvertiserMainScreen
	 */
	public JobAdvertiserMainScreen getJobAdvertMainScreen(){
		return jobadvertMainScreen;
	}

	
	/**
	 * modify jobadvert details
	 */
	public void processModify(){
		String id = advertDetailScreen.getJobIdTxt().getText();
		String title = advertDetailScreen.getAdvertTitleTxt().getText();
		String desc = advertDetailScreen.getJobTDescTxt().getText();
		String owner = advertDetailScreen.getJobAdvertiserTxt().getText();
		String jobrefcode = advertDetailScreen.getJobrefcodeTxt().getText();
		String cmpname = advertDetailScreen.getCmpnameTxt().getText();
		String  cmpDesc= advertDetailScreen.getCmpnyDescTxt().getText();		
		String department = advertDetailScreen.getDepartmentTxt().getText();
		String techskills = advertDetailScreen.getTechskillsTxt().getText();
		String mgmtskills = advertDetailScreen.getMgmtSkillsTxt().getText();
		String salary = advertDetailScreen.getSalaryrangeTxt().getText();
		String yrsExp = advertDetailScreen.getNoyrexpTxt().getText();
		String startdate = advertDetailScreen.getStartdateTxt().getText();
		String status = advertDetailScreen.getStatusTxt().getText();
		String location = advertDetailScreen.getLocationTxt().getText();
		
		
		System.out.println("id= " +id +", title=" + title +", desc =" + desc);
		
		JobAdvertDAO<JobAdvertDTO> jdao= new JobAdvertDAO<JobAdvertDTO>();
		JobAdvertDTO jdto = new JobAdvertDTO();
		jdto.setId(Integer.parseInt(id));
		jdto.setJobtitle(title);
		jdto.setJobdesc(desc);
		jdto.setAdvertizerref(owner);
		jdto.setCmpname(cmpname);
		jdto.setCmpnyDesc(cmpDesc);
		jdto.setDepartment(department);
		jdto.setStatus(status);
		jdto.setLocation(location);
		jdto.setSalaryrange(salary);
		jdto.setStartdate(startdate);
		jdto.setTechskills(techskills);
		jdto.setMgmtskills(mgmtskills);
		jdto.setJobrefcode(jobrefcode);
		jdto.setNoyrexp(yrsExp);
		
		if(isOwner(owner)){
			try {
				jdao.update(jdto);
			} catch (Exception e) {
				System.out.println("exception in select job advert dto");
				e.printStackTrace();
			}
			new MessageDialog(jobadvertMainScreen,"Success","Record updated successfully");
			updateJobAdvertList();
			jobAdvertListScreen.refreshTable();
		}
		else
		{
			new MessageDialog(jobadvertMainScreen,"Error","owner does not match");
			invokeJobAdvertListScreen();
		}
		
	}
	
	/**
	 * delete the job advert from the list means mark the status as obsolete.
	 */
	public void deleteJobAdvert(int selId){
		JobAdvertDAO<JobAdvertDTO> jdao= new JobAdvertDAO<JobAdvertDTO>();
		JobAdvertDTO jdto = new JobAdvertDTO();
		jdto.setId(selId);
		try {
			jdto = jdao.select(jdto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String owner = jdto.getAdvertizerref();
		if(isOwner(owner)){
			jdto.setStatus(JobAdvertDTO.STATUS_OBSOLETE);
			try {
				jdao.update(jdto);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			new MessageDialog(jobadvertMainScreen,"Success","Record deleted successfully");
			updateJobAdvertList();
			jobAdvertListScreen.refreshTable();
		}
		else
		{
			new MessageDialog(jobadvertMainScreen,"Error","owner does not match");			
		}		
	}
	
	
	/**
	 * withdraw the job advert from the list means mark the status as obsolete.
	 */
	public void withdrawJobAdvert(int selId){
		
		JobAdvertDAO<JobAdvertDTO> jdao= new JobAdvertDAO<JobAdvertDTO>();
		JobAdvertDTO jdto = new JobAdvertDTO();
		jdto.setId(selId);
		try {
			jdto = jdao.select(jdto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String owner = jdto.getAdvertizerref();
		String status = jdto.getStatus();
		if(isOwner(owner) && status.equals(JobAdvertDTO.STATUS_FILLED)){
			jdto.setStatus(JobAdvertDTO.STATUS_WITHDRAWN);
			try {
				jdao.update(jdto);
			} catch (Exception e) {			
				e.printStackTrace();
			}
			new MessageDialog(jobadvertMainScreen,"Success","Record withdrawn successfully");
			updateJobAdvertList();
			jobAdvertListScreen.refreshTable();
		}
		else
		{
			new MessageDialog(jobadvertMainScreen,"Error","position has not yet filled");			
		}		
	}
	
	
	/**
	 * check the owner is same as the logged in user.
	 * @param owner
	 * @return
	 */
	private boolean isOwner(String owner){
		boolean ownership = false;
		if(mainController.getUserAuth().getUserID().equals(owner))
			ownership =  true;
		else
			ownership = false;
		return ownership;
	}
	
	/**
	 * get the jobadvert title from advertiser reference id
	 * @param advertRefId
	 * @return
	 */
	public String getJobAdvertTitle(int advertRefId){
		JobAdvertDTO jdto = new JobAdvertDTO();
		JobAdvertDAO<JobAdvertDTO> jdao= new JobAdvertDAO<JobAdvertDTO>();
		jdto.setId(advertRefId);
		try {
			jdto = jdao.select(jdto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jdto.getJobtitle();
	}
	
	/**
	 * get list of job adverts
	 * @return jobadvertList
	 */
	public ArrayList<JobAdvertDTO> getJobAdvertList(){
		return jobAdvertList;
	}
	
	/**
	 * get list of job response
	 * @return jobadvertList
	 */
	public ArrayList<ResponseDTO> getJobAdvertResponseList(){
		return responseList;
	}
	
}