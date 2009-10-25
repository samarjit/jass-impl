package controller;

import gui.JobAdvertiserMainScreen;
import dao.*;
import dto.*;


/**
 * <p> <b>MainController</b> controls the full application. 
 * This is the entry point to the system </p> 
 * 
 * 
 * @author Justin Jose
 * @version 1.0	28/09/09  created 
 * 
 */

public class MainController {


	private JobAdvertiserMainScreen jobadvertMainScreen;
	private JobAdvertController jobAdvertController;
	private UserAuthDTO userRec;

	private static int USER_ID = 1;
	/**
	 * <p> Constructor which creates MainController <p>
	 * 
	 */
	public MainController() {
		jobadvertMainScreen = new JobAdvertiserMainScreen(this);
		jobAdvertController = new JobAdvertController(jobadvertMainScreen, this);
		userRec = new UserAuthDTO();		
	}

	/**
	 * Application entry point
	 */
	public void start() {		
		invokeJobAdvertiserMainScreen();
		UserAuthDAO<UserAuthDTO> udao= new UserAuthDAO<UserAuthDTO>();
		userRec.setId(USER_ID);
		try {
			userRec = udao.select(userRec);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/**
	 * gets the login user authentication
	 * @return user authentication details
	 */
	public UserAuthDTO getUserAuth(){
		return userRec;
	}
	
	/**
	 * To display JobAdverMainScreen
	 */
	public void invokeJobAdvertiserMainScreen() {				
		jobadvertMainScreen.setVisible(true);
	}


	/**
	 * To close JobAdvertMainScreen
	 */
	public void closeJobAdvertMainScreen() {
		jobadvertMainScreen.dispose();
		jobadvertMainScreen.setVisible(false);
	}

	/**
	 * Display the screen based on the parameter
	 * @param screenName
	 */
	public void showWindow(String screenName) {

		if(screenName.equals("AddJobAdvertScreen")){
			jobAdvertController.invokeAddJobAdvertScreen();			
		}
		if(screenName.equals("AdvertListScreen"))
		{			
			jobAdvertController.invokeJobAdvertListScreen();
		}
		if(screenName.equals("ResponseListScreen")){
			jobAdvertController.invokeResponseListScreen();
		}
	}

	/**
	 * Main method
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		MainController mainController = new MainController();
		mainController.start();		
	}

}
