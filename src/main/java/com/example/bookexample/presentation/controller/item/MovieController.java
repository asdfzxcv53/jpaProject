package com.example.bookexample.presentation.controller.item;

import com.example.bookexample.application.ItemService;
import com.example.bookexample.presentation.item.ItemResponseDto;
import com.example.bookexample.presentation.item.MovieSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final ItemService itemService;

    @Autowired
    public MovieController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemResponseDto> createMovie(@RequestBody MovieSaveRequestDto movieSaveRequestDto) {
        ItemResponseDto itemResponseDto = itemService.saveItem(movieSaveRequestDto);

        return ResponseEntity.ok(itemResponseDto);
    }
}
