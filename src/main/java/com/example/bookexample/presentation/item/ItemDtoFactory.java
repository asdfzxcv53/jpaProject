package com.example.bookexample.presentation.item;

import com.example.bookexample.domain.Album;
import com.example.bookexample.domain.Book;
import com.example.bookexample.domain.Item;
import com.example.bookexample.domain.Movie;
import org.springframework.stereotype.Component;

@Component
public class ItemDtoFactory {

    public ItemResponseDto createDto(Item item) {
        if (item instanceof Book) {
            Book book = (Book) item;
            BookResponseDto dto = new BookResponseDto();
            dto.setId(book.getId());
            dto.setName(book.getName());
            dto.setPrice(book.getPrice());
            dto.setStockQuantity(book.getStockQuantity());
            dto.setAuthor(book.getAuthor());
            dto.setIsbn(book.getIsbn());
            return dto;
        } else if (item instanceof Album) {
            Album album = (Album) item;
            AlbumResponseDto dto = new AlbumResponseDto();
            dto.setId(album.getId());
            dto.setName(album.getName());
            dto.setPrice(album.getPrice());
            dto.setStockQuantity(album.getStockQuantity());
            dto.setArtist(album.getArtist());
            dto.setEtc(album.getEtc());
            return dto;
        } else if (item instanceof Movie) {
            Movie movie = (Movie) item;
            MovieResponseDto dto = new MovieResponseDto();
            dto.setId(movie.getId());
            dto.setName(movie.getName());
            dto.setPrice(movie.getPrice());
            dto.setStockQuantity(movie.getStockQuantity());
            dto.setDirector(movie.getDirector());
            dto.setActor(movie.getActor());
            return dto;
        } else {
            throw new IllegalArgumentException("Unknown item type: " + item.getClass());
        }
    }
    public Item createItem(ItemSaveRequestDto dto) {
        if (dto instanceof BookSaveRequestDto) {
            //BookSaveRequestDto bookSaveRequestDto = (BookSaveRequestDto) dto;
            Book book = Book
                    .builder()
                    .name(dto.getName())
                    .price(dto.getPrice())
                    .stockQuantity(dto.getStockQuantity())
                    .author(((BookSaveRequestDto) dto).getAuthor())
                    .isbn(((BookSaveRequestDto) dto).getIsbn())
                    .build();
            return book;
        } else if (dto instanceof AlbumSaveRequestDto) {
            //AlbumSaveRequestDto albumSaveRequestDto = (AlbumSaveRequestDto) dto;
            Album album = Album
                    .builder()
                    .name(dto.getName())
                    .price(dto.getPrice())
                    .stockQuantity(dto.getStockQuantity())
                    .artist(((AlbumSaveRequestDto) dto).getArtist())
                    .etc(((AlbumSaveRequestDto) dto).getEtc())
                    .build();
            return album;
        } else if (dto instanceof MovieSaveRequestDto) {
            //MovieSaveRequestDto movieSaveRequestDto = (MovieSaveRequestDto) dto;
            Movie movie = Movie
                    .builder()
                    .name(dto.getName())
                    .price(dto.getPrice())
                    .stockQuantity(dto.getStockQuantity())
                    .director(((MovieSaveRequestDto) dto).getDirector())
                    .actor(((MovieSaveRequestDto) dto).getActor())
                    .build();

            return movie;
        } else {
            throw new IllegalArgumentException("Unknown item type: " + dto.getClass());
        }
    }

}