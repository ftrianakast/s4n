package co.s4n.interview.utils.assemblers;

import java.util.List;

import co.s4n.interview.domain.world.World;

/**
 * Mock that helps to collect all the world objects and instructions
 * @author ftrianakast
 *
 */
public class Container {

	private World world;
	
	private List<TupleRobotInstructions> pairRobotInstructions;

	
	/**
	 * Default constructor
	 * @param world
	 * @param pairRobotInstructions
	 */
	public Container(World world,
			List<TupleRobotInstructions> pairRobotInstructions) {
		super();
		this.world = world;
		this.pairRobotInstructions = pairRobotInstructions;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public List<TupleRobotInstructions> getPairRobotInstructions() {
		return pairRobotInstructions;
	}

	public void setPairRobotInstructions(
			List<TupleRobotInstructions> pairRobotInstructions) {
		this.pairRobotInstructions = pairRobotInstructions;
	}
	
	
	
}
