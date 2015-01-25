package co.s4n.interview;

import java.util.List;
import java.util.stream.Collectors;

import co.s4n.interview.domain.shared.Instruction;
import co.s4n.interview.domain.shared.Instruction.Action;

/**
 * It assembles an instruction
 * @author ftrianakast
 *
 */
public class InstructionAssembler {
	/**
	 * Assemble instructions
	 * 
	 * @param line
	 * @return
	 */
	public static List<Instruction> assembleInstructions(String line) {
		return line.trim().chars().mapToObj(character -> getInstruction(character))
				.collect(Collectors.toList());
	}

	/**
	 * Gets an instruction given a char value
	 * 
	 * @param character
	 * @return
	 */
	private static Instruction getInstruction(int intChar) {
		String instruction = String.valueOf(Character.toChars(intChar));
		Instruction newInstruction = new Instruction(Action.A);
		if (Action.A.toString().equals(instruction)) {
			newInstruction.setInstruction(Action.A);
		} else if (Action.D.toString().equals(instruction)) {
			newInstruction.setInstruction(Action.D);
		} else if (Action.I.toString().equals(instruction)) {
			newInstruction.setInstruction(Action.I);
		}
		return newInstruction;
	}
}
