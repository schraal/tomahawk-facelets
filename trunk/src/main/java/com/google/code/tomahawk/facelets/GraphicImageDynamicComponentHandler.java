/**
 * Copyright 2007
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.google.code.tomahawk.facelets;

import com.sun.facelets.tag.MetaRuleset;
import com.sun.facelets.tag.MethodRule;
import com.sun.facelets.tag.jsf.ComponentConfig;
import com.sun.facelets.tag.jsf.html.HtmlComponentHandler;

/**
 * $Id$
 */
public class GraphicImageDynamicComponentHandler extends HtmlComponentHandler
{
    protected final static Class[] GET_BYTES_METHOD_SIG = new Class[0];
    protected final static Class[] GET_CONTENT_TYPE_METHOD_SIG = new Class[0];
    protected final static MethodRule getBytesMethodTagRule
       = new MethodRule("getBytesMethod", byte[].class, GET_BYTES_METHOD_SIG);
    protected final static MethodRule getContentTypeMethodTagRule
       = new MethodRule("getContentTypeMethod", String.class, GET_CONTENT_TYPE_METHOD_SIG);

    public GraphicImageDynamicComponentHandler(ComponentConfig tagConfig)
    {
        super(tagConfig);
    }

    protected MetaRuleset createMetaRuleset(Class type)
    {
        MetaRuleset m = super.createMetaRuleset(type);

        m.addRule(getBytesMethodTagRule);
        m.addRule(getContentTypeMethodTagRule);

        return m;
    }
}
