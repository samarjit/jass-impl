package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.JobAdvertController;
import java.util.ArrayList;


import dto.JobAdvertDTO;
import dto.ResponseDTO;


/**
 * <p> <b>JobAdvertListScreen</b> This class handles the graphical user interface for the JobAdvertListScreen
 * The JobAdvertListScreen displays the list of all the job advertised. The JobAdvertList screen provides options
 * to view, delete, withdraw a particular jobadvert.
 * </p>
 * @author Sarita Singh, Justin Jose
 *
 */

public class JobAdvertListScreen extends Panel{

	private static final long serialVersionUID = 1L;

	private JobAdvertController jobAdvertController;
	private GTable advertGT;
	private ScrollPane scp;
	private int jobid;
	private boolean itemSelectionFlag=false;
	
	
	/**
	 * Constructor
	 * @param jobAdvertController
	 * @param jobAdvertList
	 */	

	public JobAdvertListScreen(JobAdvertController jobAdvertController,ArrayList<JobAdvertDTO> jobAdvertList) {

		this.jobAdvertController = jobAdvertController;
		init();
	}
	
	/**
	 * initialize the jobadvertlistscreen 
	 */	
	private void init() {

		Panel pMain = new Panel();
		Panel pTablePanel= new Panel();
		Panel pButton =new Panel();

		
		 //add the view button for viewing details of a particular  job advert 
		 	
		Button btnview = new Button ("View");
		btnview.setActionCommand("View");
		ActionListener listener =new ActionListener(){
			public void actionPerformed (ActionEvent e){
				if(itemSelectionFlag==true)
				{
					jobAdvertController.invokeJobAdvertDetailScreen(jobid);	
				}
				else
				{
					new MessageDialog(jobAdvertController.getJobAdvertMainScreen(),"Error","Please select a record.");
				}
			}

		};
		btnview.addActionListener(listener);

		pButton.add(btnview);

		
	
		//add the withdraw button for withdrawing the job advert once filled in 
		 				
		pButton.add(getWithDrawBtn());

	
		//add the delete button for deleting  the job advert  
		 	
		pButton.add(getDeleteButton());

	
		//add the close button for closing the JobAdvertListscreen
		 		
		pButton.add(getCloseButton());


		scp= new ScrollPane();		
		scp.setSize(600,450);
		

		pTablePanel.setSize(500,500);
		pTablePanel.add(scp);

		pMain.setLayout(new GridLayout(2,1));
		pMain.add(pTablePanel,BorderLayout.NORTH);
		pMain.setSize(700,500);
		pMain.setVisible(true);
		pMain.add(pButton, BorderLayout.SOUTH);
		this.add(pMain);
		
		
		 // Create the GTable and display the list of all job adverts
		 	
		
		advertGT= new GTable();
		scp.add(advertGT);
		
		advertGT.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String cmd=e.getActionCommand();
				if(!(cmd.indexOf("headcell")>-1)) {
					String[] selText= cmd.substring(cmd.indexOf(':')+1).split("~#");
					jobid = Integer.valueOf(selText[0]);
					System.out.println("JobId"+jobid);
					itemSelectionFlag = true;
				}
			}
		});
		refreshTable();

	}

	/**
	 * Implement the withdraw button
	 * @return the  withdraw button created
	 */
	private Component getWithDrawBtn(){
		Button btnwithdraw =new Button ("WithDraw");
		btnwithdraw.setActionCommand("WithDraw");
		ActionListener listenerx =new ActionListener(){
			public void actionPerformed ( ActionEvent e){
				if(itemSelectionFlag==true)
				{
					jobAdvertController.withdrawJobAdvert(jobid);	
				}
				else
				{
					new MessageDialog(jobAdvertController.getJobAdvertMainScreen(),"Error","Please select a record.");
				}
			}

		};

		btnwithdraw.addActionListener(listenerx);
		return btnwithdraw;
	}
	
	/**
	 * Implement the delete button
	 * @return the delete button created
	 */
	private Component getDeleteButton(){
		Button btndelete = new Button("Delete");
		btndelete.setActionCommand("Delete");
		ActionListener listenery= new ActionListener(){
			public void actionPerformed ( ActionEvent e){
				if(itemSelectionFlag==true)
				{
					jobAdvertController.deleteJobAdvert(jobid);	
				}
				else
				{
					new MessageDialog(jobAdvertController.getJobAdvertMainScreen(),"Error","Please select a record.");
				}
			}
		};		
		btndelete.addActionListener(listenery);		 
		return btndelete;
	}
	
	/**
	 * Implement the close button
	 * @return the close button created
	 */
	
	
	private Component getCloseButton(){
		Button btnclose = new Button("Close");
		btnclose.setActionCommand("Close");
		ActionListener listenerz= new ActionListener(){
			public void actionPerformed ( ActionEvent e){
				closePanel();
			}
		};

		btnclose.addActionListener(listenerz);
		return btnclose;
	}
	
	/**
	 * close the jobadvertListscreen
	 */
	private void closePanel(){
		jobAdvertController.removeTitle();
		setVisible(false);
	}

	/**
	 * refresh the gtable with advertlist values.
	 */
	public void refreshTable(){

		ArrayList<ArrayList<String>> data= new ArrayList<ArrayList<String>>(); 
		ArrayList<String> headerdata= new ArrayList<String>(); 		
		ArrayList<String> row = null;

		JobAdvertDTO jobadvertDTO= null;

		for(int i=0;i<jobAdvertController.getJobAdvertList().size();i++)
		{
			row =  new ArrayList<String>();
			jobadvertDTO = jobAdvertController.getJobAdvertList().get(i);

			row.add(String.valueOf(jobadvertDTO.getId()));
			row.add(jobadvertDTO.getJobtitle());
			row.add(String.valueOf(jobadvertDTO.getJobdesc()));
			row.add(String.valueOf(jobadvertDTO.getTechskills()));
			row.add(String.valueOf(jobadvertDTO.getNoyrexp()));
			row.add(String.valueOf(jobadvertDTO.getLocation()));
			row.add(String.valueOf(jobadvertDTO.getStatus()));
			data.add(row);
		}

		headerdata.add("Job Id");
		headerdata.add("Job Title");
		headerdata.add("Job Description");
		headerdata.add("Tech Skills");
		headerdata.add("Experience(yrs)");
		headerdata.add("Location");		
		headerdata.add("Status");

		try{
			advertGT.setCurY(0);
			advertGT.createGTable(headerdata,data);
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		itemSelectionFlag = false;
	}

}

