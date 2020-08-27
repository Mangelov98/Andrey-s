package prepexam.service;

import prepexam.model.entity.Category;
import prepexam.model.entity.NameCategory;
import prepexam.model.service.CategoryServiceModel;

public interface CategoryService {
    void initCategories();

    Category findByNameCategory(NameCategory nameCategory);
}
