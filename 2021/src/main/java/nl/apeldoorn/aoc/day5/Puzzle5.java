package nl.apeldoorn.aoc.day5;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Puzzle5 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		int[][] field = new int[1000][1000];
		for(int i=0; i<inputLines.length; i++) {
			String[] parseline = inputLines[i].split(" -> ");
			int x1 = Integer.parseInt(parseline[0].split(",")[0]);
			int y1 = Integer.parseInt(parseline[0].split(",")[1]);
			int x2 = Integer.parseInt(parseline[1].split(",")[0]);
			int y2 = Integer.parseInt(parseline[1].split(",")[1]);
			if (x1 == x2) {
				if (y1 <= y2) {
					for(int j=0; j<=(y2-y1); j++) {
						field[x1][y1+j]++;
					}
				} else {
					for(int j=0; j<=(y1-y2); j++) {
						field[x1][y2+j]++;
					}
				}
			}
			if (y1 == y2) {
				if (x1 <= x2) {
					for(int j=0; j<=(x2-x1); j++) {
						field[x1+j][y1]++;
					}
				} else {
					for(int j=0; j<=(x1-x2); j++) {
						field[x2+j][y1]++;
					}
				}
			}
		}
		return Arrays.stream(field).flatMapToInt(IntStream::of).filter(number -> number > 1).count();
	}

	@Override
	protected long solveSecond() {
		int[][] field = new int[1000][1000];
		for(int i=0; i<inputLines.length; i++) {
			String[] parseline = inputLines[i].split(" -> ");
			int x1 = Integer.parseInt(parseline[0].split(",")[0]);
			int y1 = Integer.parseInt(parseline[0].split(",")[1]);
			int x2 = Integer.parseInt(parseline[1].split(",")[0]);
			int y2 = Integer.parseInt(parseline[1].split(",")[1]);
			if (x1 == x2) {
				if (y1 <= y2) {
					for(int j=0; j<=(y2-y1); j++) {
						field[x1][y1+j]++;
					}
				} else {
					for(int j=0; j<=(y1-y2); j++) {
						field[x1][y2+j]++;
					}
				}
			}
			if (y1 == y2) {
				if (x1 <= x2) {
					for(int j=0; j<=(x2-x1); j++) {
						field[x1+j][y1]++;
					}
				} else {
					for(int j=0; j<=(x1-x2); j++) {
						field[x2+j][y1]++;
					}
				}
			}
			if (Math.abs(y1 - y2) == Math.abs(x1 - x2)) {
				if (x1 > x2) {
					if (y1 > y2) {
						for(int j=0; j<= y1 -y2; j++) {
							field[x2+j][y2+j]++;
						}
					} else {
						for(int j=0; j<= y2 -y1; j++) {
							field[x2+j][y2-j]++;
						}
					}
				} else {
					if (y1 > y2) {
						for(int j=0; j<= y1 -y2; j++) {
							field[x1+j][y1-j]++;
						}
					} else {
						for(int j=0; j<= y2 -y1; j++) {
							field[x1+j][y1+j]++;
						}
					}
				}
			}
		}
		return Arrays.stream(field).flatMapToInt(IntStream::of).filter(number -> number > 1).count();
	}

	public static void main(String args[]) {
		new Puzzle5().solve();
	}
}
