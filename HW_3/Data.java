package HW_3;

public class Data {

    private String lastName;
    private String firstName;
    private String patronymic;
    private String birthday;
    private String phone;
    private String gender;

    public Data(String lastName, String firstName, String patronymic, String birthday, String phone, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
    }

    public Data(String[] dataIn) {
        this.lastName = dataIn[0];
        this.firstName = dataIn[1];
        this.patronymic = dataIn[2];
        this.birthday = dataIn[3];
        this.phone = dataIn[4];
        this.gender = dataIn[5];
    }

    @Override
    public String toString() {
        return "<" + lastName + '>' +
                "<" + firstName + '>' +
                "<" + patronymic + '>' +
                "<" + birthday + '>' +
                "<" + phone + '>' +
                "<" + gender + ">\n";
    }

    public String getLastName() {
        return lastName;
    }
}