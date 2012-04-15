import java.util.Scanner;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		sequenceLenght = scanner.nextInt();
		long[] sequence = new long[sequenceLenght];
		for(int i = 0; i < sequenceLenght; i++){
			sequence[i] = scanner.nextLong();
		}
//		int max = 0;
//		for(int i = 0; i<(sequenceLenght-1) && ((sequenceLenght-i)>max); i++){
//			int length = 1;
//			
//			if(length>max){
//				max = length;
//			}
//		}
		int max = subsequence(sequence, 0, 0, 1, 0);
		System.out.println(max);
	}
	
	private static int sequenceLenght;
	
	private static int max;
	
	private static int subsequence(long[] sequence, long last, int start, int current, int acc){
		if((acc+(sequenceLenght-start))<max){
			return 0;
		}
		if(start>=sequenceLenght){
			return acc;
		}
		if(current==1){
			int aux2 = subsequence(sequence, sequence[start], start+1, 2, acc+1);
			int aux = 0;
			if((sequenceLenght-(start+1))>aux2){
				aux = subsequence(sequence, last, start+1, current, acc);
			}
			int localMax = aux>aux2?aux:aux2;
			if(localMax>max){
				max = localMax;
			}
			return localMax;
		}
//		else if(current==2){
//			int aux = subsequence(sequence, last, start+1, current, acc);
//			int aux2 = 0;
//			if(sequence[start]>last){
//				aux2 = subsequence(sequence, sequence[start], start+1, 3, acc+1);
//			}
//			int localMax = aux>aux2?aux:aux2;
//			if(localMax>max){
//				max = localMax;
//			}
//			return localMax;
//		}
		else{
			int aux2 = 0;
			if(current%2==0){
				if(sequence[start]>last && (start==sequenceLenght-1 || existsLess(sequence, start+1, sequence[start]))){
					aux2 = subsequence(sequence, sequence[start], start+1, current+1, acc+1);
				}
			}
			else{
				if(sequence[start]<last && (start==sequenceLenght-1 || existsGreater(sequence, start+1, sequence[start]))){
					aux2 = subsequence(sequence, sequence[start], start+1, current+1, acc+1);
				}
			}
			int aux = 0;
			if((sequenceLenght-(start+1))>aux2){
				aux = subsequence(sequence, last, start+1, current, acc);
			}
			int localMax = aux>aux2?aux:aux2;
			if(localMax>max){
				max = localMax;
			}
			return localMax;
		}
	}
	
	private static boolean existsGreater(long[] sequence, int start, long value){
		boolean exists = false;
		for(int i=start;i<sequenceLenght && !exists;i++){
			if(sequence[i]>value){
				exists = true;
			}
		}
		return exists;
	}
	
	private static boolean existsLess(long[] sequence, int start, long value){
		boolean exists = false;
		for(int i=start;i<sequenceLenght && !exists;i++){
			if(sequence[i]<value){
				exists = true;
			}
		}
		return exists;
	}
}