package nl.apeldoorn.aoc.day9;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Puzzle extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		Long[] longLines =  Stream.of(inputLines).map(Long::valueOf).toArray(Long[]::new);
		long invalidNumber = findInvalidNumber(longLines);
		return invalidNumber;
	}

	private long findInvalidNumber(Long[] longLines) {
		int preambleSize = 25;
		boolean valid;
		int index;
		for(index=preambleSize; index<longLines.length; index++) {
			valid = false;
			outerloop:
			for(int j=index-preambleSize; j<index; j++) {
				for(int k=j+1; k<index; k++) {
					if (longLines[j] + longLines[k] == longLines[index]) {
						valid = true;
						break outerloop;
					}
				}
			}
			if (!valid) {
				break;
			}
		}
		return longLines[index];
	}

	@Override
	protected long solveSecond() {
		Long[] longLines =  Stream.of(inputLines).map(Long::valueOf).toArray(Long[]::new);
		long invalidNumber = findInvalidNumber(longLines);
		int sum = 0;
		for(int i=0; i<longLines.length; i++) {
			int j = i;
			while(sum < invalidNumber) {
				sum += longLines[j];
				j++;
			}
			if (sum == invalidNumber) {
				Long[] validRange = Arrays.copyOfRange(longLines, i, j);
				return Arrays.stream(validRange).min(Comparator.comparingLong(a -> a)).get() +
				Arrays.stream(validRange).max(Comparator.comparingLong(a -> a)).get();
			}
			sum = 0;
		}
			return 0;
	}



	public static void main(String args[]) {
		new Puzzle().solve();
	}
}
