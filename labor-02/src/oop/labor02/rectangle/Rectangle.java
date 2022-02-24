package oop.labor02.rectangle;

public class Rectangle {
    private double length, width;

    public Rectangle(double length, double width){

        this.length = length;
        this.width = width;
    }
    public double getLength(){
        return length;
    }
    public double getWidth(){
        return width;
    }
    public double area(){
        return length*width;
    }
    public double perimeter(){
        return 2*(length+width);
    }
}
