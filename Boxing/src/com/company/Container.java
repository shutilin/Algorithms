package com.company;

import java.util.ArrayList;
import java.util.List;

public class Container {

    public double fullSpace;
    public List<Double> elements;

    public Container() {
        this.fullSpace = 1.0;
        this.elements = new ArrayList<Double>();
    }

    public Container(double element) {
        this.fullSpace = 1.0;
        this.elements = new ArrayList<Double>();

        this.elements.add(element);
    }

    public void addElement(double element) {
        this.elements.add(element);
    }

    public Boolean isEnoughSpaceForElem(double element) {
        Double sum = 0.0;

        for (Double el : elements) {
            sum += el;
        }

        return (fullSpace - sum) >= element;
    }

    @Override
    public String toString() {
        String result = "[ ";
        for (Double el: elements) {
            result += el + " ";
        }

        result += "]";

        return  result;
    }

}
