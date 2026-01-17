class ThroneInheritance {
    private String king;
    private Map<String, List<String>> children;
    private Set<String> dead;
    
    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.children = new HashMap<>();
        this.dead = new HashSet<>();
        children.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        children.putIfAbsent(parentName, new ArrayList<>());
        children.get(parentName).add(childName);
        children.put(childName, new ArrayList<>());
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }
    
    private void dfs(String person, List<String> order) {
        // Add person to order if they're not dead
        if (!dead.contains(person)) {
            order.add(person);
        }
        
        // Visit all children in order
        if (children.containsKey(person)) {
            for (String child : children.get(person)) {
                dfs(child, order);
            }
        }
    }
}