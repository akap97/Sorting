import java.util.*;

public class Inversions {

    private static long CountInversions(int[] arr,int l, int r) {
		// Keeps track of the inversion count at a 
		// particular node of the recursion tree 
		int count = 0; 

		if (l < r) { 
			int m = (l + r) / 2; 

			// Total inversion count = left subarray count 
			// + right subarray count + merge count 

			// Left subarray count 
			count += CountInversions(arr, l, m); 

			// Right subarray count 
			count += CountInversions (arr, m + 1, r); 

			// Merge count 
			count += mergeAndCount(arr, l, m, r); 
		} 

		return count; 
    }
	public static long mergeAndCount(int[] a,int l,int m,int r)
	{
		int[] left=Arrays.copyOfRange(a,l,m+1);
		int[] right=Arrays.copyOfRange(a,m+1,r+1);
		int i=0,j=0;
		long swap=0;
		int k=l;
		while(i<left.length && j<right.length)
		{
			if(left[i]<=right[j])
				a[k++]=left[i++];
			else{
				a[k++]=right[j++];
				swap+=(m+1)-(l+i);
			}
		}
		while(i<left.length)
			a[k++]=left[i++];
		while(j<right.length)
			a[k++]=right[j++];
		return swap;
	}
			

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(CountInversions(a, 0, a.length-1));
    }
}

