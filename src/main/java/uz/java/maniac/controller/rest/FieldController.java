package uz.java.maniac.controller.rest;

import lombok.Getter;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import uz.java.maniac.component.CurrentUser;
import uz.java.maniac.model.dto.FieldDto;
import uz.java.maniac.service.FieldService;

@RestController
@CrossOrigin
@RequestMapping("api/field")
public class FieldController implements ControllerInterface<HttpEntity<?>, FieldDto> {
    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @Override
    public HttpEntity<?> add(FieldDto fieldDto, UserDetails user) {
        return ResponseEntity.ok(fieldService.add(fieldDto,user));
    }

    @Override
    public HttpEntity<?> edit(FieldDto fieldDto, UserDetails user) {
        return null;
    }

    @Override
    public HttpEntity<?> all() {
        return null;
    }

    @Override
    public HttpEntity<?> one(Integer id, UserDetails user) {
        return null;
    }

    @Override
    public HttpEntity<?> delete(Integer id, UserDetails user) {
        return null;
    }

    @GetMapping("/all/{task_id}")
    public HttpEntity<?> allByTaskId(@PathVariable Integer task_id){
        return ResponseEntity.ok(fieldService.allByTaskId(task_id));
    }


}
