import java.util.*;

public class HashMapFinal<K, V> {
  java.util.ArrayList<java.util.LinkedList<Entity<K, V>>> list;

  private int size = 0;

  private float lf = 0.5f;

  public HashMapFinal() {
    list = new java.util.ArrayList<>();
    for(int i=0; i < 10; i++) {
      list.add(new java.util.LinkedList<>());
    }
  }

  public void put(K key, V value) {
    int hash = Math.abs(key.hashCode() % list.size());
    java.util.LinkedList<Entity<K, V>> entities = list.get(hash);
    for (Entity<K, V> entity : entities) {
      if(entity.key.equals(key)) {
        entity.value = value;
        return;
      }
    }
    if((float)(size) / list.size() > lf) {
      reHash();
      hash = Math.abs(key.hashCode() % list.size());
      entities = list.get(hash);
    }
    entities.add(new Entity<>(key, value));
    size++;
  }

  private void reHash() {
    System.out.println("We are now rehashing!");
    java.util.ArrayList<java.util.LinkedList<Entity<K, V>>> old = list;
    list = new java.util.ArrayList<>();
    size = 0;
    for(int i=0; i<old.size() * 2; i++) {
      list.add(new java.util.LinkedList<>());
    }
    for(java.util.LinkedList<Entity<K, V>> entries : old) {
      for(Entity<K, V> entry : entries) {
        put(entry.key, entry.value);
      }
    }
  }

  public V get(K key) {
    int hash = Math.abs(key.hashCode() % list.size());
    java.util.LinkedList<Entity<K, V>> entities = list.get(hash);
    for(Entity<K, V> entity : entities) {
      if(entity.key.equals(key)) {
        return entity.value;
      }
    }
    return null;
  }

  public void remove(K key) {
    int hash = Math.abs(key.hashCode() % list.size());
    java.util.LinkedList<Entity<K, V>> entities = list.get(hash);
    Entity<K, V> target = null;
    for(Entity<K, V> entity : entities) {
      if(entity.key.equals(key)) {
        target = entity;
        break;
      }
    }
    if(target != null) {
      entities.remove(target);
      size--;
    }
  }

  public boolean containsKey(K key) {
    return get(key) != null;
  }

  @Override
    public String toString() {
      StringBuilder builder = new StringBuilder();
        builder.append("{");
      for(java.util.LinkedList<Entity<K, V>> entities : list) {
        for(Entity<K, V> entity : entities) {
          builder.append(entity.key);
          builder.append(" = ");
          builder.append(entity.value);
          builder.append(" , ");
        }
      }
      builder.append("}");
      return builder.toString();
    }

  private static class Entity<K, V> {
    K key;
    V value;

    public Entity(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    // hashDemo();
    HashMapFinal<String, String> map = new HashMapFinal<>();
    
    map.put("Mango", "King of fruits");
    map.put("Apple", "A sweet red fruit");
    map.put("Litchi", "Kunal's fav fruit");

    System.out.println(map);
    
    
  }

  
}