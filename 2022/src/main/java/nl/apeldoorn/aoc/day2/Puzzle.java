package nl.apeldoorn.aoc.day2;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.Arrays;

public class Puzzle extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		return Arrays.stream(inputLines).mapToInt(line -> (line.charAt(2) - 'W') + (line.charAt(2) - line.charAt(0)+2)%3*3).sum();
	}

	@Override
	protected long solveSecond() {
		return Arrays.stream(inputLines).mapToInt(line -> (line.charAt(2) - 'X')*3 + calcResponse(line.charAt(0), line.charAt(2))).sum();
	}

	private int calcResponse(int opponent, int me) {
		if ((me + opponent)%3 == 0) {
			return 3;
		} else {
			return (me + opponent)%3;
		}
	}

	public static void main(String args[]) {
		new Puzzle().solve();
	}
}
