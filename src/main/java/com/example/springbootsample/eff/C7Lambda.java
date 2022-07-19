package com.example.springbootsample.eff;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class C7Lambda {


    public static void main(String[] args) {

        Collections.sort(Arrays.asList("a"), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(),o2.length());
            }
        });

        Collections.sort(Arrays.asList("a"), (s1,s2)->Integer.compare(s1.length(),s2.length()));
    }

    enum Operation {
        PLUS("+"){
            public double apply(double x,double y){
                return  x+y;
            }
        },
        TIMS("*"){
            public double apply(double x,double y){
                return  x+y;
            }
        };
        Operation(String x){

        }
        public abstract  double apply(double x,double y);
    }
}
