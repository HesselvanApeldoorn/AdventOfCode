package nl.apeldoorn.aoc.day7;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Puzzle7 extends AbstractPuzzle {
	private List<Bag> bags;
	private Set<String> foundBagNames = new HashSet<>();

	@Override
	public long solveFirst() {
		bags = SortBags();
		findContainment("shinygold");
		return foundBagNames.size();
	}

	@Override
	protected long solveSecond() {
		bags = SortBags();
		return findContents(1, "shinygold");
	}

	private int findContents(int count, String bagname) {
		final List<Integer> totalValues = new ArrayList<>();
		bags.stream().filter(bag -> bag.name.equals(bagname)).findFirst().ifPresent(bag ->
				bag.contents.forEach((key, value) ->
					totalValues.add(value + findContents(value, key))));
		return count * totalValues.stream().mapToInt(Integer::intValue).sum();
	}

	private void findContainment(String bagname) {
		bags.stream().filter(bag -> bag.contents.containsKey(bagname)).forEach(bag -> {
			foundBagNames.add(bag.name);
			findContainment(bag.name);
		});
	}

	private List<Bag> SortBags() {
		List<Bag> bags = new ArrayList<>();
		Arrays.stream(inputLines).forEach(inputLine -> {
			String[] tokens = inputLine.split(" ");
			Bag bag = new Bag(tokens[0] + tokens[1]);
			String[] Stringbags = inputLine.split("contain")[1].split(",");
			for(String Stringbag: Stringbags) {
				int quantity = getQuantity(Stringbag.split(" ")[1]);
				String contentname = Stringbag.split(" ")[2] + Stringbag.split(" ")[3];
				bag.contents.put(contentname, quantity);
			}
			bags.add(bag);
		});
		return bags;
	}

	private int getQuantity(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}

	class Bag {
		public String name;
		public Map<String, Integer> contents;

		public Bag(String name) {
			this.name = name;
			contents = new HashMap<>();
		}
	}

	public static void main(String args[]) {
		new Puzzle7().solve();
	}
}
