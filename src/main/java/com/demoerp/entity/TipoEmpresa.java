package com.demoerp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoEmpresa {
    MEI("Microempreendedor Individual"),
    EIRELI("Empresa Individual de Responsabilidade Limitada"),
    LTDA("Sociedade Limitada"),
    SA("Sociedade Anônima");

    private final String descricao;
}
