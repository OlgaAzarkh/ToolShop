package dto;

public enum CountryCode {
    AL("Albania"),
    AX("Åland Islands"),
    DZ("Algeria"),
    AS("American Samoa"),
    AD("Andorra"),
    AO("Angola"),
    AI("Anguilla"),
    AQ("Antarctica"),
    AG("Antigua and Barbuda"),
    AR("Argentina"),
    AM("Armenia"),
    AW("Aruba"),
    AU("Australia"),
    AT("Austria"),
    AZ("Azerbaijan"),
    BS("Bahamas"),
    BH("Bahrain"),
    BD("Bangladesh"),
    BB("Barbados"),
    BY("Belarus"),
    BE("Belgium"),
    BZ("Belize"),
    BJ("Benin"),
    BM("Bermuda"),
    BT("Bhutan");

    private final String displayName;

    CountryCode(String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return displayName;
    }
}

