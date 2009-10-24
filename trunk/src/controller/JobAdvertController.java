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


/*
 * <p> <b>JobAdvertController</b> This class controlls all the job 
 * advert related actions. </p> 
 * 
 * 
 * @author Justin Jose
 * @version 1.0	28/09/09
 * 
 */
public class JobAdvertController {

	private JobAdvertiserMainScreen jobadvertMainScreen;
	private ArrayList<ResponseDTO> responseList;
	private ArrayList<JobAdvertDTO> jobAdvertList;

	/**
	 * constructor
	 */
	public JobAdvertController(JobAdvertiserMainScreen jobadvertMainScreen) {
		this.jobadvertMainScreen = jobadvertMainScreen;
		responseList = new ArrayList<ResponseDTO>();
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

		System.out.println("SelId"+selId);
		//Get the selected Response and pass to detail screen for display.
		JobAdvertDTO jobadvert = new JobAdvertDTO();
		jobadvert.setId(selId);
		JobAdvertDAO<JobAdvertDTO> jdao = new JobAdvertDAO<JobAdvertDTO>();
		try {
			jdao.select(jobadvert);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		JobAdvertDetailScreen advertDetailScreen = new JobAdvertDetailScreen(this, jobadvert);
		jobadvertMainScreen.setMainPanel(advertDetailScreen, "Job Advert Detail");
	}

	/**
	 * Disply Add Job Advert List Screen
	 */
	public void invokeJobAdvertListScreen(){
		
		JobAdvertDAO<JobAdvertDTO> alljobadvert= new JobAdvertDAO<JobAdvertDTO>();
		try {
			jobAdvertList=(ArrayList<JobAdvertDTO>)alljobadvert.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JobAdvertListScreen jobAdvertListScreen = new JobAdvertListScreen(this,jobAdvertList);
		jobadvertMainScreen.setMainPanel(jobAdvertListScreen, "Job Advert List");
	}

	/**
	 * Disply Add Job Advert Response List Screen
	 */
	public void invokeResponseListScreen(){
		
		ResponseDAO<ResponseDTO> allresponse= new ResponseDAO<ResponseDTO>();
		try {
			responseList=(ArrayList<ResponseDTO>)allresponse.selectAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
                 	
        JobAdvertResponseListScreen jobAdvertResponseListScreen = new JobAdvertResponseListScreen(this,responseList);
		jobadvertMainScreen.setMainPanel(jobAdvertResponseListScreen, "Job Advert Response List");

	}

	/**
	 * Disply Add Job Advert Response Detail Screen
	 */
	public void invokeDetailResponseScreen(int selId){
		
		System.out.println("SelId"+selId);
		//Get the selected Response and pass to detail screen for display.
		ResponseDTO response = new ResponseDTO();
		response.setId(selId);
		ResponseDAO<ResponseDTO> rdao = new ResponseDAO<ResponseDTO>();
		try {
			rdao.select(response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		JobAdvertResponseDetailScreen jobAdvertResponseDetailScreen = new JobAdvertResponseDetailScreen(this, response);
		jobadvertMainScreen.setMainPanel(jobAdvertResponseDetailScreen, "Job Advert Response Detail");
	}

	
	/**
	 * remove title from jobadvert main screen
	 */
	public void removeTitle(){
		jobadvertMainScreen.removeTitle();
	}
	
	/*public static void main(String[] args) throws Exception {
		 JobAdvertDTO adDTO = new JobAdvertDTO();
		 adDTO.setId(6);
		 adDTO.setAdDesc("Some stupid BPO");
		 adDTO.setCmpnyDesc("Doesnt matter");

		 JobAdvertDAO<JobAdvertDTO> adDAO = new JobAdvertDAO<JobAdvertDTO>();
		 try {
//		 	adDAO.insert(adDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Created a record");

		 JobAdvertDTO searchDTO = new JobAdvertDTO();
		 searchDTO.setId(1);
		 System.out.println(adDAO.select(searchDTO ));


		 System.out.println("Next suitable Id="+adDAO.getNextId(adDTO));

		adDAO.update(adDTO);
		//  adDAO.delete(adDTO);
		 System.out.println(adDAO.selectAll());
	}*/
	
	
	/**
	 * give back reference of Job Advertised main screen
	 * @return JobAdvertiserMainScreen
	 */
	public JobAdvertiserMainScreen getJobAdvertMainScreen(){
		return jobadvertMainScreen;
	}


}
