package prepexam.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import prepexam.model.entity.Item;
import prepexam.model.service.CategoryServiceModel;
import prepexam.model.service.ItemServiceModel;
import prepexam.model.view.ItemViewModel;
import prepexam.repository.ItemRepository;
import prepexam.service.CategoryService;
import prepexam.service.ItemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }


    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        Item item = this.modelMapper.map(itemServiceModel, Item.class);

        item.setCategory(this.categoryService.findByNameCategory(itemServiceModel.getCategory().getNameCategory()));

        this.itemRepository.saveAndFlush(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {

        return this.itemRepository.findAll().stream().map(item -> {
            ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);

            itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getNameCategory().name()));
            return itemViewModel;
        }).collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(String id) {
        return this.itemRepository.findById(id).map(item -> {
            ItemViewModel itemViewModel = this.modelMapper.map(item, ItemViewModel.class);

            itemViewModel.setImgUrl(String.format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getNameCategory().name()));
            return itemViewModel;
        }).orElse(null);
    }

    @Override
    public void delete(String id) {
        this.itemRepository.deleteById(id);
    }
}
