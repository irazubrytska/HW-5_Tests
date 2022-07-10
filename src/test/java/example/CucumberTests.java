package example;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.diploma.EDiploma;
import org.example.diploma.Subject;
import org.example.diploma.SubjectField;

import java.lang.reflect.Type;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CucumberTests {
    private EDiploma diploma;

    @Given("new diploma")
    public void new_diploma() {
        diploma = new EDiploma();
    }

    @Given("subjects")
    public void subjects(List<SubjectField> subjects) {
        subjects.forEach(s -> diploma.addSubject(new Subject(s.getName(), s.getCredits()),s.getGrade()));
    }

    // SUBJECTS

    @When("I add subject field")
    public void i_add_subject_field(SubjectField field) {
        diploma.addSubject(new Subject(field.getName(), field.getCredits()), field.getGrade());
    }

    @Then("diploma should have {int} subjects")
    public void diploma_should_have_n_subjects(int number) {
        assertTrue(diploma.getGrades().size()==number);
    }

    // AVERAGE

    @Then("average grade should be equal to {double}")
    public void average_grade_should_be_equal_to(double average) {
        assertTrue(diploma.averageGrade() == average);
    }

    // EMPTY

    @When("I clear diploma")
    public void i_clear_diploma() {
        diploma.clearGrades();
    }

    @Then("diploma should be empty")
    public void diploma_should_be_empty() {
        assertTrue(diploma.getGrades().isEmpty());
    }

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object defaultTransformer(Object fromValue, Type toValueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.constructType(toValueType);
        return objectMapper.convertValue(fromValue, javaType);
    }
}
