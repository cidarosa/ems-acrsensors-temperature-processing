package com.github.cidarosa.acrsensor.temperature.processing;

import com.github.cidarosa.acrsensor.temperature.processing.common.IdGenerator;
import com.github.cidarosa.acrsensor.temperature.processing.common.UUIDv7Utils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

class UUIDv7Test {

    @Test
    void shouldGenerateUUIDv7() {

        // UUID versão 7 tem a data de quando foi gerado

        UUID uuid = IdGenerator.generateTimeBasedUUID();
        OffsetDateTime uuidDateTIme = UUIDv7Utils.extractOffsetDateTime(uuid).truncatedTo(ChronoUnit.MINUTES);
        OffsetDateTime currentDateTime = OffsetDateTime.now().truncatedTo(ChronoUnit.MINUTES);

//        Assertions.assertEquals(uuidDateTIme, currentDateTime);

        Assertions.assertThat(uuidDateTIme).isEqualTo(currentDateTime);

        System.out.println("| ---- |");
        System.out.println("Data e hora extraída do uuid, pegando o que está no sistema");
        UUID uuid1 = IdGenerator.generateTimeBasedUUID();
        UUID uuid2 = IdGenerator.generateTimeBasedUUID();
        UUID uuid3 = IdGenerator.generateTimeBasedUUID();
        UUID uuid4 = IdGenerator.generateTimeBasedUUID();

        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid1));
        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid2));
        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid3));
        System.out.println(UUIDv7Utils.extractOffsetDateTime(uuid4));
        System.out.println("| ------- |");
        System.out.println(uuid1);
        System.out.println(uuid2);
        System.out.println(uuid3);
        System.out.println(uuid4);

    }
}
