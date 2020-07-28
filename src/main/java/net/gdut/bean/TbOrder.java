package net.gdut.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TbOrder {
    private Integer ono;
    private Integer uno;
    private Integer bno;
    private Integer quantity;

}
