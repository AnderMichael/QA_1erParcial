package exercise1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SalarioTest {

    static Salario salario;

    @BeforeAll
    public static void setValues() {
        salario = new Salario();
    }

    @ParameterizedTest
    @CsvSource({
            "10000, 8500",
            "4000, 3800",
            "3000, 2850",
            "1750, 1750",
            "0,0",
            "-3000, -1"})
    public void verifyMethodSalarioDescuento(double sueldo, double expected) throws Exception {
        if (sueldo < 0) {
            Assertions.assertThrows(Exception.class, () -> salario.salarioDescuento(sueldo));
        } else {
            double actual = salario.salarioDescuento(sueldo);
            Assertions.assertEquals(expected, actual, "Error en la devolución");
        }
    }
}
