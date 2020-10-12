package project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Ratings Summary supporting inner and outer statistics of the review
 * 
 * @author Himaja
 * @author Scott
 * @author Daniel
 */

public class RatingSummary extends AbstractRatingSummary {

	/**
	 * Constructor.
	 * 
	 * @param inNodeID
	 * @param inDegree
	 * @param inList
	 */
	public RatingSummary(final String inNodeID, final long inDegree, final List inList) {
		super(inNodeID, inDegree, inList);
	}

	/**
	 * Constructor.
	 * 
	 * @param inNodeID
	 * @param inDegree
	 */
	public RatingSummary(final String inNodeID, final long inDegree) {
		super(inNodeID, inDegree);
	}

	/**
	 * Constructor.
	 * 
	 * @param id            product/review id
	 * @param degree        number of times reviewed
	 * @param productAvg    average rating of the product
	 * @param productStDev  standard deviation of the product's rating
	 * @param reviewerAvg   average rating of the reviewer
	 * @param reviewerStDev standard deviation of the reviewer's ratings
	 */
	public RatingSummary(final String id, final long degree, final float productAvg, final float productStDev,
			final float reviewerAvg, final float reviewerStDev) {
		
		//don't know if this is necessary, but it got rid of error
		super(id, degree); 
		// I think you're right Scott - I added initialization for the list attribute on top of what you did 
		super.setList(this.createList(productAvg, productStDev, reviewerAvg, reviewerStDev));
	}

	/**
	 * Constructor.
	 * 
	 * @param id
	 * @param degree
	 * @param rawRatings
	 */
	public RatingSummary(final String id, final List<Rating> rawRatings) {
		super(id);
		super.setDegree(rawRatings);
	}

	/**
	 * Create a newList using createList() and pass that into super.setList()
	 */
	public void setList() {
		super.setList(createList());
	}

	/**
	 * Create a new list using createList() and parameters and passing that to
	 * super.setList()
	 * 
	 * @param productAvg
	 * @param productStDev
	 * @param reviewerAvg
	 * @param reviewerStDev
	 */
	public void setList(float productAvg, float productStDev, float reviewerAvg, float reviewerStDev) {
		super.setList(createList(productAvg, productStDev, reviewerAvg, reviewerStDev));
	}

	@Override
	public List<Float> createList() {
		return new ArrayList<Float>();
	}

	/**
	 * Create a list containing each of the parameters as values.
	 * 
	 * @param productAvg
	 * @param productStDev
	 * @param reviewerAvg
	 * @param reviewerStDev
	 * @return
	 */
	public List<Float> createList(float productAvg, float productStDev, float reviewerAvg, float reviewerStDev) {
		List<Float> newList = createList();		
		newList.add(productAvg);
		newList.add(productStDev);
		newList.add(reviewerAvg);
		newList.add(reviewerStDev);

		return newList;
	}

	/**
	 * Prints RatingSummary object as form Id,degree,product avg,product
	 * st.dev,reviewer avg,reviewer st.dev\n
	 */
	@Override
	public String toString() {
		// Just need to rewrite this in virtue of the constructor fixes.
		// Should only take a few minutes (see bottom of file)
		//changed to getNodeID(), getDegree(), getList() with encapsulation because RatingSummary extends AbstractRatingSummary
		return getNodeID() + " " + getDegree() + " " + getList();

	}

	private int printStats() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * collect the list that keeps statistics 
	 * Make sure the object was initialized
	 * 
	 * @param rawRatings
	 */
	@Override
	public void collectStats(final List<Rating> rawRatings) {
		if (rawRatings != null) {
			collectProductStats(rawRatings);
			collectReviewerStats(rawRatings);
		}
	}

	/**
	 * Collects product stats for nodeID -- never call this function directly, only
	 * through collectStats
	 * 
	 * @param rawRatings
	 */
	public void collectProductStats(final List<Rating> rawRatings) {
		// implement method
		//check for rows containing product ID and filtering out corresponding rating
		for (final Rating pStat : rawRatings) {
			if (super.getNodeID().equals(pStat.getProductID())) {
				rawRatings.get(2);
			}
		}

	}

	/**
	 * Collects reviewer stats for nodeID -- never call this function directly, only
	 * through collectStats
	 * 
	 * @param rawRatings
	 */
	public void collectReviewerStats(final List<Rating> rawRatings) {
		// implement method
		//check for rows containing reviewer ID and filtering out corresponding rating
		for (final Rating rStat : rawRatings) {
			if (super.getNodeID().equals(rStat.getReviewerID())) {
				rawRatings.get(2);
			}
		}

	}

	////////// Statistics block

	/**
	 * @return sort by biggest difference between product and review average in
	 *         collection
	 */

	public Float avgScore(){
		
		// implement method
		// Himaja -understanding steps to implement this
		// Product average - Reviewer average(biggest difference)
		// Access 2nd column - specific product - find out all rows having that product. Get the ratings from column3 for each of those
		// Access 1st column - specific reviewer - find out all products he reviewed. Get ratings from column3
		// Compare these 2 and find the biggest difference
		
		List<Float> statsList = super.getList();

		Float reviewerAvg = statsList.get(2);
		Float productAvg = statsList.get(0);

		// Computation
		return reviewerAvg - productAvg;

	}
	
	/**
	 * @return sort by biggest difference between product and review st.dev. in
	 *         collection
	 */
	public Float stDevScore() {
		// updated implementation of Scott's stDevScore from before using List/super methods
		 List<Float> statsList = super.getList();

		//Making variables for readability
		Float reviewerStDev = statsList.get(3);
		Float productStDev = statsList.get(1);

		// Computation
		return reviewerStDev - productStDev;

	}

	/**
	 * @return summary of statistics as key to sorting the rating summaries
	 */
	public Float sortStats() {
		// implement method, just a return statement?
		
	}

	/**
	 * How to access data attributes (after fixing constructors)
	 * 
	 * degree - super.getDegree()
	 * nodeID - super.getNodeID()
	 * 
	 * The attributes [productAvg, productStDev, reviewerAvg, reviewerStDev] are part of a list (statsList)
	 * contained in the superclass "AbstractRatingSummary" - so we'll keep those values there (encapsulation)
	 * 
	 * 	one easy way to access:
	 * 		// get list from super
	 * 		List<Float> copyOfList = super.getList();
	 * 
	 *				// each data attribute and its index within the list
	 * 			productAvg : copyOfList.get(0);
	 * 			productStDev : copyOfList.get(1);
	 * 			reviewerAvg : copyOfList.get(2);
	 *				reviewerStDev : copyOfList.get(3)
	 *    
	 */			
}
