import com.sgr.dados.*;
import com.sgr.negocio.base.*;
import com.sgr.negocio.services.*;

public class Fachada {
    public static final ClienteRepo clienteRepo = new ClienteRepo();
    public static final ItemRepo itemRepo = new ItemRepo();
    public static final PagamentoRepo pagamentoRepo = new PagamentoRepo();
    public static final PedidoRepo pedidoRepo = new PedidoRepo(
        clienteRepo, itemRepo, pagamentoRepo
    );

    public Fachada() {
        clienteRepo.carregar();
        itemRepo.carregar();
        pagamentoRepo.carregar();

        // Pedido por último pois requer os outros
        pedidoRepo.carregar();
    }
}