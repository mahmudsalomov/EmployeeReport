//package uz.java.maniac.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.*;
//
//
//import javax.servlet.http.HttpServletRequest;
//
//@RestController
//@RequestMapping("api/auth")
//@CrossOrigin
//public class AuthController {
////    @Autowired
////    private AuthService authService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//
//
////    @Autowired
////    private UserService userService;
//
//    @PostMapping("/login")
//    public HttpEntity<?> login(@RequestParam(name = "username") String username, @RequestParam String password){
////        System.out.println(request.getHeader("webrtc"));
//        System.out.println(password);
//        System.out.println(username);
//
//
//
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//        Authentication authentication=authenticationManager.authenticate(
//                token
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        Object principal = authentication.getPrincipal();
//
//
//        return ResponseEntity.ok(principal);
//
////        return ResponseEntity.ok(authService.login(username,password));
//    }
////
////    @PostMapping("/oauth/fb")
////    public HttpEntity<?> oauth(@RequestBody FacebookUserDto dto, HttpServletRequest request){
////        System.out.println(request.getHeader("alkash"));
////        return ResponseEntity.ok(facebookUserService.fbLogin(dto,request));
////
//////        return ResponseEntity.ok(authService.login(username,password));
////    }
//
////    @GetMapping("/test")
////    public HttpEntity<?> test(HttpServletRequest request){
////        return ResponseEntity.ok("Salom");
////    }
//
//}
