import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\nCourse2-extra-problems-2-2-6-reader");

        Random r = new Random();

        Reader john = new Reader("John", "Java Development", "2005-01-15", 1235550000L + (long) r.nextInt(1000));
        System.out.println(john);

        john.takeBook("Effective Java");
        john.takeBook("Spring for beginners");
        john.takeBook("Harry Potter and OOP");
        System.out.println(john);

        final String[] b = new String[john.getBookNames().length];

        for (int i = 0; i < john.getBookNames().length; i++) {
            b[i] = john.getBookNames()[i];
        }

        System.out.println(Arrays.toString(b));

        john.returnBooks(b);

        System.out.println(john);

        john.returnBooks(b);

        Reader[] readers = {john, new Reader("Mary", "Graphic Design", "2004-07-22", 1235550000L + (long) r.nextInt(1000)),
                new Reader("Lisa", "Management", "2005-09-03", 1235550000L + (long) r.nextInt(1000))};

        String[] books = {"Detective", "Romantic", "Funny stories"};

        for (int i = 0; i < readers.length; i++) {
            readers[i].takeBook(b[r.nextInt(0, 3)]);
            readers[i].takeBook(books[r.nextInt(0, 3)]);
        }


    }
}