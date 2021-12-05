package uz.java.maniac.controller.rest;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import uz.java.maniac.component.CurrentUser;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface ControllerInterface<T,K> extends Serializable {


    @PostMapping("/add")
    T add(@RequestBody K k, @CurrentUser UserDetails user);
    @PutMapping("/edit")
    T edit(@RequestBody K k, @CurrentUser UserDetails user);
    @GetMapping("/all")
    T all();
    @GetMapping("/one/{id}")
    T one(@PathVariable Integer id,@CurrentUser UserDetails user);
    @DeleteMapping("/delete/{id}")
    T delete(@PathVariable Integer id, @CurrentUser UserDetails user);
}
