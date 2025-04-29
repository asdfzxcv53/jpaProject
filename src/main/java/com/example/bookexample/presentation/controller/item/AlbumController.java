package com.example.bookexample.presentation.controller.item;

import com.example.bookexample.application.ItemService;
import com.example.bookexample.domain.Item;
import com.example.bookexample.presentation.item.AlbumResponseDto;
import com.example.bookexample.presentation.item.AlbumSaveRequestDto;
import com.example.bookexample.presentation.item.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    private final ItemService itemService;

    @Autowired
    public AlbumController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemResponseDto> createAlbum(@RequestBody AlbumSaveRequestDto albumSaveRequestDto) {
        ItemResponseDto itemResponseDto = itemService.saveItem(albumSaveRequestDto);

        return ResponseEntity.ok(itemResponseDto);
    }

}
