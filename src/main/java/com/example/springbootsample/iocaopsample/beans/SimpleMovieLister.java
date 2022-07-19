package com.example.springbootsample.iocaopsample.beans;

public class SimpleMovieLister {

    private MovieFinder movieFinder;

    public SimpleMovieLister(MovieFinder movieFinder){
        this.movieFinder = movieFinder;
    }


}
