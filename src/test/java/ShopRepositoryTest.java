import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void shouldRemove() {
        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Масло", 200);
        Product product3 = new Product(3, "Молоко", 300);

        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(2);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowException() {
        Product product1 = new Product(1, "Хлеб", 100);
        Product product2 = new Product(2, "Масло", 200);

        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(3);
        });
    }
}
