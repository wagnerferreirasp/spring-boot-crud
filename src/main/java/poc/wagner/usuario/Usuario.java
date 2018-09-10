package poc.wagner.usuario;

import lombok.Builder;
import lombok.Data;
import poc.wagner.Role;
import poc.wagner.empresa.grandeEmpresa.GrandeEmpresa;
import poc.wagner.empresa.startup.Startup;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    Long id;
    @Column(name = "senha")
    String senha;
    @Column(name = "email")
    String email;
    @Column(name = "nome")
    String nome;
    @OneToMany
    @JoinTable(name = "usuario_startup")
    List<Startup> startups;
    @OneToMany
    @JoinTable(name = "usuario_grande_empresa")
    List<GrandeEmpresa> grandesEmpresas;
    @ManyToMany
    @JoinTable(name = "usuario_role",
        inverseJoinColumns = @JoinColumn(name = "role_id"),
        joinColumns = @JoinColumn(name = "usuario_id")
    )
    Set<Role> roles;
}

