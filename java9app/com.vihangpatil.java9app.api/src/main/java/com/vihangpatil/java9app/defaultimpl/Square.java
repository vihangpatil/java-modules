package com.vihangpatil.java9app.defaultimpl;

import com.vihangpatil.java9app.api.Shape;

/**
 * @author Vihang Patil <vihang.patil@gmail.com>
 */
public class Square implements Shape {

    final int side;

    public Square(final int side) {
        this.side = side;
    }

    @Override
    public long getArea() {
        return side * side;
    }
}
