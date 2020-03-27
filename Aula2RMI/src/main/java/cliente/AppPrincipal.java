package cliente;

import comum.IServicoRemoto;
import comum.Pessoa;
import comum.Professor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AppPrincipal {

    public static void main(String[] args) {

        try {

            IServicoRemoto pessoa = (IServicoRemoto) Naming.lookup("rmi://localhost:8282/pessoa");

            Professor p1 = new Professor();
            p1.setId(1);
            p1.setNome("Pedro");
            p1.setTelefone("(12) 1234-5678");
            p1.setCidade("Araraquara");

            Professor p2 = new Professor();
            p2.setId(2);
            p2.setNome("Bruno");
            p2.setTelefone("(11) 4321-7656");
            p2.setCidade("São Carlos");

            pessoa.inserir(p1);
            pessoa.inserir(p2);

            for (Pessoa professor : pessoa.listarPessoa()) {
                System.out.println("ID: " + professor.getId());
                System.out.println("Nome: " + professor.getNome());
                System.out.println("Telefone: " + professor.getTelefone());
                System.out.println("Cidade: " + professor.getCidade());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }

}
