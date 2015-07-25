package br.com.peretz.model.entities;

import java.io.Serializable;
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
@Table(name = "endereco")
public class Endereco implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer idEndereco;
    
    @Column(nullable = false, length = 80)
    private String bairro;
    
    @Column(nullable = false, length = 80)
    private String nomeLogradouro;
    
    @Column(nullable = false, length = 9)
    private String cep;
    
    @Column(nullable = false)
    private int numero;
    
    @Column(nullable = false, length = 15)
    private String complemento;
    
    
}
