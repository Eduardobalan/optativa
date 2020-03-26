package br.com.albus.comum.endereco;

public enum EnumTipoEndereco {
    CASA("Casa"),
    TRABALHO("Trabalho"),
    FAZENDA("Fazenda");

    private String value;

    private EnumTipoEndereco(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
