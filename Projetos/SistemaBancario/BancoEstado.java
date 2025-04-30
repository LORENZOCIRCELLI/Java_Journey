import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class BancoEstado implements Serializable {
    private static final long serialVersionUID = 1L;

    public List<Cliente> clientes;
    public Map<Cliente, List<ContaBancaria>> contas;

    public BancoEstado(List<Cliente> clientes, Map<Cliente, List<ContaBancaria>> contas) {
        this.clientes = clientes;
        this.contas = contas;
    }
}