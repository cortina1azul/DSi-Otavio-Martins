package psv;

public class PoliticoBean {

    private int id;
    private String nome;
    private String cargo;
    private String uf;
    private int anoFiliacao;

    public PoliticoBean() {
    }

    public PoliticoBean(String nome, String cargo, String uf, int anoFiliacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.uf = uf;
        this.anoFiliacao = anoFiliacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getAnoFiliacao() {
        return anoFiliacao;
    }

    public void setAnoFiliacao(int anoFiliacao) {
        this.anoFiliacao = anoFiliacao;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nome + " | " + cargo + " | " + uf
                + " | filiado desde " + anoFiliacao;
    }
}
