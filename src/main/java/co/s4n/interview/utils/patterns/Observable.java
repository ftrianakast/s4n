package co.s4n.interview.utils.patterns;


/**
 * GOF Pattern
 * 
 * @author <ftrianakast@gmail.com>
 *
 */
public interface Observable {

	void addObserver(Observer observer);

	void removeObserver(Observer observer);
}
