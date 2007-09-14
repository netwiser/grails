/**
 * Tests rendering of static content
 
 * @author Graeme Rocher
 * @since 1.0
  *
 * Created: Sep 11, 2007
 * Time: 10:41:58 PM
 * 
 */
package org.codehaus.groovy.grails.web.pages

import org.codehaus.groovy.grails.web.taglib.AbstractGrailsTagTests

class StaticContentRenderingTests extends AbstractGrailsTagTests {

    void testStaticContent() {


        def template = '''<div>
  <g:each in="${numbers}">
    <p>${it}</p>
  </g:each>
</div>'''

        assertOutputEquals('<div>    <p>1</p>    <p>2</p>    <p>3</p></div>', template, [numbers:[1,2,3]])
    }
}