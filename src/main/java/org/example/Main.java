import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            CsvReader reader = new CsvReader();
            List<Person> people = reader.readPeopleFromCsv("foreign_names.csv", ';');

            // Вывод всех считанных людей
            people.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
