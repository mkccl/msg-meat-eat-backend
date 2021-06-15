package de.mkccl.communityprojectbackend.storage.utils;

public enum BackgroundImageEnum {

    BACKGROUND1("pexels-francesco-ungaro-2325446.jpg"),
    BACKGROUND2("pexels-lumn-167699.jpg"),
    BACKGROUND3("pexels-philippe-donn-1242764.jpg"),
    BACKGROUND4("pexels-roberto-nickson-2559941.jpg"),
    BACKGROUND5("pexels-snapwire-6992.jpg"),
    ;

    private String value;

    BackgroundImageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
