package nl.apeldoorn.aoc.day8;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Puzzle extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		int index = 0;
		int accumulator = 0;
		boolean[] visitedIndexes = new boolean[inputLines.length];
		while (!visitedIndexes[index]) {
			visitedIndexes[index] = true;
			String instruction = inputLines[index].split(" ")[0];
			if (instruction.equals("acc")) {
				accumulator += Integer.parseInt(inputLines[index].split(" ")[1]);
			} else if (instruction.equals("jmp")) {
				index += Integer.parseInt(inputLines[index].split(" ")[1]) - 1;
			}
			index++;
		}
		return accumulator;
	}

	@Override
	protected long solveSecond() {
		List<String[]> runs = new ArrayList<>();
		runs.add(inputLines);
		for(int i=0; i<inputLines.length; i++) {
			if (inputLines[i].split(" ")[0].equals("nop")) {
				String[] tempLines = Arrays.copyOf(inputLines, inputLines.length);
				tempLines[i] = tempLines[i].replace("nop", "jmp");
				runs.add(tempLines);
			} else if (inputLines[i].split(" ")[0].equals("jmp")) {
				String[] tempLines = Arrays.copyOf(inputLines, inputLines.length);
				tempLines[i] = tempLines[i].replace("jmp", "nop");
				runs.add(tempLines);
			}
		}
		for (String[] run: runs ) {
			int index = 0;
			int accumulator = 0;
			boolean[] visitedIndexes = new boolean[run.length];
			while (!visitedIndexes[index]) {
				visitedIndexes[index] = true;
				String instruction = run[index].split(" ")[0];
				if (instruction.equals("acc")) {
					accumulator += Integer.parseInt(run[index].split(" ")[1]);
				} else if (instruction.equals("jmp")) {
					index += Integer.parseInt(run[index].split(" ")[1]) - 1;
				}
				index++;
				if (index >= visitedIndexes.length) {
					return accumulator;
				}
			}
		}
		return 0;
	}



	public static void main(String args[]) {
		new Puzzle().solve();
	}
}
