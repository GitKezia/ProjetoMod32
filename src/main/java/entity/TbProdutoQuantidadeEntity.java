package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto_quantidade", schema = "public", catalog = "venda_online")
public class TbProdutoQuantidadeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "id_produto_fk")
    private long idProdutoFk;
    @Basic
    @Column(name = "id_venda_fk")
    private long idVendaFk;
    @Basic
    @Column(name = "quantidade")
    private int quantidade;
    @Basic
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @ManyToOne
    @JoinColumn(name = "id_produto_fk", referencedColumnName = "id", nullable = false)
    private TbEstoqueEntity tbEstoqueByIdProdutoFk;
    @ManyToOne
    @JoinColumn(name = "id_venda_fk", referencedColumnName = "id", nullable = false)
    private TbVendaEntity tbVendaByIdVendaFk;

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

    public long getIdVendaFk() {
        return idVendaFk;
    }

    public void setIdVendaFk(long idVendaFk) {
        this.idVendaFk = idVendaFk;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbProdutoQuantidadeEntity that = (TbProdutoQuantidadeEntity) o;

        if (id != that.id) return false;
        if (idProdutoFk != that.idProdutoFk) return false;
        if (idVendaFk != that.idVendaFk) return false;
        if (quantidade != that.quantidade) return false;
        if (valorTotal != null ? !valorTotal.equals(that.valorTotal) : that.valorTotal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idProdutoFk ^ (idProdutoFk >>> 32));
        result = 31 * result + (int) (idVendaFk ^ (idVendaFk >>> 32));
        result = 31 * result + quantidade;
        result = 31 * result + (valorTotal != null ? valorTotal.hashCode() : 0);
        return result;
    }

    public TbEstoqueEntity getTbEstoqueByIdProdutoFk() {
        return tbEstoqueByIdProdutoFk;
    }

    public void setTbEstoqueByIdProdutoFk(TbEstoqueEntity tbEstoqueByIdProdutoFk) {
        this.tbEstoqueByIdProdutoFk = tbEstoqueByIdProdutoFk;
    }

    public TbVendaEntity getTbVendaByIdVendaFk() {
        return tbVendaByIdVendaFk;
    }

    public void setTbVendaByIdVendaFk(TbVendaEntity tbVendaByIdVendaFk) {
        this.tbVendaByIdVendaFk = tbVendaByIdVendaFk;
    }
}
