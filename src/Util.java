import javax.swing.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static javax.swing.JOptionPane.*;

public class Util {
    private Controle controle = new Controle();

    public void menu() {

        int opcao;
        String menu = "1. Cadastrar novo funcionário\n2. Pesquisar por um funcionário\n3. Listar todos os funcionários";



        while (true) {
            opcao = parseInt(showInputDialog(null, menu));

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    pesquisar();
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    return; // finaliza o método
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }
    }

    private void pesquisar() {
        long matricula = parseLong(showInputDialog("Informe a matricula à ser pesquisada"));
        Empregado empregado = controle.pesquisar(matricula);

        if(empregado == null) {
            showMessageDialog(null, "Empregado não encontrado");
        } else {
            showMessageDialog(null, empregado.getDados());
        }
    }

    public void cadastrar() {
        long matricula = 0;
        String nome = "";
        int totalDeHorasTrabalhadas;
        double valorDaHoraTrabalhada;
        double totalDeVendas, comissao;
        String aux = "Deseja criar que tipo de empregado?\n1. Horista\n2. Comissionado\n3. Sair";

        while (true) {
            int opcao = parseInt(showInputDialog(aux));

            if (opcao == 1 || opcao == 2) {
                matricula = parseLong(showInputDialog("Informe a matrícula do empregado"));
                nome = showInputDialog("Digite o nome do empregado");
            } else if (opcao == 3) {
                return;
            } else {
                showMessageDialog(null,"Opção inválida");
            }

            switch (opcao) {
                case 1:
                    totalDeHorasTrabalhadas = parseInt(showInputDialog("Informe o total de horas trabalhadas do funcionario " + nome));
                    valorDaHoraTrabalhada = parseDouble(showInputDialog("Informe o valor da hora trabalhada"));
                    controle.inserir(new EmpregadoHorista(matricula, nome, totalDeHorasTrabalhadas, valorDaHoraTrabalhada));
                    break;
                case 2:
                    totalDeVendas = parseDouble(showInputDialog("Informe o total das vendas do funcionario " + nome));
                    comissao = parseDouble(showInputDialog("Informe a porcentagem de comissao"));
                    controle.inserir(new EmpregadoComissionado(matricula, nome, totalDeVendas, comissao));
                    break;
            }

        }

    }

    public void listar() {
        showMessageDialog(null, controle.listar());
    }
}
