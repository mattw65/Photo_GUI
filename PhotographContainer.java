/**
 * Homework 4
 * Matt Walsh, mw6es
 *
 * Sources : none
 */
import java.util.*;
public abstract class PhotographContainer {

	protected String name;
	protected ArrayList<Photograph> photos;
	
	/**
	 * constructor for PhotoContainer
	 * @param albumName=name of album
	 */
	public PhotographContainer(String albumName) {
		name=albumName;
		photos = new ArrayList<Photograph>();
	}
	
	/**
	 * gets name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * sets name
	 * @param newName: name to set to
	 */
	public void setName(String newName) {
		 name=newName;
	}
	/**
	 * get photos in album
	 * @return set of photos in album
	 */
	public ArrayList<Photograph> getPhotos() {
		return photos;
	}
	/**
	 * Add the Photograph p to the list of the current object’s photos if and only if it was not already in that list
	 * @param p : photo to add
	 * @return Return true if the Photograph was added; return false if it was not added. Return false if p is null
	 */
	public boolean addPhoto(Photograph p) {
		if (p!=null) {
		return photos.add(p);
		} else {
			return false;
		}
	}
	/**
	 * checks is album has photo
	 * @param p : photo to be checked for
	 * @return Return true if the current object has p in its list of photos. Otherwise return false.
	 */
	public boolean hasPhoto(Photograph p) {
		return photos.contains(p);
	}
	/**
	 * Remove Photograph p from the album, if it exists in the list of photos.
	 * @param p : photo to be removed
	 * @return If successful, return true; else return false.
	 */
	public boolean removePhoto(Photograph p) {
		return photos.remove(p);
	}
	/**
	 * Return the number of Photographs in the current album (in photos).
	 * @return the number of Photographs in the current album (in photos).
	 */
	public int numPhotographs() {
		return photos.size();
	}
	/**
	 * Following the standard rules and conventions as shown in class, return true if the current Album object’s name value is equal to the name value of the Album object passed to equals(). Otherwise, return false.
	 */
	public boolean equals(Object o) {

		if (o==null) {
			return false;
		} 
		if (o instanceof Album) {
			 Album a= (Album) o;
			if (this.getName()==a.getName()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	/**
	 * A means to print out an Album object. Generate a String that has the name of the album on the first line, followed by a list of the contained photos’ filenames.
	 */
	public String toString() {
		return (name +"\n"+photos);
	}
	/**
	 * Override the default hashCode method in the Object class produce a unique integer for an Album. This method should return the hashCode() of the name field.
	 */
	public int hashCode() {
		return name.hashCode();
	}
	/**
	 * gets photos above or equal to input rating
	 * @param rating : input rating to find photos at or above
	 * @return list of photos with value at or above rating
	 */
	public ArrayList<Photograph> getPhotos(int rating) {
		ArrayList<Photograph> a= new ArrayList<Photograph>();
		for (int i=0; i<this.photos.size(); i++) {
			if (this.photos.get(i).getRating()>=rating)
				a.add(this.photos.get(i));				
		}
		return a;
	}
	/**
	 * returns list of photos taken in given year
	 * @param year : year to find photos in
	 * @return list of photos 
	 */
	public ArrayList<Photograph> getPhotosInYear(int year) {
		if (year>2019||year<0)
			return null;
		ArrayList<Photograph> b= new ArrayList<Photograph>();
		for (int i=0; i<photos.size(); i++) {
			if (Integer.parseInt(photos.get(i).getDateTaken().substring(0,4))==year)
				b.add(photos.get(i));				
		}
		return b;
	}
	/**
	 * gets photos taken in certain month of certain year
	 * @param month : month to find photos
	 * @param year : year to find photos
	 * @return list of photos
	 */
	public ArrayList<Photograph> getPhotosInMonth(int month, int year) {
		if (year > 2019||year<0||month<=0||month>12)
			return null;
		ArrayList<Photograph> b= new ArrayList<Photograph>();
		for (int i=0; i<photos.size(); i++) {
			if (Integer.parseInt(photos.get(i).getDateTaken().substring(0,4))==year&&
					Integer.parseInt(photos.get(i).getDateTaken().substring(5,7))==month	)
				b.add(photos.get(i));				
		}
		return b;
	}
	/**
	 * gets photos taken between given dates
	 * @param beginDate : start date of window in which photos taken will be returned
	 * @param endDate : end date of window in which photos taken will be returned
	 * @return list of photos
	 */
	public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate) {
		ArrayList<Photograph> c= new ArrayList<Photograph>();
		if (!Photograph.checkValidDate(beginDate)||!Photograph.checkValidDate(endDate)) {
			return null;
		}
		int a= Photograph.getDateNum(beginDate);
		int b= Photograph.getDateNum(endDate);
		if (b<a) {
			return null;
		}

		for (int i=0; i<photos.size(); i++) {
			if (Photograph.getDateNum(photos.get(i).getDateTaken())>=a&&Photograph.getDateNum(photos.get(i).getDateTaken())<=b)
				c.add(photos.get(i));
		}
		return c;
	}
 
}
