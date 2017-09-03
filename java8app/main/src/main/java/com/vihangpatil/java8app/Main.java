package com.vihangpatil.java8app;

import com.vihangpatil.java8app.api.Shape;
import com.vihangpatil.java8app.api.ShapeFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.ServiceLoader;

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
                .newInstance("Circle", 7)
                .map(Shape::getArea)
                .ifPresent(area ->
                        System.out.println("Area of circle (radius:7) is " + area));

        // Perfect - excluded using Maven's scope=runtime
//        System.out.println(new Circle(10).getArea());
    }
}
