package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Employee> employeeList = new LinkedList<>();
        employeeList.add(new Employee(1,"Öznur", "Şahin"));
        employeeList.add(new Employee(2,"Savaş", "Şahin"));
        employeeList.add(new Employee(3,"Defne", "Şahin"));
        employeeList.add(new Employee(1,"Öznur", "Şahin"));

    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> duplicate = new LinkedList<>();
        Set<Integer> seenId = new HashSet<>();
        Set<Integer> duplicateId = new HashSet<>();


        for(Employee employee: list) {
            if(employee == null) {
                continue;
            }
            if(!seenId.add(employee.getId())) {
                duplicateId.add(employee.getId());
            }
        }
        for(Employee employee: list) {
            if(employee == null) {
                continue;
            }
            if(duplicateId.contains(employee.getId())) {
                if(!duplicate.contains(employee)) {
                    duplicate.add(employee);
                }

            }
        }
        System.out.println(seenId);
        System.out.println("duplicateid" + duplicateId);
        System.out.println(duplicate);
        return duplicate;
    }

    public static Map<Integer,Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> unique = new HashMap<>();


        for(Employee employee: list) {
            if(employee == null) {
                continue;
            }
            unique.put(employee.getId(), employee);
        }
        return unique;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicateList = new LinkedList<>(employees);
        Set<Integer> seenId = new HashSet<>();
        Set<Integer> duplicateId = new HashSet<>();

        for(Employee employee: employees) {
            if(employee == null) {
                continue;
            }
            if(!seenId.add(employee.getId())) {
                duplicateId.add(employee.getId());
            }
        }
        for(Employee employee: employees) {
            if(employee == null) {
                duplicateList.remove(employee);
            }else if(duplicateId.contains(employee.getId())) {
                duplicateList.remove(employee);
            }
        }

        System.out.println(duplicateList);
        return duplicateList;
    }
}