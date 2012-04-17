import java.util.Scanner;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		long[] numbers = new long[N];
		int[] maxs = new int[N];
		maxs[0] = 1;
		int maxLength = 1;
		for(int i=0;i<N;i++){
			numbers[i] = scanner.nextLong();
			maxs[i] = 1;
			for(int j=i-1;j>=0;j--){
				if(maxs[j]+1>maxs[i]){
					if(maxs[j]%2==0){
						if(numbers[j]>numbers[i]){
							maxs[i] = maxs[j]+1;
						}
					}else{
						if(numbers[j]<numbers[i]){
							maxs[i] = maxs[j] + 1;
						}
					}
				}
			}
			if(maxs[i]>maxLength){
				maxLength = maxs[i];
			}
		}
		System.out.println(maxLength);
	}
}