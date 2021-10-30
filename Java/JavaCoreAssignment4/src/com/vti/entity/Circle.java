package com.vti.entity;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    private static final double PI = 3.14;
    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }
    public double getArea(){
        return this.radius*2*PI;
    }

    @Override
    public String toString() {
        return "Circle: \n" +
                "radius: " + radius + "\n" +
                "color: " + color + "\n" +
                "area: " + getArea() + "\n";
    }
}
