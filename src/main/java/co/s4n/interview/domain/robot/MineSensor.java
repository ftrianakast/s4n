package co.s4n.interview.domain.robot;

import java.util.Optional;

import co.s4n.interview.domain.shared.Change;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 * @version 1.0
 */
public class MineSensor implements Sensor {

	@Override
	public Optional<Change> detectChanges() {
		return Optional.empty();
	}

}
