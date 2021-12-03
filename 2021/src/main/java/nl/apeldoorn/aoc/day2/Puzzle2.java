package nl.apeldoorn.aoc.day2;

import nl.apeldoorn.aoc.AbstractPuzzle;

public class Puzzle2 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		int depth = 0;
		int horizontal = 0;
		for (int i = 0; i < inputLines.length; i++) {
			int input = Integer.parseInt(inputLines[i].split(" ")[1]);
			if (inputLines[i].startsWith("forward")) {
				horizontal += input;
			} else if (inputLines[i].startsWith("down")) {
				depth += input;
			} else {
				depth -= input;
			}
		}
		return horizontal * depth;
	}

	@Override
	protected long solveSecond() {
		int aim = 0;
		int horizontal = 0;
		int depth = 0;
		for (int i = 0; i < inputLines.length; i++) {
			int input = Integer.parseInt(inputLines[i].split(" ")[1]);
			if (inputLines[i].startsWith("forward")) {
				horizontal += input;
				depth += aim * input;
			} else if (inputLines[i].startsWith("down")) {
				aim += input;
			} else {
				aim -= input;
			}
		}
		return horizontal * depth;
	}

	public static void main(String args[]) {
		new Puzzle2().solve();
	}
}
