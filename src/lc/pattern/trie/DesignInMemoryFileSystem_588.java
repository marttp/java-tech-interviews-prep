package lc.pattern.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignInMemoryFileSystem_588 {


  private static class FileSystem {

    File root;

    public FileSystem() {
      // "/" <= root directory
      this.root = new File();
    }

    public List<String> ls(String path) {
      // 1. Ref to root directory
      File ptr = root;
      // Check edge case => put only "/"
      // If not, Move ptr from root, If it is, skip if state => go produce directory list
      if (!path.equals("/")) {
        String[] nestPath = path.split("/");
        for (int i = 1; i < nestPath.length; i++) {
          ptr = ptr.files.get(nestPath[i]);
        }
        if (ptr.isFile) {
          // If it's file, return single element as file
          return List.of(nestPath[nestPath.length - 1]);
        }
      }
      List<String> result = new ArrayList<>(ptr.files.keySet());
      // Lexicographical order
      Collections.sort(result);
      return result;
    }

    public void mkdir(String path) {
      // 1. Ref to root directory
      File ptr = root;
      // 2. Split path by slash
      String[] nestPath = path.split("/");
      // FYI: First element is empty string
      for (int i = 1; i < nestPath.length; i++) {
        ptr.files.putIfAbsent(nestPath[i], new File());
        ptr = ptr.files.get(nestPath[i]);
      }
    }

    public void addContentToFile(String filePath, String content) {
      File ptr = root;
      String[] nestPath = filePath.split("/");
      for (int i = 1; i < nestPath.length - 1; i++) {
        ptr = ptr.files.get(nestPath[i]);
      }
      // stop before last path to check if it exist or not
      // if not, create new one
      ptr.files.putIfAbsent(nestPath[nestPath.length - 1], new File());
      ptr = ptr.files.get(nestPath[nestPath.length - 1]);
      ptr.content = ptr.content.concat(content);
      ptr.isFile = true;
    }

    public String readContentFromFile(String filePath) {
      File ptr = root;
      String[] nestPath = filePath.split("/");
      for (int i = 1; i < nestPath.length; i++) {
        ptr.files.putIfAbsent(nestPath[i], new File());
        ptr = ptr.files.get(nestPath[i]);
      }
      return ptr.files.get(nestPath[nestPath.length - 1]).content;
    }
  }

  private static class File {

    boolean isFile = false;
    Map<String, File> files = new HashMap<>();
    String content = "";
  }
}
