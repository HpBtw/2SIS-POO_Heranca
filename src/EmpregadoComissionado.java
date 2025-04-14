public class EmpregadoComissionado extends Empregado {
    double totalDeVendas;
    double comissao;

    public EmpregadoComissionado(long matricula, String nome, double totalDeVendas, double comissao){
            super(matricula, nome); // chamada para o construtor da super classe
            this.totalDeVendas = totalDeVendas;
            this.comissao = comissao;
    }

    public double calcularSalario() {
        return totalDeVendas * comissao / 100;
    }

    @Override
    public String getDados() {
        return super.getDados() + " -- " + totalDeVendas + " -- " + comissao + " -- ";
        // esse getDados vai retornar os valores ja estipulados da superclasse (nome e matricula)
        // usa-se esse metodo para reaproveitar os metodos da classe super, adicionando um retorno de dados adequado
        // pra essa classe

    }
}
