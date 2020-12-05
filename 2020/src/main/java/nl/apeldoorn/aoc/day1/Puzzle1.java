package nl.apeldoorn.aoc.day1;

import lombok.NoArgsConstructor;
import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.Arrays;

@NoArgsConstructor
public class Puzzle1 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		int[] inputInts = Arrays.stream(inputLines).mapToInt(i -> Integer.parseInt(i)).toArray();
		for (int i = 0; i < inputInts.length; i++) {
			for (int j = i + 1; j < inputInts.length; j++) {
				if (inputInts[i] + inputInts[j] == 2020) {
					return inputInts[i] * inputInts[j];
				}
			}
		}
		return -1;
	}

	@Override
	protected long solveSecond() {
		int[] inputInts = Arrays.stream(inputLines).mapToInt(i -> Integer.parseInt(i)).toArray();
		for (int i = 0; i < inputInts.length; i++) {
			for (int j = i + 1; j < inputInts.length; j++) {
				for (int k = j + 1; k < inputInts.length; k++) {
					if (inputInts[i] + inputInts[j] + inputInts[k] == 2020) {
						return inputInts[i] * inputInts[j] * inputInts[k];
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
