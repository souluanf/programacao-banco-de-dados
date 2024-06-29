package dev.luanfernandes.pizzaria.domain.util;

import java.security.SecureRandom;

public class CodigoEntregaGenerator {
    private static final SecureRandom random = new SecureRandom();
    private static final String FORMAT = "%03d-%03d";

    public static String generateCodigoEntrega() {
        int part1 = random.nextInt(1000);
        int part2 = random.nextInt(1000);
        return String.format(FORMAT, part1, part2);
    }
}
