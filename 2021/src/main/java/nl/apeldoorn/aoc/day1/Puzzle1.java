package nl.apeldoorn.aoc.day1;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.Arrays;

public class Puzzle1 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		int[] inputInts = Arrays.stream(inputLines).mapToInt(i -> Integer.parseInt(i)).toArray();
		int count = 0;
		for (int i = 1; i < inputInts.length; i++) {
			if (inputInts[i] > inputInts[i - 1]) {
				count++;
			}
		}
		return count;
	}

	@Override
	protected long solveSecond() {
		int[] inputInts = Arrays.stream(inputLines).mapToInt(i -> Integer.parseInt(i)).toArray();
		int count = 0;
		for (int i = 0; i < inputInts.length - 3; i++) {
			if (inputInts[i + 3] > inputInts[i]) {
				count++;
			}
		}
		return count;

	}

	public static void main(String args[]) {
		new Puzzle1().solve();
	}
}
