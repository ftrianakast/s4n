package co.s4n.interview.utils.assemblers;

import java.util.List;

import co.s4n.interview.domain.robot.Robot;
import co.s4n.interview.domain.shared.Instruction;

/**
 * It helps to build a pair robot instructions
 * 
 * @author Felipe Triana <ftrianakast@gmail.com>
 *
 */
public class TupleRobotInstructions {

	private Robot robot;

	private List<Instruction> instructions;

	/**
	 * Default constructor
	 * 
	 * @param robot
	 * @param instructions
	 */
	public TupleRobotInstructions(Robot robot, List<Instruction> instructions) {
		super();
		this.robot = robot;
		this.instructions = instructions;
	}

	public TupleRobotInstructions() {
		// TODO Auto-generated constructor stub
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("("
				+ this.getRobot().getCurrentPosition().getCoordinate().getX()
				+ ",");
		builder.append(this.getRobot().getCurrentPosition().getCoordinate()
				.getY()
				+ ",");
		builder.append(this.getRobot().getCurrentPosition().getOrientation()
				.toString()
				+ ")");
		builder.append(" instructions: " + instructions.toString());
		return builder.toString();
	}
}
