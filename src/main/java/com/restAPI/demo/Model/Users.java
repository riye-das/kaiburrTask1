package com.restAPI.demo.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "people")
public class Users {

    private long id;


    private String name;


    private String language;


    private String framework;

    public Users(long id, String name, String language, String framework)
    {
        this.id = id;
        this.name=name;
        this.language=language;
        this.framework=framework;
    }
    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id=id;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public String getLanguage()
    {
        return language;
    }
    public void setLanguage(String language)
    {
        this.language=language;
    }

    public String getFramework()
    {
        return framework;
    }
    public void setFramework(String framework)
    {
        this.framework=framework;
    }
}

