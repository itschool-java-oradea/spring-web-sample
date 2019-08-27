package ro.itschool.curs23.firstwebapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.itschool.curs23.firstwebapp.model.Document;
import ro.itschool.curs23.firstwebapp.service.DocumentService;

@SpringBootApplication
public class FirstWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstWebAppApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(DocumentService documentService) {
        return args -> {
            documentService.addDocument(new Document("doc1", "name1"));
            documentService.addDocument(new Document("doc2", "name2"));
            documentService.addDocument(new Document("doc3", "name3"));
            documentService.addDocument(new Document("doc4", "name4"));
            documentService.addDocument(new Document("doc5", "name5"));
        };
    }
}
