package Bases; 

public class Hexadecimal extends Base{
    private String valor;
    private int valordec;
    public Hexadecimal(String valor) {
        if (!valor.matches("^[0-9A-Fa-f]+$")) {
            throw new IllegalArgumentException("El valor ingresado no es un número válido en hexadecimal");
        }
        this.valor = valor.toUpperCase(); 
        this.valordec=Integer.parseInt(valor, 16);
    }

    public String getValor() {
        return valor;
    }

    public String convertirBinario() {
        return Integer.toBinaryString(this.valordec);
    }

    public String convertirOctal() {
        return Integer.toOctalString(this.valordec);
    }

    public int convertirDecimal() {
        return this.valordec;
    }

    public String convertirHexadecimal() {
        return this.valor;
    }
    @Override
    public String toString() {
        return valor+" en hexadecimal";
    }
}