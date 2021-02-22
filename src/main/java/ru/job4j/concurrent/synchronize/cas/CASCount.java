package ru.job4j.concurrent.synchronize.cas;

import net.jcip.annotations.ThreadSafe;
import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASCount {
    private final AtomicReference<Integer> count = new AtomicReference<>(0);

    public void increment() {
        Integer next;
        Integer current;

        do {

            current = count.get();
            if (current == null) {
                throw new UnsupportedOperationException("Count is not impl.");
            }
            next = current + 1;

        } while (!count.compareAndSet(current, next));
        System.out.println(next);
    }

    public int get() {
        Integer current = count.get();
        if (current == null) {
            throw new UnsupportedOperationException("Count is not impl.");
        }
        return current;
    }
}