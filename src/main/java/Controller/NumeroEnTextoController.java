package Controller;

public class NumeroEnTextoController {
    private static final String[] UNIDADES = { "", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve" };
    private static final String[] DECENAS = { "", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa" };
    private static final String[] DIEZ_A_VEINTE = { "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve" };
    private static final String[] CENTENAS = { "", "ciento", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos" };
    private static final String[] MIL_CONECTORES = { "", "mil", "millón", "mil", "billón", "mil", "trillón", "mil", "cuatrillón", "mil" }; // y así sucesivamente...

    public static String convertirGrupoEnPalabras(Double numero) {
    if (numero == 0) {
        return "cero";
    }

    StringBuilder resultado = new StringBuilder();

    // Dividir el número en grupos de tres dígitos
    int grupo = 0;
    while (numero > 0) {
        int grupoActual = (int) (numero % 1000);
        if (grupoActual > 0) {
            String palabrasGrupo = convertirGrupoMenorEnPalabras(grupoActual);
            if (grupo > 0) {
                palabrasGrupo += " " + MIL_CONECTORES[grupo];
            }
            resultado.insert(0, palabrasGrupo + " ");
        }
        numero /= 1000;
        grupo++;
    }

    return resultado.toString().trim();
}

    private static String convertirGrupoMenorEnPalabras(int numero) {
    StringBuilder resultado = new StringBuilder();

    // Obtener las centenas
    int centenas = numero / 100;
    if (centenas > 0) {
        resultado.append(CENTENAS[centenas]);
    }

    // Obtener las decenas y unidades
    int decenasUnidades = numero % 100;
    if (decenasUnidades > 0) {
        if (centenas > 0) {
            resultado.append(" ");
        }
        if (decenasUnidades < 10) {
            resultado.append(UNIDADES[decenasUnidades]);
        } else if (decenasUnidades < 20) {
            resultado.append(DIEZ_A_VEINTE[decenasUnidades - 10]);
        } else {
            int decenas = decenasUnidades / 10;
            int unidades = decenasUnidades % 10;
            resultado.append(DECENAS[decenas]);
            if (unidades > 0) {
                resultado.append(" y ").append(UNIDADES[unidades]);
            }
        }
    }

    return resultado.toString().trim();
}
}
