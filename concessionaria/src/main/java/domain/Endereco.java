package domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_sequence")
    @SequenceGenerator(sequenceName = "endereco_sequence", initialValue = 1, allocationSize = 1, name = "endereco_sequence")
    private Long id;

    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
}