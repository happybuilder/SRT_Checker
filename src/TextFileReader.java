import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {
    static public List<Caption> getAllCaption(File aFile) {
        BufferedReader input;
        String line;
        int seqNum;
        List<Caption> captionList;

        captionList = new ArrayList<Caption>();
        try {
            input =  new BufferedReader(new FileReader(aFile, StandardCharsets.UTF_8));
            try {
                while (( line = input.readLine()) != null){
                    if (line.isBlank())
                        continue;
                    seqNum = Integer.parseInt(line);
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

        duration = readNextTextLine(input);
        lang1 = readNextTextLine(input);   // First language.
        lang2 = readNextTextLine(input);   // Second language.

        caption = new Caption(seqNum, duration, lang1, lang2);

        return caption;
    }

    static public String readNextTextLine(BufferedReader input) {
        String line;
        try {
            while (( line = input.readLine()) != null){
                if (!line.isBlank()) {
                    return line;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
