package co.s4n.interview;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import co.s4n.interview.domain.robot.Robot;
import co.s4n.interview.domain.shared.Instruction;
import co.s4n.interview.domain.shared.Threat;
import co.s4n.interview.domain.shared.abs.Position;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 * @version 1.0
 */
public class Launcher {

	private static String worldPath = "./specs/input.txt";
	private static String threatPath = "./specs/threat.txt";

	/**
	 * Entry point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Container objectContainer = WorldAssembler.assembleWorld(Paths
					.get(worldPath));
			List<Threat> threats = ThreatAssembler.assembleThreats(Paths
					.get(threatPath));
			objectContainer.getWorld().setThreats(threats);
			moveRobots(objectContainer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Moves all the robots
	 * 
	 * @param objectContainer
	 */
	private static void moveRobots(Container objectContainer) {
		objectContainer.getPairRobotInstructions().forEach(
				pair -> moveRobot(pair));
	}

	/**
	 * Moves a specific robot
	 * 
	 * @param pair
	 */
	private static void moveRobot(TupleRobotInstructions pair) {
		List<Instruction> robotInstructions = pair.getInstructions();
		Robot robot = pair.getRobot();
		robotInstructions.stream().forEach(
				instruction -> robot.move(instruction));
		printResult(robot);
	}

	/**
	 * Print the summary result
	 * 
	 * @param robot
	 */
	private static void printResult(Robot robot) {
		Position currentPosition = robot.getCurrentPosition();
		System.out.println(currentPosition.toString());
		System.out.print("Amenazas detectadas: ");
		robot.getFindedThreats().stream()
				.forEach(threat -> System.out.print(threat.toString() + " "));
		System.out.println();
	}

}
