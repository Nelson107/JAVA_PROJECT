/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.news;

import java.io.File;

/**
 *
 * @author jevan
 */
class FileModel {
    private static FileModel instance;
    private File selectedFile;

    // Private constructor to enforce singleton pattern
    private FileModel() {}

    public static FileModel getInstance() {
        if (instance == null) {
            instance = new FileModel();
        }
        return instance;
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }
}
