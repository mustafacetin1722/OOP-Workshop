public class Book {
    private int id;
    private String name;
    private String authorName;
    private int page;

    public Book(int id, String name, String authorName, int page) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.page = page;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
