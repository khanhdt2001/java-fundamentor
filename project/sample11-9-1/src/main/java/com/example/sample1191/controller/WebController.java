package com.example.sample1191.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sample1191.Todo;

import org.springframework.ui.Model;

@Controller
@RequestMapping("api/v1")
public class WebController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/hello")
    public String hello(
        @RequestParam(name = "name", required = false, defaultValue = "") String name,
        Model model
    ) {
        model.addAttribute("name", name);
        return "hello";
    }

    List<Todo> todoList = new CopyOnWriteArrayList<>();


    @RequestMapping(value = "/addTodo", method = RequestMethod.GET)
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }

    @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
    public String addTodo(@ModelAttribute Todo todo) {
        return "success";
    }
    @GetMapping("/listTodo")
    public String index(Model model, @RequestParam(value = "limit", required = false) Integer limit) {
        model.addAttribute("todoList", limit != null ? todoList.subList(0, limit): todoList);
        return "listTodo";
    }
}
