package co.s4n.interview.domain.shared.abs;

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

	public Position() {
		// TODO Auto-generated constructor stub
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
}
