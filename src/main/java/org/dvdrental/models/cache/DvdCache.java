package org.dvdrental.models.cache;

import org.dvdrental.converters.Converter;
import org.dvdrental.models.dvd.Dvd;

import java.util.List;

public class DvdCache extends CacheData {

    public DvdCache(String fileName) {
        super(fileName);
    }

    public List<Dvd> getCachedConvertedDvds() {
        return Converter.convertDvds(this.cachedData);
    }

}
