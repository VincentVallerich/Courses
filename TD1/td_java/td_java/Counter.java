/*
*=================================*
* Created  on 05-02-2020 08:22:48 *
* @author : VALLERICH Vincent     *
*=================================*
*/

package td_java;

import java.util.StringJoiner;

public class Counter {
	private final static int DEFAULT_VALUE = 0;
	private final static int DEFAULT_STEP = 1;

	private int step;
	private int value = 0;
	private String name;

	/*
	 * Constructor
	 */
	public Counter() {
		this("", DEFAULT_VALUE);
	}

	public Counter(String name) {
		this(name, DEFAULT_VALUE);
	}

	public Counter(String name, int value) {
		this.name = name;
		this.value = value;
		this.step = DEFAULT_STEP;
	}

	/*
	 * Getters & Setters
	 */
	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void increment() {
		this.value += step;
	}

	public void decrement() {
		this.value -= step;
	}

	public void reset() {
		this.value = DEFAULT_VALUE;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		//return this.name + "(" + (String)this.value + ")";
		StringJoiner tmp = new StringJoiner(",", "Counter(", ")");
		tmp.add(this.name);
		tmp.add(String.valueOf(this.value));
		return tmp.toString();
	}
}