package exercise2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class VueloTest {
    static BDService bdService;
    static Vuelo vuelo;

    @BeforeAll
    public static void setValues() {
        bdService = Mockito.mock(BDService.class);
        vuelo = new Vuelo();
    }

    @ParameterizedTest
    @CsvSource({
            "La Paz, 2, 29, 5, 2023, el dia Lunes 29 de Mayo 2023 existen 2 pasajes para La Paz"
    })
    public void verifyValues(String destino, int pasajes, int dia, int mes, int anio) {
        Mockito.when(bdService.existenPasajes(destino, pasajes));
        Mockito.when(bdService.getDay(dia, mes, anio)).thenReturn("Lunes");
        vuelo.setBdService(bdService);
    }
}
