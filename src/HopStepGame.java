/* Arthur Teng
 * Dr. Andrew Steinberg
 * COP3503 Spring 2024
 * Programming Assignment 4
 */
public class HopStepGame {
    //class attributes must be private
    public int minCost(int squares[], int numOfSquares)
    {
        //base case for when the numOfSquares var goes out of bounds
        if (numOfSquares < 0)
        {
            return 0;
        }
        //base case for when we reach the end which is the last of second last array
        //prob don't   even need this however it will be needed to compare with the basecase above
        if (numOfSquares == 0 || numOfSquares == 1)
        {
            return squares[numOfSquares];
        }

        return squares[numOfSquares] + Math.min(minCost(squares, numOfSquares -2), minCost(squares, numOfSquares - 1));
    }
    public int minCostMemoization(int squares[], int numOfSquares, int prevResults[])
    {
        return 0;
    }
    public int minCostTabulation(int squares[])
    {
        return 0;
    }
}
