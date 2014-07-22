package cci;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by xzhang71 on 7/21/14.
 */
public class ExampleReflection {

    private double a;
    private double b;

    public ExampleReflection(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double generate(double c) {
        return a * b * c;
    }

    public static void main(String[] args) {
        try {
            Class exampleClass = Class.forName("cci.ExampleReflection");

            Class[] constructorArgumentClasses = {double.class, double.class};
            Constructor constructor = exampleClass.getConstructor(constructorArgumentClasses);

            Object[] constructorArguments = {1.0, 2.0};
            ExampleReflection example = (ExampleReflection) constructor.newInstance(constructorArguments);

            Class[] methodArgumentClasses = {double.class};
            Method method = exampleClass.getMethod("generate", methodArgumentClasses);

            Object[] methodArguments = {3.0};
            double result = (double) method.invoke(example, methodArguments);

            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}