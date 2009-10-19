package gui;

import java.awt.*;

import controller.JobAdvertController;

public class AddJobAdvertScreen extends Panel{

	private static final long serialVersionUID = 1L;
	
	private JobAdvertController jobadvertController;
	
	public AddJobAdvertScreen(JobAdvertController jobadvertController) {
		this.jobadvertController = jobadvertController;
		init();
	}
	
	private void init(){
		
		Panel addAdvertPanel = new Panel(new BorderLayout());
		
		Panel memPanel = new Panel();
		memPanel.setLayout(new GridLayout(2,6,3,3));		
		memPanel.add(new Label("Member Id"));
		memPanel.add(new TextField(10));
		memPanel.add(new Label(" "));
		memPanel.add(new Label(" "));
		memPanel.add(new Label(" "));
		memPanel.add(new Label(" "));
		memPanel.add(new Label("Points"));
		memPanel.add(new TextField(10));
		memPanel.add(new Label(" "));
		memPanel.add(new Label(" "));		
		memPanel.add(new Label(" "));
		
		Panel buttonPanel = new Panel();
		
		
		addAdvertPanel.add(memPanel,"North");
		addAdvertPanel.add(buttonPanel,"Center");
		add(addAdvertPanel);
		//setVisible(true);
			
	}
}
