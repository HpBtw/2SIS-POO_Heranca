public abstract class Empregado {
    long matricula;
    String nome;

    public Empregado (long matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public abstract double calcularSalario();
    // metodo sem corpo, feito somente para chamar métodos que existam nas classes que
    // herdam métodos em comum (esse método esta presente tanto no comissionado quanto
    // no horista), o retorno será relativo à subclasse em questão (alternança do tipo
    // do 'salario' no foreach do Main

    public String getDados() { // métodos na superclasse existem em todas as suas classes 'filhas'
        return matricula + " -- " + nome + " -- ";
    }
}
