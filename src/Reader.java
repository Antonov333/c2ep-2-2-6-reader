import java.util.Arrays;

public class Reader {

    private static int readerCount;

    /**
     * 1. ФИО
     * 2. номер читательского билета
     * 3. факультет
     * 4. дата рождения
     * 5. телефон
     * 6. Методы takeBook(), returnBook().
     */


    private String name;
    private int cardNo;
    private String faculty;
    private String dateOfBirth;
    private long phone;
    private String[] bookNames;

    public Reader(String name, String faculty, String dateOfBirth, long phone) {
        readerCount++;
        this.name = name;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.cardNo = readerCount;
    }

    public void takeBook(String newBookName) {
        int bookCount = 0;
        if (this.bookNames != null) {
            bookCount = this.bookNames.length;
        }
        bookCount++;
        String[] bookNames = new String[bookCount];
        bookNames[bookCount - 1] = newBookName;
        for (int i = 0; i <= bookCount - 2; i++) {
            bookNames[i] = this.bookNames[i];
        }
        this.bookNames = bookNames;
        System.out.println(name + " rented book " + bookNames[bookNames.length - 1]);
    }

    ;

    public void returnBook(String book) {
        if (bookNames == null) {
            System.out.println("Book " + book + " is not rented by " + name);
            return;
        }
        boolean returned = false;
        int returnedBookPointer = -1;
        for (int i = 0; i <= bookNames.length - 1; i++) {
            if (bookNames[i] == book) {
                bookNames[i] = "";
                returnedBookPointer = i;
                returned = true;
                break;
            }
        }
        if (returned) {
            if (bookNames.length <= 1) {
                bookNames = null;
            } else {
                String[] newBookNames = new String[bookNames.length - 1];
                for (int i = 0; i < returnedBookPointer; i++) {
                    newBookNames[i] = bookNames[i];
                }
                for (int i = returnedBookPointer + 1; i <= bookNames.length - 1; i++) {
                    newBookNames[i - 1] = bookNames[i];
                }
                bookNames = newBookNames;
            }
            System.out.println(name + " returned book " + book);
        }
        if (!returned) {
            System.out.println("Book " + book + " is not rented by " + name);
        }

    }

    public void returnBooks(String[] bookNames) {
        if (this.bookNames == null) {
            System.out.println(name + " has not rented any book yet");
            return;
        }
        for (int i = 0; i < bookNames.length; i++) {
            returnBook(bookNames[i]);
        }
    }

    public String getName() {
        return name;
    }

    public int getCardNo() {
        return cardNo;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public long getPhone() {
        return phone;
    }

    public String[] getBookNames() {
        return bookNames;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", cardNo=" + cardNo +
                ", faculty='" + faculty + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phone=" + phone +
                ", bookNames=" + Arrays.toString(bookNames) +
                '}';
    }
}
