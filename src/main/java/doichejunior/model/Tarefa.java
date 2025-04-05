package doichejunior.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "tb_tarefa")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String descricao;

    private boolean status;

    private Date dtAtribuicao;

    private Date dtFinalizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDtAtribuicao() {
        return dtAtribuicao;
    }

    public void setDtAtribuicao(Date dtAtribuicao) {
        this.dtAtribuicao = dtAtribuicao;
    }

    public Date getDtFinalizacao() {
        return dtFinalizacao;
    }

    public void setDtFinalizacao(Date dtFinalizacao) {
        this.dtFinalizacao = dtFinalizacao;
    }
}
