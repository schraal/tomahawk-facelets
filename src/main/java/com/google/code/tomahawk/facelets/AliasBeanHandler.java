/*
 * Copyright 2001-2007 The European Bioinformatics Institute.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.code.tomahawk.facelets;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.FaceletException;
import com.sun.facelets.tag.TagAttribute;
import com.sun.facelets.tag.TagHandler;
import com.sun.facelets.tag.jsf.ComponentConfig;
import org.apache.myfaces.custom.aliasbean.AliasBean;

import javax.el.ELException;
import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentTag;
import java.io.IOException;

public class AliasBeanHandler extends TagHandler {

    private TagAttribute valueAttr;
    private TagAttribute aliasAttr;

    public AliasBeanHandler(ComponentConfig tagConfig) {
        super(tagConfig);

        valueAttr = getRequiredAttribute("value");
        aliasAttr = getRequiredAttribute("alias");
    }


    public void apply(FaceletContext ctx, UIComponent parent) throws
                                                              IOException, FacesException, FaceletException, ELException
    {
        Application app = ctx.getFacesContext().getApplication();

        AliasBean aliasBean = new AliasBean();

        String value = valueAttr.getValue();
        if (UIComponentTag.isValueReference(value))
        {
            aliasBean.setValueBinding("value",
                                      app.createValueBinding(valueAttr.getValue()));
        } else
        {
            aliasBean.setValue(value);
        }

        String alias = aliasAttr.getValue();
        if (UIComponentTag.isValueReference(alias)) {
            aliasBean.setValueBinding("alias",
                                      app.createValueBinding(aliasAttr.getValue()));
        }
        else
        {
            aliasBean.setAlias(alias);
        }

        parent.getChildren().add(aliasBean);
    }
}