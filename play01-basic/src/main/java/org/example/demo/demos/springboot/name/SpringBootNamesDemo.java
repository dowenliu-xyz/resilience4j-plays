package org.example.demo.demos.springboot.name;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Component
public class SpringBootNamesDemo {
    @Bulkhead(name = "semaphore-01")
    public void demo01() {}

    @Bulkhead(name = "semaphore-02", type = Bulkhead.Type.SEMAPHORE)
    public void demo02() {}

    @Bulkhead(name = "thread-pool-01", type = Bulkhead.Type.THREADPOOL)
    public void demo03() {}

    @Bulkhead(name = "thread-pool-02", type = Bulkhead.Type.THREADPOOL)
    public void demo04() {}

    @Bulkhead(name = "semaphore-03")
    public void demo05() {}

    @Bulkhead(name = "semaphore-04", type = Bulkhead.Type.SEMAPHORE)
    public void demo06() {}

    @Bulkhead(name = "thread-pool-03", type = Bulkhead.Type.THREADPOOL)
    public void demo07() {}

    @Bulkhead(name = "thread-pool-04", type = Bulkhead.Type.THREADPOOL)
    public void demo08() {}
}
