package plugin.properties.views;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

public class StringPropertySourceAdapterFactory implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == IPropertySource.class //
				&& adaptableObject instanceof StringWrapper) {
			return new StringPropertySource((StringWrapper) adaptableObject);
		}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] { IPropertySource.class };
	}

	private static class StringPropertySource implements IPropertySource {

		private StringWrapper ele;

		StringPropertySource(StringWrapper ele) {
			this.ele = ele;
		}

		@Override
		public Object getEditableValue() {
			return this;
		}

		@Override
		public IPropertyDescriptor[] getPropertyDescriptors() {
			return new IPropertyDescriptor[] { //
						new TextPropertyDescriptor("value", "value") };
		}

		@Override
		public Object getPropertyValue(Object id) {
			if ("value".equals(id)) {
				// 这里返回ele，在Properties视图将是一个死循环！这也是StringWrapper产生的原因
				return ele.value();
			}
			return null;
		}

		@Override
		public boolean isPropertySet(Object id) {
			return false;
		}

		@Override
		public void resetPropertyValue(Object id) {
		}

		@Override
		public void setPropertyValue(Object id, Object value) {
		}

	}

}
