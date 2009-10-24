package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.JobAdvertController;
import dto.JobAdvertDTO;

public class JobAdvertDetailScreen extends Panel{
	
	private static final long serialVersionUID = 1L;

	private JobAdvertDTO jobadvert;
	private JobAdvertController jobAdvertController;
	
	public JobAdvertDetailScreen(JobAdvertController jobAdvertController,JobAdvertDTO jobadvertdetail) {
		this.jobAdvertController = jobAdvertController;
		this.jobadvert=jobadvertdetail;
		init();
	}
	
	/**
	 * initialize the jobadvertdetail screen
	 */	
	private void init() {		
        Panel addAdvertPanel = new Panel(new BorderLayout());
		addAdvertPanel.add(getMainPanel(),"North");
		addAdvertPanel.add(getButtonPanel(),"Center");
		add(addAdvertPanel);
		
	}
	
	/**
	 * Creating the button panel for the job advert detail screen
	 * @return
	 */
	private Component getButtonPanel() {
		Panel btPanel = new Panel();
		btPanel.add(getCloseButton());					
		return btPanel;
	}

	/**
	 * create the main panel for response detail screen
	 * @return
	 */	
	private Component getMainPanel() {
		
		Panel mainPanel = new Panel(new GridLayout(2,2));
		
		Panel detailsPanel = new Panel(new GridLayout(7,2));				
		detailsPanel.add(new Label("Job Id"));
		TextField jobIdTxt = new TextField(10);
		jobIdTxt.setEditable(false);		
		jobIdTxt.setText(Integer.toString(jobadvert.getId()));		
		detailsPanel.add(jobIdTxt);
		
		detailsPanel.add(new Label("Job Title"));		
		TextField advertTitle = new TextField(10);	
		advertTitle.setEditable(false);
		advertTitle.setText(jobadvert.getJobtitle());		
		detailsPanel.add(advertTitle);
		
		detailsPanel.add(new Label("Job Description"));		
		TextField jobTDesc = new TextField(10);				
		jobTDesc.setText(jobadvert.getJobdesc());		
		detailsPanel.add(jobTDesc);
		
		/*		
		detailsPanel.add(new Label("Email"));
		TextField EmailTText = new TextField(10);
		EmailTText.setEditable(false);
		EmailTText.setText(response.getJsEmail());		
		detailsPanel.add(EmailTText);
		
		detailsPanel.add(new Label("Tel"));
		TextField telText = new TextField(10);
		telText.setEditable(false);
		telText.setText(response.getJsTelNum());		
		detailsPanel.add(telText);
		
		Panel textPanel = new Panel(new GridLayout(2,2));
		
		textPanel.add(new Label("Address"));		
		TextArea addressText =new TextArea("",3,20,TextArea.SCROLLBARS_BOTH);
		addressText.setEditable(false);
		addressText.setText(response.getJsAddress());		
		textPanel.add(addressText);
		
		textPanel.add(new Label("Resume"));
		TextArea resumeText =new TextArea("",3,20,TextArea.SCROLLBARS_BOTH);
		resumeText.setEditable(false);
		resumeText.setText(response.getJsResume());		
		textPanel.add(resumeText);
		*/
		
		mainPanel.add(detailsPanel);
		//mainPanel.add(textPanel);
		
		return mainPanel;
	}

	/**
	 * create button panel with buttons
	 * @return
	 */
	private Component getCloseButton() {
		Button btn = new Button("Close");
		ActionListener listner = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				closePanel();
			}
		};
		btn.addActionListener(listner);
		return btn;		
	}

	/**
	 * close the JobAdvertResponseDetail panel
	 */
	private void closePanel() {
		jobAdvertController.removeTitle();
		setVisible(false);
	}
	
}
