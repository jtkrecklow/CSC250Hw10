
public class Driver {

	public static void main(String[] args)
	{
		int[] ar = {11,1,1,6,7,4,2,4,123};
		Driver.display(ar);
		Driver.mergerSort(ar);
		Driver.display(ar);
		

	}
	
	static void mergerSort(int[] ar)
	{
		Driver.mergeSortHelper(ar, 0, ar.length-1);
	}
	
	static void mergeSortHelper(int[] ar, int begin, int end)
	{
		if(begin != end)
		{
			int leftBegin = begin;
			int leftEnd = (end-begin)/2 + begin;
			int rightBegin = ((end-begin)/2+begin)+1;
			int rightEnd = end;
			Driver.mergeSortHelper(ar, leftBegin, leftEnd);
			Driver.mergeSortHelper(ar, rightBegin, rightEnd);
			int[] temp = new int[rightEnd - leftBegin+1];
			int currLeft = leftBegin;
			int currRight = rightBegin;
			for(int i = 0; i < temp.length; i++)
			{
				if(currLeft > leftEnd)
				{
					temp[i] = ar[currRight];
					currRight++;
				}
				else if(currRight > rightEnd)
				{
					temp[i] = ar[currLeft];
					currLeft++;
				}
				else
				{
					if(ar[currLeft] < ar[currRight])
					{
						temp[i] = ar[currLeft];
						currLeft++;
					}
					else
					{
						temp[i] = ar[currRight];
						currRight++;
					}
				}
			}
			int tempPos = 0;
			for(int i = leftBegin; i <= rightEnd; i ++)
			{
				ar[i] = temp[tempPos];
				tempPos++;
			}
		}
	}
	
	static void display(int[] ar)
	{
		for(int i = 0; i< ar.length; i++)
		{
			System.out.print(ar[i] + " ");
		}
		System.out.println("");
		
	}

}
