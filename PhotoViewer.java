/**
 * Homework 4
 * Matt Walsh, mw6es
 *
 * Sources : oracle
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PhotoViewer extends JFrame{

	private Container container;
	private GridBagLayout gbl;
	private PhotographContainer imageLibrary;
	private int index = 0;

	//Thumbnail 1
	JButton icon1 = new JButton();

	//Thumbnail 2
	JButton icon2= new JButton();

	//Thumbnail 3
	JButton icon3 = new JButton();

	//Thumbnail 4
	JButton icon4= new JButton();

	//Thumbnail 5
	JButton icon5 = new JButton();

	//Next button
	JButton next = new JButton("Next");

	//Prev button
	JButton prev = new JButton("Prev");

	//choose rating 1
	JRadioButton rate1 = new JRadioButton("1");

	//choose rating 2
	JRadioButton rate2 = new JRadioButton("2");

	//choose rating 3
	JRadioButton rate3 = new JRadioButton("3");

	//choose rating 4
	JRadioButton rate4 = new JRadioButton("4");

	//choose rating 5
	JRadioButton rate5 = new JRadioButton("5");

	//choose to sort by caption
	JRadioButton sortCap = new JRadioButton("Sort by Caption");

	//choose to sort by rating
	JRadioButton sortRate = new JRadioButton("Sort by Rating");

	//choose to sort by date
	JRadioButton sortDate = new JRadioButton("Sort by Date");

	//main photo
	JLabel pic = new JLabel();

	//caption of main photo
	JLabel caption;

	//rating title
	JLabel rating;

	//rating of main photo
	JLabel rateNum;

	//thumbnail 1 caption 
	JLabel c1;

	//thumbnail 2 caption 
	JLabel c2;

	//thumbnail 3 caption 
	JLabel c3;

	//thumbnail 4 caption 
	JLabel c4;

	//thumbnail 5 caption 
	JLabel c5;

	Photograph p1 = new Photograph("Soaking up the sun!", "p1", "2015-06-05", 5);
	Photograph p2 = new Photograph("Swim time!", "p2", "2015-06-06", 3);
	Photograph p3 = new Photograph("#Views", "p3", "2015-06-07", 1);
	Photograph p4 = new Photograph("Elephants!", "p4", "2015-06-08", 2);
	Photograph p5 = new Photograph("Selfie Sunday", "p5", "2015-06-09", 4);

	//list of thumbnails
	JLabel[] thumbs= new JLabel[5];

	public PhotoViewer() {

		p1.loadImageData("images/HW4_1.jpeg");
		p2.loadImageData("images/HW4_2.jpeg");
		p3.loadImageData("images/HW4_3.jpeg");
		p4.loadImageData("images/HW4_4.jpeg");
		p5.loadImageData("images/HW4_5.jpeg");

		this.imageLibrary=(new PhotoLibrary("l1", 1));

		this.imageLibrary.addPhoto(p1);
		this.imageLibrary.addPhoto(p2);
		this.imageLibrary.addPhoto(p3);
		this.imageLibrary.addPhoto(p4);
		this.imageLibrary.addPhoto(p5);

		JFrame frame = new JFrame("PhotoViewer");
		frame.setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container pane = frame.getContentPane();
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		ImageIcon i1Big= new ImageIcon();
		ImageIcon i2Big= new ImageIcon();
		ImageIcon i3Big= new ImageIcon();
		ImageIcon i4Big= new ImageIcon();
		ImageIcon i5Big= new ImageIcon();

		i1Big.setImage(this.imageLibrary.getPhotos().get(0).getImageData().getScaledInstance(700, 560,
				Image.SCALE_SMOOTH));
		i2Big.setImage(this.imageLibrary.getPhotos().get(1).getImageData().getScaledInstance(700, 560,
				Image.SCALE_SMOOTH));
		i3Big.setImage(this.imageLibrary.getPhotos().get(2).getImageData().getScaledInstance(700, 560,
				Image.SCALE_SMOOTH));
		i4Big.setImage(this.imageLibrary.getPhotos().get(3).getImageData().getScaledInstance(700, 560,
				Image.SCALE_SMOOTH));
		i5Big.setImage(this.imageLibrary.getPhotos().get(4).getImageData().getScaledInstance(700, 560,
				Image.SCALE_SMOOTH));

		//default sort by date
		Collections.sort(this.imageLibrary.getPhotos(), new CompareByDate());

		c.fill = GridBagConstraints.BOTH;

		//set locations and features of all buttons and labels
		icon1 = new JButton(new ImageIcon(this.imageLibrary.getPhotos().get(0).getImageData().getScaledInstance(128, 102,
				Image.SCALE_SMOOTH)));
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(icon1, c);

		icon2 = new JButton(new ImageIcon(this.imageLibrary.getPhotos().get(1).getImageData().getScaledInstance(128, 102,
				Image.SCALE_SMOOTH)));
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 0;
		pane.add(icon2, c);

		icon3 = new JButton(new ImageIcon(this.imageLibrary.getPhotos().get(2).getImageData().getScaledInstance(128, 102,
				Image.SCALE_SMOOTH)));
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 3;
		c.gridy = 0;
		pane.add(icon3, c);

		icon4= new JButton(new ImageIcon(this.imageLibrary.getPhotos().get(3).getImageData().getScaledInstance(128, 102,
				Image.SCALE_SMOOTH)));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		pane.add(icon4, c);

		icon5 = new JButton(new ImageIcon(this.imageLibrary.getPhotos().get(4).getImageData().getScaledInstance(128, 102,
				Image.SCALE_SMOOTH)));
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 5;
		c.gridy = 0;
		pane.add(icon5, c);


		rate1= new JRadioButton("1");
		c.fill = 0; 
		c.anchor=GridBagConstraints.EAST;
		c.ipady = 51;
		c.ipadx = 64;
		c.gridx = 0;    
		c.gridy = 4;    
		pane.add(rate1, c);

		rate2= new JRadioButton("2");
		c.fill = 0;
		c.anchor=GridBagConstraints.EAST;
		c.ipady = 51;
		c.ipadx = 64; 
		c.gridx = 0;       
		c.gridy = 5;  
		pane.add(rate2, c);

		rate3= new JRadioButton("3");
		c.fill = 0;
		c.anchor=GridBagConstraints.EAST;
		c.ipady = 51;
		c.ipadx = 64;
		c.gridx = 0;       
		c.gridy = 6;       
		pane.add(rate3, c);

		rate4= new JRadioButton("4");
		c.fill = 0;
		c.anchor=GridBagConstraints.EAST;
		c.ipadx = 64;
		c.ipady = 51;
		c.gridx = 0;
		c.gridy = 7;   
		pane.add(rate4, c);

		rate5= new JRadioButton("5");
		c.fill = 0;
		c.anchor=GridBagConstraints.EAST;
		c.ipadx = 64;
		c.ipady = 51;
		c.gridx = 0;       
		c.gridy = 8;       
		pane.add(rate5, c);

		//next button
		c.fill = GridBagConstraints.BOTH; 
		c.ipadx = 64;
		c.ipady = 51;
		c.gridx = 6;       
		c.gridy = 0; 
		pane.add(next, c);

		//prev button
		c.fill = GridBagConstraints.BOTH; 
		c.ipadx = 64;
		c.ipady = 51;
		c.gridx = 0;       
		c.gridy = 0;           
		pane.add(prev, c);

		//pic button
		c.ipadx = 0;
		c.ipady = 0;
		c.gridwidth=7;
		c.gridheight=7;
		c.gridx = 0;       
		c.gridy = 2;     
		c.fill = 0;		
		pic.setIcon(new ImageIcon(this.imageLibrary.getPhotos().get(0).getImageData().getScaledInstance(700, 560,
				Image.SCALE_SMOOTH)));
		c.anchor= GridBagConstraints.CENTER;
		pane.add(pic, c);

		caption= new JLabel("<html> "+this.imageLibrary.getPhotos().get(index).getCaption()+" <html>");
		caption.setFont(new Font("Helvetica", Font.PLAIN, 32));
		c.gridwidth=10;
		c.gridheight=1;
		c.fill=0;
		c.gridx = 2;       
		c.gridy = 9;
		c.ipady=40;
		c.anchor= GridBagConstraints.WEST;
		pane.add(caption, c);


		rating= new JLabel("Rating:");
		rating.setFont(new Font("Helvetica", Font.PLAIN, 32));
		c.gridwidth=3;
		c.gridheight=1;
		c.gridx = 0;       
		c.gridy = 2;
		c.anchor= GridBagConstraints.WEST;
		pane.add(rating, c);

		rateNum= new JLabel("   "+this.imageLibrary.getPhotos().get(index).getRating());
		rateNum.setFont(new Font("Helvetica", Font.PLAIN, 64));
		c.gridwidth=3;
		c.gridheight=1;
		c.gridx = 0;       
		c.gridy = 3;
		c.anchor= GridBagConstraints.WEST;
		pane.add(rateNum, c);

		c1= new JLabel("<html>Caption: "+this.imageLibrary.getPhotos().get(0).getCaption()+"<br/>Rating: "+this.imageLibrary.getPhotos().get(0).getRating()
				+"<br/>Date: "+this.imageLibrary.getPhotos().get(0).getDateTaken()+"<html>");
		c1.setFont(new Font("Helvetica", Font.PLAIN, 10));
		c.ipady=10;
		c.ipadx=10;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=0;
		c.gridx = 1;       
		c.gridy = 1; 
		c.anchor= GridBagConstraints.CENTER;
		pane.add(c1, c);

		c2= new JLabel("<html>Caption: "+this.imageLibrary.getPhotos().get(1).getCaption()+"<br/>Rating: "+this.imageLibrary.getPhotos().get(1).getRating()
				+"<br/>Date: "+this.imageLibrary.getPhotos().get(1).getDateTaken()+"<html>");
		c2.setFont(new Font("Helvetica", Font.PLAIN, 10));
		c.ipady=10;
		c.ipadx=10;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=0;
		c.gridx = 2;       
		c.gridy = 1; 
		c.anchor= GridBagConstraints.CENTER;
		pane.add(c2, c);

		c3= new JLabel("<html>Caption: "+this.imageLibrary.getPhotos().get(2).getCaption()+"<br/>Rating: "+this.imageLibrary.getPhotos().get(2).getRating()
				+"<br/>Date: "+this.imageLibrary.getPhotos().get(2).getDateTaken()+"<html>");
		c3.setFont(new Font("Helvetica", Font.PLAIN, 10));
		c.ipady=10;
		c.ipadx=10;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=0;
		c.gridx = 3;       
		c.gridy = 1; 
		c.anchor= GridBagConstraints.CENTER;
		pane.add(c3, c);

		c4= new JLabel("<html>Caption: "+this.imageLibrary.getPhotos().get(3).getCaption()+"<br/>Rating: "+this.imageLibrary.getPhotos().get(3).getRating()
				+"<br/>Date: "+this.imageLibrary.getPhotos().get(3).getDateTaken()+"<html>");
		c4.setFont(new Font("Helvetica", Font.PLAIN, 10));
		c.ipady=10;
		c.ipadx=10;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=0;
		c.gridx = 4;       
		c.gridy = 1; 
		c.anchor= GridBagConstraints.CENTER;
		pane.add(c4, c);

		c5= new JLabel("<html>Caption: "+this.imageLibrary.getPhotos().get(4).getCaption()+"<br/>Rating: "+this.imageLibrary.getPhotos().get(4).getRating()
				+"<br/>Date: "+this.imageLibrary.getPhotos().get(4).getDateTaken()+"<html>");
		c5.setFont(new Font("Helvetica", Font.PLAIN, 10));
		c.ipady=10;
		c.ipadx=10;
		c.gridwidth=1;
		c.gridheight=1;
		c.fill=0;
		c.gridx = 5;       
		c.gridy = 1; 
		c.anchor= GridBagConstraints.CENTER;
		pane.add(c5, c);

		sortCap= new JRadioButton("Sort by Caption");
		c.fill = 0;
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 6;       
		c.gridy = 4;       
		pane.add(sortCap, c);

		sortRate= new JRadioButton("Sort by Rating");
		c.fill = 0;
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 6;
		c.gridy = 5;   
		pane.add(sortRate, c);

		sortDate= new JRadioButton("Sort by Date");
		c.fill = 0;
		c.anchor = GridBagConstraints.WEST;
		c.gridx = 6;       
		c.gridy = 6;       
		pane.add(sortDate, c);

		//add thumbnails to list
		thumbs[0]=c1;
		thumbs[1]=c2;
		thumbs[2]=c3;
		thumbs[3]=c4;
		thumbs[4]=c5;

		setRatings();

		//set action listeners and action commands
		next.addActionListener(new buttonListener());
		next.setActionCommand("next");

		prev.addActionListener(new buttonListener());
		prev.setActionCommand("prev");

		icon1.addActionListener(new buttonListener());
		icon1.setActionCommand("icon1");

		icon2.addActionListener(new buttonListener());
		icon2.setActionCommand("icon2");

		icon3.addActionListener(new buttonListener());
		icon3.setActionCommand("icon3");

		icon4.addActionListener(new buttonListener());
		icon4.setActionCommand("icon4");

		icon5.addActionListener(new buttonListener());
		icon5.setActionCommand("icon5");

		rate1.addActionListener(new buttonListener());
		rate1.setActionCommand("rate1");

		rate2.addActionListener(new buttonListener());
		rate2.setActionCommand("rate2");

		rate3.addActionListener(new buttonListener());
		rate3.setActionCommand("rate3");

		rate4.addActionListener(new buttonListener());
		rate4.setActionCommand("rate4");

		rate5.addActionListener(new buttonListener());
		rate5.setActionCommand("rate5");

		sortCap.addActionListener(new buttonListener());
		sortCap.setActionCommand("sortCap");

		sortRate.addActionListener(new buttonListener());
		sortRate.setActionCommand("sortRate");

		sortDate.addActionListener(new buttonListener());
		sortDate.setSelected(true);
		sortDate.setActionCommand("sortDate");


		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new PhotoViewer();
	}

	public void setImageLibrary(PhotographContainer pc) {
		this.imageLibrary = pc;
	}

	public PhotographContainer getImageLibrary() {
		return this.imageLibrary;
	}

	private class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			String action=event.getActionCommand();

			//action for next button
			if (action.equals("next")) {
				if (index<4) {
					index++;
					pic.setIcon(new ImageIcon(imageLibrary.getPhotos().get(index).getImageData().getScaledInstance(700, 560,
							Image.SCALE_SMOOTH)));
				} else {
					index=0;
					pic.setIcon(new ImageIcon(imageLibrary.getPhotos().get(index).getImageData().getScaledInstance(700, 560,
							Image.SCALE_SMOOTH)));
				}
				rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());
				caption.setText("<html> "+imageLibrary.getPhotos().get(index).getCaption()+" <html>");
				setRatings();
			}

			//action for prev button
			if (action.equals("prev")) {
				if (index>1) {
					index--;
					pic.setIcon(new ImageIcon(imageLibrary.getPhotos().get(index).getImageData().getScaledInstance(700, 560,
							Image.SCALE_SMOOTH)));
				} else {
					index=4;
					pic.setIcon(new ImageIcon(imageLibrary.getPhotos().get(index).getImageData().getScaledInstance(700, 560,
							Image.SCALE_SMOOTH)));
				}
				rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());
				caption.setText("<html> "+imageLibrary.getPhotos().get(index).getCaption()+" <html>");
				setRatings();
			}

			//action for pressing thumbnail 1
			if (action.equals("icon1")) {
				index=0;
				pic.setIcon(new ImageIcon(imageLibrary.getPhotos().get(0).getImageData().getScaledInstance(700, 560,
						Image.SCALE_SMOOTH)));
				rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());
				caption.setText("<html> "+imageLibrary.getPhotos().get(index).getCaption()+" <html>");
				setRatings();
			}

			//action for pressing thumbnail 2
			if (action.equals("icon2")) {
				index=1;
				pic.setIcon(new ImageIcon(imageLibrary.getPhotos().get(1).getImageData().getScaledInstance(700, 560,
						Image.SCALE_SMOOTH)));
				rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());
				caption.setText("<html> "+imageLibrary.getPhotos().get(index).getCaption()+" <html>");
				setRatings();
			}

			//action for pressing thumbnail 3
			if (action.equals("icon3")) {
				index=2;
				pic.setIcon(new ImageIcon(imageLibrary.getPhotos().get(2).getImageData().getScaledInstance(700, 560,
						Image.SCALE_SMOOTH)));
				rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());
				caption.setText("<html> "+imageLibrary.getPhotos().get(index).getCaption()+" <html>");
				setRatings();
			}

			//action for pressing thumbnail 4
			if (action.equals("icon4")) {
				index=3;
				pic.setIcon(new ImageIcon(imageLibrary.getPhotos().get(3).getImageData().getScaledInstance(700, 560,
						Image.SCALE_SMOOTH)));
				rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());
				caption.setText("<html> "+imageLibrary.getPhotos().get(index).getCaption()+" <html>");
				setRatings();
			}

			//action for pressing thumbnail 5
			if (action.equals("icon5")) {
				index=4;
				pic.setIcon(new ImageIcon(imageLibrary.getPhotos().get(4).getImageData().getScaledInstance(700, 560,
						Image.SCALE_SMOOTH)));
				rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());
				caption.setText("<html> "+imageLibrary.getPhotos().get(index).getCaption()+" <html>");
				setRatings();
			}

			//set action for changing rating to 1
			if (action.equals("rate1")) {
				rate2.setSelected(false);
				rate3.setSelected(false);
				rate4.setSelected(false);
				rate5.setSelected(false);
				imageLibrary.getPhotos().get(index).setRating(1);
				rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());
				thumbs[index].setText("<html>Caption: "+imageLibrary.getPhotos().get(index).getCaption()+
						"<br/>Rating: 1<br/>Date: "+imageLibrary.getPhotos().get(index).getDateTaken()+"<html>");
			}

			//set action for changing rating to 2
			if (action.equals("rate2")) {
				rate1.setSelected(false);
				rate3.setSelected(false);
				rate4.setSelected(false);
				rate5.setSelected(false);
				imageLibrary.getPhotos().get(index).setRating(2);
				rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());
				thumbs[index].setText("<html>Caption: "+imageLibrary.getPhotos().get(index).getCaption()+
						"<br/>Rating: 2<br/>Date: "+imageLibrary.getPhotos().get(index).getDateTaken()+"<html>");
			}

			//set action for changing rating to 3
			if (action.equals("rate3")) {
				rate2.setSelected(false);
				rate1.setSelected(false);
				rate4.setSelected(false);
				rate5.setSelected(false);
				imageLibrary.getPhotos().get(index).setRating(3);
				rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());
				thumbs[index].setText("<html>Caption: "+imageLibrary.getPhotos().get(index).getCaption()+
						"<br/>Rating: 3<br/>Date: "+imageLibrary.getPhotos().get(index).getDateTaken()+"<html>");
			}

			//set action for changing rating to 4
			if (action.equals("rate4")) {
				rate2.setSelected(false);
				rate3.setSelected(false);
				rate1.setSelected(false);
				rate5.setSelected(false);
				imageLibrary.getPhotos().get(index).setRating(4);
				rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());
				thumbs[index].setText("<html>Caption: "+imageLibrary.getPhotos().get(index).getCaption()+
						"<br/>Rating: 4<br/>Date: "+imageLibrary.getPhotos().get(index).getDateTaken()+"<html>");
			}

			//set action for changing rating to 5
			if (action.equals("rate5")) {
				rate2.setSelected(false);
				rate3.setSelected(false);
				rate4.setSelected(false);
				rate1.setSelected(false);
				imageLibrary.getPhotos().get(index).setRating(5);
				rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());
				thumbs[index].setText("<html>Caption: "+imageLibrary.getPhotos().get(index).getCaption()+
						"<br/>Rating: 5<br/>Date: "+imageLibrary.getPhotos().get(index).getDateTaken()+"<html>");
			}

			//set action for changing to sort by caption
			if (action.equals("sortCap")) {
				sortCap.setSelected(true);
				sortDate.setSelected(false);
				sortRate.setSelected(false);
				rate1.setSelected(false);
				rate2.setSelected(false);
				rate3.setSelected(false);
				rate4.setSelected(false);
				rate5.setSelected(false);
				Collections.sort(imageLibrary.getPhotos(), new CompareByCaption());
				change(imageLibrary);
				setRatings();
			}

			//set action for changing to sort by rating
			if (action.equals("sortRate")) {
				sortRate.setSelected(true);
				sortDate.setSelected(false);
				sortCap.setSelected(false);	
				rate1.setSelected(false);
				rate2.setSelected(false);
				rate3.setSelected(false);
				rate4.setSelected(false);
				rate5.setSelected(false);
				Collections.sort(imageLibrary.getPhotos(), new CompareByRating());
				change(imageLibrary);
				setRatings();
			}

			//set action for changing to sort by date
			if (action.equals("sortDate")) {
				sortDate.setSelected(true);
				sortCap.setSelected(false);
				sortRate.setSelected(false);
				rate1.setSelected(false);
				rate2.setSelected(false);
				rate3.setSelected(false);
				rate4.setSelected(false);
				rate5.setSelected(false);
				Collections.sort(imageLibrary.getPhotos(), new CompareByDate());
				change(imageLibrary);
				setRatings();
			}

		}

	}
	/**
	 * replaces all thumbnail icons when different sort methods are selected
	 * @param lib 
	 */
	private void change(PhotographContainer lib) {
		index=0;
		pic.setIcon(new ImageIcon(imageLibrary.getPhotos().get(index).getImageData().getScaledInstance(700, 560,
				Image.SCALE_SMOOTH)));
		icon1.setIcon(new ImageIcon(this.imageLibrary.getPhotos().get(0).getImageData().getScaledInstance(128, 102,
				Image.SCALE_SMOOTH)));
		icon2.setIcon(new ImageIcon(this.imageLibrary.getPhotos().get(1).getImageData().getScaledInstance(128, 102,
				Image.SCALE_SMOOTH)));
		icon3.setIcon(new ImageIcon(this.imageLibrary.getPhotos().get(2).getImageData().getScaledInstance(128, 102,
				Image.SCALE_SMOOTH)));
		icon4.setIcon(new ImageIcon(this.imageLibrary.getPhotos().get(3).getImageData().getScaledInstance(128, 102,
				Image.SCALE_SMOOTH)));
		icon5.setIcon(new ImageIcon(this.imageLibrary.getPhotos().get(4).getImageData().getScaledInstance(128, 102,
				Image.SCALE_SMOOTH)));
		caption.setText("<html> "+this.imageLibrary.getPhotos().get(index).getCaption()+" <html>");
		c1.setText("<html>Caption: "+this.imageLibrary.getPhotos().get(0).getCaption()+"<br/>Rating: "+this.imageLibrary.getPhotos().get(0).getRating()
				+"<br/>Date: "+this.imageLibrary.getPhotos().get(0).getDateTaken()+"<html>");
		c2.setText("<html>Caption: "+this.imageLibrary.getPhotos().get(1).getCaption()+"<br/>Rating: "+this.imageLibrary.getPhotos().get(1).getRating()
				+"<br/>Date: "+this.imageLibrary.getPhotos().get(1).getDateTaken()+"<html>");
		c3.setText("<html>Caption: "+this.imageLibrary.getPhotos().get(2).getCaption()+"<br/>Rating: "+this.imageLibrary.getPhotos().get(2).getRating()
				+"<br/>Date: "+this.imageLibrary.getPhotos().get(2).getDateTaken()+"<html>");
		c4.setText("<html>Caption: "+this.imageLibrary.getPhotos().get(3).getCaption()+"<br/>Rating: "+this.imageLibrary.getPhotos().get(3).getRating()
				+"<br/>Date: "+this.imageLibrary.getPhotos().get(3).getDateTaken()+"<html>");
		c5.setText("<html>Caption: "+this.imageLibrary.getPhotos().get(4).getCaption()+"<br/>Rating: "+this.imageLibrary.getPhotos().get(4).getRating()
				+"<br/>Date: "+this.imageLibrary.getPhotos().get(4).getDateTaken()+"<html>");
		rateNum.setText("   "+imageLibrary.getPhotos().get(index).getRating());


	}

	private void setRatings() {
		//set current rating radio buttons
		if (this.imageLibrary.getPhotos().get(index).getRating()==5) {
			rate5.setSelected(true);
			rate1.setSelected(false);
			rate2.setSelected(false);
			rate3.setSelected(false);
			rate4.setSelected(false);
		} else if (this.imageLibrary.getPhotos().get(index).getRating()==4) {
			rate4.setSelected(true);
			rate1.setSelected(false);
			rate2.setSelected(false);
			rate3.setSelected(false);
			rate5.setSelected(false);
		} else if (this.imageLibrary.getPhotos().get(index).getRating()==3) {
			rate3.setSelected(true);
			rate1.setSelected(false);
			rate2.setSelected(false);
			rate4.setSelected(false);
			rate5.setSelected(false);
		} else if (this.imageLibrary.getPhotos().get(index).getRating()==2) {
			rate2.setSelected(true);
			rate1.setSelected(false);
			rate4.setSelected(false);
			rate3.setSelected(false);
			rate5.setSelected(false);
		} else if (this.imageLibrary.getPhotos().get(index).getRating()==1) {
			rate1.setSelected(true);
			rate4.setSelected(false);
			rate2.setSelected(false);
			rate3.setSelected(false);
			rate5.setSelected(false);
		}
	}
}

