package entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "tb_estoque", schema = "public", catalog = "venda_online")
public class TbEstoqueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "id_produto_fk")
    private long idProdutoFk;
    @Basic
    @Column(name = "quantidade_estoque")
    private int quantidadeEstoque;
    @ManyToOne
    @JoinColumn(name = "id_produto_fk", referencedColumnName = "id", nullable = false)
    private TbProdutoEntity tbProdutoByIdProdutoFk;
    @OneToMany(mappedBy = "tbEstoqueByIdProdutoFk")
    private Collection<TbProdutoQuantidadeEntity> tbProdutoQuantidadesById;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdProdutoFk() {
        return idProdutoFk;
    }

    public void setIdProdutoFk(long idProdutoFk) {
        this.idProdutoFk = idProdutoFk;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbEstoqueEntity that = (TbEstoqueEntity) o;

        if (id != that.id) return false;
        if (idProdutoFk != that.idProdutoFk) return false;
        if (quantidadeEstoque != that.quantidadeEstoque) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idProdutoFk ^ (idProdutoFk >>> 32));
        result = 31 * result + quantidadeEstoque;
        return result;
    }

    public TbProdutoEntity getTbProdutoByIdProdutoFk() {
        return tbProdutoByIdProdutoFk;
    }

    public void setTbProdutoByIdProdutoFk(TbProdutoEntity tbProdutoByIdProdutoFk) {
        this.tbProdutoByIdProdutoFk = tbProdutoByIdProdutoFk;
    }

    public Collection<TbProdutoQuantidadeEntity> getTbProdutoQuantidadesById() {
        return tbProdutoQuantidadesById;
    }

    public void setTbProdutoQuantidadesById(Collection<TbProdutoQuantidadeEntity> tbProdutoQuantidadesById) {
        this.tbProdutoQuantidadesById = tbProdutoQuantidadesById;
    }
}
