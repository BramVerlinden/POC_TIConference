//package be.kdg.pocticonference.config;
//
//import be.kdg.pocticonference.model.CameraMessage;
//import be.kdg.pocticonference.repository.CameraMessageRepository;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//@Component
//public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    private CameraMessageRepository repository;
//
//    @Override
//    @Transactional
//    public void onApplicationEvent(ContextRefreshedEvent event){
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            List<CameraMessage> messages = mapper.readValue(new File("C:\\Users\\yanni\\Documents\\KdG TI\\jaar 3\\TIConference\\POC\\POC_TIConference\\src\\main\\resources\\MOCK_DATA-2.json")
//                    , new TypeReference<List<CameraMessage>>() {
//            });
//            repository.saveAll(messages);
//
//        }catch (IOException e){
//            System.out.println(e.getMessage());
//        }
//
//    }
//}
