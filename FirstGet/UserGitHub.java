package com.example.proba;

import com.google.gson.annotations.SerializedName;

public class UserGitHub {
    String name;

    String html_url;

    @SerializedName("id")
    public int idRepos;


    public String getName(){
       return name;
    }

    public String getHtml_url(){
        return html_url;
    }
    public int getIdRepos(){
        return idRepos;
    }
}
