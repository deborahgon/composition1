package entities;

public class Department {

    // ao criar a classe é importante sempre criar o contrutor vazio e um com
    // argumentos
    private String name;

    public Department() {

    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
