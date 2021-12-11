package nl.apeldoorn.aoc.day11;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.Arrays;

public class Puzzle11 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		int flashes = 0;
		int[][] grid = new int[inputLines.length+2][inputLines.length+2];
		for(int i=1; i<grid.length-1; i++) {
			inputLines[i-1] = "0" + inputLines[i-1] + "0";
			grid[i] = Arrays.stream(inputLines[i-1].split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		for(int step =0; step<100; step++) {
			for (int i = 1; i < grid.length; i++) {
				for (int j = 1; j < grid.length; j++) {
					if (grid[i][j] < 0) {
						grid[i][j] = 0;
					}
					grid[i][j]++;
				}
			}
			boolean stillIncreasing = true;
			while(stillIncreasing) {
				stillIncreasing = false;
				for (int i = 1; i < grid.length-1; i++) {
					for (int j = 1; j < grid.length-1; j++) {
						if (grid[i][j] > 9) {
							flashes++;
							grid[i][j] = -10;
							grid[i][j-1]++;
							grid[i][j+1]++;
							grid[i-1][j-1]++;
							grid[i-1][j]++;
							grid[i-1][j+1]++;
							grid[i+1][j-1]++;
							grid[i+1][j]++;
							grid[i+1][j+1]++;
							stillIncreasing = true;
						}
					}
				}
			}
		}
		return flashes;
	}

	@Override
	protected long solveSecond() {
		int[][] grid = new int[inputLines.length+2][inputLines.length+2];
		for(int i=1; i<grid.length-1; i++) {
			inputLines[i-1] = "0" + inputLines[i-1] + "0";
			grid[i] = Arrays.stream(inputLines[i-1].split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		boolean simultaneousFlash = false;
		int step = 0;
		while(!simultaneousFlash) {
			step++;
			for (int i = 1; i <  grid.length; i++) {
				for (int j = 1; j < grid.length; j++) {
					if (grid[i][j] < 0) {
						grid[i][j] = 0;
					}
					grid[i][j]++;
				}
			}
			boolean stillIncreasing = true;
			while(stillIncreasing) {
				stillIncreasing = false;
				for (int i = 1; i < grid.length-1; i++) {
					for (int j = 1; j < grid.length-1; j++) {
						if (grid[i][j] > 9) {
							grid[i][j] = -10;
							grid[i][j-1]++;
							grid[i][j+1]++;
							grid[i-1][j-1]++;
							grid[i-1][j]++;
							grid[i-1][j+1]++;
							grid[i+1][j-1]++;
							grid[i+1][j]++;
							grid[i+1][j+1]++;
							stillIncreasing = true;
						}
					}
				}
			}
			int size = 10;
			int[][] part = new int[size][size];
			for (int i=1; i< grid.length-1; i++) {
				System.arraycopy(grid[i], 1, part[i-1], 0, size);
			}
			simultaneousFlash = Arrays.stream(part).flatMapToInt(Arrays::stream).allMatch(gridValue -> gridValue < 0);
		}
		return step;
	}

	public static void main(String args[]) {
		new Puzzle11().solve();
	}
}
