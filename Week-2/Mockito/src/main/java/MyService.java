public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData("user123");
    }


    public interface ExternalApi {
        String getData(String user123);
    }
}