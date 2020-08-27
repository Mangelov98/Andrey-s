package prepexam.model.binding;

import org.hibernate.validator.constraints.Length;
import prepexam.model.entity.Category;
import prepexam.model.entity.NameCategory;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ItemAddBindingModel {
    private String name;
    private String description;
    private NameCategory category;
    private BigDecimal price;
    private String gender;

    public ItemAddBindingModel() {
    }

    @Length(min = 2, message = "Username length must be more than two characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 3, message = "Description length must be more than three characters!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "Enter valid category name!")
    public NameCategory getCategory() {
        return category;
    }

    public void setCategory(NameCategory category) {
        this.category = category;
    }

    @DecimalMin(value = "0")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Length(min = 2, message = "Enter valid gender!")
    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }
}
