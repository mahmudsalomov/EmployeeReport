package uz.java.maniac.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import uz.java.maniac.model.Document;
import uz.java.maniac.model.DocumentField;
import uz.java.maniac.model.Field;
import uz.java.maniac.model.User;
import uz.java.maniac.model.dto.DocumentFieldDto;
import uz.java.maniac.model.template.FormData;
import uz.java.maniac.repository.DocumentFieldRepository;
import uz.java.maniac.repository.DocumentRepository;
import uz.java.maniac.repository.FieldRepository;
import uz.java.maniac.repository.UserRepository;

import java.util.*;

@Service
public class DocumentFieldService implements ServiceInterface<DocumentField, DocumentFieldDto> {
    private final DocumentFieldRepository documentFieldRepository;
    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;
    private final FieldRepository fieldRepository;

    public DocumentFieldService(DocumentFieldRepository documentFieldRepository, DocumentRepository documentRepository, UserRepository userRepository, FieldRepository fieldRepository) {
        this.documentFieldRepository = documentFieldRepository;
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
        this.fieldRepository = fieldRepository;
    }

    @Override
    public DocumentField add(DocumentFieldDto dto, UserDetails user) {
        try {

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public DocumentField edit(DocumentFieldDto documentFieldDto, UserDetails user) {
        return null;
    }

    @Override
    public List<DocumentField> all() {
        return null;
    }

    @Override
    public DocumentField one(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id, UserDetails user) {
        Optional<User> optionalUser = userRepository.findByNameAndPass(user.getUsername(), user.getPassword());
        optionalUser.ifPresent(o->{

            List<DocumentField> documentFields=documentFieldRepository.findAllByTaskNumber(id);
            documentFieldRepository.deleteAll(documentFields);
//            Optional<DocumentField> optionalDocumentField = documentFieldRepository.findById(id);
//            optionalDocumentField.ifPresent(df->{
//                if (df.getDocument().getUser().equals(optionalUser.get())){
//                    documentFieldRepository.delete(df);
//                }
//            });
        });
        return true;
    }

    public List<DocumentField> addSpecial(UserDetails user, List<FormData> data, Date date){
        try {
            System.out.println(date);
            Optional<User> optionalUser = userRepository.findByNameAndPass(user.getUsername(), user.getPassword());
            if (optionalUser.isEmpty()) return null;
            Optional<Document> optionalDocument = documentRepository.findByUserIdAndReportDate(optionalUser.get().getId(), date);
            Document document=null;
            document = optionalDocument.orElseGet(() -> documentRepository.save(Document
                    .builder()
                    .userId(optionalUser.get().getId())
                    .user(optionalUser.get())
                    .editPermission(true)
                    .reportDate(date)
                    .deleted(false)
                    .build()));

            List<DocumentField> documentFields=new ArrayList<>();

            for (FormData d:data) {
                Optional<Field> field = fieldRepository.findById(d.name);
                if (field.isEmpty()) return null;
                documentFields.add(DocumentField
                        .builder()
                        .document(document)
                        .documentId(document.getId())
                        .data(d.value)
                        .fieldId(field.get().getId())
                        .deleted(false)
                        .build());
            }
//            Optional<DocumentField> maxNumber = documentFieldRepository.findFirstByDocumentOrderByTaskNumberDesc(document);
            Optional<DocumentField> maxNumber = documentFieldRepository.findFirstByOrderByTaskNumberDesc();
            int max=maxNumber.isPresent()?maxNumber.get().getTaskNumber():0;
            documentFields.forEach(d->{
                d.setTaskNumber(max+1);
                d=documentFieldRepository.save(d);
            });
            return documentFields;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public List<DocumentFieldDto> editSpecial(UserDetails user, List<FormData> data, Date date){
        try {
            System.out.println(date);
            Optional<User> optionalUser = userRepository.findByNameAndPass(user.getUsername(), user.getPassword());
            if (optionalUser.isEmpty()) return null;
//            Optional<Document> optionalDocument = documentRepository.findByUserIdAndReportDate(optionalUser.get().getId(), date);
//            Document document=null;
//            document = optionalDocument.orElseGet(() -> documentRepository.save(Document
//                    .builder()
//                    .userId(optionalUser.get().getId())
//                    .user(optionalUser.get())
//                    .editPermission(true)
//                    .reportDate(date)
//                    .deleted(false)
//                    .build()));

            List<DocumentFieldDto> documentFieldDtos=new ArrayList<>();

            for (FormData d:data) {
                Optional<DocumentField> documentField = documentFieldRepository.findById(d.name);
                if (documentField.isEmpty()) return null;
                if (!documentField.get().getDocument().getUser().equals(optionalUser.get())) return null;
                documentField.get().setData(d.value);
                documentFieldRepository.save(documentField.get());
                documentFieldDtos.add(documentField.get().toDto());
            }
//            Optional<DocumentField> maxNumber = documentFieldRepository.findFirstByDocumentOrderByTaskNumberDesc(document);
//            Optional<DocumentField> maxNumber = documentFieldRepository.findFirstByOrderByTaskNumberDesc();
//            int max=maxNumber.isPresent()?maxNumber.get().getTaskNumber():0;
//            documentFields.forEach(d->{
//                d.setTaskNumber(max+1);
//                d=documentFieldRepository.save(d);
//            });
            return documentFieldDtos;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<DocumentFieldDto> allByUserAndReportDate(UserDetails user, Date date) {
        Optional<User> optionalUser = userRepository.findByNameAndPass(user.getUsername(), user.getPassword());
        if (optionalUser.isEmpty()) return Collections.emptyList();
        System.out.println("USER");
        System.out.println(user);
        Optional<Document> document = documentRepository.findByUserIdAndReportDate(optionalUser.get().getId(), date);
        System.out.println("DOCUMENT");
        System.out.println(document);
        if (document.isEmpty()) return Collections.emptyList();
        System.out.println(document.get().toString());
        List<DocumentField> byDocumentId = documentFieldRepository.findAllByDocumentId(document.get().getId());
        List<DocumentFieldDto> dtoList=new ArrayList<>();
        byDocumentId.forEach(f->{
            System.out.println(f.toString());
            dtoList.add(f.toDto());
        });
        return dtoList;
    }

    public List<List<DocumentFieldDto>> allByUserAndReportDateSpec(UserDetails user, Date date) {
        Optional<User> optionalUser = userRepository.findByNameAndPass(user.getUsername(), user.getPassword());
        if (optionalUser.isEmpty()) return Collections.emptyList();
        System.out.println("USER");
        System.out.println(user);
        Optional<Document> document = documentRepository.findByUserIdAndReportDate(optionalUser.get().getId(), date);
        System.out.println("DOCUMENT");
        System.out.println(document);
        if (document.isEmpty()) return Collections.emptyList();
        System.out.println(document.get().toString());
        List<DocumentField> byDocumentId = documentFieldRepository.findAllByDocumentIdOrderByCreatedAtAsc(document.get().getId());
        List<DocumentFieldDto> dtoList=new ArrayList<>();

        List<List<DocumentFieldDto>> doc=new ArrayList<>();
        int counter=0;
        List<DocumentFieldDto> list=new ArrayList<>();
        for (int i = 0; i <byDocumentId.size(); i++) {

            if (i!=byDocumentId.size()-1&&!Objects.equals(byDocumentId.get(i).getTaskNumber(), byDocumentId.get(i + 1).getTaskNumber())){
                list.add(byDocumentId.get(i).toDto());
                doc.add(list);
                list=new ArrayList<>();
            }
            else
            list.add(byDocumentId.get(i).toDto());
//            while (byDocumentId.get(i).getTaskNumber()==byDocumentId.get(i+1).getTaskNumber()){
//                list.add(byDocumentId.get(i).toDto());
//                i++;
//            }
//            list.add(byDocumentId.get(i).toDto());

        }
        doc.add(list);

//        byDocumentId.forEach(f->{
//            System.out.println(f.toString());
//            dtoList.add(f.toDto());
//        });
        return doc;
    }

    public List<DocumentFieldDto> oneSpec(Integer taskNumber, UserDetails user) {
        Optional<User> optionalUser = userRepository.findByNameAndPass(user.getUsername(), user.getPassword());
        List<DocumentField> documentFields=documentFieldRepository.findAllByTaskNumber(taskNumber);
        List<DocumentFieldDto> dtoList=new ArrayList<>();
        if (optionalUser.isPresent()&&documentFields.size()>0&&documentFields.get(0).getDocument().getUser().equals(optionalUser.get())){
            documentFields.forEach(df->{
                dtoList.add(df.toDto());
            });
        }
        return dtoList;
    }
}
