package com.korit.springboot.controller;

// 요청 URL : /api/age 응답 데이터 : { name : 김준일, age: 32 }
// 요청 URL : /api/names 응답 데이터 : { "김준일", "김준이", "김준삼" }
// 요청 URL : /api/students 응답 데이터 : [{name: 김준일, age: 32}. {name: 김준이, age: 33}]
// 요청 URL : /api/students2 응답 데이터 :
/*
    [
        {
            name: 김준일,
            age: 32
            hobby: [축구, 농구]
        },
        {
            name: 김준일,
            age: 32
            hobby: [축구, 농구]
        }
    ]
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/")
public class HttpStudyController2 {
//    @GetMapping("/age")
//    public String getAge() {
//        return ("name : 이진혁, " + " age: 28");
//    }
    @GetMapping("/age")
    public Map<String, Object> getAge(){
        return Map.of("name", "김준일", "age", 32);
    }
    /*
    Map<String, Object> map2 = map.of("name","김준일","age",32);
    map2.put("address","동래구")
    -> 이 경우 불변 map이기 때문에 put된 입력값들 추가 안됨 
     */

    @GetMapping("/names")
    public List<String> getNames() {
        return List.of("김준일", "김준이", "김준삼");
    }
    /*
    @GetMapping("/api/names")
    public String[] names() {
        String[] names = {"김준일", "김준이", "김준삼"};
        return names;
    -> 이것도 가능
     */

    @GetMapping("/students")
    public List<Map<String, Object>> getStudents() {
//        Map<String, Object> info1 = new HashMap<>();
//        info1.put("name", "김준일");
//        info1.put("age", 32);
//        Map<String, Object> info2 = new HashMap<>();
//        info2.put("name", "김준이");
//        info2.put("age", 33);
//
//        return List.of(info1, info2);

//        List<Map<String, Object>> list = new ArrayList<>();
//        Map<String, Object> map1 = new HashMap<>();
//        map1.put("name", "김준일");
//        map1.put("age", 32);
//
//        Map<String, Object> map2 = new HashMap<>();
//        map2.put("name", "김준이");
//        map2.put("age", 33);
//
//        list.add(map1);
//        list.add(map2);
//
//        List<Map<String, Object>> list2 = List.of(map1, map2);

        return List.of(
                Map.of("name","김준일","age","32"),
                Map.of("name","김준이","age","33")
        );
    }

    @GetMapping("/students2")
    public List<Map<String, Object>> getStudents2() {
        Map<String, Object> info1 = new HashMap<>();
        info1.put("name", "김준일");
        info1.put("age", 32);
        info1.put("hobby", List.of("축구", "농구"));
        Map<String, Object> info2 = new HashMap<>();
        info2.put("name", "김준이");
        info2.put("age", 33);
        info2.put("hobby", List.of("골프", "낚시"));

        return List.of(info1, info2);
    }
}
