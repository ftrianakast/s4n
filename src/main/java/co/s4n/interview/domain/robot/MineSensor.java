package co.s4n.interview.domain.robot;

import java.util.Optional;

import co.s4n.interview.domain.shared.Threat;
import co.s4n.interview.domain.shared.abs.Coordinate;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 * @version 1.0
 */
public class MineSensor implements Sensor {

	private Robot owner;

	/**
	 * Default constructo
	 * 
	 * @param owner
	 */
	public MineSensor(Robot owner) {
		super();
		this.owner = owner;
	}

	@Override
	public void update() {
		Optional<Threat> searchedMine = searchMine();
		if (searchedMine.isPresent()) {
			owner.getFindedThreats().add(searchedMine.get());
		}
	}

	/**
	 * Search for a mine
	 * 
	 * @return
	 */
	public Optional<Threat> searchMine() {
		Coordinate currentPosition = owner.getCurrentPosition().getCoordinate();
		return owner.getCurrentWorld().getThreats().stream()
				.filter(threat -> threat.getPosition().equals(currentPosition))
				.findFirst();
	}
	
}
