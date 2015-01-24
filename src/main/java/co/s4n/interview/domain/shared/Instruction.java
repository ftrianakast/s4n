package co.s4n.interview.domain.shared;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 *
 */
public class Instruction {

	public enum Action {
		A, I, D
	}

	private Action action;

	/**
	 * Constructor Type
	 * @param action
	 */
	public Instruction(Action action) {
		super();
		this.action = action;
	}

	public Action getAction() {
		return action;
	}

	public void setInstruction(Action instruction) {
		this.action = instruction;
	}

}
