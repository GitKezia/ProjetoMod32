package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "tb_venda", schema = "public", catalog = "venda_online")
public class TbVendaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "codigo")
    private String codigo;
    @Basic
    @Column(name = "id_cliente_fk")
    private long idClienteFk;
    @Basic
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Basic
    @Column(name = "data_venda")
    private Object dataVenda;
    @Basic
    @Column(name = "status_venda")
    private String statusVenda;
    @OneToMany(mappedBy = "tbVendaByIdVendaFk")
    private Collection<TbProdutoQuantidadeEntity> tbProdutoQuantidadesById;
    @ManyToOne
    @JoinColumn(name = "id_cliente_fk", referencedColumnName = "id", nullable = false)
    private TbClienteEntity tbClienteByIdClienteFk;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public long getIdClienteFk() {
        return idClienteFk;
    }

    public void setIdClienteFk(long idClienteFk) {
        this.idClienteFk = idClienteFk;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Object getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Object dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getStatusVenda() {
        return statusVenda;
    }

    public void setStatusVenda(String statusVenda) {
        this.statusVenda = statusVenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TbVendaEntity that = (TbVendaEntity) o;

        if (id != that.id) return false;
        if (idClienteFk != that.idClienteFk) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (valorTotal != null ? !valorTotal.equals(that.valorTotal) : that.valorTotal != null) return false;
        if (dataVenda != null ? !dataVenda.equals(that.dataVenda) : that.dataVenda != null) return false;
        if (statusVenda != null ? !statusVenda.equals(that.statusVenda) : that.statusVenda != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (int) (idClienteFk ^ (idClienteFk >>> 32));
        result = 31 * result + (valorTotal != null ? valorTotal.hashCode() : 0);
        result = 31 * result + (dataVenda != null ? dataVenda.hashCode() : 0);
        result = 31 * result + (statusVenda != null ? statusVenda.hashCode() : 0);
        return result;
    }

    public Collection<TbProdutoQuantidadeEntity> getTbProdutoQuantidadesById() {
        return tbProdutoQuantidadesById;
    }

    public void setTbProdutoQuantidadesById(Collection<TbProdutoQuantidadeEntity> tbProdutoQuantidadesById) {
        this.tbProdutoQuantidadesById = tbProdutoQuantidadesById;
    }

    public TbClienteEntity getTbClienteByIdClienteFk() {
        return tbClienteByIdClienteFk;
    }

    public void setTbClienteByIdClienteFk(TbClienteEntity tbClienteByIdClienteFk) {
        this.tbClienteByIdClienteFk = tbClienteByIdClienteFk;
    }
}
