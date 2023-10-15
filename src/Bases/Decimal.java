package Bases;

public class Decimal extends Base {
    private int valor;

    public Decimal(String valor) {
        try {
            // Intentamos convertir la cadena en un valor decimal
            int valordec = Integer.parseInt(valor);

            // Comprobamos si el valor es un número válido en decimal (no negativo)
            if (valordec < 0) {
                throw new IllegalArgumentException("El valor debe ser un número decimal no negativo");
            }

            this.valor = valordec;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El valor ingresado no es un número decimal válido");
        }
    }

    public String getValor() {
        return Integer.toString(this.valor);
    }

    public String convertirHexadecimal() {
        return Integer.toHexString(valor).toUpperCase();
    }

    public String convertirOctal() {
        return Integer.toOctalString(valor);
    }

    public String convertirBinario() {
        return Integer.toBinaryString(valor);
    }


    public int convertirDecimal() {
        return this.valor;
    }
}