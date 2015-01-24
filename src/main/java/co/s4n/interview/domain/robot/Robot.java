package co.s4n.interview.domain.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.s4n.interview.domain.shared.Instruction;
import co.s4n.interview.domain.shared.Instruction.Action;
import co.s4n.interview.domain.shared.abs.Position;
import co.s4n.interview.domain.world.World;
import co.s4n.interview.utils.patterns.Observable;
import co.s4n.interview.utils.patterns.Observer;

/**
 * 
 * @author Felipe Triana<ftriankast@gmail.com>
 * @version 1.0
 */
public class Robot implements Observable {

	private String id;

	private Optional<String> name;

	private Optional<String> description;

	private List<Sensor> sensors;

	private List<Observer> mvmSensorsObservers;

	private Position currentPosition;

	private Hip hip;

	private Motor motor;

	
	private World currentWorld;

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
			Position currentpostion, Hip hip, Motor motor, World currentWorld) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.sensors = sensors;
		this.currentPosition = currentpostion;
		this.hip = hip;
		this.motor = motor;
		this.mvmSensorsObservers = new ArrayList<Observer>();
		this.currentWorld = currentWorld;
	}

	/**
	 * Move to a specific position
	 * 
	 * @param instruction
	 */
	public void move(Instruction instruction) {
		Action action = instruction.getAction();
		if (action.equals(Action.I) || action.equals(Action.D)) {
			hip.turnDependOnAction(action);
		} else if (action.equals(Action.A)) {
			motor.walk();
			notificarSensores();
		}
	}

	@Override
	public void addObserver(Observer observer) {
		mvmSensorsObservers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		mvmSensorsObservers.remove(observer);
	}

	/**
	 * Notify to all listener sensors about momevent
	 */
	private void notificarSensores() {
		mvmSensorsObservers.forEach(sensorObserver -> sensorObserver.update());
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

	public Hip getHip() {
		return hip;
	}

	public void setHip(Hip hip) {
		this.hip = hip;
	}

	public World getCurrentWorld() {
		return currentWorld;
	}

	public void setCurrentWorld(World currentWorld) {
		this.currentWorld = currentWorld;
	}
}
