package studentmanage.model.value;

public enum JobValue {
    STUDENT("학생"),
    EMPLOYEE("직원"),
    TEACHER("교사");

    private String value;

    JobValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
