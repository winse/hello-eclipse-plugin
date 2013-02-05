package plugin.properties.views;

public class StringWrapper {

	private String origin;

	public StringWrapper(String origin) {
		this.origin = origin;
	}
	
	public void setValue(String value){
		this.origin = value;
	}

	public String value() {
		return origin;
	}

	@Override
	public String toString() {
		return origin;
	}

	public static StringWrapper[] wrapper(String[] values) {
		StringWrapper[] results = new StringWrapper[values.length];
		for (int i = 0; i < values.length; i++) {
			results[i] = new StringWrapper(values[i]);
		}
		return results;
	}

}
