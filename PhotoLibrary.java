/**
 * Homework 4
 * Matt Walsh , mw6es *
 * Sources:none 
 * */
import java.util.*;
public class PhotoLibrary extends PhotographContainer {

	private int id;
	private HashSet<Album> albums;
	/**
	 * constructor for Photolibrary
	 * @param libName
	 * @param idNum
	 */
	public PhotoLibrary(String libName, int idNum) {
		super(libName);
		id=idNum;
		albums= new HashSet<Album>();
	}

	/**
	 * gets ID number
	 * @return
	 */
	public int getId() {
		return id;
	}


	/**
	 * gets a set of albums
	 * @return set of albums
	 */
	public HashSet<Album> getAlbums() {
		return albums;
	}

	/**
	 * erases a photo
	 * @param p is a photo 
	 * @return Return true if the Photograph was removed or false if it was not there.
	 */
	public boolean removePhoto(Photograph p) {
		if (photos.contains(p)) {
			photos.remove(p);
			if (!albums.isEmpty()) {
				for (Album a: albums) {
					if (a.hasPhoto(p)) {
						a.removePhoto(p);
					}
				}
			}
			return true;
		} else {
			return false;
		}


	}


	/**
	 * return true if the current PhotoLibrary object’s id value 
	 * is equal to the id value of the PhotoLibrary object passed to equals(). 
	 * Otherwise, return false.
	 */
	public boolean equals(Object o) {

		if (o==null) {
			return false;
		} 
		if (o instanceof PhotoLibrary) {
			PhotoLibrary a= (PhotoLibrary) o;
			if (this.getId()==a.getId()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}


	/**
	 *  Generate a String that shows the values of the fields name, id, and photos.
	 */
	public String toString() {
		return ("Name: "+name+", ID number : "+id+" \nPhotos: " +photos+"\n Albums: "+albums); 
	}

	/**
	 * Return an ArrayList<Photograph> of the photos that both 
	 * PhotoLibrary a and PhotoLibrary b have posted to their feeds.
	 * @param first library to compare
	 * @param second library to compare
	 * @return list of common photos
	 */
	public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b) {
		ArrayList<Photograph> output= new ArrayList<Photograph>();
		if (a.getPhotos().size()>=b.getPhotos().size()) {
			for (int i=0; i<a.getPhotos().size(); i++) {
				if (b.getPhotos().contains(a.getPhotos().get(i))) {
					output.add(a.getPhotos().get(i));
				}
			}
		} else { 
			for (int i=0; i<b.getPhotos().size(); i++) {
				if (a.getPhotos().contains(b.getPhotos().get(i))) {
					output.add(b.getPhotos().get(i));
				}

			}
		}
		return output;
	}

	/**
	 * Returns a measure of how similar the photo feeds are between PhotoLibrary a and 
	 * PhotoLibrary b, in terms of a numerical value between 0 and 1
	 * @param library to be compared
	 * @param other library to be compared
	 * @return ratio number between 1 and 0 indicating similarity 
	 */
	public static double similarity(PhotoLibrary a, PhotoLibrary b) {

		if (commonPhotos(a, b).size()==0) {
			return 0;
		} else if (a.getPhotos().size()>=b.getPhotos().size()) {
			return (double)commonPhotos(a, b).size()/((double)b.getPhotos().size());
		} else { 
			return (double)commonPhotos(a, b).size()/((double)a.getPhotos().size());
		}
	}

	/**
	 * Creates a new Album with name albumName and adds it to the list of albums, only if an Album with that name does not already exist.
	 * @param albumName : name of album to add
	 * @return Returns true if the add was successful, false otherwise.
	 */
	public boolean createAlbum(String albumName) {
		Album a = new Album(albumName);
		return albums.add(a);
	}

	/**
	 * Removes the Album with name albumName if an Album with that name exists in the set of albums.
	 * @param albumName : name of album to remove
	 * @return Returns true if the remove was successful, false otherwise.
	 */
	public boolean removeAlbum(String albumName) {
		Album b = new Album(albumName);
		return albums.remove(b);
	}

	/**
	 * Add the Photograph p to the Album in the set of albums that has name albumName if and only if it is in the PhotoLibrary’s list of photos and it was not already in that album.
	 * @param p : photo to add
	 * @param albumName : album to add to
	 * @return Return true if the Photograph was added; return false if it was not added.
	 */
	public boolean addPhotoToAlbum(Photograph p, String albumName) {
		for (Album b: albums) {
			if (albumName.hashCode()==b.hashCode()&&photos.contains(p)) {
				return b.addPhoto(p);
			}
		}
		return false;
	}

	/**
	 * Remove the Photograph p from the Album in the set of albums that has name albumName.
	 * @param p : photo to remove
	 * @param albumName : album to remove photo from
	 * @return Return true if the photo was successfully removed. Otherwise return false
	 */
	public boolean removePhotoFromAlbum(Photograph p, String albumName) {
		for (Album b: albums) {
			if (albumName.hashCode()==b.hashCode()&&photos.contains(p)) {
				return b.removePhoto(p);
			}
		}
		return false;
	}

	/**
	 *  Given an album name, return the Album with that name from the set of albums.
	 * @param albumName : name of album to be returned
	 * @returnReturn album with album name or if an album with that name is not found, return null.
	 */
	private Album getAlbumByName(String albumName) {
		for (Album b: albums) {
			if (albumName.hashCode()==b.hashCode()) {
				return b;
			}
		}
		return null;
	}

	public static void main(String[] args) {

		//Test Photograph constructor
		Photograph p1= new Photograph("Life's a beach!", "Photo1");
		Photograph p2= new Photograph("Go Hoos!", "Photo2");
		Photograph p3= new Photograph("Life's a beach!", "Photo3");
		Photograph p4= new Photograph("Life's a beach!", "Photo1");

		//Test Photograph getter methods
		System.out.println("Caption 1: "+p1.getCaption()+"\nFilename 1: "+p1.getFilename());
		System.out.println("Caption 2: "+p2.getCaption()+"\nFilename 2: "+p2.getFilename());

		//Test Photograph equals method
		System.out.println("Photo 1 equals Photo 2: " +p1.equals(p2));
		System.out.println("Photo 1 equals Photo 3: " +p1.equals(p3));
		System.out.println("Photo 1 equals Photo 4: " +p1.equals(p4));

		//Test Photograph toString method
		System.out.println(p1.toString());
		System.out.println(p2.toString());

		//Test PhotoLibrary constructor
		PhotoLibrary lib1= new PhotoLibrary("Library1", 1);
		PhotoLibrary lib2= new PhotoLibrary("Library2", 2);
		PhotoLibrary lib3= new PhotoLibrary("Library3", 1);
		PhotoLibrary lib4= new PhotoLibrary("Library1", 1);

		//Test PhotoLibrary getName and getId methods
		System.out.println("Name: "+lib1.getName()+"\nID Number: "+lib1.getId());
		System.out.println("Name: "+lib2.getName()+"\nID Number: "+lib2.getId());

		//Test PhotoLibrary setName method
		lib1.setName("NewName1");
		System.out.println(lib1.getName());
		lib2.setName("NewName2");
		System.out.println(lib2.getName());

		//Test addPhoto and toString methods
		lib1.addPhoto(p1);
		lib1.addPhoto(p2);
		System.out.println(lib1.toString());
		lib2.addPhoto(p3);
		lib2.addPhoto(p4);
		System.out.println(lib2.toString());

		//Test hasPhoto methods
		System.out.println("lib2 contains p3: "+lib2.hasPhoto(p3));
		System.out.println("lib2 contains p2: "+lib2.hasPhoto(p2));

		//Test erasePhoto method
		lib1.removePhoto(p1);
		System.out.println(lib1.toString());
		lib1.removePhoto(p2);
		System.out.println(lib1.toString());

		//Test numPhotographs method
		System.out.println("lib1 contains "+lib1.numPhotographs()+" photos");
		System.out.println("lib2 contains "+lib2.numPhotographs()+" photos");

		//Test equals method
		lib1.setName("Library1"); //so lib 1 and lib 4 are now identical
		System.out.println("lib1 equals lib2: "+lib1.equals(lib2));
		System.out.println("lib1 equals lib3: "+lib1.equals(lib3));
		System.out.println("lib1 equals lib4: "+lib1.equals(lib4));

		//Test toString method
		System.out.println(lib1.toString());
		System.out.println(lib2.toString());

		//Test common photos
		lib1.addPhoto(p1);
		lib1.addPhoto(p2);
		lib1.addPhoto(p3);
		System.out.println("lib1 and lib2 common photos: "+commonPhotos(lib1, lib2));
		System.out.println("lib2 and lib4 common photos: "+commonPhotos(lib2, lib4));

		//Test similarity method
		lib3.addPhoto(p1);
		lib3.addPhoto(p2);
		lib4.addPhoto(p2);
		lib4.addPhoto(p3);

		System.out.println("lib1 and lib2 similarity2: "+similarity(lib1, lib2));
		System.out.println("lib3 and lib3 similarity2: "+similarity(lib3, lib4));

	}
}	
