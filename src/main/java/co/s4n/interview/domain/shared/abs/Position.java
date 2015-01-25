package co.s4n.interview.domain.shared.abs;

/**
 * Models a Geographic position
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 *
 */
public class Position {

	private Coordinate coordinate;

	private GeographicDirection orientation;

	/**
	 * Default constructor
	 * 
	 * @param coordinate
	 * @param orientation
	 */
	public Position(Coordinate coordinate, GeographicDirection orientation) {
		this.coordinate = coordinate;
		this.orientation = orientation;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public GeographicDirection getOrientation() {
		return orientation;
	}

	public void setOrientation(GeographicDirection orientation) {
		this.orientation = orientation;
	}

	@Override
	public String toString() {
		String buildedString = this.getCoordinate().getX() + " "
				+ this.getCoordinate().getY() + " " + this.getOrientation();
		return buildedString;
	}

	@Override
	public boolean equals(Object obj) {
		Position requestedPosition = (Position) obj;
		Coordinate currentCoordinate = this.getCoordinate();
		Coordinate requestedCoordinate = requestedPosition.getCoordinate();
		GeographicDirection currentGeoDirection = this.getOrientation();
		GeographicDirection requestedGeoDirection = requestedPosition
				.getOrientation();
		boolean response = false;

		if (currentCoordinate.equals(requestedCoordinate)
				&& currentGeoDirection.equals(requestedGeoDirection)) {
			response = true;
		}
		return response;
	}

}
