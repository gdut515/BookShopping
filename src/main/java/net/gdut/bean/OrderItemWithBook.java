package net.gdut.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//订单项目（包含书属性）
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemWithBook {
    private String bname;
    private String author;
    private String categoryName;
    private String publisherName;
    private String ageName;
    private String cover;
    private Double price;
    private Integer quantity;
    private String description;
    private Integer category;
    private Integer publisher;
    private Integer age;
    private Double cost;
}
