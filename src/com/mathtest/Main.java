package com.mathtest;

import org.terasology.math.JomlUtil;
import org.terasology.math.geom.Matrix4f;
import org.terasology.math.geom.Vector3f;

import static org.terasology.math.JomlUtil.from;

public class Main {

    public static void lineNO() {
        int lineNumber;
        try {
            lineNumber = Thread.currentThread().getStackTrace()[4].getLineNumber();
        }
        catch(Exception e) {
            lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
        }
        System.out.print(lineNumber);
    }

    public static void print(org.terasology.math.geom.Matrix4f in) {
        System.out.printf("%f %f %f %f%n%f %f %f %f%n%f %f %f %f%n%f %f %f %f%n",
                in.m00, in.m01, in.m02, in.m03,
                in.m10, in.m11, in.m12, in.m13,
                in.m20, in.m21, in.m22, in.m23,
                in.m30, in.m31, in.m32, in.m33
        );
    }
    public static void print(org.terasology.math.geom.Vector4f in) {
        System.out.printf("%f %f %f %f%n",
                in.x, in.y, in.z, in.w
        );
    }
    public static void print(org.terasology.math.geom.Vector3f in) {
        System.out.printf("%f %f %f%n",
                in.x, in.y, in.z
        );
    }
    public static void print(org.terasology.math.geom.Quat4f in) {
        System.out.printf("%f %f %f %f%n",
                in.x, in.y, in.z, in.w
        );
    }
    public static void print(org.joml.Matrix4f in) {
        print(from(in));
    }
    public static void print(org.joml.Vector4f in) {
        print(from(in));
    }
    public static void print(org.joml.Vector3f in) {
        print(from(in));
    }
    public static void print(org.joml.Quaternionf in) {
        print(from(in));
    }
    public static void equals(org.terasology.math.geom.Matrix4f test1, org.joml.Matrix4f test2) {
        equals(test2, test1);
    }
    public static void equals(org.joml.Matrix4f test1, org.terasology.math.geom.Matrix4f test2) {
        lineNO();
        org.joml.Matrix4f temp = from(test2);
        if(temp.equals(test1)) {
            System.out.println(": Passed!");
        }
        else {
            System.out.println(": Failed -> ");
            print(test1);
            print(test2);
        }
    }
    public static void equals(float test1, float test2) {
        lineNO();
        if(test1 == test2) {
            System.out.println(": Passed!");
        }
        else {
            System.out.println(": Failed -> ");
            System.out.println(test1);
            System.out.println(test2);
        }
    }
    public static void equals(org.terasology.math.geom.Vector4f test1, org.joml.Vector4f test2) {
        equals(test2, test1);
    }
    public static void equals(org.joml.Vector4f test1, org.terasology.math.geom.Vector4f test2) {
        lineNO();
        org.joml.Vector4f temp = from(test2);
        if(temp.equals(test1)) {
            System.out.println(": Passed!");
        }
        else {
            System.out.println(": Failed -> ");
            print(test1);
            print(test2);
        }
    }

    public static void equals(org.terasology.math.geom.Vector3f test1, org.joml.Vector3f test2) {
        equals(test2, test1);
    }
    public static void equals(org.joml.Vector3f test1, org.terasology.math.geom.Vector3f test2) {
        lineNO();
        org.joml.Vector3f temp = from(test2);
        if(temp.equals(test1)) {
            System.out.println(": Passed!");
        }
        else {
            System.out.println(": Failed -> ");
            print(test1);
            print(test2);
        }
    }

    public static void main(String[] args) {

        org.terasology.math.geom.Matrix4f teraMat = new org.terasology.math.geom.Matrix4f(0f,1f,2f,3f,4f,5f,6f,7f,8f,9f,10f,11f,12f,13f,14f,15f);
        org.joml.Matrix4f jomlMat = new org.joml.Matrix4f(0f,1f,2f,3f,4f,5f,6f,7f,8f,9f,10f,11f,12f,13f,14f,15f);
        //equals(teraMat, jomlMat);
        //equals(jomlMat, teraMat);

        org.terasology.math.geom.Matrix4f teraMatMul = new org.terasology.math.geom.Matrix4f(2f,3f,4f,5f,1f,6f,3f,7f,8f,3f,5f,1f,4f,2f,7f,3f);
        org.joml.Matrix4f jomlMatMul = new org.joml.Matrix4f(2f,3f,4f,5f,1f,6f,3f,7f,8f,3f,5f,1f,4f,2f,7f,3f);
        teraMat.mul(teraMatMul);
        jomlMatMul.mul(jomlMat);
        //equals(teraMat, jomlMatMul);

        org.joml.Vector4f jomlVec4 = new org.joml.Vector4f(1f, 4f, -3f, -9f);
        org.terasology.math.geom.Vector4f teraVec4 = new org.terasology.math.geom.Vector4f(1f, 4f, -3f, -9f);
        //equals(jomlVec4, teraVec4);

        org.joml.Vector4f jomlVec4Dot = new org.joml.Vector4f(3f, -6f, 3f, 5f);
        org.terasology.math.geom.Vector4f teraVec4Dot = new org.terasology.math.geom.Vector4f(3f, -6f, 3f, 5f);
        //equals(jomlVec4.dot(jomlVec4Dot), teraVec4.dot(teraVec4Dot));

        org.terasology.math.geom.Vector3f teraVec3 = new org.terasology.math.geom.Vector3f(1f, 4f, -3f);
        org.joml.Vector3f jomlVec3 = new org.joml.Vector3f(1f, 4f, -3f);
        org.joml.Vector3f jomlVec3Cross = new org.joml.Vector3f(3f, -6f, 3f);
        org.terasology.math.geom.Vector3f teraVec3Cross = new org.terasology.math.geom.Vector3f(3f, -6f, 3f);
        //equals(teraVec3.cross(teraVec3, teraVec3Cross), jomlVec3.cross(jomlVec3Cross));

        org.joml.Quaternionf jomlQuat = new org.joml.Quaternionf(new org.joml.AxisAngle4f((float)Math.PI/2,1.0f,-1.0f, 1.0f));
        org.terasology.math.geom.Quat4f teraQuat = new org.terasology.math.geom.Quat4f(new org.terasology.math.geom.Vector3f(1.0f,-1.0f,1.0f), (float)Math.PI/2);

        print(jomlQuat);
        print(teraQuat);

        org.terasology.math.geom.Matrix4f teraMat4= new org.terasology.math.geom.Matrix4f(teraQuat, new org.terasology.math.geom.Vector3f(0.0f, 0.0f, 0.0f), 1.0f);
        org.joml.Matrix4f jomlMat4= new org.joml.Matrix4f().rotation(jomlQuat);
        print(teraMat4);
        print(jomlMat4);

    }
}
