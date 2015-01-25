package co.s4n.interview.domain.robot;



/**
 * GOF Pattern
 * 
 * @author <ftrianakast@gmail.com>
 *
 */
public interface SensorObservable {

	void addObserver(Sensor observer);

	void removeObserver(Sensor observer);
}
