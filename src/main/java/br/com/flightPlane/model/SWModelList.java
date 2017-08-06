/**
 * 
 */
package br.com.flightPlane.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Ramon Vieira
 *
 */

public class SWModelList<T> implements Serializable {

	private static final long serialVersionUID = -4120875928746397638L;

	public int count;
	
	public String next;
	
	public String previous;
	
	public ArrayList<T> results;

	public boolean hasMore() {
		return (next != null && next.length() != 0);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public ArrayList<T> getResults() {
		return results;
	}

	public void setResults(ArrayList<T> results) {
		this.results = results;
	}

	
}
