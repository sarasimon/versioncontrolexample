package com.TW;

import junit.framework.TestCase;

public class CopyTest extends TestCase {

    Copy copy;
    StubReadKeyboard readKeyboard;
    StubWritePrinter writePrinter;

    public void setUp() {
        readKeyboard = new StubReadKeyboard();
        writePrinter = new StubWritePrinter();
        copy = new Copy(readKeyboard, writePrinter);
    }

    public void testCopyWhenNoInputFromKeyboard() {
        readKeyboard.input = "";
        copy.copy();
        assertEquals("", writePrinter.output);
    }

    public void testCopyWhenWePassAFromKeyboardReturnsA() {
        readKeyboard.input = "a";
        copy.copy();
        assertEquals("a", writePrinter.output);
    }

    class StubWritePrinter implements WritePrinter {
        String output;

        public void print(String character) {
            this.output = character;
        }
    }

    class StubReadKeyboard implements ReadKeyboard {

        String input;

        public boolean hasNext() {
            return false;
        }

        public String get() {
            return input;
        }
    }


}
