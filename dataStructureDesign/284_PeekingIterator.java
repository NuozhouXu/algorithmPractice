// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    private Iterator<Integer> iter;
    private Integer next = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    if (iterator.hasNext()) {
            next = iterator.next();
        }
        iter = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (next == null) {
            throw new RuntimeException();
        }
	    Integer nextVal = next;
        next = null;
        if (iter.hasNext()) {
            next = iter.next();
        }
        return nextVal;
	}
	
	@Override
	public boolean hasNext() {
	    return next != null;
	}
}