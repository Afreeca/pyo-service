package com.interview.itv.pyoservice.utils;

public abstract class Types {

    public enum Profile{
        ADULTS("Adults"),
        ADULTS_ABC1("Adults ABC1"),
        ADULTS_16_34("Adults 16 - 34"),
        MEN_ABC1("Men ABC1"),
        WOMAN("Women"),
        WOMAN_ABC1("Women ABC1"),
        WOMAN_16_34("Women 16 - 34"),
        HOUSEWIVES("Housewives"),
        HOUSEWIVES_ABC1("Housewives ABC1"),
        HOUSEWIVES_CHILDREN("Housewives with Children");

        private final String name;

        private Profile(String str){
            this.name = str;
        }

        public String getProfile() {
            return name;
        }
    }
}
