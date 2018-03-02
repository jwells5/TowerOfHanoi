import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Rod implements Comparable<Rod> {

	private int numberOfDisks;
	private Disk[] disks;

	public Rod(int maxHeight, int numberOfDisks) {
		if (numberOfDisks > maxHeight) {
			numberOfDisks = maxHeight;
		}
		int change = 0;

		disks = new Disk[maxHeight];
		this.numberOfDisks = numberOfDisks;

		for (int i = numberOfDisks; i > 0; i--) {
			Disk disk = new Disk(i);

			disks[change] = disk;
			change = change + 1;

		}
	}

	private int getMaxHeight() {
		return disks.length;
	}

	public boolean isEmpty() {
		if (numberOfDisks == 0) {
			return true;
		} else {
			return false;
		}
	}

	private int getSize() {
		return this.getSize();
	}

	public boolean isFull() {
		if (numberOfDisks == disks.length) {
			return true;
		} else {
			return false;
		}
	}

	public void push(Disk disk) throws IllegalStateException {
		if (isFull()) {
			throw new IllegalStateException("Tower is full");
		} else {
			this.disks[numberOfDisks] = disk;
			numberOfDisks = numberOfDisks + 1;
		}
	}

	public Disk pop() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("No pieces yet");
		} else {
			Disk result = disks[numberOfDisks - 1];
			disks[--numberOfDisks] = null;
			return result;
		}

	}

	public Disk peek() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("No pieces yet");
		} else {
			return disks[numberOfDisks - 1];
		}
	}

	@Override
	public int compareTo(Rod other) {

		if (!this.isEmpty()) {
			if (other.isEmpty()) {
				return 1;
			} else if (peek().compareTo(other.peek()) == - 1) {
				return 1;
			} else {
				return -1;
			}

		} else {
			return 0;
		}
	}
	//
	// if (other.isEmpty()) {
	// return 1;
	// }
	// if (this.isEmpty()) {
	// return 0;
	// }
	// //int sizeOfThisTopDisk = this.disks[numberOfDisks - 1].getSize();
	// int sizeOfThisTopDisk = this.peek().toString().length();
	// //int sizeOfOtherTopDisk = other.disks[other.numberOfDisks - 1].getSize();
	// int sizeOfOtherTopDisk = other.peek().toString().length();
	// //System.out.println(sizeOfThisTopDisk + sizeOfOtherTopDisk);
	//// if (sizeOfThisTopDisk > sizeOfOtherTopDisk) {
	// if (sizeOfThisTopDisk > sizeOfOtherTopDisk) {
	// return -1;
	// } else {
	// return 1;
	// }
	// }

	// Disk other = peek();
	//
	// int ret = 0;
	// if (other == null || other.isEmpty()) {
	// return 0;
	// } else if (!other.isEmpty() && other.disks.toString().length() >
	// other.toString().length()) {
	// return 1;
	// } else if (other.isEmpty()) {
	// return -1;
	// } else {
	// return ret;
	// }
	// }

	@Override
	public String toString() {

		String rod = "";
		String space = "";
		String add = "";
		for (int i = this.getMaxHeight() - 1; i >= 0; i--) {
			if (disks[i] == null) {
				space = "";
				for (int k = 0; k < (this.getMaxHeight() * 2 + 1) / 2; k++) {
					space += " ";

				}
				rod = rod + space + "|" + space + "\n";
			} else {
				space = "";
				add = "";
				int spaceCount = 0;
				int count = this.getMaxHeight() * 2 + 1 - disks[i].toString().length();

				for (int k = 0; k < count; k++) {
					spaceCount += 1;
				}
				for (int k = 0; k < spaceCount / 2; k++) {
					space += " ";
				}

				rod = rod + space + disks[i].toString() + space + "\n";
			}
		}

		return rod;
	}
}
