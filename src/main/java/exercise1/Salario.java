package exercise1;

public class Salario {

    public double salarioDescuento(double salario) throws Exception {
        if (salario >= 0) {
            if (salario > 4000) {
                double discount = salario - salario * (3.0 / 20.0);
                return discount;
            } else if (salario > 2000) {
                double discount = salario - salario / 20.0;
                return discount;
            } else {
                return salario;
            }
        } else {
            throw new Exception("Salario Invalido");
        }
    }
}
