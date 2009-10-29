package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;
import dto.CompanyDTO;

import controller.JobAdvertController;

/**
 * <p> <b>JobAdvertiserMainScreen</b> This class handles gui for the Adding Job advert 
 * by the advertiser.
 * </p> 
 * @author Anbazhagan Satish Kumar
 * @version 1.0	
 * 
 */

public class AddJobAdvertScreen extends Panel{

	private static final long serialVersionUID = 1L;

	private JobAdvertController jobadvertController;
	private TextField advertiserID;
	private TextField companydept;
	private TextField jobtitle;
	private TextArea  jobDesc;
	private TextField techskills;
	private TextField mgmtskills;
	private TextField yearsOfExp;
	private TextField salaryRange;
	private TextField companyAltDesc;
	private TextField startDate;
	private TextField location;

	private Button addbtn;
	private Button clearbtn;
	private Button closebtn;

	private Choice companyName;
	private ArrayList<CompanyDTO> arCompanyDTO = null;

	/**
	 * Consturctor
	 */
	public AddJobAdvertScreen(JobAdvertController jobadvertController, String advertiserId) {
		this.jobadvertController = jobadvertController;
		advertiserID = new TextField(advertiserId);
		advertiserID.setEnabled(false);
		init();
	}
	/**
	 * Creates Panels for Buttons, Textfields and TextArea
	 */
	private void init(){

		//creates Main Panel
		Panel addAdvertPanel = new Panel(new BorderLayout());

		//creates Panel for Textfields
		Panel memPanel = new Panel();
		memPanel.setLayout(new GridLayout(13,2,250,1));		
		memPanel.add(new Label("Advertiser ID"));
		memPanel.add(advertiserID);

		memPanel.add(new Label("Company Name"));
		companyName = new Choice();
		memPanel.add(companyName);
		refresh_companylist();

		memPanel.add(new Label("Company Description"));
		companyAltDesc = new TextField();
		memPanel.add(companyAltDesc);

		memPanel.add(new Label("Company Department"));
		companydept = new TextField();
		memPanel.add(companydept);

		memPanel.add(new Label("Job Title"));
		jobtitle = new TextField();
		memPanel.add(jobtitle);

		memPanel.add(new Label("Required Technical Skills"));
		techskills = new TextField();
		memPanel.add(techskills);

		memPanel.add(new Label("Required Management Skills"));
		mgmtskills = new TextField();
		memPanel.add(mgmtskills);

		memPanel.add(new Label("Required Years of Experience"));
		yearsOfExp = new TextField();
		memPanel.add(yearsOfExp);

		memPanel.add(new Label("Salary Range"));
		salaryRange = new TextField();
		memPanel.add(salaryRange);

		memPanel.add(new Label("Start Date (dd-MM-yyyy)"));
		startDate = new TextField();
		memPanel.add(startDate);

		memPanel.add(new Label("Location"));
		location = new TextField();
		memPanel.add(location);

		memPanel.add(new Label(""));

		//Creates Panel for TextArea
		Panel areapanel = new Panel();
		areapanel.setLayout(new BorderLayout());	
		areapanel.add(new Label("Job Description"));
		jobDesc = new TextArea();
		areapanel.add(jobDesc,BorderLayout.SOUTH);

		//Creates Panel for Buttons
		Panel buttonPanel = new Panel();
		clearbtn = new Button("Clear");
		addbtn = new Button("Create Advert");
		closebtn = new Button("Close");

		//Adding ActionListener for Buttons
		ActionListener ladd =new ActionListener(){
			public void actionPerformed ( ActionEvent e){
				if(validationchk()){

					jobadvertController.addJobAdvert(advertiserID.getText(),companyName.getSelectedItem(),companydept.getText(),jobtitle.getText(),jobDesc.getText(),techskills.getText(),mgmtskills.getText(),yearsOfExp.getText(),salaryRange.getText(),companyAltDesc.getText(),startDate.getText(),location.getText());
					clear();
				}

			}
		};
		addbtn.addActionListener(ladd);

		ActionListener lclr =new ActionListener(){

			public void actionPerformed ( ActionEvent e){

				clear();

			}
		};
		clearbtn.addActionListener(lclr);

		ActionListener listnercl = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				closePanel();
				jobadvertController.getJobAdvertMainScreen();
			}
		};
		closebtn.addActionListener(listnercl);

		buttonPanel.add(addbtn);
		buttonPanel.add(clearbtn);
		buttonPanel.add(closebtn);


		//Adding Sub panels to Main Panel
		addAdvertPanel.add(memPanel,"North");
		addAdvertPanel.add(areapanel,"Center");
		addAdvertPanel.add(buttonPanel,"South");
		add(addAdvertPanel);

	}
	
	/**
	 * GUI Validations
	 * @return boolean
	 */
	public boolean validationchk(){

		if(advertiserID.getText().length()==0 || companyName.getSelectedIndex()== -1 || companyName.getSelectedIndex()== 0 ||companydept.getText().length()==0 || jobtitle.getText().length()==0 ||jobDesc.getText().length()==0 || techskills.getText().length()==0 ||mgmtskills.getText().length()==0 || yearsOfExp.getText().length()==0 ||salaryRange.getText().length()==0 ||companyAltDesc.getText().length()==0 ||startDate.getText().length()==0 ||location.getText().length()==0){
			new MessageDialog(jobadvertController.getJobAdvertMainScreen(),"Error","Enter Complete details");
			return false;
		}

		if(!(Pattern.matches("-?\\d+(.\\d+)?",yearsOfExp.getText()))){
			new MessageDialog(jobadvertController.getJobAdvertMainScreen(),"Error","Invalid number of years experience");
			return false;

		}

		if(!(Pattern.matches("-?\\d+(.\\d+)?",salaryRange.getText()))){
			new MessageDialog(jobadvertController.getJobAdvertMainScreen(),"Error","Invalid Salary");
			return false;
		}


		if(!"".equals(startDate.getText())){

			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			df.setLenient(false);
			try {
				df.parse(startDate.getText());
			} catch (ParseException e) {
				new MessageDialog(jobadvertController.getJobAdvertMainScreen(),"Error","Invalid Date");
				return false;
			}
			return true;

		}

		return true;
	}
	
	
	/**
	 * Removes the Header title and sets the panel's visibility to false
	 */
	private void closePanel() {
		jobadvertController.removeTitle();
		setVisible(false);
	}

	/**
	 * clears all the values entered previously by the user 
	 * after a job advert record is successfuly created.
	 */
	public void clear(){

		
		refresh_companylist();
		companydept.setText(null);
		jobtitle.setText(null);
		jobDesc.setText(null);
		techskills.setText(null);
		mgmtskills.setText(null);
		yearsOfExp.setText(null);
		salaryRange.setText(null);
		companyAltDesc.setText(null);
		startDate.setText(null);
		location.setText(null);

	}
	
	/**
	 * Refreshes the Company Name drop down list box.
	 */

	public void refresh_companylist(){
		companyName.removeAll();
		companyName.add("Select a Company");
		arCompanyDTO = jobadvertController.getCompanyDetails();
		//System.out.println(arCompanyDTO.size());

		for(CompanyDTO cdt : arCompanyDTO){
			companyName.add(cdt.getCompanyName());
			//	System.out.println(cdt.getId());

		}

	}

}
