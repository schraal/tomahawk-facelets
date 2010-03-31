import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentTag;

import org.apache.myfaces.custom.aliasbean.AliasBean;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.tag.MetaRuleset;
import com.sun.facelets.tag.TagAttribute;
import com.sun.facelets.tag.jsf.ComponentConfig;
import com.sun.facelets.tag.jsf.ComponentHandler;


/**
 * Handler for AliasBean Component.
 * 
 */
public class AliasBeanHandler extends ComponentHandler {

    private TagAttribute valueAttr;

    private TagAttribute aliasAttr;

    public AliasBeanHandler(ComponentConfig aConfig) {
        super(aConfig);

        valueAttr = getRequiredAttribute("value");
        aliasAttr = getRequiredAttribute("alias");
    }

    /**
     * {@inheritDoc}
     */
    protected MetaRuleset createMetaRuleset(Class aClass) {
        MetaRuleset theRules = super.createMetaRuleset(aClass);
        theRules = theRules.ignore("value");
        theRules = theRules.ignore("alias");
        return theRules;
    }

    /**
     * {@inheritDoc}
     */
    protected void onComponentCreated(FaceletContext aContext, UIComponent aComponent, UIComponent aParent) {
        super.onComponentCreated(aContext, aComponent, aParent);

        AliasBean theComponent = (AliasBean) aComponent;

        Application app = aContext.getFacesContext().getApplication();

        String theValue = valueAttr.getValue();
        if (UIComponentTag.isValueReference(theValue)) {
            theComponent.setValueBinding("value", app.createValueBinding(valueAttr.getValue()));
        } else {
            theComponent.setValue(theValue);
        }

        String theAlias = aliasAttr.getValue();
        if (UIComponentTag.isValueReference(theAlias)) {
            theComponent.setValueBinding("alias", app.createValueBinding(aliasAttr.getValue()));
        } else {
            theComponent.setAlias(theAlias);
        }
    }
}