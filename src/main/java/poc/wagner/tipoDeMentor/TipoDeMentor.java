package poc.wagner.tipoDeMentor;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tipo_de_mentor")
@Data
public class TipoDeMentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_de_mentor_id")
    Long id;
    @Column(name = "nome")
    String nome;
}
