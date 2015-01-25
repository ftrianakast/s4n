package co.s4n.interview.utils.assemblers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import co.s4n.interview.domain.shared.Threat;
import co.s4n.interview.domain.shared.Threat.ThreatType;
import co.s4n.interview.domain.shared.abs.Coordinate;

/**
 * It assemble the threats existing in a file archive
 * 
 * @author Felipe Triana<ftrianakast@gmail.com>
 *
 */
public class ThreatAssembler {

	/**
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static List<Threat> assembleThreats(Path path) throws IOException {
		return Files.lines(path).map(line -> buildThreat(line))
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @param line
	 * @return
	 */
	private static Threat buildThreat(String line) {
		char[] chars = line.toCharArray();
		int x = 0;
		int y = 0;
		ThreatType threatType = ThreatType.ANTI_MINE;
		for (int i = 0; i < chars.length; i++) {
			char character = chars[i];
			if (i == 1) {
				x = Integer.parseInt(String.valueOf(character));
			} else if (i == 3) {
				y = Integer.parseInt(String.valueOf(character));
			} else if (i == 5) {
				threatType = determineThreatType(String.valueOf(character));
			}
		}
		Threat threat = new Threat(Optional.empty(), Optional.empty(),
				new Coordinate(x, y), threatType);
		return threat;
	}

	/**
	 * 
	 * @param threatText
	 * @return
	 */
	private static ThreatType determineThreatType(String threatText) {
		ThreatType threatType = ThreatType.ANTI_MINE;
		if (threatText.equals(ThreatType.ANTI_MINE.toString())) {
			threatType = ThreatType.ANTI_MINE;
		} else if (threatText.equals(ThreatType.OTHER.toString())) {
			threatType = ThreatType.OTHER;
		}
		return threatType;
	}
}
