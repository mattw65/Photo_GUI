/**
 * Homework 4
 * Matt Walsh , mw6es *
 * Sources:none 
 * */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Photograph implements Comparable<Photograph>{

	private String caption;
	private String filename;
	private String dateTaken;
	private int rating;
	protected BufferedImage imageData;
	/**
	 * constructor for photograph
	 * @param cap String for caption
	 * @param name String for name of file
	 */
	public Photograph(String cap, String name) {
		caption=cap;
		filename=name;
		dateTaken="1901-01-01";
		rating=0;
	}


	public boolean loadImageData(String filename) {
		try {
			this.imageData = ImageIO.read(new File(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public BufferedImage getImageData() {
		return this.imageData;
	}

	public void setImageData(BufferedImage image) {
		this.imageData=image;
	}
	/**
	 * Compares the dateTaken of the current Photograph object with the parameter p. 
	 * If the current object’s dateTaken is before p’s, return a negative number. 
	 * If p’s is earlier, return a positive number. If they are equal, return the 
	 * comparison of the this object’s caption with p’s caption.
	 */
	public int compareTo(Photograph p) {
		if (p.getDateTaken().equals(this.getDateTaken())) {
			if (p.getCaption().equals(this.getCaption())) {
				return 0;
			} else if (this.getCaption().compareTo(p.getCaption())<0) {
				return -1;
			} else return 1;
		} else if (this.getDateTaken().compareTo(p.getDateTaken())<0) {
			return -1;
		} else return 1;
	}

	/**
	 * another constructor for photograph 
	 * @param cap : input caption
	 * @param name : input file name
	 * @param date : input date taken
	 * @param rate : input rating
	 */
	public Photograph(String cap, String name, String date, int rate) {
		caption=cap;
		filename=name;

		if (rate>=0 && rate<=5) {
			this.rating=rate;
		} else {
			this.rating=0;
		}
		if (checkValidDate(date)) {
			this.dateTaken=date;
		} else this.dateTaken="1901-01-01";
	}

	/**
	 * gets filename
	 * @return name of file
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * gets caption
	 * @return caption
	 */
	public String getCaption() {
		return this.caption;
	}

	/**
	 * gets date taken
	 * @return date taken
	 */
	public String getDateTaken() {
		return this.dateTaken;
	}

	/**
	 * makes an 8 digit number that can be used to compare if a date is before or after another
	 * @param date : date to turn into number
	 * @return number that can be used to compare dates
	 */
	public static int getDateNum(String date) {
		int mm=Integer.parseInt(date.substring(5,7));
		int dd=Integer.parseInt(date.substring(8));
		if (mm>10&&dd>10) {
			return Integer.parseInt(date.substring(0,4)+date.substring(5,7)+date.substring(8));
		} else if (mm>10&&dd<10){
			return Integer.parseInt(date.substring(0,4)+date.substring(5,7)+"0"+date.substring(8));
		}else return Integer.parseInt(date.substring(0,4)+"0"+date.substring(5,7)+"0"+date.substring(8));

	}

	/**
	 * gets year of input date
	 * @param date : input date with year, month, and date
	 * @return year
	 */
	public static int getYearTaken(String date) {
		return Integer.parseInt(date.substring(0,4));
	}

	/**
	 * gets month of input date
	 * @param date : input date with year, month, and date
	 * @return month
	 */
	public static int getMonthTaken(String date) {
		return Integer.parseInt(date.substring(5,7));
	}

	/**
	 * gets day of input date
	 * @param date : input date with year, month, and date
	 * @return day
	 */
	public static int getDayTaken(String date) {
		return Integer.parseInt(date.substring(8));
	}

	/**
	 * checks if date is correctly formatted
	 * @param date : input date with year, month, and date
	 * @return true if date is correctly formatted or false if not
	 */
	public static boolean checkValidDate(String date) {
		if (date.length()!=10) {
			return false;
		}
		if (date.charAt(4)!='-'||date.charAt(7)!='-') {
			return false;
		}
		if (Integer.parseInt(date.substring(0,4))>2019||Integer.parseInt(date.substring(0,4))<=0) {
			return false;
		}
		if (Integer.parseInt(date.substring(5,7))>12||Integer.parseInt(date.substring(5,7))<=0) {
			return false;
		}
		if (Integer.parseInt(date.substring(8))>31||Integer.parseInt(date.substring(8))<=0) {
			return false;
		}
		if ((Integer.parseInt(date.substring(5,7))==4||Integer.parseInt(date.substring(5,7))==6||
				Integer.parseInt(date.substring(5,7))==9||Integer.parseInt(date.substring(5,7))==11)&&
				(Integer.parseInt(date.substring(8))>30)) {
			return false;
		}
		if (Integer.parseInt(date.substring(5,7))==2&&Integer.parseInt(date.substring(8))>28) {
			return false;
		}
		return true;
	}

	/**
	 * gets rating
	 * @return rating
	 */
	public int getRating() {
		return this.rating;
	}

	/**
	 * sets rating
	 * @param rate : input rate
	 */
	public void setRating(int rate) {
		if (rate>=0 && rate<=5) {
			rating=rate;
		} else {
			rating=0;
		}
	}

	/**
	 * sets caption
	 * @param cap : input caption
	 */
	public void setCaption(String cap) {
		caption=cap;
	}

	/**
	 * returns a unique number for photo based on filename
	 */
	public int hashCode() {
		return filename.hashCode();
	}

	/**
	 * return true if the Photograph object passed to equals() with caption and filename strings match (are equal to) the 
	 * caption and filename strings of the current Photograph object; otherwise, return false.
	 */
	public boolean equals(Object o) {
		if (o==null) {
			return false;
		} 
		if (o instanceof Photograph) {
			Photograph p= (Photograph) o;
			if (p.getCaption().equals(this.getCaption())&&p.getFilename().equals(this.getFilename()))  {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Generate a String that shows the values of the fields caption and filename
	 */
	public String toString() {
		return ("Caption: "+this.getCaption()+", Filename: "+this.getFilename());
	}


}




