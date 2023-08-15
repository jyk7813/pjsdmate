package kr.com.greenart.sdmate.pjsdmate.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class ChatHistory {
    private String content;
    private String who;

    private Timestamp datetime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatHistory that = (ChatHistory) o;
        return Objects.equals(content, that.content) && Objects.equals(who, that.who) && Objects.equals(datetime, that.datetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, who, datetime);
    }

    @Override
    public String toString() {
        return "ChatHistory{" +
                "content='" + content + '\'' +
                ", who='" + who + '\'' +
                ", datetime=" + datetime +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}
