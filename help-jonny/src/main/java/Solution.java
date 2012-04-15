import java.util.Scanner;

/**
 * <p>
 * Jonny has just learned Sorting in his algorithm classes. He wants to show his
 * mother how good he is with algorithms, but his mother is very clever. She
 * wants to ensure Jonny has learned the key concepts and not just the methods.
 * </p>
 * <p>
 * She places N integers in order 1, 2, 3, ..., N. and asks Jonny to reverse
 * this sequence, i.e convert this sequence to N, N-1, .... , 3, 2, 1. The only
 * operation Jonny is allowed to do is to choose any 4 (not necessarily
 * adjacent) integers and perform the following action: exchange the leftmost
 * integer with the rightmost one and similarly swap the remaining two integers
 * in the middle, both swaps must occur. He can perform this operation as many
 * times he want.
 * </p>
 * <p>
 * Jonny has a feeling that this may not always be possible for all sequences,
 * so before starting he wants to know whether it is possible to do this task.
 * </p>
 * <p>
 * Input Format
 * </p>
 * <p>
 * First line of the input contains T, the number of testcases. Then follow T
 * lines, each containing an integer N.
 * </p>
 * <p>
 * Output Format
 * </p>
 * <p>
 * For each of the given numbers print YES if the task is possible, otherwise
 * NO.
 * </p>
 * <p>
 * Sample Input
 * </p>
 * <code>
 * 2
 * 5
 * 6
 * </code>
 * <p>
 * Sample Output
 * </p>
 * <code>
 * YES
 * NO
 * </code>
 * <p>
 * Constrains
 * </p>
 * <p>
 * 1 <= T <= 10
 * </p>
 * <p>
 * 4 <= N <= 1,000,000
 * </p>
 * 
 * @author Jorge Agudo Praena (joragupra@gmail.com)
 * @version 1.0
 */
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nCases = scanner.nextInt();
		int[] cases = new int[nCases];
		for (int i = 0; i < nCases; i++) {
			cases[i] = scanner.nextInt();
		}
		for (int n : cases) {
			canReverse(n);
		}
	}

	private static void canReverse(int nNumbers) {
		int half = (int) Math.floor(nNumbers / 2);
		if (half % 2 == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}