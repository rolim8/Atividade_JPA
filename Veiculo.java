package domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = "veiculosFindAll", query = "SELECT v FROM Veiculo v")
})
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo_sequence")
    @SequenceGenerator(sequenceName = "veiculo_sequence", initialValue = 1, allocationSize = 1, name = "veiculo_sequence")
    private Long id;

    private String marca;
    private String modelo;
    private LocalDate ano_fabricacao;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Acessorio> acessorios;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Concessionaria concessionaria;
}
