//Display to the Console output
package com.thoughtworks.biblioteca;

public class Display {

    String message;

    public Display(String message) {
        this.message = message;
    }

    public void display() {
        System.out.print(message);
    }
}