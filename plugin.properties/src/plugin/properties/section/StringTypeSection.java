package plugin.properties.section;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.ui.IWorkbenchPart;

import plugin.properties.views.StringWrapper;

public class StringTypeSection extends AbstractTextSection {

	private StringWrapper ele;

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (selection instanceof StructuredSelection) {
			this.ele = (StringWrapper) ((StructuredSelection) selection).getFirstElement();
		}
	}

	@Override
	protected String getLabelText() {
		return "Value : ";
	}

	@Override
	protected void handleTextModifiedInternal() {
		ele.setValue(getText().getText());
	}

	@Override
	protected String getFeatureAsString() {
		return ele.value();
	}

	@Override
	protected void verifyField(VerifyEvent e) {
	}

}
