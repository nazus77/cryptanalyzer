package com.javarush.cryptanalyzer.nazarov.constants;

public class GetParametersConstants {

    public static final String SOURCE_PATH_REQUEST = "Please enter source full path or enter \"0\" to use ";
    public static final String DEFAULT_PATH_DESCRIPTION = ", located in project's root directory";
    public static final String INPUT_TXT = "input.txt";
    public static final String ENCODED_TXT = "encoded.txt";
    public static final String DECODED_TXT = "decoded.txt";
    public static final String DESTINATION_PATH_REQUEST = "Please enter destination full path or enter \"0\" to use ";
    public static final String WRONG_PATH_WARNING = "You have entered an incorrect path. ";
    public static final String KEY_REQUEST = "Please enter key (an integer from 1 to 1 000) or enter \"0\" to use random key";
    public static final String WRONG_KEY_WARNING = "You have entered an incorrect key. ";
    public static final String EMPTY_STRING = "";
    public static final String TXT_EXTENSION = ".txt";
    public static final String DICTIONARY = "dictoinary.txt)";
    public static final String DICTIONARY_REQUEST = "Please enter dictionary full path or enter \"0\" to use dictionary.txt" + DEFAULT_PATH_DESCRIPTION;
    public static final String DICTIONARY_REQUIREMENTS = "\nThe dictionary must have '.txt' extension and must include the text of the same author\nand in the same style as the source text before its encryption";

    private GetParametersConstants() {
    }
}
