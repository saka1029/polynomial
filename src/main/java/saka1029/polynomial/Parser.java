package saka1029.polynomial;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    
    final int[] input;
    int ch, index = 0;

    Parser(String in) {
        this.input = in.codePoints().toArray();
        this.index = 0;
        get();
    }

    int get() {
        return ch = index < input.length
            ? input[index++] : -1;
    }

    void spaces() {
        while (Character.isWhitespace(ch))
                get();
    }

    boolean eat(int expected) {
        spaces();
        if (ch == expected) {
            get();
            return true;
        }
        return false;
    }

    static boolean isVariable(int ch) {
        return Character.isLetter(ch);
    }

    static boolean isDigit(int ch) {
        return ch >= '0' && ch <= '9';
    }

    long digits() {
        long d = 0;
        while (isDigit(ch)) {
            d = d * 10L + Character.digit(ch, 10);
            get();
        }
        return d;
    }

    long parsePower() {
        if (eat('^')) {
            spaces();
            if (!isDigit(ch))
                throw new RuntimeException("digit expected after '^'");
            return digits();
        }
        return 1L;
    }

    Term parsePrimary(Term term) {
        if (isVariable(ch)) {
            String v = Character.toString(ch);
            get();      // skip variable;
            return term.mult(v, parsePower());
        } else if (isDigit(ch)) {
            long n = digits();
            return term.mult((long)Math.pow(n, parsePower()));
        } else
            throw new RuntimeException("unexpected char '%s'"
                .formatted(Character.toString(ch)));
    }

    Term parseTerm(long sign) {
        Term term = Term.of(sign);
        spaces();
        term = parsePrimary(term);
        while (true) {
            if (eat('*'))
                /* do nothing */;
            spaces();
            if (isVariable(ch) || isDigit(ch))
                term = parsePrimary(term);
            else
                break;
        }
        return term;
    }

    public Polynomial parsePolynomial() {
        List<Term> terms = new ArrayList<>();
        long sign = eat('-') ? -1L : 1L;
        terms.add(parseTerm(sign));
        while (true)
            if (eat('+'))
                terms.add(parseTerm(1L));
            else if (eat('-'))
                terms.add(parseTerm(-1L));
            else
                break;
        return Polynomial.of(terms);
    }
}
