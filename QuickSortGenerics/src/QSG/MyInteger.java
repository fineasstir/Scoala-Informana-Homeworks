package QSG;

public class MyInteger implements Comparable<MyInteger> {

	private int value;

	public MyInteger(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public int compareTo(MyInteger o) {
		if (this.value < o.getValue()) {
			return -1;
		} else if (this.value == o.getValue()) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		return "MyInteger{" + "value=" + value + '}';
	}

}
