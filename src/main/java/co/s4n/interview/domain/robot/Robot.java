package co.s4n.interview.domain.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.s4n.interview.domain.shared.Instruction;
import co.s4n.interview.domain.shared.Instruction.Action;
import co.s4n.interview.domain.shared.Threat;
import co.s4n.interview.domain.shared.abs.Position;
import co.s4n.interview.domain.world.World;
import co.s4n.interview.utils.patterns.Observer;

/**
 * The robot could be observale by some sensors
 * 
 * @author Felipe Triana<ftriankast@gmail.com>
 * @version 1.0
 */
public class Robot implements SensorObservable {

	private String id;

	private Optional<String> name;

	private Optional<String> description;

	private List<Sensor> sensors;

	private List<Sensor> mvmSensorsObservers;

	private List<Threat> findedThreats;

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
	public Robot(Builder builder) {
		super();
		this.id = builder.id;
		this.name = builder.name;
		this.description = builder.description;
		this.sensors = builder.sensors;
		this.currentPosition = builder.currentPosition;
		this.hip = builder.hip;
		this.motor = builder.motor;
		this.mvmSensorsObservers = new ArrayList<Sensor>();
		this.currentWorld = builder.currentWorld;
		this.findedThreats = new ArrayList<Threat>();

	}

	/**
	 * Move to a specific position
	 * 
	 * @param instruction
	 */
	public void move(Instruction instruction) {
		Action action = instruction.getAction();
		// System.out.println("Instruction: " + action
		// + ", Current Position: "
		// + this.getCurrentPosition().toString());
		if (action.equals(Action.I) || action.equals(Action.D)) {
			hip.turnDependOnAction(action);
		} else if (action.equals(Action.A)) {
			if (!isAnExaminedPosition()) {
				notificarSensores();
			}
			motor.walk();
		}
	}

	@Override
	public void addObserver(Sensor observer) {
		mvmSensorsObservers.add(observer);
	}

	/**
	 * Notify to all listener sensors about momevent
	 */
	private void notificarSensores() {
		mvmSensorsObservers.forEach(sensorObserver -> sensorObserver.update());
	}

	/**
	 * Return is a position is an examined position
	 * 
	 * @param position
	 * @return
	 */
	private boolean isAnExaminedPosition() {
		return this
				.getFindedThreats()
				.stream()
				.anyMatch(
						threat -> threat.getPosition().equals(
								this.getCurrentPosition().getCoordinate()));
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

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public List<Threat> getFindedThreats() {
		return findedThreats;
	}

	public void setFindedThreats(List<Threat> findedThreats) {
		this.findedThreats = findedThreats;
	}

	/**
	 * This inner class allows build different representations of robot
	 * 
	 * @author Felipe Triana
	 *
	 */
	public static class Builder {
		private String id;

		private Optional<String> name;

		private Optional<String> description;

		private List<Sensor> sensors;

		@SuppressWarnings("unused")
		private List<Observer> mvmSensorsObservers;

		private Position currentPosition;

		private Hip hip;

		private Motor motor;

		private World currentWorld;

		/**
		 * Creates a minimal robot builder
		 * 
		 * @param id
		 * @param currentPosition
		 * @param currentWorld
		 */
		public Builder(String id, Position currentPosition) {
			this.id = id;
			this.currentPosition = currentPosition;
		}

		/**
		 * 
		 * @param name
		 * @return
		 */
		public Builder withName(String name) {
			this.name = Optional.of(name);
			return this;
		}

		public Builder withDescription(String description) {
			this.name = Optional.of(description);
			return this;
		}

		public Builder withSensors(List<Sensor> sensors) {
			this.sensors = sensors;
			return this;
		}

		public Builder withSensorObservers(List<Observer> sensors) {
			this.mvmSensorsObservers = sensors;
			return this;
		}

		public Builder withHip(Hip hip) {
			this.hip = hip;
			return this;
		}

		public Builder withMotor(Motor motor) {
			this.motor = motor;
			return this;
		}

		/**
		 * Construct a robot
		 */
		public Robot build() {
			return new Robot(this);
		}
	}

	@Override
	public void removeObserver(Sensor observer) {
		// TODO Auto-generated method stub

	}

}
