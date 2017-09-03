package com.vihangpatil.java9app.impl;

import com.vihangpatil.java9app.api.Shape;

/**
 * @author Vihang Patil <vihang.patil@gmail.com>
 */
public class Circle implements Shape {

    final int radius;

    public Circle(final int radius) {
        this.radius = radius;
    }

    @Override
    public long getArea() {
        return Math.round(Math.PI * radius * radius);
    }
}
