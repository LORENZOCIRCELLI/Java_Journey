public class Loading {

    public void loadingBar(){
        System.out.println();
        for(int i = 0 ; i <= 100 ; i++){
            System.out.print("\rCarregando... " + i + "%");
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("Carregamento Concluido!");
        System.out.println();
    }
    
}
