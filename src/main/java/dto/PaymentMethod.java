package dto;

public enum PaymentMethod {
    BANK_TRANSFER("bank-transfer"),
    CASH_ON_DELIVERY("cash-on-delivery"),
    CREDIT_CARD("credit-card"),
    BUY_NOW_PAY_LATER("buy-now-pay-later"),
    GIFT_CARD("gift-card");

    private final String value;

    PaymentMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
