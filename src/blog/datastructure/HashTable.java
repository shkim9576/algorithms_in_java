package blog.datastructure;

import java.util.LinkedList;
import java.util.Objects;

public class HashTable<K,V> {

    private static final int BUCKET_SIZE = 10;
    private LinkedList<HashEntry<K,V>>[] buckets = new LinkedList[BUCKET_SIZE];

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.add("keyA", 1);
        hashTable.add("keyC", 3);
        hashTable.add("keyB", 2);
        hashTable.add("keyE", 5);
        hashTable.add("keyE", 5);

        System.out.println("get:keyD = " + hashTable.get("keyD")); // null
        System.out.println("get:keyA = " + hashTable.get("keyA")); // 1
        System.out.println("get:keyE = " + hashTable.get("keyE")); // 5

        System.out.println("remove:keyE = " + hashTable.remove("keyE")); // true
        System.out.println("get:keyE = " + hashTable.get("keyE")); // null

        System.out.println("contains:keyC = " + hashTable.containsKey("keyC")); // true
        System.out.println("contains:keyX = " + hashTable.containsKey("keyX")); // false
    }

    class HashEntry<K,V> {

        K key;
        V value;

        HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public int hashCode() {
            return Objects.hash(this.key, this.value);
        }

        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof HashEntry)) return false;

            HashEntry e = (HashEntry) o;

            return e.key.equals(this.key) && e.value.equals(this.value);
        }
    }

    void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);

        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<>();
        }

        V val = get(key);

        if (val != null) { // the key exist already
            buckets[bucketIndex].remove(new HashEntry<>(key, val));
        }

        buckets[bucketIndex].add(new HashEntry<>(key, value));
    }

    boolean remove(K key) {
        int bucketIndex = getBucketIndex(key);

        if (buckets[bucketIndex] == null) {
            return false;
        }

        LinkedList<HashEntry<K,V>> list = buckets[bucketIndex];

        for (int i=0; i< list.size(); i++) {
            if (list.get(i).key.equals(key)) {
                return buckets[bucketIndex].remove(list.get(i));
            }
        }

        return false;
    }

    V get(K key) {
        int bucketIndex = getBucketIndex(key);
        if (buckets[bucketIndex] == null) {
            return null;
        }

        LinkedList<HashEntry<K,V>> list = buckets[bucketIndex];

        for (int i=0; i< list.size(); i++) {
            if (list.get(i).key.equals(key)) {
                return list.get(i).value;
            }
        }

        return null;
    }

    boolean containsKey(K key) {
        return get(key) != null;
    }

    int getBucketIndex(K key) {
        int hashCode = hashFunction(key);
        return compress(hashCode);
    }

    int hashFunction(K key) {
        return key.hashCode();
    }

    int compress(int hashCode) {
        return hashCode % BUCKET_SIZE;
    }
}
