package com.botaniac.forumsservice.model.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ForumSection {
    NEWS("News and Announcements"),
    DISCUSSION("Discussions"),
    QUESTION("Questions"),
    TIPS("Tips"),
    OFF_TOPIC("Free discussion");
    @JsonProperty
    private final String displayName;
    //private final String imagePath;
    private ForumSection(String displayName){
        this.displayName=displayName;
    }

    @JsonGetter("displayName")
    public String getDisplayName() {
        return displayName;
    }
    @JsonGetter("value")
    public int toValue() {
        return ordinal();
    }
    @JsonGetter("name")
    public String getName(){
        return this.toString();
    }
}
