package co.s4n.interview.domain.robot;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 * @version 1.0
 */
public interface Sensor {

	/**
	 * Sensor is an observer so it must observe changes of any types
	 */
	void update();

}
