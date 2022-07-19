package com.example.springbootsample.eff;

import com.sun.org.apache.regexp.internal.RE;
import lombok.Data;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.util.StringUtils;
import sun.misc.Cleaner;

import java.nio.file.Files;
import java.util.*;
import java.util.regex.Pattern;

public class StaticFactory {
    /**
     * 静态工厂方法与构造器不同的第一大优势在于，它们有名称
     * e.g 为 ginteger.probablePrime  1.4
     */
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 静态工厂方法与构造器不同的第二大优势在于，不必在每次调用它们的时候都创建一个新对象
     * class Boolean  {
     * public static final Boolean TRUE = new Boolean(true); 这种类被称作实例受控的类（ instance-controlled
     * }
     */
    public static Boolean staticObject() {
        return Boolean.valueOf("true");
    }

    /**
     * 静态工厂方法与构造器不同的第三大优势在子，它们可以返回原返回类型的任何子类型的对象
     * @see java.util.Collections
     */


    /**
     * 静态工厂的第四大优势在于，所返回的对象的类可以随着每次调用而发生变化，这取决于静态工厂方法的参数值
     * 静态工厂的第五大优势在于，方法返回的对象所属的类，在编写包含该静态工厂方法的类时可以不存在
     */
    public static void enumSetSample() {
//        EnumSet.of(1)


    }

}


class ServiceSample {
    class User {

    }

    interface UserServiceInterface {

        public void adduser(User user);

        User getUser(Long id);
    }

    class UserServiceInterfaceProvider implements UserServiceInterface {

        @Override
        public void adduser(User user) {
            System.out.println("adduser->");
        }

        @Override
        public User getUser(Long id) {
            return new User();
        }
    }

    class ServiceRegister {

        Map<String, Object> serviceProvider = new HashMap<>();

        public int registerCount = 0;

