package net.gdut.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TbUser {
    private Integer uno;
    private String uname;
    private String password;
    private String authority;
}
