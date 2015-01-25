package co.s4n.interview.domain.robot;

/**
 * All the elements that could be observed by some Sensor, must implement this
 * interface
 * 
 * @author <ftrianakast@gmail.com>
 *
 */
public interface SensorObservable {

	/**
	 * @param observer
	 */
	void addObserver(Sensor observer);

	/**
	 * 
	 * @param observer
	 */
	void removeObserver(Sensor observer);
}
