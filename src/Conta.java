import lombok.Getter;
import lombok.Setter;

public abstract class Conta implements IConta
{
    // atributos - ESTADO
    protected int numero;
    protected double saldo;

    protected int agencia;

    protected Cliente cliente;


    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Getter @Setter private String BankName;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }




    // métodos - COMPORTAMENTO
    public void sacar(double valor)
    {
        saldo -= valor;
    }

    public void depositar(double valor)
    {
        saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino)
    {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirHeaderSaldo() {
        System.out.println(String.format("Agência: %s", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %f", this.saldo));
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
    }

}