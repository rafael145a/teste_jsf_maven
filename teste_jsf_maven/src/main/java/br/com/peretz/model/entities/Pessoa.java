package br.com.peretz.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;
import javax.persistence.OneToOne;
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
    
    @Column(unique = true, length = 25)
    private String login;
    @Column(length = 40)
    private String senha;
    @Column(length = 36)
    private String permissao;
    
    
    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoPessoa")
    private Endereco endereco;    
    
    @ManyToOne(optional=false)
    @JoinColumn(name="idSexo", referencedColumnName = "idSexo", nullable = false)
    @ForeignKey(name = "PessoaSexo")
    private Sexo sexo;

    public Pessoa() {
        this.sexo = new Sexo();
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
       
    public Sexo getSexo() {
        return sexo;
    }

    public void setPessoa(Sexo sexo) {
        this.sexo = sexo;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
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
