package com.example.bookexample.presentation.controller.item;

import com.example.bookexample.application.ItemService;
import com.example.bookexample.presentation.item.BookResponseDto;
import com.example.bookexample.presentation.item.BookSaveRequestDto;
import com.example.bookexample.presentation.item.ItemRequestDto;
import com.example.bookexample.presentation.item.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    private final ItemService itemService;

    @Autowired
    public BookController(final ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemResponseDto> createBook(@RequestBody BookSaveRequestDto bookSaveRequestDto) {
        ItemResponseDto itemResponseDto = itemService.saveItem(bookSaveRequestDto);

        return ResponseEntity.ok(itemResponseDto);
    }
}
