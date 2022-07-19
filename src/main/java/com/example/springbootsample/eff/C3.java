package com.example.springbootsample.eff;

import lombok.Data;

import java.awt.*;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 对于所有对象都通用的方法
 * equals 方法实现了等价关系（ equi va lence relation ），其属性如下：
 * 自反性（ reflexive 对于任何非 null 的引用值 equals(x ）必须返回 true
 * 对称性（ symmetric ）：对于任何非 null 的引用值 ，当且仅当 y.equals(x ）返
 * true 时＇， x.equals(y ）必须返回 true
 * 传递性（ transitive 对于任何非 null 的引用值 ，如果 x.equals(y ）返回
 * true ，并且 y.equals(z ）也返回 true ，那么 x.equals(z ）也必须返回 true
 * 一致性（ consistent 对于任何非 nu ll 引用值 ，只要 equals 的比较操作
 * 在对象中所用的信息没有被修改，多次调用 x.equals(y ）就会一致地返回 true,
 * 或者一致地返回 false
 * 对于任何非 null 的引用值 x, x.equals (null ）必须返回 false
 */
public class C3 {

    static class CaseInsensitiveString {
        private String s;

        public CaseInsensitiveString(String s) {
            this.s = Objects.requireNonNull(s);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CaseInsensitiveString that = (CaseInsensitiveString) o;
            return Objects.equals(s, that.s);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s);
        }
    }

    @Data
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class ColorPoint extends Point {
        private Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            ColorPoint that = (ColorPoint) o;
            return Objects.equals(color, that.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), color);
        }
    }

    class CounterPoint extends Point {
        AtomicInteger atomicInteger = new AtomicInteger();

        public CounterPoint(int x, int y) {
            super(x, y);
            atomicInteger.incrementAndGet();
        }

        public int numberCreated() {
            return atomicInteger.get();
        }
    }

    /**
     * 里氏替换原则（ Liskov substitution princip ）认为 一个类型的任何重要属性也将适用于它
     * 子类型，因 为该类型编写的任何方法，在它的子类型上 应该同样运行得很好 skov87
     * 针对上述 Poi 的子类（ CounterPo nt 然是 Point ，并且必须发挥作用的例 ，这
     * 个就是它的正式语句 但是假设我 CounterPoint 实例传给了。nUnitC ir cle
     * Point 类使用了基于 getClass equals 方法，无论 CounterPoint 实例的
     * 是什么， onUnitCircle 方法都会返回 false
     */
 // ：遵从第 18 条“复合优先于继承”的建议
    class  ColorPoint2{
        private Point point;
        private Color color;
        public ColorPoint2(int x,int y,Color color){
            point = new Point(x,y);
            color = color;
        }

        public Point asPoint(){
            return point;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ColorPoint2 that = (ColorPoint2) o;
            return Objects.equals(point, that.point) && Objects.equals(color, that.color);
        }

        @Override
        public int hashCode() {
            return Objects.hash(point, color);
        }
    }

    class PhoneNumber {
        private short areaCode,prefix,lineNum;
        public PhoneNumber(int areaCode,int prefix,int lineNum){

        }

        private short rangeCheck(int val,int max,String arg){
            if(val<0 || val > max){

            }
            return (short) val;
        }

    }
    // 11 ：覆盖 equals 时总要覆盖 hash Code

    /**
     * 在应用程序的执行期间，只要对象的 equals 方法的比较操作所用到的信息没有被
     * 修改，那么对同一个对象的多次调用， hashCode 方法都必须始终返回同一个值
     * 在一个应用程序与另一个程序的执行过程中，执行 hashCode 方法所返回的值可以
     * 一致
     * 如果两个对象根据 equals(Object ）方法比较是相等的，那么调用这两个对象中
     * hashCode 方法都必须产生同样的整数结果
     * 如果两个对象根据 equals(Object ）方法比较是不相等的，那么调用这两个对象
     * 中的 hashCode 方法，则不一定要求 hashCode 方法必须产生不同的结果 但是程
     * 序员应该知道，给不相等的对象产生截然不同的整数结果，有可能提高散列表（ hash
     * table ）的性能
     * 因没有 hashCode 而违反的关 约定 第二条：相等的对象必须具有相等的散到
     * 码（ hash code
     * @param args
     * 之所以选择 31 ，是因为
     * 它是一个奇素数 如果乘数是偶数，并且乘法、溢出的话，信息就会丢失，因为与 相乘等价
     * 于移位运算 使用素数的好处并不很明显，但是习惯上都使用素数来计算散列结果 有个
     * 很好的特性，即用移位和减法来代替乘法，可以得到更好的性能 31 女 i = = ( i < < 5 ) -
     * 现代的虚拟机可以自动完成这种优化
     */


    public static void main(String[] args) {
//        final CaseInsensitiveString polish = new CaseInsensitiveString("Polish");


    }

}
