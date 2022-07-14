package com.draznin.ocp.chapter4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        Supplier<Human> humanSupplier = Human::new;
        Supplier<Integer> integerSupplier = Human::getAge;

        Consumer<String> stringConsumer = Human::sayWord;
        Human human = new Human();
        BiConsumer<String, String> humanConsumer = human::setName;

        Predicate<Human> humanPredicate = Human::isMan;
        BiPredicate<Integer, Human> humanBiPredicate = (i, h) -> h.isOlderThan(i);

        Function<Human, Integer> humanIntegerFunction = Human::getHeight;
        BiFunction<Human, String, Human> humanStringHumanBiFunction = Human::addPrefix;

        UnaryOperator<Human> humanUnaryOperator = Human::doNothing;
        BinaryOperator<Human> humanBinaryOperator = Human::doNothingWith;

        Optional<Human> humanOptional = Optional.of(new Human());
        boolean isEmpty = humanOptional.isEmpty(); // false'
        boolean isPresent = humanOptional.isPresent(); // true

        humanOptional.orElse(new Human());
        humanOptional.orElseGet(Human::new);
        humanOptional.orElseThrow(RuntimeException::new);

        //Streams
        Stream<Human> humanStream = Stream.of(new Human(), new Human());
        Stream<Human> humanStream1 = Arrays.asList(new Human(), new Human()).stream();
        Stream<Human> humanStream2 = Stream.empty();

        Stream<Double> generateStream = Stream.generate(Math::random);
        Stream<String> iterateStream = Stream.iterate("Start", String::toUpperCase);

        Stream<Long> testStream = Stream.iterate(0L, s -> s<100L, s -> s + Math.round(Math.random())*10);
        System.out.println(testStream.count());
        Stream<Long> testStream2 = Stream.iterate(0L, s -> s<100L, s -> s + Math.round(Math.random())*10);
        System.out.println(testStream2.max((i1, i2) -> (int) (i1 - i2)));
        Stream<Long> testStream3 = Stream.iterate(0L, s -> s<100L, s -> s + Math.round(Math.random())*10);
        System.out.println(testStream3.reduce(0L, Long::sum));

         Set<String> stringSet = Stream
                .of(new Human("John", 50), new Human("Jim", 20), new Human("Frank", 57),
                        new Human("Brad", 11))
                .filter(h -> h.getName().startsWith("J"))
                .limit(1)
                .map(Human::getName)
                .collect(Collectors.toSet());

        System.out.println(stringSet);

        System.out.println(Stream.of(new Human("John", 50), new Human("Jim", 20), new Human("Frank", 57),
                new Human("Brad", 11)).flatMap(h -> h.getHobby().stream()).collect(Collectors.toList()));
        System.out.println(Stream.of(new Human("John", 50), new Human("Jim", 20), new Human("Frank", 57),
                new Human("Brad", 11)).flatMap(h -> Stream.of(h.getName())).collect(Collectors.toSet()));
        System.out.println(Stream.of(new Human("John", 50), new Human("Jim", 20), new Human("Frank", 57),
                new Human("Brad", 50)).collect(Collectors.groupingBy(Human::getRealAge)));
        System.out.println(Stream.of(new Human("John", 50), new Human("Jim", 20), new Human("Frank", 57),
                new Human("Brad", 11)).collect(Collectors.partitioningBy(h -> h.getName().startsWith("J"))));


    }
}
