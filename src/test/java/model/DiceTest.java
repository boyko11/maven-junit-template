package model;

import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class DiceTest {
	
	private Dice dice;
	
	@Before
	public void before() {
		dice = new Dice();
	}

	@Test
	public void testRoll() throws Exception {
		
		Set<Integer> makeSureAll6NumbersAppear = new HashSet<Integer>();
		for(int i = 0; i < 100; i++) {
			int diceRollResult = dice.roll();
			assertThat(diceRollResult, allOf(greaterThan(0), lessThan(7)));
			makeSureAll6NumbersAppear.add(diceRollResult);
		}
		
		assertThat(makeSureAll6NumbersAppear.size(), is(6));
	}

}
