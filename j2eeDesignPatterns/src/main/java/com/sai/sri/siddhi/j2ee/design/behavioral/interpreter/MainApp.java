package com.sai.sri.siddhi.j2ee.design.behavioral.interpreter;

import com.sai.sri.siddhi.j2ee.design.structural.filter.CriteriaMale;

import java.time.temporal.IsoFields;

public class MainApp {

    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    public static Expression getFemaleMarriedExpression() {
        Expression female = new TerminalExpression("Female");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(female, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isFemaleMarried = getFemaleMarriedExpression();

        System.out.println("Is Robert male? " + isMale.interpret("Robert"));
        System.out.println("Is Julie Female ? " + isFemaleMarried.interpret("Julie Female Married"));
    }
}


