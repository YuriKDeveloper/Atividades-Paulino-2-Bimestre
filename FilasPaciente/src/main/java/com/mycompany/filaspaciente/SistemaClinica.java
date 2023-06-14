import javax.swing.JOptionPane;

public class SistemaClinica {
    private static final int TAMANHO_FILA = 20;
    private static String[] filaPacientes = new String[TAMANHO_FILA];
    private static int indiceInicio = 0;
    private static int indiceFim = 0;

    public static void main(String[] args) {
        int opcao;
        do {
            String opcaoStr = JOptionPane.showInputDialog(
                "=== Menu ===\n" +
                "1 - Adicionar paciente\n" +
                "2 - Chamar próximo paciente\n" +
                "0 - Sair\n" +
                "Digite a opção desejada:"
            );

            opcao = Integer.parseInt(opcaoStr);

            switch (opcao) {
                case 1:
                    String nomePaciente = JOptionPane.showInputDialog("Digite o nome do paciente:");
                    adicionarPaciente(nomePaciente);
                    break;
                case 2:
                    chamarProximoPaciente();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Digite novamente.");
            }

        } while (opcao != 0);
    }

    private static void adicionarPaciente(String nomePaciente) {
        if (indiceFim - indiceInicio == TAMANHO_FILA) {
            JOptionPane.showMessageDialog(null, "A fila de pacientes está cheia. Não é possível adicionar mais pacientes.");
        } else {
            filaPacientes[indiceFim % TAMANHO_FILA] = nomePaciente;
            indiceFim++;
            JOptionPane.showMessageDialog(null, "Paciente " + nomePaciente + " adicionado à fila com sucesso.");
        }
    }

    private static void chamarProximoPaciente() {
        if (indiceInicio == indiceFim) {
            JOptionPane.showMessageDialog(null, "A fila de pacientes está vazia.");
        } else {
            String proximoPaciente = filaPacientes[indiceInicio % TAMANHO_FILA];
            indiceInicio++;
            JOptionPane.showMessageDialog(null, "Próximo paciente: " + proximoPaciente);
        }
    }
}