package com.vihangpatil.java9app;

import com.vihangpatil.java9app.api.Shape;
import com.vihangpatil.java9app.api.ShapeFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Vihang Patil <vihang.patil@gmail.com>
 */
public class Main {
    public static void main(String[] args) throws
            ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        new ShapeFactory()
                .newInstance("defaultimpl.Square", 5)
                .map(Shape::getArea)
                .map(area -> "Area of square (side=5) :" + area)
                .ifPresent(System.out::println);

        // Perfect - excluded using Java 9's module
//        System.out.println(new Square(10).getArea());

        new ShapeFactory()
                .newInstance("impl.Circle", 7)
                .map(Shape::getArea)
                .map(area -> "Area of circle (radius=7) :" + area)
                .ifPresent(System.out::println);

        // Perfect - excluded using Java 9's module
//        System.out.println(new Circle(10).getArea());

    }
}
