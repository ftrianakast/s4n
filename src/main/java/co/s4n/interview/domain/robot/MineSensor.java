package co.s4n.interview.domain.robot;

import java.util.List;
import java.util.Optional;

import co.s4n.interview.domain.shared.Threat;
import co.s4n.interview.domain.shared.abs.Position;
import co.s4n.interview.utils.patterns.Observer;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 * @version 1.0
 */
public class MineSensor implements Observer {

	private Robot owner;

	private List<Threat> findedThreats;

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
			findedThreats.add(searchMine().get());
		}
	}

	/**
	 * Search for a mine
	 * @return
	 */
	public Optional<Threat> searchMine() {
		Position currentPosition = owner.getCurrentPosition();
		return owner.getCurrentWorld().getThreats().stream()
				.filter(threat -> threat.getPosition().equals(currentPosition))
				.findFirst();
	}
}
