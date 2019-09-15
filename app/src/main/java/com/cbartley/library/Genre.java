package com.cbartley.library;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;

public enum Genre {
    Action("Action"),
    Adventure("Adventure"),
    Art("Art"),
    AlternateHistory("Alternate History"),
    Autobiography("Auto-Biography"),
    Anthology("Anthology"),
    Biography("Biography"),
    BookReview("Book Review"),
    Children("Children"),
    Cookbook("Cook Book"),
    Comic("Comic"),
    ComingOfAge("Coming of Age"),
    Crime("Crime"),
    Diary("Diary"),
    Dictionary("Dictionary"),
    Drama("Drama"),
    Encyclopedia("Encyclopedia"),
    Fairytale("Fairytale"),
    Fantasy("Fantasy"),
    GraphicNovel("Graphic Novel"),
    Guide("Guide"),
    Health("Health"),
    HistoricalFiction("Historical Fiction"),
    History("History"),
    Horror("Horror"),
    Journal("Journal"),
    LitRPG("LitRPG"),
    Manga("Manga"),
    Math("Math"),
    Memoir("Memoir"),
    Mystery("Mystery"),
    Paranormal("Paranormal"),
    PictureBook("Picture Book"),
    Poetry("Poetry"),
    Political("Political"),
    Prayer("Prayer"),
    Religion("Religion"),
    Review("Review"),
    Romance("Romance"),
    Satire("Satire"),
    Science("Science"),
    ScienceFiction("Science Fiction"),
    SelfHelp("Self Help"),
    ShortStory("Short Story"),
    Spirituality("Spirituality"),
    Suspense("Suspense"),
    Textbook("Textbook"),
    Thriller("Thriller"),
    Travel("Travel"),
    TrueCrime("True Crime"),
    YoungAdult("Young Adult");


    private String friendlyName;

    private Genre(String friendlyName){
        this.friendlyName = friendlyName;
    }

    @Override
    public String toString(){
        return friendlyName;
    }

    public String getGenre(){
        return friendlyName;
    }

    private static final Map<String, Genre> lookup = new HashMap<>();

    //Populate the lookup table on loading time
    static
    {
        for(Genre env : Genre.values())
        {
            lookup.put(env.getGenre(), env);
        }
    }

    public static Genre get(String name){
        return lookup.get(name);
    }
}