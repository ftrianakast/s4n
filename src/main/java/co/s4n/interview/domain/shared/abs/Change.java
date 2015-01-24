package co.s4n.interview.domain.shared.abs;

import java.util.Optional;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 * @version 1.0
 */
public abstract class Change {
	private Optional<String> name;

	private Optional<String> description;

	/**
	 * Default constructor
	 * 
	 * @param name
	 * @param description
	 * @param position
	 */
	public Change(Optional<String> name, Optional<String> description) {
		super();
		this.name = name;
		this.description = description;
	}

	public Optional<String> getName() {
		return name;
	}

	public void setName(Optional<String> name) {
		this.name = name;
	}

	public Optional<String> getDescription() {
		return description;
	}

	public void setDescription(Optional<String> description) {
		this.description = description;
	}

}
