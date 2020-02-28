package com.mathtest;

import org.terasology.math.JomlUtil;

import static org.terasology.math.JomlUtil.from;

public class Main {

    public static void print(org.terasology.math.geom.Matrix4f in) {
        System.out.printf("%f %f %f %f%n%f %f %f %f%n%f %f %f %f%n%f %f %f %f%n",
                in.m00, in.m01, in.m02, in.m03,
                in.m10, in.m11, in.m12, in.m13,
                in.m20, in.m21, in.m22, in.m23,
                in.m30, in.m31, in.m32, in.m33
        );
    }
    public static void print(org.joml.Matrix4f in) {
       print(from(in));
    }
    public static void equals(org.terasology.math.geom.Matrix4f test1, org.joml.Matrix4f test2) {
        equals(test2, test1);
    }
    public static void equals(org.joml.Matrix4f test1, org.terasology.math.geom.Matrix4f test2) {
        int lineNumber;
        try {
            lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
        }
        catch(Exception e) {
            lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
        }
        org.joml.Matrix4f temp = from(test2);
        if(temp.equals(test1)) {
            System.out.println(lineNumber+": Passed!");
        }
        else {
            System.out.println(lineNumber+": Failed -> ");
            print(test1);
            print(test2);
        }
    }

    public static void main(String[] args) {
        org.terasology.math.geom.Matrix4f test1 = new org.terasology.math.geom.Matrix4f(0f,1f,2f,3f,4f,5f,6f,7f,8f,9f,10f,11f,12f,13f,14f,15f);
        org.joml.Matrix4f test2 = new org.joml.Matrix4f(0f,1f,2f,3f,4f,5f,6f,7f,8f,9f,10f,11f,12f,13f,14f,15f);
        equals(test1, test2);
        equals(test2, test1);
        org.terasology.math.geom.Matrix4f test1mul = new org.terasology.math.geom.Matrix4f(2f,3f,4f,5f,1f,6f,3f,7f,8f,3f,5f,1f,4f,2f,7f,3f);
        org.joml.Matrix4f test2mul = new org.joml.Matrix4f(2f,3f,4f,5f,1f,6f,3f,7f,8f,3f,5f,1f,4f,2f,7f,3f);
        test1.mul(test1mul);
        test2mul.mul(test2);
        equals(test1, test2mul);
    }
}
