import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class DocumentStoreService {
    private final DocumentStoreRepository documentStoreRepository;

    public DocumentStoreService(DocumentStoreRepository documentStoreRepository) {
        this.documentStoreRepository = documentStoreRepository;
    }

    public List<Document> getAllDocuments() {
        return documentStoreRepository.findAll();
    }

    public List<Document> filterDocuments(String filter) {
    	return documentStoreRepository.findAllByFileNameContaining(filter);
    }

    public List<Document> searchDocuments(String query) {
    	return documentStoreRepository.findAllByFileNameContainingOrDescriptionContaining(query, query);
    }

    public List<Document> recommendDocuments(Long templateId) {
    	return documentStoreRepository.findAllByTemplateId(templateId);
    }

    public List<Document> tagDocuments(String tag) {
    	return documentStoreRepository.findAllByTagsContaining(tag);
    }

    public void storeDocuments(MultipartFile[] files) {
        for (MultipartFile file : files) {
            Document document = new Document();
            document.setFileName(file.getOriginalFilename());
            document.setContent(file.getBytes());
            documentStoreRepository.save(document);
        }
    }
}
