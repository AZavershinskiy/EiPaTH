package HW_3;

import java.io.IOException;

public class MyInputException extends Exception {
    public MyInputException() {
        super("Data input error");
    }

    public MyInputException(String e) {
        super(e);
    }
}

class LackData extends MyInputException {
    public LackData() {
        super("Not all data inputted");
    }
}

class ExtraData extends MyInputException {
    public ExtraData() {
        super("Extra data inputted");
    }
}

class NumericInNameException extends MyInputException {
    public NumericInNameException() {
        super("The presence of numbers in the name is not allowed");
    }
}

class NotCurrentDateValueError extends MyInputException {
    public NotCurrentDateValueError(String e) {
        super(e);
    }

    public NotCurrentDateValueError() {
        super("Date inputted incorrectly");
    }
}

class LetterInPhoneException extends MyInputException {
    public LetterInPhoneException() {
        super("The presence of letters in the phone number is not allowed");
    }
}

class GenderError extends MyInputException {
    public GenderError() {
        super("Gender input error");
    }
}

class DateIncompletelyException extends NotCurrentDateValueError {
    public DateIncompletelyException() {
        super("Date inputted incompletely");
    }
}

class ExtraSymbolException extends NotCurrentDateValueError {
    public ExtraSymbolException() {
        super("Extra symbols in the inputted date");
    }
}

class DateNotValidException extends NotCurrentDateValueError {
    public DateNotValidException() {
        super("Non-existent day in the calendar");
    }

    public DateNotValidException(String e) {
        super(e);
    }
}

class DataWrite extends IOException {
    public DataWrite() {
        super("File write error! Check the path");
    }
}