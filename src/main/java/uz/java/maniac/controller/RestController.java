package uz.java.maniac.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import uz.java.maniac.component.CurrentUser;
import uz.java.maniac.model.User;
import uz.java.maniac.model.template.FormData;
import uz.java.maniac.repository.UserRepository;
import uz.java.maniac.service.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin
@RequestMapping("api")
public class RestController {

    private final TaskService taskService;
    private final FieldService fieldService;
    private final DocumentService documentService;
    private final DocumentFieldService documentFieldService;
    private final UserService userService;
    private final UserRepository userRepository;

    public RestController(TaskService taskService, FieldService fieldService, DocumentService documentService, DocumentFieldService documentFieldService, UserService userService, UserRepository userRepository) {
        this.taskService = taskService;
        this.fieldService = fieldService;
        this.documentService = documentService;
        this.documentFieldService = documentFieldService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/test")
    public HttpEntity<?> test(@CurrentUser UserDetails user){
        System.out.println(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/me")
    public HttpEntity<?> me(@CurrentUser UserDetails user){
        if (user==null) return ResponseEntity.ok("Unknown");
        Optional<User> optionalUser = userRepository.findByNameAndPass(user.getUsername(), user.getPassword());
        if (optionalUser.isEmpty()) return ResponseEntity.ok("Unknown");
        return ResponseEntity.ok(optionalUser.get().getFullName());
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

    @GetMapping("/check_date/{date}")
    public HttpEntity<?> checkDate(@PathVariable Date date){
        if (date.after(new Date())) return ResponseEntity.ok(false);
        return ResponseEntity.ok(true);
    }









}
