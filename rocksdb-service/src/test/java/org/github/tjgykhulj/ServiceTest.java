package org.github.tjgykhulj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class ServiceTest {

    @Autowired
    private RocksDBService rocksDBService;

    @Test
    public void test() {
        assert rocksDBService.put("test", "ok");
        assert "ok".equals(rocksDBService.get("test"));
    }
}
