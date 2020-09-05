
public class GenerateAllPrimes {
    public List<Integer> sieveOfEratosthenes(int n) { 
        // Create a boolean array "prime[0..n]" and initialize 
        // all entries it as true. A value in prime[i] will 
        // finally be false if i is Not a prime, else true. 
        boolean prime[] = new boolean[n + 1]; 
        for (int i = 0; i < n; i++) 
            prime[i] = true; 
          
        for (int p = 2; p * p <= n; p++) { 
            // If prime[p] is not changed, then it is a prime 
            if (prime[p]) { 
                // Update all multiples of p 
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false; 
                }
            } 
        } 
        
        List<Integer> output = new ArrayList<>();
        // Print all prime numbers 
        for (int i = 2; i <= n; i++) { 
            if (prime[i]) output.add(i); 
        } 
        return output;
    }
}