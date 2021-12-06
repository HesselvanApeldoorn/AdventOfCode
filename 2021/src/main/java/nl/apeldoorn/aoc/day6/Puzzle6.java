package nl.apeldoorn.aoc.day6;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.Arrays;

public class Puzzle6 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		long[] fishes = new long[9];
		Arrays.stream(inputLines[0].split(",")).mapToInt(Integer::parseInt).forEach(fish -> fishes[fish]++);
		long copyfish;
		for (int i=0; i<80; i++) {
			copyfish = fishes[0];
			for (int j=0; j<8; j++) {
				fishes[j] = fishes[j + 1];
			}
			fishes[8] = copyfish;
			fishes[6] += copyfish;
		}
		return Arrays.stream(fishes).sum();
	}

	@Override
	protected long solveSecond() {
		long[] fishes = new long[9];
		Arrays.stream(inputLines[0].split(",")).mapToInt(Integer::parseInt).forEach(fish -> fishes[fish]++);
		long copyfish;
		for (int i=0; i<256; i++) {
			copyfish = fishes[0];
			for (int j=0; j<8; j++) {
				fishes[j] = fishes[j + 1];
			}
			fishes[8] = copyfish;
			fishes[6] += copyfish;
		}
		return Arrays.stream(fishes).sum();
	}

	public static void main(String args[]) {
		new Puzzle6().solve();
	}
}
