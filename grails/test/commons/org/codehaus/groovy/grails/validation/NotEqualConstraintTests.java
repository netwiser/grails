package org.codehaus.groovy.grails.validation;

import java.util.Date;

/**
 * Test cases for 'notEqual' constraint.
 *
 * @author Sergey Nebolsin (<a href="mailto:nebolsin@gmail.com"/>)
 */
public class NotEqualConstraintTests extends AbstractConstraintTests {
    protected Class getConstraintClass() {
        return NotEqualConstraint.class;
    }

    public void testValidation() {
        testConstraintMessageCodes(
                getConstraint( "testString", "12345" ),
                "12345",
                new String[] {"testClass.testString.notEqual.error","testClass.testString.notEqual"},
                new Object[] {"testString",TestClass.class,"12345","12345"}
        );

        testConstraintPassed(
                getConstraint( "testString", "12345" ),
                "1234"
        );

        testConstraintPassed(
                getConstraint( "testLong", new Long(123) ),
                new Long(122)
        );

        testConstraintPassed(
                getConstraint( "testDate", new Date(123) ),
                null
        );

        testConstraintDefaultMessage(
                getConstraint( "testString", "123" ),
                "123",
                "Property [{0}] of class [{1}] with value [{2}] cannot equal [{3}]"
        );
    }

    public void testCreation() {
        NotEqualConstraint constraint = (NotEqualConstraint) getConstraint( "testString", "12345" );
        assertEquals( ConstrainedProperty.NOT_EQUAL_CONSTRAINT, constraint.getName() );
        assertTrue( constraint.supports( String.class ));
        assertTrue( constraint.supports( Object.class ));
        assertFalse( constraint.supports( null ));

        assertEquals( "12345", constraint.getNotEqualTo() );
    }
}