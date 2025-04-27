package com.example.bookexample.application;

import com.example.bookexample.domain.Item;
import com.example.bookexample.infrastructure.ItemRepository;
import com.example.bookexample.presentation.item.ItemDtoFactory;
import com.example.bookexample.presentation.item.ItemRequestDto;
import com.example.bookexample.presentation.item.ItemResponseDto;
import com.example.bookexample.presentation.item.ItemSaveRequestDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ItemService {

    private ItemRepository itemRepository;
    private ItemDtoFactory itemDtoFactory;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemDtoFactory itemDtoFactory) {
        this.itemRepository = itemRepository;
        this.itemDtoFactory = itemDtoFactory;
    }

    public ItemResponseDto saveItem(ItemSaveRequestDto itemSaveRequestDto) {
        Item item = itemDtoFactory.createItem(itemSaveRequestDto);
        Item savedItem = itemRepository.save(item);

        ItemResponseDto itemResponseDto = itemDtoFactory.createDto(savedItem);

        return itemResponseDto;
    }

    public List<ItemResponseDto> findItems() {
        List<ItemResponseDto> itemResponseDtos =
                itemRepository.findAll()
                        .stream()
                        .map(item -> itemDtoFactory.createDto(item))
                        .toList();

        return itemResponseDtos;
    }

    public ItemResponseDto findOne(Long id) {
        Item item = itemRepository.findOne(id);

        return itemDtoFactory.createDto(item);
    }

    public List<ItemResponseDto> findByName(String name) {
        List<ItemResponseDto> itemResponseDtos =
                itemRepository.findByName(name)
                .stream()
                .map(item -> itemDtoFactory.createDto(item))
                .toList();

        return itemResponseDtos;
    }


}
