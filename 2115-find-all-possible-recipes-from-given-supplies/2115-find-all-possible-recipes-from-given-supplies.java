class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();  // Recipes and supplies are nodes in the graph. The ingredients list gives us the edges.
    Map<String, Integer> inDegree = new HashMap<>();  
    
        Set<String> recipesSet = new HashSet<>();   // Needed so that later, while processing nodes during the topological sort,  we only add recipes to the result.

        // Add supply nodes to the graph.
        for (String currSupply : supplies) {
            graph.put(currSupply, new ArrayList<>());
            inDegree.put(currSupply, 0);
        }
        
        // System.out.println(graph);

        // Add recipe nodes to the graph.
        for (String currRecipe : recipes) {
            graph.put(currRecipe, new ArrayList<>());
            inDegree.put(currRecipe, 0);

            recipesSet.add(currRecipe);
        }

        // System.out.println(graph);
        // Add edges to the graph.
        for (int i = 0; i < ingredients.size(); ++i) {
            for (String currIngredient : ingredients.get(i)) {
                graph.putIfAbsent(currIngredient, new ArrayList<>());   
                graph.get(currIngredient).add(recipes[i]); 
                inDegree.put(recipes[i], inDegree.get(recipes[i]) + 1);   
            }
        }

        // Standard topological sort
        List<String> result = new ArrayList<>();
        Deque<String> queue = new ArrayDeque<>();

        //System.out.println(graph);
        
        for (String currNode : inDegree.keySet()) {
            //System.out.println(currNode +"::"+inDegree.get(currNode));
            if (inDegree.get(currNode) == 0){
                queue.offer(currNode);  
            } 
        }


        while (!queue.isEmpty()) {
            String currNode = queue.poll();

            if (recipesSet.contains(currNode)) {
                result.add(currNode);   
            }
            
            for (String adjacentNode : graph.get(currNode)) {
                inDegree.put(adjacentNode, inDegree.get(adjacentNode) - 1);
                if (inDegree.get(adjacentNode) == 0){
                    queue.offer(adjacentNode);
                } 
            }
        }
        
        return result;
    }
}