package uz.java.maniac.controller.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.java.maniac.component.CurrentUser;
import uz.java.maniac.model.Document;
import uz.java.maniac.model.dto.DocumentDto;
import uz.java.maniac.service.DocumentService;

@RestController
@CrossOrigin
@RequestMapping("api/document")
public class DocumentController implements ControllerInterface<HttpEntity<?>, DocumentDto> {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @Override
    public HttpEntity<?> add(DocumentDto dto, UserDetails user) {
        Document document = documentService.add(dto, user);
        return ResponseEntity.ok(document);
//        return null;
    }

    @Override
    public HttpEntity<?> edit(DocumentDto documentDto, UserDetails user) {
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
}
