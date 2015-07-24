package br.com.peretz.model.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rafael
 */

@Entity
@Table (name="pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue
    @Column(name="idPessoa", nullable=false)
    private Integer idPessoa;
    
    @Column(nullable=false, length = 80)
    private String nome;
    
    @Column(nullable=false, length = 80)
    private String email;
    
    @Column(nullable=false, length = 80)
    private String telefone;
    
    @Column(nullable=false)
    private String cpf;
    
    @Column(nullable=false)
    private Date dataNascimento;
    private Date dataCadastro;

}
