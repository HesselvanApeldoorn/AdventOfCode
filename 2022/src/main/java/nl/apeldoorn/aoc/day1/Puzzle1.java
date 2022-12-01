package nl.apeldoorn.aoc.day1;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.PriorityQueue;

public class Puzzle1 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		int max = 0;
		int current = 0;
		for (int i = 0; i < inputLines.length; i++) {
			if (inputLines[i].length() == 0) {
				if (current > max) {
					max = current;
				}
				current = 0;
			} else {
				current += Integer.parseInt(inputLines[i]);
			}
		}
		return max;
	}

	@Override
	protected long solveSecond() {
		PriorityQueue<Integer> max = new PriorityQueue<>();
		max.add(0);
		max.add(0);
		max.add(0);
		int current = 0;
		for (int i = 0; i < inputLines.length; i++) {
			if (inputLines[i].length() == 0) {
				max.add(current);
				max.remove();
				current = 0;
			} else {
				current += Integer.parseInt(inputLines[i]);
			}
		}
		max.add(current);
		max.remove();
		return max.poll() + max.poll() + max.poll();
	}

	public static void main(String args[]) {
		new Puzzle1().solve();
	}
}
