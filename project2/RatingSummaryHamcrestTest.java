package project2;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class RatingSummaryHamcrestTest {

  @Test 
  public void testEquals() { 
  	RatingSummary rs1 = new RatingSummary("A1EE2E3N7PW666", 2);
	RatingSummary rs2 = rs1;
	
    assertThat(rs1, equalTo(rs2)); 

  } 

  @Test
  public void testRatingSummaryHasToString() {
    RatingSummary rs = new RatingSummary("AQNPK1Q7HIAP3", 2, 4, 5, 3, 2);

    assertThat(rs, hasToString("AQNPK1Q7HIAP3,2,4.0,5.0,3.0,2.0\n"));
  }

  @Test
  public void testGetDegreeNotNull() {
    RatingSummary rs = new RatingSummary("AQNPK1Q7HIAP3", 2);
    assertThat(rs.getDegree(), is(notNullValue()));
  }

  @Test
  public void testRatingSummaryContainsString() {
    RatingSummary rs = new RatingSummary("B000GFDAUG", 2);

    assertThat(rs.getNodeID(), startsWith("B"));
  }

  @Test
  public void testTwoSimilarEntriesAreNotTheSameInstance() {
    RatingSummary rs1 = new RatingSummary("B000GFDAUG", 2);
    RatingSummary rs2 = new RatingSummary("B000GFDAUG", 2);
    assertThat(rs1, not(sameInstance(rs2)));
  }

  @Test
  public void checkIfConstructorWithAllParametersInitializesCorrectly() {
    RatingSummary rs1 = new RatingSummary("B000GFDAUG", 2, 4f, 4f, 4f, 4f);
    assertThat(rs1.getDegree(), is(notNullValue()));
    assertThat(rs1.getList().get(0), is(notNullValue()));
    assertThat(rs1.getList().get(1), is(notNullValue()));
    assertThat(rs1.getList().get(2), is(notNullValue()));
    assertThat(rs1.getList().get(3), is(notNullValue()));
  }
} 