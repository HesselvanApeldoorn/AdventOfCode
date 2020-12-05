package nl.apeldoorn.aoc.day1;

import lombok.NoArgsConstructor;
import nl.apeldoorn.aoc.AbstractPuzzle;

@NoArgsConstructor
public class Puzzle1 extends AbstractPuzzle {

	@Override
	public int solveFirst() {
		for (int i = 0; i < inputLines.length; i++) {
			for (int j = i + 1; j < inputLines.length; j++) {
				if (inputLines[i] + inputLines[j] == 2020) {
					return inputLines[i] * inputLines[j];
				}
			}
		}
		return -1;
	}

	@Override
	protected int solveSecond() {
		for (int i = 0; i < inputLines.length; i++) {
			for (int j = i + 1; j < inputLines.length; j++) {
				for (int k = j + 1; k < inputLines.length; k++) {
					if (inputLines[i] + inputLines[j] + inputLines[k] == 2020) {
						return inputLines[i] * inputLines[j] * inputLines[k];
					}
				}
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		new Puzzle1().solve();
	}
}
