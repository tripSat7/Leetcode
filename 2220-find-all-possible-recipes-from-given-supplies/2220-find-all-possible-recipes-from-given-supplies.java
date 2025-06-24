// Time Complexity: O(N + E)
//   N = number of nodes (recipes + supplies + unique ingredients)
//   E = number of edges (total number of ingredient-to-recipe dependencies)
//
// Space Complexity: O(N + E)

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>(); // Adjacency list: ingredient -> list of recipes dependent on it
        Map<String, Integer> inDegree = new HashMap<>(); // Tracks incoming dependencies for each node
        Set<String> recipesSet = new HashSet<>(); // For quick lookup to filter result

        // Initialize supplies as nodes with in-degree 0
        for (String supply : supplies) {
            graph.put(supply, new ArrayList<>());
            inDegree.put(supply, 0);
        }

        // Initialize recipe nodes (also in-degree 0 for now)
        for (String recipe : recipes) {
            graph.put(recipe, new ArrayList<>());
            inDegree.put(recipe, 0);
            recipesSet.add(recipe);
        }

        // Build the dependency graph: for each ingredient, add edge ingredient -> recipe
        for (int i = 0; i < ingredients.size(); ++i) {
            for (String ingredient : ingredients.get(i)) {
                graph.putIfAbsent(ingredient, new ArrayList<>());
                graph.get(ingredient).add(recipes[i]);  // ingredient is needed to make recipe
                inDegree.put(recipes[i], inDegree.get(recipes[i]) + 1); // recipe has one more dependency
            }
        }

        // Topological sort: start with nodes that have no dependencies (in-degree 0)
        List<String> result = new ArrayList<>();
        Deque<String> queue = new ArrayDeque<>();
        for (String node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) {
                queue.offer(node);
            }
        }

        // Process queue: for each available item, reduce dependencies of its neighbors
        while (!queue.isEmpty()) {
            String node = queue.poll();

            if (recipesSet.contains(node)) {
                result.add(node);      // Only recipes are part of the answer
            }
            for (String neighbor : graph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1); // Use up dependency
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor); // Ready to be made
                }
            }
        }
        return result;
    }
}