        public void registerService(Class clazz) {
            try {
                if (clazz == null) {
                    System.out.println("service register stop ..... ");
                    return;
                }
                final String serviceProviderName = clazz.getName();
                if (StringUtils.isEmpty(serviceProviderName)) {
                    System.out.println("service provider name is  empty- >");
                    return;
                }
                synchronized (this) {
                    final Object o = clazz.newInstance();
                    serviceProvider.put(serviceProviderName, o);
                    registerCount++;
                }
//                Files.getFileStore("")
                System.out.println("service reister start ......");

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        public void call(String methodName, Class clazz) {
            System.out.println("call mehod success !");
        }

        public void showRegisterCountServiceProvider() {
            if (registerCount == 0) {
                System.out.println("thiere is no register servie count ");
                return;
            }
            System.out.println("register service count is = " + registerCount);

        }
    }


    @Data
    class NutritionFacts {
        private int servingSize;

        private int servings;

        private int calories;

        private int fat;

        private int sodium;

        private int carhobydrate;

        /**
         * 简而言之，重叠构造器模式可行，但是当有许多参数的时候，客户端代码会很难缩写，并且仍然较难以阅读
         */
        public NutritionFacts(int servingSize, int servings) {
            this(servingSize, servings, 0);
        }

        public NutritionFacts(int servingSize, int servings, int calories) {
            this(servingSize, servings, calories, 0);
        }

        public NutritionFacts(int servingSize, int servings, int calories, int fat) {

        }

        public NutritionFacts(int servingSize, int servings, int calories, int fat, int height) {

        }
    }

    @Data
    class SetNuttionFacts {
        private int servingSize;

        private int servings;

        private int calories;

        private int fat;

        private int sodium;

        private int carhobydrate;


        public void setBad() {
            // 在构造过程中 Java Bean 可能处于不一致的状态, ava Beans 模式使得把类做成不可变的可能性不复存在
            final SetNuttionFacts s = new SetNuttionFacts();
            s.setServings(1);
        }
    }


    abstract static class Pizza {
        enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

        ;
        Set<Topping> toppings;

    }

    // 使类成为 Singleton,会使它的害户端测试变得十分困难


    class Elvis {
        public final Elvis INSTANCE = new Elvis();

        public Elvis getINSTANCE() {
            return INSTANCE;
        }

        //  Singl ton 类变成是可序列化 Seri li ab ）
        private Object readResolve() {

            return INSTANCE;
        }

//        static enum  Elviss{
//            INSTANCE;
//            Elviss(){
//
//            }
//        }

    }

    /**
     * 第4条： 通过私有构建起强化不可实例化的能力
     */

    class UtilityClass {

        private UtilityClass() {

        }
    }

    class SpellChcker {

        private final Lexion lexion = null;

        private SpellChcker() {

        }

        public boolean isValid(String word) {
            return false;
        }

        public List<String> suggestions(String word) {
            return Arrays.asList(word);
        }


    }

    class Lexion {

    }
    /**
     * 不要用 ingleton 和静态工具类来实现依赖一个或多个底层资源的类，且该
     * 资源的行为会影响到该类的行为 ；也不要直接用这个类来创建这些资源 而应该将这些资源
     * 或者工厂传给构造器（或者静态工厂，或者构建器），通过它们来创建类
     */

    /**
     * 6避免创建不必要的对象
     */
    public void testNotCreateObject() {
        // bad
        final String a = new String("a");
        // good 个版本只用了一个 String 实例，而不是每次执行的时候都创建一个新的实例
        //且，它可以保证，对于所有在同一台虚拟机中运行的代码，只要它们包含相同的字符串字面
        //常量，该对象就会被重用［
        String b = "a";

    }

    class RomanNumerals {
        private final Pattern ROMAN = Pattern.compile("");

        boolean isRomanNumeral(String s) {
            return ROMAN.matcher(s).matches();
        }

        /**
         * ROMAN  METHOD ISROMANNUMERAL CALL WILL CEATE
         * 如果对象不变，那么显然能够安全重用
         * 考虑适配器(adapter) 也称为 视图
         * 适配器是指这洋一共对象： 把功能委托给一个后背对象 ，从而为后备对象提供一个可以代替的接口
         */

        private long sum() {
            // bad Interger i
            // 优先使用基本类型而不是使用装箱基本类型，当心无意思自动装箱
            for (int i = 0; i < 10; i++) {
                return i;
            }
            return 1 + 2;
        }
    }

    // 7  消除过期的对象引用!
    class Stack {
        // 内存泄露
        private Object[] elements;
        private int size = 0;
        private int DEFAULT_INITAL_CAPACITY = 16;

        public Stack() {
            elements = new Object[DEFAULT_INITAL_CAPACITY];
        }

        public void push(Object o) {
            ensureCapacity();
            elements[size++] = o;
        }

        public Object pop() {
            if (size == 0) {
                throw new EmptyStackException();
            }
            final Object element = elements[--size];
            // 清空对象引用应该是一种例外 而不是一种规范行为
            elements[size] = null;
            return elements[--size];
        }

        private void ensureCapacity() {
            if (elements.length == size) {
                elements = Arrays.copyOf(elements, 2 * size + 1);
            }
        }
        /**
         * 内存泄漏的另一个常见来源是缓存
         * 如果你正好要实现这样的缓存：只要在缓存之外存在对某个项的键的引用，
         * 该项就有意义，那么就可以用 WeakHashMap 代表缓存；当缓存中的项过期之后，它们就
         * 会自动被删除 记住只有当所要的缓存项的生命周期是由该键的外部引用而不是由值决定
         * 时， WeakHashMap 才有用处
         * LinkedHashMap->removeEldestEntry
         * 内存泄漏的第三个常见来源是监昕器和其他回调 确保回调立即被当作垃圾回收的最佳方法是只保存它们的弱引用 weareference ，例如，只将它们保存成 WeakHashMap 中的键

         */
    }

    /**
     * 8条：避免使用终结方法和清除方法
     */

    class Room implements AutoCloseable{

        Cleaner cleaner = Cleaner.create(this, State::new);

         // 嵌的静态 State 保存清除方法清除房间所需的资源
        class State  implements Runnable {

            int numJunkPiles ;
            public State(){
                numJunkPiles = 10;
            }

            @Override
            public void run() {
                System.out.println("Cleaning rooms ");
                numJunkPiles = 0;
            }
        }

        @Override
        public void close() throws Exception {
            cleaner.clean();
        }
    }

    class Audit {
        public void  show(){
            /*try(Room r = new Room()){

            }*/
        }
    }

}
