package exercise2;

public class VueloStatic {
    public String reservaVuelo(String destino, int pasajes, int dia, int mes, int anio) {
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        String mess;
        if (mes > 0 && mes < 13) {
            mess = meses[mes - 1];
        } else {
            return "mes incorrecto";
        }

        if (dia <= 0 || dia >= 32) {
            return "dia incorrecto";
        }

        if (anio < 2023) {
            return "anio incorrecto";
        }
        if (BDServiceStatic.existenPasajes(destino, pasajes)) {
            return String.format("el dia %s %d %s %d existen %d pasajes para %s", BDServiceStatic.getDay(dia, mes, anio), dia, mess, anio, pasajes, destino);
        } else {
            return String.format("no existen suficientes pasajes para %s", destino);
        }
    }
}
