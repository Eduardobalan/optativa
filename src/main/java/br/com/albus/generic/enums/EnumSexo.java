package br.com.albus.generic.enums;

public enum EnumSexo {

    MASCULINO("Masculino"), FEMININO("Feminino");

    private String value;

    private EnumSexo(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
