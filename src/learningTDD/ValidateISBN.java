package learningTDD;

public class ValidateISBN {

    private static final int SHORT_ISBN_LENGTH = 10;
    private static final int LONG_ISBN_LENGTH = 13;
    public static final int SHORT_ISBN_MULTIPLIER = 11;
    public static final int LONG_ISBN_MULTIPLIER = 10;

    public boolean checkISBN(String isbn) {
        if (isbn.length() == LONG_ISBN_LENGTH) {
            return isThisAValidLongISBN(isbn);
        } else if (isbn.length() == SHORT_ISBN_LENGTH) {
            return isThisAValidShortISBN(isbn);
        }
        throw new NumberFormatException("ISBN numbers must be 10 or 13 digits long.");
    }

    private boolean isThisAValidLongISBN(String isbn) {
        int total = 0;
        int numericValue;
        for (int i = 0; i < LONG_ISBN_LENGTH; i++) {
            numericValue = Character.getNumericValue(isbn.charAt(i));
            total += (i % 2 == 0) ? numericValue : numericValue * 3;
        }
        return total % LONG_ISBN_MULTIPLIER == 0;
    }

    private boolean isThisAValidShortISBN(String isbn) {
        int total = 0;
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == 9 && isbn.charAt(i) == 'X') {
                    total += 10;
                } else {
                    throw new NumberFormatException("ISBN numbers can only contain numeric digits");
                }
            } else {
                total += Character.getNumericValue(isbn.charAt(i)) * (SHORT_ISBN_LENGTH - i);
            }
        }
        return total % SHORT_ISBN_MULTIPLIER == 0;
    }

}

