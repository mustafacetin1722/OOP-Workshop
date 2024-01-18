public class User {
    private int id;
    private String tc;
    private String name;
    private String lastName;
    private int[] assignedBooks;
    private int assignedBooksCount;

    public User(int id, String tc, String name, String lastName) {
        this.id = id;
        this.tc = tc;
        this.name = name;
        this.lastName = lastName;
        this.assignedBooks = new int[100];
        this.assignedBooksCount = 0;
    }

    public int[] getAssignedBooks() {
        return assignedBooks;
    }

    public void setAssignedBooks(int[] assignedBooks) {
        this.assignedBooks = assignedBooks;
    }

    public int getAssignedBooksCount() {
        return assignedBooksCount;
    }

    public void setAssignedBooksCount(int assignedBooksCount) {
        this.assignedBooksCount = assignedBooksCount;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
