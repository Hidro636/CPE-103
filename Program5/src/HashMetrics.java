
/**
 *
 * @author Lucas Robertson
 * @version Program 5
 */
public interface HashMetrics {

    /**
     * Returns the total number of collisions that have occurred during all
     * calls to add in this table
     *
     * @return the current total number of collisions that have occurred during
     * all calls to add
     */
    public long collisions();

    /**
     * Returns the maximum number of collisions that have occurred during a
     * single call to add in this table.
     *
     * @return the current maximum number of collisions that have occurred
     * during a single call to add
     */
    public int maxCollisions();

}
