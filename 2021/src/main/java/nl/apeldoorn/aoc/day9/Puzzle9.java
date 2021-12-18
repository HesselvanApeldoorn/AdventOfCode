package nl.apeldoorn.aoc.day9;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Puzzle9 extends AbstractPuzzle {

	int[][] grid;
	boolean[][] visited;
	int[][] lowPoints;
	@Override
	public long solveFirst() {
		grid = new int[inputLines.length][inputLines.length];
		for(int i=0; i<grid.length; i++) {
			grid[i] = Arrays.stream(inputLines[i].split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		lowPoints = new int[grid.length][grid[0].length];
		visited = new boolean[grid.length][grid[0].length];
		for(int y=0; y<grid.length; y++) {
			for (int x=0; x<grid[0].length; x++) {
				findLowerPoint(y, x);
			}
		}
		return Arrays.stream(lowPoints).flatMapToInt(IntStream::of).sum();
	}

	private void findLowerPoint(int y, int x) {
		if (!visited[y][x]) {
			int current = grid[y][x];
			visited[y][x] = true;
			if (y != 0 && current >= grid[y - 1][x]) {
				findLowerPoint(y - 1, x);
			} else if (y != grid.length - 1 && current >= grid[y + 1][x]) {
				findLowerPoint(y + 1, x);
			} else if (x != 0 && current >= grid[y][x - 1]) {
				findLowerPoint(y, x - 1);
			} else if (x != grid[0].length - 1 && current >= grid[y][x + 1]) {
				findLowerPoint(y, x + 1);
			} else {
				lowPoints[y][x] = grid[y][x] + 1;
			}
		}
	}

	@Override
	protected long solveSecond() {
		grid = new int[inputLines.length][inputLines.length];
		for(int i=0; i<grid.length; i++) {
			grid[i] = Arrays.stream(inputLines[i].split(""))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		lowPoints = new int[grid.length][grid[0].length];
		visited = new boolean[grid.length][grid[0].length];
		for(int y=0; y<grid.length; y++) {
			for (int x=0; x<grid[0].length; x++) {
				findLowerPoint(y, x);
			}
		}
		visited = new boolean[grid.length][grid[0].length];
		int[][] basin = new int[grid.length][grid[0].length];
		for (int y=0; y<grid.length; y++) {
			for (int x=0; x<grid[0].length; x++) {
				if (lowPoints[y][x] != 0) {
					basin[y][x] = addToBasin(y, x);
				}
			}
		}
		return Arrays.stream(basin).flatMapToInt(IntStream::of)
				.map(i -> -i).sorted().map(i -> -i)
				.limit(3L)
				.reduce(1, Math::multiplyExact);
	}

	private int addToBasin(int y, int x) {
		if (y < 0 || x < 0 || y == grid.length || x == grid[0].length || grid[y][x] == 9 || visited[y][x]) {
			return 0;
		}
		visited[y][x] = true;
		return addToBasin(y, x + 1) + addToBasin(y, x - 1) + addToBasin(y + 1, x) + addToBasin(y - 1, x) + 1;
	}

	public static void main(String[] args) {
		new Puzzle9().solve();
	}
}
