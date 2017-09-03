package com.vihangpatil.java9app.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

/**
 * @author Vihang Patil <vihang.patil@gmail.com>
 */
public class ShapeFactory {

    public Optional<Shape> newInstance(final String shape, final Object... params) throws
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {

        final Class<? extends Shape> shapeClass = (Class<? extends Shape>) Class.forName(
                "com.vihangpatil.java9app." + shape);
        final Constructor[] constructors = shapeClass.getConstructors();
        nextConstructor: for(Constructor<Shape> constructor : constructors) {
            final Class[] paramClasses = constructor.getParameterTypes();
            if(paramClasses.length != params.length) {
                continue;
            }
            int index = 0;

            for(Object param : params) {
                final Class paramClass = paramClasses[index];
                if(!paramClass.isInstance(param)
                        && !(paramClass == Boolean.TYPE && Boolean.class.isInstance(param))
                        && !(paramClass == Short.TYPE && Short.class.isInstance(param))
                        && !(paramClass == Integer.TYPE && Integer.class.isInstance(param))
                        && !(paramClass == Long.TYPE && Long.class.isInstance(param))
                        && !(paramClass == Float.TYPE && Float.class.isInstance(param))
                        && !(paramClass == Double.TYPE && Double.class.isInstance(param))) {
                    continue nextConstructor;
                }
                ++index;
            }

            return Optional.of(constructor.newInstance(params));
        }
        return Optional.empty();
    }
}
