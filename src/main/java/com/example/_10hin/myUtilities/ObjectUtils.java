package com.example._10hin.myUtilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * utitilies that I want in {@link java.util.Objects}
 *
 * @author kei
 *
 */
public class ObjectUtils {

    public static <T> boolean partialEquals(T a, T b, Function<? super T, ?> extractor) {
        if (extractor == null) {
            throw new NullPointerException();
        }
        if (a == b) {
            return true;
        }
        if (a == null) {
            if (b != null) {
                return false;
            }
        }
        if (b == null) {
            return false;
        }
        return Objects.equals(extractor.apply(a), extractor.apply(b));
    }

    public static <T, R> List<R> listConvert(List<T> list, Function<T, R> converter) {
        if (converter == null) {
            throw new NullPointerException();
        }
        if (list == null) {
            return null;
        }
        Stream<R> convertStream = list.stream().map(converter);
        int flags = ((list instanceof Queue) ? 1 : 0)
                + ((list instanceof Serializable) ? 2 : 0)
                + ((list instanceof Cloneable) ? 4 : 0);
        Collector<R, ?, List<R>> collector = null;
        switch (flags) {
        case 0:
            collector = Collectors.toCollection(NoneButRandomAccess::new);
            break;
        case 1:
            collector = Collectors.toCollection(NoneButDeque::new);
            break;
        case 2:
            collector = Collectors.toCollection(SerializableRandomAccess::new);
            break;
        case 3:
            collector = Collectors.toCollection(SerializableDeque::new);
            break;
        case 4:
            collector = Collectors.toCollection(CloneableRandomAccess::new);
            break;
        case 5:
            collector = Collectors.toCollection(CloneableDeque::new);
            break;
        case 6:
            collector = Collectors.toCollection(NoneButDeque::new);
            break;
        case 7:
            collector = Collectors.toCollection(NoneButDeque::new);
            break;
        default:
             throw new InternalError("impossible local variable value");
        }
        return convertStream.collect(collector);
    }

    /**
     *
     * @author kei
     *
     * @param <E>
     */
    private static class CloneableRandomAccess<E> extends NoneButRandomAccess<E> implements Cloneable {

        public CloneableRandomAccess<E> clone() {
            try {

                // to localize scope of annotation @SuppressWarnings
                @SuppressWarnings("unchecked")
                CloneableRandomAccess<E> clone = (CloneableRandomAccess<E>) super.clone();

                return clone;
            } catch (CloneNotSupportedException e) {
                throw new InternalError("this instance implements Cloneable", e);
            }
        }

    }

    /**
     *
     * @author kei
     *
     * @param <E>
     */
    private static class CloneableDeque<E> extends NoneButDeque<E> implements Cloneable {

        @Override
        public CloneableDeque<E> clone() {
            try {

                // to localize scope of annotation @SuppressWarnings
                @SuppressWarnings("unchecked")
                CloneableDeque<E> clone = (CloneableDeque<E>) super.clone();

                return clone;
            } catch (CloneNotSupportedException e) {
                throw new InternalError("this instance implements Cloneable", e);
            }
        }

    }

    /**
     *
     * @author kei
     *
     * @param <E>
     */
    private static class SerializableRandomAccess<E> extends NoneButRandomAccess<E> implements Serializable {

        /**
        *
        */
        private static final long serialVersionUID = 2480626481038558647L;

    }

    /**
     *
     * @author kei
     *
     * @param <E>
     */
    private static class SerializableDeque<E> extends NoneButDeque<E> implements Serializable {

        /**
        *
        */
        private static final long serialVersionUID = 6163491841525611985L;

    }

    /**
     *
     * @author kei
     *
     * @param <E>
     */
    private static class NoneButRandomAccess<E> implements List<E>, RandomAccess {

        private List<E> list;

        private NoneButRandomAccess() {
            this.list = new ArrayList<E>();
        }

        @Override
        public boolean add(E e) {
            return this.list.add(e);
        }

        @Override
        public void add(int index, E element) {
            this.list.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return this.list.addAll(c);
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> c) {
            return this.list.addAll(index, c);
        }

        @Override
        public void clear() {
            this.list.clear();
        }

        @Override
        public boolean contains(Object o) {
            return this.list.contains(o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return this.list.containsAll(c);
        }

        @Override
        public E get(int index) {
            return this.list.get(index);
        }

        @Override
        public int indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override
        public Iterator<E> iterator() {
            return this.list.iterator();
        }

        @Override
        public int lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }

        @Override
        public ListIterator<E> listIterator() {
            return this.list.listIterator();
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            return this.list.listIterator(index);
        }

        @Override
        public boolean remove(Object o) {
            return this.list.remove(o);
        }

        @Override
        public E remove(int index) {
            return this.list.remove(index);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return this.list.removeAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return this.list.retainAll(c);
        }

        @Override
        public E set(int index, E element) {
            return this.list.set(index, element);
        }

        @Override
        public int size() {
            return this.list.size();
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            return this.list.subList(fromIndex, toIndex);
        }

        @Override
        public Object[] toArray() {
            return this.list.toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return this.list.toArray(a);
        }

        @Override
        public int hashCode() {
            return this.list.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return this.list.equals(o);
        }

        @Override
        public String toString() {
            return this.list.toString();
        }

    }

    /**
     *
     * @author kei
     *
     * @param <E>
     */
    private static class NoneButDeque<E> implements List<E>, Deque<E>, Queue<E> {

