package uz.java.maniac.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import uz.java.maniac.model.Document;
import uz.java.maniac.model.User;
import uz.java.maniac.model.dto.DocumentDto;
import uz.java.maniac.repository.DocumentRepository;
import uz.java.maniac.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService implements ServiceInterface<Document, DocumentDto>{

    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;

    public DocumentService(DocumentRepository documentRepository, UserRepository userRepository) {
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Document add(DocumentDto documentDto, UserDetails user) {
        try {
            Optional<User> byName = userRepository.findByName(user.getUsername());
            if (byName.isPresent()&&!documentRepository.existsByUserIdAndReportDate(byName.get().getId(),documentDto.reportDate)) {
                documentDto.userId=byName.get().getId();
                documentDto.editPermission=true;
                return documentRepository.save(documentDto.toEntity());
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Document edit(DocumentDto documentDto, UserDetails user) {
        return null;
    }

    @Override
    public List<Document> all() {
        return documentRepository.findAll();
    }

    @Override
    public Document one(Integer id) {
        return documentRepository.findByIdAndDeletedFalse(id).orElse(null);
    }

    @Override
    public boolean delete(Integer id, UserDetails user) {
        try {
            documentRepository.findById(id).ifPresent(document -> {
                document.setDeleted(true);
                documentRepository.save(document);
            });
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Document oneByUserIdAndReportDate(Integer id, Date reportDate){
        Optional<Document> document = documentRepository.findByUserIdAndReportDate(id, reportDate);
        return document.map(this::blocker).orElse(null);
    }

    public Document oneByUserDetailsAndReportDate(UserDetails userDetails,Date reportDate){
        Optional<User> user = userRepository.findByNameAndPass(userDetails.getUsername(), userDetails.getPassword());
        Optional<Document> document= Optional.empty();
        if (user.isPresent()){
            document = documentRepository.findByUserIdAndReportDate(user.get().getId(), reportDate);
        }
        return document.map(this::blocker).orElse(null);
    }

    protected Document blocker(Document document){
        try {
            if (document.isEditPermission()&&new Date().getTime()-document.getReportDate().getTime()>86400000){
                document.setEditPermission(false);
                return documentRepository.save(document);
            }
            return document;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
