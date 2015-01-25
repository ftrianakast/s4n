package co.s4n.interview.domain.shared.abs;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 * @version 1.0
 */
public enum GeographicDirection {
	N {
		public String toString() {
			return "N";
		}
	},
	E {
		public String toString() {
			return "E";
		}
	},
	O {
		public String toString() {
			return "W";
		}
	},
	S {
		public String toString() {
			return "S";
		}
	}
}
