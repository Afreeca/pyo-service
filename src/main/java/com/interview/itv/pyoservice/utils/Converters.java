package com.interview.itv.pyoservice.utils;

import com.interview.itv.pyoservice.utils.Types.Profile;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

public abstract class Converters {

    @Converter(autoApply = true)
    public static class ProfileConverter implements AttributeConverter<Profile, String> {

        @Override
        public String convertToDatabaseColumn(Profile profile) {
            if (profile == null) {
                return null;
            }
            return profile.getProfile();
        }

        @Override
        public Profile convertToEntityAttribute(String name) {
            if (name == null) {
                return null;
            }

            return Stream.of(Profile.values())
                    .filter(c -> c.getProfile().equals(name))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
}
