package com.webdesign;

import java.io.*;
import java.util.List;

public class SRT {
    private String title;
    private int CaptionCount;
    private List<Caption> captions;

    static public void showCaption(Caption caption) {
        System.out.println(caption.getSeqNum());
        System.out.println(caption.getDuration());
        System.out.println(caption.getLang1());
        if (!CommonUtils.stringIsBlank(caption.getLang2())) {
            System.out.println(caption.getLang2());
        }
        System.out.println();
    }

    static public void writeCapture(Caption caption, BufferedWriter output) {
        try {
            output.write(String.valueOf(caption.getSeqNum())); output.newLine();
            output.write(caption.getDuration()); output.newLine();
            output.write(caption.getLang1());
            if (!CommonUtils.stringIsBlank(caption.getLang2())) {
                output.newLine();
                output.write(caption.getLang2());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void listAllCaption() {
        for(Caption cap : this.captions) {
            SRT.showCaption(cap);
        }
    }

    public void writeFile(File aFile) {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(aFile));
            try {
                writeCapture(this.captions.get(0), output);
                for(int i = 1; i < this.captions.size(); i++) {
                    output.newLine();
                    output.newLine();
                    writeCapture(this.captions.get(i), output);
                }
            }
            finally {
                output.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCaptionCount() {
        return captions.size();
    }

    public List<Caption> getCaptions() {
        return captions;
    }

    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }
}
