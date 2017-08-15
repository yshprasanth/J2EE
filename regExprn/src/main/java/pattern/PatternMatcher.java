package pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sri Hari Prasanth Yalamanchili on 21/05/2017.
 * <p>
 * PatternMatch class
 * <p>
 * The purpose of this class is to parse a pattern string, generate a regular expression
 * and evaluate the regular expression on a set of strings and match.
 * <p>
 * Ex.
 * Few Pattern Inputs:
 * <p>
 * "is this message %{} {}0 ballpark %{} {S13}"
 * "foo %{} {}0 is a %{} {}1"
 * "foo %{} {}0 is a %{} {S10}"
 * "the %{} {S01} %{} {}1 ran away"
 * "bar %{} {G0} foo %{} {}1"
 * <p>
 * %{} - Token Delimiter
 * {}# - Simple Token to accept one or more number of words
 * {S#} - S Token to specify number of spaces
 * {G#} - G Token to specify greedy match
 */
public class PatternMatcher {

    // Static constants to hold standard regular expression values
    protected static final String REGEX_BEGIN_OF_LINE = "^";
    protected static final String REGEX_END_OF_LINE = "$";
    protected static final String REGEX_BEGIN_OF_STRING = "\\A";
    protected static final String REGEX_END_OF_STRING = "\\z";
    protected static final String REGEX_ZERO_OR_MORE_OCCURANCES = "*";
    protected static final String REGEX_ONE_OR_MORE_OCCURANCES = "+";
    protected static final String REGEX_ZERO_OR_ONE_OCCURANCE = "?";
    protected static final String REGEX_OR_MATCHER = "|";
    protected static final String REGEX_GROUP_START = "(";
    protected static final String REGEX_GROUP_END = ")";
    protected static final String REGEX_CLASS_START = "[";
    protected static final String REGEX_CLASS_END = "]";
    protected static final String REGEX_CLASS_NEGATION = "^";
    protected static final String REGEX_CLASS_RANGE = "-";
    protected static final String REGEX_CLASS_INTERSECTION = "&&";
    protected static final String REGEX_WORD = "\\w";
    protected static final String REGEX_NON_WORD = "\\W";
    protected static final String REGEX_WHITESPACE = "\\s";
    protected static final String REGEX_NON_WHITESPACE = "\\S";
    protected static final String REGEX_DIGIT = "\\d";
    protected static final String REGEX_NON_DIGIT = "\\D";
    protected static final String REGEX_WORD_BRAKE = "\\w";
    protected static final String REGEX_NEW_NAME_CAPTURING_GROUP_START = "?<";
    protected static final String REGEX_EXISTING_NAME_CAPTURING_GROUP_START = "\\k<";
    protected static final String REGEX_NAME_CAPTURING_GROUP_END = ">";

    // Static constants to parse and validate input pattern strings
    protected static final String INPUT_PATTERN_STRING_REGEX = "(.*?)(\\%\\{\\}\\s*)(\\{.*?\\}\\d*)(.*)";
    protected static final String INPUT_PATTERN_STRING_DELIM_REGEX = "(\\{.*?\\}\\d*)";
    protected static final String INPUT_PATTERN_STRING_TOKEN_REGEX = "\\{([S|G]\\d+)*\\}(\\d*)";
    protected static final String INPUT_PATTERN_STRING_SIMPLE_TOKEN_REGEX = "(\\{\\})(\\d*)";
    protected static final String INPUT_PATTERN_STRING_S_TOKEN_REGEX = "\\{(S[\\d]+)\\}(\\d*)";
    protected static final String INPUT_PATTERN_STRING_G_TOKEN_REGEX = "\\{(G[\\d]+)\\}(\\d*)";

    // Static constants to generate regular expression
    protected static final String GEN_SIMPLE_TOKEN_REGEX = "[\\w|\\s]+";
    protected static final String GEN_S_TOKEN_WORD_WITHOUT_SPACE_REGEX = "\\b\\w+\\b";
    protected static final String GEN_S_TOKEN_WORD_WITH_SPACE_REGEX = "\\s\\b\\w+\\b";
    protected static final String GEN_G_TOKEN_SUFFIX_REGEX = ".*";

    // Static constants to hold the exit command
    protected static final String EXIT_COMMAND = "exit";


    // Member instance variable to hold patternString
    private String patternString;
    // Member instance variable to hold generated regular expression
    private StringBuffer regularExprn;
    // Member instance variable to hold individual tokens pattern string
    private List<String> parsedTokensList;
    // Member instance variable to hold Pattern object
    private Pattern inputStringPattern;

    // Default Constructor
    public PatternMatcher() {
        inputStringPattern = Pattern.compile(INPUT_PATTERN_STRING_REGEX);
    }

    // Constructor with 1 param
    public PatternMatcher(String patternString) {
        this();
        this.patternString = patternString;
    }

    /*
     * Main method.
     * parameter: Expects Pattern String as the command line argument while running this class.
     *
     * args[0] must be a Pattern String
     * Ex.,
     * java PatternMatcher "is this message %{} {}0 ballpark %{} {S13}"
     *
     * here arg[0]="is this message %{} {}0 ballpark %{} {S13}"
     */
    public static void main(String[] args) {
        // check for command line argument
        if (args != null && args.length >= 1) {
            logMessage("PatternString argument: " + args[0]);

        } else {
            logMessage("Error - Missing PatternString as argument");
            return;
        }

        // Set first argument to a variable
        String inputPatternString = args[0];

        if("dev-test".equals(inputPatternString)) {
            test();
            return;
        }

        // Instantiate PatternMatcher object
        PatternMatcher patternMatcher = new PatternMatcher(inputPatternString);

        // Invoke parsePatternString() method
        patternMatcher.parsePatternString();

        // Invoke matchTextFromConsole() method
        patternMatcher.matchTextFromConsole();
    }

    /*
     * method: parsePatternString
     *
     * This method is the entry point for parsing the pattern string.
     * It will parse the pattern string and generate regular expression.
     */
    public void parsePatternString() {
        // check if the patternString is not null
        // and patternString matches the regex pattern
        if (patternString != null && patternString.matches(INPUT_PATTERN_STRING_REGEX)) {

            // initialize list to hold tokens
            parsedTokensList = new ArrayList<String>();

            // parse individual sub-tokens
            parseSubPatternText(patternString);

            //for(String token: parsedTokensList)
            //    logMessage("token:" + token);

            //parseTokens();

            // generate Regular expression
            generateRegularExpression();
        }
    }

    /*
     * method: parseSubPatternText
     *
     * This method will faciliate recursive calls to parse individual tokens.
     * This method is recursively called from with-in.
     *
     * Input Pattern String is divided into 4 groups so it can be parsed easily.
     *
     * Group 1: (.*?)
     * Group 2: (%{}\s*)
     * Group 3: ({.*?}\d*)
     * Group 4: (.*)
     */
    private void parseSubPatternText(String patternText) {
        // Match the incoming text with the regular expression
        Matcher matcher = inputStringPattern.matcher(patternText);
        //logMessage("patternText:" + patternText);
        // check if match found
        if (matcher.find()) {
            //logMessage("groupCount:" + matcher.groupCount());

            // Check if all 4 groups are found in the input pattern string
            if (matcher.groupCount() == 4) {
                // Add groups 1 & 3 to the list
                parsedTokensList.add(matcher.group(1));
                parsedTokensList.add(matcher.group(3));

                // Recursively call the same method for group 4
                parseSubPatternText(matcher.group(4));
            } else if (matcher.groupCount() <= 3) {  // Check if only 3 or less groups are found in the input pattern string
                // add groups 1 to 3 to the list
                for (int index = 1; index <= matcher.groupCount(); index++) {
                    parsedTokensList.add(matcher.group(index));
                }
            }
        } else {
            // no match found, so it could be a plain text. Add it to the list
            parsedTokensList.add(patternText);
        }
    }

    /*
     * method: parseTokens
     *
     * This method will loop through the individual tokens in parsedTokensList and validate
     * the token sequences
     */
    private void parseTokens() {
        Pattern pattern = Pattern.compile(INPUT_PATTERN_STRING_DELIM_REGEX);
        Matcher matcher;
        for (int index = 0; index < parsedTokensList.size(); index++) {
            matcher = pattern.matcher(parsedTokensList.get(index));
            //logMessage("token " + index + ":" + parsedTokensList.get(index));
            if (matcher.find()) {
                //logMessage("groupCount:" + matcher.groupCount());
                if (matcher.groupCount() > 1) {
                    //logMessage("group2:" + matcher.group(2));
                    parsedTokensList.set(index, matcher.group(2));
                } else if (matcher.groupCount() == 1) {
                    //logMessage("group1:" + matcher.group(1));
                    parsedTokensList.set(index, matcher.group(1));
                }
            }
        }
    }

    /*
     * method: generateRegularExpression
     *
     * This method will loop through the individual tokens in parsedTokensList and generate
     * a Regular Expression that will be used to match/validate against the input text.
     *
     * While looping through the tokens, it will check if the token is either SIMPLE or S or G TOKEN
     * and will apply the regular expression accordingly.
     */
    private void generateRegularExpression() {
        // init regularExprn variable
        regularExprn = new StringBuffer();
        // Add start of line - "^"
        regularExprn.append(REGEX_BEGIN_OF_LINE);

        // Variable to hold regular expression index for tokens
        int tokensRegExprnIndex = 0;

        Pattern sTokenPattern = Pattern.compile(INPUT_PATTERN_STRING_S_TOKEN_REGEX);
        Pattern gTokenPattern = Pattern.compile(INPUT_PATTERN_STRING_G_TOKEN_REGEX);
        Matcher matcher;

        // loop through the individual tokens
        for (String token : parsedTokensList) {

            // check if the token matches the pattern - "{([S|G]\d+)*}(\d*)"
            if (token.matches(INPUT_PATTERN_STRING_TOKEN_REGEX)) {

                // check if the token matches Simple Token pattern - "({})(\d*)"
                if (token.matches(INPUT_PATTERN_STRING_SIMPLE_TOKEN_REGEX)) {
                    // if yes, convert to "[\w|\s]+"
                    regularExprn.append(GEN_SIMPLE_TOKEN_REGEX);

                } else if (token.matches(INPUT_PATTERN_STRING_S_TOKEN_REGEX)) { // check if the token matches S Token pattern - "{(S[\d]+)}(\d*)"
                    // if yes, get the matcher
                    matcher = getMatcher(sTokenPattern, token);

                    // if matched and group count ==2
                    if (matcher.find() && matcher.groupCount() == 2) {
                        // group 1: will the text with S, i.e., S01 or S13, etc.
                        String sOption = matcher.group(1);
                        // group 2: to cover the cases where the index is specified after the brackets.
                        String trailingDigits = matcher.group(2);

                        // identify the index string, so we can extract the no. of spaces to be allocated
                        String tokenIndex = "S" + tokensRegExprnIndex;
                        if (sOption.startsWith(tokenIndex)) {
                            // identify the no. of spaces allowed
                            int allowedSpaceLimit = Integer.parseInt(sOption.substring(tokenIndex.length()));

                            // build the regular expression
                            regularExprn.append(REGEX_GROUP_START)
                                    .append(GEN_S_TOKEN_WORD_WITHOUT_SPACE_REGEX);

                            // build the regular expression dynamically based on the value of allowedSpaceLimit
                            while (allowedSpaceLimit > 0) {
                                regularExprn.append(GEN_S_TOKEN_WORD_WITH_SPACE_REGEX);
                                allowedSpaceLimit--;
                            }
                            // end the group
                            regularExprn.append(REGEX_GROUP_END);
                            // append trailing Digits as it not the index anymore and should match plain text
                            regularExprn.append(trailingDigits);
                        }
                    }
                } else if (token.matches(INPUT_PATTERN_STRING_G_TOKEN_REGEX)) { // check if the token matches G Token pattern - "{(G[\d]+)}(\d*)"
                    // if yes, get the matcher
                    matcher = getMatcher(gTokenPattern, token);

                    // if matched and group count ==2
                    if (matcher.find() && matcher.groupCount() == 2) {

                        // group 2: to cover the cases where the index is specified after the brackets.
                        String trailingDigits = matcher.group(2);

                        // build the regular expression
                        regularExprn.append(GEN_SIMPLE_TOKEN_REGEX)
                                .append(GEN_G_TOKEN_SUFFIX_REGEX);

                        // append trailing Digits as it not the index anymore and should match plain text
                        regularExprn.append(trailingDigits);
                    }
                } else {
                    // It's neither Simple/S/G token, for now set the reg exp to Simple token
                    logMessage("ERROR while parsing token: " + token + ", Unknown format.");
                    regularExprn.append(GEN_SIMPLE_TOKEN_REGEX);
                }
                // Increment the reg expression Index
                tokensRegExprnIndex++;
            } else {
                // it's plain text, so add it as it is.
                regularExprn.append(token);
            }
        }
        // append end of line - "$"
        regularExprn.append(REGEX_END_OF_LINE);

        parsedTokensList = null; // free up memory as we no longer need parsedTokensList
    }

    /*
     *  method: matchTextFromConsole
     *
     *  This method will listen to the input stream, i.e., System.in, for the incoming text
     *  Every line will then be evaluated against the generated Regular Expression
     *  Prints the message to the output stream, i.e., System.out, with the matching status:
     *  MATCH / NO MATCH
     */
    private void matchTextFromConsole() {
        // Register Scanner object against System.in
        Scanner scanner = new Scanner(System.in);

        // Get Pattern object for the generated regular expression
        Pattern pattern = getPattenForRegEx();

        logMessage("Regular Expression: " + regularExprn);
        logMessage("Type <exit> to terminate the console");

        // Loop through until a text input is entered
        while (scanner.hasNext()) {

            // Scan the entire line
            String inputText = scanner.nextLine();

            // If the text matches "exit" then terminate
            if (EXIT_COMMAND.equalsIgnoreCase(inputText))
                System.exit(0);

            matchText(pattern, inputText);
        }
    }

    private void matchText(Pattern pattern, String inputText) {
        // Get Matcher object for the given text
        Matcher matcher = getMatcher(pattern, inputText);

        // Check if the text matched the regular expression
        if (matcher.matches()) {
            logMessage("MATCH: " + inputText);
        } else {
            logMessage("NO MATCH: " + inputText);
        }
    }

    /*
     * method: getPattenForRegEx
     * parameters:
     * returns: Pattern object
     *
     * This method will take no input parameters.
     * It will refer to the member instance variable regularExprn.
     * It will create and return a Pattern object based on regularExprn.
     */
    private Pattern getPattenForRegEx() {
        Pattern pattern = null;
        if (this.regularExprn != null && this.regularExprn.length() > 0) {
            pattern = Pattern.compile(this.regularExprn.toString());
        } else {
            logMessage("ERROR - Cannot generate pattern for empty regularExprn. Return null.");
        }
        return pattern;
    }


    /*
     * method: getMatcher
     * parameters: pattern: Patten object
     *             inputText: Text to be evaluated
     * returns: Matcher object
     *
     * This method will take Pattern and inputText as input parameters.
     * It will evaluate the inputText against the Pattern and returns
     * the matcher object.
     */
    private Matcher getMatcher(Pattern pattern, String inputText) {
        Matcher matcher = null;

        if (pattern != null && inputText != null) {
            matcher = pattern.matcher(inputText);
        }

        return matcher;
    }

    /*
     * method: logMessage
     * parameters: message: String message to be logged
     *
     * This method will log the given string message to the output console
     * We can enhance this method to log to a file/console by using log4j api.
     */
    private static void logMessage(String message) {
        System.out.println(message);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        parsedTokensList = null;
        patternString = null;
        regularExprn = null;
        inputStringPattern = null;
    }

    public void setPatternString(String patternString) {
        this.patternString = patternString;
    }

    public String getPatternString() {
        return patternString;
    }

    private static void test() {
        // Instantiate PatternMatcher object
        PatternMatcher patternMatcher = new PatternMatcher();
        // test 1
        logMessage("test 1");
        patternMatcher.setPatternString("is this message %{} {}0 ballpark %{} {S13}");
        patternMatcher.parsePatternString();
        logMessage("PatternString: " + patternMatcher.getPatternString());
        logMessage("RegExp: " + patternMatcher.getPattenForRegEx());
        Pattern pattern = patternMatcher.getPattenForRegEx();
        patternMatcher.matchText(pattern, "is this message a ballpark of what it is");
        patternMatcher.matchText(pattern, "is this message a ballpark what it is");

        // test 2
        logMessage("test 2");
        patternMatcher.setPatternString("foo %{} {}0 is a %{} {}1");
        patternMatcher.parsePatternString();
        logMessage("PatternString: " + patternMatcher.getPatternString());
        logMessage("RegExp: " + patternMatcher.getPattenForRegEx());
        pattern = patternMatcher.getPattenForRegEx();
        patternMatcher.matchText(pattern, "foo blah is a bar");
        patternMatcher.matchText(pattern, "foo blah is a very big boat");

        // test 3
        logMessage("test 3");
        patternMatcher.setPatternString("foo %{} {}0 is a %{} {S10}");
        patternMatcher.parsePatternString();
        logMessage("PatternString: " + patternMatcher.getPatternString());
        logMessage("RegExp: " + patternMatcher.getPattenForRegEx());
        pattern = patternMatcher.getPattenForRegEx();
        patternMatcher.matchText(pattern, "foo blah is a bar");
        patternMatcher.matchText(pattern, "foo blah is a very big boat");
        patternMatcher.matchText(pattern, "foo blah is bar");
        patternMatcher.matchText(pattern, "foo blah");
        patternMatcher.matchText(pattern, "foo blah is");

        // test 4
        logMessage("test 4");
        patternMatcher.setPatternString("the %{} {S01} %{} {}1 ran away");
        patternMatcher.parsePatternString();
        logMessage("PatternString: " + patternMatcher.getPatternString());
        logMessage("RegExp: " + patternMatcher.getPattenForRegEx());
        pattern = patternMatcher.getPattenForRegEx();
        patternMatcher.matchText(pattern, "the big brown fox ran away");
        patternMatcher.matchText(pattern, "the big brown colored fox ran away");

        // test 5
        logMessage("test 5");
        patternMatcher.setPatternString("bar %{} {G0} foo %{} {}1");
        patternMatcher.parsePatternString();
        logMessage("PatternString: " + patternMatcher.getPatternString());
        logMessage("RegExp: " + patternMatcher.getPattenForRegEx());
        pattern = patternMatcher.getPattenForRegEx();
        patternMatcher.matchText(pattern, "bar foo bar foo bar foo bar foo");
        patternMatcher.matchText(pattern, "bar foo bar foo");

    }
}


