
public class TowerOfHanoi {

	private Rod[] rods;

	public TowerOfHanoi(int width, int height) {
		rods = new Rod[width];
		rods[0] = new Rod(height, height);
		for (int i = 1; i < width; i++) {
			rods[i] = new Rod (height, 0);
		}
		

	}

	public void moveDisk(int source, int destination) {
		Rod begin = rods[source];
		Rod end = rods[destination];
		if (begin.compareTo(end) == 1) {
			Disk target = begin.pop();
			end.push(target);
		} else if (begin.compareTo(end) == -1) {
			System.out.println("WARNING: Illegal move.");
		} else {
			System.out.println("WARNING: Illegal move.");
		}
	}


	public boolean isSolved() {
		for (int i = 0; i < rods.length; i++) {
			if (rods[i].isEmpty() && rods[getMaxWidth() - 1].isFull()) {
				return true;
			}
		}

		return false;
	}

	public String toString() {
		String[] output = new String[rods[0].toString().split("\n").length];
		for (int i = 0; i < output.length; i++) {
			output[i] = "";
		}
		for (int i = 0; i < rods.length; i++) {
			String[] layers = rods[i].toString().split("\n");
			for (int j = 0; j < layers.length; j++) {
				output[j] += layers[j];
			}
		}
		String finalString = "";
		for (String a : output) {
			finalString += a + "\n";
		}
		return finalString;
	}

	private int getMaxWidth() {
		return rods.length;
	}
	
	public void solve(int number, int source, int destination, int auxiliary) {
		Rod beginRod = rods[source];
		Rod endRod = rods[destination];
		if (number > 0) {
			solve(number - 1, source, auxiliary, destination);
			endRod.push(beginRod.pop());
			System.out.println(this.toString());
			solve(number - 1, auxiliary, destination, source);
			
		}
	}

}
