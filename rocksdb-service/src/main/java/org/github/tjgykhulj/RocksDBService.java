package org.github.tjgykhulj;

import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RocksDBService {

    private RocksDB rocksDB;

    @PostConstruct
    public void init() throws RocksDBException {
        rocksDB = RocksDB.open("./out");
    }

    public boolean put(String key, String val) {
        try {
            rocksDB.put(key.getBytes(), val.getBytes());
            return true;
        } catch (RocksDBException e) {
            return false;
        }
    }

    public String get(String key) {
        try {
            byte[] val = rocksDB.get(key.getBytes());
            return val == null? null: new String(val);
        } catch (RocksDBException e) {
            return null;
        }
    }

    public void mget(String key) {
        rocksDB.getSnapshot();
    }
}
