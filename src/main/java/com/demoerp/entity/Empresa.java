package com.demoerp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "empresa")
public class Empresa implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "nome_fantasia", nullable = false, length = 80)
    private String nomeFantasia;

    @Column(name = "razao_social", nullable = false, length = 80)
    private String razaoSocial;

    @Column(nullable = false, length = 18)
    private String cnpj;

    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipo;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_fundacao")
    private Date dataFundacao;

    @ManyToOne
    @JoinColumn(name = "ramo_atividade_id")
    private RamoAtividade ramoAtividade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return id != null && id.equals(empresa.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
