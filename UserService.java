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
    public void getUserBYTC(int id) {
        int isUserFound = -1;
        for (int i = 0; i < userCount; i++) {
            if (users[i].getId()==id) {
                isUserFound = i;
                break;
            }
        }
        if (isUserFound != -1) {
            System.out.println("Kullanıcı İsmi:" + users[isUserFound].getName());
            System.out.println("Kullanıcı Soyismi: " + users[isUserFound].getLastName());
            System.out.println("kullanıcı TC:" + users[isUserFound].getTc());
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
