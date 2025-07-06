package MVCPattern;

class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}
class StudentView {
    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("Student Details:");
        System.out.println("Name : " + name);
        System.out.println("ID   : " + id);
        System.out.println("Grade: " + grade);
    }
}
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // Controller methods to update model
    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    // Controller methods to get model data
    public String getStudentName() { return model.getName(); }
    public String getStudentId() { return model.getId(); }
    public String getStudentGrade() { return model.getGrade(); }

    // Update view
    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}
public class Main {
    public static void main(String[] args) {
        // Step 1: Create model
        Student student = new Student("Ritiv", "X169", "A+");

        // Step 2: Create view
        StudentView view = new StudentView();

        // Step 3: Create controller
        StudentController controller = new StudentController(student, view);

        // Step 4: Display initial details
        controller.updateView();

        // Step 5: Update model via controller
        controller.setStudentName("Ritiv Mohapatra");
        controller.setStudentGrade("O");

        // Step 6: Display updated details
        controller.updateView();
    }
}

