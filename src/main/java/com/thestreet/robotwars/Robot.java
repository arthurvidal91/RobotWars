package com.thestreet.robotwars;

import static com.thestreet.robotwars.enums.Heading.EAST;
import static com.thestreet.robotwars.enums.Heading.NORTH;
import static com.thestreet.robotwars.enums.Heading.SOUTH;
import static com.thestreet.robotwars.enums.Heading.WEST;

import com.thestreet.robotwars.enums.Heading;

public class Robot {

	private int x, y;
	private int penalties = 0;

	private Heading heading;

	private final static int MAX_BOUNDARY = 5;
	private final static int MIN_BOUNDARY = 0;

	public Robot(int x, int y, char heading) {
		this.x = x;
		this.y = y;
		this.heading = Heading.getHeadingByCode(heading);
	}

	public void move(char control) {
		switch (control) {
		case 'L': {
			changeHeadingToLeft();
			break;
		}
		case 'R': {
			changeHeadingToRight();
			break;
		}

		case 'M': {
			makeMove();
			break;
		}
		
		default: {
			throw new IllegalArgumentException("Invalid Move");
		}
		}

	}

	private void makeMove() {

		switch (heading) {
		case WEST: {
			moveWest();
			break;
		}
		case SOUTH: {
			moveSouth();
			break;
		}
		case EAST: {
			moveEast();
			break;
		}
		case NORTH: {
			moveNorth();
			break;
		}
		}
	}

	private void moveWest() {
		int futureMove = x - 1;
		if (futureMove >= MIN_BOUNDARY) {
			x--;
		} else {
			penalties++;
		}
	}

	private void moveNorth() {
		int futureMove = y + 1;
		if (futureMove <= MAX_BOUNDARY) {
			y++;
		} else {
			penalties++;
		}
	}

	private void moveEast() {
		int futureMove = x + 1;
		if (futureMove <= MAX_BOUNDARY) {
			x++;
		} else {
			penalties++;
		}
	}

	private void moveSouth() {
		int futureMove = y - 1;
		if (futureMove >= MIN_BOUNDARY) {
			y--;
		} else {
			penalties++;
		}

	}

	private void changeHeadingToLeft() {
		switch (heading) {
		case WEST: {
			heading = SOUTH;
			break;
		}
		case SOUTH: {
			heading = EAST;
			break;
		}
		case EAST: {
			heading = NORTH;
			break;
		}
		case NORTH: {
			heading = WEST;
			break;
		}
		}
	}

	private void changeHeadingToRight() {
		switch (heading) {
		case WEST: {
			heading = NORTH;
			break;
		}
		case NORTH: {
			heading = EAST;
			break;
		}
		case EAST: {
			heading = SOUTH;
			break;
		}
		case SOUTH: {
			heading = WEST;
			break;
		}
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Heading getHeading() {
		return heading;
	}

	public void setHeading(Heading heading) {
		this.heading = heading;
	}

	public int getPenalties() {
		return penalties;
	}

	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}

}
