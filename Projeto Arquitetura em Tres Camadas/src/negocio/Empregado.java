package negocio;

/**
 * Created by lucas on 11/04/16.
 */
public class Empregado {

    private int matricula;
    private String nomeInicial;
    private String nomeMeio;
    private String nomeFinal;
    private double salario;
    private String sexo;
    private int numSupervisor;
    private int numDepartamento;
    private String endereco;

    public Empregado(int matricula, String nomeInicial, String nomeMeio, String nomeFinal, double salario, String sexo, int numSupervisor, int numDepartamento, String endereco) {
        this.matricula = matricula;
        this.nomeInicial = nomeInicial;
        this.nomeMeio = nomeMeio;
        this.nomeFinal = nomeFinal;
        this.salario = salario;
        this.sexo = sexo;
        this.numSupervisor = numSupervisor;
        this.numDepartamento = numDepartamento;
        this.endereco = endereco;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNomeInicial() {
        return nomeInicial;
    }

    public void setNomeInicial(String nomeInicial) {
        this.nomeInicial = nomeInicial;
    }

    public String getNomeMeio() {
        return nomeMeio;
    }

    public void setNomeMeio(String nomeMeio) {
        this.nomeMeio = nomeMeio;
    }

    public String getNomeFinal() {
        return nomeFinal;
    }

    public void setNomeFinal(String nomeFinal) {
        this.nomeFinal = nomeFinal;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getNumSupervisor() {
        return numSupervisor;
    }

    public void setNumSupervisor(int numSupervisor) {
        this.numSupervisor = numSupervisor;
    }

    public int getNumDepartamento() {
        return numDepartamento;
    }

    public void setNumDepartamento(int numDepartamento) {
        this.numDepartamento = numDepartamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empregado empregado = (Empregado) o;

        if (getMatricula() != empregado.getMatricula()) return false;
        if (Double.compare(empregado.getSalario(), getSalario()) != 0) return false;
        if (getNumSupervisor() != empregado.getNumSupervisor()) return false;
        if (getNumDepartamento() != empregado.getNumDepartamento()) return false;
        if (!getNomeInicial().equals(empregado.getNomeInicial())) return false;
        if (getNomeMeio() != null ? !getNomeMeio().equals(empregado.getNomeMeio()) : empregado.getNomeMeio() != null)
            return false;
        if (!getNomeFinal().equals(empregado.getNomeFinal())) return false;
        if (!getSexo().equals(empregado.getSexo())) return false;
        return getEndereco() != null ? getEndereco().equals(empregado.getEndereco()) : empregado.getEndereco() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getMatricula();
        result = 31 * result + getNomeInicial().hashCode();
        result = 31 * result + (getNomeMeio() != null ? getNomeMeio().hashCode() : 0);
        result = 31 * result + getNomeFinal().hashCode();
        temp = Double.doubleToLongBits(getSalario());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getSexo().hashCode();
        result = 31 * result + getNumSupervisor();
        result = 31 * result + getNumDepartamento();
        result = 31 * result + (getEndereco() != null ? getEndereco().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Empregado{" +
                "matricula=" + matricula +
                ", nomeInicial='" + nomeInicial + '\'' +
                ", nomeMeio='" + nomeMeio + '\'' +
                ", nomeFinal='" + nomeFinal + '\'' +
                ", salario=" + salario +
                ", sexo='" + sexo + '\'' +
                ", numSupervisor=" + numSupervisor +
                ", numDepartamento=" + numDepartamento +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
