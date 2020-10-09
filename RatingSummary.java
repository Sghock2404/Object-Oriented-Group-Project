package project1;

/* Team needs to add relevant packages here */
//more readable if we don't use the wildcard sign (*) - feel free to fix and import the specific package
import java.util.*;

/**
* Ratings Summary supporting inner and outer statistics of the review 
  @author tesic
  @author tarek
*/

public class RatingSummary extends AbstractRatingSummary{

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
     * @param id        	product/review id
     * @param degree		number of times reviewed
     * @param productAvg    average rating of the product
     * @param productStDev 	standard deviation of the product's rating
     * @param reviewerAvg   average rating of the reviewer
     * @param reviewerStDev standard deviation of the reviewer's ratings
     */
	public RatingSummary(final String id, final long degree, final float productAvg, final float productStDev, final float reviewerAvg,
	final float reviewerStDev) {
		//implement constructor
		this.id = id; 
		this.degree = degree;
		this.productAvg = productAvg;
		this.productStDev = productStDev;
		this.reviewerAvg = reviewerAvg;
		this.reviewerStDev = reviewerStDev;  
	}

	/**
	 * 
	 * @param id
	 * @param degree
	 * @param rawRatings
	 */
	public RatingSummary(final String id, final List<Rating> rawRatings) {
		//implement constructor
	}

	public void setList() {
		//implement method
	}

	public void setList(float productAvg, float productStDev, float reviewerAvg, float reviewerStDev) {
		//implement method
	}

	@Override
	public List<Float> createList(){
		return new ArrayList<Float>();
	}

	public List<Float> createList(float productAvg, float productStDev, float reviewerAvg, float reviewerStDev) {
		List<Float> newList = createList();
		newList.add(productAvg);
		newList.add(productStDev);
		newList.add(reviewerAvg);
		newList.add(reviewerStDev);

		return newList;
	}


	/**
	 * Prints RatingSummary object as form Id,degree,product avg,product st.dev,reviewer avg,reviewer st.dev\n
	 */
	@Override
	public String toString(){
				//implement method
				return "ID: " + id + ", degree: " + degree + ", product avg: " + productAvg + ", product st.dev: " + productStDev +
				", reviewer avg: " + reviewerAvg + ", reviewer st.dev: " + reviewerStDev + "\n";	
	}

	private int printStats() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * collect the list that keeps statistics 
	 * Make sure the object was initialized 
	 */
	@Override
	public void collectStats(final List<Rating> rawRatings){

				//implement method
	}

	/**
	 * Collects product stats for nodeID -- never call this function directly, only through collectStats
	 * @param rawRatings
	 */
	public void collectProductStats(final List<Rating> rawRatings) {

				//implement method

	}

	/**
	 * Collects product stats for nodeID -- never call this function directly, only through collectStats
	 * @param rawRatings
	 */
	public void collectReviewerStats(final List<Rating> rawRatings) {

				//implement method
	
	}

	////////// Statistics block

	/** 
	 * @return sort by biggest difference between product and review average in collection 
	 */
	public Float avgScore(){
		
		//implement method
	}

	/** 
	 * @return sort by biggest difference between product and review st.dev. in collection   
	 */
	public Float stDevScore(){

				//implement method
	}

	/** 
	 * @return summary of statistics as key to sorting the rating summaries 
	 */
	public Float sortStats(){
				//implement method
	}

   //add methods if needed
   private final String id;
   private final long degree;
   private final float productAvg;
   private final float productStDev;
   private final float reviewerAvg;
   private final float reviewerStDev;



}
