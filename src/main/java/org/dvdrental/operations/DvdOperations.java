package org.dvdrental.operations;

import org.dvdrental.models.cache.DvdCache;
import org.dvdrental.models.dvd.Dvd;
import org.dvdrental.operations.Operations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DvdOperations extends Operations {

    public List<Dvd> getCachedConvertedDvds() {
        return cachedConvertedDvds;
    }

    public void setCachedConvertedDvds(List<Dvd> cachedConvertedDvds) {
        this.cachedConvertedDvds = cachedConvertedDvds;
    }

    private List<Dvd> cachedConvertedDvds;

    public DvdOperations(DvdCache dvdCache) {
        this.cachedConvertedDvds = dvdCache.getCachedConvertedDvds();
    }

    public List<Dvd> getAllDvds() {
        return cachedConvertedDvds.stream()
                .sorted(Comparator.comparing(Dvd::getTitle))
                .toList();
    }

    public List<Dvd> getAvailableDvds() {
        return cachedConvertedDvds.stream()
                .filter(dvd -> !dvd.isRent())
                .collect(Collectors.toList());
    }

    public List<Dvd> getRentedDvds() {
        return cachedConvertedDvds.stream()
                .filter(Dvd::isRent)
                .collect(Collectors.toList());
    }

    public void saveCachedData(DvdCache cachedDvds) {
        List<List<String>> csvDVDs = new ArrayList<>();

        for (Dvd dvd : cachedConvertedDvds) {
            List<String> csvRecord = dvd.asCSVRecord();
            csvDVDs.add(csvRecord);
        }
        cachedDvds.updateCachedData(csvDVDs);
        cachedDvds.updateFile();
    }
}
