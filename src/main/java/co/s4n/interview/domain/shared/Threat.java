package co.s4n.interview.domain.shared;

import java.util.Optional;

import co.s4n.interview.domain.shared.abs.Change;
import co.s4n.interview.domain.shared.abs.Coordinate;

/**
 * 
 * @author Felipe Triana <ftrinakast@gmail.com>
 * @version 1.0
 */
public class Threat extends Change {

	/**
	 * Threat position
	 */
	private Coordinate position;

	/**
	 * Default Constructor
	 * 
	 * @param name
	 * @param description
	 * @param position
	 */
	public Threat(Optional<String> name, Optional<String> description,
			Coordinate position) {
		super(name, description);
		this.position = position;
	}

	public Coordinate getPosition() {
		return position;
	}

	public void setPosition(Coordinate position) {
		this.position = position;
	}
}
