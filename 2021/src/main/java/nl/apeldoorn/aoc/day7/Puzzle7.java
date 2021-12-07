package nl.apeldoorn.aoc.day7;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Puzzle7 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		int maxCrab = Arrays.stream(inputLines[0].split(",")).mapToInt(Integer::parseInt).max().getAsInt()+1;
		long[] crabs = new long[maxCrab];
		Arrays.stream(inputLines[0].split(",")).mapToInt(Integer::parseInt).forEach(crab -> crabs[crab]++);
		int minimalRequiredFuel = Integer.MAX_VALUE;
		for (int i=0; i<maxCrab; i++) {
			int requiredFuel = 0;
			for(int j=0; j<maxCrab; j++) {
				requiredFuel += Math.abs(i-j)*crabs[j];
			}
			if (requiredFuel < minimalRequiredFuel) {
				minimalRequiredFuel = requiredFuel;
			}

		}
		return minimalRequiredFuel;
	}

	@Override
	protected long solveSecond() {
		int maxCrab = Arrays.stream(inputLines[0].split(",")).mapToInt(Integer::parseInt).max().getAsInt()+1;
		long[] crabs = new long[maxCrab];
		Arrays.stream(inputLines[0].split(",")).mapToInt(Integer::parseInt).forEach(crab -> crabs[crab]++);
		int minimalRequiredFuel = Integer.MAX_VALUE;
		for (int i=0; i<maxCrab; i++) {
			int requiredFuel = 0;
			for(int j=0; j<maxCrab; j++) {
				requiredFuel += IntStream.rangeClosed(0, Math.abs(i-j)).sum()*crabs[j];
			}
			if (requiredFuel < minimalRequiredFuel) {
				minimalRequiredFuel = requiredFuel;
			}

		}
		return minimalRequiredFuel;
	}

	public static void main(String args[]) {
		new Puzzle7().solve();
	}
}
