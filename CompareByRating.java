/**
 * Homework 4
 * Matt Walsh, mw6es
 *
 * Sources : none
 */
import java.util.*;

public class CompareByRating implements Comparator<Photograph>{
	
	/**
	 * compares two Photographs by rating (in descending order). If two ratings are identical,
	 *  then compare by caption in alphabetical order.
	 */
	public int compare(Photograph p1, Photograph p2) {
		if (p2.getRating()==(p1.getRating())) {
			if (p2.getCaption().equals(p1.getCaption())) {
				return 0;
			} else if (p1.getCaption().compareTo(p2.getCaption())<0) {
				return -1;
			} else return 1;
		} else if (p1.getRating()>p2.getRating()) {
			return -1;
		} else return 1;
	}
}
