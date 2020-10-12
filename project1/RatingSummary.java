package project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


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
		//implement constructor
		this.id = id; 
		this.degree = degree;
		this.productAvg = productAvg;
		this.productStDev = productStDev;
		this.reviewerAvg = reviewerAvg;
		this.reviewerStDev = reviewerStDev;  
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
		// implement method
		return "ID: " + id + ", degree: " + degree + ", product avg: " + productAvg + ", product st.dev: " + productStDev
				+ ", reviewer avg: " + reviewerAvg + ", reviewer st.dev: " + reviewerStDev + "\n";
	}

	private int printStats() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * collect the list that keeps statistics Make sure the object was initialized
	 */
	@Override
	public void collectStats(final List<Rating> rawRatings) {
		// implement method
		

		
	}

	/**
	 * Collects product stats for nodeID -- never call this function directly, only
	 * through collectStats
	 * 
	 * @param rawRatings
	 */
	public void collectProductStats(final List<Rating> rawRatings) {
		// implement method

	}

	/**
	 * Collects product stats for nodeID -- never call this function directly, only
	 * through collectStats
	 * 
	 * @param rawRatings
	 */
	public void collectReviewerStats(final List<Rating> rawRatings) {
		// implement method

	}

	////////// Statistics block

	/**
	 * @return sort by biggest difference between product and review average in
	 *         collection
	 */

	public Float avgScore(){
		
		//implement method
		//Himaja -understanding steps to implement this
		// Product average - Reviewer average(biggest difference)
		// Access 2nd column - specific product - find out all rows having that product. Get the ratings from column3 for each of those
		// Access 1st column - specific reviewer - find out all products he reviewed. Get ratings from column3
		// Compare these 2 and find the biggest difference

	}
	
	/**
	 * @return sort by biggest difference between product and review st.dev. in
	 *         collection
	 */
	public Float stDevScore() {
		// implement method
	}

	/**
	 * @return summary of statistics as key to sorting the rating summaries
	 */
	public Float sortStats() {
		// implement method
		RatingSummary stats = new RatingSummary(id, degree, productAvg, productStDev, reviewerAvg, reviewerStDev);
		Collections.sort(stats.createList());
	}

   //add methods if needed
	private final String id;
	private final long degree;
	private final float productAvg;
	private final float productStDev;
	private final float reviewerAvg;
	private final float reviewerStDev;

}
