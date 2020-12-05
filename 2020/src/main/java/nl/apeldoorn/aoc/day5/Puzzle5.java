package nl.apeldoorn.aoc.day5;

import lombok.NoArgsConstructor;
import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@NoArgsConstructor
public class Puzzle5 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		int highest = 0;
		for(String inputLine : inputLines) {
			int row = 0, column = 0;
			for(int i=0; i<=6; i++) {
				if(inputLine.charAt(i) == 'B') {
					row += (int) Math.pow(2, 6 - i);
				}
			}
			String columnLine = inputLine.substring(7, 10);
			for(int i=0; i<=2; i++) {
				if(columnLine.charAt(i) == 'R') {
					column += (int) Math.pow(2, 2 - i);
				}
			}
			int value = row*8+column;
			if (value > highest) {
				highest = value;
			}
		}
		return highest;
	}

	@Override
	protected long solveSecond() {
		int highest = 0;
		ArrayList<Integer> values = new ArrayList<>();
		for(String inputLine : inputLines) {
			int row = 0, column = 0;
			for(int i=0; i<=6; i++) {
				if(inputLine.charAt(i) == 'B') {
					row += (int) Math.pow(2, 6 - i);
				}
			}
			String columnLine = inputLine.substring(7, 10);
			for(int i=0; i<=2; i++) {
				if(columnLine.charAt(i) == 'R') {
					column += (int) Math.pow(2, 2 - i);
				}
			}
			values.add(row*8+column);
		}
		values.addAll(IntStream.rangeClosed(0, Collections.min(values)-1)
				.boxed().collect(Collectors.toList()));
		values.addAll(IntStream.rangeClosed(Collections.max(values)+1, 1023)
				.boxed().collect(Collectors.toList()));

		List<Integer> range = IntStream.rangeClosed(0, 1023)
				.boxed().collect(Collectors.toList());
		range.removeAll(values);
		return range.get(0);
	}

	public static void main(String args[]) {
		new Puzzle5().solve();
	}
}
