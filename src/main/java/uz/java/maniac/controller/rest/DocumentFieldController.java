package uz.java.maniac.controller.rest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import uz.java.maniac.component.CurrentUser;
import uz.java.maniac.model.DocumentField;
import uz.java.maniac.model.dto.DocumentFieldDto;
import uz.java.maniac.model.template.FormData;
import uz.java.maniac.service.DocumentFieldService;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/df")
public class DocumentFieldController implements ControllerInterface<HttpEntity<?>, DocumentFieldDto> {

    private final DocumentFieldService documentFieldService;

    public DocumentFieldController(DocumentFieldService documentFieldService) {
        this.documentFieldService = documentFieldService;
    }

    @Override
    public HttpEntity<?> add(DocumentFieldDto documentFieldDto, @CurrentUser UserDetails user) {
        return null;
    }

    @Override
    public HttpEntity<?> edit(DocumentFieldDto documentFieldDto, @CurrentUser UserDetails user) {
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
    public HttpEntity<?> delete(Integer id, @CurrentUser UserDetails user) {
        return ResponseEntity.ok(documentFieldService.delete(id,user));
    }

    @GetMapping("/one/spec/{taskNumber}")
    public HttpEntity<?> oneSpec(@PathVariable Integer taskNumber, @CurrentUser UserDetails user){
        return ResponseEntity.ok(documentFieldService.oneSpec(taskNumber,user));
    }

    @PostMapping("/add/special/{date}")
    public HttpEntity<?> addSpecial(@CurrentUser UserDetails user, @RequestBody List<FormData> formData, @PathVariable Date date){
        System.out.println(formData);
        return ResponseEntity.ok(documentFieldService.addSpecial(user,formData,date));
    }

    @PostMapping("/edit/special/{date}")
    public HttpEntity<?> editSpecial(@CurrentUser UserDetails user, @RequestBody List<FormData> formData, @PathVariable Date date){
        System.out.println("EDIT");
        System.out.println(formData);
        formData.forEach(d->{
            System.out.println(d.toString());
        });
        return ResponseEntity.ok(documentFieldService.editSpecial(user,formData,date));
//        return ResponseEntity.ok("ok");
    }

    @GetMapping("/all/user/{date}")
    public HttpEntity<?> allDocumentField(@CurrentUser UserDetails user,@PathVariable Date date){
        List<DocumentFieldDto> fields = documentFieldService.allByUserAndReportDate(user, date);
        System.out.println(fields);
        return ResponseEntity.ok(fields);
    }
    @GetMapping("/all/user/spec/{date}")
    public HttpEntity<?> allDocumentFieldSpec(@CurrentUser UserDetails user,@PathVariable Date date){
        List<List<DocumentFieldDto>> fields = documentFieldService.allByUserAndReportDateSpec(user, date);
        System.out.println(fields);
        return ResponseEntity.ok(fields);
    }
}
