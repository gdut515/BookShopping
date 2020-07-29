package net.gdut.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TbBook {
    private Integer bno;
    private String bname;
    private String author;
    private String cover;
    private Double price;
    private String description;

}
