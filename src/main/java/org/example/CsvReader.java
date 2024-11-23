import com.opencsv.CSVReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CsvReader {
    public List<Person> readPeopleFromCsv(String csvFilePath, char separator) throws Exception {
        Map<String, Department> departmentMap = new HashMap<>();
        List<Person> people = new ArrayList<>();

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(csvFilePath);
             CSVReader reader = in == null ? null : new CSVReader(new InputStreamReader(in), separator)) {
            if (reader == null) {
                throw new FileNotFoundException("Файл не найден: " + csvFilePath);
            }

            String[] nextLine;
            reader.readNext(); // Пропускаем заголовок

            while ((nextLine = reader.readNext()) != null) {
                // ID;Имя;Пол;Подразделение;Зарплата;Дата рождения
                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                String gender = nextLine[2];
                String departmentName = nextLine[3];
                double salary = Double.parseDouble(nextLine[4]);
                LocalDate birthDate = LocalDate.parse(nextLine[5], DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                Department department = departmentMap.computeIfAbsent(departmentName, Department::new);
                Person person = new Person(id, name, gender, department, salary, birthDate);
                people.add(person);
            }
        }

        return people;
    }
}
