package net.gdut.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartItem {
    private Integer id;
    private String author;
    private String book_image;
    private String book_name;
    private Double price;
    private Integer quantity;
}
