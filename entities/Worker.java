package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

    private String name;
    private WorkerLevel level;
    private double baseSalary;

    // no diagrama de classe o departament e hourContract é associados a classe
    // Worker, entao vamos cita-las nessa classe
    // por meio de uma composição
    // asociações, compowsição de objetos
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();; // worker pode ter varios contratos, entao foi criado uma
                                                               // lista
    // sempre ao criar lista, colocar o ArrayList<>();

    // nao se coloca lista no construtor, por isso nao esta a Lista contract, lembre
    // se disso
    public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }
    // nao podemos deixar o set contract, pois a lista quanndo instaciada
    // (ArrayList) ela começa com zero, e com os metodos
    // remove e add, posso adicionar e remover contratos dessa lista, mas ao criar o
    // set ela é trocada,
    // pois recece outra lista e ela é atribuida a lista de contratos do trabalhador
    // e nao se pode deixar isso acontecer, entao sempre remova o SET de listas

    // metodos:
    // esses metodos sao responsaveis por fazer e desfazer associaçao entre o
    // trabalhador e o contrato, ou seja,
    // fazer e desfazer(remover) o contrato da lista

    public void addContract(HourContract contract) {
        contracts.add(contract); // add lista no contrato

    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    // income é uma operação, total salario

    public double income(int year, int month) {
        double sum = baseSalary;

        // aqui, intanciamos um calendario
        Calendar cal = Calendar.getInstance();

        // fazer um for para cada contrato da lista de contrato, testar se o contrato
        // é do mesmo mes e ano, se for ele sera acrescentado na soma(sum)
        for (HourContract c : contracts) {

            cal.setTime(c.getDate()); // aqui peguei a data do contrato e coloquei no calendario

            int c_year = cal.get(Calendar.YEAR); // aqui peguei o ano da data mencinada (cal.setTime(c.getDate())

            // iniciamos com 1 + cal pois o mes do calendar começa com 0
            int c_month = 1 + cal.get(Calendar.MONTH); // aqui peguei o ano da data mencinada (cal.setTime(c.getDate())

            // testar se esse o ano e o mes sao iguais o ano e o mes do contrato, vai entrar
            // na soma
            if (year == c_year && month == c_month) {
                sum += c.totalValue();
            }

        }
        return sum;
    }

}
