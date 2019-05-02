package com.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        List<Container> containers = new ArrayList<Container>();

        containers.add(new Container());

//        Scanner in = new Scanner(System.in).useLocale(Locale.US);
//        double element;
//        while (true) {
//            element = in.nextDouble();
//
//            boolean isNewContainerRequired = true;
//            for (Container c : containers) {
//                if (c.isEnoughSpaceForElem(element)) {
//                    c.addElement(element);
//                    isNewContainerRequired = false;
//                    break;
//                }
//            }
//
//            if (isNewContainerRequired) containers.add(new Container(element));
//            System.out.println(containers);
//        }

        List<Double> elements = new ArrayList<Double>();
        for (int i=0; i<ThreadLocalRandom.current().nextInt(10, 30); i++) {
            elements.add(ThreadLocalRandom.current().nextDouble(0.0, 1.0));
        }

        //Bad practise
        Collections.sort(elements);
        Collections.reverse(elements);


        System.out.println(elements);


        for (Double element: elements) {
            boolean isNewContainerRequired = true;
            for (Container c : containers) {
                if (c.isEnoughSpaceForElem(element)) {
                    c.addElement(element);
                    isNewContainerRequired = false;
                    break;
                }
            }

            if (isNewContainerRequired) containers.add(new Container(element));
        }
        System.out.println(containers);

    }

}
