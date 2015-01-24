package co.s4n.interview.domain.abst;

public class Position {

	private Coordinate coordinate;

	private GeographicDirection orientation;

	/**
	 * 
	 * @param coordinate
	 * @param orientation
	 */
	public Position(Coordinate coordinate, GeographicDirection orientation) {
		super();
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
}
