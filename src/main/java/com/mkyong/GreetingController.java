package com.mkyong;

import com.beans.Employee;
import com.beans.Greeting;
import com.beans.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public List<Greeting> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        List<Greeting> list = new ArrayList<>();
        list.add(new Greeting(counter.incrementAndGet(),String.format(template, name)));
        list.add(new Greeting(counter.incrementAndGet(), String.format(template, name +" blabla")));
        list.add(new Greeting(counter.incrementAndGet(), String.format(template, name +" bloblo")));
        return list;
    }

    @RequestMapping("/user")
    public ResponseEntity<Map<String, List<User>>> users(){
        Map<String, List<User>> map = new HashMap<>();
        List<User> users = new ArrayList<>();
        users.add(new User("nxhuy", "123"));
        users.add(new User("pqhnam", "456"));
        users.add(new User("hclap", "789"));

        map.put("progress", users);

        users = new ArrayList<>();
        users.add(new User("messi", "123"));
        users.add(new User("ronaldo", "456"));
        users.add(new User("neymar", "789"));
        map.put("history", users);

        users = new ArrayList<>();
        users.add(new User("zeus", "123"));
        users.add(new User("hades", "456"));
        users.add(new User("poseidon", "789"));
        map.put("future", users);

        return new ResponseEntity<>(map, HttpStatus.FOUND);
    }

    @RequestMapping("/login")
    public List<User> login(){
        List<User> list = new ArrayList<>();
        list.add(new User("nxhuy", "123"));
        list.add(new User("pqhnam", "456"));
        list.add(new User("hclap", "789"));
        return list;
    }

    @RequestMapping("/employee")
    public Employee employee(){
        Employee employee = new Employee(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
        return employee;
    }

    @RequestMapping(value = "/send", method = RequestMethod.PUT)
    public String receiveData(@RequestBody String string){
        System.out.println(string);
        return "Receive Data: " + string;
    }
}
