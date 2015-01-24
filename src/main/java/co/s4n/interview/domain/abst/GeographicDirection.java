package co.s4n.interview.domain.abst;

/**
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 * @version 1.0
 */
public enum GeographicDirection {
	N {
		public String toString() {
			return "North";
		}
	},
	E {
		public String toString() {
			return "East";
		}
	},
	O {
		public String toString() {
			return "West";
		}
	},
	S {
		public String toString() {
			return "South";
		}
	}
}
