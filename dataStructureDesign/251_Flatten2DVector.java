class Vector2D {

    int outer;
    int inner;
    int[][] v;
    
    public Vector2D(int[][] v) {
        this.outer = 0;
        this.inner = 0;
        this.v = v;
    }
    
    private void advanceToNext() {
        while (outer < v.length && inner == v[outer].length) {
            inner = 0;
            outer++;
        }
    }
    
    public int next() {
        if (!hasNext()) throw new RuntimeException();
        return (v[outer][inner++]);
    }
    
    public boolean hasNext() {
        advanceToNext();
        return outer < v.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */