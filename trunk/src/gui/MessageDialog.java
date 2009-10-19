package gui;

import java.awt.*;
import java.awt.event.*;
public class MessageDialog extends Dialog {

	private static final long serialVersionUID = 1L;

	public MessageDialog (Frame parent, String title,String msg) {
        super (parent,title);
        add ("Center",getMsgPanel(msg));
        initialize(title);
    }
	
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
    
    public Panel getMsgPanel(String msg){
    	Panel msgPanel = new Panel();
    	msgPanel.add(new Label( msg));
    	return msgPanel;
    }
    
    private Panel createButtonPanel () {
        Panel p = new Panel ();
        Button b;
        ActionListener l;

        b = new Button("Ok");//new Button ("OK");
        l = new ActionListener () {
            public void actionPerformed (ActionEvent e) {
            	destroyDialog ();
            }
        };
        b.addActionListener (l);
        p.add (b);

        return p;
    }

    private void destroyDialog () {
        setVisible (false);
        dispose();
    }
}