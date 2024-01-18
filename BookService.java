public class BookService {
    private Book[] books;
    private int bookCount;
    public BookService(){
        this.books = new Book[100];
        this.bookCount = 0;
    }

    public void addBook(Book book){
        books[bookCount] = book;
        bookCount++;
    }

    public void updateBook(Book book,int id){
        boolean isBookFound = false;
        for(int i=0;i<bookCount;i++){
            if(books[i].getId()==id){
                book.setId(books[i].getId());
                book.setPage(books[i].getPage());
                books[i] = book;
                isBookFound = true;
                break;
            }
        }

        if(isBookFound){
            System.out.println("Kitap gucellenmistir...");
        }else {
            System.out.println("Kitap bulunamadi...");
        }

    }
    public Book[] getBooks(){
        return books;
    }
    public void deleteBook(int id){
        int isBookFound = -1;
        for(int i=0;i<bookCount;i++){
            if(books[i].getId()==id){
                isBookFound = i;
                break;
            }}
        if (isBookFound!=-1){
            for (int i=isBookFound; i<bookCount; i++){
                books[bookCount]=books[bookCount+1];
            }
            bookCount--;
        }
        else{
            System.out.println("Kitap bulunamadi...");
        }
    }
    public Book getBookById(int id){
        int isBookFound = -1;
        for(int i=0;i<bookCount;i++){
            if(books[i].getId()==id){
                isBookFound = i;
                break;
            }}
        if (isBookFound!=-1){
            System.out.println("Kitap İsmi:"+books[isBookFound].getName());
            System.out.println("Yazar İsmi: "+books[isBookFound].getAuthorName());
            System.out.println("Sayfa Sayısı:"+books[isBookFound].getPage());
        }
        else {
            System.out.println("Kütap bulunamadı.");
        }
        return null;
    }
    public void getBooksByAuthorName(String AuthorName){
        int isBookFound = -1;
        for(int i=0;i<bookCount;i++){
            if(books[i].getAuthorName().equals(AuthorName)){
                isBookFound = i;
                break;
            }}
        if (isBookFound!=-1){
            System.out.println("Kitap İsmi:"+books[isBookFound].getName());
            System.out.println("Yazar İsmi: "+books[isBookFound].getAuthorName());
            System.out.println("Sayfa Sayısı:"+books[isBookFound].getPage());
        }
        else {
            System.out.println("Kütap bulunamadı.");
        }

    }
}
