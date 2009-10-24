package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.JobAdvertController;
import java.util.ArrayList;


import dto.JobAdvertDTO;
import dto.ResponseDTO;




public class JobAdvertListScreen extends Panel{

	private static final long serialVersionUID = 1L;

	private JobAdvertController jobAdvertController;

	private ArrayList<JobAdvertDTO> alljobadvertList;
	private int jobid;
	private boolean itemSelectionFlag=false;

	public JobAdvertListScreen(JobAdvertController jobAdvertController,ArrayList<JobAdvertDTO> jobAdvertList) {

		this.jobAdvertController = jobAdvertController;
		this.alljobadvertList=(ArrayList<JobAdvertDTO>)jobAdvertList;
		init();
	}
	private void init() {

		Panel pMain = new Panel();
		Panel pTable= new Panel();
		Panel pButton =new Panel();

		// adding the view button
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


		// adding the withdraw button
		Button btnwithdraw =new Button ("WithDraw");
		btnwithdraw.setActionCommand("WithDraw");
		ActionListener listenerx =new ActionListener(){
			public void actionPerformed ( ActionEvent e){
				System.exit(0);
			}
		};

		btnwithdraw.addActionListener(listenerx);

		pButton.add(btnwithdraw);

		// adding the delete button
		Button btndelete = new Button("Delete");
		btndelete.setActionCommand("Delete");
		ActionListener listenery= new ActionListener(){
			public void actionPerformed ( ActionEvent e){
				System.exit(0);
			}
		};		
		btndelete.addActionListener(listenery);		 
		pButton.add(btndelete);

		// adding the close button
		Button btnclose = new Button("Close");
		btnclose.setActionCommand("Close");
		ActionListener listenerz= new ActionListener(){
			public void actionPerformed ( ActionEvent e){
				closePanel();
			}
		};

		btnclose.addActionListener(listenerz);

		pButton.add(btnclose);

		ScrollPane scr= new ScrollPane();
		ArrayList<ArrayList<String>> data= new ArrayList<ArrayList<String>>(); 
		ArrayList<String> headerdata= new ArrayList<String>(); 
		
		GTable gt= new GTable();
		ArrayList<String> row = null;

		JobAdvertDTO jobadvertDTO= null;


		for(int i=0;i<alljobadvertList.size();i++)
		{
			row =  new ArrayList<String>();
			jobadvertDTO = alljobadvertList.get(i);

			row.add(String.valueOf(jobadvertDTO.getId()));
			row.add(jobadvertDTO.getJobtitle());
			row.add(String.valueOf(jobadvertDTO.getJobdesc()));


			row.add(String.valueOf(jobadvertDTO.getMgmtskills()));
			row.add(String.valueOf(jobadvertDTO.getTechskills()));
			row.add(String.valueOf(jobadvertDTO.getNoyrexp()));
			row.add(String.valueOf(jobadvertDTO.getSalaryrange()));

			row.add(String.valueOf(jobadvertDTO.getStartdate()));
			row.add(String.valueOf(jobadvertDTO.getLocation()));
			row.add(String.valueOf(jobadvertDTO.getCmpname()));
			row.add(String.valueOf(jobadvertDTO.getCmpnyDesc()));
			row.add(String.valueOf(jobadvertDTO.getStatus()));
			data.add(row);

		}

		headerdata.add("Job Id");
		headerdata.add("Job Title");
		headerdata.add("Job Description");
		headerdata.add("Management Skills");
		headerdata.add("Technical Skills");
		headerdata.add("Number of years of experience");
		headerdata.add("Salary Range");
		headerdata.add("Required Start Date");
		headerdata.add("Location");		
		headerdata.add("Company Name");
		headerdata.add("Company Description");
		headerdata.add("Status");

		try{
			gt.createGTable(headerdata,data);
		}catch(Exception e1){
			e1.printStackTrace();
		}

		scr.add(gt);
		scr.setSize(300,300);
		pTable.setSize(500,500);
		pTable.add(scr);
		pMain.setLayout(new GridLayout(2,1));
		pMain.add(pTable,BorderLayout.NORTH);
		pMain.setSize(700,500);
		pMain.setVisible(true);
		pMain.add(pButton, BorderLayout.SOUTH);
		this.add(pMain);
		gt.addActionListener(new ActionListener(){
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

	}

	//close the jobadvertListscreen
	private void closePanel(){
		jobAdvertController.removeTitle();
		setVisible(false);
	}	

}

