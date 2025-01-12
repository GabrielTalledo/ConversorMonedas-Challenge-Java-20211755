import Herramientas.PrincipalTool;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        PrincipalTool principalTool = new PrincipalTool();
        principalTool.mostrarMenu();
    }
}
