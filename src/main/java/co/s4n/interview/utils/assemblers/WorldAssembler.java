package co.s4n.interview.utils.assemblers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import co.s4n.interview.domain.robot.Robot;
import co.s4n.interview.domain.shared.Instruction;
import co.s4n.interview.domain.shared.Threat;
import co.s4n.interview.domain.shared.abs.Coordinate;
import co.s4n.interview.domain.shared.abs.Position;
import co.s4n.interview.domain.world.World;

/**
 * 
 * @author ftrianakast<ftrianakast@gmail.com>
 * @version 1.0
 */
public class WorldAssembler {

	/**
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static Container assembleWorld(Path path) throws IOException {
		return assemble(path);
	}

	/**
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	private static Container assemble(Path path) throws IOException {
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		List<Robot> robots = new ArrayList<Robot>();
		List<Threat> threats = new ArrayList<Threat>();
		World buildedWorld = new World(Optional.empty(), robots, threats, 0, 0);
		List<List<Instruction>> instructionsPerRobot = new ArrayList<>();

		for (int i = 0; i < lines.size(); i++) {
			String currentLine = lines.get(i);
			if (i == 0) {
				buildedWorld = assembleWorld(currentLine, buildedWorld);
			} else if (i % 2 != 0) {
				robots.add(assembleRobot(currentLine, buildedWorld));
			} else if (i % 2 == 0) {
				instructionsPerRobot.add(InstructionAssembler
						.assembleInstructions(currentLine));
			}
		}

		buildedWorld.setRobots(robots);
		List<TupleRobotInstructions> tupleRobotInstructions = assembleTupleRobotInstructions(
				robots, instructionsPerRobot);
		return new Container(buildedWorld, tupleRobotInstructions);
	}

	/**
	 * Assemble a world with threats
	 * 
	 * @param line
	 */
	private static World assembleWorld(String line, World world) {
		String[] sizes = line.trim().split(" ");
		world.setWidth(Integer.parseInt(sizes[0]));
		world.setHeight(Integer.parseInt(sizes[1]));
		return world;
	}

	/**
	 * Assemble a robot given a line
	 * 
	 * @param currentLine
	 * @param buildedWorld
	 * @return
	 */
	private static Robot assembleRobot(String currentLine, World buildedWorld) {
		Coordinate mockCoordinate = new Coordinate(0, 0);
		Robot assembledRobot = new Robot.Builder("", new Position(
				mockCoordinate, null)).build();
		assembledRobot = RobotAssember.assembleRobot(currentLine);
		assembledRobot.setCurrentWorld(buildedWorld);
		return assembledRobot;
	}

	/**
	 * 
	 * @param robots
	 * @param instructionsPerRobot
	 * @return
	 */
	private static List<TupleRobotInstructions> assembleTupleRobotInstructions(
			List<Robot> robots, List<List<Instruction>> instructionsPerRobot) {
		List<TupleRobotInstructions> robotInstructionsTuples = new ArrayList<TupleRobotInstructions>();
		for (int i = 0; i < robots.size(); i++) {
			Robot currentRobot = robots.get(i);
			TupleRobotInstructions tupleRobotInstructions = new TupleRobotInstructions(
					currentRobot, instructionsPerRobot.get(i));
			robotInstructionsTuples.add(tupleRobotInstructions);
		}
		return robotInstructionsTuples;
	}

}
