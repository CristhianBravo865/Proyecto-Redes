package Bases;

public class Binario extends Base {
    private String valor;
    private int valordec;

    public Binario(String valor) {
        if (!valor.matches("^[01]+$")) {
            throw new IllegalArgumentException("El valor ingresado no es un número válido en binario");
        }
        this.valor = valor;
        this.valordec = Integer.parseInt(valor, 2);
    }

    public String getValor() {
        return valor;
    }

    public String convertirHexadecimal() {
        return Integer.toHexString(valordec).toUpperCase();
    }

    public String convertirOctal() {
        return Integer.toOctalString(valordec);
    }

    public int convertirDecimal() {
        return this.valordec;
    }

    public String convertirBinario() {
        return this.valor;
    }

    @Override
    public String toString() {
        return valor+" en binario";
    }

}
