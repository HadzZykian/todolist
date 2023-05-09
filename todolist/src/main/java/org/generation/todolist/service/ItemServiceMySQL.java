package org.generation.todolist.service;


import org.generation.todolist.repository.ItemRepository;
import org.generation.todolist.repository.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ItemServiceMySQL implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceMySQL(@Autowired ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
    }


    @Override
    public Item save(Item item)
    {
        return itemRepository.save(item);
    }


    @Override
    public void delete(int itemId)
    {
        itemRepository.deleteById(itemId);
    }


    @Override
    public ArrayList<Item> all()
    {
        ArrayList<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach(result::add);
        return result;
    }


    @Override
    public Item findById(int itemId)
    {
        Optional<Item> item = itemRepository.findById(itemId);
        Item itemResponse = item.get();
        return itemResponse;
    }
}


