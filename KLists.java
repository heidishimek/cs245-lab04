import java.util.*;

public class KLists
{
	public double[] mergeKLists(double [][] outerArray)
	{
		//counter
		int x = 0;
		//variable for the first array
		double[] arr = outerArray[0];

		//loop to set x equal to the length of outerArray
		for (int i = 0; i < outerArray.length; i++)
		{
			x += outerArray[i].length;
		}

		//variable to set result equal to length of outerArray
		double[] result = new double[x];

		//loop to go through the array to compare
		for (int y = 1; y < outerArray.length; y++)
		{
			//array2 is set equal to second row
			double[] arr2 = outerArray[y];
			ArrayList<Double> temporaryList = new ArrayList<>();

			int a = 0; int b = 0;
			while (a < arr.length && b < arr2.length)
			{
				if (arr[a] <= arr2[b])
				{	
					//add element at index to temporaryList if num is smaller 
					temporaryList.add(arr[a]);
					a++;
				}
				else
				{
					//add element at index if elemet is greater than previous to temporary array list
					temporaryList.add(arr2[b]);
					b++;
				}
			}
			//all other elements added to temporary array list
			while (a < arr.length)
			{
				temporaryList.add(arr[a]);
				a++;
			}
			while (b < arr2.length)
			{
				temporaryList.add(arr2[b]);
				b++;
			}

			//change arrayList to an array
			Double[] arr3 = temporaryList.toArray(new Double[temporaryList.size()]);
			for (int i = 0; i < arr3.length; i++)
			{
				result[i] = arr3[i];
			}

			//to keep track of array
			double[] newTemp = new double[arr3.length];
			for (int i = 0; i < arr3.length; i++)
			{
				newTemp[i] = arr3[i];
			}
			arr = newTemp;
		}
		return result;

	}


	public static void main(String[] args)
	{
		//EXAMPLES
		double[][] list = {{1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {2.2, 6.6}};
		// double[][] list = {{9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27}};
		// double[][] list = {};
		// double[][] list = {{}};

		KLists sort = new KLists();
		System.out.print("Output: ");
		double[] output = sort.mergeKLists(list);
		for (double value : output)
		{
			System.out.print(value + ", ");
		}
	}
}