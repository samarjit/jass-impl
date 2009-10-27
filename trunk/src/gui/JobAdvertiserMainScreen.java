package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controller.JobAdvertController;
import controller.MainController;

/*
 * <p> <b>JobAdvertiserMainScreen</b> This class handles gui for the job advertiser main window
 * </p> 
 * 
 * 
 * @author Justin Jose
 * @version 1.0	28/09/09
 * 
 */

public class JobAdvertiserMainScreen extends Frame {

	private static final long serialVersionUID = 1L;


	private MainController mainController;
	
	private Panel mainPanel;
	private Panel mainTitlePanel;
	private Panel completeWindow;
	/**
	 * Consturctor
	 */
	public JobAdvertiserMainScreen(MainController mainControler) {
		this.mainController = mainControler;
		init();
	}

	/**
	 * Initialize the advertiser main window
	 */
	private void init(){
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){				
				closeWindow();
			}
		});		
				
		//create main panel. It would be substituted by corresponding sub panels.
		completeWindow=new Panel(new BorderLayout());
		Panel left=new Panel();
		completeWindow.add(left);
		completeWindow.add(getMainPanel(), "West");
		
		//create a button panel, used to display add jobadvert, jobadvertlist,
		//jobresponse list buttons.
		Panel right=new Panel();		
		completeWindow.add(right);
		completeWindow.add(getButtonPanel(), "East");				
		add(completeWindow);	
		setSize(800, 500);
		setTitle("JASS");		
	}

	/**
	 * Creating the button panel for the job advertscreen
	 * @return
	 */
	private Component getButtonPanel() {
		Panel btPanel = new Panel();
		btPanel.setLayout(new GridLayout(10,0,0,3));		
		btPanel.add(getAddButton());
		btPanel.add(getAdvertListButton());
		btPanel.add(getResponseListButton());
		btPanel.add(getCloseButton());
		btPanel.add(new Label(" "));		
		btPanel.add(new Label(" "));
		return btPanel;
	}

	/**
	 * create close button
	 * @return
	 */
	private Component getCloseButton() {
		Button btn = new Button("Close");
		ActionListener listner = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				closeWindow();
			}
		};
		btn.addActionListener(listner);
		return btn;		
	}

	/**
	 * create add job advert button
	 * @return Button
	 */
	private Button getAddButton() {
		Button btn = new Button("Add JobAdvert");
		ActionListener listner = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
				mainController.showWindow("AddJobAdvertScreen");
			}
		};
		btn.addActionListener(listner);
		return btn;
	}
	
	/**
	 * create show response list button
	 * @return Button
	 */
	private Button getResponseListButton() {
		Button btn = new Button("Show Response List");
		ActionListener listner = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				mainController.showWindow("ResponseListScreen");
			}

		};
		btn.addActionListener(listner);
		return btn;
	}
	
	/**
	 * create show Advert List button
	 * @return Button
	 */
	private Button getAdvertListButton() {
		Button btn = new Button("Show Advert List");
		ActionListener listner = new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				mainController.showWindow("AdvertListScreen");
			}

		};
		btn.addActionListener(listner);
		return btn;
	}
	
	/**
	 * create  main panel.
	 * @return panel
	 */
	private Panel getMainPanel() {
		mainPanel = new Panel(new BorderLayout()); 
		mainPanel.setSize(900,500);
		return mainPanel;
	}
	
	
	public void setMainPanel(Panel newPanel, String title){
		/*if(this.mainPanel.getComponents().length > 1){
			Component tempComp = this.mainPanel.getComponent(1);
			this.mainPanel.remove(1);
			tempComp = null;
		}*/
		for( Component cmp:this.mainPanel.getComponents()){
			mainPanel.remove(cmp);
		}	
		
		mainTitlePanel = new Panel();
		Panel padPanel = new Panel(new GridLayout(0,1));
		mainTitlePanel.setFont(new Font("Arial",Font.BOLD,14));
		mainTitlePanel.setBackground(new Color(181,200,245));
		mainTitlePanel.setForeground(new Color(43,52,81));
		mainTitlePanel.add(new Label(title));
		mainTitlePanel.setName("mainTitle");
		padPanel.add(mainTitlePanel);
		padPanel.add(new Label(" "));
		
		
		mainPanel.add(padPanel,"North");
		this.mainPanel.add(newPanel,"Center");
		completeWindow.add(mainPanel, "West");
		this.setVisible(true);
		this.pack();
	}
	
	public void removeTitle(){		 
		mainTitlePanel.setVisible(false); 
	}
	
	/**
	 * handle close window
	 */
	private void closeWindow(){		
		mainController.closeJobAdvertMainScreen();
	}

	
}
