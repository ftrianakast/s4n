package co.s4n.interview.domain.shared;

import java.util.Optional;

import co.s4n.interview.domain.shared.abs.Change;
import co.s4n.interview.domain.shared.abs.Coordinate;

/**
 * @author Felipe Triana <ftrinakast@gmail.com>
 * @version 1.0
 */
public class Threat extends Change {

	/**
	 * It is the threat type
	 * 
	 * @author Felipe Triana
	 *
	 */
	public enum ThreatType {
		ANTI_MINE {
			public String toString() {
				return "*";
			}
		},
		OTHER {
			public String toString() {
				return "%";
			}
		}
	}

	/**
	 * Threat position
	 */
	private Coordinate position;

	/**
	 * Threat type
	 */
	private ThreatType threatType;

	/**
	 * Default Constructor
	 * 
	 * @param name
	 * @param description
	 * @param position
	 */
	public Threat(Optional<String> name, Optional<String> description,
			Coordinate position, ThreatType threatType) {
		super(name, description);
		this.position = position;
		this.threatType = threatType;
	}

	public Coordinate getPosition() {
		return position;
	}

	public void setPosition(Coordinate position) {
		this.position = position;
	}

	public ThreatType getThreatType() {
		return threatType;
	}

	public void setThreatType(ThreatType threatType) {
		this.threatType = threatType;
	}

	@Override
	public String toString() {
		String result = "(";
		result = result + this.getPosition().getX() + ",";
		result = result + this.getPosition().getY() + ")";
		return result;
	}
}
