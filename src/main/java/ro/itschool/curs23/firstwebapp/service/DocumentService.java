package ro.itschool.curs23.firstwebapp.service;

import org.springframework.stereotype.Service;
import ro.itschool.curs23.firstwebapp.model.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

@Service
public class DocumentService {
    private final List<Document> documents = new ArrayList<>();

    public List<Document> getDocuments(String name) {
        return ofNullable(name)
                .map(this::getByName)
                .orElse(documents);
    }

    private List<Document> getByName(String name) {
        return documents.stream()
                .filter(doc -> doc.getName().equals(name))
                .collect(toList());
    }

    public Document addDocument(Document doc) {
        doc.setDocumentId(UUID.randomUUID().toString());
        documents.add(doc);
        return doc;
    }

    public Document getDocument(String documentId) {
        return documents.stream()
                .filter(doc -> doc.getDocumentId().equals(documentId))
                .findFirst()
                .orElse(null);
    }

    public Document updateDocument(String documentId, Document doc) {
        final Document exitingDocument = getDocument(documentId);
        if (exitingDocument != null) {
            doc.setDocumentId(documentId);
            documents.remove(exitingDocument);
            documents.add(doc);
            return exitingDocument;
        } else {
            return null;
        }
    }

    public Document deleteDocument(String documentId) {
        final Document doc = getDocument(documentId);
        if (documents.remove(doc)) {
            return doc;
        } else {
            return null;
        }
    }
}
