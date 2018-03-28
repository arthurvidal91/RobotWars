package com.thestreet.robotwars.enums;

import java.util.Optional;
import java.util.stream.Stream;

public enum Heading {
	NORTH('N'), WEST('W'), SOUTH('S'), EAST('E');

	private char code;

	private Heading(char code) {
		this.code = code;
	}

	public char getCode() {
		return code;
	}

	public static Heading getHeadingByCode(char code) {
		Stream<Heading> stream = Stream.of(Heading.values());
		Optional<Heading> heading = stream.filter(h -> h.getCode() == code).findFirst();

		return heading.orElseThrow(() -> new IllegalArgumentException("Invalid heading"));

	}
}
