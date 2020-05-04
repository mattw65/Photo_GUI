/**
 * Homework 4
 * Matt Walsh, mw6es
 *
 * Sources : none
 */
import java.util.*;
public class CompareByDate implements Comparator<Photograph> {

	/**
	 * compares two Photographs by caption (in alphabetical order). If two captions are identical, 
	 * then compare by rating, in descending order with the highest-rated photo first.
	 */
	public int compare(Photograph p1, Photograph p2) {
		if (p2.getDateTaken().equals(p1.getDateTaken())) {
			if (p2.getRating()==(p1.getRating())) {
				return 0;
			} else if (p1.getRating()>p2.getRating()) {
				return -1;
			} else return 1;
		} else if (p1.getDateTaken().compareTo(p2.getDateTaken())<0) {
			return -1;
		} else return 1;
	}
}
