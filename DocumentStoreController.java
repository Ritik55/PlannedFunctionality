import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
public class DocumentStoreController {
    private final DocumentStoreService documentStoreService;

    public DocumentStoreController(DocumentStoreService documentStoreService) {
        this.documentStoreService = documentStoreService;
    }

    @GetMapping("/")
    public String showDocumentStorePage(Model model) {
        List<Document> documents = documentStoreService.getAllDocuments();
        model.addAttribute("documents", documents);
        return "documentStore";
    }

    @PostMapping("/filter")
    public String filterDocumentStore(@RequestParam String filter, Model model) {
        List<Document> documents = documentStoreService.filterDocuments(filter);
        model.addAttribute("documents", documents);
        return "documentStore";
    }

    @PostMapping("/search")
    public String searchDocumentStore(@RequestParam String query, Model model) {
        List<Document> documents = documentStoreService.searchDocuments(query);
        model.addAttribute("documents", documents);
        return "documentStore";
    }

    @PostMapping("/recommend")
    public String recommendDocuments(@RequestParam Long templateId, Model model) {
        List<Document> documents = documentStoreService.recommendDocuments(templateId);
        model.addAttribute("documents", documents);
        return "documentStore";
    }

    @PostMapping("/tag")
    public String tagDocuments(@RequestParam String tag, Model model) {
        List<Document> documents = documentStoreService.tagDocuments(tag);
        model.addAttribute("documents", documents);
        return "documentStore";
    }

    @PostMapping("/store")
    public String storeDocuments(@RequestParam("file") MultipartFile[] files, Model model) {
        documentStoreService.storeDocuments(files);
        return "documentStore";
    }
}
