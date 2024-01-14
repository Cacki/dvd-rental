package org.dvdrental.models.cache;

import org.dvdrental.operations.Operations;

import java.util.List;

import static org.dvdrental.operations.Operations.writeToCSV;

public class CacheData {
    protected List<List<String>> cachedData;
    protected String fileName;

    public CacheData() {
    }

    public CacheData(String fileName) {
        this.fileName = fileName;
        this.cachedData = Operations.readFromCSV(fileName);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<List<String>> getCachedData() {
        return this.cachedData;
    }

    public void updateCachedData(List<List<String>> newData) {
        this.cachedData = newData;
    }

    public void updateFile() {
        writeToCSV(this.cachedData, fileName);
    }

}
