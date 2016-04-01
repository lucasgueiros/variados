package dominio;

/**
 * Created by lucas on 30/03/16.
 */
public class Pessoa {
    private String nome;
    private String cpf;
    private String nomeDaMae;

    public Pessoa(String nome, String cpf, String nomeDaMae) {
        this.nome = nome;
        this.cpf = cpf;
        this.nomeDaMae = nomeDaMae;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
        this.nomeDaMae = nomeDaMae;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (!getNome().equals(pessoa.getNome())) return false;
        if (!getCpf().equals(pessoa.getCpf())) return false;
        return getNomeDaMae().equals(pessoa.getNomeDaMae());

    }

    @Override
    public int hashCode() {
        int result = getNome().hashCode();
        result = 31 * result + getCpf().hashCode();
        result = 31 * result + getNomeDaMae().hashCode();
        return result;
    }
}
