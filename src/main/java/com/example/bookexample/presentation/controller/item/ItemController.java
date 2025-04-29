package com.example.bookexample.presentation.controller.item;

import com.example.bookexample.application.ItemService;
import com.example.bookexample.presentation.item.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(final ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<ItemResponseDto>> getItems(){
        List<ItemResponseDto> itemResponseDtos = itemService.findItems();

        return ResponseEntity.ok(itemResponseDtos);
    }
}
