package com.example.demo.java.design_pattern.observer;

public class ObserverClient {
    public static void main(String[] args) {
        Subject subject = new Subject();
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        OctalObserver octalObserver = new OctalObserver(subject);
        subject.setState(10);
    }
}
