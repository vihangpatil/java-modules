# Java 9 - JPMS (Java Platform Module System) + Maven + IntelliJ

This is a _sandbox_ app created to test out Java 9' Project Jigsaw with Maven functionality.

For Project Jigsaw, without maven, check this tutorial:
http://openjdk.java.net/projects/jigsaw/quick-start

For reference, I have also added Java 8 app to do the similar thing.

I have used simple Java Reflection API and not the ServiceLoader since I wanted to pass parameters and not use default 
constructors or Abstract Factories.  

## Experiment

 * Created an `interface Shape`
 * Created two implementations `class Circle` and `class Square` of `interface Shape`.
 * `Main App` should have `compile-time` dependency on `interface Shape`, 
    but `runtime` dependency on implementations. 

## Modules

1. **API**
    * Module which has `interface Shape` and _default_ implementation `class Square`.
2. **IMPL**
    * Module has `compile-time` dependency on **API**. 
    * This module has `class Circle` which has _custom_ implementation of `interface Shape`.
3. **APP**
    * This module has the `Main` class.
    * It will use `class ShapeFactory` in **API**,
   which will create objects of `Circle` and `Square` using Java Reflection API 
   (wanted to keep things simple and avoid any dependency injection libs/frameworks).
    * Try to uncomment the lines which are trying to use `Circle` and `Square` classes at _compile-time_. It should give a compile-time error. 

## Dependencies


    [APP] ---- (compile-time) ----> [API] <---- (compile-time) ---- [IMPL]
       \                                                             ^
        \_________________________ (runtime) _______________________/


## Building via Maven

    mvn clean package

## Maven Toolchain settings

Add this in `~/.m2/toolchains.xml`

    <?xml version="1.0"?>
    <toolchains>
      <toolchain>
        <type>jdk</type>
        <provides>
          <version>1.9</version>
          <vendor>oracle</vendor>
        </provides>
        <configuration>
          <jdkHome>/path/to/java-9/home</jdkHome>
        </configuration>
      </toolchain>
    </toolchains>

## Running from IntelliJ

Java9's JPMS do not work on IntelliJ 2017.2.*

You need IntelliJ with version 2017.3 or later.

You may need to explicitly change the module SDKs to Java9.