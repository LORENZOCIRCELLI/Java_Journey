
public class MenuInicial {

    public void menuInicial(){

        
        Loading loading = new Loading();
        Tools tools = new Tools();

        tools.cleanScreen();

        loading.loadingBar();

        tools.cleanScreen();

        System.out.println("\n\n");

        String ANSI_BLUE = "\u001B[34m";
        String ANSI_RESET = "\u001B[0m";

        String[] asciiArt = {
            "██████╗  █████╗ ███╗   ██╗██╗  ██╗    ███████╗██╗   ██╗███████╗████████╗███████╗███╗   ███╗",
            "██╔══██╗██╔══██╗████╗  ██║██║ ██╔╝    ██╔════╝╚██╗ ██╔╝██╔════╝╚══██╔══╝██╔════╝████╗ ████║",
            "██████╔╝███████║██╔██╗ ██║█████╔╝     ███████╗ ╚████╔╝ ███████╗   ██║   █████╗  ██╔████╔██║",
            "██╔══██╗██╔══██║██║╚██╗██║██╔═██╗     ╚════██║  ╚██╔╝  ╚════██║   ██║   ██╔══╝  ██║╚██╔╝██║",
            "██████╔╝██║  ██║██║ ╚████║██║  ██╗    ███████║   ██║   ███████║   ██║   ███████╗██║ ╚═╝ ██║",
            "╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝    ╚══════╝   ╚═╝   ╚══════╝   ╚═╝   ╚══════╝╚═╝     ╚═╝",
            "                                                                                           "
        };

        for (String linha : asciiArt) {
            System.out.println(ANSI_BLUE + linha + ANSI_RESET);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("============================================================");
        System.out.println("                  BEM-VINDO AO BANCO DIGITAL                ");
        System.out.println("============================================================");
        System.out.println("      Segurança, praticidade e inovação ao seu alcance.     ");
        System.out.println("  Gerencie suas contas, faça transações e acompanhe saldos. ");
        System.out.println("------------------------------------------------------------");
        System.out.println("               O seu banco, do seu jeito.                   ");
        System.out.println("============================================================");
        System.out.println("                  Desenvolvido por:                         ");
        System.out.println("                  Lorenzo Circelli                          ");
        System.out.println("============================================================");
        
    }
    
}
