class FileSystem {
    
    private FileNode root;

    public FileSystem() {
        root = new FileNode("");
    }
    
    public List<String> ls(String path) {
        return findNode(path).getList();
    }
    
    public void mkdir(String path) {
        findNode(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        FileNode file = findNode(filePath);
        file.setIsFile();
        file.addContent(content);
    }
    
    public String readContentFromFile(String filePath) {
        return findNode(filePath).getContent();
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
    
    private class FileNode {
        private TreeMap<String, FileNode> children;
        private StringBuilder file;
        private String name;
        private boolean isFile;

        public FileNode(String name) {
            children = new TreeMap<>();
            file = new StringBuilder();
            isFile = false;
            this.name = name;
        }

        public String getContent(){
            return file.toString();
        }

        public String getName(){
            return name;
        }

        public void addContent(String content){
            file.append(content);
        }

        public boolean isFile(){
            return isFile;
        }
        
        public void setIsFile() {
            isFile = true;
        }
        
        public TreeMap<String, FileNode> getChildren() {
            return children;
        }

        public List<String> getList(){
            List<String> list = new ArrayList<>();
            if (isFile()) {
                list.add(getName());
            } else {
                list.addAll(children.keySet());
            }

            return list;
        }
    }
}
