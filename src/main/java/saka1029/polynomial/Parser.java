package saka1029.polynomial;

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

}