        private LinkedList<E> list;

        private NoneButDeque() {
            this.list = new LinkedList<E>();
        }

        @Override
        public boolean add(E e) {
            return this.list.add(e);
        }

        @Override
        public void add(int index, E element) {
            this.list.add(index, element);
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            return this.list.addAll(c);
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> c) {
            return this.list.addAll(index, c);
        }

        @Override
        public void clear() {
            this.list.clear();
        }

        @Override
        public boolean contains(Object o) {
            return this.list.contains(o);
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return this.list.containsAll(c);
        }

        @Override
        public E get(int index) {
            return this.list.get(index);
        }

        @Override
        public int indexOf(Object o) {
            return this.list.indexOf(o);
        }

        @Override
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override
        public Iterator<E> iterator() {
            return this.list.iterator();
        }

        @Override
        public int lastIndexOf(Object o) {
            return this.list.lastIndexOf(o);
        }

        @Override
        public ListIterator<E> listIterator() {
            return this.list.listIterator();
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            return this.list.listIterator(index);
        }

        @Override
        public boolean remove(Object o) {
            return this.list.remove(o);
        }

        @Override
        public E remove(int index) {
            return this.list.remove(index);
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return this.list.removeAll(c);
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return this.list.retainAll(c);
        }

        @Override
        public E set(int index, E element) {
            return this.list.set(index, element);
        }

        @Override
        public int size() {
            return this.list.size();
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            return this.list.subList(fromIndex, toIndex);
        }

        @Override
        public Object[] toArray() {
            return this.list.toArray();
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return this.list.toArray(a);
        }

        @Override
        public void addFirst(E arg0) {
            this.list.addFirst(arg0);
        }

        @Override
        public void addLast(E arg0) {
            this.addLast(arg0);
        }

        @Override
        public Iterator<E> descendingIterator() {
            return this.list.descendingIterator();
        }

        @Override
        public E element() {
            return this.list.element();
        }

        @Override
        public E getFirst() {
            return this.list.getFirst();
        }

        @Override
        public E getLast() {
            return this.list.getLast();
        }

        @Override
        public boolean offer(E arg0) {
            return this.list.offer(arg0);
        }

        @Override
        public boolean offerFirst(E arg0) {
            return this.list.offerFirst(arg0);
        }

        @Override
        public boolean offerLast(E arg0) {
            return this.list.offerLast(arg0);
        }

        @Override
        public E peek() {
            return this.list.peek();
        }

        @Override
        public E peekFirst() {
            return this.list.peekFirst();
        }

        @Override
        public E peekLast() {
            return this.list.peekLast();
        }

        @Override
        public E poll() {
            return this.list.poll();
        }

        @Override
        public E pollFirst() {
            return this.list.pollFirst();
        }

        @Override
        public E pollLast() {
            return this.list.pollLast();
        }

        @Override
        public E pop() {
            return this.list.pop();
        }

        @Override
        public void push(E arg0) {
            this.list.push(arg0);
        }

        @Override
        public E remove() {
            return this.list.remove();
        }

        @Override
        public E removeFirst() {
            return this.list.removeFirst();
        }

        @Override
        public boolean removeFirstOccurrence(Object arg0) {
            return this.list.removeFirstOccurrence(arg0);
        }

        @Override
        public E removeLast() {
            return this.list.removeLast();
        }

        @Override
        public boolean removeLastOccurrence(Object arg0) {
            return this.list.removeLastOccurrence(arg0);
        }

        @Override
        public int hashCode() {
            return this.list.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return this.list.equals(o);
        }

        @Override
        public String toString() {
            return this.list.toString();
        }

    }

    public static <T, R> R[] arrayConvert(T[] array, Function<T, R> converter) {
        if (converter == null) {
            throw new NullPointerException();
        }
        if (array == null) {
            return null;
        }

        // to localize scope of annotation @SuppressWarnings
        @SuppressWarnings("unchecked")
        R[] result = (R[]) Arrays.stream(array).map(converter).collect(Collectors.toList()).toArray();

        return result;
    }

    public static <T, R> Set<R> setConvert(Set<T> set, Function<T, R> converter) {
        if (converter == null) {
            throw new NullPointerException();
        }
        if (set == null) {
            return null;
        }
        return set.stream().map(converter).collect(Collectors.toSet());
    }

    public static <T, R> Collection<R> collectionConvert(Collection<T> collection, Function<T, R> converter) {
        if (converter == null) {
            throw new NullPointerException();
        }
        if (collection == null) {
            return null;
        }
        return collection.stream().map(converter).collect(Collectors.toList());
    }

    public static <T, R, C extends Collection<R>> C collectionConvert(Collection<T> collection,
            Function<T, R> converter, Supplier<C> collectionFactory) {
        if (converter == null || collectionFactory == null) {
            throw new NullPointerException();
        }
        if (collection == null) {
            return null;
        }
        return collection.stream().map(converter).collect(Collectors.toCollection(collectionFactory));
    }

    public static <TK, TV, RK, RV> Map<RK, RV> mapConvert(Map<TK, TV> map, Function<TK, RK> keyConverter,
            Function<TV, RV> valueConverter) {
        if (keyConverter == null || valueConverter == null) {
            throw new NullPointerException();
        }
        if (map == null) {
            return null;
        }
        return map.keySet().stream().collect(Collectors.toMap(keyConverter, valueConverter.compose(map::get)));
    }

}
