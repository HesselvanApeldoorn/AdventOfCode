package nl.apeldoorn.aoc.day2;

import lombok.NoArgsConstructor;
import nl.apeldoorn.aoc.AbstractPuzzle;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor
public class Puzzle2 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		int valid = 0;
		for(String inputline : inputLines) {
			String appearances = inputline.split(" ")[0];
			int minimum = Integer.parseInt(appearances.split("-")[0]);
			int maximum = Integer.parseInt(appearances.split("-")[1]);
			char character = inputline.split(" ")[1].charAt(0);
			String password = inputline.split(" ")[2];
			int occurences = StringUtils.countMatches(password, character);
			if (minimum <= occurences && maximum >= occurences) {
				valid++;
			}
		}
		return valid;
	}

	@Override
	protected long solveSecond() {
		int valid = 0;
		for(String inputline : inputLines) {
			String appearances = inputline.split(" ")[0];
			int first = Integer.parseInt(appearances.split("-")[0]);
			int second = Integer.parseInt(appearances.split("-")[1]);
			char character = inputline.split(" ")[1].charAt(0);
			String password = inputline.split(" ")[2];
			if (second <= password.length()) {
				if (password.charAt(first-1) == character && !(password.charAt(second-1) == character)) {
					valid++;
				} else if (!(password.charAt(first-1) == character) && password.charAt(second-1) == character) {
					valid++;
				}
			}
		}
		return valid;
	}

	public static void main(String args[]) {
		new Puzzle2().solve();
	}
}
