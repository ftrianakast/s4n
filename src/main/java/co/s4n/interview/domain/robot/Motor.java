package co.s4n.interview.domain.robot;

import co.s4n.interview.domain.shared.abs.Coordinate;
import co.s4n.interview.domain.shared.abs.GeographicDirection;
import co.s4n.interview.domain.shared.abs.Position;

/**
 * It allows to a robot go forward
 * 
 * @author ftrianakast
 *
 */
public class Motor {

	/**
	 * Robot owner
	 */
	private Robot owner;

	/**
	 * Constructor
	 * 
	 * @param owner
	 */
	public Motor(Robot owner) {
		super();
		this.owner = owner;
	}

	/**
	 * Predict position id 'Adelante' action is taken
	 * 
	 * @return
	 */
	public void walk() {
		Coordinate predictedCoordinate = new Coordinate(0, 0);
		GeographicDirection currentGeoDirection = owner.getCurrentPosition()
				.getOrientation();
		Coordinate currentCoordinate = owner.getCurrentPosition()
				.getCoordinate();

		// System.out.print("Walk...;");
		if (currentGeoDirection.equals(GeographicDirection.E)) {
			predictedCoordinate.setX(currentCoordinate.getX() + 1);
			predictedCoordinate.setY(currentCoordinate.getY());
		} else if (currentGeoDirection.equals(GeographicDirection.O)) {
			predictedCoordinate.setX(currentCoordinate.getX() - 1);
			predictedCoordinate.setY(currentCoordinate.getY());
		} else if (currentGeoDirection.equals(GeographicDirection.N)) {
			predictedCoordinate.setX(currentCoordinate.getX());
			predictedCoordinate.setY(currentCoordinate.getY() + 1);
		} else if (currentGeoDirection.equals(GeographicDirection.S)) {
			predictedCoordinate.setX(currentCoordinate.getX());
			predictedCoordinate.setY(currentCoordinate.getY() - 1);
		}

		Position newPosition = new Position(predictedCoordinate,
				currentGeoDirection);
		owner.setCurrentPosition(newPosition);
		// System.out.println(" My new position is: "
		// + this.owner.getCurrentPosition().toString());
	}

}
