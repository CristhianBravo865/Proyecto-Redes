package Bases;

public class Octal extends Base{
    private String valor;
    private int valordec;
    public Octal(String valor) {
        if (!valor.matches("^[0-7]+$")) {
            throw new IllegalArgumentException("El valor ingresado no es un número válido en octal");
        }
        this.valor = valor;
        this.valordec=Integer.parseInt(valor, 8);
    }

    public String getValor() {
        return valor;
    }

    public String convertirHexadecimal() {
        return Integer.toHexString(this.valordec).toUpperCase();
    }

    public String convertirBinario() {
        return Integer.toBinaryString(this.valordec);
    }

    public int convertirDecimal() {
        return this.valordec;
    }
    
    public String convertirOctal() {
        return this.valor;
    }
}