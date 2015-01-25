package co.s4n.interview.domain.world;

import java.util.List;
import java.util.Optional;

import co.s4n.interview.domain.robot.Robot;
import co.s4n.interview.domain.shared.Threat;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 * @version 1.0
 */
public class World {

	private Optional<String> name;

	private List<Robot> robots;

	private List<Threat> threats;

	private int height;

	private int width;

	/**
	 * Default constructor
	 * 
	 * @param id
	 * @param name
	 * @param robots
	 * @param threats
	 * @param height
	 * @param weight
	 */
	public World(Optional<String> name, List<Robot> robots,
			List<Threat> threats, int height, int weight) {
		super();
		this.name = name;
		this.robots = robots;
		this.threats = threats;
		this.height = height;
		this.width = weight;
	}

	/**
	 * Constructor
	 */
	public World() {
	}

	/**
	 * @param robot
	 */
	public void addRobot(Robot robot) {
		getRobots().add(robot);
	}

	/**
	 * @param robot
	 */
	public void removeRobot(Robot robot) {
		getRobots().removeIf(
				currentRobot -> currentRobot.getId().equals(robot.getId()));
	}

	public Optional<String> getName() {
		return name;
	}

	public void setName(Optional<String> name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<Robot> getRobots() {
		return robots;
	}

	public void setRobots(List<Robot> robots) {
		this.robots = robots;
	}


	public List<Threat> getThreats() {
		return threats;
	}

	public void setThreats(List<Threat> threats) {
		this.threats = threats;
	}
}
