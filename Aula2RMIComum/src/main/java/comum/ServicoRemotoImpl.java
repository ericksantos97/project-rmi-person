package comum;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServicoRemotoImpl extends UnicastRemoteObject implements IServicoRemoto {

    private static final long serialVersionUID = -4271005113433446707L;
    private static List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public ServicoRemotoImpl() throws RemoteException {
    }

    @Override
    public void inserir(Pessoa pessoa) throws RemoteException {
        pessoas.add(pessoa);
    }

    @Override
    public List<Pessoa> listarPessoa() throws RemoteException {
        return pessoas;
    }
}
