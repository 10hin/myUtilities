package com.example._10hin.myUtilities;

public class Reference<T> {

    private final T object;

    public Reference(T object) {
        this.object = object;
    }

    public T get() {
        return this.object;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this.object);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Reference)) {
            return false;
        }
        Reference<?> other = (Reference<?>) obj;
        return this.object == other.object;
    }

    @Override
    public String toString() {
        return new StringBuilder() //
            .append("Reference @") //
            .append(Integer.toHexString(System.identityHashCode(this.object))) //
            .append("[") //
            .append(this.object) //
            .append("]") //
            .toString();
    }

}