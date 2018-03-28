package com.thestreet.robotwars.units;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thestreet.robotwars.Robot;
import com.thestreet.robotwars.RobotWars;

public class RobotWarsTest {

	@Test
	public void testScenario1() {
		RobotWars game = new RobotWars();
		Robot player1 = new Robot(0, 2, 'E');
		game.registerPlayer(player1);

		char[] moves = "MLMRMMMRMMRR".toCharArray();
		for (char move : moves) {
			game.play(move);
		}
		
		assertEquals(4, player1.getX());
		assertEquals(1, player1.getY());
		assertEquals('N', player1.getHeading().getCode());
		assertEquals(0, player1.getPenalties());
	}

	@Test
	public void testScenario2() {
		RobotWars game = new RobotWars();
		Robot player1 = new Robot(4, 4, 'S');
		game.registerPlayer(player1); 

		char[] moves = "LMLLMMLMMMRMM".toCharArray();
		for (char move : moves) {
			game.play(move);
		}
		
		assertEquals(0, player1.getX());
		assertEquals(1, player1.getY());
		assertEquals('W', player1.getHeading().getCode());
		assertEquals(1, player1.getPenalties());

	}

	@Test
	public void testScenario3() {
		RobotWars game = new RobotWars();
		Robot player1 = new Robot(2, 2, 'W');
		game.registerPlayer(player1);

		char[] moves = "MLMLMLM RMRMRMRM".toCharArray();
		for (char move : moves) {
			game.play(move);
		}

		assertEquals(2, player1.getX());
		assertEquals(2, player1.getY());
		assertEquals('N', player1.getHeading().getCode());
		assertEquals(0, player1.getPenalties());
	}

	@Test
	public void testScenario4() {
		RobotWars game = new RobotWars();
		Robot player1 = new Robot(1, 3, 'N');
		game.registerPlayer(player1);

		char[] moves = "MMLMMLMMMMM".toCharArray();
		for (char move : moves) {
			game.play(move);
		}

		assertEquals(0, player1.getX());
		assertEquals(0, player1.getY());
		assertEquals('S', player1.getHeading().getCode());
		assertEquals(3, player1.getPenalties());
	}

}
