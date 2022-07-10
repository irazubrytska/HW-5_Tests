package org.example.diploma;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Subject {
    @Getter
    private String name;
    @Getter
    private int credits;
}
