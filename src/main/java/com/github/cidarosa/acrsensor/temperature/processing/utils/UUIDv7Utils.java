package com.github.cidarosa.acrsensor.temperature.processing.utils;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;

public class UUIDv7Utils {

    private UUIDv7Utils() {
    }

    public static OffsetDateTime extractOffsetDateTime(UUID uuid){

        if(uuid == null){
            return null;
        }
        //bits do início
        // remover o bit da versão
        //utiliza operação com bits, bitwise
       long timestamp = uuid.getMostSignificantBits() >>> 16;

        return OffsetDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());

    }
}
