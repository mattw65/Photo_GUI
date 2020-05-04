/**
 * Homework 4
 * Matt Walsh, mw6es
 *
 * Sources : none
 */
import java.util.*;
public class CompareByCaption implements Comparator<Photograph> {

	/**
	 * compares two Photographs by caption (in alphabetical order). If two captions are identical, 
	 * then compare by rating, in descending order with the highest-rated photo first.
	 */
	public int compare(Photograph p1, Photograph p2) {
		if (p2.getCaption().equals(p1.getCaption())) {
			if (p2.getRating()==(p1.getRating())) {
				return 0;
			} else if (p1.getRating()>p2.getRating()) {
				return -1;
			} else return 1;
		} else if (p1.getCaption().compareTo(p2.getCaption())<0) {
			return -1;
		} else return 1;
	}
}
