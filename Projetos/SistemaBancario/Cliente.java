public class Cliente {

    private String name;
    private String CPF;
    private String address;
    private int password;

    public Cliente(String name, String CPF, String address, int password) {
        this.name = name;
        this.CPF = CPF;
        this.address = address;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public String getCPF() {
        return CPF;
    }
    public String getAddress() {
        return address;
    }
    public int getPassword() {
        return password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPassword(int password) {
        this.password = password;
    }

    
}
