package oop.labor12.labor12_3;

import java.util.Objects;

public class Mark {
    private final double grade;
    private final String subject;

    public Mark(double grade, String subject) {
        this.grade = grade;
        this.subject = subject;
    }

    public double getGrade() {
        return grade;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return Objects.equals(subject, mark.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, subject);
    }

    @Override
    public String toString() {
        return "Mark{" +
                "grade=" + grade +
                ", subject='" + subject + '\'' +
                '}';
    }
}
