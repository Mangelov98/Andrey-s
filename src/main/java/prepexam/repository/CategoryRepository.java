package prepexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prepexam.model.entity.Category;
import prepexam.model.entity.NameCategory;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Optional<Category> findByNameCategory(NameCategory nameCategory);
}
