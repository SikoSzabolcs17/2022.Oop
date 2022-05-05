package oop.labor11.labor11_2;


public class Student {
    private String neptunId;
    private String firstName;
    private String lastName;
    private int credit;
    private MyDate birthDate;

    public Student(String neptunId, String firstName, String lastName, int credit, int birthYear,int birthMonth,int birthDay) throws InvalidDateException {
        this.neptunId = neptunId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credit = credit;
        this.birthDate = new MyDate(birthYear,birthMonth,birthDay);
    }

    public String getNeptunId() {
        return neptunId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCredit() {
        return credit;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setNeptunId(String neptunId) {
        this.neptunId = neptunId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Stundent{" +
                "neptunId='" + neptunId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", credit=" + credit +
                ", birthDate=" + birthDate +
                '}';
    }
}
