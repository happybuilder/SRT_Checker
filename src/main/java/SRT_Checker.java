import java.io.*;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;

public class SRT_Checker {

    public static void main(String[] args) {
        String sInFile, sOutFile;
        File inFile, outFile;
        List<Caption> captionList;
        SRT srt = new SRT();

        // Read all arguments from command line.
        inFile = new File(readInputPath(args));
        if (inFile == null) {
            System.out.println("Input file missing. Application end.");
            return;
        }
        outFile = new File(readOutputPath(args, inFile));

        if (inFile.exists()) {
            captionList = TextFileReader.getAllCaption(inFile);
            srt.setCaptions(captionList);
            srt.listAllCaption();
            srt.writeFile(outFile);
            System.out.println("Input file: " + inFile.getPath());
            System.out.println("Output file: " + outFile.getPath());
            System.out.println("Number of captions: " + srt.getCaptionCount());
        }
        else {
            System.out.println("File does not exists: " + inFile.getAbsolutePath());
        }
    }


    // Format: must be the FIRST argument.
    public static String readInputPath(String[] args) {
        Scanner sc;
        String inputPath;

        if (args.length > 0) {
            inputPath = args[0];
        }
        else {
            sc = new Scanner(System.in);
            System.out.println("Input SRT file in full path: ");
            inputPath = sc.nextLine();
        }

        return inputPath.isBlank() ? null : inputPath;
    }

    // Format ex.: -o c:\temp\output.srt
    // Default: add "-chk" at the end of input file, and output to the same folder.
    public static String readOutputPath(String[] args, File inFile) {
        final String CHECKED = "-chk";
        String inBaseName;
        String outputFolder, outFilename;

        for(int i = 0; i < args.length; i++) {
            if (args[i].equals("-o") && i < args.length - 1) {
                return args[i+1];
            }
        }

        outputFolder = inFile.getParent();
        inBaseName = FilenameUtils.getBaseName(inFile.getPath());
        outFilename = inBaseName + CHECKED + "." + FilenameUtils.getExtension(inFile.getPath());
        return FilenameUtils.concat(outputFolder, outFilename);
    }

}
