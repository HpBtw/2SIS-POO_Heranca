public class Main {
    public static void main(String[] args) {
        Empregado[] empregado = new Empregado[3];

        empregado[0] = new EmpregadoComissionado(558975, "lu", 100, 10);
        empregado[1] = new EmpregadoHorista(559201, "roxa", 25, 50);
        empregado[2] = new EmpregadoHorista(559988, "vito", 30, 60);

        for (Empregado salario : empregado) {
            System.out.print(salario.getDados());
            System.out.println(salario.calcularSalario());
        }

    }
}
