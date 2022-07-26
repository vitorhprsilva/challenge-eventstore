import domain.TextFile;
import main.MainEvent;
import java.util.Scanner;

public class main {
    public static void main(String[] args)  {
        Scanner read = new Scanner(System.in);
        MainEvent mainEvent = new MainEvent(new TextFile("eventFile"));
        while (true) {
            System.out.print("##--Menu de escolhas--##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Novo evento       |\n");
            System.out.print("| Opção 2 - Apagar evento     |\n");
            System.out.print("| Opção 3 - Sair              |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");
            int option = read.nextInt();
            if (option == 3) break;
            mainEvent.makeEvent(option);
        }

    }
}
