package learningTDD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateISBNTest {

    @Test
    public void checkAValid1ShortISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean isValid = validator.checkISBN("1593279280");
        assertTrue(isValid);
    }

    @Test
    public void shortISBNsEndeingInAnXAreValid(){
        ValidateISBN validator = new ValidateISBN();
        boolean isValid = validator.checkISBN("012000030X");
        assertTrue(isValid);
    }

    @Test
    public void checkInvalidShortISBN() {
        ValidateISBN validator = new ValidateISBN();
        boolean isValid = validator.checkISBN("1593279283");
        assertFalse(isValid);
    }

    @Test
    public void checkISBNsAreTenDigits(){
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class,
                () -> { validator.checkISBN("123456789");
        });
    }

    @Test
    public void nonNumericISBNsAreNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        assertThrows(NumberFormatException.class,
                () -> { validator.checkISBN("helloworld");
        });
    }
    @Test
    public void isThisAValidLongISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean isValid = validator.checkISBN("9781786892737");
        assertTrue(isValid);
    }

    @Test
    public void isThisAnInvalidLongISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean isValid = validator.checkISBN("9781786892738");
        assertFalse(isValid);
    }

}