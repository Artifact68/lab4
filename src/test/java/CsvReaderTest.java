import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CsvReaderTest {

    @Test
    public void testReadPeopleFromCsv() throws Exception {
        CsvReader reader = new CsvReader();
        List<Person> people = reader.readPeopleFromCsv("test_names.csv", ';');

        // Проверяем, что список содержит 3 элемента
        assertEquals(3, people.size(), "Количество людей должно быть равно 3");

        // Проверяем первого человека
        Person person1 = people.get(0);
        assertEquals(1, person1.getId());
        assertEquals("Иван Иванов", person1.getName());
        assertEquals("Мужской", person1.getGender());
        assertEquals("Отдел продаж", person1.getDepartment().getName());
        assertEquals(50000, person1.getSalary());
        assertEquals("1985-04-15", person1.getBirthDate().toString());

        // Проверяем уникальность ID подразделений
        assertEquals(2, people.get(0).getDepartment().getId());
        assertEquals(1, people.get(1).getDepartment().getId());

        // Проверяем второго человека
        Person person2 = people.get(1);
        assertEquals(2, person2.getId());
        assertEquals("Анна Смирнова", person2.getName());
        assertEquals("Маркетинг", person2.getDepartment().getName());
        assertEquals(60000, person2.getSalary());
    }
}
