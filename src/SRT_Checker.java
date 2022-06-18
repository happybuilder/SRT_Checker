import java.io.*;
import java.util.List;

public class SRT_Checker {

    public static void main(String[] args) {
        String inPath = args[0];
        String outPath = args[1];
        File inFile = new File(inPath);
        File outFile = new File("c:/~temp/output.srt");
        List<Caption> captionList;
        SRT srt = new SRT();

        if (inFile.exists()) {
            captionList = TextFileReader.getAllCaption(inFile);
            srt.setCaptions(captionList);
            srt.listAllCaption();
            srt.writeFile(outFile);
            System.out.println("Number of captions: " + srt.getCaptionCount());
        }
        else {
            System.out.println("File does not exists: " + inFile.getAbsolutePath());
        }
    }

}
