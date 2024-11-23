import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DepartmentTest {

    @Test
    public void testDepartmentCreation() {
        Department department1 = new Department("Отдел продаж");
        Department department2 = new Department("Маркетинг");

        // Проверяем правильность ID и имен
        assertEquals("Отдел продаж", department1.getName());
        assertEquals("Маркетинг", department2.getName());
        assertTrue(department1.getId() < department2.getId());
    }

    @Test
    public void testDepartmentEquality() {
        Department department1 = new Department("Отдел продаж");
        Department department2 = new Department("Отдел продаж");

        // Проверяем, что отделы считаются равными по имени
        assertEquals(department1, department2);

        // Проверяем, что hashCode совпадает
        assertEquals(department1.hashCode(), department2.hashCode());
    }
}
