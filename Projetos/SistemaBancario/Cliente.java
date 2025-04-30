
import java.io.Serializable;

public class Cliente implements Serializable{

    public static final long serialVersionUID = 1L;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (CPF == null) {
            if (other.CPF != null)
                return false;
        } else if (!CPF.equals(other.CPF))
            return false;
        return true;
    }

    
}
