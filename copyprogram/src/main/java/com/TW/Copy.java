package com.TW;

public class Copy {
    private ReadKeyboard readKeyboard;
    private WritePrinter writePrinter;

    public Copy(ReadKeyboard readKeyboard, WritePrinter writePrinter) {
        this.readKeyboard = readKeyboard;
        this.writePrinter = writePrinter;
    }

    public void copy() {
        writePrinter.print(this.readKeyboard.get());
    }
}
