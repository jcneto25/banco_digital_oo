public class Main {
    public static void main(String[] args) throws Exception {

        Cliente fulano = new Cliente();
        fulano.setNome("Jaime");

        Conta cc = new ContaCorrente(fulano);
        Conta Poupanca = new ContaPoupanca(fulano);
        cc.imprimirSaldo();
    }
}
