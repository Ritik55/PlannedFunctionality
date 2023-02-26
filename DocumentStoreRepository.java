import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DocumentStoreRepository extends JpaRepository<Document, Long> {
    List<Document> findByFilter(String filter);
    List<Document> findByQuery(String query);
    List<Document> findByTemplateId(Long templateId);
    List<Document> findByTag(String tag);
}