package br.com.andrea.autorizacao.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Data
@Entity
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private Long procedimento;

    @Min(0)
    @PositiveOrZero
    private int idade;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private boolean permitido;

    public Procedimento(Long procedimento) {
        this.procedimento = procedimento;
    }

    public Procedimento() {
        super();
    }

}
