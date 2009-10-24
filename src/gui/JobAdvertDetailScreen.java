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
	
	private TextField jobIdTxt;
	private TextField advertTitle;
	private TextField jobTDesc;
	

	private TextField jobAdvertiserTxt;
	private TextField cmpnameTxt;
	private TextField jobrefcodeTxt;
	private TextField cmpnyDescTxt;
	private TextField mgmtSkillsTxt;
	private TextField salaryrangeTxt;

	private TextField techskillsTxt;
	private TextField statusTxt;
	private TextField locationTxt;
	private TextField noyrexpTxt;
	private TextField departmentTxt;
	private TextField startdateTxt;
	
	
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
		btPanel.add(getModifyButton());
		btPanel.add(getSaveButton());
		return btPanel;
	}

	/**
	 * create the main panel for response detail screen
	 * @return
	 */	
	private Component getMainPanel() {
		
		Panel mainPanel = new Panel(new GridLayout(15,2));				
		mainPanel.add(new Label("Job Id"));
		jobIdTxt = new TextField(10);
		jobIdTxt.setEditable(false);		
		jobIdTxt.setText(Integer.toString(jobadvert.getId()));		
		mainPanel.add(jobIdTxt);
		
		mainPanel.add(new Label("Job Title"));		
		advertTitle = new TextField(10);	
		advertTitle.setEditable(false);
		advertTitle.setText(jobadvert.getJobtitle());		
		mainPanel.add(advertTitle);
		
		mainPanel.add(new Label("Job Description"));		
		jobTDesc = new TextField(10);		
		jobTDesc.setEditable(false);
		jobTDesc.setText(jobadvert.getJobdesc());		
		mainPanel.add(jobTDesc);
		
		mainPanel.add(new Label("Company Name"));		
		cmpnameTxt = new TextField(10);		
		cmpnameTxt.setEditable(false);
		cmpnameTxt.setText(jobadvert.getCmpname());		
		mainPanel.add(cmpnameTxt);
		
		mainPanel.add(new Label("Company Description"));		
		cmpnyDescTxt = new TextField(10);		
		cmpnyDescTxt.setEditable(false);
		cmpnyDescTxt.setText(jobadvert.getCmpnyDesc());		
		mainPanel.add(cmpnyDescTxt);
		
		
		
		mainPanel.add(new Label("Job Reference Code"));		
		jobrefcodeTxt = new TextField(10);		
		jobrefcodeTxt.setEditable(false);
		jobrefcodeTxt.setText(jobadvert.getJobrefcode());		
		mainPanel.add(jobrefcodeTxt);
		
		mainPanel.add(new Label("Department"));		
		departmentTxt = new TextField(10);		
		departmentTxt.setEditable(false);
		departmentTxt.setText(jobadvert.getDepartment());		
		mainPanel.add(departmentTxt);
		
		mainPanel.add(new Label("Job Advertiser ID"));		
		jobAdvertiserTxt = new TextField(10);		
		jobAdvertiserTxt.setEditable(false);
		jobAdvertiserTxt.setText(jobadvert.getAdvertizerref());		
		mainPanel.add(jobAdvertiserTxt);
		
		mainPanel.add(new Label("Tecnical Skills"));		
		techskillsTxt = new TextField(10);		
		techskillsTxt.setEditable(false);
		techskillsTxt.setText(jobadvert.getTechskills());		
		mainPanel.add(techskillsTxt);
		
		mainPanel.add(new Label("Mgmt Skills"));		
		mgmtSkillsTxt = new TextField(10);		
		mgmtSkillsTxt.setEditable(false);
		mgmtSkillsTxt.setText(jobadvert.getMgmtskills());		
		mainPanel.add(mgmtSkillsTxt);
		
		mainPanel.add(new Label("Years of Experience"));		
		noyrexpTxt = new TextField(10);		
		noyrexpTxt.setEditable(false);
		noyrexpTxt.setText(jobadvert.getNoyrexp());		
		mainPanel.add(noyrexpTxt);
		
		mainPanel.add(new Label("Salary Range"));		
		salaryrangeTxt = new TextField(10);		
		salaryrangeTxt.setEditable(false);
		salaryrangeTxt.setText(jobadvert.getSalaryrange());		
		mainPanel.add(salaryrangeTxt);
		
		mainPanel.add(new Label("Start Date"));		
		startdateTxt = new TextField(10);		
		startdateTxt.setEditable(false);
		startdateTxt.setText(jobadvert.getStartdate());		
		mainPanel.add(startdateTxt);
		
		mainPanel.add(new Label("Location"));		
		locationTxt = new TextField(10);		
		locationTxt.setEditable(false);
		locationTxt.setText(jobadvert.getLocation());		
		mainPanel.add(locationTxt);
		
		mainPanel.add(new Label("Status"));		
		statusTxt = new TextField(10);		
		statusTxt.setEditable(false);
		statusTxt.setText(jobadvert.getStatus());		
		mainPanel.add(statusTxt);
		
		
		return mainPanel;
	}
	
	/**
	 * gets Text field contains job advert title
	 * @return Text field contains job advert title
	 */
	public TextField getAdvertTitleTxt(){
		return advertTitle;
	}
	
	/**
	 * gets Text field contains job advertiser ref id
	 * @return Text field contains job advertiser ref id
	 */
	public TextField getJobAdvertiserTxt(){
		return jobAdvertiserTxt;
	}
	
	/**
	 * gets Text field contains job advert description
	 * @return Text field contains job advert description
	 */
	public TextField getJobTDescTxt(){
		return jobTDesc;
	}
	
	/**
	 * gets Text field contains job advert id
	 * @return Text field contains job advert id
	 */
	public TextField getJobIdTxt(){
		return jobIdTxt;
	}
	

	/**
	 * create close button 
	 * @return button
	 */
	private Component getCloseButton() {
		Button btn = new Button("Close");
		ActionListener listner = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				closePanel();
				jobAdvertController.invokeJobAdvertListScreen();
			}
		};
		btn.addActionListener(listner);
		return btn;		
	}
	
	/**
	 * create modify button 
	 * @return button
	 */
	private Component getModifyButton() {
		Button btn = new Button("Modify");
		ActionListener listner = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				setEditable(true);
			}
		};
		btn.addActionListener(listner);
		return btn;		
	}
	
	/**
	 * create save button 
	 * @return button
	 */
	private Component getSaveButton() {
		Button btn = new Button("Save");
		ActionListener listner = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				if(validateInput()){
					jobAdvertController.processModify();
					setEditable(false);
					closePanel();
					jobAdvertController.invokeJobAdvertListScreen();
				}
				
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
	
	/**
	 * set text fileds editable for modification
	 */
	private void setEditable(boolean flag){		
		advertTitle.setEditable(flag);
		jobTDesc.setEditable(flag);		
		cmpnameTxt.setEditable(flag);
		jobrefcodeTxt.setEditable(flag);
		cmpnyDescTxt.setEditable(flag);
		mgmtSkillsTxt.setEditable(flag);
		salaryrangeTxt.setEditable(flag);
		techskillsTxt.setEditable(flag);
		locationTxt.setEditable(flag);
		noyrexpTxt.setEditable(flag);
		departmentTxt.setEditable(flag);
	}
	
	/**
	 * validate the input before saving the job advert details
	 * @return true - if all validations are correct
	 * 		   false - if any validation fails
	 */
	private boolean validateInput(){
		return true;
	}
	
	
	public TextField getCmpnameTxt() {
		return cmpnameTxt;
	}

	public TextField getJobrefcodeTxt() {
		return jobrefcodeTxt;
	}

	public TextField getCmpnyDescTxt() {
		return cmpnyDescTxt;
	}

	public TextField getMgmtSkillsTxt() {
		return mgmtSkillsTxt;
	}

	public TextField getSalaryrangeTxt() {
		return salaryrangeTxt;
	}

	
	public TextField getTechskillsTxt() {
		return techskillsTxt;
	}

	public TextField getStatusTxt() {
		return statusTxt;
	}

	public TextField getLocationTxt() {
		return locationTxt;
	}

	public TextField getNoyrexpTxt() {
		return noyrexpTxt;
	}

	public TextField getDepartmentTxt() {
		return departmentTxt;
	}

	public TextField getStartdateTxt() {
		return startdateTxt;
	}
}
