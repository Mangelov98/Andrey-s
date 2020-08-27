package prepexam.model.service;

import prepexam.model.entity.NameCategory;

public class CategoryServiceModel extends BaseServiceModel {

    private NameCategory nameCategory;
    private String description;

    public CategoryServiceModel() {

    }

    public NameCategory getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(NameCategory nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
