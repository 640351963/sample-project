package com.example.springbootsample.eff;

import lombok.Data;

import java.time.Instant;
import java.util.*;
import java.util.function.Predicate;

/**
 * 类和接口
 */
public class C4 {
    /**
     15 条：使类和成员的可访问性最小化
     组件好坏： 对于外部其他组件，是否隐藏其内部数据和其他实现细节，设计良好组件会隐藏所有的实现细节
     infomation hidding 隐藏, encapsulation 封装
     信息隐藏之所以非常重要有许多原因，其中大多是因为 它可以有效 解除组成系统的各组件之 的藕合关系，即解相（ de upl ），
     使得这些组件可以独立地开发、 试、优、使用、理解和修改 因为这些组件可以并行开发，所以加快了系统开发的速度
     */

    /**
     * 尽可能地使每个类或者成员不被外界访问
     */
    @Data
    class Point {
        private double x;
        private double y;
    }

    class Time {
        int HOURSE_PRE_DAY = 24;
        int MINUTES_PRE_HOUR = 60;
        int hour;
        int minute;

        public Time(int h, int m) {

        }
    }
    // 17 使可变性 小化

    /**
     * 不要提供任何会 改对 状态的方法
     * 保证类不会 扩展
     * 声明所有的域都是final
     * 声明所有的域都为私有的
     * 确保对于任何可变组件的互斥访问
     */
    class Complex {
        private double re;
        private double im;

        public Complex(double re, double im) {
            this.re = re;
            this.im = im;
        }

    }

    // !!复合优先于继承 与方法调用不同的是，继承打破了封装性［ Snyder86
    class FowardingSet<E> implements Set<E> {

        private Set<E> s;

        public FowardingSet(Set<E> s) {
            this.s = s;
        }


        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(E e) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }
    }

    // 获取了set接口特性 并且提供了新功能 Wrapper Class-> ！！ 包装类不适用于回调框架，回调框架 对象把自身引用传递给其他对象，用于
    // 后续的调用    两类之间存在 is-a 关系，类B才应扩展类A ，类B 扩展类A  ，每个B也是A 吗
    // ，那么 就不应该扩展 如果答案是否定的，通常情况下， 应该包含的一个私有实例，并且暴露一个较小的、较简单的 API: 本质上不是 的一部分，只是它的实现细节而已
    class InstrumentedSet<E> extends FowardingSet<E> {
        private int addCount;

        public InstrumentedSet(Set<E> s) {
            super(s);
        }

        @Override
        public boolean add(E e) {
            addCount++;
            return super.add(e);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            addCount += c.size();
            return super.addAll(c);
        }

        public int getAddCount() {
            return addCount;
        }
    }
    // 19 条：要么设计继承并提供文档说明，要么禁止继承

    class Super {
        public Super() {
            overrideMe();
        }

        public void overrideMe() {
        }
    }

    class Sub extends Super {
        private Instant instant = null;

        Sub() {
            instant = Instant.now();
        }

        @Override
        public void overrideMe() {
            System.out.println(instant);
        }
    }

    //  打印两次，第一次打印null, 因为overrideMe 被super 构造调用，sub 的 instant未初始化
    // final 域处理两种不同状态 ，如果 overriedMe 调用 instant 任何方法 ，当super 调用 就会抛出NPE问题
//    无论是 clone 还是「eadObject 都不可以调用可 盖的方 法，不管是以直接还是间接的方式
    // 为了继承而设计类，对这个类会有一些实质性的限制。 包括接口的骨架实现（ ske implementation)
    // 这个问题的最佳解决方案是，对于那些并非为了安全地进行子类化而设计和编写文档的类，要禁止子类化


    // 接口优于抽象类 ：接口优于抽象类 , 接口是定义 mixin （混合类型）的理想选择 , 接口允许构造非层次结构的类型框架
    class AudioClip {
    }

    interface Song {
    }

    interface Singe {
        AudioClip sing(Song s);
    }

    interface SongWriter {

    }

    interface Songwriter {
        Song compose(int chartPosition);
    }

    /**
     * ，有些歌唱家本身也是作曲家 因为我们使用了接口而不是抽象类来定
     * 义这些类型，所以对于单个类而 ，它同时实现 Singer So gwriter 是完全允许的
     * 实际上，我们可以定义第三个接口，它同时扩展 Singer Songwriter ，并添加一些
     */
    interface SingerSongWriter extends Song, SongWriter {
        AudioClip strum();

        /**
         * 另外一种
         * 做法是编写一个脆肿（ bloated ）的类层次，对于每 种要被支持的属性组合，都包含一个单
         * 独的类 果在整个类型系统中有 个属性，那么就必须支持 种可能的组合 这种现象
         * 被称为“纽合爆炸”（ combinatorial explosio
         */
        void actSensitive();
    }

    class IntArraysAsList {
        // Adapte
        List<Integer> intArrayAsList(int[] a) {
            Objects.requireNonNull(a);
            return new AbstractList<Integer>() {
                @Override
                public Integer get(int index) {
                    return a[index];
                }

                @Override
                public int size() {
                    return a.length;
                }
            };
        }
    }


    abstract class MyAbstractMapEntity<K, V> implements Map.Entry<K, V> {

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        /**
         * 有了缺省方法，接口的现有实现就不会出现编译时没有报错或 告，运行时却失败的
         * 情况 这
         */
//        default boolean removeIf(Predicate<? super E> filter){
//
//        }


    }
    // 22 条：接口只用于定义类型

    interface PhysicalConstants {
        // bad 量接口模式是对接口的不良使用
        static int AA = 1;
        static int BB = 2;
    }
    // Good

    class PhysicalζonstantsClazz {
        int AA = 1;
        int BB = 2;
    }

    // ，这样的 型有
    //两个：圆形（ circle ）和矩形（ rectangle 在每个子类中都包含特定于该类型 数据域
    abstract class Figure {
        abstract double area();
    }

    class Circle extends Figure {

        private double raduis;

        Circle(double d) {
            raduis = d;
        }

        @Override
        double area() {
            return 0;
        }
    }

    class Rectangle extends Figure {

        double length;
        double width;

        Rectangle(double l, double w) {
            length = l;
            width = w;
        }

        @Override
        double area() {
            return 0;
        }
    }

    class Square extends Rectangle {
        Square(double side) {
            super(side, side);
        }
    }

    class MySet<E> extends AbstractSet<E> {
        @Override
        public Iterator<E> iterator() {
            return new MyIterator();
        }

        @Override
        public int size() {
            return 1;
        }

        // 如果声明成员类不要求访问外围实例，就要始终把修饰符 static 放在它的声明中，
        private class MyIterator implements Iterator<E> {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        }
    }

    // 25 条：限制 原文件为单个顶级类 永远不要把多个顶级类或者接口放在一个源文件中
    class Mains {

    }

    class Utensil {
        String NAME = "pan";
    }

    class Dessert {
        String NAME = "";
    }




}


