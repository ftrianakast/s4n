package co.s4n.interview.domain.robot;

import java.util.Optional;

import co.s4n.interview.domain.shared.Instruction.Action;
import co.s4n.interview.domain.shared.abs.Coordinate;
import co.s4n.interview.domain.shared.abs.GeographicDirection;
import co.s4n.interview.domain.shared.abs.Position;

/**
 * 
 * @author Felipe Triana <ftrianakast@gmail.com>
 * @version 1.0
 */
public class Hip {

	private Robot owner;

	/**
	 * Default constructor
	 * 
	 * @param owner
	 */
	public Hip(Robot owner) {
		super();
		this.owner = owner;
	}

	/**
	 * @param owner
	 * @param turnAction
	 * @return
	 */
	public void turnDependOnAction(Action turnAction) {
		Optional<Position> predictedPosition = Optional.empty();
		if (turnAction.equals(Action.I)) {
			// System.out.print("Girando a la izquierda...; ");
			predictedPosition = Optional.of(turnLeft());
		} else if (turnAction.equals(Action.D)) {
			// System.out.print("Girando a la derecha...; ");
			predictedPosition = Optional.of(turnRight());
		}
		this.owner.setCurrentPosition(predictedPosition.get());
//		System.out.print("My new position is "
//				+ this.owner.getCurrentPosition().toString());
//		System.out.println();
	}

	/**
	 * 
	 * @param owner
	 * @return
	 */
	private Position turnRight() {
		GeographicDirection currentGeoDirection = this.owner
				.getCurrentPosition().getOrientation();
		Coordinate currentCoordinate = this.owner.getCurrentPosition()
				.getCoordinate();
		GeographicDirection predictedGeo = currentGeoDirection;

		if (currentGeoDirection.equals(GeographicDirection.E)) {
			predictedGeo = GeographicDirection.S;
		} else if (currentGeoDirection.equals(GeographicDirection.O)) {
			predictedGeo = GeographicDirection.N;
		} else if (currentGeoDirection.equals(GeographicDirection.N)) {
			predictedGeo = GeographicDirection.E;
		} else if (currentGeoDirection.equals(GeographicDirection.S)) {
			predictedGeo = GeographicDirection.O;
		}
		return new Position(currentCoordinate, predictedGeo);
	}

	/**
	 * 
	 * @param owner
	 * @return
	 */
	private Position turnLeft() {
		GeographicDirection currentGeoDirection = owner.getCurrentPosition()
				.getOrientation();
		Coordinate currentCoordinate = owner.getCurrentPosition()
				.getCoordinate();
		GeographicDirection predictedGeo = currentGeoDirection;

		if (currentGeoDirection.equals(GeographicDirection.E)) {
			predictedGeo = GeographicDirection.N;
		} else if (currentGeoDirection.equals(GeographicDirection.O)) {
			predictedGeo = GeographicDirection.S;
		} else if (currentGeoDirection.equals(GeographicDirection.N)) {
			predictedGeo = GeographicDirection.O;
		} else if (currentGeoDirection.equals(GeographicDirection.S)) {
			predictedGeo = GeographicDirection.E;
		}
		return new Position(currentCoordinate, predictedGeo);
	}
}