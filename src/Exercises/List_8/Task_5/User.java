package Exercises.List_8.Task_5;

public class User {
    private int id;
    private String name;
    private String email;
    private String mobile;

    public User(int id, String name, String email, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (this == other) {
            return true;
        }

        return (other instanceof User) && this.hashCode() == other.hashCode();
    }

    @Override
    public int hashCode() {
        int result = 19;

        result *= 5;
        result += id;

        result %= 10000;

        result *= 7;
        result += stringHash(name);

        result %= 10000;

        result *= 9;
        result += stringHash(email);

        result %= 10000;

        result *= 11;
        result += stringHash(mobile);

        result %= 10000;

        return result;
    }

    private int stringHash(String str) {
        int sum = 3;

        for (char c : str.toCharArray()) {
            sum += (int) c;
        }

        return sum;
    }

    public static void main(String[] args) {
        User userA = new User(0, "Tom", "tom@tom.com", "504231042");
        System.out.println(userA.hashCode());

        User userB = new User(1, "Anna", "anna@gmail.com", "592015921");
        System.out.println(userB.hashCode());

        System.out.println("Users equal? " + userA.equals(userA));
        System.out.println("Users equal? " + userA.equals(userB));
    }
}