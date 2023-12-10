package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "tb_cliente", schema = "public", catalog = "venda_online")
public class TbClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "cpf")
    private long cpf;
    @Basic
    @Column(name = "tel")
    private long tel;
    @Basic
    @Column(name = "endereco")
    private String endereco;
    @Basic
    @Column(name = "numero")
    private long numero;
    @Basic
    @Column(name = "cidade")
    private String cidade;
    @Basic
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "tbClienteByIdClienteFk")
    private Collection<TbVendaEntity> tbVendasById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbClienteEntity that = (TbClienteEntity) o;

        if (id != that.id) return false;
        if (cpf != that.cpf) return false;
        if (tel != that.tel) return false;
        if (numero != that.numero) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (endereco != null ? !endereco.equals(that.endereco) : that.endereco != null) return false;
        if (cidade != null ? !cidade.equals(that.cidade) : that.cidade != null) return false;
        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (int) (cpf ^ (cpf >>> 32));
        result = 31 * result + (int) (tel ^ (tel >>> 32));
        result = 31 * result + (endereco != null ? endereco.hashCode() : 0);
        result = 31 * result + (int) (numero ^ (numero >>> 32));
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    public Collection<TbVendaEntity> getTbVendasById() {
        return tbVendasById;
    }

    public void setTbVendasById(Collection<TbVendaEntity> tbVendasById) {
        this.tbVendasById = tbVendasById;
    }
}
