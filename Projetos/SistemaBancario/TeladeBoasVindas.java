public class TeladeBoasVindas {
    
    public void welcome() {
        String mensagem = "Bem-vindo ao Sistema Bancário!";
        
        for (char c : mensagem.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(100); // espera 100 milissegundos entre cada letra
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("\n\nCarregando sistema...");
    }
}
