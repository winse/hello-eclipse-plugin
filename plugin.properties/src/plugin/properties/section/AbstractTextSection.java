package plugin.properties.section;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public abstract class AbstractTextSection extends AbstractPropertySection {
	
    /** The text control for the section. */
    private Text text;

    /** The label used with to identify the Section */
    private CLabel nameLabel;
    
    @Override
    public final void createControls(Composite parent,
    		TabbedPropertySheetPage aTabbedPropertySheetPage) {
    	super.createControls(parent, aTabbedPropertySheetPage);
    	
    	Composite composite = new Composite(parent, SWT.NONE);
    	composite.setLayout(new FormLayout());
    	
    	createWidgets(composite);
    	setSectionData(composite);
    	hookListeners();
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
     */
    protected void createWidgets(Composite composite)
    {
    	nameLabel = getWidgetFactory().createCLabel(composite, getLabelText());
    	
        text = getTextWidget(composite,getStyle());
    }
    
    protected abstract String getLabelText();

    public Text getTextWidget(Composite parent, int style) {
		return new Text(parent, style);
	}

	/**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
     */
    protected void setSectionData(Composite composite)
    {
        FormData data = new FormData();
        data.left = new FormAttachment(0, 5);
        data.top = new FormAttachment(0, 5);
        nameLabel.setLayoutData(data);

        data = new FormData();
        data.left = new FormAttachment(nameLabel, 5);
        data.right = new FormAttachment(100, -5);
        data.top = new FormAttachment(0, 5);
        text.setLayoutData(data);
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#hookListeners()
     */
    protected void hookListeners()
    {
        text.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				AbstractTextSection.this.focusOut();
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				AbstractTextSection.this.focusIn();
			}
		});
        text.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				handleTextModified();
			}
		});
        text.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent e) {
				verifyField(e);
			}
		});
        
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#refresh()
     */
    public void refresh()
    {
        super.refresh();
        getText().setText(getFeatureAsString());
    }

    /**
     * @see org.topcased.tabbedproperties.sections.AbstractTabbedPropertySection#setEnabled(boolean)
     */
    protected void setEnabled(boolean enabled)
    {
        if (getText() != null)
        {
            getText().setEnabled(enabled);
        }
    }

    /**
     * Handle the text modified event. When there is any problem while creating and executing the command, the view will
     * be only refreshed
     */
    protected void handleTextModified()
    {
        if (isTextValid())
        {
        	handleTextModifiedInternal();
        }
        else
        {
            refresh();
        }
    }
    
    protected abstract void handleTextModifiedInternal();

    /**
     * Handle action when the focus is gained Default action is to do nothing. Clients may override this method if they
     * desire a particular action to be executed when the text control gain the focus.
     */
    protected void focusIn()
    {
        // Do nothing
    }

    /**
     * Handle action when the focus is lost. Default action is to do nothing. Clients may override this method if they
     * desire a particular action to be executed when the text control lost the focus.
     */
    protected void focusOut()
    {
        // Do nothing
    }

    /**
     * Get the style of the text widget. By default, this is a single line text
     * 
     * @return the style
     */
    protected int getStyle()
    {
        return SWT.SINGLE | SWT.BORDER;
    }

    /**
     * @return the text
     */
    protected Text getText()
    {
        return text;
    }

    /**
     * @return the nameLabel
     */
    public CLabel getNameLabel()
    {
        return nameLabel;
    }

    /**
     * Check whether the text entered is valid or not. Subclasses should override this method to provide their own
     * check. By default, return true.
     * 
     * @return true if the text entered is valid
     */
    protected boolean isTextValid()
    {
        return true;
    }

    /**
     * Get the value of the feature as text for the text field for the section.
     * 
     * @return the value of the feature as text.
     */
    protected abstract String getFeatureAsString();

    /**
     * Subclasses may provide their own checker on the text that is entered by the user and update the 'doit' flag of
     * the Event in consequence.
     * 
     * @param e the Event that is sent when the Text is modified
     */
    protected abstract void verifyField(VerifyEvent e);

}
