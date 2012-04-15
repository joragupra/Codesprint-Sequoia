import java.util.Scanner;

public class Solution {

	private static int[] scanBags(String s) {
		int[] bags = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			bags[i] = Integer.parseInt(new String("" + s.charAt(i)));
		}
		return bags;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		int[] bags = scanBags(s);
		int count = 0;
		MrLee mrlee = new MrLee(bags);
		int nextBag = mrlee.findBestBag();
		while (nextBag != -1) {
			mrlee.punch(nextBag);
			count++;
			nextBag = mrlee.findBestBag();
		}
		System.out.println(count);
	}

	private static class MrLee {
		private int[] bags;

		private MrLee(int[] bags) {
			this.bags = bags;
		}

		private int findBestBag() {
			int bestCandidate = -1;
			int bestCandidateValoration = 0;
			for (int i = 0; i < this.bags.length; i++) {
				if (this.bags[i] > 0) {
					int valoration = valorate(i - 1) + valorate(i + 1);
					if (valoration == 8) {
						return i;
					} else if (bestCandidate == -1) {
						bestCandidate = i;
						bestCandidateValoration = valoration;
					} else {
						if (valoration > bestCandidateValoration) {
							bestCandidate = i;
							bestCandidateValoration = valoration;
						} else if (valoration == bestCandidateValoration) {
							if (this.bags[i] < this.bags[bestCandidate]) {
								bestCandidate = i;
								bestCandidateValoration = valoration;
							}
						}
					}
				}
			}
			return bestCandidate;
		}

		private void punch(int position) {
			this.bags[position] = 0;
			if (position > 0) {
				this.bags[position - 1] = this.bags[position - 1] - 1;
			}
			if (position < this.bags.length - 1) {
				this.bags[position + 1] = this.bags[position + 1] - 1;
			}
		}

		private int valorate(int bagPosition) {
			if (bagPosition < 0 || bagPosition > (this.bags.length - 1)) {
				return 4;
			}
			if (this.bags[bagPosition] == 0) {
				return 4;
			}
			if (this.bags[bagPosition] == 1) {
				return -1;
			}
			return this.bags[bagPosition];
		}
	}
}