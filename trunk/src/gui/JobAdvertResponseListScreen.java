package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import controller.JobAdvertController;
import dto.ResponseDTO;

public class JobAdvertResponseListScreen extends Panel{

	/**
	 *  <p> <b>JobAdvertResponseListScreen</b> This class handles gui for the job advertiser main window
	 * </p>
	 * @author Saw Nandi
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JobAdvertController jobAdvertController;
	private Button btnView;
	private Button btnClose;
	private int responseid;
	private boolean itemSelectionFlag=false;
	
	/**
	 * Constructor
	 * @param jobAdvertController
	 * @param responseList
	 */	
	public JobAdvertResponseListScreen(JobAdvertController jobAdvertController, ArrayList<ResponseDTO> responseList) 
	{
		this.jobAdvertController = jobAdvertController;		
		init();
	}

	/**
	 * Creating View Button for JobAdvertResponseListScreen
	 */	

	public Button getViewButton(){
		btnView=new Button("View");
		btnView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(itemSelectionFlag==true)
				{
					jobAdvertController.invokeDetailResponseScreen(responseid);
				}
				else
				{
					 new MessageDialog(jobAdvertController.getJobAdvertMainScreen(),"Error","Please select a record.");
				}
			}
		});
		return btnView;
	}

	/**
	 * Creating Close Button for JobAdvertResponseListScreen
	 */	
	public Button getCloseButton(){
		btnClose=new Button("Close");
		btnClose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				closePanel();
			}
		});
		return btnClose;
	}

	/**
	 * initialize the JobAdvertResponseListScreen
	 */
	private void init() 
	{
		Panel pMain=new Panel();
		Panel pTable= new Panel();
		Panel pButton=new Panel();

		/**  
		 * Create GTable and Display all Response records into the JobAdvertListScreen
		 * */
		ScrollPane sc= new ScrollPane();
		ArrayList<ArrayList<String>> data= new ArrayList<ArrayList<String>>(); 
		ArrayList<String> headerdata= new ArrayList<String>(); 
		GTable gt= new GTable();
		ArrayList<String> row = null;

		ResponseDTO jobadvertResponseDTO = null;

		for(int i=0;i<jobAdvertController.getJobAdvertResponseList().size();i++)
		{
			row =  new ArrayList<String>();
			jobadvertResponseDTO = jobAdvertController.getJobAdvertResponseList().get(i);

			row.add( String.valueOf(jobadvertResponseDTO.getId()));
			row.add(jobadvertResponseDTO.getJsName());
			row.add(String.valueOf(jobadvertResponseDTO.getAdvertRefId()));
			row.add("pos frm job advert");

			data.add(row);

		}
		headerdata.add("Response ID");
		headerdata.add(" Candidate Name ");
		headerdata.add(" Job Advert Code ");
		headerdata.add("      Position        ");

		try {
			gt.createGTable(headerdata, data);
		} catch (Exception e1) 
		{
			e1.printStackTrace();
		}
		pButton.add(getViewButton());
		pButton.add(getCloseButton());
		sc.setSize(600, 300);
		sc.add(gt);
		pTable.setSize(800, 300);
		pTable.add(sc);
		pMain.setLayout(new GridLayout(2,1));
		pMain.add(pTable,BorderLayout.NORTH); 
		pMain.add(pButton,BorderLayout.SOUTH); 
		pMain.setSize(900,500);
		pMain.setVisible(true);
		this.add(pMain);
		gt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String cmd=e.getActionCommand();
				if(!(cmd.indexOf("headcell")>-1)) {
					String[] selText= cmd.substring(cmd.indexOf(':')+1).split("~#");
					responseid = Integer.valueOf(selText[0]);					
					itemSelectionFlag = true;
				}
			}
		});

	}
	/**
	 * close the JobAdvertResponseDetail panel
	 */
	private void closePanel() {
		jobAdvertController.removeTitle();
		setVisible(false);
	}
}

