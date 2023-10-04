package exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class VueloTest {
    static BDService bdService;
    static Vuelo vuelo;

    static VueloStatic vueloStatic;
    @BeforeAll
    public static void setValues() {
        bdService = Mockito.mock(BDService.class);
        vuelo = new Vuelo();
        vueloStatic =  new VueloStatic();
    }

    @ParameterizedTest
    @CsvSource({
            "La Paz, 2, 29, 5, 2023, true,el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz, Lunes",
            "La Paz, 2, 29, 5, 2023, false,no existen suficientes pasajes para La Paz, Lunes",
            "La Paz, 2, 29, 13, 2023, false,mes incorrecto, Lunes",
            "La Paz, 2, 29, -1, 2023, false,mes incorrecto, Lunes",
            "La Paz, 2, 32, 12, 2023, false,dia incorrecto, Lunes",
            "La Paz, 2, 31, 12, 2022, false,anio incorrecto, Lunes"

    })
    public void verifyValues(String destino, int pasajes, int dia, int mes, int anio, boolean pasajesBool, String expected, String day) {
        Mockito.when(bdService.existenPasajes(destino, pasajes)).thenReturn(pasajesBool);
        Mockito.when(bdService.getDay(dia, mes, anio)).thenReturn(day);
        vuelo.setBdService(bdService);
        String actual = vuelo.reservaVuelo(destino, pasajes, dia, mes, anio);
        Assertions.assertEquals(expected, actual, "Error en el string de retorno");

    }

    @ParameterizedTest
    @CsvSource({
            "La Paz, 2, 29, 5, 2023, true,el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz, Lunes",
            "La Paz, 2, 29, 5, 2023, false,no existen suficientes pasajes para La Paz, Lunes",
            "La Paz, 2, 29, 13, 2023, false,mes incorrecto, Lunes",
            "La Paz, 2, 29, -1, 2023, false,mes incorrecto, Lunes",
            "La Paz, 2, 32, 12, 2023, false,dia incorrecto, Lunes",
            "La Paz, 2, 31, 12, 2022, false,anio incorrecto, Lunes"

    })
    public void verifyValuesStatic(String destino, int pasajes, int dia, int mes, int anio, boolean pasajesBool, String expected, String day) {
        MockedStatic<BDServiceStatic> bdStatic = Mockito.mockStatic(BDServiceStatic.class);
        bdStatic.when(()->BDServiceStatic.existenPasajes(destino, pasajes)).thenReturn(pasajesBool);
        bdStatic.when(()->BDServiceStatic.getDay(dia, mes, anio)).thenReturn(day);
        String actual = vueloStatic.reservaVuelo(destino, pasajes, dia, mes, anio);
        Assertions.assertEquals(expected, actual, "Error en el string de retorno");

    }
}
