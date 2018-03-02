
public class Disk implements Comparable<Disk> {

	private int size;

	public Disk(int size) throws IllegalArgumentException {
		if (size < 1 || size > 9) {
			throw new IllegalArgumentException("Size is not valid");
		} else {
			this.size = size;
		}
	}

	@Override
	public int compareTo(Disk other) {
		int ret = 0;
		if (other == null || other.size == this.size) {
			ret = 0;
		} else if (other.size > this.size) {
			ret = -1;
		} else if (other.size < this.size ){
			ret = 1;
		}
		return ret;
	}

	@Override
	public String toString() {
		int surround = this.size - 1;
		String rep = "" + this.size;
		for (int i = 0; i < surround; i++) {
			rep = " " + rep + " ";
		}
		rep = "<" + rep.replace(" ", "=") + ">";
		return rep;
	}

}
