package com.mini.spring.test;

public class AServiceImpl implements AService {
    private String p1;

    private String name;

    private int level;

    public AServiceImpl() {
    }

    public AServiceImpl(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, " + this.name + "!");
        System.out.println("level, " + this.level);
        System.out.println("p1, " + this.p1);
    }
}