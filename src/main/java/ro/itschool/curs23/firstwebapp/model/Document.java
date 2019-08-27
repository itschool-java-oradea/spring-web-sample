package ro.itschool.curs23.firstwebapp.model;

import java.util.Objects;
import java.util.StringJoiner;

public class Document {
    private String documentId;
    private String name;

    public Document() {
    }

    public Document(String documentId, String name) {
        this.documentId = documentId;
        this.name = name;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document that = (Document) o;

        return Objects.equals(this.documentId, that.documentId) &&
                Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId, name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]")
                .add("documentId = " + documentId)
                .add("name = " + name)
                .toString();
    }
}
