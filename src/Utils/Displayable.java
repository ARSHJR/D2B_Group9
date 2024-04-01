package Utils;

import java.util.ArrayList;

/**
 * Identification comments:
 *   Name: Aarush Satpute
 *   Experiment No: 07
 *   Experiment Title: Implementing JSON File Handling in Java to store relationship objects data. Reading a json file to objects and writing objects to a json data file.
 *   Experiment Date: 20-02-2024
 *   @version 1.0
 *
 *
 * Beginning comments:
 * Filename: Displayable.java
 * @author:  Aarush Satpute D2B 46
 * Overview: This is the Displayable Interface. In this file we have achieved the following
 * - Declared the functions, the body to which will be provided in the classes which implement this interface
 *
 */

public interface Displayable {
    ArrayList<String> getLine(int line);
    /*
    The getLine(int line) method returns an ArrayList of String objects that represent a single row of the table.
    The method takes an integer argument line that specifies which row to retrieve. The method retrieves the ...
    at the specified index in the ... list and then extracts the various attributes of the ...
    etc. These attributes are then added to the ArrayList and returned.
     */

    ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine);
    /*
    The getLines(int firstLine, int lastLine) method returns an ArrayList of ArrayList of String objects that represent a subset of rows
    of the table. The method takes two integer arguments firstLine and lastLine that specify the range of rows to retrieve.
    The method then iterates over this range and calls getLine(int line) for each row, adding the resulting ArrayList of attributes to a
    new ArrayList of ArrayList of String objects that is then returned.
     */

    public int getFirstLineToDisplay();
    public int getLineToHighlight();
    public int getLastLineToDisplay();
    public int getLinesBeingDisplayed();

    public void setFirstLineToDisplay(int firstLine);
    public void setLineToHighlight(int highlightedLine);
    public void setLastLineToDisplay(int lastLine);
    public void setLinesBeingDisplayed(int numberOfLines);
}
