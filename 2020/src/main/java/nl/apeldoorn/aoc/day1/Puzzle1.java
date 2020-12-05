package nl.apeldoorn.aoc.day1;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class Main {

	public static void main(String args[]) throws Exception {
		Path path = Paths.get(Main.class.getClassLoader()
				.getResource("day1/input.txt").toURI());
		String[] lines = Files.lines(path).toArray(String[]::new);;
		System.out.println(lines[0]);
		log.info("start");
	}
}
