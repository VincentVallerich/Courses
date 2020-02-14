/*
*=================================*
* Created  on 05-02-2020 08:22:48 *
* @author : VALLERICH Vincent     *
*=================================*
*/

package td_java;

public class Counter {
	private int value = 0;
	private String name;

	public Counter() {

	}

	public Counter(String name) {
		this.name = name;
	}

	public Counter(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {

	}

	public void increment() {
		this.value++;
	}

	public void decrement() {
		this.value--;
	}

	public void reset() {
		this.value = 0;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return this.name + "(" + this.value + ")";
	}
}