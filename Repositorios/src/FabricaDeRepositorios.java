/**
 * Created by lucas on 24/03/16.
 */
public class FabricaDeRepositorios {

    private RepositorioGenerico<Cliente> clientes = new RepositorioClienteImplBD();


    public RepositorioGenerico<Cliente> getRepositorioCliente() {
        return clientes;
    }

}
