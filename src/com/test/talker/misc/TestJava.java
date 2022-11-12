package com.test.talker.misc;

import java.util.*;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestJava {

    public static void main(String[] args) {
        someMethod(null);

        String multilineString = "Baeldung helps \n \n developers \n explore Java.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
        System.out.println("lines;" + lines);

        List<String> sampleList = Arrays.asList("Java", "Kotlin", "JaVa", "JaVas");
        Set resultString = sampleList.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toSet());

        System.out.println("resultString;" + resultString);


    }
    public static void someMethod(Object o) {
        System.out.println("Object method Invoked");
    }
    public static void someMethod(String s) {
        System.out.println("String method Invoked");
    }

    @Test
    public void testPredicate(){
        List<String> names = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> nameStartsWithS = str -> str.startsWith("S");
        names.stream().filter(nameStartsWithS).forEach(System.out::println);
    }

    @Test
    public void supplier(){
        Supplier<Double> doubleSupplier1 = () -> Math.random();
        DoubleSupplier doubleSupplier2 = Math::random;

        System.out.println(doubleSupplier1.get());
        System.out.println(doubleSupplier2.getAsDouble());
    }

    @Test
    public void testFunctions(){
        List<String> names = Arrays.asList("Smith", "Gourav", "Heather", "John", "Catania");
        Function<String, Integer> nameMappingFunction = String::length;
        System.out.println(nameMappingFunction.apply("A very long string..."));
        List<Integer> nameLength = names.stream().map(nameMappingFunction).collect(Collectors.toList());
        System.out.println(nameLength);
    }

    @Test
    public void testIterator(){
        Map<String, String> cityCode = new HashMap<String, String>();
        cityCode.put("Delhi", "India");
        cityCode.put("Moscow", "Russia");
        cityCode.put("New York", "USA");

        for (String s : cityCode.keySet()) {
            System.out.println(cityCode.get(s));

            // adding an element to Map
            // exception will be thrown on next call
            // of next() method.
            cityCode.put("Istanbul", "Turkey");
        }
    }

    @Test
    public void runFilter() {

        List<String> notes = new ArrayList<>();
        notes.add("note1");
        notes.add("note2");
        notes.add("note3");
        notes.add("note4");
        notes.add("note5");

        //Using Stream and filter
        //Output : note2
        notes.stream()
                .filter(s->s.contains("5"))
                .forEach(System.out::println);

        //Using method reference
        //Output : note1,note2,note3,note4,note5
        //notes.forEach(System.out::println);
    }

    @Test
    public void isEmpty() {

        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "aa", 11));
        noteLst.add(new Notes(3, "cc", 33));
        noteLst.add(new Notes(4, "bb", 44));
        noteLst.add(new Notes(2, "dd", 34));
        noteLst.add(new Notes(5, "zz", 32));

        noteLst = new ArrayList<>();

        Optional.ofNullable(noteLst)
                .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
                .stream().filter(Objects::nonNull) //loop throgh each object and consider non null objects
                .map(Notes::getTagName) // method reference, consider only tag name
                .forEach(System.out::println); // it will print tag names
    }

    @Test
    public void sort() {
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "aa", 11));
        noteLst.add(new Notes(3, "cc", 33));
        noteLst.add(new Notes(4, "bb", 44));
        noteLst.add(new Notes(2, "dd", 34));
        noteLst.add(new Notes(5, "zz", 32));

        // java 8 sort according to id 1,2,3,4,5
        noteLst.sort((n1, n2)->n1.getId()-n2.getId());

        //java 8 print the notes using lamda
        noteLst.forEach(System.out::println);
    }

    @Test
    public void mapToObjects() {
        List<String> names = Arrays.asList("aa", "bb", "cc", "dd");

        List<String> nameLst = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(nameLst); //output- [AA, BB, CC, DD]
    }

    @Test
    public void createMapToObjects() {

        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));

        noteLst.add(new Notes(6, "note4", 66));

        //use third mergeFunction argument (oldValue, newValue) -> oldValue solved the duplicated key issue by considering old value
        Map<String, Long> notesRecords = noteLst.stream().collect(
                Collectors.toMap(Notes::getTagName, Notes::getCount,
                        //(oldValue, newValue) -> oldValue // This will save note4=44
                        (oldValue, newValue) -> newValue // This will save note4=66
                )
        );

        System.out.println("Notes : " + notesRecords);

    }

    @Test
    public void createMapToObjectsSorted() {

        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));

        noteLst.add(new Notes(6, "note4", 66));


        Map<String, Long> notesRecords = noteLst.stream()
                .sorted(Comparator.comparingLong(Notes::getId)) // sorting is based on TagId 55,44,33,22,11
                .collect(
                        Collectors.toMap(Notes::getTagName, Notes::getCount,
                                (oldValue, newValue) -> oldValue, // consider old value 44 for dupilcate key
                                LinkedHashMap::new           // it keeps order
                        )
                );

        System.out.println("Notes : " + notesRecords);

    }

    @Test
    public void createInttoIntegerList() {

        int[] nums = {1, 12, 390, 47, 2795, -6, -207};

        //using Arrays.stream() sequential stream with boxed
        List<Integer> numsLst = Arrays.stream(nums).boxed().collect(Collectors.toList());

        //OR
        //By using IntStream.boxed(), convert each element of the stream to an Integer ().
        List<Integer> numsLstInt = IntStream.of(nums).boxed().collect(Collectors.toList());

        numsLstInt.forEach(System.out::println);

        List<Integer> sortedNumArr = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder())
                //.mapToInt(Integer::intValue)
                .collect(Collectors.toList());


        sortedNumArr.forEach(System.out::println);;
    }


    @Test
    public void sortIntArray() {

        int[] numArr = {1, 12, 390, 47, 2795, -6, -207};

        int[] sortedNumArr = Arrays.stream(numArr).boxed()
                //.sorted(Collections.reverseOrder())
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println("sortedNumArr : " + Arrays.toString(sortedNumArr));

    }

    @Test
    public void concatenateArray() {

        List<String> str = Arrays.asList("Welcome", "to", "TechGeekNext");

        String jonStr = str.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" - "));

        System.out.println(jonStr);

    }

    @Test
    public void getCountsInList() {
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC", "CC", "AA", "FF", "CC");
        Map<String,Long> namesCount = names
                .stream()
                //.filter(x->Collections.frequency(names, x)>0)
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));
        System.out.println(namesCount);
    }

    @Test
    public void countOfEachWordInList() {

        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> namesCount = names
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity()
                                , Collectors.counting()
                        ));
        System.out.println(namesCount);

    }

    @Test
    public void findDuplicatesInList() {

        List<String> names = Arrays.asList("AA", "BB", "AA", "CC", "DD", "EE");
        Map<String,Long> namesCount = names
                .stream()
                .filter(x->Collections.frequency(names, x)>1)
                .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));
        System.out.println(namesCount);

    }


}




class Notes {

    private int Id;
    private String tagName;
    private long count;

    public Notes(int inputId, String inputName, long inputCount) {
        this.Id = inputId;
        this.tagName = inputName;
        this.count = inputCount;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "Id=" + Id +
                ", tagName='" + tagName + '\'' +
                ", count=" + count +
                '}';
    }
}