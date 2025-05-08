package com.example.bookexample.servicetest;

import com.example.bookexample.application.ItemService;
import com.example.bookexample.domain.Album;
import com.example.bookexample.domain.Item;
import com.example.bookexample.infrastructure.ItemRepository;
import com.example.bookexample.presentation.item.*;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private ItemDtoFactory itemDtoFactory;

    @InjectMocks
    private ItemService itemService;


    @Test
    @DisplayName("아이템 저장")
    public void SaveItem() throws Exception {

        // Given

        Album album = new Album(null, "album", 10000, 10, "artist", "etc");
        AlbumSaveRequestDto albumSaveRequestDto = new AlbumSaveRequestDto("album", 10000, 10, "artist", "etc");
        AlbumResponseDto albumResponseDto = new AlbumResponseDto(1L, "album", 10000, 10, "artist", "etc");

        when(itemDtoFactory.createItem(any(ItemSaveRequestDto.class))).thenReturn(album);
        when(itemRepository.save(any(Item.class))).thenReturn(album);
        when(itemDtoFactory.createDto(any(Item.class))).thenReturn(albumResponseDto);

        // When

        ItemResponseDto result = itemService.saveItem(albumSaveRequestDto);

        // Then

        assertThat(result)
                .extracting("name", "price", "stockQuantity", "artist", "etc")
                .containsExactly("album", 10000, 10, "artist", "etc");
    }
}
