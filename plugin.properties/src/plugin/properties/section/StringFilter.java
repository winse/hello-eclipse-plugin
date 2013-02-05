package plugin.properties.section;

import org.eclipse.jface.viewers.IFilter;

import plugin.properties.views.StringWrapper;

public class StringFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		if (toTest instanceof StringWrapper) {
			return true;
		}
		return false;
	}

}
