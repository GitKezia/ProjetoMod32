package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "tb_produto", schema = "public", catalog = "venda_online")
public class TbProdutoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "codigo")
    private Long codigo;
    @Basic
    @Column(name = "nome")
    private String nome;
    @Basic
    @Column(name = "descricao")
    private String descricao;
    @Basic
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic
    @Column(name = "quantidade_em_estoque")
    private Integer quantidadeEmEstoque;
    @OneToMany(mappedBy = "tbProdutoByIdProdutoFk")
    private Collection<TbEstoqueEntity> tbEstoquesById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbProdutoEntity that = (TbProdutoEntity) o;

        if (id != that.id) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;
        if (valor != null ? !valor.equals(that.valor) : that.valor != null) return false;
        if (quantidadeEmEstoque != null ? !quantidadeEmEstoque.equals(that.quantidadeEmEstoque) : that.quantidadeEmEstoque != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        result = 31 * result + (quantidadeEmEstoque != null ? quantidadeEmEstoque.hashCode() : 0);
        return result;
    }

    public Collection<TbEstoqueEntity> getTbEstoquesById() {
        return tbEstoquesById;
    }

    public void setTbEstoquesById(Collection<TbEstoqueEntity> tbEstoquesById) {
        this.tbEstoquesById = tbEstoquesById;
    }
}
