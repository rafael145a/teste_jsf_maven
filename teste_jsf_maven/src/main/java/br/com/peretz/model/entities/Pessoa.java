package br.com.peretz.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Rafael
 */

@Entity
@Table (name="pessoa")
public class Pessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="idPessoa", nullable=false)
    private Integer idPessoa;
    
    @Column(nullable=false, length = 80)
    private String nome;
    
    @Column(nullable=false, length = 80)
    private String email;
    
    @Column(nullable=false, length = 15)
    private String telefone; //(011)-9999-9999
    
    @Column(nullable=false, length = 14) 
    private String cpf;      //111.555.999-66
    
    @Column(nullable=false)
    private Date dataNascimento;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    
    @ManyToOne(optional=false)
    @ForeignKey(name="PessoaSexo")
    private Pessoa pessoa;
    

    public Pessoa() {
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.idPessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.idPessoa, other.idPessoa)) {
            return false;
        }
        return true;
    }
    
    

}
