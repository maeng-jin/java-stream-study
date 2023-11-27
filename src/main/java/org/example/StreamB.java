package org.example;

import org.example.model.Employee;
import org.example.model.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamB {
    public static void main(String[] args) {
        // Integer 형식의 리스트 생성
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 스트림을 이용하여 짝수만 필터링하여 새로운 리스트 생성
        List<Integer> evenNumbers = numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        // 결과 출력
        System.out.println("Original List: " + numbers);
        System.out.println("Even Numbers List: " + evenNumbers);
        System.out.println();


        // 문자열 리스트 생성
        List<String> words = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");

        // 스트림을 이용하여 길이가 5보다 큰 문자열만 필터링하여 새로운 리스트 생성
        List<String> longWords = words.stream()
                .filter(word -> word.length() > 5)
                .collect(Collectors.toList());

        // 결과 출력
        System.out.println("Original List: " + words);
        System.out.println("Words with Length > 5: " + longWords);
        System.out.println();


        // 숫자 리스트 생성
        List<Integer> numbers2 = Arrays.asList(10, 25, 8, 30, 15, 18, 40, 12);

        // 특정 범위 내에 있는 숫자만 필터링하여 새로운 리스트 생성
        int lowerBound = 10;
        int upperBound = 30;

        List<Integer> filteredNumbers = numbers2.stream()
                .filter(num -> num >= lowerBound && num <= upperBound)
                .collect(Collectors.toList());

        // 결과 출력
        System.out.println("Original List: " + numbers2);
        System.out.println("Filtered Numbers between " + lowerBound + " and " + upperBound + ": " + filteredNumbers);
        System.out.println();


        // Person 객체를 포함하는 리스트 생성
        List<Person> people = Arrays.asList(
                new Person("Alice", 28),
                new Person("Bob", 30),
                new Person("Charlie", 25),
                new Person("David", 35)
        );

        // 특정 조건을 충족하는 Person 객체 필터링
        int ageThreshold = 30;

        List<Person> filteredPeople = people.stream()
                .filter(person -> person.getAge() >= ageThreshold)
                .collect(Collectors.toList());

        // 결과 출력
        System.out.println("Original List: " + people);
        System.out.println("People older than " + ageThreshold + ": " + filteredPeople);
        System.out.println();


        // Person 객체를 포함하는 리스트 생성
        List<Person> people2 = Arrays.asList(
                new Person("Alice", 28, 3000L),
                new Person("Bob", 30, 5000L),
                new Person("Charlie", 25, 230L),
                new Person("David", 35, 2500L),
                new Person("Ella", 30, 3000L)
        );

        // 나이가 30세 이상인 사람들을 필터링하여 나이별로 그룹화하고, 각 그룹의 평균 나이 계산
        Map<Integer, Double> averageAgeByAgeGroup = people2.stream()
                .filter(person -> person.getAge() >= 30)
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.averagingDouble(Person::getMoney)
                ));

        // 결과 출력
        System.out.println("People aged 30 or older grouped by age with average money:");
        averageAgeByAgeGroup.forEach((age, averageMoney) ->
                System.out.println("Age: " + age + ", Average Money: " + averageMoney));
        System.out.println();


        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 28, "Engineering"),
                new Employee("Bob", 30, "Sales"),
                new Employee("Charlie", 25, "Engineering"),
                new Employee("David", 35, "Sales"),
                new Employee("Ella", 30, "Engineering")
        );


        // Engineering 부서의 직원 중 30세 이상인 사람들의 이름을 정렬하여 출력
        List<String> engineeringEmployeesAbove30Sorted = employees.stream()
                .filter(employee -> "Engineering".equals(employee.getDepartment()))
                .filter(employee -> employee.getAge() >= 30)
                .map(Employee::getName)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Engineering Department Employees above 30 (sorted by name):");
        engineeringEmployeesAbove30Sorted.forEach(System.out::println);


        // 모든 직원들을 부서별로 그룹화하여 출력
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\nEmployees grouped by department:");
        employeesByDepartment.forEach((department, empList) -> {
            System.out.println(department + ": ");
            empList.forEach(System.out::println);
        });

        // Sales 부서 직원들의 이름을 쉼표로 연결하여 출력
        String salesEmployeesNames = employees.stream()
                .filter(employee -> employee.getDepartment().equals("Sales"))
                .map(Employee::getName)
                .collect(Collectors.joining(", "));

        System.out.println("\nNames of Employees in Sales Department: " + salesEmployeesNames);
        System.out.println();

        Map<String, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        Collection<List<Employee>> values = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .values();

        Stream<List<Employee>> stream = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .values()
                .stream();

        // 부서별로 Employee를 List로 가진 List 생성
        List<List<Employee>> employeesByDepartmentList = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .values()
                .stream()
                .collect(Collectors.toList());

        // 결과 출력
        System.out.println("Employees grouped by department as List of Lists:");
        employeesByDepartmentList.forEach(System.out::println);
    }
}
