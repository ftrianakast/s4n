package co.s4n.interview.domain.robot;

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
	 * @param owner
	 * @param turnAction
	 * @return
	 */
	public void turnDependOnAction(Action turnAction) {
		Position predictedPosition = new Position();
		if (turnAction.equals(Action.I)) {
			predictedPosition = turnLeft();
		} else if (turnAction.equals(Action.D)) {
			predictedPosition = turnRight();
		}
		this.getOwner().setCurrentPosition(predictedPosition);
	}

	/**
	 * 
	 * @param owner
	 * @return
	 */
	private Position turnRight() {
		GeographicDirection currentGeoDirection = owner.getCurrentPosition()
				.getOrientation();
		Coordinate currentCoordinate = owner.getCurrentPosition()
				.getCoordinate();
		Position predictedPosition = new Position();
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
		predictedPosition.setOrientation(predictedGeo);
		predictedPosition.setCoordinate(currentCoordinate);
		return predictedPosition;
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
		Position predictedPosition = new Position();
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
		predictedPosition.setOrientation(predictedGeo);
		predictedPosition.setCoordinate(currentCoordinate);
		return predictedPosition;
	}

	public Robot getOwner() {
		return owner;
	}

	public void setOwner(Robot owner) {
		this.owner = owner;
	}

}