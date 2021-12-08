package nl.apeldoorn.aoc.day8;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.Arrays;
import java.util.stream.Stream;

public class Puzzle8 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		return Arrays.stream(inputLines)
				.map(inputLine -> inputLine.split("\\|")[1])
				.map(inputLine -> inputLine.split(" "))
				.flatMap(Stream::of)
				.filter(inputline -> inputline.length() == 2 || inputline.length() == 3 || inputline.length() == 4 || inputline.length() == 7)
				.count();
	}

	@Override
	protected long solveSecond() {
		return -1;
	}

	public static void main(String args[]) {
		new Puzzle8().solve();
	}
}
