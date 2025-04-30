import java.io.IOException;
import java.io.Serializable;

public class Tools implements Serializable{

    public static final long serialVersionUID = 1L;

    public void cleanScreen(){

        String sistema = System.getProperty("os.name").toLowerCase();

        try {
            if (sistema.contains("win")) {
                // Windows usa o comando "cls", mas precisa ser executado dentro do cmd
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Linux e macOS usam "clear"
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    
}
