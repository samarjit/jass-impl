package gui;

/**
* @Author               :       samarjit
* @Creation Date        :       14/03/2009
* @Description          :    GTcell implementaion to be used with GTable
*  
* @          -------------------------------------------------
* @Revision:  Revision Date    Name     Change Description      
* @          -------------------------------------------------     
* @                      
*/

import java.awt.AWTEventMulticaster;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

 
/**
 * <p><b>GTcell</b> class is used by GTrow to create cells as its child. But this class is more generic and can be used to
 * draw a cell just on any component</p>
 * @author Samarjit
 * @version 1.0
 */
public class GTcell extends Component{
	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;
	private int nlines;
	private int charwidth; //character width
	private String celldata;
	private GTrow parentElement;
	private boolean multiline = false;
	private int x;
	private int y;
	private int height; //pixel
	private int width; // pixel
	private Font font= null;
	private Rectangle rect=null;
	private int charHeight = 0;
	private ActionListener actionListener;
	private String actionCommand=null;
	/**
	 * This is a constructor for creating a cell and fill it with data. It also takes a reference of
	 * parent element.
	 * @param trow parent Element
	 * @param x position x
	 * @param y position y
	 * @param width width of the cell
	 * @param data text data to be filled in the cell
	 * @throws Exception
	 */
	public GTcell(GTrow trow,int x,int y,int width, String data) throws Exception{
		super();
		//colwidth=width;
		parentElement = trow;
		this.width = width;
		this.x = x;
		this.y = y;
		rect = new Rectangle();
		rect.x = x;
		rect.y = y;
		rect.width = width;
		font = new Font ("Monospaced",Font.BOLD,12);
		setCelldata(data);
		addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				//get Trow String

				if(parentElement != null ){
					actionCommand = getRowData();
					parentElement.setSelectedRow(true);
				}
				//get Trow String
				if(parentElement!=null && parentElement.isHeadingRow()){
					ActionEvent ae =
						new ActionEvent(this,ActionEvent.ACTION_PERFORMED,"headcellClick:"+actionCommand);
					if (actionListener != null) {
						actionListener.actionPerformed(ae);
					}
				}else{
					ActionEvent ae =
						new ActionEvent(this,ActionEvent.ACTION_PERFORMED,"cellClick:"+actionCommand);
					if (actionListener != null) {
						actionListener.actionPerformed(ae);
					}
				}

			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}

		});
	}

	/**
	 * Gets row text
	 * @return
	 */
	private String getRowData() {
		String allRowText="";
		for(GTcell tc:parentElement.getCells()){
			allRowText +=tc.getCelldata()+"~#";
		}
		return allRowText;
	}
	/**
	 * @param l ActionListener
	 */
	public void addActionListener(ActionListener l) {
		actionListener =
			AWTEventMulticaster.add(actionListener,l);
	}
	/**
	 * @param l ActionListener
	 */
	public void removeActionListener(ActionListener l) {
		actionListener =
			AWTEventMulticaster.remove(actionListener, l);
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#getX()
	 */
	public int getX() {
		return x;
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#getY()
	 */
	public int getY() {
		return y;
	}

	/* (non-Javadoc)
	 * @see java.awt.Component#getHeight()
	 */
	public int getHeight() {
		return height;
	}
	/* (non-Javadoc)
	 * @see java.awt.Component#getWidth()
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * Used to paint the cells
	 * @see java.awt.Component#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g){
		if(this.parentElement != null)
			if(this.parentElement.isHeadingRow())
				font = new Font ("Monospaced",Font.BOLD,12);
			else
				font = new Font ("Monospaced",Font.PLAIN,12);

		g.setFont(font);        
		FontMetrics fm = g.getFontMetrics ();
		g.clearRect(0,0,width-1,height-1);  //it colors background
		g.setColor(new Color(50,50,50));
		//g.setColor(getBackground());
		int ascent = fm.getMaxAscent ();
		int descent= fm.getMaxDescent ();

		for(int i=1;i<=nlines;i++){
			if(multiline){
				int msgWidth = fm.stringWidth (getCellTexti(i-1));
				int msgX = getSize ().width/2 - msgWidth/2;
				int msgY = i*getSize ().height/(2*nlines) - descent/2 + ascent/2;

				g.drawString (getCellTexti(i-1),msgX,msgY);

			}else{
				int msgWidth = fm.stringWidth (getCellTexti(i-1));
				int msgX = getSize ().width/2 - msgWidth/2;
				int msgY = i*getSize ().height/(2*nlines) - descent/2 + ascent/2;

				g.drawString (getCellTexti(i-1),msgX,msgY);

			}
		}
		g.setColor(new Color(150,150,150));

		g.drawRect(0,0,width-1,height-1);
		super.paint(g);

	}
	public int getNlines() {
		return nlines;
	}

	public GTrow getParentElement() {
		return parentElement;
	}


	public int getCharwidth() {
		return charwidth;
	}

	public boolean isMultiline() {
		return multiline;
	}

	ArrayList<String> cellTexti=new ArrayList<String>();
	
	/**
	 * The raw cell contents without the number of lines info is returned
	 * @return The data contained by the cell in simple string format.
	 */
	public String getCelldata() {
		return celldata;
	}
	/**
	 * This function splits the data 
	 * @param celldata   The data to be stored in the cell
	 * @throws Exception
	 */
	private void setCelldata(String celldata) throws Exception {
		this.celldata = celldata;
		calcCellTexti(celldata);
	}
	
	/**
	 * @return ArrayList of cell text in lines.
	 */
	public ArrayList<String> getCellTextAr(){
		return cellTexti;
	}
	/**
	 * @param i The line number inside the cell.
	 * @return  Data from a particular line inside the cell
	 */
	public  String getCellTexti(int i) {
		return cellTexti.get(i);
	}
	
	/**
	 * This function will resize heights of the cell according to the data it contains. It will split
	 * up the cells data and put it in different lines. The maximum width is calculated from the width
	 * attribute of the cell Component. 
	 * @param celldt
	 */
	private void calcCellTexti(String celldt) throws Exception {
		String temp1,temp2;
		int len=0;
		nlines=0;

		FontMetrics fm = getFontMetrics (font);
		int msgWidth = fm.stringWidth (celldt);
		int ascent = fm.getMaxAscent ();
		int descent= fm.getMaxDescent ();
		int msgX = getSize ().width/2 - msgWidth/2;
		int msgY = getSize ().height/2 - descent/2 + ascent/2;
		//Need to find out how many character will fit in a line. Should work fine with mono-spaced character.
		int charLen = fm.charWidth('A');

		if(charLen > width)throw new Exception("Something went wrong in sizing");
		charwidth = width/charLen;

		len=celldt.length();
		temp2 = celldt;
		try {
			while(len >0){
				if (len >  charwidth) {
					temp1 = temp2.substring(0, charwidth);
					temp2 = temp2.substring( charwidth);
					len = temp2.length();
					nlines++;

				}else{
					temp1 = temp2; len=-1;nlines++;
				}
				cellTexti.add(temp1);
			}
			height = (ascent+descent) * nlines;
			charHeight = (ascent+descent);
			rect.height = height;
			setSize(width,height);
			//      System.out.println("width="+width+"px height="+height+" "+charwidth);
			if(nlines>1)multiline=true;
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Calc in GTcell"+e);
		}
	}

	/**
	 * This function will resize heights of the cell according to the height provided to it by inserting 
	 * blank lines. This is used for row height resizing.
	 * This method is called by GTrow at the end of a table row creation.
	 * @param trHeight
	 */
	public void cellResize(int trHeight){ //this is final tr height
		while(trHeight > nlines){
			cellTexti.add("");nlines++;height+=charHeight;
		}
		rect.height = height;
		parentElement.setHeight(height);
		setBounds(x,y-1,width,height);
		//System.out.println(" cellResize:"+x+","+y+","+width+","+height);
	}


}


