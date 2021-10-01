package Product;

public enum AgeRestriction {
    NONE(0),
    TEENAGER(13),
    ADULT(18);
    private final int age;

    AgeRestriction(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
