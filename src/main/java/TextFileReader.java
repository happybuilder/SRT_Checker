import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {

    private static String nextLine;
    static public List<Caption> getAllCaption(File aFile) {
        BufferedReader input;
        String line = null;
        int seqNum = -1, prevSeqNum;
        List<Caption> captionList;

        captionList = new ArrayList<Caption>();
        try {
            input =  new BufferedReader(new FileReader(aFile, StandardCharsets.UTF_8));
            try {
                while ((nextLine != null) || ( line = input.readLine()) != null){
                    if (line.isBlank())
                        continue;
                    prevSeqNum = seqNum;
                    try {
                        seqNum = nextLine != null ? Integer.parseInt(nextLine) : Integer.parseInt(line);
                    } catch(NumberFormatException e) {
                        System.out.println("Too many lines in Caption: " + prevSeqNum);
                        throw e;
                    }
                    captionList.add(getCaption(input, seqNum));
                }
            }
            finally {
                input.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return captionList;
    }

    static public Caption getCaption(BufferedReader input, int seqNum) {
        String duration;
        String lang1, lang2;
        Caption caption;

        nextLine = null;
        duration = readNextTextLine(input);
        lang1 = readNextTextLine(input);    // First language.
        lang2 = readNextTextLine(input);    // Second language.
        if (isInteger(lang2) && Integer.parseInt(lang2) == seqNum + 1) {
            nextLine = lang2;
            lang2 = "";
        }

        caption = new Caption(seqNum, duration, lang1, lang2);

        return caption;
    }

    static public String readNextTextLine(BufferedReader input) {
        String line;
        try {
            while (( line = input.readLine()) != null){
                if (!line.isBlank()) {
                    return line.trim();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

//    public String getNextLine() {
//        return nextLine;
//    }
//
//    public void setNextLine(String nextLine) {
//        this.nextLine = nextLine;
//    }

}
