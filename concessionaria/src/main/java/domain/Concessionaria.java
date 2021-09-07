package domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = "findByName", query = "SELECT c from Concessionaria c where c.nome = :nome")
})
public class Concessionaria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "concessionaria_sequence")
    @SequenceGenerator(sequenceName = "concessionaria_sequence", initialValue = 1, allocationSize = 1, name = "concessionaria_sequence")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private String nome;
    private String telefone;

    @OneToMany(mappedBy = "concessionaria", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Veiculo> veiculos;

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
        veiculos.stream().forEach(v -> {
            v.setConcessionaria(this);
        });
    }
}