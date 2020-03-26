package br.com.albus.generic.enums;

public enum EnumSimNao {
    S("Sim"),
    N("Não");

    private String value;

    private EnumSimNao(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
