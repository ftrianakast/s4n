package co.s4n.interview.domain.shared.abs;

/**
 * Represents a 2D Position
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 * @version 1.0
 */
public class Coordinate {

	private int x;

	private int y;

	/**
	 * Default constructor
	 * 
	 * @param x
	 * @param y
	 */
	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object reqObj) {
		Coordinate reqCoordinate = (Coordinate) reqObj;
		boolean response = (this.getX() == reqCoordinate.getX())
				&& (this.getY() == reqCoordinate.getY());
		return response;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
