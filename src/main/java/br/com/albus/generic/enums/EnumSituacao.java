package br.com.albus.generic.enums;

public enum EnumSituacao {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String value;

    private EnumSituacao(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
