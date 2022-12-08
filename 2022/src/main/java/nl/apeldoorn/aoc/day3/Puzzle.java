package nl.apeldoorn.aoc.day3;

import nl.apeldoorn.aoc.AbstractPuzzle;

public class Puzzle extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		int sum = 0;
		for (String inputline : inputLines) {
			String firstHalf = inputline.substring(0, inputline.length() / 2);
			String secondHalf = inputline.substring(inputline.length() / 2);
			for (char c : firstHalf.toCharArray()) {
				if (secondHalf.contains("" + c)) {
					if (Character.isUpperCase(c)) {
						sum += c - 38;
					} else {
						sum += c - 96;
					}
					break;
				}
			}
		}
		return sum;
	}

	@Override
	protected long solveSecond() {
		int sum = 0;
		for (int i = 0; i < inputLines.length; i += 3) {
			for (char c : inputLines[i].toCharArray()) {
				if (inputLines[i+1].contains("" + c) && inputLines[i+2].contains("" + c)) {
					if (Character.isUpperCase(c)) {
						sum += c - 38;
					} else {
						sum += c - 96;
					}
					break;
				}
			}
		}
		return sum;
	}


	public static void main(String args[]) {
		new Puzzle().solve();
	}
}
