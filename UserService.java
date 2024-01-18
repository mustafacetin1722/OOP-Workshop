public class UserService {
    private final BookService bookService;

    private User[] users;
    private int userCount;
    private int assignmentBookCount=0;
    public UserService(BookService bookService){
        this.bookService = bookService;
        this.users = new User[100];
        this.userCount = 0;
    }

    public void addUser(User user){
        users[userCount] = user;
        userCount++;
    }
    public void updateUser(User user,int id){
        boolean isUserFound = false;
        for (int i=0; i<userCount; i++){
            if (users[i].getId()==id){
                users[i].setTc(user.getTc());
                users[i].setName(user.getName());
                users[i].setLastName(user.getLastName());
                users[i]=user;
                isUserFound=true;
                break;
            }
        }
        if(isUserFound){
            System.out.println("Kullanıcı gucellenmistir...");
        }else {
            System.out.println("kullanıcı bulunamadi...");
        }
    }
    public void userDelete(int id){
        int isUserFound = -1;
        for (int i=0; i<userCount; i++){
            if (users[i].getId()==id) {
                isUserFound=i;
                break;
            }}
        for (int i=isUserFound; i<userCount; i++){
            users[i]=users[i+1];
        }
        userCount--;
    }
    public void getUserBYTC(String tc) {
        int isUserFound = -1;
        for (int i = 0; i < userCount; i++) {
            if (users[i].getTc().equals(tc)) {
                isUserFound = i;
                break;
            }
        }
        if (isUserFound != -1) {
            User user = users[isUserFound];
            System.out.println("Kullanıcı İsmi:" + users[isUserFound].getName());
            System.out.println("Kullanıcı Soyismi: " + users[isUserFound].getLastName());
            System.out.println("kullanıcı TC:" + users[isUserFound].getTc());

            int[] assignedBooks = user.getAssignedBooks();
            System.out.println("Kullanıcının Atanmış Kitapları:");
            if (assignedBooks.length > 0) {
                for (int bookId : assignedBooks) {
                    Book assignedBook = bookService.getBookById(bookId);
                    if (assignedBook != null) {
                        System.out.println(" - Kitap ID: " + assignedBook.getId());
                        System.out.println("   Kitap İsmi: " + assignedBook.getName());
                        System.out.println("   Yazar İsmi: " + assignedBook.getAuthorName());
                        System.out.println("   Sayfa Sayısı: " + assignedBook.getPage());
                    }
                }
            } else {
                System.out.println("Kullanıcıya atanmış kitap bulunmamaktadır.");
            }
        } else {
            System.out.println("Kullanıcı bulunamadı.");
        }
    }

    public void assignBookToUser(int userId, int bookId) {
        User foundUser = getUserById(userId);
        Book foundBook = bookService.getBookById(bookId);

        if (foundUser != null && foundBook != null) {
                System.out.println("Kitap kullanıcıya atandı.");
                assignmentBookCount++;

        } else {
            System.out.println("Kullanıcı veya kitap bulunamadı.");
        }
    }
    private User getUserById(int userId) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getId() == userId) {
                return users[i];
            }
        }
        return null;
    }

    // Delete, Update, getUserBYTC, assignBookToUser methodlariniz yaziniz.
}
