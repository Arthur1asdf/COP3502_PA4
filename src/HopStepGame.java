/* Arthur Teng
 * Dr. Andrew Steinberg
 * COP3503 Spring 2024
 * Programming Assignment 4
 */
public class HopStepGame {
    //class attributes must be private
    //finished function do not change
    public int minCost(int squares[], int numOfSquares)
    {
        //base case for when the numOfSquares var goes out of bounds
        //this mean it has ended
        //how we will know if we should go to second last or last index will be determined in the driver file
        if (numOfSquares < 0)
        {
            return 0;
        }
        //the last and second last index
        if (numOfSquares < 2)
        {
            return squares[numOfSquares];
        }
        //System.out.println(squares[numOfSquares] + "j");
        //put 2 pointers into the array see which is smaller and add the cost for min distance recursivly
        return squares[numOfSquares] + Math.min(minCost(squares, numOfSquares -2), minCost(squares, numOfSquares - 1));
    }

    private int fib;
    public int minCostMemoization(int squares[], int numOfSquares, int prevResults[])
    {
  
        /*if(numOfSquares < 0)
        {
            return 0;
        }
        if(numOfSquares == 1)
        {
            fib = squares[0];
        }
        if( numOfSquares == 2)
        {
            fib = squares[2];
        }
        else
        {
            prevResults[numOfSquares] =  squares[numOfSquares] + Math.min(minCostMemoization(squares, numOfSquares -2, prevResults), minCostMemoization(squares, numOfSquares - 1, prevResults));
        }
        prevResults[numOfSquares] = fib;

        return fib;*/

        //base case for when the numOfSquares var goes out of bounds
        if (numOfSquares < 0)
        {
            return 0;
        }
        //the last and second last index
        if (numOfSquares < 2)
        {
            return squares[numOfSquares];
        }

        //when we make an array we always get 0 for all arrays automatically, so we check to see if array is  not 0 to see if we stored anything inside
        if(prevResults[numOfSquares] != 0)
        {
            return prevResults[numOfSquares];
        }

        prevResults[numOfSquares] =  squares[numOfSquares] + Math.min(minCostMemoization(squares, numOfSquares -2, prevResults), minCostMemoization(squares, numOfSquares - 1, prevResults));
        return prevResults[numOfSquares];

    }

    public int minCostTabulation(int squares[])
    {
        //to store the last two index value
        int[] min = new int[squares.length];
    
        //put the first two indexes so we can add them in the for loop
        min[0] = squares[0]; 
        min[1] = squares[1]; 
        
        //we start at 2 because we already established the first 2 indexes therefore we start at two and add the two to find the cost 
        for (int i = 2; i < squares.length; i++) 
        {
            // The cost for the current square is the cost of the square itself plus
            // the minimum of the cost of getting to one or two squares before it.
            min[i] = squares[i] + Math.min(min[i - 1], min[i - 2]);
        }
    
        return Math.min(min[squares.length - 1], min[squares.length - 2]);
    }
}
