package br.com.albus.comum.pessoa;

public enum ETipoPessoa {
    PESSOA("pessoa"),
    JURIDICA("juridica"),
    FISICA("fisica");

    private String value;

    private ETipoPessoa(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
