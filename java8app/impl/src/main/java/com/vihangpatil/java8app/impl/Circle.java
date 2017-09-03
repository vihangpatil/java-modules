package com.vihangpatil.java8app.impl;

import com.vihangpatil.java8app.api.Shape;

/**
 * @author Vihang Patil <vihang.patil@gmail.com>
 */
public class Circle implements Shape {

    final int radius;

    public Circle() {
        this.radius = 0;
    }

    public Circle(final int radius) {
        this.radius = radius;
    }

    @Override
    public long getArea() {
        return Math.round(Math.PI * radius * radius);
    }
}
