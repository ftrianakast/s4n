package co.s4n.interview.domain.shared;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 *
 */
public class Instruction {

	/**
	 * Represents the robot action
	 * 
	 * @author ftrianakast
	 *
	 */
	public enum Action {
		A {
			public String toString() {
				return "A";
			}
		},
		I {
			public String toString() {
				return "I";
			}
		},
		D {
			public String toString() {
				return "D";
			}
		}
	}

	private Action action;

	/**
	 * Constructor Type
	 * 
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

	@Override
	public String toString() {
		return this.getAction().toString();
	}
}
