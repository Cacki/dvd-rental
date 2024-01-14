package org.dvdrental.models.cache;

import org.dvdrental.converters.Converter;
import org.dvdrental.models.user.User;

import java.util.List;

public class UserCache extends CacheData {
    public UserCache(String fileName) {
        super(fileName);
    }

    public List<User>  getCachedConvertedUsers() {
        return Converter.convertUsers(this.cachedData);
    }
}
