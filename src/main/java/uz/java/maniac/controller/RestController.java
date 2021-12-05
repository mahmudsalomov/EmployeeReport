package uz.java.maniac.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import uz.java.maniac.component.CurrentUser;
import uz.java.maniac.model.dto.FieldDto;
import uz.java.maniac.model.dto.TaskDto;
import uz.java.maniac.model.template.FormData;
import uz.java.maniac.service.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin
@RequestMapping("api")
public class RestController {

    private final TaskService taskService;
    private final FieldService fieldService;
    private final DocumentService documentService;
    private final DocumentFieldService documentFieldService;
    private final UserService userService;

    public RestController(TaskService taskService, FieldService fieldService, DocumentService documentService, DocumentFieldService documentFieldService, UserService userService) {
        this.taskService = taskService;
        this.fieldService = fieldService;
        this.documentService = documentService;
        this.documentFieldService = documentFieldService;
        this.userService = userService;
    }

    @GetMapping("/test")
    public HttpEntity<?> test(@CurrentUser UserDetails user){
        System.out.println(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/form")
    public HttpEntity<?> form(@RequestBody MultiValueMap<Integer, String> formData){
        System.out.println(formData);
        return ResponseEntity.ok("ok");
    }

    @PostMapping("/form2")
    public HttpEntity<?> form2(@RequestBody List<FormData> formData){
        System.out.println(formData);
        return ResponseEntity.ok("ok");
    }


    //Task

//    @PostMapping("add/task")
//    public HttpEntity<?> add(@RequestBody TaskDto dto){
//
//        return ResponseEntity.ok("");
//    }
//
//    @PutMapping("edit/task")
//    public HttpEntity<?> edit(@RequestBody TaskDto dto){
//
//        return ResponseEntity.ok("");
//    }
//
//    @GetMapping("all/task")
//    public HttpEntity<?> all(){
//        return ResponseEntity.ok(taskService.all());
//    }
//
//    @GetMapping("one/task/{id}")
//    public HttpEntity<?> one(@PathVariable Integer id){
//        return ResponseEntity.ok(taskService.one(id));
//    }







}
