package co.s4n.interview.domain.shared;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 *
 */
public class Instruction {

	private enum InstructionType {
		A, I, D
	}

	private InstructionType instruction;

	/**
	 * Constructor Type
	 * @param instruction
	 */
	public Instruction(InstructionType instruction) {
		super();
		this.instruction = instruction;
	}

	public InstructionType getInstruction() {
		return instruction;
	}

	public void setInstruction(InstructionType instruction) {
		this.instruction = instruction;
	}

}
