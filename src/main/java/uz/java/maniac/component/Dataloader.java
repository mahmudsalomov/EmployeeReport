//package uz.java.maniac.component;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import uz.java.maniac.model.Field;
//import uz.java.maniac.model.Task;
//import uz.java.maniac.model.User;
//import uz.java.maniac.model.template.InputType;
//import uz.java.maniac.repository.*;
//
//import java.util.List;
//
//@Component
//public class Dataloader implements CommandLineRunner {
//    private final UserRepository userRepository;
//    private final TaskRepository taskRepository;
//    private final FieldRepository fieldRepository;
//    private final DocumentRepository documentRepository;
//    private final DocumentFieldRepository documentFieldRepository;
//
//    public Dataloader(UserRepository userRepository, TaskRepository taskRepository, FieldRepository fieldRepository, DocumentRepository documentRepository, DocumentFieldRepository documentFieldRepository) {
//        this.userRepository = userRepository;
//        this.taskRepository = taskRepository;
//        this.fieldRepository = fieldRepository;
//        this.documentRepository = documentRepository;
//        this.documentFieldRepository = documentFieldRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        List<User> all = userRepository.findAll();
//        if (all.size()==0){
//            userRepository.save(User
//                    .builder()
//                    .id(1)
//                    .name("user")
//                    .pass("user")
//                    .build());
//
//            userRepository.save(User
//                    .builder()
//                    .id(2)
//                    .name("user2")
//                    .pass("user2")
//                    .build());
//
//            List<Task> tasks=taskRepository.findAll();
//
////            if (tasks.size()==0){
////                Task task1 = taskRepository.save(Task
////                        .builder()
////                        .name("Uchrashuv")
////                        .description("asdasd")
////                        .build());
////                Task task2 = taskRepository.save(Task
////                        .builder()
////                        .name("Sotuv")
////                        .description("qqqqqq")
////                        .build());
////
////                Task task3 = taskRepository.save(Task
////                        .builder()
////                        .name("Komandirovka")
////                        .description("a")
////                        .build());
////
////
////                //Task1
////                fieldRepository.save(Field
////                        .builder()
////                        .taskId(task1.getId())
////                        .placeholder("Ism")
////                        .type(InputType.TEXT)
////                        .name("Kim bilan?")
////                        .build());
////
////                fieldRepository.save(Field
////                        .builder()
////                        .taskId(task1.getId())
////                        .placeholder("Sabab")
////                        .type(InputType.TEXTAREA)
////                        .name("Nima sababdan?")
////                        .build());
////                fieldRepository.save(Field
////                        .builder()
////                        .taskId(task1.getId())
////                        .placeholder("Vaqt")
////                        .type(InputType.DATE)
////                        .name("Uchrashuv vaqti")
////                        .build());
////
////                //Task2
////                fieldRepository.save(Field
////                        .builder()
////                        .taskId(task2.getId())
////                        .placeholder("Mahsulot")
////                        .type(InputType.TEXT)
////                        .name("Nima mahsulot?")
////                        .build());
////                fieldRepository.save(Field
////                        .builder()
////                        .taskId(task2.getId())
////                        .placeholder("Narxi")
////                        .type(InputType.NUMBER)
////                        .name("Mahsulot narxi?")
////                        .build());
////
////                //Task3
////                fieldRepository.save(Field
////                        .builder()
////                        .taskId(task3.getId())
////                        .placeholder("Qayerga")
////                        .type(InputType.TEXT)
////                        .name("Qayerga")
////                        .build());
////
////                fieldRepository.save(Field
////                        .builder()
////                        .taskId(task3.getId())
////                        .placeholder("Qancha vaqtga (kun)")
////                        .type(InputType.NUMBER)
////                        .name("Qancha vaqtga? (kun)")
////                        .build());
////            }
//
//        }
//
//    }
//}
