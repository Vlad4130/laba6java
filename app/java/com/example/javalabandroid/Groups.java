package com.example.javalabandroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.Toast;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Arrays;

public class Groups{
    private int id;
    private String number;
    public String facultyName;
    private int educationLevel;
    private boolean contractExistsFlg;
    private boolean privilegeExistsFlg;

    public Groups(int id,String number,String facultyName,int educationLevel, boolean contractExistsFlg, boolean privilegeExistsFlg){
        this.id = id;
        this.number = number;
        this.facultyName = facultyName;
        this.educationLevel = educationLevel;
        this.contractExistsFlg = contractExistsFlg;
        this.privilegeExistsFlg = privilegeExistsFlg;
    }
    public Groups(String number,String facultyName,int educationLevel, boolean contractExistsFlg, boolean privilegeExistsFlg){

    }

    public int getId() {
        return this.id;
    }

    public static ArrayList<Groups> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return number;
    }

    public String getNumber() {
        return number;
    }

    public String getFacultyName() {
        return facultyName;
    }
    public int getEducationLevel() {
        return educationLevel;
    }

    public boolean isContractExistsFlg() {
        return contractExistsFlg;
    }

    public boolean isPrivilegeExistsFlg() {
        return privilegeExistsFlg;
    }

    public static ArrayList<Groups> groups = new ArrayList<Groups>(
            Arrays.asList(
                    new Groups("301","Інноваційні технології",0, true,false),
                    new Groups("302","Старі технології",0, true,false),
                    new Groups("303","Доісторичні технології",0, true,false),
                    new Groups("304","Майбутні технології",1, false,true)
            )
    );
    public static Groups getGroup(String groupNumber){
    for (Groups g:groups){
        if(g.getNumber().equals(groupNumber)){
            return g;
        }
    }
    return null;
    }
    public static void addGroup(Groups group){groups.add(group);}


}
