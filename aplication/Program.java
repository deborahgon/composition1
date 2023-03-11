package aplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
    public static void main(String[] args) throws Exception {

        // Ler os dados de um trabalhador com N contratos (N fornecido pelo usuário).
        // Depois, solicitar do usuário um mês e mostrar qual foi o salário do
        // funcionário nesse
        // mês

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // data instanciada no formato customizado(que eu
                                                                   // quero)

        SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");

        Department department = new Department();

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary: ");
        double baseSalary = sc.nextDouble();
        // instancie o obj depois de colocar os dados digitados

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
                new Department(departmentName));
        // instaciamos um novo objeto Worker, os dados desse objeto é o nome que foi
        // digitado (nome do empregago)
        // logo depois instaciamos um novo obj WorkerLevel, os dados é o nome
        // digitado(level)
        // baseSalary que foi digitado
        // associado a esse objeto(Worker) esta instaciado o Department e o dado é o
        // valor que digitei
        // obs: os valores que vai ser digitado esta no objeto instanciado e colocado
        // entre parenteses
        // para dizer que esta relacionado com o obj

        System.out.print("How many contract to this woker: ");

        int x = sc.nextInt();
        for (int i = 0; i < x; i++) {
            System.out.println("Enter contract #" + (1 + i) + " data:");
            System.out.print("Date (dd/mm/yyyy): ");
            // primeiro instanciar o SimpleDateFormat e colocar o formato desejado *esta
            // instanciado no inicio do cod
            // colocar o parse para conveter a string em data, e colocar a variavel data,
            // que nesse caso é o sc.next
            // pois ainda sera digitada
            Date contractDate = sdf.parse(sc.next()); // pode acontecer um erro de exceção, entao adicione a dclaração
                                                      // throws Exception no inicio
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            Integer hours = sc.nextInt();
            HourContract hContract = new HourContract(contractDate, valuePerHour, hours);
            // agoras temos que associar o hContract com o obj Worker
            worker.addContract(hContract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        // isso corta o string yearmonth e gera um substring com os dois digitos(do mes)
        // colocando as posições das variaveis por exemplo XX/YY a posição de cada é
        // X = 0, X=2 /= 3, Y=4, Y=5, e assim sucessivamente
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        // agr temos que converter esse substring para inteiro usando o Integer.parseInt

        int year = Integer.parseInt(monthAndYear.substring(3));// colocando a posição 3 o codigo ja vai pegar os
                                                               // adiantes

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName()); // primeiro instanciar o worker e pegar o
        // obj departament, e so ai pegar o dado que esta no obj departament, associado
        // no worker
        // isso é composição
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
        // tudo que esta associado a uma classe, chamar por ela primeiro

        sc.close();

    }
}
