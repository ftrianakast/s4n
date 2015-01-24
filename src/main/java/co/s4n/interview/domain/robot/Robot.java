package co.s4n.interview.domain.robot;

import java.util.List;
import java.util.Optional;

import co.s4n.interview.domain.abst.Position;

/**
 * 
 * @author Felipe Triana<ftriankast@gmail.com>
 * @version 1.0
 */
public class Robot {

	private String id;

	private Optional<String> name;

	private Optional<String> description;

	private List<Sensor> sensors;

	private Position currentPosition;

	/**
	 * Default constructor
	 * 
	 * @param id
	 * @param name
	 * @param description
	 * @param sensors
	 * @param currentpostion
	 */
	public Robot(String id, Optional<String> name,
			Optional<String> description, List<Sensor> sensors,
			Position currentpostion) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.sensors = sensors;
		this.currentPosition = currentpostion;
	}


	public Optional<String> getName() {
		return name;
	}

	public void setName(Optional<String> name) {
		this.name = name;
	}

	public Optional<String> getDescription() {
		return description;
	}

	public void setDescription(Optional<String> description) {
		this.description = description;
	}

	public List<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}

	public Position getCurrentPostion() {
		return currentPosition;
	}

	public void setCurrentpostion(Position currentpostion) {
		this.currentPosition = currentpostion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Position getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}
}
