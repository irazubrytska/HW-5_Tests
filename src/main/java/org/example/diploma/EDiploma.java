package org.example.diploma;

import com.google.common.util.concurrent.AtomicDouble;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EDiploma {
    @Getter
    private Map<Subject, Integer> grades = new HashMap<>();

    public void addSubject(Subject s, int grade) {
        grades.put(s, grade);
    }

    public double averageGrade() {
        AtomicDouble sum = new AtomicDouble();
        AtomicInteger credits = new AtomicInteger();
        grades.forEach((s, grade) -> {
            sum.addAndGet(grade*s.getCredits());
            credits.addAndGet(s.getCredits());
        });
        return sum.get()/credits.get();
    }

    public void clearGrades() {
        grades.clear();
    }
}
