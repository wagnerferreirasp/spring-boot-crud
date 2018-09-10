package poc.wagner.empresa.socio;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "socio")
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "socio_id")
    Long id;
    @Column(name = "nome")
    String nome;
}
