public class Caption {
    private int langCount;
    private int seqNum;
    private String duration;
    private String lang1;
    private String lang2;

    public Caption(int seqNum, String duration, String lang1, String lang2) {
        this.seqNum = seqNum;
        this.duration = duration;
        this.lang1 = lang1;
        this.lang2 = lang2;
        if (lang2.isBlank()) {
            this.langCount = 1;
        } else {
            this.langCount = 2;
        }
    }

    public int getLangCount() {
        return langCount;
    }

    public void setLangCount(int langCount) {
        this.langCount = langCount;
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
