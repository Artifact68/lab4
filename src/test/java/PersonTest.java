import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testPersonCreation() {
        Department department = new Department("Отдел продаж");
        Person person = new Person(1, "Иван Иванов", "Мужской", department, 50000, LocalDate.of(1985, 4, 15));

        assertEquals(1, person.getId());
        assertEquals("Иван Иванов", person.getName());
        assertEquals("Мужской", person.getGender());
        assertEquals(department, person.getDepartment());
        assertEquals(50000, person.getSalary());
        assertEquals(LocalDate.of(1985, 4, 15), person.getBirthDate());
    }
}
