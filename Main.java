import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Hoşgeldiniz...");
        BookService bookService=new BookService();
        UserService userService=new UserService(bookService);
        while (true){

            System.out.println("1.  Kitapları Görüntüle");
            System.out.println("2.  Kitap Ekle");
            System.out.println("3.  Kitap Güncelle");
            System.out.println("4.  Kitap Sil");
            System.out.println("5.  Kitap ID İle Görüntüle");
            System.out.println("6.  Kitap Yazar İsmi İle Görüntüle");
            System.out.println("7.  Kullanıcı Ekle");
            System.out.println("8.  Kullanıcı Güncelle");
            System.out.println("9.  Kullanıcı Sil");
            System.out.println("10. Kullanıcı ID İle Görüntüle");
            System.out.println("11. Kitap ata.");
            try {


            String choice=scanner.nextLine();
            switch (choice){
                case "1":
                    bookService.getBooks();
                    break;
                case "2":
                    System.out.println("Kitap ID giriniz.");
                    int addBookID=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Kitap ismini giriniz.");
                    String addBookName=scanner.nextLine();
                    System.out.println("Kitap yazarını giriniz.");
                    String addBookAuthorName=scanner.nextLine();
                    System.out.println("Kitap sayfasını giriniz.");
                    int addBookPage=scanner.nextInt();
                    scanner.nextLine();
                    Book newbook=new Book(addBookID,addBookName,addBookAuthorName,addBookPage);
                    bookService.addBook(newbook);
                    break;
                case "3":
                    System.out.println("Kitap ID giriniz.");
                    int bookID= scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Yeni kitap ID giriniz.");
                    int updateBookID=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Yeni kitap ismini giriniz.");
                    String updateBookName=scanner.nextLine();
                    System.out.println("Yeni kitap yazarını giriniz.");
                    String updateBookAuthorName=scanner.nextLine();
                    System.out.println("Yeni kitap sayfasını giriniz.");
                    int updateBookPage=scanner.nextInt();
                    scanner.nextLine();
                    Book updatedBook = new Book(updateBookID, updateBookName, updateBookAuthorName, updateBookPage);
                    bookService.updateBook(updatedBook,bookID);
                    break;
                case "4":
                    System.out.println("Kitap ID giriniz.");
                    int bookID1=scanner.nextInt();
                    scanner.nextLine();
                    bookService.deleteBook(bookID1);
                    break;
                case "5":
                    System.out.println("Kitap ID giriniz.");
                    int bookBYID=scanner.nextInt();
                    scanner.nextLine();
                    bookService.getBookById(bookBYID);
                    break;
                case "6":
                    System.out.println("Yazar ismi giriniz.");
                    String authorName=scanner.nextLine();
                    bookService.getBooksByAuthorName(authorName);
                    break;
                case "7":
                    System.out.println("Kullanıcı ID giriniz.");
                    int addUserID=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Kullanıcı TC giriniz.");
                    String addUserTC=scanner.nextLine();
                    System.out.println("Kullanıcı ismini giriniz.");
                    String addUserName=scanner.nextLine();
                    System.out.println("Kullanıcı soy ismini giriniz.");
                    String addUserLastName=scanner.nextLine();
                    User user=new User(addUserID,addUserTC,addUserName,addUserLastName);
                    userService.addUser(user);
                    break;
                case "8":
                    System.out.println("Kullanıcı ID giriniz.");
                    int UserID=scanner.nextInt();
                    System.out.println("Yeni kullanıcı ID giriniz.");
                    int updateUserID=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Yeni kullanıcı TC giriniz.");
                    String updateUserTC=scanner.nextLine();
                    System.out.println("Yeni kullanıcı ismini giriniz.");
                    String updateUserName=scanner.nextLine();
                    System.out.println("Yenikullanıcı soy ismini giriniz.");
                    String updateUserLastName=scanner.nextLine();
                    User updateUser=new User(updateUserID,updateUserTC,updateUserName,updateUserLastName);
                    userService.updateUser(updateUser,UserID);
                    break;
                case "9":
                    System.out.println("Kitap ID giriniz.");
                    int deleteBookID= scanner.nextInt();
                    scanner.nextLine();
                    userService.userDelete(deleteBookID);
                    break;
                case "10":
                    System.out.println("Kullanıcı ID giriniz.");
                    String bookBYTC= scanner.nextLine();
                    scanner.nextLine();
                    userService.getUserBYTC(bookBYTC);
                    break;
                case "11":
                    System.out.println("Kullanıcı ID giriniz:");
                    int assignUserId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Kitap ID giriniz:");
                    int assignBookId = scanner.nextInt();
                    userService.assignBookToUser(assignUserId, assignBookId);
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Lütfen bir seçim yapınız");
                    break;
            }
        }
            catch (InputMismatchException e){
                System.out.println("Lütfen bir seçim yapınız");
                scanner.nextLine();
            }
        }

    }
}