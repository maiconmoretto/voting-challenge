package com.br.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserDTO {

    private String name;
    private LocalDateTime createdAt;
    private String cpf;

}