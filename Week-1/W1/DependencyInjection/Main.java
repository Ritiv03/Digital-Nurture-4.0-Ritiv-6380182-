package DependencyInjection;
 
import java.util.HashMap;
import java.util.Map;

interface CustomerRepository {
    Customer findCustomerById(String id);
}
class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
}


class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> database = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Sample data
        database.put("C001", new Customer("C001", "Ritiv"));
        database.put("C002", new Customer("C002", "Chaitanya"));
    }

    public Customer findCustomerById(String id) {
        return database.get(id);
    }
}
class CustomerService {
    private CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void displayCustomer(String id) {
        Customer customer = customerRepository.findCustomerById(id);
        if (customer != null) {
            System.out.println("Customer Found:");
            System.out.println("ID   : " + customer.getId());
            System.out.println("Name : " + customer.getName());
        } else {
            System.out.println("Customer not found for ID: " + id);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Create the repository
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject repository into service
        CustomerService service = new CustomerService(repository);

        // Use service to find and display customer
        service.displayCustomer("C001");  // Existing customer
        service.displayCustomer("C999");  // Non-existent customer
    }
}
