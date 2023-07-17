import Sistema.Agencia;
import Sistema.Banco;
import Sistema.Cliente;
import Sistema.Conta;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

        static int codigocliente = 1;

        static int codigobanco = 1;

        static int digitoagencia = 1;

        static int codigoagencia = 1;

        static int numeroconta = 1;

        static int digitoconta = 1;


        static Scanner teclado = new Scanner(System.in);
        static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        static ArrayList<Banco> bancos = new ArrayList<Banco>();
        static ArrayList<Conta> contas = new ArrayList<Conta>();
        static ArrayList<Agencia> agencias = new ArrayList<Agencia>();

        public static void main(String[] args) {

                while (true) {

                        limpatela();
                        System.out.println("\n                                     ===== MENU =====\n");
                        System.out.println(" ==================     ==================     ==================     ================== ");
                        System.out.println("|                  |   |                  |   |                  |   |                  |");
                        System.out.println("|                  |   |                  |   |                  |   |                  |");
                        System.out.println("|   1 Clientes     |   |    2 Bancos      |   |     3 Listar     |   |      4 Sair      |");
                        System.out.println("|                  |   |                  |   |                  |   |                  |");
                        System.out.println("|                  |   |                  |   |                  |   |                  |");
                        System.out.println(" ==================     ==================     ==================     ================== ");
                        System.out.println("\nDesja fazer qual operação?");
                        System.out.print("R: ");
                        int menuVerifica;
                        try {
                                teclado = new Scanner(System.in);
                                menuVerifica = teclado.nextInt();
                                teclado.nextLine();

                        } catch (InputMismatchException exception) {
                                System.out.println("Caracter inserido não compatível!");
                                continue;
                        }
                        if (menuVerifica == 4) {
                                limpatela();
                                System.out.println("Flw...");
                                break;
                        } else {
                                switch (menuVerifica) {
                                        case 1:
                                                menuClientes();
                                                break;
                                        case 2:
                                                menuBancos();
                                                break;
                                        case 3:
                                                listar();
                                                break;


                                }
                        }
                }
        }

        public static void listar() {

                int cl = 1;
                int co = 1;
                int ba = 1;
                int ag = 1;
                for (Cliente c: clientes) {
                        System.out.println("=================================");
                        System.out.println("          Cliente "+ cl);
                        System.out.println("Nome: "+c.getNome());
                        System.out.println("Logradouro: "+c.getLogradouro());
                        System.out.println("CPF: "+c.getCPF());
                        System.out.println("Bairro: "+c.getBairro());
                        System.out.println("Cep: "+c.getCep());
                        System.out.println("Cidade: "+c.getCidade());
                        System.out.println("Estado: "+c.getUf());
                        System.out.println("=================================\n");
                        cl++;
                }
                for (Conta cc: contas) {
                        System.out.println("=================================");
                        System.out.println("         Conta "+ co);
                        System.out.println("Cliente: "+cc.getCliente());
                        System.out.println("Tipo de conta: "+cc.getTipoConta());
                        System.out.println("Saldo: "+cc.getSaldo());
                        System.out.println("Limite: "+cc.getLimite());
                        System.out.println("=================================\n");
                        co++;
                }

                for (Banco b: bancos) {
                        System.out.println("=================================");
                        System.out.println("          Banco "+ ba);
                        System.out.println("Numero: "+b.getNumero());
                        System.out.println("Nome: "+b.getNome());
                        System.out.println("=================================\n");
                        ba++;
                }
                for (Agencia a: agencias) {
                        System.out.println("=================================");
                        System.out.println("          Agencia "+ ag);
                        System.out.println("Numero: "+a.getNumero());
                        System.out.println("Digito: "+a.getDigito());
                        System.out.println("Codigo: "+a.getCodigo());
                        System.out.println("Nome: "+a.getNome());
                        System.out.println("Banco: "+a.getBanco());
                        System.out.println("Logradouro: "+a.getLogradouro());
                        System.out.println("Bairro: "+a.getBairro());
                        System.out.println("Cep: "+a.getCep());
                        System.out.println("Cidade: "+a.getCidade());
                        System.out.println("Estado: "+a.getEstado());
                        System.out.println("=================================\n");
                        ag++;
                }
                teclado.nextLine();
        }

        private static void limpatela() {
                for (int i = 0; i <= 100; i++) {
                        System.out.println("");
                }
        }
        public static void menuClientes() {

                limpatela();
                while (true) {

                        limpatela();
                        System.out.println("\n                       ===== CLIENTES =====\n");
                        System.out.println(" ==================     ==================     ================== ");
                        System.out.println("|                  |   |                  |   |                  |");
                        System.out.println("|                  |   |                  |   |                  |");
                        System.out.println("|   1 Cadastrar    |   |    2 Consultar   |   |     3 Voltar     |");
                        System.out.println("|                  |   |                  |   |                  |");
                        System.out.println("|                  |   |                  |   |                  |");
                        System.out.println(" ==================     ==================     ================== ");
                        System.out.println("\nDesja fazer qual operação?");
                        System.out.print("R: ");
                        int clienteVerifica;
                        try {
                                teclado = new Scanner(System.in);
                                clienteVerifica = teclado.nextInt();
                                teclado.nextLine();

                        } catch (InputMismatchException exception) {
                                System.out.println("Caracter inserido não compatível!");
                                continue;
                        }
                        if (clienteVerifica == 3) {
                                break;
                        } else {
                                switch (clienteVerifica) {
                                        case 1:
                                                cadastrarCliente();
                                                break;

                                        case 2:
                                                if (clientes.size() > 0) {
                                                        telaconsultacliente();
                                                } else {
                                                        cadastrarCliente();
                                                }
                                                break;
                                }
                        }
                }
        }
        public static void cadastrarCliente() {

                limpatela();
                System.out.println(" ====================== ");
                System.out.println("| CADASTRO DE CLIENTES |");
                System.out.println(" ====================== ");
                System.out.print("\nNome: ");
                String nome = teclado.next();
                System.out.print("Logradouro: ");
                String logradouro = teclado.next();
                System.out.print("Cpf: ");
                String CPF = teclado.next();
                //Retirado por motivo de anonimato
                /*while (!Cliente.ValidaCpf(CPF)) {
                        System.out.println("Digite um cpf valido!");
                        System.out.print("R: ");
                        CPF = teclado.next();
                }*/
                System.out.print("Bairro: ");
                String bairro = teclado.next();
                System.out.print("Cep: ");
                String cep = teclado.next();
                System.out.print("Cidade: ");
                String cidade = teclado.next();
                System.out.print("Estado: ");
                String uf = teclado.next();
                Cliente cliente = new Cliente(codigocliente,nome,logradouro,CPF,bairro,cep,cidade,uf);
                clientes.add(cliente);
                codigocliente++;
        }
        public static void telaconsultacliente() {

                limpatela();
                System.out.println(" ====================== ");
                System.out.println("| CONSULTA DE CLIENTES |");
                System.out.println(" ====================== ");
                System.out.println("Digite um dado referente ao cliente");
                System.out.print("R: ");
                String verifica = teclado.next();
                Cliente cliente = consultarCliente(verifica);
                if (cliente == null) {
                        telaconsultacliente();
                } else {

                        System.out.println("\n=================================");
                        System.out.println("Id "+consultarCliente(verifica).getCodigo());
                        System.out.println("Nome: "+consultarCliente(verifica).getNome());
                        System.out.println("Logradouro: "+consultarCliente(verifica).getLogradouro());
                        System.out.println("CPF: "+consultarCliente(verifica).getCPF());
                        System.out.println("Bairro: "+consultarCliente(verifica).getBairro());
                        System.out.println("Cep: "+consultarCliente(verifica).getCep());
                        System.out.println("Cidade: "+consultarCliente(verifica).getCidade());
                        System.out.println("Estado: "+consultarCliente(verifica).getUf());
                        System.out.println("=================================");
                        teclado.nextLine();
                        teclado.nextLine();

                }
        }

        public static Cliente consultarCliente(String dadoCliente) {

                Cliente cliente = null;
                for (Cliente c: clientes) {
                        if(Objects.equals(c.getCep(), dadoCliente) || Objects.equals(c.getCPF(), dadoCliente) || Objects.equals(c.getNome(), dadoCliente) ||
                                Objects.equals(c.getUf(), dadoCliente) || Objects.equals(c.getCidade(), dadoCliente) ||
                                Objects.equals(c.getLogradouro(), dadoCliente) || Objects.equals(c.getBairro(), dadoCliente)) {

                                cliente = c;
                        }
                }
                return cliente;
        }

        public static Cliente consultarClienteConta(String dadoClienteConta) {

                Cliente cliente = null;
                for (Cliente c: clientes) {
                        if(Objects.equals(c.getNome(), dadoClienteConta)) {

                                cliente = c;
                        }
                }
                return cliente;
        }

        public static Conta consultarConta(String dadoConta) {

                Conta conta = null;
                for (Conta c:  contas) {
                        if(Objects.equals(c.getCliente(), dadoConta)) {

                                conta = c;
                        }
                }
                return conta;
        }

        public static Banco consultarBanco(String dadoBanco) {

                Banco banco = null;
                for (Banco b: bancos) {
                        if(Objects.equals(b.getNome(), dadoBanco)) {

                                banco = b;
                        }
                }
                return banco;
        }

        public static void menuBancos() {

                limpatela();
                while (true) {

                        limpatela();
                        System.out.println("\n                                    ===== BANCOS =====\n");
                        System.out.println(" ==================     ==================     ==================     ================== ");
                        System.out.println("|                  |   |                  |   |                  |   |                  |");
                        System.out.println("|                  |   |                  |   |                  |   |                  |");
                        System.out.println("|     1 Banco      |   |    2 Agencia     |   |     3 Conta      |   |      4 Sacar     |");
                        System.out.println("|                  |   |                  |   |                  |   |                  |");
                        System.out.println("|                  |   |                  |   |                  |   |                  |");
                        System.out.println(" ==================     ==================     ==================     ================== ");
                        System.out.println(" ==================     ==================     ================== ");
                        System.out.println("|                  |   |                  |   |                  |");
                        System.out.println("|                  |   |                  |   |                  |");
                        System.out.println("|   5 Depositar    |   |   6 Transferir   |   |     7 Voltar     |");
                        System.out.println("|                  |   |                  |   |                  |");
                        System.out.println("|                  |   |                  |   |                  |");
                        System.out.println(" ==================     ==================     ================== ");
                        System.out.println("\nDesja fazer qual operação?");
                        System.out.print("R: ");
                        int bancoVerifica;
                        try {
                                teclado = new Scanner(System.in);
                                bancoVerifica = teclado.nextInt();
                                teclado.nextLine();

                        } catch (InputMismatchException exception) {
                                System.out.println("Caracter inserido não compatível!");
                                continue;
                        }
                        if (bancoVerifica == 7) {
                                break;
                        } else {
                                switch (bancoVerifica) {
                                        case 1:
                                                cadastrarBanco();
                                                break;
                                        case 2:
                                                if (bancos.size() > 0) {
                                                        cadastrarAgencia();

                                                } else {
                                                        cadastrarBanco();
                                                }
                                                break;
                                        case 3:
                                                if (clientes.size() > 0) {
                                                        cadastrarConta();
                                                } else {
                                                        cadastrarCliente();
                                                }
                                                break;

                                        case 4:
                                                if (clientes.size() < 1) {
                                                        cadastrarCliente();

                                                } else if (contas.size() < 1) {
                                                        cadastrarConta();

                                                } else {
                                                        sacar();

                                                }
                                                break;
                                        case 5:
                                                if (clientes.size() < 1) {
                                                        cadastrarCliente();

                                                } else if (contas.size() < 1) {
                                                        cadastrarConta();

                                                } else {
                                                        Depositar();

                                                }
                                                break;
                                        case 6:
                                                if (clientes.size() < 2) {
                                                        cadastrarCliente();

                                                } else if (contas.size() < 2) {
                                                        cadastrarConta();

                                                } else {
                                                        Transferir();

                                                }
                                                break;


                                }
                        }
                }
        }

        public static void cadastrarBanco() {

                limpatela();
                System.out.println(" ====================== ");
                System.out.println("|  CADASTRO DE BANCOS  |");
                System.out.println(" ====================== ");
                System.out.print("\nNome: ");
                String nome = teclado.next();
                Banco banco = new Banco(codigobanco,nome);
                bancos.add(banco);
                codigobanco++;

        }
        public static void cadastrarAgencia() {

                limpatela();
                System.out.println(" ====================== ");
                System.out.println("| CADASTRO DE AGENCIAS |");
                System.out.println(" ====================== ");
                System.out.print("\nNome: ");
                String nome = teclado.next();
                System.out.println("\nEssas são as opções de bancos");
                for (Banco b: bancos) {
                        System.out.println(b.getNumero()+" "+ b.getNome());
                }
                System.out.print("\nBanco: ");
                String banco = teclado.next();
                Banco banco1 = consultarBanco(banco);
                if (banco1 == null) {
                        cadastrarAgencia();

                } else {
                        System.out.print("\nLogradouro: ");
                        String logradouro = teclado.next();
                        System.out.print("\nNumero: ");
                        String numero = teclado.next();
                        System.out.print("\nBairro: ");
                        String bairro = teclado.next();
                        System.out.print("\nCep: ");
                        String cep = teclado.next();
                        System.out.print("\nCidade: ");
                        String cidade = teclado.next();
                        System.out.print("\nEstado: ");
                        String estado = teclado.next();

                        Agencia agencia = new Agencia(digitoagencia,codigoagencia,nome,banco1.getNome(),logradouro,numero,bairro,cep,cidade,estado);
                        agencias.add(agencia);
                        codigoagencia++;
                        digitoagencia++;

                }
        }

        public static void cadastrarConta() {

                limpatela();
                System.out.println(" ====================== ");
                System.out.println("|  CADASTRO DE CONTAS  |");
                System.out.println(" ====================== ");
                System.out.println("\nEsses são os clientes cadastrados");
                for (Cliente c: clientes) {
                        System.out.println(c.getCodigo()+" "+ c.getNome());
                }
                System.out.print("Cliente: ");
                String cliente = teclado.next();
                Cliente cliente1 = consultarClienteConta(cliente);
                if (cliente1 == null) {
                        cadastrarConta();
                } else {

                        System.out.println("Os tipos de conta são: 1 Deposito | 2 Pagamento | 3 Corrente | 4 Poupança");
                        System.out.print("Tipo de conta: ");
                        int tipodeconta = teclado.nextInt();

                        while (tipodeconta != 1 && tipodeconta != 2 && tipodeconta != 3 && tipodeconta != 4) {
                                System.out.println("Tipo de conta invalido");
                                System.out.print("R: ");
                                tipodeconta = teclado.nextInt();
                        }
                        String Tipodeconta = null;
                        switch (tipodeconta) {
                                case 1:
                                        Tipodeconta = "deposito";
                                        break;
                                case 2:
                                        Tipodeconta = "pagamento";
                                        break;
                                case 3:
                                        Tipodeconta = "corrente";
                                        break;
                                case 4:
                                        Tipodeconta = "poupança";
                                        break;
                        }
                        Conta conta = new Conta(numeroconta,digitoconta,cliente,Tipodeconta);
                        contas.add(conta);
                        numeroconta++;
                        digitoconta++;

                }
        }

        public static void sacar() {

                limpatela();
                System.out.println(" ====================== ");
                System.out.println("|         SAQUE        |");
                System.out.println(" ====================== ");
                System.out.println("Selecione uma conta! (Digite o nome da conta)");
                for (Conta c: contas) {
                        System.out.println(c.getNumero() +" "+ c.getCliente());
                }
                System.out.print("R: ");
                String cliente = teclado.next();
                Conta conta1 = consultarConta(cliente);
                if (conta1 == null) {
                        sacar();
                } else {
                        while (true) {

                                System.out.println("Seu saldo é "+conta1.getSaldo());
                                System.out.println("Quanto deseja sacar?");
                                System.out.print("R: ");
                                float sacar;
                                try {
                                        teclado = new Scanner(System.in);
                                        sacar = teclado.nextFloat();
                                        teclado.nextLine();

                                } catch (InputMismatchException exception) {
                                        System.out.println("\nCaracter inserido não compatível!");
                                        continue;
                                }
                                while (!conta1.saca(sacar)) {
                                        System.out.println("Saldo insuficiente!");
                                        System.out.print("R: ");
                                        sacar = teclado.nextFloat();
                                }
                                System.out.println("Saldo atual: "+conta1.getSaldo());
                                teclado.nextLine();
                                break;
                        }
                }

        }

        public static void Depositar() {

                limpatela();
                System.out.println(" ====================== ");
                System.out.println("|       DEPOSITO       |");
                System.out.println(" ====================== ");
                System.out.println("Selecione uma conta! (Digite o nome da conta)");
                for (Conta c: contas) {
                        System.out.println(c.getNumero() +" "+ c.getCliente());
                }
                System.out.print("R: ");
                String cliente = teclado.next();
                Conta conta1 = consultarConta(cliente);
                if (conta1 == null) {
                        Depositar();
                } else {

                        while (true) {

                                System.out.println("Seu saldo é "+conta1.getSaldo());
                                System.out.println("Quanto deseja depositar?");
                                System.out.print("R: ");
                                float depositar;
                                try {
                                        teclado = new Scanner(System.in);
                                        depositar = teclado.nextFloat();
                                        teclado.nextLine();

                                } catch (InputMismatchException exception) {
                                        System.out.println("\nCaracter inserido não compatível!");
                                        continue;
                                }
                                conta1.deposita(depositar);
                                System.out.println("Saldo atual: "+conta1.getSaldo());
                                teclado.nextLine();
                                break;
                        }
                }
        }
        public static void Transferir() {

                limpatela();
                System.out.println(" ====================== ");
                System.out.println("|     TRANSFERENCIA    |");
                System.out.println(" ====================== ");
                System.out.println("Selecione uma conta! (Digite o nome da conta)");
                for (Conta c: contas) {
                        System.out.println(c.getNumero() +" "+ c.getCliente());
                }
                System.out.print("R: ");
                String nomeCliente = teclado.next();
                Conta conta2 = consultarConta(nomeCliente);
                System.out.println("Deseja transferir para qual cliente?");
                System.out.print("R: ");
                String transferiCliente = teclado.next();
                Conta conta3 = consultarConta(transferiCliente);
                if (conta2 == null || conta3 == null) {
                        Transferir();
                } else {

                        while (true) {

                                System.out.println("Seu saldo é "+conta2.getSaldo());
                                System.out.println("Quanto deseja Transferir?");
                                System.out.print("R: ");
                                float transferir;
                                try {
                                        teclado = new Scanner(System.in);
                                        transferir = teclado.nextFloat();
                                        teclado.nextLine();

                                } catch (InputMismatchException exception) {
                                        System.out.println("\nCaracter inserido não compatível!");
                                        continue;
                                }

                                conta2.transfere(conta3,transferir);
                                System.out.println("Saldo atual: "+conta2.getSaldo());
                                teclado.nextLine();
                                break;
                        }
                }
        }
}