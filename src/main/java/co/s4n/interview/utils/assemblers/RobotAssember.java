package co.s4n.interview.utils.assemblers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.s4n.interview.domain.robot.Hip;
import co.s4n.interview.domain.robot.MineSensor;
import co.s4n.interview.domain.robot.Motor;
import co.s4n.interview.domain.robot.Robot;
import co.s4n.interview.domain.robot.Sensor;
import co.s4n.interview.domain.shared.abs.Coordinate;
import co.s4n.interview.domain.shared.abs.GeographicDirection;
import co.s4n.interview.domain.shared.abs.Position;

/**
 * 
 * @author Felipe Triana
 * @version 1.0
 */
public class RobotAssember {

	/**
	 * 
	 * @param line
	 * @return
	 */
	public static Robot assembleRobot(String line) {
		String[] geographicPoints = line.trim().split(" ");
		List<Sensor> sensors = new ArrayList<Sensor>();
		Coordinate coordinate = new Coordinate(
				Integer.parseInt(geographicPoints[0]),
				Integer.parseInt(geographicPoints[1]));
		GeographicDirection geo = assembleGeographicDirection(geographicPoints[2]);
		Position position = new Position(coordinate, geo);
		String robotId = UUID.randomUUID().toString();
		Robot robot = new Robot.Builder(robotId, position).build();

		Sensor mineSensor = new MineSensor(robot);
		sensors.add((Sensor) mineSensor);
		robot.addObserver((MineSensor) mineSensor);
		robot.setHip(new Hip(robot));
		robot.setMotor(new Motor(robot));
		return robot;
	}

	/**
	 * 
	 * @return
	 */
	private static GeographicDirection assembleGeographicDirection(
			String textGeoDirection) {
		Optional<GeographicDirection> geoDir = Optional.empty();
		if (textGeoDirection.equals("N")) {
			geoDir = Optional.of(GeographicDirection.N);
		} else if (textGeoDirection.equals("E")) {
			geoDir = Optional.of(GeographicDirection.E);
		} else if (textGeoDirection.equals("O")) {
			geoDir = Optional.of(GeographicDirection.O);
		} else if (textGeoDirection.equals("S")) {
			geoDir = Optional.of(GeographicDirection.S);
		}
		return geoDir.get();
	}
}
