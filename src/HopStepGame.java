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
        //System.out.println(squares[numOfSquares] + "j");
        return squares[numOfSquares] + Math.min(minCost(squares, numOfSquares -2), minCost(squares, numOfSquares - 1));
    }

    //unfinished
    public int minCostMemoization(int squares[], int numOfSquares, int prevResults[])
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
        else
        {
            prevResults[numOfSquares] =  squares[numOfSquares] + Math.min(minCost(squares, numOfSquares -2), minCost(squares, numOfSquares - 1));
        }
        return prevResults[numOfSquares];
       
    }
    //unfinished
    public int minCostTabulation(int squares[])
    {
        /*int n = squares.length;
        int total = 0;
        System.out.println(n);
        for(int i = 0; i < n; i++)
        {
            if(i == n - 1  || i == n - 2 )
            {
                return total;
            }
            total =  total + Math.min(squares[i], squares[i + 1]);
            System.out.println(total);
            if(Math.min(squares[i], squares[i + 1]) == squares[i + 1])
            {
                i++;
            }
        }

        return total;
    }*/

        int[] min = new int[squares.length];
    
        // Base cases
        min[0] = squares[0]; 
        min[1] = squares[1]; 
    
        for (int i = 2; i < squares.length; i++) 
        {
            // The cost for the current square is the cost of the square itself plus
            // the minimum of the cost of getting to one or two squares before it.
            min[i] = squares[i] + Math.min(min[i - 1], min[i - 2]);
        }
    
        return Math.min(min[squares.length - 1], min[squares.length - 2]);
    }
}
