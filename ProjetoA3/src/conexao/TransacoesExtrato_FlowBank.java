
package conexao;

import java.sql.Timestamp;
import java.math.BigDecimal;

public class TransacoesExtrato_FlowBank {
    
    private Integer id_transacao;
    private Integer id_cliente;
    private Timestamp data_transacao;
    private BigDecimal valor_transacao;
    private String tipo_transacao;
    
    
    public Integer getId_Transacao() { return id_transacao; }
    public Integer getId_Cliente() {return id_cliente; }
    public Timestamp getData_Transacao() { return data_transacao; }
    public BigDecimal getValor_Transacao() { return valor_transacao; }
    public String getTipo_Transacao() { return tipo_transacao; }
    
    
    public void setId_Transacao(Integer id_transacao) {this.id_transacao = id_transacao; }
    public void setId_Cliente(Integer id_cliente) { this.id_cliente = id_cliente; }
    public void setData_Transacao(Timestamp data_transacao) { this.data_transacao = data_transacao; }
    public void setValor_Transacao(BigDecimal valor_transacao) { this.valor_transacao = valor_transacao; }
    public void setTipo_Transacao(String tipo_transacao) { this.tipo_transacao = tipo_transacao; }
}