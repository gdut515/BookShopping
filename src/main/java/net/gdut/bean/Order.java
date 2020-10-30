package net.gdut.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Integer ono;
    private Integer uno;
    private Timestamp time;
    private Integer state;
    private String address;
    private List<OrderItem> orderItems;
}
