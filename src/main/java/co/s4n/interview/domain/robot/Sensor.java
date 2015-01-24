package co.s4n.interview.domain.robot;

import java.util.Optional;

import co.s4n.interview.domain.shared.Change;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 * @version 1.0
 */
public interface Sensor {

	/**
	 * Detect changes.
	 * 
	 * @return T change if something is detected.
	 */
	public Optional<Change> detectChanges();

}
