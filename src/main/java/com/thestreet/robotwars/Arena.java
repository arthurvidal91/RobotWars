package com.thestreet.robotwars;

public class Arena {

	private Robot robot;

	public void play(char c) {
		robot.move(c);
	}

	public void registerPlayer(Robot robot) {
		this.robot = robot;
	}

}
