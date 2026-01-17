class FileSystem {

    private class FileNode {
        private TreeMap<String, FileNode> children;
        private StringBuilder file;
        private String name;
        private boolean isFile;

        public FileNode(String name) {
            this.children = new TreeMap<>();
            this.file = new StringBuilder();
            this.isFile = false;
            this.name = name;
        }

        public void addContent(String content) {
            file.append(content);
        }

        public void setIsFile() {
            this.isFile = true;
        }

        public String getContent() {
            return this.file.toString();
        }

        public TreeMap<String, FileNode> getChildren() {
            return this.children;
        }

        public List<String> getChildrenList() {
            List<String> results = new ArrayList<>();
            if (this.isFile) {
                results.add(this.name);
            } else {
                results.addAll(this.children.keySet());
            }
            return results;
        }
    }

    private FileNode root;

    public FileSystem() {
        root = new FileNode("");
    }
    
    public List<String> ls(String path) {
        FileNode node = findNode(path);
        return node.getChildrenList();
    }
    
    public void mkdir(String path) {
        findNode(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        FileNode node = findNode(filePath);
        node.setIsFile();
        node.addContent(content);
    }
    
    public String readContentFromFile(String filePath) {
        FileNode node = findNode(filePath);
        return node.getContent();
    }

    private FileNode findNode(String path) {
        String[] files = path.split("/");
        
        FileNode curr = root;
        for (String file: files) {
            if (file.length() == 0) continue;
            curr.getChildren().putIfAbsent(file, new FileNode(file));
            curr = curr.getChildren().get(file);
        }
        return curr;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */