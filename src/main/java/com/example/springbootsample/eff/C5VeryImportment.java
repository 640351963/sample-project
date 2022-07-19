package com.example.springbootsample.eff;

import java.util.HashSet;
import java.util.Set;

/**
 * 泛型： 编译-运行
 */
public class C5VeryImportment {
    // 26 请不要使用原生态类型

    /**
     * 参数化的类型 List<String> 26
     * 实际类型参数 String ng
     * 泛型 List<E> 26 条和第 29
     * 形式类型参数 E 26
     * 无限制统配符类型 配符类型 List<?> 26
     * 原生态类型 List 26
     * 有限制类型参数 <E extends Number> 29
     * 递归类型限制 <T extends Comparable<T>
     * 有限制通配符类型 List<? extends Number> 31
     * 泛型方法 stat 工 c <E> List<E> asList (E [ J a) 30
     * 类型令牌 String . class 3
     */


    public static void main(String[] args) {
        Set<Lake> exaltation = new HashSet<>();
    }

    static class Lake {

    }

    public <T> T[] toArray(T[] a){
        if(a.length < 1){

        }
        return null;
    }
}

