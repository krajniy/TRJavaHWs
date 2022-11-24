package TRJavaHWs.lesson17;
import java.util.Objects;
import java.util.Set;
public class Customer {
    private Long id;
    private String name;
    private Integer tier;

    public Customer(long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public Customer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id)
                && Objects.equals(name, customer.name)
                && Objects.equals(tier, customer.tier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tier);
    }

    @Override
    public String toString() {
        return "Customer{ \n" +
                "id=" + id +
                "\n, name='" + name + '\'' +
                "\n, tier=" + tier +
                "}";
    }
}
