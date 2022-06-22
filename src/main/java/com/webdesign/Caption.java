package com.webdesign;

public class Caption {

    public enum CaptionType {
        SINGLE_LANG, DUAL_LANG
    }

    private CaptionType captionType;
    private int seqNum;
    private String duration;
    private String lang1;
    private String lang2;

    public Caption(int seqNum, String duration, String lang1, String lang2) {
        this.seqNum = seqNum;
        this.duration = duration;
        this.lang1 = lang1;
        this.lang2 = lang2;
        if (CommonUtils.stringIsBlank(lang2)) {
            this.captionType = CaptionType.SINGLE_LANG;
        } else {
            this.captionType = CaptionType.DUAL_LANG;
        }
    }

    public CaptionType getCaptionType() {
        return captionType;
    }

    public void setCaptionType(CaptionType captionType) {
        this.captionType = captionType;
    }

    public int getSeqNum() {
        return seqNum;
    }

    public void setSeqNum(int seqNum) {
        this.seqNum = seqNum;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLang1() {
        return lang1;
    }

    public void setLang1(String lang1) {
        this.lang1 = lang1;
    }

    public String getLang2() {
        return lang2;
    }

    public void setLang2(String lang2) {
        this.lang2 = lang2;
    }
}
