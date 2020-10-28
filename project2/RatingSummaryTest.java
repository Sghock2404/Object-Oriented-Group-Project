package project2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import project1.RatingSummary;

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
		Assertions.assertEquals(rs.getDegree(), 3);
	}

	@Test
	void testSetListFloat() {
		List<Float> actual = Arrays.asList(2.0f, 2.0f, 2.0f, 2.0f);
		rs.setList(2.0f, 2.0f, 2.0f, 2.0f);

		Assertions.assertTrue(actual.equals(rs.getList()));

	}

	



}
