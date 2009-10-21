package gui;

import java.awt.*;
import java.awt.event.*;
public class MessageDialog extends Dialog {
	/**
	 *  <p> <b>JobAdvertResponseListScreen</b> This class handles gui for the job advertiser main window
	 * </p>
	 * @author Saw Nandi
	 *
	 */	
	
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor
	 * @param parent JobAdvertiserMainScreen
	 * @param title Title will appear in dialog
	 * @param msg message
	 */
	public MessageDialog (Frame parent, String title,String msg) {
        super (parent,title);
        add ("Center",getMsgPanel(msg));
        initialize(title);
    }
	/**
	 * Initialize the components for message dialog
	 * @param title Title will appear in dialog
	 */
	public void initialize(String title){
		add ("South",  createButtonPanel());
		add("West",new Label(" "));
		add("East", new  Label(" "));
        this.setTitle(title);
        
        WindowListener listner = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				destroyDialog();				
			}
		};		
		addWindowListener(listner);
		pack();
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
	}
	/**
	 * Creating a label in msgPanel to show the message.
	 */	
    public Panel getMsgPanel(String msg){
    	Panel msgPanel = new Panel();
    	msgPanel.add(new Label( msg));
    	return msgPanel;
    }
    /**
	 * Creating OK Button in the message dialog.
	 */	
    private Panel createButtonPanel () {
        Panel p = new Panel ();
        Button b;
        ActionListener l;
        b = new Button("OK");
        l = new ActionListener () {
            public void actionPerformed (ActionEvent e) {
            	destroyDialog ();
            }
        };
        b.addActionListener (l);
        p.add (b);
        return p;
    }
	/**
	 * Destroy the message dialog after clicking OK button on Message Dialog.
	 * 
	 */
    private void destroyDialog () {
        setVisible (false);
        dispose();
    }
}