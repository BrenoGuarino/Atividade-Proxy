import org.example.BancoDeDados;
import org.example.Cliente;
import org.example.Funcionario;
import org.example.ClienteProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClienteProxyTest {

    @BeforeEach
    void setUp() {
        BancoDeDados.addCliente(new Cliente(1234, "Fulano", "Juiz de Fora", 80000, 300));
        BancoDeDados.addCliente(new Cliente(1233, "Ciclano", "Juiz de Fora", 100, 3000));
    }

    @Test
    void deveRetornarDadosPessoaisCliente() {
        ClienteProxy cliente = new ClienteProxy(1234);

        assertEquals(Arrays.asList("Fulano", "Juiz de Fora"), cliente.obterDadosPessoais());
    }

    @Test
    void deveRetonarContaBancariaCliente() {
        Funcionario funcionario = new Funcionario("Firmino", true);
        ClienteProxy cliente = new ClienteProxy(1233);

        assertEquals(Arrays.asList(100, 3000), cliente.obterContaBancaria(funcionario));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarContaBancariaCliente() {
        try {
            Funcionario funcionario = new Funcionario("Beltrano", false);
            ClienteProxy cliente = new ClienteProxy(1233);

            cliente.obterContaBancaria(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}