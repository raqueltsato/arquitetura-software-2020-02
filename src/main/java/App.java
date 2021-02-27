import java.util.Scanner;

public class App {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String textura;

        System.out.println("Escolha a textura de solo, digitando:");
        System.out.println("1 - para solo argiloso");
        System.out.println("2 - para solo textura média");
        textura = scan.nextLine();
        imprimeTextura(textura);



    }

    private static void imprimeTextura(String textura) {
        if (textura.equals("1") ) {
            System.out.printf("SOLO ARGILOSO");
        } else if(textura.equals("2") ) {
            System.out.printf("SOLO TEXTURA MÉDIA");
        } else {
            System.out.printf("Você deve escolher 1 ou 2");
            return;
        }
    }
}
