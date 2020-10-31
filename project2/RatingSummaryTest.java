package project2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RatingSummaryTest {

	public RatingSummary rs;
	
	@BeforeEach
	public void setup() {
		rs = new RatingSummary("A1EE2E3N7PW666", 2);
	}

	// From class RatingSummary
	@Test
	void testRatingSummaryStringLongListOfFloat() {
		String actualOutput = "A1EE2E3N7PW666,2,2.0,2.0,2.0,2.0\n";
		rs.setList(2, 2, 2, 2);
		Assertions.assertTrue(actualOutput.equals(rs.toString()));
	}


	// From class AbstractRatingSummary
	@Test
	void testSetDegreeLong() {
		rs.setDegree(3);
		Assertions.assertEquals(3,rs.getDegree());
	}

	@Test
	void testSetListFloat() {
		List<Float> actual = Arrays.asList(2.0f, 2.0f, 2.0f, 2.0f);
		rs.setList(2, 2, 2, 2);

		Assertions.assertTrue(actual.equals(rs.getList()));

	}

	@Test
	void testAvgScore() {
		rs.setList(4, 1, 4, 0);
		Float avgScore = rs.getList().get(1) - rs.getList().get(3);
		assertEquals(1, avgScore); 
	}

	@Test
	void testStDevScore() {
		rs.setList(5, 1, 3, 0);
		Float stDevScore = rs.getList().get(0) - rs.getList().get(2);
		assertEquals(2, stDevScore);	
	}

}
