package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.JobAdvertController;
import dto.ResponseDTO;

/**
 *  <p> <b>JobAdvertResponseDetailScreen</b> This class handles gui for the job advertiser main window
 * </p>
 * @author Justin Jose
 *
 */
public class JobAdvertResponseDetailScreen extends Panel{


	private static final long serialVersionUID = 1L;
	private JobAdvertController jobAdvertController;
	private ResponseDTO response;

	/**
	 * Constructor
	 * @param jobAdvertController
	 * @param response
	 */
	public JobAdvertResponseDetailScreen(JobAdvertController jobAdvertController, ResponseDTO response) {
		this.jobAdvertController = jobAdvertController;
		this.response = response;
		init();
	}

	/**
	 * initialize the JobAdvertResponseDetailScreen
	 */
	private void init() {
		Panel addAdvertPanel = new Panel(new BorderLayout());
		
		addAdvertPanel.add(getMainPanel(),"North");
		addAdvertPanel.add(getButtonPanel(),"Center");
		
		add(addAdvertPanel);
	}


	/**
	 * Creating the button panel for the job response detail screen
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
		
		
		detailsPanel.add(new Label("Candidate Name"));
		TextField candidateNameTxt = new TextField(10);
		candidateNameTxt.setEditable(false);		
		candidateNameTxt.setText(response.getJsName());		
		detailsPanel.add(candidateNameTxt);
		
		detailsPanel.add(new Label("Job Seeker Code"));		
		TextField jsidTxt = new TextField(10);	
		jsidTxt.setEditable(false);
		jsidTxt.setText(Integer.toString(response.getJsId()));		
		detailsPanel.add(jsidTxt);
		
		
		detailsPanel.add(new Label("Job Advert Ref ID"));		
		TextField advertRefIdTxt = new TextField(10);	
		advertRefIdTxt.setEditable(false);
		advertRefIdTxt.setText(Integer.toString(response.getAdvertRefId()));		
		detailsPanel.add(advertRefIdTxt);
		
		detailsPanel.add(new Label("Job Title"));		
		TextField jobTText = new TextField(10);
		advertRefIdTxt.setEditable(false);		
		jobTText.setText(jobAdvertController.getJobAdvertTitle(response.getAdvertRefId()));		
		detailsPanel.add(jobTText);
		
		
		
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
		
		mainPanel.add(detailsPanel);
		mainPanel.add(textPanel);
		
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
				jobAdvertController.invokeResponseListScreen();
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
