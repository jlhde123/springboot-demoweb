package com.jlh.demoworkweb;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: jiluohao
 * Date: 2019-01-31 15:48
 * Description:
 */
public class TestMain {


    public static void main(String[] args) {


        //函数表达式
//        section1();
//        section2();
//        section3();
//        section4();


        //时间处理对象

//        section5();
    }


    public static void section1(){



        //      1、 流 过滤，与去重,排序



        Stream.of(1,2,3).distinct().collect(Collectors.toList());
        Stream.concat(Stream.of(1),Stream.of(1,2,3)).distinct().collect(Collectors.toList());

        List<Long> arrs = Arrays.asList(3L,2L,9L,5L,1L,3L,2L,null);

        arrs.parallelStream().forEach(System.out::println);

        List<Long> out = arrs.stream().filter(m->m!=null).distinct().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());


//        List<Long> out = new ArrayList<>();
//        for (Long arr :arrs){
//            if (arr!=null && out.indexOf(arr)>=0){
//                out.add(arr);
//            }
//        }
//        Collections.sort(out);

        System.out.println(out);


        //流中引用变量必定是final的 如果变量会改变则通过指针的形式 类似数组 或者 对象
        Long testNumber = 3L;
        arrs.stream().filter(m-> m.equals(testNumber));

        Long[] testNumbers = new Long[]{1L};
        testNumbers[0]=2L;
        arrs.stream().filter(m->m.equals(testNumbers[0]));



    }

    public static void section2(){
        // 2、collect 与 map、peek

        List<Person> personList = Arrays.asList(new Person(1L,"jlh"),new Person(2L,"jlh2"));


        personList.stream().collect(Collectors.toList());
        personList.stream().collect(Collectors.toSet());
        Map<Long, Person> collect = personList.stream().collect(Collectors.toMap(m -> m.id, m -> m));


        //分组归类
        personList = Arrays.asList(new Person(1L,"jlh"),new Person(2L,"jlh2"),new Person(1L,"jlh3"));
        Map<Long, List<Person>> collect2 = personList.stream().collect(Collectors.groupingBy(m -> m.id));

        //map 改变流传递的对象
        List<Person> collect1 = Stream.of(1L, 2L).map(collect::get).peek(m->{
            m.name = m.name+"asd";
        }).collect(Collectors.toList());



        //flatMap 继续平铺流对象


        List<Person> collect3 = collect2.entrySet().stream().flatMap(m -> {
            return m.getValue().stream();
        }).collect(Collectors.toList());


        //join 方法

        System.out.println(personList.stream().map(m->m.name).collect(Collectors.joining(",")));



    }

    public static void section3(){

        //一些骚操作

        List<Long> arr = Arrays.asList(1L,2L,3L,4L);

        // option 与 max等
        Optional<Long> max = arr.stream().max(Long::compare);
        if (max.isPresent()) {
            System.out.println(max.get());
        }
        System.out.println(max.orElse(1L));

        arr.stream().skip(1).limit(3).count();
        Optional<Long> reduce = arr.stream().reduce((total, a) -> total += a);
        System.out.println("reduce:"+reduce.get());




        //截取其中一个 或者 查找是否含有
        arr.stream().filter(m->m == 1L).findFirst();
        arr.stream().findAny();

        arr.stream().anyMatch(m->m==1);
        arr.stream().allMatch(m->m==1);
        arr.stream().noneMatch(m->m==1);
        arr.stream().anyMatch(m->m==1L);


        // list 转数组

        Long[] longs = arr.stream().toArray(Long[]::new);

    }


    public static void section4(){

        //自定义函数表达式

        CallBack callBack = ()-> "123";
        callBack.doIt();


        //以往的接口实现通过lambda

        Runnable a = ()->{
            System.out.println(123);
        };

        new Thread(()->{
            System.out.println("thread start");
        },"thread1").start();


        // 函数式编程 例子~ redis 不存在则执行 以及锁
        RedisManage.putIfNull("key1",()->"value1");
        RedisManage.requireLock("lock1",()->{
            System.out.println("do something");
            return "ok";
        });
        // 数据库事务
        TransationUtils.exec(()->{
            // xxxDao.update(object);
            return "";
        });



    }



    public static void section5(){

        // LocalDateTime = LocalDate + LocalTime;
        LocalTime.now();
        LocalDate.now();
        LocalDateTime.now();
        LocalDateTime.of(LocalDate.now(),LocalTime.now());

        //带时区的 localDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime gmt = ZonedDateTime.now(ZoneId.ofOffset("GMT", ZoneOffset.ofHours(10)));


        //时间戳 与 localDateTime的互换
        LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()),ZoneId.systemDefault());
        LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();

        // 时间计算的常规操作

        LocalDateTime.now().plusDays(1);
        LocalDateTime.now().plusHours(1);
        LocalDateTime.now().minusDays(1);
        //....
        LocalDateTime.now().plus(1,ChronoUnit.DAYS);

        LocalDateTime.now().isAfter(LocalDateTime.now());
        LocalDateTime.now().isBefore(LocalDateTime.now());
        LocalDateTime.now().isEqual(LocalDateTime.now());


        //计算a 时间与 b时间差多少

        long until = LocalDateTime.now().minusDays(1).minusMonths(1).until(LocalDateTime.now(), ChronoUnit.HOURS);
        System.out.println(until);


        //格式化

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

        //Period 与 Duration

        System.out.println(Period.between(LocalDate.now().minusMonths(1),LocalDate.now()).getDays());
        System.out.println(Duration.between(LocalDateTime.now().minusMonths(1),LocalDateTime.now()).toDays());

        //循环日期

        for (LocalDateTime st = LocalDateTime.now() ; st.isBefore(LocalDateTime.now().plusDays(10));st = st.plusDays(1)){
            System.out.println(st);
        }



    }




    @FunctionalInterface
    public static interface CallBack<T>{

        T doIt();
    }


    public static class RedisManage{


         static <T> T putIfNull(String key,CallBack<T> callBack){

            // t = redis.get(key)
            // t != null;

            T t =callBack.doIt();
            // redis.put(key,t);
            return t;
        }

        static <T> T requireLock(String lockKey,CallBack<T> callBack){


             // 分布式锁实现

            return callBack.doIt();
        }

    }

    public static class TransationUtils{


        static <T> T exec(CallBack<T> callBack){

            return callBack.doIt();
        }

    }


    public static class Person{
        public Long id;
        public String name;

        public Person(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(id, person.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

}
